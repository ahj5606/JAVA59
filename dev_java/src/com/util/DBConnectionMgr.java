package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc2.JDBCTest;

public class DBConnectionMgr {
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	public static final String _URL ="jdbc:oracle:thin:@127.0.0.1:1521:orcl11";//ip:port:이름
	public static String _USER ="scott";
	public static String _PW ="tiger";
	//static-클래스급이다. -공유(하나다-정적변수)
	Connection 			con 	= null;
	private static DBConnectionMgr dbMgr = new DBConnectionMgr();
	private DBConnectionMgr() {}
	//싱글톤 패턴으로 객체 관리하기 - 인스턴스화 과정이다.
	public static DBConnectionMgr getInstance() {
		if(dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}
	//물리적으로 떨어져 있는 오라클 서버와 연결통로 만들기
	//인스턴스화를 해주는 메소드 구현
	public Connection getConnection(){
		try {
			Class.forName(_DRIVER);
			//con = new Connection//반드시 구현체 클래스가 있어야 한다.
			con = DriverManager.getConnection(_URL,_USER,_PW);
			
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스 이름을 찿을 수 없어요");
		}catch(Exception e) {
			System.out.println("예외가 발생햇음.");			
		}
		System.out.println("getConnection호출성공");
		
		return con;
	}
}
