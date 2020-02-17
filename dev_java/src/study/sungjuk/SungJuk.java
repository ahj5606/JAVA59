package study.sungjuk;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SungJuk implements ActionListener{
	int rowNum = 0;
	String sungjuk[][] = null;
	JLabel jlb_su = new JLabel(" 명          ");
	JLabel jlb_inwon = new JLabel("    인 원 수       ");
	JTextField jtf_inwon = new JTextField(15);
	JButton jbtn_ran = new JButton("랜덤");
	JButton jbtn_data = new JButton("데이터 불러오기");
	JButton jbtn_account = new JButton("처 리");
	JButton jbtn_exit = new JButton("종 료");
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_south = new JPanel();
	JPanel jp_center = new JPanel();
	String				cols[]		= {"이름","국어","영어","수학","총점","평균","등수"};
	String				data[][]	= new String[rowNum][7];;
	DefaultTableModel  dtm_sungjuk = new DefaultTableModel(data,cols);
	JTable 				jt_sungjuk 		= new JTable(dtm_sungjuk);
	JScrollPane 	jsp_sungjuk = new JScrollPane(jt_sungjuk);
	String strData[][] = {
			{"김유신","80","61","70"}
			,{"이성계","60","67","62"}
			,{"이순신","70","87","90"}
			,{"홍길동","82","65","83"}
			,{"강감찬","82","52","87"}
	};
	
	public SungJuk() {
		initDisplay();
	}
	
	public void start() {
		jbtn_account.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_inwon.addActionListener(this);
		jbtn_data.addActionListener(this);
		jbtn_ran.addActionListener(this);
	}
	public void initDisplay() {
		start();
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb_su);
		jf_sungjuk.add("North",jp_north);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
	//@Overrid는 어노테이션이라고 읽음 -ActionListener가 가진 추상 메소드를
	@Override 
	public void actionPerformed(ActionEvent e) {
		//insert here
		Object obj = e.getSource();
		if(obj==jtf_inwon) {
			String inwon = jtf_inwon.getText();
			rowNum = Integer.parseInt(inwon);
			System.out.println(rowNum);
			jsp_sungjuk.setVisible(true);
			dtm_sungjuk.setRowCount(0);
			dtm_sungjuk.setRowCount(rowNum);
			jt_sungjuk.setModel(dtm_sungjuk);
			jt_sungjuk.setEditingColumn(4);
			jf_sungjuk.pack();
			Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension di2 = jf_sungjuk.getSize();
			
			jf_sungjuk.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
			jtf_inwon.setText("");
		}else if(obj==jbtn_account) {
			
			sungjuk=new String[rowNum][4];
			for(int i =0;i<sungjuk.length;i++) {
				for(int j=0;j<sungjuk[i].length;j++) {
					sungjuk[i][j] = (String) dtm_sungjuk.getValueAt(i,j);
					if(sungjuk[i][j]==null) {
						JOptionPane.showMessageDialog(jf_sungjuk, "모든 값을 입력해 주세요."+i+","+j);
						return;
					}
					
				}
			}
			int total[] = total(sungjuk);
			double avg[] = average(total);
			int rank[] = ranking(avg);
			for(int i=0;i<sungjuk.length;i++) {
				dtm_sungjuk.setValueAt(total[i], i,4);
				dtm_sungjuk.setValueAt(avg[i], i, 5);
				dtm_sungjuk.setValueAt(rank[i], i, 6);
			}
		}else if(obj==jbtn_exit) {
			System.exit(0);
		}else if(obj==jbtn_data) {
			if(rowNum!=strData.length) {
				JOptionPane.showMessageDialog(jf_sungjuk, "저장되어 있는 값의 크기는"+strData.length+"입니다");
				return;
			}
			for(int i=0;i<strData.length;i++) {
				for(int j=0;j<strData[i].length;j++) {
					dtm_sungjuk.setValueAt(strData[i][j], i, j);
				}
				
			}
		}else if(obj == jbtn_ran) {
			if(rowNum==0) {
				JOptionPane.showMessageDialog(jf_sungjuk, "크기를 지정해주세요");
				return;
			}
			sungjuk=new String[rowNum][4];
			Random rd = new Random();
			for(int i=0;i<sungjuk.length;i++) {
				for(int j=1;j<sungjuk[i].length;j++) {
					sungjuk[i][0]=new RandomName().name;
					sungjuk[i][j]=Integer.toString(rd.nextInt(100));
				}
			}
			for(int i=0;i<sungjuk.length;i++) {
				for(int j=0;j<sungjuk[i].length;j++) {
					dtm_sungjuk.setValueAt(sungjuk[i][j], i, j);
				}
			}
		}
	}
	public int[] total(String sungjuk[][]) {
		int[] total = new int[rowNum];
		int sum = 0;
		for(int i = 0 ; i <sungjuk.length;i++) {
			sum=0;
			for(int j = 1; j<sungjuk[i].length ;j++) {
				sum += Integer.parseInt(sungjuk[i][j]);
			}
			total[i]=sum;
		}
		return total;
	}
	
	public double[] average(int total[]) {
		double avg[] = new double[rowNum];
		for(int i=0;i<avg.length;i++) {
			avg[i]=total[i]/3.0;
		}
		return avg;
	}
	
	public int[] ranking(double avg[]) {
		int rank[] = new int[rowNum];
		for(int i =0;i<rank.length;i++) {	// 0등이 아니라 1등부터 이므로 ,모든 순위를 1로 초기화
			rank[i]=1;
		}
		
		for(int i=0;i<rank.length;i++) {	//순위를 주기위한 반복
			for(int j=0;j<rank.length;j++) {
				if(avg[i]<avg[j]) {//자기 자신보다 높은 점수가 있으면 
					rank[i]+=1;			//순위가 1씩 밀려난다
				}
			}
		}
		return rank;
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new SungJuk();
	}
}
