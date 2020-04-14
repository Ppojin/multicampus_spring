package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersUpdate {
	
	
	public static void main(String[] args) {
		String sql = "update users set name=?, gender=?, city=? where userid=?";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loading OK!!");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		String name = "홍길동";
		String gender = "남";
		String city = "서울";
		String userid = "gildong";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pass = "tiger";

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setString(3, city);
			stmt.setString(4, userid);
			int cnt = stmt.executeUpdate();
			stmt.execute();
			System.out.println("등록된 건수 : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
