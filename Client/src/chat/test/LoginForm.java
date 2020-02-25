package chat.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame{
	JLabel jl_id = new JLabel("ID");
	JLabel jl_pw = new JLabel("PW");
	JTextField jtf_id = new JTextField("");
	JTextField jtf_pw = new JTextField("");
	
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_sign = new JButton("회원가입");
	
	JPanel jp_south = new JPanel();
	JPanel jp_lb = new JPanel();
	JPanel jp_btn = new JPanel();
	JPanel jp_text = new JPanel();
	String u_id = null;
	public void initDisplay() {
		jp_lb.setLayout(new GridLayout(2,1));
		jp_lb.add(jl_id);
		jp_lb.add(jl_pw);
		jp_text.setLayout(new GridLayout(2,1));
		jp_text.add(jtf_id);
		jp_text.add(jtf_pw);
		
		
		
		jp_btn.setLayout(new GridLayout(2,1));
		jp_btn.add(jbtn_login);
		jp_btn.add(jbtn_sign);
		
		jp_south.setLayout(new BorderLayout());
		jp_south.add("West",jp_lb);
		jp_south.add("Center",jp_text);
		jp_south.add("East",jp_btn);
		this.add("South",jp_south);
		addAction();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("South",jp_south);
		this.setSize(300, 500);
		Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di2 = this.getSize();
		this.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
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
