package myspring.user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring_beans.xml")
public class MyBatisTest {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired DataSource dataSource;
	@Autowired SqlSessionFactory sqlSessionFactroy;
	@Autowired SqlSession sqlSession;
	@Autowired UserService userService;
	
	static String USER_NAMESPACE = "myspring.user.dao.mapper.UserMapper";
	
	@Test @Ignore
	public void service() {
		UserVO user= userService.getUser("gildong");
		logger.debug(user);
	}
	
	@Test //@Ignore
	public void sqlUpdate() {
		String userID = "java";
		String name = "오징어땅콩";
		String gender = "여";
		String city = "silicon vally";
		
		//String userId, String name, String gender, String city
		UserVO updateUser = new UserVO(userID, name, gender, city);
		logger.info(">>>>> update cnt + cnt");  
		int count = sqlSession.update(USER_NAMESPACE+".updateUser", updateUser );
		System.out.println(count);
	}

	@Test @Ignore
	public void sqlSelectList() {
		List<UserVO> userVOList = sqlSession.selectList(USER_NAMESPACE+".selectUserList");
		
		for(UserVO userVO : userVOList) {
			logger.debug(userVO);
		}
	}
	
	@Test @Ignore
	public void sqlInsert() {
		String userID = "ppojin";
		String name = "황효진";
		String gender = "남";
		String city = "LALA LAND";
		
		//String userId, String name, String gender, String city
		UserVO insertUser = new UserVO(userID, name, gender, city);  
		int count = sqlSession.insert(USER_NAMESPACE+".insertUser", insertUser);
		System.out.println(count);
	}
	
	@Test @Ignore
	public void sqlSelectOne() {
		String uid = "java";
		UserVO userVO = sqlSession.selectOne(USER_NAMESPACE+".selectUserById", uid);
		System.out.println(userVO);
	}
	
	@Test @Ignore
	public void mybatis_spring() {
		System.out.println(sqlSessionFactroy.getClass().getName());
		System.out.println(sqlSession.getClass().getName());
	}
	
	@Test @Ignore
	public void connection() {
		try {	
			Connection conn = dataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
