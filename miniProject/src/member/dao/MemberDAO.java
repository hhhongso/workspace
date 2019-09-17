package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	public static MemberDAO instance;
	private static SqlSessionFactory sqlSessionFactory;
	
	public static MemberDAO getinstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insert(MemberDTO memberDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("memberSQL.insert", memberDTO);
		session.commit();
		session.close();
		
	}

	public boolean isDuplicate(String id) {
		boolean isDup = false;
		SqlSession session = sqlSessionFactory.openSession();
		MemberDTO memberDTO = session.selectOne("memberSQL.isDupGetInfo", id);
		if(memberDTO != null) isDup = true;
		session.close();		
		//cf) 상관쿼리 exist로 boolean 받을 수 있음.  
		return isDup;
	}
	
	public MemberDTO isLogin(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberDTO memberDTO = session.selectOne("memberSQL.isLogin", map);
		session.close();		
		return memberDTO;
	}

	public MemberDTO getInfo(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberDTO memberDTO = session.selectOne("memberSQL.isDupGetInfo", id);
		session.close();		
		return memberDTO;
		
	}
	
	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map){
		SqlSession session = sqlSessionFactory.openSession();
		List<ZipcodeDTO> list = session.selectList("memberSQL.getZipcodeList", map);
		session.close();
	
		return list;
	}
	
	public void update(MemberDTO memberDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("memberSQL.update", memberDTO);
		session.commit();
		session.close();
	}
}
