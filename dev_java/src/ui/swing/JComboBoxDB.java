package ui.swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class JComboBoxDB {
	private DBConnectionMgr dbMgr =	DBConnectionMgr.getInstance();
	private Connection con = null;//물리적으로 떨어져있는 서버와 연결통로 만들기
	private PreparedStatement pstmt = null;//연결통로가 만들어지면 그 길을 따라 select문을 오라클에 전달
	private ResultSet rs = null;//커서 이동
	public String dnames[] =null;//전역변수로 생성자 사용해서 바로 DB읽은 결과 받기
	private String[] getDeptList() {
		String dnames[] =null;
		//쿼리문을 작성할 때 여로 로우가 나올 수 있는대 String을 사용하면 원본이 바뀌지
		//않아서 자바성능튜닝팀에서 못쓰게합니다.
		//대신 StringBuilder를 사용하라고 권장하죠
		//이 클래스는 원본이 바뀌기 떄문에 불필요한 자원낭비를 막을 수 있어요
		//서버 입장에서는 동시 접속자 수가 많아서 작은 양이지만 큰 문제를 일으킬 수도 잇다고 합니다.
		StringBuilder sb = new StringBuilder("");
		Vector<String> v = new Vector<>();
		sb.append("SELECT dname FROM dept ");
		//예외가 발생되면 시스템이 멈춰 서 있게 됩니다.
		//무한이 기다리는 상황이 발생되므로 다음 사람도 이용할 수 없다.
		try {//물리적으로 떨어져 있는 서버에 ip주로소 접근하니까 예외가 발생할 가능성이 있음.
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String dname=rs.getString("dname");;
				v.add(dname);
			}
			dnames = new String[v.size()];
			v.copyInto(dnames);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dnames;
	}
	JComboBoxDB(){
		this.dnames=getDeptList();
	}
}
