package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentsRead {
	
	public static void main(String[] args) {
		//1. Driver class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";
		String sql = "select * from departments";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2. DB 연결 : Connection 생성
			con = DriverManager.getConnection(url, user, pass);
			System.out.println(con.getClass().getName());
			//3. SQL 전달하기 위한 준비: Statement 생성
			stmt = con.createStatement();
			System.out.println(stmt.getClass().getName());
			//4. SQL 실행
			rs = stmt.executeQuery(sql);
			//5. query 결과 처리
			while(rs.next()) {
				String DEPARTMENT_ID = rs.getString("DEPARTMENT_ID");
				String DEPARTMENT_NAME = rs.getString("DEPARTMENT_NAME");
				int MANAGER_ID = rs.getInt("MANAGER_ID");
				int LOCATION_ID = rs.getInt("LOCATION_ID");
				System.out.println(DEPARTMENT_ID+" " + DEPARTMENT_NAME+" "+MANAGER_ID+" "+
						LOCATION_ID);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
