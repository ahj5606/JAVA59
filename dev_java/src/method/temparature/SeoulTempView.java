package method.temparature;

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

public class SeoulTempView implements ActionListener{
	//선언부
	Connection 			con 	= null; 
	PreparedStatement 	pstmt 	= null;
	ResultSet			rs			= null;
	JTextField 			jtf_date 	= new JTextField("날짜를 입력하세요.");
	JButton 			jbtn_search = new JButton("조회");
	String				cols[]		= {"날짜","최저온도","최고온도"};
	String				data[][]	= new String[4][3];
	DefaultTableModel   dtm_zip 	= new DefaultTableModel(data,cols);
	JTable 				jt_zip 		= new JTable(dtm_zip);
	JScrollPane 		jsp_zip		= new JScrollPane(jt_zip);
	JTableHeader		jth_zip		= new JTableHeader();
	JFrame 				jf_zip 		= new JFrame();
	JPanel				jp_north	= new JPanel();
	JComboBox			jcb_year	= null;
	JComboBox			jcb_month	= null;
	String				years[]		= null; //오라클 서버 경유해서 반환 받는 값으로 초기화
	SeoulTempDAO		stDao		= new SeoulTempDAO();
	//생성자
	public SeoulTempView() {
		//오라클 서버 경유하기
		years=stDao.getYearList();
		//오라클 서버 경유하고 나서 받은 리턴값으로 콤보박스 인스턴스화 하기
		jcb_year = new JComboBox(years);
		//생성자에서 메소드를 호출할 수 있다.
		
		initDisplay();
	}
	//화면처리부
	public void initDisplay() {
		System.out.println("initDisplay호출 성공");
		
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(100,22,100));
		jth_zip.setForeground(Color.white);
		jth_zip.setFont(new Font("맑은고딕",Font.BOLD,15));
		jt_zip.setGridColor(Color.GREEN);
		//그리드의 높이 변경하기
		jt_zip.setRowHeight(20);
		//컬럼의 너비 조정하기
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(300);
		//선택한 row의 배경색이나 글자색 변경하기
		jt_zip.setSelectionBackground(new Color(133,142,120));
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_search를 붙인다.
		//이렇게 동,서,남,북,중앙 에 버튼을 배치하고 싶으면 BorderLayout을 사용함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.RED);
		jbtn_search.addActionListener(this);
		jtf_date.addActionListener(this);
		jp_north.add(jcb_year);
		jp_north.add(jtf_date);
		jp_north.add(jbtn_search);
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자.
		//속지안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다.
		jf_zip.add("North",jp_north);
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerfomed)를 연결해준다.
		
		jf_zip.add("Center",jsp_zip);
		jf_zip.setTitle("서울기후통계 검색");
		jf_zip.setSize(600,500);
		jf_zip.setVisible(true); 
		
	}
	//전체조회 혹은 조건검색 하기 구현
	//insert here
	public void refreshData(String myDong) {
		System.out.println("refreshData호출 성공"+myDong);
		String sql="";
		sql+="SELECT address , zipcode";
		sql+=" FROM zipcode_t";
		if(myDong !=null||myDong.length()>0) {
			System.out.println("if문 호출 myDong.length : "+myDong.length());
			sql+=" WHERE dong LIKE '%'||?||'%'";
		}
		Vector<ZipCodeVO> v = new Vector<>();
		ZipCodeVO zcVOS[] =null;
		ZipCodeVO zcVO =null;
		DBConnectionMgr dm = DBConnectionMgr.getInstance();
		dm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,myDong);
			rs = pstmt.executeQuery();
			while(rs.next()) {//커서이동,커서이동
				zcVO= new ZipCodeVO();
				//System.out.println(rs.getString("주소"));
				zcVO.setAddress(rs.getString("address"));
				zcVO.setZipcode(rs.getInt("zipcode"));
				v.add(zcVO);
			}
			zcVOS =new ZipCodeVO[v.size()];
			v.copyInto(zcVOS); 
			System.out.println("v.size()"+v.size()+", " +zcVOS.length);
			
			if(v.size()>0) { //조회된 결과가 있니?
				//조회결과가 있다면 데이트를 DefaultTableModel에 담아주어야 함니다.
				//그래야 JTable에서 그리드 에 출력된 결과를 볼 수 있기 때문입니다.
				//그런데 컬럼을 하나씩 각각 개발자가 일일이 초기화 해주는건 너무 불편합니다.
				dtm_zip.setRowCount(0);
				for(int i=0;i<v.size();i++) {
				//그래서 for 문 안에서 백터를 하나 더 생성했어요
				//addRow라는 메소드가 있는데 이 파라미터에 Vector를 넣으면 한개로우씩
				//추가 해준다고 합니다.
					Vector oneRow = new Vector();
					oneRow.add(0,zcVOS[i].getAddress());
					oneRow.add(1,zcVOS[i].getZipcode());
					dtm_zip.addRow(oneRow);
//					dtm_zip.addRow(new Object[] {zcVOS[i].getAddress(),zcVOS[i].getZipcode()});
					
				}				
			}
			
		} catch (SQLException se) {
			//테이블이 존재하지 않습니다. - 테이블을 만들지 않았네
			//혹은 부적합한 식별자 - 컬럼명이 맞지 않았습니다.
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//그 밖의 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
		
	}
	//메인메소드
	public static void main(String[] args) {
		new SeoulTempView();
		
	}
	public void actionPerformed(ActionEvent ae) {
		
	}
}
