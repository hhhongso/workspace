package member.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;


public class MemberDAO {
	public static MemberDAO instance;
	private SqlSessionFactory ssf;	
	
	public static MemberDAO getinstance() {
		if(instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();				
			}
		}
		return instance;
	}
	
	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isDuplicate(String checkId) {
		boolean isDup = false;
		SqlSession session = ssf.openSession();
		MemberDTO memberDTO= session.selectOne("memberSQL.isDuplicate", checkId);
		if(memberDTO != null) isDup = true; 
		session.close();
		return isDup;
	}
	


}
