package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
	    PrintWriter out = resp.getWriter();
	    req.setCharacterEncoding("UTF-8");
	    
	    String man_lady[] = req.getParameterValues("manlady");
	    
	    if(man_lady[0].equals("남성")){
	    	String display = "forwardman";
	    	RequestDispatcher dispatch = req.getRequestDispatcher(display);
	    	dispatch.forward(req, resp);
	    }else{
	    	String display = "forwardlady";
	    	RequestDispatcher dispatch = req.getRequestDispatcher(display);
	    	dispatch.forward(req, resp);
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
