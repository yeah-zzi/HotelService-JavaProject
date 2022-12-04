package userlogin;
// 관리자 - 고객관리 화면

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;	// 이 패키지 내의 DefultTableModel 클래스 사용 
import javax.swing.table.TableColumn; // 테이블 열 너비 조절을 위해 include
import java.util.Vector;
import java.util.*;
 
class CliManage extends JFrame implements ActionListener, MouseListener {
	
	private JPanel grid, jpManage, jpClient, jpUse, p1, p2, p3, p4, p5, p6; 
	private LineBorder bb = new LineBorder(Color.gray, 2, true);
	private JLabel jpUse_blank, jlmc, jlic, jlid, jlname, jlbirth, jltel, jlemail, jlemail_sign;
	private JTextField jtName, jtBirth, jtid, jtname, jttel, jtbirth, jtemail_id;
	private JComboBox cbtel, cbemail;
	private JButton jbInquiry, jbInqCancel, jbEdit, jbCancel, jbDelete;
    private String telcode[] = { "010", "011", "017", "070", "02", "031", "032", "033", "041" }, 
			emcode[] = { "naver.com", "gmail.com", "nate.com", "daum.net", "korea.kr" };
     
    // 고객 관리 테이블
    Vector<String> columnName_cli;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_cli;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_cli = null;	
    DefaultTableModel model_cli = null;
    JScrollPane tableSP_cli; // 스크롤
    int row_cli;	// 테이블의 선택된 행
    
    // 고객 이용내역 테이블
    Vector<String> columnName_use;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_use;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_use = null;	
    DefaultTableModel model_use = null;
    JScrollPane tableSP_use; // 스크롤 
    
    CliManage (String title) {	// 생성자 시작
    	
    	setTitle(title);
        
    	// (1) 고객 관리 패널 시작
        jpManage = new JPanel();
		jpManage.setBorder(bb);
		jpManage.setBorder(new TitledBorder(bb,"  [ 고객 관리 ]  "));
		jpManage.setLayout(new BorderLayout());
		JPanel top_cli = new JPanel();
		
		// 고객 관리 테이블 시작
		columnName_cli = new Vector<String>();
		columnName_cli.add("아이디");	columnName_cli.add("이름");	
		columnName_cli.add("연락처 코드");	columnName_cli.add("연락처");	
		columnName_cli.add("생년월일");	
		columnName_cli.add("이메일");	columnName_cli.add("이메일 코드");
		
		rowData_cli = new Vector<Vector<String>>();
		model_cli = new DefaultTableModel(rowData_cli, columnName_cli);
		table_cli = new JTable(model_cli);
		tableSP_cli = new JScrollPane(table_cli);
		
		// 고객 이름, 생년월일 입력
		jtName = new JTextField("이름", 10);
		jtBirth = new JTextField("생년월일", 10);
		// 조회 버튼
		jbInquiry = new JButton("조회");
		jbInqCancel= new JButton("초기화");	// 클릭 시 테이블 뜬거 지우기

		// 고객 관리 패널 레이아웃 설정
		top_cli.setLayout(new FlowLayout());
		top_cli.add(jtName);	top_cli.add(jtBirth);
		top_cli.add(jbInquiry);	top_cli.add(jbInqCancel);	

		// 고객 관리 패널에 각각 올리기
		jpManage.add(top_cli, BorderLayout.NORTH);
		jpManage.add(tableSP_cli, BorderLayout.CENTER);
	
		
        // (2) 고객 정보 수정 패널 시작
		// ** 첫 초기화면은 텍스트필드 모두 공백으로 되어 정보 추가 가능하게!
        // 직원 정보는 DB에서 갖고 온 후, 수정할 수 있게 하기
        jpClient = new JPanel();
		jpClient.setBorder(new TitledBorder(bb,"  [ 고객 정보 ]  "));

		// 직원 정보 패널 내 그리드패널
		grid = new JPanel();
		grid.setLayout(new GridLayout(6,0,0,20));
		
		// 직원 정보들
		jlid = new JLabel("ID               ");
		jtid = new JTextField(10);	
		jlname = new JLabel("이름           ");
		jtname = new JTextField(10);
		jltel = new JLabel("연락처       ");
		cbtel = new JComboBox(telcode);
		jttel = new JTextField(12);
		jlbirth = new JLabel("생년월일   ");
		jtbirth = new JTextField(10);
		jlemail = new JLabel("이메일      ");
		jtemail_id = new JTextField(10);
		jlemail_sign = new JLabel("@");
		cbemail = new JComboBox(emcode);
		
		// 직원 정보 수정, 취소, 추가, 삭제 버튼
		jbEdit = new JButton("수정");
		jbCancel = new JButton("취소");
		jbDelete = new JButton("삭제");
		
		// 각 패널 만들기
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(jlid);	p1.add(jtid);	

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(jlname);	p2.add(jtname);
								
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(jltel);	p3.add(cbtel);	p3.add(jttel);	
						
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(jlbirth);	p4.add(jtbirth);	
						
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(jlemail);	p5.add(jtemail_id);
		p5.add(jlemail_sign);	p5.add(cbemail);
						
		p6 = new JPanel(); 
		p6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p6.add(jbEdit);	p6.add(jbCancel); p6.add(jbDelete);
							
		// 그리드 패널에 올리기
		grid.add(p1); grid.add(p2); grid.add(p3); 
		grid.add(p4); grid.add(p5); grid.add(p6);
 
		// 직원 정보 패널에 올리기
		jpClient.add(grid);
		
		
		// (3) 고객별 호텔 이용 정보 패널 시작
        // 고객 클릭하면 이용 정보 보여주기
        jpUse = new JPanel();
		jpUse.setBorder(new TitledBorder(bb,"  [ 고객 호텔 이용 내역 ]  "));
		jpUse.setLayout(new BorderLayout());
		
		JPanel top_use = new JPanel(); 	// 테이블 위 공백 패널
		jpUse_blank = new JLabel(" ");
		top_use.add(jpUse_blank);

		// 고객 이용내역 테이블 
		columnName_use = new Vector<String>();
		columnName_use.add("예약자명");	columnName_use.add("이용일");		
		columnName_use.add("객실타입"); columnName_use.add("결제금액");
		
		rowData_use = new Vector<Vector<String>>();
		model_use = new DefaultTableModel(rowData_use, columnName_use);
		table_use = new JTable(model_use);
		tableSP_use = new JScrollPane(table_use);
		
		// 내 예약 목록 패널에 각각 올리기
		jpUse.add(top_use, BorderLayout.NORTH);
		jpUse.add(tableSP_use, BorderLayout.CENTER);

		
        // (4) 이벤트 연결
		// jbInquiry.addActionListener(this);
		// jbInqCancel.addActionListener(this);
        jbEdit.addActionListener(this);
        jbCancel.addActionListener(this);
        jbDelete.addActionListener(this);
        table_cli.addMouseListener(this);
        
		// (5) 창 넣기 
        Container ct = getContentPane();
		ct.setLayout(null); 
		jpManage.setBounds(40,50,600,600);
		jpClient.setBounds(650,50,400,360);
		jpUse.setBounds(650,420,400,230);
		ct.add(jpManage);	ct.add(jpClient);	
		ct.add(jpUse);

    }
    
    // actionPerformed 메소드
    public void actionPerformed(ActionEvent ae) {
		
		String s = ae.getActionCommand(); // 버튼 String 갖고 옴
		String sid, sname, scbtel, stel, sbirth, semail_id, scbemail;		
	
	    // 직원 정보 입력값들 다 갖고 오기
		sid = jtid.getText();
		sname = jtname.getText();
		scbtel = (String) cbtel.getSelectedItem();
		stel = jttel.getText();
		sbirth = jtbirth.getText();
		semail_id = jtemail_id.getText();
		scbemail = (String) cbemail.getSelectedItem();
		
		// 화면 입력값들을 벡터의 원소들로 추가
		Vector <String> txt_cli = new Vector <String>();
		txt_cli.add(sid);	
		txt_cli.add(sname);
		txt_cli.add(scbtel);	txt_cli.add(stel);
		txt_cli.add(sbirth);
		txt_cli.add(semail_id);	txt_cli.add(scbemail);	    	
    	
    	
    	// (1) 취소 버튼을 눌렀을 때
    	if (s.equals("취소")) { 
    		if (sid.equals("") || sname.equals("") || stel.equals("") || sbirth.equals("") || semail_id.equals("")) {
				// 공백 있으면 추가 못하게 예외처리하기!!
    			JOptionPane.showMessageDialog(this, "직원 정보를 모두 입력해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			rowData_cli.add(txt_cli);
    			JOptionPane.showMessageDialog(this, "직원 정보가 추가되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
    			clearUI();	// 입력값 텍스트필드에서 모두 지우기 
    		}
    	}
    	
    	// (2) 수정 버튼을 눌렀을 때
    	else if (s.equals("수정")) {
    		//** 테이블에서 열 클릭 안하면 수정 안된다는 알림창 띄우기
    		//** 테이블에서 열 클릭 하면 수정할 정보 오른쪽에 갖고 오기 

			if (sname.equals("") || stel.equals("") || sbirth.equals("") || semail_id.equals("")) {
				// 공백 있으면 수정 못하게 예외처리하기!!
				JOptionPane.showMessageDialog(this, "고객 정보를 모두 입력해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
			}
			else {	// row행의 기존 값을 삭제하고 새로 수정한 값을 row위치에 추가
				rowData_cli.remove(row_cli);	rowData_cli.add(row_cli, txt_cli);
				JOptionPane.showMessageDialog(this, "고객 정보 수정이 완료되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
				clearUI();	// 수정했던 정보 모두 클리어
				jtid.setEditable(true);	// 직원id(사번) 텍스트필드 활성화 (정보 추가할 때 써야하니)
			}
		}
    	// (3) 삭제 버튼을 눌렀을 때
    	else if (s.equals("삭제")) {
    		//** 테이블에서 열 클릭 안하면 삭제 안된다는 알림창 띄우기
    		
			JOptionPane.showMessageDialog(this, "해당 고객 정보가 삭제되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
    		rowData_cli.remove(row_cli);
			clearUI();	// 정보 텍스트필드에서 모두 클리어
			jtid.setEditable(true);	// 직원id(사번) 텍스트필드 활성화 (정보 추가할 때 써야하니)
		}
    	
    	table_cli.updateUI();	// ??이건 뭐?
    	/*
    	// (4) 조회 버튼을 눌렀을 때
    	else if (s.equals("조회")) {
    		table_emp.loadData(jtId.getText());
    		// DB 연동
    	}
    	// (5) 조회 버튼을 눌렀을 때
    	else if (s.equals("초기화")) {
    		// DB 연동
    	}*/
    	 
    	
    } // actionPerformed 메소드
    
    void clearUI() {	// 오른쪽 정보 텍스트 모두 클리어
    	jtid.setText("");	
		jtname.setText("");
		jttel.setText("");
		jtbirth.setText("");
		jtemail_id.setText("");
		cbtel.setSelectedItem((Object) telcode[0]);
		cbemail.setSelectedItem((Object) emcode[0]);
    }
    
    // mouseClicked 메소드
    public void mouseClicked(MouseEvent ae) {
    	row_cli = table_cli.getSelectedRow();
    	// column = table.getSelectedColumn();	// 선택된 열번호 리턴 -> 굳이? 안해도
    	
    	// 직원 관리 패널에 테이블에서 선택된 정보 갖고 오기
    	jtid.setText((String)model_cli.getValueAt(row_cli, 0));
    	jtid.setEditable(false);	// 정보 갖고 올 때는 직원id(사번) 텍스트필드 비활성화 (수정 불가능)
    	jtname.setText((String)model_cli.getValueAt(row_cli, 2));
    	cbtel.setSelectedItem((String)model_cli.getValueAt(row_cli, 3)); // 콤보박스
    	jttel.setText((String)model_cli.getValueAt(row_cli, 4));
    	jtbirth.setText((String)model_cli.getValueAt(row_cli, 5));
    	jtemail_id.setText((String)model_cli.getValueAt(row_cli, 6));
    	cbemail.setSelectedItem((String)model_cli.getValueAt(row_cli, 7));
    	
    	// 고개 정보 패널에 테이블에서 선택된 고객이용내역 테이블 갖고 오기
    	// ** 실제로는 db에 있는 해당 고객의 정보 갖고 오게 바꾸기! 
    	// 클릭한 테이블 행의 정보들을 벡터의 원소들로 추가
    	Vector <String> txt_use = new Vector <String>();
    	txt_use.add((String)model_cli.getValueAt(row_cli, 0));	
   		txt_use.add((String)model_cli.getValueAt(row_cli, 1));
  		txt_use.add((String)model_cli.getValueAt(row_cli, 2));	
  		txt_use.add((String)model_cli.getValueAt(row_cli, 3));
		rowData_use.add(txt_use);	// 고객이용내역 테이블의 데이터로 추가

   	}
    // MouseListener가 상속해주는 추상 메소드들을 모두 메소드 오버라이딩 해야 함
    public void mousePressed(MouseEvent ae) {}
    public void mouseReleased(MouseEvent ae) {}
    public void mouseEntered(MouseEvent ae) {}
    public void mouseExited(MouseEvent ae) {}

	
	public static void main(String[] args) {
		
		CliManage c = new CliManage("관리자 - 고객 관리");
		
		c.setSize(1100, 1000);
		c.setLocation(350, 20);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
	}

}
