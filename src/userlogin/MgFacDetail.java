package userlogin;
// 관리자 - 시설 예약 관리 - 예약 상세 조회 화면

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;	// 이 패키지 내의 DefultTableModel 클래스 사용 
import java.util.Vector;
import java.util.*;

public class MgFacDetail extends JFrame implements ActionListener {

	private JLabel jltitle, jldate, jldate_d, jlfacility, jlfacility_d, jltime, jlbreakfast, jldining, jlswim, jifitness;
	private JComboBox cbtime;
	private JButton jbInquiry, jbConfirm;
	private String breakfast_time[] = {"전체", "1타임: 오전 7~10시"};
	private String dining_time[] = {"전체", "1타임: 오후 5시", "2타임: 오후 7시", "3타임: 오후 9~11시"};
	private String swim_time[] = {"전체", "1타임: 오전 7~10시", "2타임: 오후 1~3시", "3타임: 오후 5~7시"};
	private String fitness_time[] = {"전체", "1타임: 오전 7~12시", "2타임: 오후 12~5시", "3타임: 오후 5~11시"};

    // 이용시설 예약 상세 테이블
    Vector<String> columnName_facd;	// 표의 각 컬럼 제목
    Vector<Vector<String>> rowData_facd;	// 표 안에 가변크기의 데이터 Vector 사용
    JTable table_facd = null;	
    DefaultTableModel model_facd = null;
    JScrollPane tableSP_facd; // 스크롤 
	
	MgFacDetail (String title) { // 생성자 시작
		
		setTitle(title); 
		
		jltitle = new JLabel("[ 시설 예약 상세 ]");
		jldate = new JLabel("날짜           :");
		
		// 이전 페이지에서 선택한 날짜 보이게 하기
		jldate_d = new JLabel("22/12/23");
		
		jlfacility = new JLabel("시설명        :");
		
		// 이전 페이지에서 선택한 이용시설 보이게 하기
		jlfacility_d = new JLabel("수영장");
		/*
		if (조식뷔페)
			jlfacility_d = new JLabel("조식뷔페")
		else if (다이닝)
			jlfacility_d = new JLabel("다이닝")
		else if (수영장)
			jlfacility_d = new JLabel("수영장")
		else if (피트니스/사우나)
			jlfacility_d = new JLabel("피트니스/사우나")
		*/
		
		
		jltime = new JLabel("이용타임    :");
		
		// 이전 페이지에서 선택한 이용시설의 타임 보이게 하기
		cbtime = new JComboBox(swim_time);
		/*
		if (조식뷔페)
			cbtime = new JComboBox(breakfast_time);
		else if (다이닝)
			cbtime = new JComboBox(dining_time);
		else if (수영장)
			cbtime = new JComboBox(swim_time);
		else if (피트니스/사우나)
			cbtime = new JComboBox(fitness_time);
		*/
		
		// 조회 버튼
		jbInquiry = new JButton("조회");

		// 객실 예약 상세 테이블 
		//** DB 연동해서 데이터 갖고 오기 
		//** 확정된 예약 목록만 보여주기!
		columnName_facd = new Vector<String>();
		columnName_facd.add("예약번호");	columnName_facd.add("예약자명");	
		columnName_facd.add("인원수");	columnName_facd.add("이용일");
		columnName_facd.add("이용타임");	columnName_facd.add("결제금액");	

		rowData_facd = new Vector<Vector<String>>();
		model_facd = new DefaultTableModel(rowData_facd, columnName_facd);
		table_facd = new JTable(model_facd);
		tableSP_facd = new JScrollPane(table_facd);
			    
	    
		// 창 넣기 
        Container ct = getContentPane();
		ct.setLayout(null); 
		
		jltitle.setBounds(30,30,150,20);
		jldate.setBounds(40,70,100,20);
		jldate_d.setBounds(140,70,100,20);
		jlfacility.setBounds(40,100,100,20);
		jlfacility_d.setBounds(140,100,200,20);
		jltime.setBounds(40,130,100,20);
		cbtime.setBounds(140,130,150,20);
		jbInquiry.setBounds(330,130,70,20);
		tableSP_facd.setBounds(40,180,510,300);
		
		ct.add(jltitle);
		ct.add(jldate);	ct.add(jldate_d);
		ct.add(jlfacility);	ct.add(jlfacility_d);
		ct.add(jltime);	ct.add(cbtime); ct.add(jbInquiry);
		ct.add(tableSP_facd);
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
		
		MgFacDetail mfd = new MgFacDetail("관리자 - 시설 예약 - 상세");
		
		mfd.setSize(600, 600);
		mfd.setLocation(350, 20);
		mfd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mfd.setVisible(true);
	}

}
