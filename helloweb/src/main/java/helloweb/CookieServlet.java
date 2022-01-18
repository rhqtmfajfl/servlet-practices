package helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COOKIE_NAME = "visitcount";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int visitCount =0;
		
		
		//쿠키 읽기 
		Cookie[] cookies = request.getCookies(); // 모든 쿠키는 받아와서 배열로 받는다.
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(COOKIE_NAME.equals(cookie.getName())) {  //첫번째 요청시 쿠키 네임이 안와서 안으로 안들어간다.
					visitCount = Integer.parseInt(cookie.getValue());
					break;
				}
				
			}
		}
		
		visitCount++;  //1 쿠키 1 이 나온다.
		
		
		//쿠키 쓰기(굽기)  쿠키 구워라고 나온다.
		Cookie cookie = new Cookie(COOKIE_NAME, String.valueOf(visitCount));
		cookie.setPath(request.getContextPath());
		
		cookie.setMaxAge(24 * 60 * 60); // 1 day
		
		response.addCookie(cookie); //이러면 set 쿠키로 나간다.
		
		
		//화면 출력  Cookie: visitcount=1  f12에 net
		response.setContentType("text/html; charset=utf-8"); //여기서 쿠키가 1인것 확인  다음에 쿠키 읽기에서 1이 넘어간다.
		PrintWriter out = response.getWriter();
		out.println("<h1> 방문 횟수 : " + visitCount + "</h1>");
		//처음 방문하게 되면 쿠키는 0 ㅣㅇ다.
		//
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
