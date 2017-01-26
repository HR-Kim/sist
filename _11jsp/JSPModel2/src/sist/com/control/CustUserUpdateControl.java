package sist.com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.com.dto.CustUserDto;
import sist.com.model.CustUserService;

public class CustUserUpdateControl extends HttpServlet {
	private boolean isNull(String str){
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
		
		CustUserService service = CustUserService.getInstance();
		
		String command = req.getParameter("command");
		
		if(command != null && command.equals("update")){
			
			String id = req.getParameter("id");
			
			//model 이동 -> data취득
			CustUserDto custdto = service.getCustUser(id);
			req.setAttribute("cust", custdto);
			
			dispatch("custuserupdate.jsp", req, resp);
		}else if(command != null && command.equals("updateModel")){
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			
			if(isNull(id)||isNull(name)||isNull(address)){
				System.out.println("모든 정보를 입력하셔야 합니다.");
				dispatch("custusercontrol.jsp?command=update", req, resp);
			}
			
			// model -> DB의 데이터를 변경!
			int count = service.updateCustUser(id, name, address);
			// list로 이동
			if(count == 0){
				
			}
			dispatch("custDetailCtr?command=detail&id="+id.trim(), req, resp);
		}
	}
	
	
	
	public void dispatch(String urls, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(urls);
		dispatch.forward(req, resp);
	}
}
