package chat.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginEvent implements ActionListener{
	LoginForm lf = null;
	LoginEvent(LoginForm lf){
		this.lf=lf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==lf.jbtn_login || obj==lf.jtf_id || obj==lf.jtf_pw) {
			String u_id = lf.jtf_id.getText();
			String u_pw = lf.jtf_pw.getText();
			LoginCheck lc = new LoginCheck();
			boolean logincheck = lc.login(u_id, u_pw);
			if(logincheck) {
				System.out.println("로그인 실행");
//				new ChatForm(lf);
				new ChatRoomList(u_id,lf);
			}else if(logincheck==false) {
				JOptionPane.showMessageDialog(lf, "아이디와 비밀번호를 다시확인해 주세요.");
			}
		}
		if(obj==lf.jbtn_sign) {
			System.out.println("회원가입 버튼 실행");
			new SignForm();
		}
		
	}

}
