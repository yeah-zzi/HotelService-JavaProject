package userlogin;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class reservation extends JFrame implements ActionListener{
   
   //label
   private JLabel pd_info; //상품 정보  (product_info)
   private JLabel room_class; //고객이 선택한 룸 등급
   private JLabel cheak_in, cheak_out; //체크인, 체크아웃
   private JLabel ckIn_date, ckOut_date; //체크인, 체크아웃 날짜
   private JLabel contour_1, contour_2, contour_3; //구분선 1,2
   private JLabel f_name; //추가시설 이용 (facility)
   
   private JLabel rp_info; //예약자 정보 (reservation person)
   
   private JLabel name; //예약자 이름
   private JLabel phoneNum; //예약자 전화번호
   
   private JTextField name_v_re; //이름값 수정
   private JTextField phoneNum_v_re1; //전화번호값 수정 (010)
   private JTextField phoneNum_v_re2; //전화번호값 수정 (1234-5678)
   
   private JLabel pay_info; //결제 정보
   private JLabel room_pay; //숙박 비용
   private JLabel facility_pay; //시설 비용   
   private JLabel total; //총 이용 요금
   
   //Button
   private JButton ok; //예약자 정보 확인
   private JButton correct; //예약자 정보 수정
   private JButton reservation; //예약하기
   private JButton cancle; //예약 취소
   
   //comboBox
   private JComboBox cb_facility; //시설 선택
   private JComboBox cb_date; //시설 이용 날짜 
   private JComboBox cb_time; //시설 이용 시간 
   private JComboBox cb_age; //시설 이용자 연령 
   private JComboBox cb_people; //시설 이용 인원
   private JComboBox cb_telcode; // 연락처 코드
   
   String [] facilities= {" 루프탑 수영장"," 조식뷔페"," 다이닝"," 피트니스&사우나"};
   String [] date= {" 2022년 12월 03일"," 2022년 12월 04일"};
   String [] time= {" 오전"," 오후"," 야간"};
   String [] age= {" 성인"," 어린이"};
   String [] people= {" 1명"," 2명"," 3명"," 4명"," 5명"," 6명"," 7명"," 8명"};
   String [] telcode = { "010", "011", "017", "070", "02", "031", "032", "033", "041" };

   
   
   public reservation() { //생성자
      
      //객체 생성
      pd_info=new JLabel("[  상품 정보  ]");    //상품정보
      room_class=new JLabel("디럭스 룸");    //룸 등급
      cheak_in=new JLabel("체크인"); cheak_out=new JLabel("체크아웃"); //체크인, 체크아웃
      ckIn_date=new JLabel("2022년  12월  03일  15:00 ~"); ckOut_date=new JLabel("2022년  12월  04일  11:00"); //체크인, 체크아웃
      contour_1=new JLabel("------------------------------------------------------------------------------------------------------------------"); //구분선
      
      f_name=new JLabel("추가시설 이용"); //추가시설 이용
      cb_facility=new JComboBox(facilities); //시설 선택
      cb_date=new JComboBox(date); //날짜 선택
      cb_time=new JComboBox(time); //시간 선택
      cb_age=new JComboBox(age); //날짜 선택
      cb_people=new JComboBox(people); //시간 선택
      contour_2=new JLabel("------------------------------------------------------------------------------------------------------------------"); //구분선
      
      
      
      rp_info=new JLabel("[  예매자 정보  ]");
    
      name=new JLabel("이름                    : ");
      name_v_re=new JTextField("김지수");
      
      phoneNum=new JLabel("전화번호            :");
      cb_telcode = new JComboBox(telcode);
      phoneNum_v_re1=new JTextField("017");
      phoneNum_v_re2=new JTextField("12345678");
      
      
      ok=new JButton("확인");
      correct=new JButton("수정");
      contour_3=new JLabel("------------------------------------------------------------------------------------------------------------------"); //구분선
      
      pay_info=new JLabel("[  결제 정보  ]");
      room_pay=new JLabel("   숙박 요금                (주말)                169000원");
      facility_pay=new JLabel("+ 이용 시설       (조식뷔페)                  40000원");
      total=new JLabel("Total,         209000원");
      reservation=new JButton("예약");
      cancle=new JButton("취소");
      
      
      Container ct=getContentPane(); //창 생성
      ct.setLayout(null);
      
      
      //좌표 설정 및 창에 추가
      pd_info.setBounds(125, 70, 100, 30);
      room_class.setBounds(185, 140, 100, 30);
      cheak_in.setBounds(335, 140, 100, 30);
      cheak_out.setBounds(335, 160, 100, 30);
      ckIn_date.setBounds(435, 140, 200, 30);
      ckOut_date.setBounds(435, 160, 200, 30);
      contour_1.setBounds(165, 200, 500, 30);
      
      f_name.setBounds(185, 240, 100, 30);
      cb_facility.setBounds(185, 290, 120, 30);
      cb_date.setBounds(340, 290, 140, 30);
      cb_time.setBounds(515, 290, 80, 30);
      cb_age.setBounds(185, 330, 120, 30);
      cb_people.setBounds(340, 330, 140, 30);
      contour_2.setBounds(165, 380, 500, 30);
      
      rp_info.setBounds(125, 420, 120, 30);
      name.setBounds(185, 470, 150, 30);
      name_v_re.setBounds(285, 470, 130, 30);
      phoneNum.setBounds(185, 500, 150, 30);
      cb_telcode.setBounds(285, 500, 50, 30);
      phoneNum_v_re1.setBounds(285, 500, 50, 30);
      phoneNum_v_re2.setBounds(345, 500, 80, 30);
      ok.setBounds(440, 500, 80, 27);
      correct.setBounds(535, 500, 80, 27);
      contour_3.setBounds(165, 530, 500, 30);
      
      pay_info.setBounds(125, 570, 120, 30);
      room_pay.setBounds(185, 620, 300, 30);
      facility_pay.setBounds(185, 640, 300, 30);
      total.setBounds(515, 650, 150, 50);
   
      reservation.setBounds(455, 720, 100, 45);
      cancle.setBounds(575, 720, 100, 45);
      
      
      
      //창에 추가
      ct.add(pd_info); ct.add(room_class); 
      ct.add(cheak_in); ct.add(cheak_out); ct.add(ckIn_date); ct.add(ckOut_date);
      ct.add(contour_1); 
      
      ct.add(f_name);
      ct.add(cb_facility); ct.add(cb_date); ct.add(cb_time); ct.add(cb_age); ct.add(cb_people);
      ct.add(contour_2);
      
      ct.add(rp_info); 
      ct.add(name); ct.add(name_v_re);
      ct.add(phoneNum); ct.add(cb_telcode);
      ct.add(phoneNum_v_re1); ct.add(phoneNum_v_re2);
      
      ct.add(ok); ct.add(correct); ct.add(contour_3);
      
      ct.add(pay_info); ct.add(room_pay); ct.add(facility_pay);
      ct.add(total); ct.add(reservation); ct.add(cancle);
      
      ok.addActionListener(this); //같은 class내에 있으므로 this
      correct.addActionListener(this); //같은 class내에 있으므로 this
      
      name_v_re.setEditable(false);
      cb_telcode.setVisible(false);
      phoneNum_v_re1.setEditable(false);
      phoneNum_v_re2.setEditable(false);
      
   }
   
   //actionPerformed 메소드 사용
   public void actionPerformed(ActionEvent e) {
     
      String str_name = name_v_re.getText();
      String str_phoneNum;
      
      String s = e.getActionCommand();
         
      if (s.equals("수정")) { //수정 버튼 누르면 입력칸 열림
         name_v_re.setEditable(true);
         phoneNum_v_re1.setVisible(false);	// 텍스트필드 없어지고
         cb_telcode.setVisible(true);	// 라디오버튼 텍스트필드 입력값으로 선택돼서 보임
         cb_telcode.setSelectedItem((String)phoneNum_v_re1.getText());
         phoneNum_v_re2.setEditable(true);
         }
      else if (s.equals("확인")) {
          name_v_re.setEditable(false);         
          phoneNum_v_re2.setEditable(false); 
          cb_telcode.setVisible(false);	// 라디오버튼 안보임
          phoneNum_v_re1.setVisible(true);	// 라디오버튼에서 선택됐던 항목으로 텍스트필드 보임
          phoneNum_v_re1.setText((String)cb_telcode.getSelectedItem());
         }
   
   }
   
   public static void main(String[] args) {
      
      reservation rv = new reservation();

      rv.setTitle("예약");
      rv.setSize(800, 900);
      rv.setLocation(350, 80); 
      rv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      rv.setVisible(true);
      
   }

}
