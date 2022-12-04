package userlogin;
// 관리자 - 방 예약 관리 - 예약 상세 조회 화면

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;	// 이 패키지 내의 DefultTableModel 클래스 사용 
import java.util.Vector;
import java.util.*;

public class MgRoomDetail extends JFrame implements ActionListener {

	private JLabel jltitle, jldate, jldate_d, jlnum, jlroom;
	private JTextField jtnum;
	private JComboBox cbroom;
	private JButton jbInquiry;
	private String room[] = {"전체","스탠다드", "디럭스", "패밀리", "스위트", };
	
	// 객실 예약 상세 테이블
    Vector<String> columnName_roomd;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_roomd;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_roomd = null;	
    DefaultTableModel model_roomd = null;
    JScrollPane tableSP_roomd; // 스크롤 
    
	MgRoomDetail (String title) { // 생성자 시작
		
		setTitle(title); 
		
		jltitle = new JLabel("[ 객실 예약 상세 ]");
		jldate = new JLabel("날짜           :");
		// 이전 페이지에서 선택한 날짜 보이게 하기
		jldate_d = new JLabel("22/12/23");
		jlnum = new JLabel("예약번호    :");
		jtnum = new JTextField(10);
		jlroom = new JLabel("룸타입        :");
		cbroom = new JComboBox(room);
		
		// 조회 버튼
		jbInquiry = new JButton("조회");

		// 객실 예약 상세 테이블 
		//** DB 연동해서 데이터 갖고 오기 
		//** 확정된 예약 목록만 보여주기!
		columnName_roomd = new Vector<String>();
		columnName_roomd.add("예약번호");	columnName_roomd.add("예약자명");	
		columnName_roomd.add("인원수");		
		columnName_roomd.add("체크인");	columnName_roomd.add("체크아웃");	
		columnName_roomd.add("객실타입");	columnName_roomd.add("결제금액");	
		columnName_roomd.add("추가메세지");

		rowData_roomd = new Vector<Vector<String>>();
		model_roomd = new DefaultTableModel(rowData_roomd, columnName_roomd);
		table_roomd = new JTable(model_roomd);
		tableSP_roomd = new JScrollPane(table_roomd);
	    
	    
		// 창 넣기 
        Container ct = getContentPane();
		ct.setLayout(null); 
		
		jltitle.setBounds(30,30,150,20);
		jldate.setBounds(40,70,100,20);
		jldate_d.setBounds(140,70,100,20);
		jlnum.setBounds(40,100,100,20);
		jtnum.setBounds(140,100,100,20);
		jlroom.setBounds(40,130,100,20);
		cbroom.setBounds(140,130,100,20);
		jbInquiry.setBounds(290,130,70,20);
		tableSP_roomd.setBounds(40,180,510,300);
		
		ct.add(jltitle);
		ct.add(jldate);	ct.add(jldate_d);
		ct.add(jlnum);	ct.add(jtnum); 
		ct.add(jlroom);	ct.add(cbroom);	ct.add(jbInquiry);
		ct.add(tableSP_roomd);	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String s = ae.getActionCommand(); // 버튼 String 갖고 옴
		
		/*
		if (s.equals("조회")) 
		{
		
		}
		*/
	}
	
	public static void main(String[] args) {
		
		MgRoomDetail mrd = new MgRoomDetail("관리자 - 방 예약 - 상세");
		
		mrd.setSize(600, 600);
		mrd.setLocation(350, 20);
		mrd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mrd.setVisible(true);
	}

}
