package qna.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import qna.bean.QnADTO;

public class QnADAO {
	private static QnADAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public QnADAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static QnADAO getInstance() {
		if(instance == null) {
			synchronized (QnADAO.class) {
				instance = new QnADAO();
			}
		}
		return instance;
	}

	public void writeQNA(QnADTO qnaDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("qnaSQL.writeQNA", qnaDTO);
		session.commit();
		session.close();
		
	}

	public List<QnADTO> getQnAList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<QnADTO> list = session.selectList("qnaSQL.getQnAList");
		session.close();		
		return list;
	}

	public QnADTO getQnAView(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		QnADTO qnaDTO = session.selectOne("qnaSQL.getQnAView", seq);
		session.close();
		return qnaDTO;
	}
}
