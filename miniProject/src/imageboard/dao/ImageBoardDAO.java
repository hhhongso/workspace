package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageBoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static ImageBoardDAO instance;
	
	public ImageBoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ImageBoardDAO getInstance() {
		if(instance == null) {
			synchronized (ImageBoardDAO.class) {
				instance = new ImageBoardDAO();				
			}
		}
		return instance;
	}

	public void writeImageboard(ImageboardDTO imageboardDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("imageboardSQL.writeImageboard", imageboardDTO);
		session.commit();
		session.close();		
	}

	public List<ImageboardDTO> getImageboardList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<ImageboardDTO> list = session.selectList("imageboardSQL.getImageboardList", map);
		session.close();
		return list;
	}

	public int getTotArticle() {
		SqlSession session = sqlSessionFactory.openSession();
		int totalArticle = session.selectOne("imageboardSQL.getTotArticle");
		session.close();
		return totalArticle;
	}

	public ImageboardDTO getImageboardView(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		ImageboardDTO imageboardDTO = session.selectOne("imageboardSQL.getImageboardView", seq);
		session.close();
		return imageboardDTO;
	}

	public void deleteImageBoard(String seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("imageboardSQL.deleteImageBoard", seq);
		session.commit();
		session.close();
		
	}
	

}
