package notice.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import notice.bean.NoticeDTO;

public class NoticeDAO {
	private static NoticeDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public NoticeDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static NoticeDAO getInstance() {
		if(instance == null) {
			synchronized (NoticeDAO.class) {
				instance = new NoticeDAO();
			}
		}
		return instance;
	}

	public void writeNotice(NoticeDTO noticeDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("noticeSQL.writeNotice", noticeDTO);
		session.commit();
		session.close();
		
	}
}
