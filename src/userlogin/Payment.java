package userlogin;
//사용자 - 예약 - 결제화면

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Payment extends JFrame implements ActionListener, ItemListener {

	private int payResult = 1;
	private JLabel jlPay, jlTotal, jlTotalP, jlTotalP_num, jlLine1, jlLine2;
	private ButtonGroup btg;
	private JRadioButton creditCard, deposit, naverPay, kakaoPay, payco, fcreditCard, fdeposit, fnaverPay, fkakaoPay, fpayco;
	private String[] credits = {"KB국민카드", "현대카드", "하나카드", "신한카드", "농협카드"};
	private String[] creditsIn = {"일시불", "3개월", "6개월", "9개월", "12개월"};
	private String[] deposits = {"KB국민은행", "하나은행", "신한은행", "농협은행", "카카오뱅크"};
	private JComboBox creditsCombo, creditsInCombo, depositsCombo;
	private JButton jbYes, jbCancel;
	
	Payment (String title) { // 생성자 시작
		
		setTitle(title);
		
		jlPay = new JLabel("[  결제수단  ]");

		// 결제수단 라디오버튼그룹
		btg = new ButtonGroup();
		creditCard = new JRadioButton("신용카드");
		deposit = new JRadioButton("무통장입금");
		naverPay = new JRadioButton("네이버페이");
		kakaoPay = new JRadioButton("카카오페이");
		payco = new JRadioButton("페이코");
		
		btg.add(creditCard);	btg.add(deposit);	
		btg.add(naverPay);	btg.add(kakaoPay);	btg.add(payco);
		btg.add(fcreditCard);	btg.add(fdeposit);	
		btg.add(fnaverPay);	btg.add(fkakaoPay);	btg.add(fpayco);
		
		// 결제수단 옆 콤보박스
		creditsCombo = new JComboBox(credits);
		creditsInCombo = new JComboBox(creditsIn);
		depositsCombo = new JComboBox(deposits);
		creditsCombo.setVisible(false); 
		creditsInCombo.setVisible(false);
		depositsCombo.setVisible(false);
		
		jlLine1 = new JLabel("------------------------------------------------------------------------------------------------------------------");

		
		// 결제 금액 label
		jlTotal = new JLabel("[  Total  ]");
		jlTotalP = new JLabel("결제 금액");
		jlTotalP_num = new JLabel("209,000원");
		jlLine2 = new JLabel("------------------------------------------------------------------------------------------------------------------");
		
		// 결제, 취소 버튼
		jbYes = new JButton("결제하기");
		jbCancel = new JButton("취소");
		
		// 창 생성
		Container ct = getContentPane();
		ct.setLayout(null); 
		
		// 이벤트 연결
		creditCard.addItemListener(this);
		deposit.addItemListener(this);
		naverPay.addItemListener(this);
		kakaoPay.addItemListener(this);
		payco.addItemListener(this);
		jbYes.addActionListener(this);
		jbCancel.addActionListener(this);
		
		// 좌표설정
		jlPay.setBounds(125, 70, 100, 30);
		creditCard.setBounds(185, 140, 100, 30);
		creditsCombo.setBounds(335, 140, 100, 30);
		creditsInCombo.setBounds(470, 140, 100, 30);
		deposit.setBounds(185, 190, 100, 30);
		depositsCombo.setBounds(335, 190, 100, 30);
		naverPay.setBounds(185, 240, 100, 30);
		kakaoPay.setBounds(185, 290, 100, 30);
		payco.setBounds(185, 340, 100, 30);
		jlLine1.setBounds(165, 390, 500, 30);
		jlTotal.setBounds(125, 450, 100, 30);
		jlTotalP.setBounds(190, 500, 100, 30);
		jlTotalP_num.setBounds(350, 500, 100, 30);
		jlLine2.setBounds(165, 550, 500, 30);
		jbYes.setBounds(455, 700, 100, 45);
		jbCancel.setBounds(575, 700, 100, 45);
		
		// 창에 전부 추가
		ct.add(jlPay);
		ct.add(creditCard);	ct.add(creditsCombo);	ct.add(creditsInCombo);
		ct.add(deposit);	ct.add(depositsCombo);	
		ct.add(naverPay);	ct.add(kakaoPay);	ct.add(payco);	
		ct.add(jlLine1);
		ct.add(jlTotal);	ct.add(jlTotalP);	ct.add(jlTotalP_num);
		ct.add(jlLine2);
		ct.add(jbYes);	ct.add(jbCancel);

	}
	
	public void itemStateChanged(ItemEvent ie) { // 결제수단 라디오버튼 선택에 따라 
		if (creditCard.isSelected()) {	// 신용카드 선택 시 콤보박스 보이게
			creditsCombo.setVisible(true); 
			creditsInCombo.setVisible(true);
			depositsCombo.setVisible(false);	// 다른 콤보박스는 안 보이게
		}
		else if (deposit.isSelected()) { // 무통장입금 선택 시 콤보박스 보이게
			depositsCombo.setVisible(true);
			creditsCombo.setVisible(false); 	// 다른 콤보박스는 안 보이게
			creditsInCombo.setVisible(false);
		}
		else if (naverPay.isSelected() || kakaoPay.isSelected() || payco.isSelected()) { 
			creditsCombo.setVisible(false); // 다른 결제수단 선택 시 콤보박스 안 보이게
			creditsInCombo.setVisible(false);
			depositsCombo.setVisible(false);
		}	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String s = ae.getActionCommand(); // 버튼 String 갖고 옴
		
		if (s.equals("결제하기")) {	// 결제하기 버튼 누를시
			// 결제 수단 하나도 선택 안했으면 안된다고 띄우기
			if (( creditCard.isSelected() || deposit.isSelected() || naverPay.isSelected() || kakaoPay.isSelected() || payco.isSelected() )== false) {
				JOptionPane.showMessageDialog(this, "결제수단을 선택해주세요!", "알림창", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "결제가 완료되었습니다!", "알림창", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {	// 취소 버튼 누를시
			dispose();	// 창 닫기
		}
	}


	public static void main(String[] args) {
		Payment pa = new Payment("예약 - 결제");
		
		pa.setSize(800, 900);
		pa.setLocation(350, 20);
		pa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pa.setVisible(true);
	}

}
