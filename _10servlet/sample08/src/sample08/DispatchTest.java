package sample08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchTest extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	    
	    out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<p>이 밑이 include처리 되어 있습니다.</p>");
        
        /*dispatch : 붙인다
        	- include
        	- forward*/
        
        String display = "includetest";
        RequestDispatcher dispatch = req.getRequestDispatcher(display);
        //dispatch.include(req, resp);	//추가가 되는 부분
        dispatch.forward(req, resp);	// 이동이 되는 부분
        
        out.println("<p>이 위가 include처리 되어 있습니다.</p>");
        
        out.println("</body>");
        out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    
	    req.setCharacterEncoding("UTF-8");
	}
	
}
