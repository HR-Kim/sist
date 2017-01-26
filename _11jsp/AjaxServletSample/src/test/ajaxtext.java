package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ajaxtext extends HttpServlet{

	private static final long serialVersionUID = -3620717640490075110L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//client로부터 전송된 데이터
		String val = req.getParameter("val");
		String num = req.getParameter("num");
		
		System.out.println("val = " + val);
		System.out.println("num = " + num);
		
		try{
			// client로 보내줄 Json
			JSONObject obj = new JSONObject();
			obj.put("result", "성공");
			
			resp.setContentType("application/x-json; charset=UTF-8");
			resp.getWriter().print(obj);
		}catch(JSONException e){
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
}





















