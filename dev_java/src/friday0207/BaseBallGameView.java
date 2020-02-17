package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.crypto.provider.RSACipher;

public class BaseBallGameView extends JFrame {
	//전역변수를 선언하여 문제를 해결할 수 있어요.
	//생성자의 파라미터로 배열의 주소번지를 받고 되는데 이 값을 사용하는 곳이
	//생성자 안에서가 아니라 intitDisyplay메소드 안에 setTitle메소드에서
	//사용해야 하기 때문에 파라미터로 넘어온 값을 반드시 전변과 초기화 해야 합니다.
	String result[] = null;
	//화면과 관련된 코드 추가 시작
	//JMenuBar는 JFrame 안에 메뉴바 추가하기
	JMenuBar 	jmb_bbgame 	= new JMenuBar();
	//JMenu는 JMenuBar안에 들어갈 메뉴 추가하기
	JMenu 		jm_game 	= new JMenu("게임");
	//JMenuItem은 JMenu아래에 들어갈 메뉴 내용들.
	JMenuItem 	jmi_next 	= new JMenuItem("다음겜");
	JMenuItem 	jmi_clear	= new JMenuItem("지우기");
	JMenuItem 	jmi_dap 	= new JMenuItem("정답");
	JMenuItem 	jmi_oracle 	= new JMenuItem("오라클테스트");
	JMenuItem 	jmi_exit 	= new JMenuItem("나가기");
	JMenu 		jm_info 	= new JMenu("도움말");
	JTextArea 	jta_display = new JTextArea("");
	JScrollPane 	jsp_display = new JScrollPane(jta_display);
	JTextField 	jtf_input 	= new JTextField();
	JButton 		jbtn_next 	= new JButton("다음겜");
	JButton 	jbtn_clear 	= new JButton("지우기");
	JButton 	jbtn_dap 	= new JButton("정답");
	JButton 	jbtn_exit 	= new JButton("나가기");
	JPanel	 	jp_center 	= new JPanel();
	JPanel 		jp_east 	= new JPanel();
	BaseBallGameLogic bbLogic = new BaseBallGameLogic();
	//화면과 관련된 코드 추가 끝
	public void initDisplay() {
		//이전 버전에서는 화면 처리를 직접 하였다. -ActionListener했다.
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
		jbtn_dap.setForeground(new Color(0,0,212));
		jbtn_exit.setBackground(new Color(8,90,125));
		jbtn_exit.setForeground(new Color(212,212,212));
		jta_display.setFont(new Font("고딕", Font.BOLD, 20));
		jtf_input.setFont(new Font("고딕", Font.BOLD, 20));
		jp_east.add(jbtn_next);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_exit);
		
		jm_game.add(jmi_next);
		jm_game.add(jmi_clear);
		jm_game.add(jmi_dap);
		jm_game.add(jmi_oracle);
		jm_game.add(jmi_exit);
		jta_display.setEditable(false);
		//메뉴를 메뉴바에 붙여요
		jmb_bbgame.add(jm_game);
		jmb_bbgame.add(jm_info);
		setJMenuBar(jmb_bbgame);
		
		aActionListener();
		add("East",jp_east);
		add("Center",jp_center);
		add("East",jp_east);
		setTitle("야구 숫자 게임 이름: "+result[0]+"["+result[1]+"]");
		setSize(600,400);
		setVisible(true);
	}
	void aActionListener() {
		BaseBallGameEvent bbEvent = new BaseBallGameEvent(this);
		jtf_input.addActionListener(bbEvent);
		jbtn_next.addActionListener(bbEvent);
		jmi_next.addActionListener(bbEvent);
		jbtn_clear.addActionListener(bbEvent);
		jmi_clear.addActionListener(bbEvent);
		jbtn_dap.addActionListener(bbEvent);
		jmi_dap.addActionListener(bbEvent);
		jbtn_exit.addActionListener(bbEvent);
		jmi_exit.addActionListener(bbEvent);
		jmi_oracle.addActionListener(bbEvent);
	}
	//파라미터자리는 변수를 선언하는 자리입니다.
	//초기화는 일어나지 않지요. - 생성하는 자리가 아닙니다.
	public BaseBallGameView(String result[]) {
	//생성자 안에서 메소드를 호출하면 인스턴스화 없이도 호출이 가능함.
		this.result=result;
		if(this.result==null) {
			this.result = new String[2];
			this.result[0] = "";
			this.result[1] = "";
		}
		if(this.result[0]!=null) {
			bbLogic.ranCom();
			System.out.println("유저 : "+this.result[0]+"    아이디 : "+this.result[1]);
			initDisplay();
			JOptionPane.showMessageDialog(this, "환영합니다."+this.result[0]+" 님");
	
		}
	}
	public static void main(String[] args) {
		new BaseBallGameView(null);
		
	}
}
