package service;
//Dao(Data Access Object) : 데이터베이스 접근 객체의 약자 
import java.sql.Connection; //SQL 연결
import java.sql.PreparedStatement; //Statement와 구분하기 SQL문 컴파일하는 역할  
import java.sql.ResultSet; //ResultSet SELECT의 결과를 저장하는 객체
import java.sql.SQLException; //데이타베이스 액세스 에러 또는 그 외의 에러에 관한 정보를 제공하는 예외입니다
import java.util.ArrayList;

import dbconn.DBconn;

public class UserDao{
	
	//필드를 통해 속성지정
	private Connection conn; //dbconn에 conn으로 SQL 드라이버 연결 해놨음 그거 연결하겠다고  
	PreparedStatement pstmt = null; //미리 준비한 값은 없다
	
	//회원가입 생성자
	public UserDao(){
		
		//데이터 베이스에 연결시킨다
		DBconn conn = new DBconn();  //DBconn 객체생성
		this.conn = conn.getConnect();  //conn에 연결하는 메소드호출
	}
	
	public UserVo UserLogin(String user_id, String user_pwd) {
		
		// 받는 값 설정
		ResultSet rs = null; //executeQuery(String sql)을 통해 쿼리 실행하면 ResultSet타입으로 반환을 해주어 결과값을 저장	
		UserVo uv = null; //UserVo에서 받아오는 값 uv에 담는데 아직 값이 없다고 설정
		
		try {
			String sql = "select * from user_if where user_id= ? and user_pwd= ?";					

			pstmt = conn.prepareStatement(sql); //
			pstmt.setString(1,user_id); 
			pstmt.setString(2,user_pwd);
			rs = pstmt.executeQuery(); //executeQuery로 rs에 값을 반환한다.			
			
			if (rs.next()) {				
				uv = new UserVo(); // 객체생성		
				//UserVo에 보낼 값들
				uv.setUser_num(rs.getInt("user_num"));		
				uv.setUser_id(rs.getString("user_id"));	
				uv.setUser_name(rs.getString("user_name"));	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		System.out.println("왔음?"+uv); 
		return uv;
	}
	
	/*public int User_IdCheck(String user_id) {
		int value= 0;
		ResultSet rs = null;
		
		String sql = "select count(*) as cnt from user_if where user_id= ? ";	//user_if의 user_id를 세겠다고 쓴거 cnt에 담아서				
		System.out.println("ID DAo 입력은되었는가 확인");
		try {
			pstmt = conn.prepareStatement(sql); //sql 연결하는 객체
			pstmt.setString(1, user_id); // 입력되는 아이디 넣음
			rs = pstmt.executeQuery(); // sql문이 select니 executeQuery()씀  executeUpdate()는 update나  insert 등에 씀 
			
			if (rs.next()) {
			value = rs.getInt("cnt");		
			}			
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
			
		return value;
	}*/
	
	public int UserInsert(String user_id, String user_pwd, String user_name, String user_e_mail, String user_e_mail2) {
		int value=0;
		
		System.out.println("UserDao오나 확인중");
		String sql="insert into user_if (user_num,user_id,user_pwd,user_name,user_e_mail,user_date,adminyn,delyn,user_e_mail2)"
				+ "values(user_num_seq.nextval,?,?,?,?,default,'N','N',?)";
				//user_date 부분은 defalt로 넣어야 알아서 가입날짜로 넣어줌->table 작성시 sysdate로 해줌. 
		
		try {
			pstmt = conn.prepareStatement(sql); // conn으로 연결하여 sql문 전송하는 객체인 PreparedStatement 생성
			pstmt.setString(1,user_id); //값 설정(넣기)
			pstmt.setString(2,user_pwd); 
			pstmt.setString(3,user_name); 
			pstmt.setString(4,user_e_mail);
			pstmt.setString(5,user_e_mail2);
			value = pstmt.executeUpdate(); //전송하는 메소드 insert니까 executeUpdate() 사용 select는 아마 executeQuery() 이거?
			
			System.out.println("DAo 입력은되었는가 확인");
			
		} catch (SQLException e) {
			
			e.printStackTrace(); //try 실패시 catch로 넘어와서 에러메세지 출력
		}		
		return value;
	}
	
}
