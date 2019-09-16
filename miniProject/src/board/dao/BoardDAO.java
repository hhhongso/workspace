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

	public void deleteBoard(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("boardSQL.deleteBoard", seq);
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
		int cnt = session.selectOne("boardSQL.getSearchTotArticle", map);
		session.close();
		return cnt;
	}

	public List<BoardDTO> getSearchList(Map<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardDTO> list = session.selectList("boardSQL.getSearchList", map);
		session.close();
		return list;
	}

	
}
