package board.dao;

import java.io.IOException;
import java.io.Reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	public static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;

	public BoardDAO() {		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();				
			}
		}
		return instance;
	}
	
	public void write(BoardDTO boardDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("boardSQL.write", boardDTO);
		session.commit();
		session.close();
			
	}
	
	public int getTotArticle() {
		SqlSession session = sqlSessionFactory.openSession();
		int totArticle = session.selectOne("boardSQL.getTotArticle");
		session.close();		
		return totArticle;
	}
	
	public List<BoardDTO> getList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardDTO> list = session.selectList("boardSQL.getList", map);
		
		return list;
	}
	
	public BoardDTO getBoardView(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDTO boardDTO = session.selectOne("boardSQL.getBoardView", seq);
		session.close();		
		return boardDTO;
	}
	
	public void updateHit(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("boardSQL.updateHit", seq);
		session.commit();
		session.close();
	}
	
	public void updateBoard(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("boardSQL.updateBoard", map);
		session.commit();
		session.close();
	}

	public List<BoardDTO> searchBoard(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardDTO> list = session.selectList("boardSQL.searchBoard", map);
		session.close();
		return list;
	}

	public int getSearchTotArticle(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		int totalArticle = session.selectOne("boardSQL.getSearchTotArticle", map);
		session.close();
		return totalArticle;
	}

	public List<BoardDTO> getSearchList(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardDTO> list = session.selectList("boardSQL.getSearchList", map);
		session.close();
		return list;
	}

	public void replyBoard(BoardDTO boardDTO) {
		BoardDTO pDTO = getBoardView(boardDTO.getPseq()); //0. 원글 먼저 가져오기 

		SqlSession session = sqlSessionFactory.openSession();
		session.update("boardSQL.replyBoard1", pDTO); // 1. 먼저 달려있는 답글의 글순서(step) 밀어내기(업데이트) 
		
		 //insert ~ values( ref=원글ref, lev+1, step+1) 을 위해 원글의 ref, lev, step을 boardDTO에 set한다. 
		boardDTO.setRef(pDTO.getRef());
		boardDTO.setLev(pDTO.getLev()+1);
		boardDTO.setStep(pDTO.getStep()+1);
		
		session.insert("boardSQL.replyBoard2", boardDTO); //2. 답글쓰기
		session.update("boardSQL.replyBoard3", boardDTO.getPseq());//3. 원글의 답글 수 증가
		
		session.commit();
		session.close();
	}

	public void deleteBoard(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
//		session.update("boardSQL.deleteBoard1", seq); //1. 삭제하고자 하는 글의 원글을 찾아 답글 수 1 감소
//		session.update("boardSQL.deleteBoard2", seq); //2. 삭제하고자 하는 글의 답글을 찾아 제목에 [원글이 삭제된 답글] 추가
//		session.delete("boardSQL.deleteBoard3", seq); //3. 글 삭제
		
		//상기 세 가지 쿼리문을 한번에 
		session.delete("boardSQL.deleteBoard", seq);
		
		session.commit();
		session.close();
	}
	
}
