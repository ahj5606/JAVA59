package chat.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.util.DBConnectionMgr;

public class LoginCheck {
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	public boolean login(String u_id,String u_pw){
		int col =0;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");
		sb.append(" SELECT u_id,u_pw FROM CHATINFO where u_id=? and u_pw=? ");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(++col, u_id);
			pstmt.setString(++col, u_pw);
			rs = pstmt.executeQuery();
			if(rs.next()==false) {
				return false;
			}
			while(rs.next()) {
				if(!u_id.equals(rs.getString("u_Id"))) {
					return false;
				}
				if(!u_pw.equals(rs.getString("u_pw"))) {
					return false;
				}
				
				
				
			}
		}catch (SQLException se) {
			se.printStackTrace();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return true;
	}
}
