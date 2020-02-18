package method.temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.util.*;
import oracle.jdbc2.ZipCodeVO;

public class SeoulTempView2{
	//선언부
	SeoulTempEvent2 ste2 = new SeoulTempEvent2(this);
	String month = null;
	String year = null;
	String			textField		= "날짜를 입력하세요.";
	String 				years[]		= null;
	String				months[]    = null;
	JComboBox<String>	jcb_year	= null;
	JComboBox<String>   jcb_month	= null;
	JTextField 			jtf_date 	= new JTextField(textField);
	JButton 			jbtn_search = new JButton("조회");
	String				cols[]		= {"날짜","최저온도","최고온도"};
	String				data[][]	= new String[0][3];
	DefaultTableModel   dtm_temp 	= new DefaultTableModel(data,cols);
	JTable 				jt_temp 		= new JTable(dtm_temp);
	JScrollPane 		jsp_temp		= new JScrollPane(jt_temp);
	JTableHeader		jth_temp		= new JTableHeader();
	JFrame 				jf_temp 		= new JFrame();
	JPanel				jp_north	= new JPanel();
	ArrayList  as = new ArrayList();
	
	//생성자
	public SeoulTempView2() {
		//생성자에서 메소드를 호출할 수 있다.
		years=ste2.stl.getYear();
		jcb_year =new JComboBox<String>(years);
		initDisplay();
	}
	
	public void actionListener() {
		jbtn_search.addActionListener(ste2);
		jtf_date.addActionListener(ste2);
		jtf_date.addFocusListener(ste2);
		jcb_year.addItemListener(ste2);
		jcb_month.addItemListener(ste2);
	}
	//화면처리부
	public void initDisplay() {
		System.out.println("initDisplay호출 성공");
		
		jth_temp = jt_temp.getTableHeader();
		jth_temp.setBackground(new Color(100,22,100));
		jth_temp.setForeground(Color.white);
		jth_temp.setFont(new Font("맑은고딕",Font.BOLD,15));
		jt_temp.setGridColor(Color.GREEN);
		//그리드의 높이 변경하기
		jt_temp.setRowHeight(20);
		//컬럼의 너비 조정하기
		jt_temp.getColumnModel().getColumn(0).setPreferredWidth(300);
		//선택한 row의 배경색이나 글자색 변경하기
		jt_temp.setSelectionBackground(new Color(133,142,120));
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_search를 붙인다.
		//이렇게 동,서,남,북,중앙 에 버튼을 배치하고 싶으면 BorderLayout을 사용함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.RED);
		jp_north.add(jcb_year);
		jcb_month= new JComboBox<String>();
		jp_north.add(jcb_month);
		jp_north.add(jtf_date);
		jp_north.add(jbtn_search);
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자.
		//속지안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다.
		jf_temp.add("North",jp_north);
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerfomed)를 연결해준다.
		
		jf_temp.add("Center",jsp_temp);
		actionListener();
		jf_temp.setTitle("서울기후통계 검색");
		jf_temp.setSize(600,500);
		jf_temp.setVisible(true); 
		
	}
	//전체조회 혹은 조건검색 하기 구현
	//insert here
	//메인메소드
	public static void main(String[] args) {
		new SeoulTempView2();
		
	}
}
