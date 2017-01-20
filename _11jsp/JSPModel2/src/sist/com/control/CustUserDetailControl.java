package sist.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.com.dto.CustUserDto;
import sist.com.model.CustUserService;

public class CustUserDetailControl extends HttpServlet {
	boolean isNull(String str){
		return str == null || str.trim().equals("");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----------------1");
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String command = req.getParameter("command");
		
		if(command != null && command.equals("detail")){
			CustUserService service = CustUserService.getInstance();
			
			String id = req.getParameter("id");
			
			CustUserDto custdto = service.getCustUser(id);
			//송신
			req.setAttribute("cust", custdto);

			dispatch("custuserdetail.jsp", req, resp);
		}else if(command != null && command.equals("delete")){
			CustUserService service = CustUserService.getInstance();
			
			
		}
	}
	
	public void dispatch(String urls, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(urls);
		dispatch.forward(req, resp);
	}
}
