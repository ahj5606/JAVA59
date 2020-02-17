package ui.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JComboBoxTest implements ItemListener{
	//선언부
	String data[] = null;
	JComboBox jcb_dept = null;
	JFrame jf = new JFrame();
	//생성자
	JComboBoxTest(){
		//insert here
		data = new JComboBoxDB().dnames;
		jcb_dept = new JComboBox(data);
		//jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.add("North",jcb_dept);
		jcb_dept.addItemListener(this);
		jf.setTitle("부서");
		jf.setSize(300, 400);
		jf.setLocation(700, 300);
		jf.setVisible(true);
	}
	/*
	 * 오라클 서버에서 dept테이블에 이쓴 정보를 조회하시오.
	 * 조회된 정보를 data배열에 초기화 하시오.
	 */
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new JComboBoxTest();
	}
	/*
	 * ItemListener의 공식명칭은 인터페이스 이다.
	 * 인터페이스는 추상메소드를 가지고 있으므로 반드시 구현해 주어야 한다.
	 * 이 때 부모가  가진 메소드의 원형을 절대로 훼손해서는 안된다.
	 */
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == jcb_dept) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println((String)jcb_dept.getSelectedItem());
			}
		}
		
	}
}
