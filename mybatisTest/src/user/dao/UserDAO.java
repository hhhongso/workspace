package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		if(instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.write", userDTO); //key, value
		sqlSession.commit();
		sqlSession.close();
	}

	public int delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	public List<UserDTO> getList() { 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getList");
		sqlSession.close();
		
		return list;
	}

	public int update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt= sqlSession.update("userSQL.update", userDTO);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	public UserDTO select(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.select", id);
		sqlSession.close();
		return userDTO;
	}

}
