package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UserSelect {

	public static void main(String[] args) {
		//1. Driver Class loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "select * from users";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2. Connection 생성
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection = "+conn);
			
			//3. Statement 생성
			stmt = conn.createStatement();
			System.out.println("Statmemt = "+stmt);
			
			//4. sql문 실행
			rs = stmt.executeQuery(sql);
			System.out.println("ResultSet = "+rs);
			
			//5. query 결과값 처리
			List<UserVO> userList = new ArrayList();
			while(rs.next()) {
				String userid = rs.getString("userid");
				String name = rs.getString("name");
				char gender = rs.getString("gender").charAt(0);
				String city = rs.getString("city");
				userList.add(new UserVO(userid, name, gender, city));
			}
			
			for(UserVO userVO : userList) {
				System.out.println(userVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
