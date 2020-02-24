package chat.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatForm extends JFrame implements ActionListener{
	JPanel jp_msg = new JPanel();
	JTextArea jta_text = new JTextArea();
	JButton jbtn_msg = new JButton("보내기");
	JTextField jtf_msg = new JTextField();
	String u_id = null;
	String title =null;
	ChatRoomList crl =null;
	InetAddress ip = null;

	public ChatForm(String u_id,String title,ChatRoomList crl,InetAddress ip){
		this.u_id=u_id;
		this.title=title;
		this.crl=crl;
		this.ip=ip;
		crl.dispose();
		jp_msg.setLayout(new BorderLayout());
		jp_msg.add("Center",jtf_msg);
		jp_msg.add("East",jbtn_msg);
		this.add(jta_text);
		addAction();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jta_text.setEditable(false);
		this.add("South",jp_msg);
		this.setTitle(title + " / 사용자  :" +u_id );
		this.setSize(300,500);
		Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di2 = this.getSize();
		this.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
		this.setVisible(true);
	}
	public void addAction() {
		jtf_msg.addActionListener(this);
		jbtn_msg.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj== jtf_msg || obj == jbtn_msg) {
			String msg = jtf_msg.getText();
			jta_text.append(msg+"\n");
		}
		
	}
	
	
}
