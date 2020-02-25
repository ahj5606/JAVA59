package chat.test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignForm extends JFrame implements ActionListener{
	JPanel jp_text = new JPanel();
	JLabel jl_id = new JLabel("ID");
	JLabel jl_pw = new JLabel("PW");
	JPanel jp_lb = new JPanel();
	JTextField jtf_id = new JTextField();
	JTextField jtf_pw = new JTextField();
	JPanel jp_button = new JPanel();
	JButton jbtn_check = new JButton("중복 확인");
	JButton jbtn_sign = new JButton("가입");
	JButton jbtn_exit = new JButton("종료");
	SignDB sdb =new SignDB();
	boolean id_check = false;
	boolean sign_user = false;
	String u_id = null;
	
	SignForm(){
		jp_lb.setLayout(new GridLayout(2,1));
		jp_lb.add(jl_id);
		jp_lb.add(jl_pw);
		
		jp_text.setLayout(new GridLayout(2, 1));
		jp_text.add(jtf_id);
		jp_text.add(jtf_pw);
		
		jp_button.setLayout(new GridLayout(3,1));
		jp_button.add(jbtn_check);
		jp_button.add(jbtn_sign);
		jp_button.add(jbtn_exit);
		
		addAction();
		this.add("West",jp_lb);
		this.add("Center",jp_text);
		this.add("East",jp_button);
		this.setTitle("회원가입");
		this.setVisible(true);
		setSize(300,100);
		Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di2 = this.getSize();
		this.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
	}
	void addAction() {
		jtf_id.addActionListener(this);
		jtf_pw.addActionListener(this);
		jbtn_check.addActionListener(this);
		jbtn_sign.addActionListener(this);
		jbtn_exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_exit) {
			this.dispose();
			return;
		}else 
		if(obj == jtf_id || obj == jtf_pw || obj == jbtn_sign) {
			String u_id = jtf_id.getText();
			String u_pw = jtf_pw.getText();
			System.out.println(u_id);
			if(u_id.equals("") || u_pw.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 작성해주세요.");
				return;
			}
			
			if(id_check) {
				System.out.println("가입 실행");
				sign_user=sdb.signUser(u_id, u_pw);
				if(sign_user) {
					JOptionPane.showMessageDialog(this,"가입이 완료되었습니다.");
				}else if(!sign_user) {
					JOptionPane.showMessageDialog(this, "가입에 실패하였습니다.");
				}
				
				
			}else if(!id_check) {
				JOptionPane.showMessageDialog(this, "아이디 중복체크를 하세요.");
				return;
			}
		}else
		if(obj == jbtn_check) {
			String u_id = jtf_id.getText();
			if(u_id.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 작성해주세요.");
				return;
			}
			if(u_id.length()>10) {
				JOptionPane.showMessageDialog(this, "아이디는 10자리 이하로 작성해 주세요.");
				return;
			}else if(u_id.length()<=10) {
				
				id_check=sdb.checkID(u_id);
				if(id_check) {
					JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디 입니다.");
					jtf_id.setEnabled(false);
					return;
				}else if(!id_check) {
					JOptionPane.showMessageDialog(this, "중복된 아이디가 있습니다.");
					return;
				}
			}
			
			
		}
		
	}

}
