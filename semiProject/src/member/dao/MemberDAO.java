package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public void insertMember(MemberDTO memberDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("memberSQL.insertMember", memberDTO);
		session.commit();
		session.close();
		
	}

	public boolean isExistedId(String id) {
		boolean isExisted = false;
		SqlSession session = sqlSessionFactory.openSession();
		MemberDTO memberDTO = session.selectOne("memberSQL.isExistedId", id);
		if(memberDTO != null) isExisted = true;
		session.close();
		return isExisted;
	}

	public MemberDTO isLogin(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberDTO memberDTO = session.selectOne("memberSQL.isLogin", map);
		session.close();		
		return memberDTO;
	}
	
	
}
