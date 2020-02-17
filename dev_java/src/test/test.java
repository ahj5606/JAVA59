package test;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test implements ActionListener {
	boolean togle[] = new boolean[25];
	JButton jbtn_t[] = new JButton[25];
	String sbt = "";
	JFrame jf = new JFrame();
	void initDisplay(){
		jf.setLayout(new GridLayout(5,5));
		for(int i=0 ; i <25 ; i++) {
			jbtn_t[i] = new JButton(Integer.toString(i));
			jbtn_t[i].addActionListener(this);
			jbtn_t[i].setBackground(new Color(0,0,0));
			jf.add(jbtn_t[i]);
		}
		jf.setTitle("타이틀");
		jf.setSize(500,500);
		jf.setVisible(true);
	}
	test(){
		initDisplay();
	}
	public static void main(String[] args) {
		new test();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for(int i =0; i<jbtn_t.length;i++) {
			if(obj==jbtn_t[i]) {
				if(togle[i]==false) {
					jbtn_t[i].setBackground(new Color(255,255,255));
					togle[i]=true;
				}else if(togle[i]==true) {
					jbtn_t[i].setBackground(new Color(0,0,0));
					togle[i]=false;
					
				}
			}
		}
		
	}
}
