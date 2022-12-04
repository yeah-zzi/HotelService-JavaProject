package userlogin;
// 사용자 - 마이페이지

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.*;	// 이 패키지 내의 DefultTableModel 클래스 사용 
import java.util.Vector;
import java.util.*;

public class MyPage extends JFrame implements ActionListener {

	private JPanel jpMyinfo, jpReserve, grid, p1, p2, p3, p4, p5, p6, p7, p8, p9;
	private LineBorder bb = new LineBorder(Color.gray, 2, true);
	private JLabel jpReserve_blank, jlid, jlpw, jlname, jlbirth, jltel, jlemail, jlemail_sign, jlpwhint, jlpwanswer;
	private JTextField jtName, jtBirth, jtid, jtname, jttel_num1, jttel_num2, jtbirth, jtemail_id, jtpwanswer;
	private JPasswordField jpw;
	private JButton jbEdit, jbCancel;
	private JComboBox cbtel, cbemail, cbpwhint;
	private JTable table;
	private String telcode[] = { "010", "011", "017", "070", "02", "031", "032", "033", "041" }, 
			emcode[] = { "naver.com", "gmail.com", "nate.com", "daum.net", "korea.kr" }, 
			pwhint[] = {"내가 가장 존경하는 인물은?", "나의 초등학교는?", "나만의 보물 1호는?"} ;
    
    // 예약 목록 테이블
    Vector<String> columnName_resv;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_resv;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_resv = null;	
    DefaultTableModel model_resv = null;
    JScrollPane tableSP_resv; // 스크롤
	
	MyPage (String title) {	// 생성자 시작
		
		setTitle(title);
		
		// (1) 내 예약 목록 패널 시작
        jpReserve = new JPanel();
		jpReserve.setBorder(bb);
		jpReserve.setBorder(new TitledBorder(bb,"  [ 내 예약 목록 ]  "));
		jpReserve.setLayout(new BorderLayout());

		JPanel top_resv = new JPanel();	// 테이블 위 공백 패널
		jpReserve_blank = new JLabel(" ");
		top_resv.add(jpReserve_blank);
		
		// 예약목록 테이블 시작
		columnName_resv = new Vector<String>();
		columnName_resv.add("예약번호");	columnName_resv.add("예약자명");	
		columnName_resv.add("체크인");	columnName_resv.add("체크아웃");	
		columnName_resv.add("객실타입");	columnName_resv.add("결제금액");	
		columnName_resv.add("상태");	
		
		rowData_resv = new Vector<Vector<String>>();
		model_resv = new DefaultTableModel(rowData_resv, columnName_resv);
		table_resv = new JTable(model_resv);
		tableSP_resv = new JScrollPane(table_resv);
		
		//*** DB 연동해서 테이블 데이터 불러오기!!
		
		
		// 내 예약 목록 패널에 각각 올리기
		jpReserve.add(top_resv, BorderLayout.NORTH);
        jpReserve.add(tableSP_resv, BorderLayout.CENTER);
 
	    
		// (2) 내 정보 수정 패널 시작
        // 내 정보는 DB에서 갖고 온 후, 수정할 수 있게 하기
        jpMyinfo = new JPanel();
		jpMyinfo.setBorder(new TitledBorder(bb,"  [ 내 정보 ]  "));
		
		// 내정보 패널 내 그리드패널
		grid = new JPanel();
		grid.setLayout(new GridLayout(9,0,0,20));
		
		jlid = new JLabel("ID                ");	
		jtid = new JTextField("jisu2", 10);	
		jtid.setEditable(false);	// id 텍스트필드 비활성화 (수정 불가능)
		jlpw = new JLabel("비밀번호     ");	
		jpw = new JPasswordField("12345678", 10);	
		jlname = new JLabel("이름            ");
		jtname = new JTextField("김지수", 10);
		jltel = new JLabel("연락처        ");
		cbtel = new JComboBox(telcode);
		jttel_num1 = new JTextField("1234", 8);
		jttel_num2 = new JTextField("5678", 8);
		jlbirth = new JLabel("생년월일     ");
		jtbirth = new JTextField("010102", 10);
		jlemail = new JLabel("이메일        ");
		jtemail_id = new JTextField("jisu", 10);
		jlemail_sign = new JLabel("@");
		cbemail = new JComboBox(emcode);
		jlpwhint = new JLabel("PW힌트       ");
		cbpwhint = new JComboBox(pwhint);
		jlpwanswer = new JLabel("PW힌트정답 "); 
		jtpwanswer = new JTextField("김지수선생님", 15);
		
		jbEdit = new JButton("수정");
		jbCancel = new JButton("취소");
		
		// 각 패널 만들기
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.add(jlid);	p1.add(jtid);	
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p2.add(jlpw);	p2.add(jpw);	
			
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(jlname);	p3.add(jtname);
				
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p4.add(jltel);	p4.add(cbtel);	p4.add(jttel_num1);	p4.add(jttel_num2);	
				
		p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p5.add(jlbirth);	p5.add(jtbirth);	
		
		p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		p6.add(jlemail);	p6.add(jtemail_id);
		p6.add(jlemail_sign);	p6.add(cbemail);
		
		p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		p7.add(jlpwhint);	p7.add(cbpwhint);	
		
		p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.LEFT));
		p8.add(jlpwanswer);	p8.add(jtpwanswer);	
		
		p9 = new JPanel();
		p9.setLayout(new FlowLayout(FlowLayout.CENTER));
		p9.add(jbEdit);	p9.add(jbCancel);
				
		// 그리드 패널에 올리기
		grid.add(p1); grid.add(p2); grid.add(p3); grid.add(p4);	
		grid.add(p5); grid.add(p6); grid.add(p7); grid.add(p8); grid.add(p9);

		// 마이페이지 패널에 올리기
		jpMyinfo.add(grid);

		// 이벤트 연결
		jpw.addActionListener(this);
		jtname.addActionListener(this);
		jttel_num1.addActionListener(this);
		jttel_num2.addActionListener(this);
		jtbirth.addActionListener(this);
		jtemail_id.addActionListener(this);
		jtpwanswer.addActionListener(this);
		
		jbEdit.addActionListener(this);
		jbCancel.addActionListener(this);
		
		// (4) 창 넣기 
        Container ct = getContentPane();
		ct.setLayout(null); 
		jpReserve.setBounds(40,50,600,550);
		jpMyinfo.setBounds(650,50,400,550);
		ct.add(jpMyinfo);	ct.add(jpReserve);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String s = ae.getActionCommand(); // 버튼 String 갖고 옴
		
		String sname, stel_num1, stel_num2, sbirth, semail_id, spwanswer; // 텍스트필드 입력값 갖고 올 문자열 변수 선언
		String spw = "";
		char[] cpw = jpw.getPassword(); // jpw에서 비밀번호 갖고와 char[]에 저장
		
		// cpw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
	     for(char cha : cpw){         
	         Character.toString(cha);       // cha에 저장된 값 string으로 변환
	       // spw에 저장하기, spw에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
	         spw += (spw.equals("")) ? ""+cha+"" : ""+cha+"";   
	     }
		
		sname = jtname.getText();	// 텍스트필드 입력값 다 갖고 오기
		stel_num1 = jttel_num1.getText();
		stel_num2 = jttel_num2.getText();
		sbirth = jtbirth.getText();
		semail_id = jtemail_id.getText();
		spwanswer = jtpwanswer.getText();
		
		if (s.equals("수정")) {	// 수정 버튼 누를시
			if (spw.equals("") || sname.equals("") || stel_num1.equals("") || stel_num2.equals("") || sbirth.equals("") || semail_id.equals("") || spwanswer.equals("")) {
				// 공백 있으면 수정 못하게 예외처리하기!!
				JOptionPane.showMessageDialog(this, "정보를 모두 입력해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "내 정보 수정이 완료되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {	// 취소 버튼 누를시
			// 텍스트 모두 초기화 (id 제외)
			jpw.setText("");
			jtname.setText("");
			jttel_num1.setText("");
			jttel_num2.setText("");
			jtbirth.setText("");
			jtemail_id.setText("");
			jtpwanswer.setText("");
			cbpwhint.setSelectedItem((Object) pwhint[0]);
			cbtel.setSelectedItem((Object) telcode[0]);
			cbemail.setSelectedItem((Object) emcode[0]);
		}
	}

	
	public static void main(String[] args) {

		MyPage mp = new MyPage("사용자 - MyPage");
		
		mp.setSize(1100, 1000);
		mp.setLocation(350, 20);
		mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mp.setVisible(true);
	}

}
