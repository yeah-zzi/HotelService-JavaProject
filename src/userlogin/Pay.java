package userlogin;
//결제화면
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*; 
import java.awt.event.*; 

public class Pay extends JFrame implements ActionListener, ItemListener {

	private int payResult = 1;
	private JLabel jlPay, jlTotal, jlTotalP, jlTotalP_num, jlLine1, jlLine2;
	private ButtonGroup btg;
	private JRadioButton creditCard, deposit, naverPay, kakaoPay, payco, fcreditCard, fdeposit, fnaverPay, fkakaoPay, fpayco;
	private String[] credits = {"KB국민카드", "현대카드", "하나카드", "신한카드", "농협카드"};
	private String[] creditsIn = {"일시불", "3개월", "6개월", "9개월", "12개월"};
	private String[] deposits = {"KB국민은행", "하나은행", "신한은행", "농협은행", "카카오뱅크"};
	private JComboBox creditsCombo, creditsInCombo, depositsCombo;
	private JButton jbYes, jbCancel;
	
	public Pay() {
		
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
		jbYes.setBounds(455, 600, 100, 45);	// y좌표 700
		jbCancel.setBounds(575, 600, 100, 45);
		
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
				PayJDialog pcNo = new PayJDialog(this, "결제", true, "결제 수단을 선택해 주세요!");
				pcNo.show();
			}
			else {
				PayJDialog pcYes = new PayJDialog(this, "결제", true, "결제가 완료되었습니다!");
				pcYes.show();	// 결제 완료 창 띄우기 
			}
		}
		else {	// 취소 버튼 누를시
			// 창 닫기 
		}
	}
	
	class PayJDialog extends JDialog implements ActionListener {
		// JDialg창 띄우기 클래스
		JButton dia_ok;
		
		PayJDialog(JFrame parent, String title, boolean mode, String msg) {
			super(parent, title, mode);
			
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
	}


	public static void main(String[] args) {
		Pay pa = new Pay();
		
		pa.setTitle("예약");
		pa.setSize(800, 900);
		pa.setLocation(350, 80);
		pa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pa.setVisible(true);
	}

}
