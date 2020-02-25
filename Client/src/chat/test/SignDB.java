package chat.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnectionMgr;

public class SignDB {
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;

	
	public boolean checkID(String u_id) {
		int col =0;
		boolean check = false;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");
		sb.append(" SELECT u_id  FROM CHATINFO where u_id= ? ");
		try {
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(++col, u_id);
			
			rs = pstmt.executeQuery();
			check = !rs.next();
			System.out.println(check);
		} catch (SQLException se) {
			se.printStackTrace();
		
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		
		return check;
	}
	
	public boolean signUser(String u_id,String u_pw) {
		int col =0;
		boolean sign = false;
		int result  =0;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");
		sb.append("INSERT INTO CHATINFO(u_id,u_pw) values(?,?)");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(++col, u_id);
			pstmt.setString(++col, u_pw);
			result= pstmt.executeUpdate();
			if(result ==1) {
				sign =true;
			}else if(result ==0) {
				sign=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
		
	}
	

}
