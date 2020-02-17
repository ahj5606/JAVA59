package study.sungjuk;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SungJukView {
	SungJukLogic sjl = new SungJukLogic();
	String sungjuk[][] = null;
	JLabel jlb_su = new JLabel(" 명          ");
	JLabel jlb_inwon = new JLabel("    인 원 수       ");
	JTextField jtf_inwon = new JTextField(15);
	JButton jbtn_oracle = new JButton("오라클로보내기");
	JButton jbtn_ran = new JButton("랜덤");
	JButton jbtn_data = new JButton("데이터 불러오기");
	JButton jbtn_account = new JButton("처 리");
	JButton jbtn_exit = new JButton("종 료");
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_south = new JPanel();
	JPanel jp_center = new JPanel();
	String				cols[]		= {"이름","국어","영어","수학","총점","평균","등수"};
	String				data[][]	= new String[0][7];;
	DefaultTableModel  dtm_sungjuk = new DefaultTableModel(data,cols);
	JTable 				jt_sungjuk 		= new JTable(dtm_sungjuk);
	JScrollPane 	jsp_sungjuk = new JScrollPane(jt_sungjuk);
	
	public SungJukView() {
		initDisplay();
	}
	
	public void start() {
		SungJukEvent sje = new SungJukEvent(this);
		jbtn_oracle.addActionListener(sje);
		jbtn_account.addActionListener(sje);
		jbtn_exit.addActionListener(sje);
		jtf_inwon.addActionListener(sje);
		jbtn_data.addActionListener(sje);
		jbtn_ran.addActionListener(sje);
	}
	public void initDisplay() {
		start();
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb_su);
		jf_sungjuk.add("North",jp_north);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_oracle);
		jp_south.add(jbtn_ran);
		jp_south.add(jbtn_data);
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		jf_sungjuk.add("Center",jsp_sungjuk);
		jsp_sungjuk.setVisible(false);
		jf_sungjuk.add("South",jp_south);
		jf_sungjuk.setTitle("성적처리");
		jf_sungjuk.setSize(600, 400);
		jf_sungjuk.setVisible(true);
		
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new SungJukView();
	}
}
