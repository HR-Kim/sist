package sist.jsp;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static {
		
		System.out.println("HelloWorldServlet.static{}");
		
	}
	
	{
		
		System.out.println("HelloWorldServlet.{}");
		
	}
	
	public HelloWorld() {
		
		super();
		
		System.out.println("HelloWorldServlet.Constructor()");
		
	}
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("HelloWorldServlet.init()");
		
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("HelloWorldServlet.init(ServletConfig)");
		
		super.init(config);
	}
	
	@Override
	public void destroy() {
		
		System.out.println("HelloWorldServlet.destroy()");
		
		super.destroy();
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.service(ServletRequest, ServletResponse)");
		
		super.service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.service(HttpServletRequest, HttpServletResponse)");
		
		super.service(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doGet(HttpServletRequest, HttpServletResponse)");
		
		super.doGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doPost(HttpServletRequest, HttpServletResponse)");
		
		super.doPost(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doPut(HttpServletRequest, HttpServletResponse)");
		
		super.doPut(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doDelete(HttpServletRequest, HttpServletResponse)");
		
		super.doDelete(request, response);
	}
	
	@Override
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doHead(HttpServletRequest, HttpServletResponse)");
		
		super.doHead(request, response);
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doOptions(HttpServletRequest, HttpServletResponse)");
		
		super.doOptions(request, response);
	}
	
	@Override
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HelloWorldServlet.doTrace(HttpServletRequest, HttpServletResponse)");
		
		super.doTrace(request, response);
	}
	
}