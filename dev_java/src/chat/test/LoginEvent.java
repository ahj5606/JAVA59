package chat.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEvent implements ActionListener{
	LoginForm lf = null;
	LoginEvent(LoginForm lf){
		this.lf=lf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==lf.jbtn_login || obj==lf.jtf_id || obj==lf.jtf_pw) {
			System.out.println("로그인 실행");
		}
		if(obj==lf.jbtn_sign) {
			System.out.println("회원가입 버튼 실행");
		}
		
	}

}
