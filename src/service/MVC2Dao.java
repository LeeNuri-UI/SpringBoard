package service;
//Dao(Data Access Object) : 데이터베이스 접근 객체의 약자 
import java.sql.Connection; //SQL 연결
import java.sql.PreparedStatement; //Statement와 구분하기 SQL문 컴파일하는 역할  
import java.sql.ResultSet; //ResultSet SELECT의 결과를 저장하는 객체
import java.sql.SQLException; //데이타베이스 액세스 에러 또는 그 외의 에러에 관한 정보를 제공하는 예외입니다
import java.util.ArrayList;

import dbconn.DBconn;
import domain.SearchCriteria;


public class MVC2Dao {
	
	//필드를 통해 속성지정
		private Connection conn; //dbconn에 conn으로 SQL 드라이버 연결 해놨음 그거 연결하겠다고  
		PreparedStatement pstmt = null; //미리 준비한 값은 없다
		
		//회원가입 생성자
		public MVC2Dao(){
			//데이터 베이스에 연결시킨다
			DBconn conn = new DBconn();  //DBconn 객체생성
			this.conn = conn.getConnect();  //연결하는 메소드호출
		}
		
		//글쓰기 액션
		public int MVC2Isert(String MVC2cate, String MVC2sub,String MVC2content, String user_name, int user_num, String html_ip) {
			
			int value=0;
			
			System.out.println("MVC2Dao오나 확인중");
			String sql="insert into MVC2 (MVC2_num,user_num,MVC2_sub,MVC2_content,MVC2_file,MVC2_re_ref,MVC2_re_lev,MVC2_re_step,MVC2_date,MVC2_viewcount,delyn,html_ip,MVC2_writer,MVC2_catagory)"
					+ "values(MVC2_num_seq.nextval,?,?,?,0,0,0,0,default,0,'N',?,?,?)";
					//user_date 부분은 default로 넣어야 알아서 가입날짜로 넣어줌->table 작성시 sysdate로 해줌. 
			
			try {
				pstmt = conn.prepareStatement(sql); // conn으로 연결하여 sql문 전송하는 객체인 PreparedStatement 메소드호출 
				pstmt.setInt(1,user_num); //값 설정(넣기)
				pstmt.setString(2,MVC2sub); 
				pstmt.setString(3,MVC2content); 
				pstmt.setString(4,html_ip);
				pstmt.setString(5,user_name);
				pstmt.setString(6,MVC2cate);
				
				System.out.println("DAo 입력은되었는가 확인");
				
				value = pstmt.executeUpdate(); //전송하는 메소드 insert니까 executeUpdate() 사용 select는 아마 executeQuery() 이거?
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace(); //try 실패시 catch로 넘어와서 에러메세지 출력
			}		
			return value;
		}
		
		public ArrayList<MVC2Vo> boardSelectAll(SearchCriteria scri, String MVC2_catagory) {
			//게시글 리스트 불러오기
			ArrayList<MVC2Vo> alist = new ArrayList<MVC2Vo>();
			ResultSet rs = null;
			
			String sql = "select * from MVC2 "
					+ "where delyn='N' "
					+ "order by MVC2_num desc, MVC2_re_step asc";
			try {
				//쿼리를 실행하여 pstmt에 담아 쿼리를 실행 후 rs에 담음
				
				pstmt = conn.prepareStatement(sql);
			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					MVC2Vo bv = new MVC2Vo();
					
					System.out.println("0.2");
					bv.setMVC2_num(rs.getInt("MVC2_num"));
					bv.setMVC2_catagory(rs.getString("MVC2_catagory"));
					bv.setMVC2_writer(rs.getString("MVC2_writer"));
					bv.setMVC2_sub(rs.getString("MVC2_sub"));
					bv.setMVC2_date(rs.getString("MVC2_date"));
					bv.setMVC2_viewcount(rs.getInt("MVC2_viewcount"));
					
					System.out.println("0.3");
					alist.add(bv);
					System.out.println("0.4");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return alist;
		}
		
		public int boardTotal(String keyword) {
			//게시글 전체 갯수
			ResultSet rs = null;
			int cnt = 0;
			
			String sql = "select count(*) as cnt from MVC2 where delyn='N' and MVC2_sub like ?";
			
			try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						cnt = rs.getInt("cnt");
					}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return cnt;
		}
		
		
		public MVC2Vo HtmlView(int MVC2_num){
			
			ResultSet rs = null; //메소드의 리턴 받을 값 select 구문값 리턴
			MVC2Vo MVC2v = null; // MVC2Vo 받아올 기본 값 설정
			
			String sql = "select * from MVC2 where delyn='N' and MVC2_num=?";
			
			try {
				pstmt = conn.prepareStatement(sql); // sql문에 연결해주는 메소드 실행
				pstmt.setInt(1, MVC2_num); //매개변수를 보내라
				rs = pstmt.executeQuery(); // ResultSet rs = null;에 리턴해라
				
				if(rs.next()) {
					MVC2v = new MVC2Vo(); //MVC2Vo 를 받을 객체생성
					
					//MVC2Vo에서  받아온 값을 rs에 담겠다.
					MVC2v.setMVC2_writer(rs.getString("MVC2_writer"));
					MVC2v.setMVC2_sub(rs.getString("MVC2_sub"));
					MVC2v.setMVC2_content(rs.getString("MVC2_content"));
					MVC2v.setMVC2_file(rs.getString("MVC2_file"));
					MVC2v.setMVC2_re_ref(rs.getInt("MVC2_re_ref"));
					MVC2v.setMVC2_re_lev(rs.getInt("MVC2_re_lev"));
					MVC2v.setMVC2_re_step(rs.getInt("MVC2_re_step"));
					MVC2v.setMVC2_date(rs.getString("MVC2_date"));			
				
				}
			
			}catch (SQLException e){
					e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				//5.MVC2v값 리턴
			return MVC2v;
		}
				
}
