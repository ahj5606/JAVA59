package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*이벤트 처리 순서
 * 1.이벤트 소스를 지원하는 이벤트 처리 인터페이스를 implements한다
 * 선언만 되어있고 구현이 전혀 안되어 있는 메소드를 추상메소드라 한다.
 * 2.ActionListener가 선언하고 있는 추상메소드 재정의하기
 * 3.jbtn_exit.addActionListener(this) 호출하여
 * 	이벤트 소스와 이벤트처리를 담당하는 클래스를 연결하기.
 */
public class BaseBallGame implements ActionListener{
	//화면과 관련된 코드 추가 시작
	JFrame		jf_bbgmae	= new JFrame();
	//JMenuBar는 JFrame 안에 메뉴바 추가하기
	JMenuBar 	jmb_bbgame 	= new JMenuBar();
	//JMenu는 JMenuBar안에 들어갈 메뉴 추가하기
	JMenu 		jm_game 	= new JMenu("게임");
	//JMenuItem은 JMenu아래에 들어갈 메뉴 내용들.
	JMenuItem 	jmi_next 	= new JMenuItem("다음겜");
	JMenuItem 	jmi_clear	= new JMenuItem("지우기");
	JMenuItem 	jmi_dap 	= new JMenuItem("정답");
	JMenuItem 	jmi_exit 	= new JMenuItem("나가기");
	JMenu 		jm_info 	= new JMenu("도움말");
	JTextArea 	jta_display = new JTextArea("");
	JScrollPane jsp_display = new JScrollPane(jta_display);
	JTextField 	jtf_input 	= new JTextField();
	JButton 	jbtn_next 	= new JButton("다음겜");
	JButton 	jbtn_clear 	= new JButton("지우기");
	JButton 	jbtn_dap 	= new JButton("정답");
	JButton 	jbtn_exit 	= new JButton("나가기");
	JPanel	 	jp_center 	= new JPanel();
	JPanel 		jp_east 	= new JPanel();
	//화면과 관련된 코드 추가 끝
	
	static int com[] = new int[3];
	int my[] = new int[3];//my[0]=0 my[1]=0 my[2]=0	
	//디폴트 생성자 선언하기 
	public BaseBallGame() {
	//생성자 안에서 메소드를 호출하면 인스턴스화 없이도 호출이 가능함.
		initDisplay();
	}
	public void exitGame(){
		System.exit(0);
	}
	//화면처리하기
	public void initDisplay() {
		//System.out.println("화면 처리 시작");
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		jp_east.setLayout(new GridLayout(4,1));
		jbtn_next.setBackground(new Color(158,9,9));
		jbtn_next.setForeground(new Color(212,212,212));
		jbtn_clear.setBackground(new Color(50,120,15));
		jbtn_clear.setForeground(new Color(212,212,212));
		jbtn_dap.setBackground(new Color(98,180,180));
		jbtn_dap.setForeground(new Color(212,212,212));
		jbtn_exit.setBackground(new Color(8,90,125));
		jbtn_exit.setForeground(new Color(212,212,212));
		jp_east.add(jbtn_next);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		
		jm_game.add(jmi_next);
		jm_game.add(jmi_clear);
		jm_game.add(jmi_dap);
		jm_game.add(jmi_exit);
		//메뉴를 메뉴바에 붙여요
		jmb_bbgame.add(jm_game);
		jmb_bbgame.add(jm_info);
		jf_bbgmae.setJMenuBar(jmb_bbgame);
		
		//이벤트 소스와 이벤트 처리 클래스 매핑
		jtf_input.addActionListener(this);
		jbtn_next.addActionListener(this);
		jbtn_clear.addActionListener(this);
		jbtn_dap.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jmi_exit.addActionListener(this);
		
		jf_bbgmae.add("East",jp_east);
		jf_bbgmae.add("Center",jp_center);
		jf_bbgmae.add("East",jp_east);
		jf_bbgmae.setTitle("야구 숫자 게임");
		jf_bbgmae.setSize(600,400);
		jf_bbgmae.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		//JVM이감지한 이벤트 소스[jbtn_exit,jtf_input]로 부터
		Object obj = e.getSource();
		//너 그만 할거야?
		if(obj==jtf_input) {
			String user =jtf_input.getText();
			BaseBallGameLogic bbgl = new BaseBallGameLogic();
			String dap = bbgl.account(user);
			jta_display.append("입력한값 : "+user+"\n");
			jta_display.append(dap+"\n");
			jtf_input.setText("");
		}
		if(obj==jbtn_next) {
			BaseBallGameLogic bbgl = new BaseBallGameLogic();
			jta_display.setText("정답이 초기화 되었습니다.");
		}else if(obj==jbtn_clear) {
			jta_display.setText("");
		}else if(obj==jbtn_dap) {
			jta_display.setText("정답 : "+com[0]+""+com[1]+""+com[2]+"\n");
		}else if(obj==jbtn_exit || obj == jmi_exit) {
			//자바가상머신과 이 어플하고의 연결고리를 끊음
			exitGame();
		}
			
	}
	
	
	//세자리 숫자를 채번하는 메소드 입니다.
	//새게임 버튼을 누르거나 강제 종료 후 다시 시작할 때 호출됩니다.
	public void ranCom() {
		Random r = new Random();//0.0~
		com[0] = r.nextInt(10);//0.0~10.0
		do {
			com[1] = r.nextInt(10);//0.0~10.0
		}while(com[0]==com[1]);
		do {
			com[2] = r.nextInt(10);//0.0~10.0			
		}while((com[0]==com[2])||(com[1]==com[2]));
	}
	//insert here -  account메소드 구현 /////////////////////////
	/**************************************************************
	 * 사용자가 입력한 값에 대한 힌트를 출력하는 메소드 입니다.
	 * @param user 사용자가 입력한 세자리 숫자 입니다.
	 * @return 컴터가 채번한 숫자와 사용자가 입력한 숫자를 비교한 후 힌트문을 전달합니다.
	 * 버전
	 * 작성일
	 * 작성자 :  이순신
	 *************************************************************/
	public String account(String user) {
		int temp = Integer.parseInt(user);
		my[0] = temp/100;//123/100=1
		my[1] = (temp%100)/10;//2
		my[2] = temp%10;//3
		for(int me:my) {
			System.out.println("me:"+me);//0 0 0
		}
		int strike = 0;
		int ball = 0;
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<my.length;j++) {
				if(com[i]==my[j]) {//내가 입력한 숫자중에 컴터에 그 숫자가 있니?
					if(i==j) {//혹시 그 숫자가 자리도 일치하는거야?
						strike++;
					}//스트라이크 결정
					else {
						ball++;
					}
				}//////볼카운트 확보
			}//////////end of inner for
		}//////////////end of outter for
		if(strike==3) {
			return "정답입니다. 축하합니다.";
		}
		return strike+"스 "+ball+"볼";
	}	
	/////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		BaseBallGame bbGame = new BaseBallGame();
		
		
	}

}
