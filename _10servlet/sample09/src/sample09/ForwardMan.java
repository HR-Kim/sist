package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardMan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    req.setCharacterEncoding("UTF-8");
	    
	    out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        
        String age[] = req.getParameterValues("age");
        String pay[] = req.getParameterValues("pay");
        
        out.println("<p>");
        out.println("남성용 홈페이지입니다.");
        out.println("</p>");
        
        out.println("<p>");
        out.println("나이:" + age[0] + ", 연수입 :" + pay[0]);
        out.println("</p>");
        
        out.println("</body>");
        out.println("</html>");
	}
	
}














