package sample07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	    
	    HttpSession session = req.getSession(false);	// 세션이 존재하지 않는 경우 false로 되어있으면 null로 반환
	    
	    /*
	     * Session : 쿠키와 비슷 
	     * 			Server측 저장
	     */
	    
	    
	    out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        
        
        /*if(session == null){
        	out.println("<p>세션이 존재하지 않습니다. 시작합니다</p>");
        	session = req.getSession(true);
        	session.setAttribute("sVisit", "1");
        	
        }else{
        	out.println("<p>세션을 시작합니다.</p>");
        	
        	String sVisitStr = (String)session.getAttribute("sVisit");
        	int visited = Integer.parseInt(sVisitStr);
        	System.out.println("visited = " + visited);
        	visited++;
        	
        	out.println("<p>방문 횟수:");
        	out.println(visited);
        	out.println("</p>");
        	
        	session.setAttribute("sVisit", Integer.toString(visited));
        }*/
        
        /*if(session != null){
        	session.removeAttribute("sVisit");
        }*/
        
        session = req.getSession(true);
        
        session.setAttribute("ss1", "1");
        session.setAttribute("ss2", "10");
        session.setAttribute("ss3", "100");
        //session은 맵으로 관리되기 때문에 트리구조로 되어있다.
        if(session != null){
        	out.println("<p>");
        	
        	Enumeration enum_session = session.getAttributeNames();
        	
        	while(enum_session.hasMoreElements()){
        		String key = (String)enum_session.nextElement();
        		String value = (String)session.getAttribute(key);
        		
        		out.println(key + ":" + value + "<br>");
        	}
        	out.println("</p>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
        
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}



































