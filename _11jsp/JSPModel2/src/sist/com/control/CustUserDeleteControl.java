package sist.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.com.dto.CustUserDto;
import sist.com.model.CustUserService;

public class CustUserDeleteControl extends HttpServlet {
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
		
		CustUserService service = CustUserService.getInstance();
		String command = req.getParameter("command");
		
		if(command.equalsIgnoreCase("delete")){
			String id = req.getParameter("id");
			
			// model 이동 -> data 삭제
			int count = service.deleteCustUser(id);
			if(count == 0){
				System.out.println("고객정보 삭제 실패하였습니다");
			}
			// list
			dispatch("./custListCtr?command=list", req, resp);
		}else if(command.equalsIgnoreCase("muldel")){
			String ids[] = req.getParameterValues("delck");
			
			/* for(int i=0; i< ids.length; i++){
				System.out.println("ids[" + i + "] = " + ids[i]);
			} */
			
			//model로 취득한 id꾸러미를 들고 갔다 온다
			boolean isS = service.deleteCustUser(ids);
			
			if(!isS){
				System.out.println("정상적으로 작동하지 못했습니다.");
			}
			dispatch("./custListCtr?command=list", req, resp);
		}
	}
	
	public void dispatch(String urls, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(urls);
		dispatch.forward(req, resp);
	}
}
