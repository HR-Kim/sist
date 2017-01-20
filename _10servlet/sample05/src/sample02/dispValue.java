package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dispValue extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	    
	    Cookie cookie[] = req.getCookies();
	    
	    out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
       
        if(cookie != null){
        	for(int i=0; i<cookie.length; ++i){
        		if(cookie[i].getName().equals("visited")){
        			String value = cookie[i].getValue();
        			
        			out.println("<p>");
        			out.println(cookie[i].getName());
        			out.println("=");
        			out.println(value);
        			out.println("</p>");
        		}
        	}
        }
      
        out.println("</body>");
        out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
