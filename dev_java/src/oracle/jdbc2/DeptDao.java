package oracle.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//부서 집합에서 조회하는 메소드 선언하기
//SELECT deptno,dname,loc FROM dept WHERE deptno =10;
	public DeptVO[] deptList(int deptno) {
		
		rs =null;
		DeptVO[] dvos = null;
		DeptVO dvo = null;
		Vector<DeptVO> v = new Vector();
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");
		sb.append("SELECT deptno,dname,loc FROM dept WHERE deptno =?");
		
		try {
			pstmt =con.prepareStatement(sb.toString());
			pstmt.setInt(1,deptno);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				
				v.add(dvo);
				
			}
			dvos = new DeptVO[v.size()];
			v.copyInto(dvos);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//에러가 발생하더라도 자원바납은 무조건 꼬오옥 해주세요
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt, rs);
		}
		
		return dvos;
	}
	//메소드 오버로딩이라고 한다.
	//무조건 파라미터의 갯수가 다르거나 혹은 파라미터의 타입이 달라야 한다.
	//SELECT deptno, dname, loc FROM dept WHERE deptno>10 AND dname=?;
	public DeptVO[] deptList(int deptno,String dname) {
		return null;
	}
	//신규 부서 정보를 등록하는 메소드 선언하기
	public int deptInsert(int deptno , String dname, String loc) {
		
		int result = 0;
		int col =1;
		StringBuilder sb = new StringBuilder("");
		sb.append("INSERT INTO dept(deptno,dname,loc) values(?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt =con.prepareStatement(sb.toString());
			int i=0;
			pstmt.setInt(++i, deptno);
			pstmt.setString(++i, dname);
			pstmt.setString(++i, loc);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//에러가 발생하더라도 자원바납은 무조건 꼬오옥 해주세요
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
	//기존 부서 정보를 수정하는 메소드 선언하기
	public int deptUpdate( int deptno,String dname,String loc ) {
		con = null;
		pstmt =null;
		int result = 0;
		int col = 1;
		StringBuilder sb = new StringBuilder("");
		sb.append("	UPDATE dept set dname =? ,loc = ? ");
		sb.append("		WHERE deptno = ?              ");
		try {
			
			con = dbMgr.getConnection();
			pstmt =con.prepareStatement(sb.toString());
			pstmt.setString(col++, dname);
			pstmt.setString(col++, loc);
			pstmt.setInt(col++, deptno);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//에러가 발생하더라도 자원바납은 무조건 꼬오옥 해주세요
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
	//사라진 부서 정보 반영하는 메소드 선언하기
	public int deptDelete(int deptno) {
		con = null;
		pstmt =null;
		int result = 0;
		con = dbMgr.getConnection();
		StringBuilder sb = new StringBuilder("");
		sb.append("DELETE FROM dept WHERE deptno = ?");
		try {
			
			pstmt =con.prepareStatement(sb.toString());
			int i =0;
			pstmt.setInt(++i, deptno);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			//delete문에 에러가 발생했을 때 delete문을 출력하는 문장을 작성할 수
			//있는데 이때 변수 sb를 사용할 수 있다|없다
			System.out.println(sb.toString());
		}finally {//에러가 발생하더라도 자원바납은 무조건 꼬오옥 해주세요
			//사용한 자원은 반납해주세요.
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}
	
}
