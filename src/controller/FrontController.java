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
		//가상경로와 같은지 확인한다
		String uri = request.getRequestURI(); //요청 값의 하부경로까지 다 나오게해줌->위치 알아야지 
		String projectname = request.getContextPath(); //프로젝트 Path만 가져옵니다 ->파일의 위치(경로) 찾아옴. 길 잡아주기위함
		int jarinum = projectname.length(); // length()는 문자열 길이를 말해주는데 이게 왜 필요한지 어디에 쓰이는 건지 모르겟엉->일단 문자열 구분을 위해 만들어짐
		String str = uri.substring(jarinum); // 경로길이를 문자별로 나눠서 알려줄거야
			
		String[] po = str.split("/"); //문자열을 나누는데 뭘로 나눌거냐 str을 split("/")로 나눌거야 ex)/User/UserJoinAction.do
		String hc = po[1]; // 첫번째 배열은 hc로 담을거다
			
			if (hc.equals("MVC2")) { 
				MVC2Controller MC = new MVC2Controller();
				MC.doGet(request, response); 
				/** hc가 "MVC2"와 같다는 조건을 만들어줌 ->같다면 /MVC2로 시작하는 주소로 보내줄거야
				 * new MVC2Controller();를 담아줄 생성자를 만들어줌 MC임
				 * MC에서 얻어올거다(요청하고 응답할것을)->/MVC2로 시작하는 주소에서
				**/
			}else if (hc.equals("User")) {			
				UserController uc = new UserController();
				uc.doGet(request, response);
				
				System.out.println("front는 된다."); //이건 콘솔 확인용
			}
	}	
				
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
