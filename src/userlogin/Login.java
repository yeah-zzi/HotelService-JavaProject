//로그인

package userlogin;

import javax.swing.*;

import project.SignUp.ableIdDialog;

import java.awt.*; 
import java.awt.event.*; 

public class Login extends JFrame implements ActionListener{ //로그인 화면
   
   private JTextField jtf1, jtf2; //id,pw 입력칸
   private JLabel lb_id, lb_pw; //id,pw label
   private JLabel lb_name; //호텔명 label
   private JButton bt_find_pw, bt_join, bt_cancle; //비밀번호 찾기, 회원가입, 취소 Button
   private JButton bt_log; //Login button
   
   
   public Login() { //생성자 시작
      
      lb_name=new JLabel("MJ HOTEL"); //호텔명 label 생성
      lb_id=new JLabel("ID : ");       //id label 생성
      lb_pw=new JLabel("Passwd : ");    //pw label 생성
      jtf1=new JTextField(15); //id 입력칸 생성
      jtf2=new JTextField(15); //pw 입력칸 생성
      bt_log=new JButton("LOGIN");    //Login button 생성
      bt_find_pw=new JButton("비밀번호 찾기");   //비밀번호 찾기 label 생성
      bt_join=new JButton("회원가입");   //회원가입 label 생성
      bt_cancle=new JButton("취소");      //취소 label 생성
      

      Container ct=getContentPane(); //창 생성
      ct.setLayout(null);


      //id,pw label과 입력칸 좌표설정
      lb_name.setBounds(320,120,100,30);
      lb_id.setBounds(210,240,70,30); jtf1.setBounds(310,240,170,30); 
      lb_pw.setBounds(210,290,70,30); jtf2.setBounds(310,290,170,30); 

      //창에 id,pw label과 입력칸 추가
      ct.add(lb_id); ct.add(lb_pw); ct.add(lb_name);
      ct.add(jtf1);  ct.add(jtf2);
      
      //Login button 좌표설정, 창에 추가
      bt_log.setBounds(300,380,100,40);
      ct.add(bt_log); 
      
      bt_join.setBounds(155,600,100,30);
      bt_find_pw.setBounds(275,600,150,30);
      bt_cancle.setBounds(445,600,100,30);
      
      ct.add(bt_find_pw);	  ct.add(bt_join);    ct.add(bt_cancle);
      
      bt_cancle.addActionListener(this);
      jtf1.addActionListener(this);
      jtf2.addActionListener(this);

      
   }
   
   public void actionPerformed(ActionEvent ae) {
	   
		String s = ae.getActionCommand();
		
		if (s.equals("취소")) { // 취소 버튼 누르면 모든 입력값 초기화
			jtf1.setText("");
			jtf2.setText("");
		} 
   }
   

   
   public static void main(String[] args) {
      
      Login log = new Login();

      log.setTitle("로그인");
      log.setSize(700, 800);
      log.setLocation(350, 80); 
      log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      log.setVisible(true);
      
   }

}
