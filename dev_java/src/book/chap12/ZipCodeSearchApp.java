package book.chap12;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.*;
public class ZipCodeSearchApp implements ActionListener, FocusListener, ItemListener{
	String				zdo			= null;
	String 				zdos[] 		= null;
	JComboBox<String> 	jcb_zdo 	= null;
	JComboBox<String> 	jcb_sigu 	= null;
	String 				sigu	= null;
	String 				sigus[]	= null;
	Connection 			con 	= null; //전역변수 선언하기 -클래스 전역에서 사용가능함
	PreparedStatement 	pstmt 	= null;
	ResultSet			rs			= null;
	DBConnectionMgr		dbMgr		= DBConnectionMgr.getInstance();
	JTextField 			jtf_dong 	= new JTextField("동이름을 입력하세요.");
	JButton 			jbtn_search = new JButton("조회");
	JButton				jbtn_del = new JButton("삭제");
	String				cols[]		= {"주소","우편번호"};
	String				data[][]	= new String[0][2];
	DefaultTableModel   dtm_zip 	= new DefaultTableModel(data,cols);
	JTable 				jt_zip 		= new JTable(dtm_zip);
	JScrollPane 		jsp_zip		= new JScrollPane(jt_zip);
	JTableHeader		jth_zip		= new JTableHeader();
	JFrame 				jf_zip 		= new JFrame();//운영체제위에 창을 띄운다.
	JPanel				jp_north	= new JPanel();//속지를 만들어 준다.
	public ZipCodeSearchApp() {
		zdos = getZdos();
		jcb_zdo = new JComboBox<String>(zdos);
		initDisplay();
		System.out.println("나는 파라미터가 없느 디폴트 생성자라고 해.");
		System.out.println("나는 인스턴스화 하면 자동으로 호출이 되는 거야.");
	}
	public ZipCodeSearchApp(String str , int i) {
		
	}
	public List<Map<String,Object>> refreshData(String myDong,String zdo,String sigu) {
		con=null;
		int col=1;
		int orderby=0;
		System.out.println("입력한 동 : "+myDong);
		StringBuilder sb = new StringBuilder("");
		sb.append("SELECT address , zipcode ");
		sb.append(" FROM zipcode_t");
		sb.append(" WHERE 1=1 ");
		List<Map<String,Object>> addrList = new ArrayList<Map<String,Object>>();
		Map<String,Object> rMap =null;
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
			rs = pstmt.executeQuery();
			while(rs.next()) {//커서이동,커서이동
				rMap= new HashMap<String, Object>();
				rMap.put("address",rs.getString("address"));
				rMap.put("zipcode",rs.getInt("zipcode"));
				addrList.add(rMap);
			}
			if(addrList.size()>0) { //조회된 결과가 있니?
				while(dtm_zip.getRowCount()>0) {
					dtm_zip.removeRow(0);
					
				}
				for(int i=0;i<addrList.size();i++) {
					Map<String, Object> map = addrList.get(i);
					Vector oneRow = new Vector();
					
					oneRow.add(0,map.get("address"));
					oneRow.add(1,map.get("zipcode"));
					
					dtm_zip.addRow(oneRow);
					
				}				
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("[[query]]"+sb.toString());
		} catch(Exception e) {//그 밖의 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
		return addrList;
	}
	
	public String[] getZdos() {
		con = null;
		pstmt = null;
		rs = null;
		String zdos[]=null;
		Vector<String> v = new Vector<>();
		StringBuilder sb = new StringBuilder("");
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
		jt_zip.setRowHeight(20);
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350);
		jt_zip.setSelectionBackground(new Color(133,142,120));
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
		jf_zip.add("North",jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setTitle("우편번호 검색");
		jf_zip.setSize(600,500);
		jf_zip.setVisible(true); 		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
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

