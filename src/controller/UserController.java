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

			//�ѱ� ��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
					
			//�����ο� ������ Ȯ���Ѵ�
		String uri = request.getRequestURI(); //�Ϻ��ּ� ��û�� uri�� ��´�
		int projectname = request.getContextPath().length(); 
			/**��û�� ������Ʈ ��� getContextPath()�� .length() ���ڿ��� pojectname�� ����
			 * http://localhost/ZESTINE/test.jsp ���� /ZESTINE ��θ� ��´� **/

		String str = uri.substring(projectname); 
			/**�Ϻ��ּ�(uri)�� ���������Ʈ ��θ� str �� ����
			 * �׷��� �� �Ϻ��ּ� �ϳ��� �ص� �ڿ� ��� �� �����µ� ����  getContextPath()�� .length() �־�� �ϴ� ���� ã�ƺ���**/
		
		
		if (str.equals("/User/UserJoinAction.do")) {
			
			//�޾ƿ��� �޼ҵ�� ���Գ��� ȣ��
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			String user_name = request.getParameter("user_name");
			String user_e_mail = request.getParameter("user_e_mail");
			String user_e_mail2 = request.getParameter("user_e_mail2");
			
			//�ܼ� Ȯ���� ���� ���� println��
			System.out.println("user_id: " + user_id); 
			System.out.println("user_pwd: " + user_pwd);
			System.out.println("user_name: " + user_name);
			System.out.println("user_e_mail: " + user_e_mail);
			System.out.println("user_e_mail2: " + user_e_mail2);
			
			//UserDao Ŭ���� ȣ��
			UserDao ud = new UserDao(); // UserDao ��ü���� 
			int value = ud.UserInsert(user_id, user_pwd, user_name, user_e_mail, user_e_mail2); // UserInsert()�޼ҵ�� ���� value�� ��´�.
			
			System.out.println("value: " + value); 	//�̰͵� Ȯ�ο����� ���� �� 
			
			// ������ Ŭ���̾�Ʈ�� �ߵƴٰ� �����ϱ����ؼ� �ؿ� �� ������ ���� 
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('ȸ�������� �Ǿ����ϴ�.');</script>");
			out.println("<script>document.location.href='"+request.getContextPath()+"/Main.jsp';</script>");
			
			//response.sendRedirect(request.getContextPath()+"/");
			
		}else if (str.equals("/User/UserJoin.do")) {
			//�ܼ� ȸ������â �̵���
			RequestDispatcher rd = request.getRequestDispatcher("/Join.jsp");
			rd.forward(request, response);		
							
		}else if(str.equals("/User/UserLogin.do")) {
			//�ܼ� �α���â �̵���
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.forward(request, response);		
							
		}else if (str.equals("/User/UserLoginAction.do")) {
			
			//request.getParameter()�޼ҵ�� ID�� PW�� �޾ƿ´�.
			String user_id = request.getParameter("user_id");
			String user_pwd = request.getParameter("user_pwd");
			
			// UserDao Ŭ����  �޼ҵ忡�� ���̵� Ȯ���ϱ�
			UserDao ud = new UserDao(); //��ü����
			UserVo uv = ud.UserLogin(user_id,user_pwd); 
			if(uv != null) {
				HttpSession session = request.getSession(true);
				
				session.setAttribute("user_num", uv.getUser_num());
				session.setAttribute("user_id", uv.getUser_id());
				session.setAttribute("user_name", uv.getUser_name());
				
				PrintWriter out = response.getWriter(); 
				out.println("<script>alert('�α��� �Ǿ����ϴ�.');</script>");
				out.println("<script>document.location.href='"+request.getContextPath()+"/User/Main.do';</script>");
				
			}else {
				PrintWriter out = response.getWriter(); 
				out.println("<script>alert('���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���');</script>");
				out.println("<script>document.location.href='"+request.getContextPath()+"/User/UserLogin.do';</script>");
			}
				
											
		}else if(str.equals("/User/UserLogout.do")) {
			
			HttpSession session = request.getSession(true); // �α׾ƿ��� ��û�� ������� ���ǰ�ü ������
			session.invalidate(); //invalidate() �޼ҵ�� ��������
			
			//����ڿ��� �α׾ƿ����� �˸��� ����ȭ������ ������
			PrintWriter out = response.getWriter(); 
			out.println("<script>alert('�α׾ƿ� �Ǿ����ϴ�.');</script>");
			out.println("<script>document.location.href='"+request.getContextPath()+"/Main.jsp';</script>");
			
		}else if(str.equals("/User/Main.do")) {
			//�ܼ� ����â �̵���
			RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
			rd.forward(request, response);	
			
		}/*else if (str.equals("/User/User_IdCheck.do")) {
			String user_id = request.getParameter("user_id");
			
			UserDao ud = new UserDao();
			int value = ud.User_IdCheck(user_id);
			System.out.println("value:"+value);
			System.out.println("��Ʈ�ѷ����� �Խ��ϴ�");
			//ȭ�鿡 ����Ѵ�
			PrintWriter out = response.getWriter();
		   	out.println("{\"cnt\":\""+value+"\"}");
		   	 	 	
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
