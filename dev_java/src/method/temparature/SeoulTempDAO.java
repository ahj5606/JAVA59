package method.temparature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class SeoulTempDAO {
	/*
	 * 서울 기상통계 정보로 부터 최금 10년도 정보 가져오기
	 */
	DBConnectionMgr		dbMgr		= DBConnectionMgr.getInstance();
	Connection 			con 	= null; 
	PreparedStatement 	pstmt 	= null;
	ResultSet			rs			= null;
	public String[] getYearList() {
		
		con = null;
		pstmt = null;
		rs = null;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder();
		Vector<String> v = new Vector<>();
		String years[] = null;
		sb.append("SELECT DISTINCT(TO_CHAR(TO_DATE(sdate),'YYYY')) ta_year            ");
		sb.append("  FROM seoultemp                                                   ");
		sb.append(" WHERE TO_CHAR(TO_DATE(sdate),'YYYY') > TO_CHAR(sysdate,'YYYY') -11");
		sb.append("ORDER BY ta_year asc                                               ");
		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String year = rs.getString("ta_year");
				v.add(year);
			}
			years=new String[v.size()];
			v.copyInto(years);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return years;
	}

}
