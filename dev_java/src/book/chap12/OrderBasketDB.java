package book.chap12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class OrderBasketDB {
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con =null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;
	
	public OrderBasketVO[] result() {
		
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");                               
		sb.append("	SELECT                                                       ");
		sb.append("      decode(b.rno,1,a.indate_vc,2,'총계') as 판매날짜      ");
		sb.append("     ,sum(a.qty_nu) as 판매개수                       ");
		sb.append("     ,sum(a.qty_nu*a.price_nu)  as 판매가격           ");
		sb.append("  FROM t_orderbasket a                                        ");
		sb.append("      ,(SELECT rownum rno from t_orderbasket where rownum<3) b");
		sb.append("  GROUP BY decode(rno,1,indate_vc,2,'총계')                   ");
		sb.append("  ORDER BY decode(rno,1,indate_vc,2,'총계') ASC               ");
		ArrayList<OrderBasketVO> al = new ArrayList();
		OrderBasketVO orVO= null;
		OrderBasketVO orVOs[] = null;
		try {
			pstmt=con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			//VO는 한번에 한 개 로우만 담을 수 있어요. 두 개 로우는 안되죠.
			//VO에는 변수에 하나에 한 개값만 담는 변수를 선언했기 때문이죠.
			while(rs.next()) {
				orVO= new OrderBasketVO();
				orVO.setIndate_vc(rs.getString("판매날짜"));
				orVO.setT_qty(rs.getInt("판매개수"));
				orVO.setT_price(rs.getInt("판매가격"));
				al.add(orVO);
			}
			orVOs = new OrderBasketVO[al.size()];
			
			for(int i = 0 ; i<al.size();i++) {
				orVOs[i]=al.get(i);
			}
		}catch (SQLException se) { //오라클에서 발생되는 에러메시지 잡기
			se.printStackTrace();
		} catch (Exception e) { //자바전체에서 발생되는 에러메시지 잡기
			e.printStackTrace();
		}finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return orVOs; // null값으로 리턴될 가능성이 음
	}
	
}
