package controller;

import java.io.IOException;
import java.io.PrintWriter;//
import java.net.InetAddress; //
import java.util.ArrayList; //

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconn.DBconn;
import service.UserDao;
import service.UserVo;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//한글 깨짐방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
					
			//가상경로와 같은지 확인한다
		String uri = request.getRequestURI(); //하부주소 요청을 uri에 담는다
		int projectname = request.getContextPath().length(); 
			/**요청된 프로젝트 경로 getContextPath()와 .length() 문자열은 pojectname에 담음
			 * http://localhost/ZESTINE/test.jsp 경우→ /ZESTINE 경로만 얻는다 **/

		String str = uri.substring(projectname); 
			/**하부주소(uri)와 경로프로젝트 경로를 str 에 담음
			 * 그런데 왜 하부주소 하나만 해도 뒤에 경로 다 나오는데 굳이  getContextPath()와 .length() 넣어야 하는 이유 찾아보기**/
		
		
		if (str.equals("/User/UserJoinAction.do")) {
			
			//받아오는 메소드로 가입내용 호출
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			String user_name = request.getParameter("user_name");
			String user_e_mail = request.getParameter("user_e_mail");
			String user_e_mail2 = request.getParameter("user_e_mail2");
			
			//콘솔 확인을 위해 넣은 println임
			System.out.println("user_id: " + user_id); 
			System.out.println("user_pwd: " + user_pwd);
			System.out.println("user_name: " + user_name);
			System.out.println("user_e_mail: " + user_e_mail);
			System.out.println("user_e_mail2: " + user_e_mail2);
			
			//UserDao 클래스 호출
			UserDao ud = new UserDao(); // UserDao 객체생성 
			int value = ud.UserInsert(user_id, user_pwd, user_name, user_e_mail, user_e_mail2); // UserInsert()메소드로 값을 value에 담는다.
			
			System.out.println("value: " + value); 	//이것도 확인용으로 넣은 값 
			
			// 서버가 클라이언트에 잘됐다고 응답하기위해서 밑에 글 나오게 설정 
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('회원가입이 되었습니다.');</script>");
			out.println("<script>document.location.href='"+request.getContextPath()+"/Main.jsp';</script>");
			
			//response.sendRedirect(request.getContextPath()+"/");
			
		}else if (str.equals("/User/UserJoin.do")) {
			//단순 회원가입창 이동용
			RequestDispatcher rd = request.getRequestDispatcher("/Join.jsp");
			rd.forward(request, response);		
							
		}else if(str.equals("/User/UserLogin.do")) {
			//단순 로그인창 이동용
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);		
							
		}else if (str.equals("/User/UserLoginAction.do")) {
			
			//request.getParameter()메소드로 ID와 PW를 받아온다.
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			
			// UserDao 클래스  메소드에서 아이디 확인하기
			UserDao ud = new UserDao(); //객체생성
			UserVo uv = ud.UserLogin(user_id,user_pwd); 
			if(uv != null) {
				HttpSession session = request.getSession(true);
				
				session.setAttribute("user_num", uv.getUser_num());
				session.setAttribute("user_id", uv.getUser_id());
				session.setAttribute("user_name", uv.getUser_name());
				
				PrintWriter out = response.getWriter(); 
				out.println("<script>alert('로그인 되었습니다.');</script>");
				out.println("<script>document.location.href='"+request.getContextPath()+"/User/Main.do';</script>");
				
			}else {
				PrintWriter out = response.getWriter(); 
				out.println("<script>alert('아이디 또는 비밀번호를 확인하세요');</script>");
				out.println("<script>document.location.href='"+request.getContextPath()+"/User/UserLogin.do';</script>");
			}
				
											
		}else if(str.equals("/User/UserLogout.do")) {
			
			HttpSession session = request.getSession(true); // 로그아웃을 요청한 사용자의 세션객체 얻어오기
			session.invalidate(); //invalidate() 메소드로 세션제거
			
			//사용자에게 로그아웃됨을 알리고 메인화면으로 보내기
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('로그아웃 되었습니다.');</script>");
			out.println("<script>document.location.href='"+request.getContextPath()+"/Main.jsp';</script>");
			
		}else if(str.equals("/User/Main.do")) {
			//단순 메인창 이동용
			RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
			rd.forward(request, response);	
			
		}/*else if (str.equals("/User/User_IdCheck.do")) {
			String user_id = request.getParameter("user_id");
			
			UserDao ud = new UserDao();
			int value = ud.User_IdCheck(user_id);
			System.out.println("value:"+value);
			System.out.println("컨트롤러에도 왔습니다");
			//화면에 출력한다
			PrintWriter out = response.getWriter();
		   	out.println("{\"cnt\":\""+value+"\"}");
		   	 	 	
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
