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

	public void replyQNA(QnADTO qnaDTO) {
		QnADTO pDTO = getQnAView(qnaDTO.getPseq());
		
		SqlSession session = sqlSessionFactory.openSession();
		session.update("qnaSQL.replyQNA1", pDTO); // 1. 먼저 달려있는 답글의 글순서(step) 밀어내기

		qnaDTO.setRef(pDTO.getRef());
		qnaDTO.setLev(pDTO.getLev()+1);
		qnaDTO.setStep(pDTO.getStep()+1);
		session.insert("qnaSQL.replyQNA2", qnaDTO); //답글 달기
		
		session.update("qnaSQL.replyQNA3", qnaDTO.getPseq());//3. 원글의 답글 수 증가
		
		session.commit();
		session.close();
	}


}
