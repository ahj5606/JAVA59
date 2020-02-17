package book.chap05;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TvButton extends JFrame implements ActionListener {
	
	int width=600;
	int height=300;
	String title="TV";
	int vol=1;
	int chn=1;
	boolean power = false;
	JTextArea jta_vol = new JTextArea("볼륨 : "+vol);
	JTextArea jta_po = new JTextArea("전원 : "+power);
	JTextArea jta_chn = new JTextArea("채널 : "+chn);
	JPanel jp_north = new JPanel();
	GridLayout glay_cen = new GridLayout(1,4);
	JButton jbtns[]= new JButton[15];
	JButton po_btn = new JButton("전원");
	String btn_str[] = {"1","2","3","4","5","6","7","8","9","채널↑","0","채널↓","볼륨↑","입력","볼륨↓"};
	JPanel jp_south = new JPanel();
	GridLayout glay = new GridLayout(5,3);
	JPanel jp_center = new JPanel();
	GridLayout glay_center = new GridLayout(2,1);
	JTextArea jta_ch = new JTextArea();
	
	public void display() {
		
		JFrame jf_tv = new JFrame();
		jp_south.setLayout(glay);
		
		for(int i=0;i<jbtns.length;i++) {
			jp_south.add(jbtns[i]=new JButton(btn_str[i]));
			jbtns[i].addActionListener(this);
		}
		jp_north.setLayout(glay_cen);
		jp_north.add(jta_vol);
		jp_north.add(jta_po);
		jp_north.add(jta_chn);
		
		jp_center.setLayout(glay_center);
		jp_center.add(po_btn);
		jp_center.add(jta_ch);
		
		po_btn.addActionListener(this);
		jf_tv.add("North",jp_north);
		jf_tv.add("Center",jp_center);
		jf_tv.setSize(width, height);
		jf_tv.add("South",jp_south);
		jf_tv.setTitle(title);
		jf_tv.setVisible(true); 
		
	}
	void chnUp() {	//채널up 채널 ++ 해서 반환
		chn++;
		jta_chn.setText("채널 : "+chn);
	}
	void chnDown() { //채널down 채널--해서 반환
		chn--;
		jta_chn.setText("채널 : "+chn);
	}
	void volUp() {//볼륨up 볼륨++ 해서 반환
		vol++;
		jta_vol.setText("볼륨 : "+vol);
	}
	void volDown() {//볼륨down 볼륨-- 해서 반환
		vol--;
		jta_vol.setText("볼륨 : "+vol);
	}
	void powerOnOff() { //파워OnOff 현재상태의 반대상태를 반환
		power=!power;
		jta_po.setText("전원 : "+power);
	}
	void buttonCh(String chnStr) { //입력된 값으로 채널을변경할때
		if(jta_ch.getText().equals("")) {
			return;
		}
		chn=Integer.parseInt(chnStr);
		jta_chn.setText("채널 : "+chn);
		
		jta_ch.setText("");
	}
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if((power)&&(str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||
				str.equals("5")||str.equals("6")||str.equals("7")||str.equals("8")||
				str.equals("9")||str.equals("0"))) {
				jta_ch.append(str);
		}else if((power)&&str.equals("입력")) {
			buttonCh(jta_ch.getText());
		}else if((power)&&str.equals("채널↑")) {
			chnUp();
		}else if((power)&&str.equals("채널↓")) {
			chnDown();
		}else if((power)&&str.equals("볼륨↑")) {
			volUp();
		}else if((power)&&str.equals("볼륨↓")) {
			volDown();
		}else if(str.equals("전원")) {
			powerOnOff();
		}
	}
	
	public static void main(String[] args) {
		TvButton tb = new TvButton();
		tb.display();
	}
}
