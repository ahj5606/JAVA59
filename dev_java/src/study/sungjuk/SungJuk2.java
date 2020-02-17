package study.sungjuk;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.sun.javafx.tk.Toolkit;

import javafx.scene.layout.Border;

public class SungJuk2 implements ActionListener{
	int rowNum = 0; 
	String sungjuk[][] = null;
	JLabel jlb_su = new JLabel(" 명          ");
	JLabel jlb_inwon = new JLabel("    인 원 수       ");
	JTextField jtf_inwon = new JTextField(15);
	JButton jbtn_data = new JButton("데이터 불러오기");
	JButton jbtn_account = new JButton("처 리");
	JButton jbtn_exit = new JButton("종 료");
	JFrame jf_sungjuk = new JFrame();
	JPanel jp_north = new JPanel();
	JPanel jp_south = new JPanel();
	JPanel jp_center = new JPanel();
	String				cols[]		= {"이름","자바","오라클","HTML","총점","평균","등수"};
	String				data[][]	= null;
	DefaultTableModel  dtm_sungjuk = null;
	JTable 				jt_sungjuk 		= null;
	JScrollPane 	jsp_sungjuk =null;
	String strData[][] = {
			{"김유신","80","61","70"}
			,{"이성계","60","67","62"}
			,{"이순신","70","87","90"}
			,{"홍길동","82","65","83"}
			
	};
	//초기화 할 수 있니?
	//2중 for문 활용할 수 있는거야?
	//사용자가 입력한 인원수를 담을 변수 입니다.
	//전역변수로 한 이유는 인원수를 듣기에는 jtf_inwon에서 엔터쳤을 때 값이 결정됩니다.
	//그 때 결정된 3이 jbtn_account에서도 필요합니다.
	//왜냐하면 총점을 기준으로 석차를 구하기로 결정되었으므로 총점과 석차를 같이 관리할
	//2차 배열을 선언하였기 때문입니다.
	//생성자
	public SungJuk2() {
		initDisplay();
	}
	public void start() {
		jbtn_account.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jtf_inwon.addActionListener(this);
		jbtn_data.addActionListener(this);
	}
	public void initDisplay() {
		start();
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb_su);
		jf_sungjuk.add("North",jp_north);
		jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_south.add(jbtn_data);
		jp_south.add(jbtn_account);
		jp_south.add(jbtn_exit);
		jf_sungjuk.add("South",jp_south);
		jf_sungjuk.setTitle("성적처리");
		jf_sungjuk.setSize(600, 400);
		jf_sungjuk.setVisible(true);
	}
	//@Overrid는 어노테이션이라고 읽음 -ActionListener가 가진 추상 메소드를
	//그대로 가져다가 재정의해서 사용하시오.
	//methodA();
	@Override 
	public void actionPerformed(ActionEvent e) {
		//insert here
		Object obj = e.getSource();
		if(obj==jtf_inwon) {
			String inwon = jtf_inwon.getText();
			rowNum = Integer.parseInt(inwon);
			data= new String[rowNum][7];
			System.out.println(rowNum);
			dtm_sungjuk = new DefaultTableModel(data,cols);
			jt_sungjuk = new JTable(dtm_sungjuk);
			jsp_sungjuk =  new JScrollPane(jt_sungjuk);
			jf_sungjuk.add("Center",jsp_sungjuk);
			
			Dimension di = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension di2 = jf_sungjuk.getSize();
			
			jf_sungjuk.setLocation((int)(di.getWidth()/2-di2.getWidth()/2), (int)(di.getHeight()/2-di2.getHeight()/2));
			
			
//			dtm_sungjuk.setRowCount(0);
//			dtm_sungjuk.setRowCount(rowNum);
			jf_sungjuk.pack();
			jtf_inwon.setText("");
		}else if(obj==jbtn_account) {
			//총점과 석차가 들어갈 공간을 할당하기
			//인원수는 어떻게 가져오지? - 전역변수로 선언하고 사용하는게 좋겠어
			//왜냐면 다른 이벤트에서도 필요하기 때문이지
			sungjuk=new String[rowNum][4];
			
			for(int i =0;i<sungjuk.length;i++) {
				for(int j=0;j<sungjuk[i].length;j++) {
					sungjuk[i][j] = (String) dtm_sungjuk.getValueAt(i,j);
					if(sungjuk[i][j]==null) {
						JOptionPane.showMessageDialog(jf_sungjuk, i+","+j+"  모든 값을 입력해 주세요.");
						return;
					}
					
				}
			}
			double total[] = total(sungjuk);
			double avg[] = average(total);
			int rank[] = ranking(avg);
			dtm_sungjuk.setRowCount(0);
			for(int i=0;i<rowNum;i++) {
				Vector oneRow = new Vector();
				oneRow.add(0,sungjuk[i][0]);
				oneRow.add(1,sungjuk[i][1]);
				oneRow.add(2,sungjuk[i][2]);
				oneRow.add(3,sungjuk[i][3]);
				oneRow.add(4,total[i]);
				oneRow.add(5,avg[i]);
				oneRow.add(6,rank[i]);
				dtm_sungjuk.addRow(oneRow);
			}
		}else if(obj==jbtn_exit) {
			System.exit(0);
		}else if(obj==jbtn_data) {
			dtm_sungjuk.setRowCount(0);
			if(rowNum!=strData.length) {
				JOptionPane.showMessageDialog(jf_sungjuk, "저장되어 있는 값의 크기는"+strData.length+"입니다");
				return;
			}
			for(int i=0;i<strData.length;i++) {
				Vector oneRow = new Vector();
				oneRow.add(0,strData[i][0]);
				oneRow.add(1,strData[i][1]);
				oneRow.add(2,strData[i][2]);
				oneRow.add(3,strData[i][3]);
				
				dtm_sungjuk.addRow(oneRow);
			}
		}
	}
	public double[] total(String sungjuk[][]) {
		double[] total = new double[rowNum];
		double sum = 0;
		for(int i = 0 ; i <sungjuk.length;i++) {
			sum=0;
			for(int j = 1; j<sungjuk[i].length ;j++) {
				sum += Integer.parseInt(sungjuk[i][j]);
			}
			total[i]=sum;
		}
		
		
		return total;
	}
	public double[] average(double total[]) {
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
		new SungJuk2();
	}
}
