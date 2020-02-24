package method.zipcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.*;
//implements 뒤에 오는 이름 모두 인터페이스
//인터페이스는 추상메소드만 가지고 있다. 메소드 뒤에 세미콜론으로 끝남.
// void(int) methodA();
//인터페이스는 단독으로 인스턴스화를 할 수 없다.
//ItemListener item = new ItemListener(); <- X
//ItemListener item = new ZipCodeSearchApp(); <- O
//인터페이스는 반드시 구현체 클래스가 있어야 한다.
//구현체 클래스가 되기 위한 필요조건은 반드시 추상메소드를 구현해주어야 한다. @Override 
public class ZipCodeSearchApp implements ActionListener, FocusListener, ItemListener{
/* 모든 클래스에 메인메소드가 있다면 이 메소드가 시작점이다.
 * 이것보다 먼저 초기화 되는 코드들이 있다. 이것이 전변이다. 
 */
	//사용자가 콤보박스에서 선택한 정보를 담을 변수 선언
	//선택은 이벤트 쪽에서 처리되므로 전역변수로 해야 그 값을 유지할 수 있고
	//또 조회메소드에서 그 값을 사용할 수 있을 것이다.
	String				zdo			= null;
	String 				zdos[] 		= null;
	JComboBox<String> 	jcb_zdo 	= null;
	JComboBox<String> 	jcb_sigu 	= null;
	String 				sigu	= null;
	String 				sigus[]	= null;
	//선언부 - 전역변수는 초기화를 생성자가 해준다
	Connection 			con 	= null; //전역변수 선언하기 -클래스 전역에서 사용가능함
	//오라클 서버에 쿼리문을 전달하고 너가 좀 처리해 줄래
	PreparedStatement 	pstmt 	= null;
	//오라클에는 일꾼이 살고 있는데 이름은 옵티마이저라고 함.
	//데이터를 찿을 때는 커서를 움직이면서 조회결과가 존재하는지 확인하고 그 로우에 있는 값들을
	//RAM메모리 영역에 올린다. 커서를 조작하면서 해당 로우에 있는 값을 꺼낼 수 있다.
	ResultSet			rs			= null;
	DBConnectionMgr		dbMgr		= DBConnectionMgr.getInstance();
	JTextField 			jtf_dong 	= new JTextField("동이름을 입력하세요.");
	JButton 			jbtn_search = new JButton("조회");
	JButton				jbtn_del = new JButton("삭제");
	//오라클에서 조회한 결과를 담을 클래스 선언하기
	//테이블의 헤더 설정하기
	String				cols[]		= {"주소","우편번호"};
	String				data[][]	= new String[0][2];
	//생성자에는 파라미터를 가질 수 있다.
	//첫번째 파라미터는 데이터영역을 표시하는 주소번지
	//두번째 파라미터는 테이블 헤더 영역에 해당하는 주소번지
	//파라미터의 갯수에 따라서 서로 다른 생성자를 선언하는 것도 가능하다는 것인가?
	DefaultTableModel   dtm_zip 	= new DefaultTableModel(data,cols);
	//테이블 양식 그려줌
	JTable 				jt_zip 		= new JTable(dtm_zip);
	JScrollPane 		jsp_zip		= new JScrollPane(jt_zip);
	JTableHeader		jth_zip		= new JTableHeader();
	JFrame 				jf_zip 		= new JFrame();//운영체제위에 창을 띄운다.
	JPanel				jp_north	= new JPanel();//속지를 만들어 준다.
	//생성자 - 리턴타입이 없다. 클래스 이름과 동일하다.
	public ZipCodeSearchApp() {
		//인스턴스화를 할 때마다 생성자도 같은 횟수만큼 호출이 일어난다.
		//new A()와 같이 했을때 객체가 RAM에 로딩(상주:기억)되면서 동시에 생성자가 호출됨.
		zdos = getZdos();
		jcb_zdo = new JComboBox<String>(zdos);
		initDisplay();
		System.out.println("나는 파라미터가 없느 디폴트 생성자라고 해.");
		System.out.println("나는 인스턴스화 하면 자동으로 호출이 되는 거야.");
	}
	public ZipCodeSearchApp(String str , int i) {
		
	}
	//물리적으로 떨어져 있는 오라클 서버와 연결통로 만들기
	//새로 고침 기능을 구현해 보자 -SELECT
	public Vector<ZipCodeVO> refreshData(String myDong,String zdo,String sigu) {
		con=null;
		int col=1;
		int orderby=0;
		System.out.println("입력한 동 : "+myDong);
		StringBuilder sb = new StringBuilder("");
		sb.append("SELECT address , zipcode ");
		sb.append(" FROM zipcode_t");
		sb.append(" WHERE 1=1 ");
		Vector<ZipCodeVO> v = null;
		ZipCodeVO zcVOS[] =null;
		ZipCodeVO zcVO =null;
		con = dbMgr.getConnection();
		try {
			if(zdo !=null&&zdo.length()>0) {
				sb.append(" AND zdo = ?");
			}
			if(myDong !=null&&myDong.length()>0) {
				sb.append(" AND dong LIKE '%'||?||'%'");
			}
			if(sigu !=null && sigu.length()>0) {
				sb.append("AND sigu =?");
			}
			sb.append(" ORDER BY zipcode asc");
			
			pstmt = con.prepareStatement(sb.toString());
			if(zdo !=null&&zdo.length()>0) {
				pstmt.setString(col++,zdo);
			}
			if(myDong !=null&&myDong.length()>0) {
				pstmt.setString(col++,myDong);
			}
			if(sigu !=null && sigu.length()>0) {
				pstmt.setString(col++, sigu);
			}
			 v = new Vector<>();
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
				while(dtm_zip.getRowCount()>0) {
					dtm_zip.removeRow(0);
					
				}
				//조회결과가 있다면 데이트를 DefaultTableModel에 담아주어야 함니다.
				//그래야 JTable에서 그리드 에 출력된 결과를 볼 수 있기 때문입니다.
				//그런데 컬럼을 하나씩 각각 개발자가 일일이 초기화 해주는건 너무 불편합니다.
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
			se.printStackTrace();
			System.out.println("[[query]]"+sb.toString());
		} catch(Exception e) {//그 밖의 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
		return v;
	}
	
	public String[] getZdos() {
		con = null;
		pstmt = null;
		rs = null;
		String zdos[]=null;
		Vector<String> v = new Vector<>();
		StringBuilder sb = new StringBuilder("");
		//자바코드는 이클립스에서 디버깅 하고 select문 토드에서 디버깅 하기.
		sb.append("SELECT '전체' zdo FROM dual\r\n" + 
				"UNION ALL\r\n" + 
				"SELECT zdo\r\n" + 
				"  FROM (\r\n" + 
				"SELECT DISTINCT(zdo) \r\n" + 
				"  FROM zipcode_t \r\n" + 
				"ORDER BY ZDO ASC\r\n" + 
				"  )");
		sb.append("");
		try { 
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
		} catch (Exception e) {
//stack영역에 관리되는 에러메시지 정보를 라인번호와 이력까지 출력해줌.
			e.printStackTrace();
		}
		zdos = new String[v.size()];
		v.copyInto(zdos);
		
		return zdos;
	}
	public String[] getSigu(String zdo) {
		con = null;
		pstmt = null;
		rs = null;
		String sigus[]=null;
		Vector<String> v = new Vector<>();
		StringBuilder sb = new StringBuilder("");
		//자바코드는 이클립스에서 디버깅 하고 select문 토드에서 디버깅 하기.
		sb.append("select '전체' as sigu from dual union all SELECT DISTINCT(sigu) as sigu  FROM zipcode_t");
		if(zdo!=null&&zdo.length()>0) {
			sb.append(" WHERE zdo =?");
		}
		try { 
			con = dbMgr.getConnection();
			
			
			pstmt = con.prepareStatement(sb.toString());
			
			if(zdo!=null&&zdo.length()>0) {
				pstmt.setString(1, zdo);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
		} catch (Exception e) {
//stack영역에 관리되는 에러메시지 정보를 라인번호와 이력까지 출력해줌.
			e.printStackTrace();
		}
		sigus = new String[v.size()];
		v.copyInto(sigus);
		
		return sigus;
	}
	//화면그리기
	public void initDisplay() {
		System.out.println("initDisply호출 성공");
		//테이블 헤더 영역에 배경색 바꿔볼까?
		zdos = getZdos();
		jcb_zdo = new JComboBox<String>(zdos);
		jth_zip = jt_zip.getTableHeader();
		sigus =getSigu(zdo);
		jcb_sigu = new JComboBox<String>(sigus);
		jth_zip.setBackground(new Color(100,22,100));
		jth_zip.setForeground(Color.white);
		jth_zip.setFont(new Font("맑은고딕",Font.BOLD,20));
		jt_zip.setGridColor(Color.GREEN);
		//그리드의 높이 변경하기
		jt_zip.setRowHeight(20);
		//컬럼의 너비 조정하기
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350);
		//선택한 row의 배경색이나 글자색 변경하기
		jt_zip.setSelectionBackground(new Color(133,142,120));
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_search를 붙인다.
		//이렇게 동,서,남,북,중앙 에 버튼을 배치하고 싶으면 BorderLayout을 사용함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.RED);
		jcb_zdo.addItemListener(this);
		jbtn_search.addActionListener(this);
		jbtn_del.addActionListener(this);
		jtf_dong.addActionListener(this);
		jtf_dong.addFocusListener(this);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jtf_dong);
		jp_north.add(jbtn_search);
		jp_north.add(jbtn_del);
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자.
		//속지안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다.
		jf_zip.add("North",jp_north);
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerfomed)를 연결해준다.
		jf_zip.add("Center",jsp_zip);
		jf_zip.setTitle("우편번호 검색");
		jf_zip.setSize(600,500);
		jf_zip.setVisible(true); 		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 감지된 버튼의 주소번지를 읽어오는 메소드임.
		Object obj = ae.getSource();
		if((obj==jbtn_search)||(obj == jtf_dong)) {
			zdo=(String)jcb_zdo.getSelectedItem();
			if(zdo.equals("전체")) {
				zdo = null;
			}
			sigu=(String)jcb_sigu.getSelectedItem();
			if(sigu.equals("전체")) {
				sigu = null;
			}
				
			
			System.out.println("선택된 시/도 : "+zdo);
			String myDong = jtf_dong.getText();
			jtf_dong.setText("");
			try {
				//자바에서는 같은 이름의 메소드를 정의할 수 있다.
				//단 파라미터의 갯수가 다르거나 파라미터의 타입이 반드시 달라야 한다.
				refreshData(myDong,zdo,sigu);
			} catch (Exception e) {
			}
		}else if(obj==jbtn_del) {
			int index[] = jt_zip.getSelectedRows();
			
			for(int row :index) {
				JOptionPane.showMessageDialog(jf_zip, row);
				dtm_zip.removeRow(row);
			}
		}
	}
	//메인메소드
	public static void main(String[] args) {
		new ZipCodeSearchApp();
	}
	@Override
	public void focusGained(FocusEvent e) {
		Object obj = e.getSource();
		if(obj == jtf_dong) {
			jtf_dong.setText("");
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		
		Object obj = e.getSource();
		if(obj == jtf_dong) {
			jtf_dong.setText("동 이름을 입력하세요");
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == jcb_zdo) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				zdo=zdos[jcb_zdo.getSelectedIndex()];
				
				if(zdo.equals("전체")) {
					sigus = getSigu(null);
					jcb_sigu.removeAllItems();
					
					for(int i= 0 ; i<sigus.length;i++) {
						jcb_sigu.addItem(sigus[i]);
					}
				}else {
					sigus = getSigu(zdo);
					jcb_sigu.removeAllItems();
					for(int i= 0 ; i<sigus.length;i++) {
						jcb_sigu.addItem(sigus[i]);
					}
				}
				System.out.println("선택 : "+(String)jcb_zdo.getSelectedItem());
				
				System.out.println(zdos[jcb_zdo.getSelectedIndex()]);
			}
		}
	}
}

