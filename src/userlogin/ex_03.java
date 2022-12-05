package userlogin;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class ex_03 extends JFrame{ //방 예약 관리 화면

	//private JPanel wait; //대기현황 패널
	//private JPanel calender; //달력틀 패널
	
	private JLabel year, month; //달력 년,월
	private JButton next; //다음달 이동
	private JLabel div01, div02, div03, div04, div05, div06, div07, div08; //구분선
	private JLabel Sun, Mon, Tue, Wed, Thu, Fri, Sat; //요일
	
	private JPanel day[]; //달력날짜 패널
	private JPanel room[]; //룸등급 패널
	private JButton B_day[]; //날짜 버튼
	private JLabel standard[]; //스탠다드 10건 제한 text
	private JLabel deluxe[]; //디럭스 8건 제한 text
	private JLabel suite[]; //스위트 2건 제한 text
	private JLabel family[]; //패밀리 4건 제한 text
	//방 등급별 현재 예약 수
	private int s_now[];
	private int d_now[];
	private int t_now[];
	private int f_now[];

	
	
	public ex_03() { //생성자 시작
		
		Container ct=getContentPane(); //창 생성
		ct.setLayout(null); 
		
		//달력 틀 label
		year=new JLabel("2022");       
		month=new JLabel("12");    
		div01=new JLabel("/");
		
		next=new JButton("▶");   
		
		div02=new JLabel("__________________________________________________________________________________________________________________________________");
		div03=new JLabel("__________________________________________________________________________________________________________________________________");
		div04=new JLabel("__________________________________________________________________________________________________________________________________");
		div05=new JLabel("__________________________________________________________________________________________________________________________________");
		div06=new JLabel("__________________________________________________________________________________________________________________________________");
		div07=new JLabel("__________________________________________________________________________________________________________________________________");
		div08=new JLabel("__________________________________________________________________________________________________________________________________");
			
		Sun=new JLabel("일");
		Mon=new JLabel("월");
		Tue=new JLabel("화");
		Wed=new JLabel("수");
		Thu=new JLabel("목");
		Fri=new JLabel("금");
		Sat=new JLabel("토");
		//끝
		
		
		//달력 틀 위치, 크기 설정
		year.setBounds(110,253,70,30); 
		month.setBounds(165,253,70,30); 
		div01.setBounds(150,253,70,30);
		ct.add(year); ct.add(month); ct.add(div01);
		
		next.setBounds(200,253,50,25);
		ct.add(next);
		
		div02.setBounds(90,280,1000,30);
		div03.setBounds(90,320,1000,30);
		div04.setBounds(90,430,1000,30);
		div05.setBounds(90,540,1000,30);
		div06.setBounds(90,650,1000,30);
		div07.setBounds(90,760,1000,30);
		div08.setBounds(90,870,1000,30);
		ct.add(div02);   ct.add(div03);   ct.add(div04);   ct.add(div05);   ct.add(div06);   ct.add(div07);  ct.add(div08);
		
		Sun.setBounds(140,305,1000,30);
		Mon.setBounds(270,305,1000,30);
		Tue.setBounds(400,305,1000,30);
		Wed.setBounds(530,305,1000,30);
		Thu.setBounds(660,305,1000,30);
		Fri.setBounds(790,305,1000,30);
		Sat.setBounds(920,305,1000,30);
		ct.add(Sun);  ct.add(Mon);  ct.add(Tue);  ct.add(Wed);  ct.add(Thu);  ct.add(Fri);  ct.add(Sat);
		//끝
		
		
		
		//31일이기 때문에 31개씩 생성.
		day=new JPanel[31]; 
		room=new JPanel[31];
		
		B_day=new JButton[31];
		
		standard=new JLabel[31];
		deluxe=new JLabel[31];
		suite=new JLabel[31];
		family=new JLabel[31];
		
		s_now=new int[31];
		d_now=new int[31];
		t_now=new int[31];
		f_now=new int[31];
		//생성 끝
		
		
		//날짜 버튼 생성
		B_day[0]=new JButton("1일"); 
		B_day[1]=new JButton("2일"); 
		B_day[2]=new JButton("3일"); 
		B_day[3]=new JButton("4일"); 
		B_day[4]=new JButton("5일"); 
		B_day[5]=new JButton("6일"); 
		B_day[6]=new JButton("7일"); 
		B_day[7]=new JButton("8일"); 
		B_day[8]=new JButton("9일"); 
		B_day[9]=new JButton("10일"); 
		B_day[10]=new JButton("11일");
		B_day[11]=new JButton("12일");
		B_day[12]=new JButton("13일");
		B_day[13]=new JButton("14일");
		B_day[14]=new JButton("15일");
		B_day[15]=new JButton("16일");
		B_day[16]=new JButton("17일");
		B_day[17]=new JButton("18일");
		B_day[18]=new JButton("19일");
		B_day[19]=new JButton("20일");
		B_day[20]=new JButton("21일");
		B_day[21]=new JButton("22일");
		B_day[22]=new JButton("23일");
		B_day[23]=new JButton("24일");
		B_day[24]=new JButton("25일");
		B_day[25]=new JButton("26일");
		B_day[26]=new JButton("27일");
		B_day[27]=new JButton("28일");
		B_day[28]=new JButton("29일");
		B_day[29]=new JButton("30일");
		B_day[30]=new JButton("31일");
		//끝
		
		
		for (int i=0; i<31; i++) {
			
			//현재 객실별 예약 현황
			s_now[i]=0; 
			d_now[i]=0;
			t_now[i]=0;
			f_now[i]=0;
			//끝
			
			day[i]=new JPanel(); //day 패널 생성
			room[i]=new JPanel(); //room 패널 생성
			
			//방 등급별 예약현황 출력하는 label
			standard[i]=new JLabel("스탠다드    "+s_now[i]+" / 10"); 
			deluxe[i]=new JLabel("디럭스          "+d_now[i]+" / 8");
			suite[i]=new JLabel("스위트          "+t_now[i]+" / 2");
			family[i]=new JLabel("패밀리          "+f_now[i]+" / 4");
			//끝
			
			day[i].setLayout(null);
			
			//B_day[i].setBounds(100, 120, 20, 40); 
			
			room[i].setLayout(new GridLayout(5,1,0,-10)); //각 날짜별 방 Panel을 GridLayout으로 지정	
			day[i].setLayout(new BorderLayout()); //각 날짜별 Panel을 BorderLayout으로 지정
			
			day[i].add(B_day[i], BorderLayout.NORTH); //날짜 Button을 북쪽에
			day[i].add(room[i], BorderLayout.CENTER); //방 등급별 예약 현황을 중앙에
			
			//룸 Panel에 등급별 Label 추가
			room[i].add(standard[i]);
			room[i].add(deluxe[i]);
			room[i].add(suite[i]);
			room[i].add(family[i]);
			
		}
				
		//날짜 Panel 좌표 지정
		day[0].setBounds(615, 350, 100, 110);
		day[1].setBounds(745, 350, 100, 110);
		day[2].setBounds(875, 350, 100, 110);
		
		day[3].setBounds(95, 460, 100, 110);
		day[4].setBounds(225, 460, 100, 110);
		day[5].setBounds(355, 460, 100, 110);
		day[6].setBounds(485, 460, 100, 110);
		day[7].setBounds(615, 460, 100, 110);
		day[8].setBounds(745, 460, 100, 110);
		day[9].setBounds(875, 460, 100, 110);
		
		day[10].setBounds(95, 570, 100, 110);
		day[11].setBounds(225, 570, 100, 110);
		day[12].setBounds(355, 570, 100, 110);
		day[13].setBounds(485, 570, 100, 110);
		day[14].setBounds(615, 570, 100, 110);
		day[15].setBounds(745, 570, 100, 110);
		day[16].setBounds(875, 570, 100, 110);
		
		day[17].setBounds(95, 680, 100, 110);
		day[18].setBounds(225, 680, 100, 110);
		day[19].setBounds(355, 680, 100, 110);
		day[20].setBounds(485, 680, 100, 110);
		day[21].setBounds(615, 680, 100, 110);
		day[22].setBounds(745, 680, 100, 110);
		day[23].setBounds(875, 680, 100, 110);
	
		day[24].setBounds(95, 790, 100, 110);
		day[25].setBounds(225, 790, 100, 110);
		day[26].setBounds(355, 790, 100, 110);
		day[27].setBounds(485, 790, 100, 110);
		day[28].setBounds(615, 790, 100, 110);
		day[29].setBounds(745, 790, 100, 110);
		day[30].setBounds(875, 790, 100, 110);
		//끝
		
		
		for(int i=0; i<31; i++)
		ct.add(day[i]); //Panel을 창에 추가
	
		
	}
	
	public static void main(String[] args) {
		
		ex_03 win = new ex_03();
		
		win.setTitle("방 예약 관리");
		win.setSize(1100, 1000);
		win.setLocation(350, 20); 
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		}
	}
