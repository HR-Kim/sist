package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class ServletClass extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	    
	    Cookie cookie = new Cookie("visited", "1");
	    resp.addCookie(cookie);
	    
	      out.println("<html>");
	      out.println("<head>");
	      out.println("</head>");
	      out.println("<body>");
	      //out.println("<b>쿠키명:</b>" + cookie.getName() + " " + cookie.getValue());
	      out.println("<p>쿠키를 저장했습니다.</p>");
	      
	      out.println("<a href=\"dispVal\">쿠키를 표시</a>");
	      
	      out.println("</body>");
	      out.println("</html>");
	      
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
   
   /*
    * Cookie : 저장을 하기 위한 요소
    * 			Client에 저장
    * 
    */

	
}