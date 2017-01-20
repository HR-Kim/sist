package sist.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.com.model.CustUserService;

public class CustUserAddControl extends HttpServlet {
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
		
		if(command != null && command.equals("add")){
			CustUserService service = CustUserService.getInstance();
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			
			if(isNull(id) || isNull(name) || isNull(address)){
				System.out.println("모든정보를 입력해야 합니다.");
			}
			
			int count = service.addCustUser(id, name, address);
			if(count == 0){
				System.out.println("추가하지 못했습니다.");
			}
			dispatch("./custListCtr?command=list", req, resp);
		}
	}
	
	public void dispatch(String urls, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(urls);
		dispatch.forward(req, resp);
	}
}
