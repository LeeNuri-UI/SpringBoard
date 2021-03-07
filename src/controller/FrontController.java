package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ο� ������ Ȯ���Ѵ�
		String uri = request.getRequestURI(); //��û ���� �Ϻΰ�α��� �� ����������->��ġ �˾ƾ��� 
		String projectname = request.getContextPath(); //������Ʈ Path�� �����ɴϴ� ->������ ��ġ(���) ã�ƿ�. �� ����ֱ�����
		int jarinum = projectname.length(); // length()�� ���ڿ� ���̸� �����ִµ� �̰� �� �ʿ����� ��� ���̴� ���� �𸣰پ�->�ϴ� ���ڿ� ������ ���� �������
		String str = uri.substring(jarinum); // ��α��̸� ���ں��� ������ �˷��ٰž�
			
		String[] po = str.split("/"); //���ڿ��� �����µ� ���� �����ų� str�� split("/")�� �����ž� ex)/User/UserJoinAction.do
		String hc = po[1]; // ù��° �迭�� hc�� �����Ŵ�
			
			if (hc.equals("MVC2")) { 
				MVC2Controller MC = new MVC2Controller();
				MC.doGet(request, response); 
				/** hc�� "MVC2"�� ���ٴ� ������ ������� ->���ٸ� /MVC2�� �����ϴ� �ּҷ� �����ٰž�
				 * new MVC2Controller();�� ����� �����ڸ� ������� MC��
				 * MC���� ���ðŴ�(��û�ϰ� �����Ұ���)->/MVC2�� �����ϴ� �ּҿ���
				**/
			}else if (hc.equals("User")) {			
				UserController uc = new UserController();
				uc.doGet(request, response);
				
				System.out.println("front�� �ȴ�."); //�̰� �ܼ� Ȯ�ο�
			}
	}	
				
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
