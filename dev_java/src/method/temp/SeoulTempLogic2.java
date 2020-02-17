package method.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

import oracle.jdbc2.ZipCodeVO;

public class SeoulTempLogic2 {
	DBConnectionMgr		dbMgr		= DBConnectionMgr.getInstance();
	Connection 			con 	= null; 
	PreparedStatement 	pstmt 	= null;
	ResultSet			rs			= null;
	SeoulTempEvent2 ste= null;
	SeoulTempLogic2(SeoulTempEvent2 ste){
		this.ste=ste;
	}
	public void reData(String year,String month) {
		int col=1;
		con = null;
		pstmt = null;
		rs = null;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder();
		Vector<SeoulTempVO> v = new Vector<>();
		SeoulTempVO  stvo = null;
		SeoulTempVO stvos[] = null;
		sb.append("select sdate,mitemp,matemp                      ");
		sb.append("from seoultemp                                  ");
		sb.append("where 1=1");
		if(month==null&&year!=null) {
			sb.append(" and sdate = ?");
		}else {
			if(year!=null&&year.length()>0) {
				sb.append(" and TO_CHAR(TO_DATE(sdate),'YYYY') = ?   ");
			}
			if(month!=null&&month.length()>0) {
				sb.append(" and TO_CHAR(TO_DATE(sdate),'MM') = ?     ");
			} 
		}
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			if(month==null&&year!=null) {
				pstmt.setString(col, year);
			}else {
				if(year!=null&&year.length()>0) {
						pstmt.setString(col++, year);
					}
					if(month!=null&&month.length()>0) {
						pstmt.setString(col++, month);
					}
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stvo = new SeoulTempVO();
				stvo.setSdate(rs.getString("sdate"));
				stvo.setMitemp(rs.getDouble("mitemp"));
				stvo.setMatemp(rs.getDouble("matemp"));
				v.add(stvo);
			}
			stvos = new SeoulTempVO[v.size()];
			v.copyInto(stvos);
		} catch (Exception e) {
			System.out.println(sb);
			e.printStackTrace();
		}
		System.out.println(v.size());
		if(v.size()>0) {
		while(ste.stv.dtm_temp.getRowCount()>0) {
			ste.stv.dtm_temp.removeRow(0);
			
		}
			for(int i =0; i<v.size();i++) {
				Vector row = new Vector();
				row.add(0,stvos[i].getSdate());
				row.add(1,stvos[i].getMitemp());
				row.add(2,stvos[i].getMatemp());
				ste.stv.dtm_temp.addRow(row);
			}
		}
		
	}
	public String[] getMonth(String year) {
		int col =1;
		con = null;
		pstmt = null;
		rs = null;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder();
		Vector<String> v = new Vector<>();
		String months[] = null;
		try {
			sb.append("SELECT DISTINCT(TO_CHAR(TO_DATE(sdate),'MM')) ta_month ");
			sb.append("  FROM seoultemp                                      ");
			sb.append(" WHERE TO_CHAR(TO_DATE(sdate),'YYYY') = ?        ");
			sb.append("ORDER BY ta_month asc                                  ");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(col, year);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String month = rs.getString("ta_month");
				v.add(month);
			}
			months = new String[v.size()];
			v.copyInto(months);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return months;
	}
	public String[] getYear() {
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
