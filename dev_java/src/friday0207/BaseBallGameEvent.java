package friday0207;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import com.util.DBConnectionMgr;

public class BaseBallGameEvent implements ActionListener{
	DBConnectionMgr dbMgr =	DBConnectionMgr.getInstance();
	Connection con = null;
	BaseBallGameView bbView =null;
	//게임을 진행하는 동안에는 계속 그 숫자를 기억하고 있다가 1씩 증가되야 하니까..
	//전역변수로 해야 함.
	int cnt = 0;;//회차를 출력할 변수 선언
	public BaseBallGameEvent(BaseBallGameView bbView) {//생성자 사용
		this.bbView =bbView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//JVM이감지한 이벤트 소스[jbtn_exit,jtf_input]로 부터
		Object obj = e.getSource();
		//너 그만 할거야?
		if(obj == bbView.jtf_input) {
			int score = 10;
			String user = bbView.jtf_input.getText();
			
			String hint = bbView.bbLogic.account(user);
			if(user.length()!=3) {
				bbView.jta_display.append("3자리 숫자를 입력하세요.\n");
				bbView.jtf_input.setText("");
				return;
			}
			
			bbView.jtf_input.setText("");
			
			if(hint.equals("정답입니다. 축하합니다.")) {
				
				bbView.jtf_input.setEditable(false);
				score = 100-cnt*10;
			
			}else if(cnt ==9) {
				bbView.jta_display.append("***********************************"
											+ "\n기회를 다 사용했습니다."
											+ "\n***********************************\n");
			}
			//insert here 
			//수집해야하는 정보를 입력해 보기
			bbView.jta_display.append(++cnt+" 회  "+user+"---->"+hint+"\n");
			String dap = bbView.bbLogic.com[0]+""+bbView.bbLogic.com[1]+""+bbView.bbLogic.com[2];
			System.out.println("mem_id : "+bbView.result[1]);
			System.out.println("game_seq : "+(cnt));
			System.out.println("input : "+user);
			System.out.println("hint : "+hint);
			System.out.println("dap : "+dap);
			System.out.println("score : "+score);
			
			BaseBallVO bbvo = new BaseBallVO(cnt,user,hint,dap,bbView.result[1],score);
			System.out.println("=================================");
			System.out.println("mem_id : "+bbvo.getMem_id());
			System.out.println("game_seq : "+bbvo.getGame_seq());
			System.out.println("input : "+bbvo.getInput());
			System.out.println("hint : "+bbvo.getHint());
			System.out.println("dap : "+bbvo.getDap());
			System.out.println("score : "+bbvo.getScore());
			
			
			
			
			int result = bbView.bbLogic.history(bbvo);
			if(result == 1) {
				JOptionPane.showMessageDialog(bbView,"등록성공");
			}else if(result == 0) {
				JOptionPane.showMessageDialog(bbView,"등록실패");
				
			}
			
			
			
			
		}
		if(obj == bbView.jbtn_next || obj == bbView.jmi_next) {
			cnt = 0;
			bbView.bbLogic.ranCom();
			bbView.jtf_input.setEditable(true);
			bbView.jbtn_dap.setEnabled(true);
			bbView.jta_display.setText("정답이 초기화 되었습니다.\n");
		}else if(obj == bbView.jbtn_clear || obj == bbView.jmi_clear) {
			bbView.jta_display.setText("");
		}else if(obj == bbView.jbtn_dap || obj == bbView.jmi_dap) {
			bbView.jta_display.append("정답 : "+bbView.bbLogic.com[0]+""+bbView.bbLogic.com[1]+""+bbView.bbLogic.com[2]+"\n");
			bbView.jbtn_dap.setEnabled(false);
		}else if(obj == bbView.jmi_exit||obj == bbView.jbtn_exit) {			//자바가상머신과 이 어플하고의 연결고리를 끊음
			System.exit(0);
		}else if(obj == bbView.jmi_oracle) {
			dbMgr = DBConnectionMgr.getInstance();
			con = dbMgr.getConnection();
			if(con!=null) {
				System.out.println("오라클 서버 연결  성공"+con);
			}else {
				System.out.println("오라클 서버 연결 실패");
			}
		}
			
	}

}
