package userlogin;
// 관리자 - 직원관리 화면
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;	// 이 패키지 내의 DefultTableModel 클래스 사용 
import java.util.Vector;
import java.util.*;
 
class EmpManage extends JFrame implements ActionListener, MouseListener { 
	 
	private JPanel grid, jpManage, jpEmp, jpEmpinfo, p1, p2, p3, p4, p5, p6, p7; 
	private LineBorder bb = new LineBorder(Color.gray, 2, true);
	private JLabel jlmc, jlic, jlid, jlpw, jlname, jlbirth, jltel, jlemail, jlemail_sign;
	// 직원 정보 패널의 타이틀 레이블
	private JLabel jlemp_join, jlemp_score, jlemp_salary, jlemp_period, jlemp_work;
	// 직원 정보 패널의 정보 출력하는 레이블
	private JLabel jlemp_joind, jlemp_scored, jlemp_salaryd, jlemp_periodd, jlemp_workd;
	private JTextField jtId, jtBirth, jtid, jtpw, jtname, jttel, jtbirth, jtemail_id;
	private JComboBox cbtel, cbemail;
	private JButton jbInquiry, jbInqCancel, jbEdit, jbCancel, jbAdd, jbDelete;
    private String telcode[] = { "010", "011", "017", "070", "02", "031", "032", "033", "041" }, 
			emcode[] = { "naver.com", "gmail.com", "nate.com", "daum.net", "korea.kr" };
    
    // 직원 관리 테이블
    Vector<String> columnName_emp;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_emp;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_emp = null;	
    DefaultTableModel model_emp = null;
    JScrollPane tableSP_emp; // 스크롤
    int row_emp;	// 테이블의 선택된 행
  
    
    EmpManage (String title) {	// 생성자 시작
    	
    	setTitle(title);
        
    	// (1) 직원 관리 패널 시작
        jpManage = new JPanel();
		jpManage.setBorder(bb);
		jpManage.setBorder(new TitledBorder(bb,"  [ 직원 관리 ]  "));
		jpManage.setLayout(new BorderLayout());
		JPanel top_emp = new JPanel();
		
		// 직원 관리 테이블 시작
		columnName_emp = new Vector<String>();
		columnName_emp.add("사번");	columnName_emp.add("비밀번호");	
		columnName_emp.add("이름");
		columnName_emp.add("연락처 코드");	columnName_emp.add("연락처");	
		columnName_emp.add("생년월일");	
		columnName_emp.add("이메일");	columnName_emp.add("이메일 코드");
		
		rowData_emp = new Vector<Vector<String>>();
		model_emp = new DefaultTableModel(rowData_emp, columnName_emp);
		table_emp = new JTable(model_emp);
		tableSP_emp = new JScrollPane(table_emp);
		
		// 직원 사번, 생년월일 입력
		jtId = new JTextField("사번", 10);
		jtBirth = new JTextField("생년월일", 10);
		// 조회 버튼
		jbInquiry = new JButton("조회");
		jbInqCancel= new JButton("초기화");	// 클릭 시 테이블 뜬거 지우기
		
		// 직원 관리 패널 레이아웃 설정
		top_emp.setLayout(new FlowLayout());
		top_emp.add(jtId);	top_emp.add(jtBirth);
		top_emp.add(jbInquiry);	top_emp.add(jbInqCancel);	

		// 직원 관리 패널에 각각 올리기
		jpManage.add(top_emp, BorderLayout.NORTH);
		jpManage.add(tableSP_emp, BorderLayout.CENTER);
	
		
        // (2) 직원 정보 수정 패널 시작
		// ** 첫 초기화면은 텍스트필드 모두 공백으로 되어 정보 추가 가능하게!
        // 직원 정보는 DB에서 갖고 온 후, 수정할 수 있게 하기
        jpEmp = new JPanel();
		jpEmp.setBorder(new TitledBorder(bb,"  [ 직원 정보 ]  "));

		// 직원 정보 패널 내 그리드패널
		grid = new JPanel();
		grid.setLayout(new GridLayout(7,0,0,20));
		
		// 직원 정보들
		jlid = new JLabel("ID (사번)     ");
		jtid = new JTextField(10);	
		jlpw = new JLabel("비밀번호    ");
		jtpw = new JTextField(10);
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
		jbAdd = new JButton("추가");
		jbDelete = new JButton("삭제");
		// 직원관리 페이지는 고객관리와 다르게 직원 추가가 가능함
		
		// 각 패널 만들기
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(jlid);	p1.add(jtid);	

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(jlpw);	p2.add(jtpw);
		
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(jlname);	p3.add(jtname);
								
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(jltel);	p4.add(cbtel);	p4.add(jttel);	
						
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(jlbirth);	p5.add(jtbirth);	
						
		p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(jlemail);	p6.add(jtemail_id);
		p6.add(jlemail_sign);	p6.add(cbemail);
						
		p7 = new JPanel(); 
		p7.setLayout(new FlowLayout(FlowLayout.CENTER));
		p7.add(jbEdit);	p7.add(jbCancel); p7.add(jbAdd); p7.add(jbDelete);
							
		// 그리드 패널에 올리기
		grid.add(p1); grid.add(p2); grid.add(p3); 
		grid.add(p4); grid.add(p5); grid.add(p6); grid.add(p7);
 
		// 직원 정보 패널에 올리기
		jpEmp.add(grid);
		
		
		// (3) 직원별 상세 정보 패널 시작
        // 직원 클릭하면 해당 직원 연봉 등 상세 정보 보여주기
        jpEmpinfo = new JPanel();
		jpEmpinfo.setBorder(new TitledBorder(bb,"  [ 직원 인사 정보 ]  "));
		
		// 직원 정보 패널 내 그리드패널 
		grid = new JPanel();
		grid.setLayout(new GridLayout(5,0,0,3));

		// 직원 정보 패널 타이틀 레이블
		jlemp_join = new JLabel("-  입사년도          :   ");
		jlemp_score = new JLabel("-  인사평가점수   :   ");
		jlemp_salary = new JLabel("-  연봉                  :   ");
		jlemp_period = new JLabel("-  계약기간          :   ");
		jlemp_work = new JLabel("-  근무년수          :   ");
		// 직원 정보 패널 내 정보 출력하는 레이블
		jlemp_joind = new JLabel();
		jlemp_scored = new JLabel();
		jlemp_salaryd = new JLabel();
		jlemp_periodd = new JLabel();
		jlemp_workd = new JLabel();
		
		// 직원 정보 패널 레이아웃 설정
		// 각 패널 만들기
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(jlemp_join);	p1.add(jlemp_joind);	

		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(jlemp_score);	p2.add(jlemp_scored);		
				
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(jlemp_salary);	p3.add(jlemp_salaryd);
			
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(jlemp_period);	p4.add(jlemp_periodd);
		
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(jlemp_work);	p5.add(jlemp_workd);
			
		// 그리드 패널에 올리기
		grid.add(p1); grid.add(p2); grid.add(p3); 
		grid.add(p4); grid.add(p5); 
		 
		// 직원 정보 패널에 올리기
		jpEmpinfo.add(grid);

        // (4) 이벤트 연결
		// jbInquiry.addActionListener(this);
		// jbInqCancel.addActionListener(this);
        jbEdit.addActionListener(this);
        jbCancel.addActionListener(this);
        jbAdd.addActionListener(this);
        jbDelete.addActionListener(this);
        table_emp.addMouseListener(this);
        
		// (5) 창 넣기 
        Container ct = getContentPane();
		ct.setLayout(null); 
		jpManage.setBounds(40,50,600,600);
		jpEmp.setBounds(650,50,400,410);
		jpEmpinfo.setBounds(650,470,400,180);
		ct.add(jpManage);	ct.add(jpEmp);	
		ct.add(jpEmpinfo);

    }
    
    // actionPerformed 메소드
    public void actionPerformed(ActionEvent ae) {
		
		String s = ae.getActionCommand(); // 버튼 String 갖고 옴
		String sid, spw, sname, scbtel, stel, sbirth, semail_id, scbemail;
		
		/* // 패스워드필드 안 쓰니 주석처리
		String spw = "";	// 비번 텍스트 갖고 올 변수 선언해두고 쓰기 
		
		
		// 비밀번호 PasswordField에서 갖고 오기
		char[] cpw = jpw.getPassword(); // jpw에서 비밀번호 갖고와 char[]에 저장
		// cpw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
	    for(char cha : cpw){         
	       Character.toString(cha);       // cha에 저장된 값 string으로 변환
	       //spw에 저장하기, spw에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
	       spw += (spw.equals("")) ? ""+cha+"" : ""+cha+"";   
	    } // 비밀번호는 table에 안 띄우고 DB에만 저장? 
	    */
		
	    // 직원 정보 입력값들 다 갖고 오기
		sid = jtid.getText();
		spw = jtpw.getText();
		sname = jtname.getText();
		scbtel = (String) cbtel.getSelectedItem();
		stel = jttel.getText();
		sbirth = jtbirth.getText();
		semail_id = jtemail_id.getText();
		scbemail = (String) cbemail.getSelectedItem();
		
		// 화면 입력값들을 벡터의 원소들로 추가
		Vector <String> txt_emp = new Vector <String>();
		txt_emp.add(sid);	txt_emp.add(spw);
		txt_emp.add(sname);
		txt_emp.add(scbtel);	txt_emp.add(stel);
		txt_emp.add(sbirth);
		txt_emp.add(semail_id);	txt_emp.add(scbemail);	

		// (1) 추가 버튼을 눌렀을 때
    	if (s.equals("추가")) { 
    		if (sid.equals("") || spw.equals("") || sname.equals("") || stel.equals("") || sbirth.equals("") || semail_id.equals("")) {
				// 공백 있으면 추가 못하게 예외처리하기!!
    			JOptionPane.showMessageDialog(this, "직원 정보를 모두 입력해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			rowData_emp.add(txt_emp);
    			JOptionPane.showMessageDialog(this, "직원 정보가 추가되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
    			clearUI();	// 입력값 텍스트필드에서 모두 지우기 
    		}
    	}
    	
    	// (2) 취소 버튼을 눌렀을 때
    	else if (s.equals("취소")) {
    		clearUI();	// 입력값 모두 클리어
			jtid.setEditable(true);	// 직원id(사번) 텍스트필드 활성화 (정보 추가할 때 써야하니)
    	}
		
    	// (3) 수정 버튼을 눌렀을 때
    	else if (s.equals("수정")) {
    		//** 테이블에서 열 클릭 안하면 수정 안된다는 알림창 띄우기
    		//** 테이블에서 열 클릭 하면 수정할 정보 오른쪽에 갖고 오기 

			if (spw.equals("") || sname.equals("") || stel.equals("") || sbirth.equals("") || semail_id.equals("")) {
				// 공백 있으면 수정 못하게 예외처리하기!!
				JOptionPane.showMessageDialog(this, "직원 정보를 모두 입력해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
			}
			else {	// row행의 기존 값을 삭제하고 새로 수정한 값을 row위치에 추가
				rowData_emp.remove(row_emp);	rowData_emp.add(row_emp, txt_emp);
				JOptionPane.showMessageDialog(this, "직원 정보 수정이 완료되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
				clearUI();	// 수정했던 정보 모두 클리어
				jtid.setEditable(true);	// 직원id(사번) 텍스트필드 활성화 (정보 추가할 때 써야하니)
			}
		}
    	// (4) 삭제 버튼을 눌렀을 때
    	else if (s.equals("삭제")) {
    		//** 테이블에서 열 클릭 안하면 삭제 안된다는 알림창 띄우기
    		
			JOptionPane.showMessageDialog(this, "해당 고객 정보가 삭제되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
    		rowData_emp.remove(row_emp);
			clearUI();	// 정보 텍스트필드에서 모두 클리어
			jtid.setEditable(true);	// 직원id(사번) 텍스트필드 활성화 (정보 추가할 때 써야하니)
		}
    	
    	table_emp.updateUI();	// ??이건 뭐?
    	/*
    	// (5) 조회 버튼을 눌렀을 때
    	else if (s.equals("조회")) {
    		table_emp.loadData(jtId.getText());
    		// DB 연동
    	}
    	// (6) 조회 버튼을 눌렀을 때
    	else if (s.equals("초기화")) {
    		// DB 연동
    	}*/
    	 
    	
    } // actionPerformed 메소드
    
    void clearUI() {	// 오른쪽 정보 텍스트 모두 클리어
    	jtid.setText("");	
		jtname.setText("");
		jtpw.setText("");
		jttel.setText("");
		jtbirth.setText("");
		jtemail_id.setText("");
		cbtel.setSelectedItem((Object) telcode[0]);
		cbemail.setSelectedItem((Object) emcode[0]);
    }
    
    // mouseClicked 메소드
    public void mouseClicked(MouseEvent ae) {
    	row_emp = table_emp.getSelectedRow();
    	// column = table.getSelectedColumn();	// 선택된 열번호 리턴 -> 굳이? 안해도
    	
    	// 직원 관리 패널에 테이블에서 선택된 정보 갖고 오기
    	jtid.setText((String)model_emp.getValueAt(row_emp, 0));
    	jtid.setEditable(false);	// 정보 갖고 올 때는 직원id(사번) 텍스트필드 비활성화 (수정 불가능)
    	jtpw.setText((String)model_emp.getValueAt(row_emp, 1));
    	jtname.setText((String)model_emp.getValueAt(row_emp, 2));
    	cbtel.setSelectedItem((String)model_emp.getValueAt(row_emp, 3)); // 콤보박스
    	jttel.setText((String)model_emp.getValueAt(row_emp, 4));
    	jtbirth.setText((String)model_emp.getValueAt(row_emp, 5));
    	jtemail_id.setText((String)model_emp.getValueAt(row_emp, 6));
    	cbemail.setSelectedItem((String)model_emp.getValueAt(row_emp, 7));
    	
    	// 직원 정보 패널에 테이블에서 선택된 사원 상세 정보 갖고 오기
    	// ** 실제로는 db에 있는 해당 직원의 정보 갖고 오게 바꾸기!
    	jlemp_joind.setText((String)model_emp.getValueAt(row_emp, 0));
    	jlemp_scored.setText((String)model_emp.getValueAt(row_emp, 1));
    	jlemp_salaryd.setText((String)model_emp.getValueAt(row_emp, 2));
    	jlemp_periodd.setText((String)model_emp.getValueAt(row_emp, 3));
    	jlemp_workd.setText((String)model_emp.getValueAt(row_emp, 4));
    		
   	}
    // MouseListener가 상속해주는 추상 메소드들을 모두 메소드 오버라이딩 해야 함
    public void mousePressed(MouseEvent ae) {}
    public void mouseReleased(MouseEvent ae) {}
    public void mouseEntered(MouseEvent ae) {}
    public void mouseExited(MouseEvent ae) {}
   
    	/*
    class MgeJDialog extends JDialog implements ActionListener {
    	
   		JButton dia_ok;
   		
   		MgeJDialog(JFrame parent, String title, boolean mode, String msg, int messageType) {
   			super(parent, title, mode, messageType); 
    			
   			JPanel p1 = new JPanel(); 
    		p1.setLayout(new GridLayout(3,0));

    		JLabel label1 = new JLabel(" ");
   			JLabel label2 = new JLabel(msg);
   			JLabel label3 = new JLabel(" ");
    			
   			label1.setHorizontalAlignment(JLabel.CENTER);
   			label2.setHorizontalAlignment(JLabel.CENTER);
    		label3.setHorizontalAlignment(JLabel.CENTER);
    			
    		p1.add(label1);	p1.add(label2);	p1.add(label3);
    		add(p1, BorderLayout.CENTER);
    			
   			JPanel p2 = new JPanel();
   			dia_ok = new JButton("OK");
   			dia_ok.addActionListener(this);
   			p2.add(dia_ok);
   			add(p2, BorderLayout.SOUTH);
    			
    		this.setBounds(420,235,500,230);	
    		}
   		
    		public void actionPerformed(ActionEvent ae) {
    			dispose(); // 다이얼로그 창 닫기.
    		}
    	}    	*/
	
	public static void main(String[] args) {
		
		EmpManage t = new EmpManage("관리자 - 직원 관리");
		
		t.setSize(1100, 1000);
		t.setLocation(350, 20);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setVisible(true);
	}

}
