package userlogin;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class ex_03 extends JFrame{ //�� ���� ���� ȭ��

	//private JPanel wait; //�����Ȳ �г�
	//private JPanel calender; //�޷�Ʋ �г�
	
	private JLabel year, month; //�޷� ��,��
	private JButton next; //������ �̵�
	private JLabel div01, div02, div03, div04, div05, div06, div07, div08; //���м�
	private JLabel Sun, Mon, Tue, Wed, Thu, Fri, Sat; //����
	
	private JPanel day[]; //�޷³�¥ �г�
	private JPanel room[]; //���� �г�
	private JButton B_day[]; //��¥ ��ư
	private JLabel standard[]; //���Ĵٵ� 10�� ���� text
	private JLabel deluxe[]; //�𷰽� 8�� ���� text
	private JLabel suite[]; //����Ʈ 2�� ���� text
	private JLabel family[]; //�йи� 4�� ���� text
	//�� ��޺� ���� ���� ��
	private int s_now[];
	private int d_now[];
	private int t_now[];
	private int f_now[];

	
	
	public ex_03() { //������ ����
		
		Container ct=getContentPane(); //â ����
		ct.setLayout(null); 
		
		//�޷� Ʋ label
		year=new JLabel("2022");       
		month=new JLabel("12");    
		div01=new JLabel("/");
		
		next=new JButton("��");   
		
		div02=new JLabel("__________________________________________________________________________________________________________________________________");
		div03=new JLabel("__________________________________________________________________________________________________________________________________");
		div04=new JLabel("__________________________________________________________________________________________________________________________________");
		div05=new JLabel("__________________________________________________________________________________________________________________________________");
		div06=new JLabel("__________________________________________________________________________________________________________________________________");
		div07=new JLabel("__________________________________________________________________________________________________________________________________");
		div08=new JLabel("__________________________________________________________________________________________________________________________________");
			
		Sun=new JLabel("��");
		Mon=new JLabel("��");
		Tue=new JLabel("ȭ");
		Wed=new JLabel("��");
		Thu=new JLabel("��");
		Fri=new JLabel("��");
		Sat=new JLabel("��");
		//��
		
		
		//�޷� Ʋ ��ġ, ũ�� ����
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
		//��
		
		
		
		//31���̱� ������ 31���� ����.
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
		//���� ��
		
		
		//��¥ ��ư ����
		B_day[0]=new JButton("1��"); 
		B_day[1]=new JButton("2��"); 
		B_day[2]=new JButton("3��"); 
		B_day[3]=new JButton("4��"); 
		B_day[4]=new JButton("5��"); 
		B_day[5]=new JButton("6��"); 
		B_day[6]=new JButton("7��"); 
		B_day[7]=new JButton("8��"); 
		B_day[8]=new JButton("9��"); 
		B_day[9]=new JButton("10��"); 
		B_day[10]=new JButton("11��");
		B_day[11]=new JButton("12��");
		B_day[12]=new JButton("13��");
		B_day[13]=new JButton("14��");
		B_day[14]=new JButton("15��");
		B_day[15]=new JButton("16��");
		B_day[16]=new JButton("17��");
		B_day[17]=new JButton("18��");
		B_day[18]=new JButton("19��");
		B_day[19]=new JButton("20��");
		B_day[20]=new JButton("21��");
		B_day[21]=new JButton("22��");
		B_day[22]=new JButton("23��");
		B_day[23]=new JButton("24��");
		B_day[24]=new JButton("25��");
		B_day[25]=new JButton("26��");
		B_day[26]=new JButton("27��");
		B_day[27]=new JButton("28��");
		B_day[28]=new JButton("29��");
		B_day[29]=new JButton("30��");
		B_day[30]=new JButton("31��");
		//��
		
		
		for (int i=0; i<31; i++) {
			
			//���� ���Ǻ� ���� ��Ȳ
			s_now[i]=0; 
			d_now[i]=0;
			t_now[i]=0;
			f_now[i]=0;
			//��
			
			day[i]=new JPanel(); //day �г� ����
			room[i]=new JPanel(); //room �г� ����
			
			//�� ��޺� ������Ȳ ����ϴ� label
			standard[i]=new JLabel("���Ĵٵ�    "+s_now[i]+" / 10"); 
			deluxe[i]=new JLabel("�𷰽�          "+d_now[i]+" / 8");
			suite[i]=new JLabel("����Ʈ          "+t_now[i]+" / 2");
			family[i]=new JLabel("�йи�          "+f_now[i]+" / 4");
			//��
			
			day[i].setLayout(null);
			
			//B_day[i].setBounds(100, 120, 20, 40); 
			
			room[i].setLayout(new GridLayout(5,1,0,-10)); //�� ��¥�� �� Panel�� GridLayout���� ����	
			day[i].setLayout(new BorderLayout()); //�� ��¥�� Panel�� BorderLayout���� ����
			
			day[i].add(B_day[i], BorderLayout.NORTH); //��¥ Button�� ���ʿ�
			day[i].add(room[i], BorderLayout.CENTER); //�� ��޺� ���� ��Ȳ�� �߾ӿ�
			
			//�� Panel�� ��޺� Label �߰�
			room[i].add(standard[i]);
			room[i].add(deluxe[i]);
			room[i].add(suite[i]);
			room[i].add(family[i]);
			
		}
				
		//��¥ Panel ��ǥ ����
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
		//��
		
		
		for(int i=0; i<31; i++)
		ct.add(day[i]); //Panel�� â�� �߰�
	
		
	}
	
	public static void main(String[] args) {
		
		ex_03 win = new ex_03();
		
		win.setTitle("�� ���� ����");
		win.setSize(1100, 1000);
		win.setLocation(350, 20); 
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		}
	}
