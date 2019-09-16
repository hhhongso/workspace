package imageboard.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dao.BoardDAO;
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

	public void writeImage(ImageboardDTO imageboardDTO) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("imageboardSQL.writeImage", imageboardDTO);
		session.commit();
		session.close();
		
	}
	

}
