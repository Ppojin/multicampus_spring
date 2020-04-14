package myspring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

//@Repository("userDao")
public class UserDaoImpl implements UserDao {

//	@Autowired
    private SqlSession sqlSession;
	private final String USER_NAMESPACE = "myspring.user.dao.mapper.UserMapper"; 
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public UserVO read(String id) {
		UserVO user  = sqlSession.selectOne(USER_NAMESPACE+".selectUserById", id);
		return user;
	}

	public List<UserVO> readAll() {
		List<UserVO> userList = sqlSession.selectList(USER_NAMESPACE+".selectUserList");
		return userList;
	}
	
	public void insert(UserVO user) {
		sqlSession.update(USER_NAMESPACE+".insertUser", user);
		System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	@Override
	public void update(UserVO user) {
		sqlSession.update(USER_NAMESPACE+".updateUser", user);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete(USER_NAMESPACE+".deleteUser", id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}




	

}
