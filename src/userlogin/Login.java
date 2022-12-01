//�α���
//test

package userlogin;

import javax.swing.*;

import project.SignUp.ableIdDialog;

import java.awt.*; 
import java.awt.event.*; 

public class Login extends JFrame implements ActionListener{ //�α��� ȭ��
   
   private JTextField jtf1, jtf2; //id,pw �Է�ĭ
   private JLabel lb_id, lb_pw; //id,pw label
   private JLabel lb_name; //ȣ�ڸ� label
   private JButton bt_find_pw, bt_join, bt_cancle; //��й�ȣ ã��, ȸ������, ��� Button
   private JButton bt_log; //Login button
   
   
   public Login() { //������ ����
      
      lb_name=new JLabel("MJ HOTEL"); //ȣ�ڸ� label ����
      lb_id=new JLabel("ID : ");       //id label ����
      lb_pw=new JLabel("Passwd : ");    //pw label ����
      jtf1=new JTextField(15); //id �Է�ĭ ����
      jtf2=new JTextField(15); //pw �Է�ĭ ����
      bt_log=new JButton("LOGIN");    //Login button ����
      bt_find_pw=new JButton("��й�ȣ ã��");   //��й�ȣ ã�� label ����
      bt_join=new JButton("ȸ������");   //ȸ������ label ����
      bt_cancle=new JButton("���");      //��� label ����
      

      Container ct=getContentPane(); //â ����
      ct.setLayout(null);


      //id,pw label�� �Է�ĭ ��ǥ����
      lb_name.setBounds(320,120,100,30);
      lb_id.setBounds(210,240,70,30); jtf1.setBounds(310,240,170,30); 
      lb_pw.setBounds(210,290,70,30); jtf2.setBounds(310,290,170,30); 

      //â�� id,pw label�� �Է�ĭ �߰�
      ct.add(lb_id); ct.add(lb_pw); ct.add(lb_name);
      ct.add(jtf1);  ct.add(jtf2);
      
      //Login button ��ǥ����, â�� �߰�
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
		
		if (s.equals("���")) { // ��� ��ư ������ ��� �Է°� �ʱ�ȭ
			jtf1.setText("");
			jtf2.setText("");
		} 
   }
   

   
   public static void main(String[] args) {
      
      Login log = new Login();

      log.setTitle("�α���");
      log.setSize(700, 800);
      log.setLocation(350, 80); 
      log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      log.setVisible(true);
      
   }

}
