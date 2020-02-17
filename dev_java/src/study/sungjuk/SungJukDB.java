package study.sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConnectionMgr;

public class SungJukDB {
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;//물리적으로 떨어져있는 서버와 연결통로 만들기
	PreparedStatement pstmt = null;//동적쿼리 작성하기 - ?
	SungJukDB(){
		
	}
	public void insertSungJuk(SungJukVO[] sjvos) {
		int col=1;
		StringBuilder sb = new StringBuilder("");
		sb.append("insert into sungjuk                     ");
		sb.append("values(?,?,?,?,?,?,?)");
		for(int i=0;i<sjvos.length;i++) {
		try {
			con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sb.toString());
        	pstmt.setString(col++, sjvos[i].getName());
        	pstmt.setString(col++, sjvos[i].getKor());
        	pstmt.setString(col++, sjvos[i].getEng());
        	pstmt.setString(col++, sjvos[i].getMath());
        	pstmt.setString(col++, sjvos[i].getTotal());
        	pstmt.setString(col++, sjvos[i].getAvg());
        	pstmt.setString(col++, sjvos[i].getRank());
        	pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
}
