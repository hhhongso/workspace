/* [JDBC]: java와 DB를 연결해주는 과정
1. driver Loading(적재):한 번만 설정( ==> 생성자!). ojdbc7.jar(자바압축파일)
2. Connection(연결): URL, user, pw 를 입력할 때마다 연결 (==> 생성자는 안되욤)
3. Statement / PreparedStatement (문장준비): SQL 명령어를 번역 ( java가 이해할 수 있도록)

'' 데이터
"" 별명 (as)
*/

package dbTest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String user = "java"; 
	private String pw = "dkdlxl"; 
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	public InsertTest() {
		//OracleDriver.class 가 클래스인지, 인터페이스인지 타입을 알 수 없음 => 무엇이든 포괄할 수 있도록 Class 타입 으로 생성시킴 [몽타쥬]
		//forName 안은 풀 쿼리 네임(ex. String ==> java.lang.String) 으로 작성한다. .class 는 포함하지 않는다.  
		try {
			Class.forName(driver);
			System.out.println("driver loading!");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} //constructor
	
	public void getConnection() {
		//Connection 인터페이스는 implementing class가 없다 => method로 생성
													//jdbc:oracle:드라이버명:서버:포트:데이터베이스명
		try {
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertArticle() {
		//insert into dbtest 못해욤 => preparedStatement
		try {
		//데이터 받기 
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 입력: ");
			String name = scan.next();
			System.out.print("나이 입력: ");
			int age = scan.nextInt();
			System.out.print("키 입력: ");
			double height = scan.nextDouble();
		
		//접속
			this.getConnection();
			
		// 생성											오라클은 인덱스가 1번부터 시작:	 1	2  3	4
			String sql = "INSERT INTO DBTEST(NAME, AGE, HEIGHT, LOGTIME) VALUES (?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql); // 직접 입력하면 보안의 위험 => ? 처리 후 set/get 
		
		// 데이터 가져오기
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
		// 실행 
			int count = pstmt.executeUpdate(); // insert 는 만들어진 개수를 리턴
			System.out.println(count + " row created");
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 에러 여부와 상관없이 수행. close하는 순서는 LIFO			
		// 종료: 끝내줘야 다른 문장을 쓸 수 있음 
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//====================================================================================================================================
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle(); // java는 자동으로 commit한다. 
	}

}
// *.jar 는 필요한 프로젝트에 넣는다. (jre/jdk에 바로 집어넣으면 XXXX)
// 혹은, 서버에 넣어두고 서버에서 내려받는다. 

// 오라클 드라이버 thin
//ex 그래픽 드라이버	1. 지포스		2. AMD



