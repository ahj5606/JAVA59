package book.chap05;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelBook  extends JFrame implements ActionListener {
	//선언부
	int width=600;
	int height=500;
	String title="전화번호부";
	JButton jbtn = new JButton("전화목록출력할 영역");
	JButton btn_sel = new JButton("조회");
	JButton btn_ins = new JButton("입력");
	JButton btn_upd = new JButton("수정");
	JButton btn_del = new JButton("삭제");
	JTextArea jta = new JTextArea();
	JButton jbtn_ins = new JButton("입력");
	JPanel jp_north = new JPanel();
	GridLayout glay = new GridLayout(1,4);
	JPanel jp_south = new JPanel();
	GridLayout glay_tf = new GridLayout(1,2);
	JTextField jtf = new JTextField();
	//생성자
	public String toString() {
		return "나는 TelBook테스트 클래스임.";
	}
	//화면처리부
	public void display() {
		System.out.println("display 호출 성공");
		//윈도우 화면에 창을 만들어주는 클래스 입니다. 가로세로 변경가능, 제목도 바꿀 수 있음
		JFrame jf_tel = new JFrame();
		//속지의 레이아웃을 GrridLayout 1,4 로우 한개 컬럼 4개로 n분할
		jp_north.setLayout(glay); //레이아웃 1줄 4칸으로 나눔
		jp_north.add(btn_sel);
		jp_north.add(btn_ins);
		jp_north.add(btn_upd);
		jp_north.add(btn_del);
		jp_south.setLayout(glay_tf);
		jp_south.add(jtf);
		jp_south.add("Right",jbtn_ins);
		jbtn_ins.addActionListener(this);
		//화면의 크기를 정해 주세요. 600,500
		//setSize메소드를 호출해보세요.
		jf_tel.setSize(width, height);//사이즈 
		//jf_tel.setSize(400,600);
		jf_tel.add("North",jp_north);
		jf_tel.add("Center",jta);
		jf_tel.add("South",jp_south);
		jf_tel.setTitle(title);//타이틀 이름 
		jf_tel.setVisible(true); //true false 화면 활성화 / 비활성화
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="입력") {
			String str = jtf.getText();
			jta.append(str+"\r\n");
			jtf.setText("");
		}
	}
	//메인메소드
	public static void main(String[] args) {
		TelBook tb = new TelBook();
		tb.display();
	}
}
