package userlogin;
//test
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener, ItemListener {

	JTextField id, pwans, name, birth, tel_num1, tel_num2, email_id;
	JPasswordField pw;
	JComboBox hint, tel, email;
	JButton ok, cancel, check;
	JRadioButton cBtn, mBtn, defalutBtn;
	String pwhint[] = { "내가 가장 존경하는 인물은?", "내가 태어난 곳은?", "내 어릴적 별명은?", "내가 키우던 애완동물의 이름은?", "내가 가장 좋아하는 간식은?",
			"내가 싫어하는 음식은?", "내가 좋아하는 캐릭터는?", "나와 가장 친한 친구의 이름은?", "자신의 보물 1호는?", "내가 다닌 초등학교 이름은?" };
	String telcode[] = { "010", "011", "017", "070", "02", "031", "032", "033", "041" };
	String emcode[] = { "naver.com", "gmail.com", "nate.com", "daum.net", "korea.kr" };
	String c_hint = "6자리 (영소문자&숫자)";
	String m_hint = "6자리 사번 (끝 2자리 부서번호)";
	String b_hint = "EX> 990101";
	
	SignUp(String title) {
		setTitle(title);
		
		this.setLayout(new BorderLayout(0, 50));
		
		
		JPanel photo = new JPanel();
		
		ImageIcon c = new ImageIcon("images/client.png");
		Image i1 = c.getImage();
		Image ci = i1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon client = new ImageIcon(ci);
		
		ImageIcon sc = new ImageIcon("images/selectedClient.jpeg");
		Image si1 = sc.getImage();
		Image sci = si1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon selectedClient = new ImageIcon(sci);
		
		ImageIcon m = new ImageIcon("images/manager.png");
		Image i2 = m.getImage();
		Image mi = i2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon manager = new ImageIcon(mi);
		
		ImageIcon sm = new ImageIcon("images/selectedManager.jpeg");
		Image si2 = sm.getImage();
		Image smi = si2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon selectedManager = new ImageIcon(smi);
		
		ButtonGroup g = new ButtonGroup();
		cBtn = new JRadioButton("고객 ", client);
		mBtn = new JRadioButton("관리자", manager);
		defalutBtn = new JRadioButton();  // 취소 버튼 누를 때, 초기화로 버튼 안눌러진 상태로 보이기 위해 만든 가상의 라디오버튼
		
		cBtn.setBorderPainted(true);
		cBtn.setSelectedIcon(selectedClient);
		cBtn.setFont(new Font("", Font.PLAIN, 25));
		cBtn.addItemListener(this);
		
		mBtn.setBorderPainted(true);
		mBtn.setSelectedIcon(selectedManager);
		mBtn.setFont(new Font("", Font.PLAIN, 25));
		mBtn.addItemListener(this);

		
		g.add(cBtn); g.add(mBtn); g.add(defalutBtn); //라디오그룹에만 추가하고 패널에 올리지 않는다.
		photo.add(cBtn); photo.add(mBtn);
		add(photo, BorderLayout.NORTH);
		
	

		JPanel main = new JPanel(); // 메인 패널 위에 그리드 패널 올림.
		
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(8,0, 0,20));
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l1 = new JLabel("아이디         ");//9
		id = new JTextField(15);
		check = new JButton("중복 확인");
		check.addActionListener(this);
		p1.add(l1);
		p1.add(id);
		p1.add(check);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l2 = new JLabel("비밀번호      ");//6
		pw = new JPasswordField(15);
		p2.add(l2);
		p2.add(pw);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l3 = new JLabel("비밀번호 힌트     ");//5
		hint = new JComboBox(pwhint);
		p3.add(l3);
		p3.add(hint);

		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l4 = new JLabel("비밀번호 힌트 답  ");//2
		pwans = new JTextField(15);
		p4.add(l4);
		p4.add(pwans);

		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l5 = new JLabel("이름            ");//12
		name = new JTextField(8);
		p5.add(l5);
		p5.add(name);
		
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l6 = new JLabel("생년월일       ");//7
		birth = new JTextField(b_hint, 8);
		p6.add(l6);
		p6.add(birth);

		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l7 = new JLabel("연락처         ");//9
		tel = new JComboBox(telcode);
		tel_num1 = new JTextField(6);
		tel_num2 = new JTextField(6);
		p7.add(l7);
		p7.add(tel);
		p7.add(tel_num1);
		p7.add(tel_num2);
		
		JPanel p8 = new JPanel();
		p8.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel l8 = new JLabel("이메일         ");//9
		email_id = new JTextField(10);
		JLabel l9 = new JLabel("@");
		email = new JComboBox(emcode);
		p8.add(l8);
		p8.add(email_id);
		p8.add(l9);
		p8.add(email);
		
		
		
		grid.add(p1); grid.add(p2); grid.add(p3); grid.add(p4);
		grid.add(p5); grid.add(p6); grid.add(p7); grid.add(p8);
		
		main.add(grid);
		//main.setPreferredSize(new Dimension(400,500));
		add(main, BorderLayout.CENTER);
		
		

		

		JPanel bottom = new JPanel();
		
		ok = new JButton("확인");
		ok.setFont(new Font("", Font.PLAIN, 15));
		cancel = new JButton("취소");
		cancel.setFont(new Font("", Font.PLAIN, 15));
		cancel.addActionListener(this);
		bottom.add(ok);
		bottom.add(cancel);

		add(bottom, BorderLayout.SOUTH);
	}
	
	public void itemStateChanged(ItemEvent ie) { //라디오버튼이 선택되면 힌트값을 다르게 출력.
		if(cBtn.isSelected())
			id.setText(c_hint);
		else
			id.setText(m_hint);
			
	}
	
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("취소")) { // 취소 버튼 누르면 모든 입력값 초기화
			defalutBtn.setSelected(true);  // 가상의 라디오버튼, 라디오버튼이 안 눌려진 상태로 보이게 함.
			id.setText("");
			pw.setText("");
			pwans.setText("");
			name.setText("");
			birth.setText(b_hint);
			tel_num1.setText("");
			tel_num2.setText("");
			email_id.setText("");
			hint.setSelectedItem((Object) pwhint[0]);
			tel.setSelectedItem((Object) telcode[0]);
			email.setSelectedItem((Object) emcode[0]);
		} 
		else if (s.equals("확인")) { // 확인 버튼 누르면 DB연동 저장
			
		} 
		else { // 아이디 중복확인 DB로 확인 후, 사용가능여부 창 띄우기(가능하면 JDiglog, 불가능하면 JOptionPane)
			String ID = id.getText();
			
			//if (ID.equals("정상")) { //사용가능 
				ableIdDialog ai = new ableIdDialog(this, "아이디 중복 확인", true, ID);
				ai.show();
			
		} 
	}
	
	class ableIdDialog extends JDialog implements ActionListener {
		JButton ok;
		
		ableIdDialog(JFrame parent, String title, boolean mode, String id) {
			super(parent, title, mode);
			
			
			JPanel p1 = new JPanel(); 
			p1.setLayout(new GridLayout(2,0));
			JLabel lId = new JLabel("\""+ id +"\"");
			JLabel lAble = new JLabel("사용 가능한 아이디 입니다.");
			lId.setHorizontalAlignment(JLabel.CENTER);
			lAble.setHorizontalAlignment(JLabel.CENTER); //문장 가운데정렬.
			
			p1.add(lId); p1.add(lAble);
			add(p1, BorderLayout.CENTER);
			
			JPanel p2 = new JPanel();
			ok = new JButton("OK");
			ok.addActionListener(this);
			p2.add(ok);
			add(p2, BorderLayout.SOUTH);
			
			this.setBounds(450,235,500,230);
			
		}
		public void actionPerformed(ActionEvent ae) {
			dispose(); // 다이얼로그 창 닫기.
		}
	}
	
	public static void main(String[] args) {
		SignUp win = new SignUp("page");
		
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(700, 800);
		win.setLocation(350, 80);
		win.show();
	}

}
