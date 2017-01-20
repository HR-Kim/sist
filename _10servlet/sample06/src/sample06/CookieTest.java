package sample06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	    
	    out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        
        Cookie cookie[] = req.getCookies();
        Cookie visitedCookie = null;
        
        if(cookie != null){
        	for(int i=0; i<cookie.length; ++i){
        		if(cookie[i].getName().equals("visit")){
        			visitedCookie = cookie[i];
        		}
        	}
        	
        	if(visitedCookie != null){
            	int visited = Integer.parseInt(visitedCookie.getValue()) + 1;
            	
            	out.println("<p>");
            	out.println(visited);
            	out.println("번째 방문입니다.");
            	out.println("</p>");
            	
            	visitedCookie.setValue(Integer.toString(visited));
            	resp.addCookie(visitedCookie);
            }else{
            	out.println("<p>첫번째 방문입니다</p>");
            	
            	Cookie newCookie = new Cookie("visit", "1");
            	newCookie.setMaxAge(3600);
            	resp.addCookie(newCookie);
            }
        }else{
        	out.println("<p>첫번째 방문입니다</p>");
        	
        	Cookie newCookie = new Cookie("visit", "1");
        	resp.addCookie(newCookie);
        }
        
        out.println("<a href=\"HiHj\"");
        
        out.println("</body>");
        out.println("</html>");
        
        
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}



































