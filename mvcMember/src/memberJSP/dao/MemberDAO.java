package memberJSP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import memberJSP.bean.MemberDTO;
import memberJSP.bean.ZipcodeDTO;

public class MemberDAO {
	public static MemberDAO instance;
	private DataSource ds;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static MemberDAO getinstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();// Context는 인터페이스.
			//NamingService: 이름으로 서비스 제공. 
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle"); // Tomcat의 경우 java:comp/env/ 까지 붙여주어야 함. 
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}

	public int insert(MemberDTO memberDTO) {
		int cnt = 0;
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}

	public boolean isDuplicate(String id) {
		boolean isDup = false;
		String sql = "select * from member where id = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				isDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isDup;
	}
	
	public MemberDTO isLogin(String id, String pwd) {
		MemberDTO memberDTO = null;
		String sql = "select * from member where id = ? and pwd = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return memberDTO;
	}

	public MemberDTO getInfo(String id) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "select * from member where id = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				id = rs.getString("id");
				String gender = rs.getString("gender");
				String email1 = rs.getString("email1");
				String email2 = rs.getString("email2");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String zipcode = rs.getString("zipcode");
				String addr1 = rs.getString("addr1");
				String addr2 = rs.getString("addr2");
				
				memberDTO.setName(name);
				memberDTO.setId(id);
				memberDTO.setGender(gender);
				memberDTO.setEmail1(email1);
				memberDTO.setEmail2(email2);
				memberDTO.setTel1(tel1);
				memberDTO.setTel2(tel2);
				memberDTO.setTel3(tel3);
				memberDTO.setZipcode(zipcode);
				memberDTO.setAddr1(addr1);
				memberDTO.setAddr2(addr2);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return memberDTO;
		
	}
	
	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname){
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
//		String sql = "select zipcode, sido, nvl(sigungu, ' ') as sigungu, yubmyundong, nvl(ri, ' ') as ri, roadname, buildingname from newzipcode where sido like ? and nvl(sigungu, 0) like ? and roadname like ?";		
		String sql = "select*from newzipcode where sido like ? and nvl(sigungu,' ') like ? and roadname like ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sido+"%");
			pstmt.setString(2, "%"+sigungu+"%");
			pstmt.setString(3, "%"+roadname+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));				
				zipcodeDTO.setSigungu(rs.getString("sigungu") == null ? "": rs.getString("sigungu"));
				zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
				zipcodeDTO.setRi(rs.getString("ri") == null ? "" :rs.getString("ri"));
				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname") == null ? "" :rs.getString("buildingname"));
				
				list.add(zipcodeDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int update(MemberDTO memberDTO) {
		int cnt = 0;
		String sql = "update member set name=?, pwd=?, gender=?, email1=?, email2=?, tel1=?, tel2=?, tel3=?, "
				+ "zipcode=?, addr1=?, addr2=?, logtime=sysdate where id =? ";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;		
	}
}
