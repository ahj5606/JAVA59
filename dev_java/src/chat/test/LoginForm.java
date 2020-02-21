package chat.test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame{
	JTextField jtf_id = new JTextField("ID입력공간");
	JTextField jtf_pw = new JTextField("PW입력공간");
	
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_sign = new JButton("회원가입");
	
	JPanel jp_south = new JPanel();
	JPanel jp_btn = new JPanel();
	JPanel jp_text = new JPanel();
	
	public void initDisplay() {
		jp_text.setLayout(new GridLayout(2,1));
		jp_text.add(jtf_id);
		jp_text.add(jtf_pw);
		
		jp_btn.setLayout(new GridLayout(2,1));
		jp_btn.add(jbtn_login);
		jp_btn.add(jbtn_sign);
		
		jp_south.setLayout(new GridLayout(1,2));
		jp_south.add(jp_text);
		jp_south.add(jp_btn);
		this.add("South",jp_south);
		addAction();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("South",jp_south);
		this.setSize(300, 500);
		this.setVisible(true);
	}
	void addAction() {
		LoginEvent le = new LoginEvent(this);
		jtf_id.addActionListener(le);
		jtf_pw.addActionListener(le);
		jbtn_login.addActionListener(le);
		jbtn_sign.addActionListener(le);
	}
	public LoginForm() {
		initDisplay();
	}
	public static void main(String[] args) {
		new LoginForm();
	}
}
