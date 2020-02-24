package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

public class TdeptManager extends JFrame{
	String cols[] = {"사번","이름","부서"};
	String data[][] = new String[0][3];
	DefaultTableModel dtm_order = new DefaultTableModel(data,cols);
	//서로 연관(의존성)이 있는 클래스 사이에서 별도의 메소드나 코딩 없이
	//생성자의 파라미터를 통해서 값을 초기화 할 수 있다.
	JTable jt_order = new JTable(dtm_order);
	JScrollPane jsp_order = new JScrollPane(jt_order);
	public TdeptManager() {}
	public void initDisplay() {
		ArrayList<TempVO> al= result();
		for(int i=0 ; i<al.size();i++) {
			Vector v = new Vector();
			v.add(al.get(i).getEmp_id());
			v.add(al.get(i).getEmp_name());
			v.add(al.get(i).getDeptname());
			dtm_order.addRow(v);
		}
		this.add(jsp_order);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("사원정보 조회");
		this.setSize(500,400);
		this.setVisible(true);
	}
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con =null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;
	
	public ArrayList<TempVO> result() {
		
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");                               
		sb.append("SELECT e.emp_id id , e.emp_name ename ,d.dept_name  dname");
		sb.append("  FROM temp e , tdept d                   ");
		sb.append(" WHERE e.dept_code = d.dept_code          ");
		ArrayList<TempVO> al = new ArrayList();
		TempVO tVO= null;
		TempVO tVOs[] = null;
		try {
			pstmt=con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			//VO는 한번에 한 개 로우만 담을 수 있어요. 두 개 로우는 안되죠.
			//VO에는 변수에 하나에 한 개값만 담는 변수를 선언했기 때문이죠.
			while(rs.next()) {
				tVO= new TempVO();
				tVO.setEmp_id(rs.getInt("id"));
				tVO.setEmp_name(rs.getString("ename"));
				tVO.setDeptname(rs.getString("dname"));
				al.add(tVO);
			}
			
			tVOs = new TempVO[al.size()];
			
			for(int i = 0 ; i<al.size();i++) {
				tVOs[i]=al.get(i);
			}
		}catch (SQLException se) { //오라클에서 발생되는 에러메시지 잡기
			se.printStackTrace();
		} catch (Exception e) { //자바전체에서 발생되는 에러메시지 잡기
			e.printStackTrace();
		}finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return al; // null값으로 리턴될 가능성이 음
	}
	public static void main(String[] args) {
		TdeptManager tm = new TdeptManager();
		tm.initDisplay();
	}
}
