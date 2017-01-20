package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class ServletClass extends HttpServlet {
   
   int count = 0;

   @Override                   //요청               //응답 -> 서버로부터 받은DATA를 뿌려줌 
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                        // request는 사용하는 함수가 많고 response는 하나정도만 알면된다.
      System.out.println("doGet");
      resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
      PrintWriter out = resp.getWriter();
      
      String name = req.getParameter("name");
      String tmp = req.getParameter("age");
      int age;
      if(tmp == null || tmp.length() == 0){
    	  age = -1;
      }else{
    	  try{
    		  age = Integer.parseInt(req.getParameter("age"));
    	  }catch(NumberFormatException e){
    		  age = -1;
    	  }
      }
      
      String fruit[] = req.getParameterValues("fruit");
      
	  StringBuffer sb =new StringBuffer(); // 버퍼는 저장공간 
      sb.append("<html>");
      sb.append("<head>");
      sb.append("</head>");
      sb.append("<body>");
      
      sb.append("<p>이름:");
      sb.append(name);
      sb.append("</p>");
      
      sb.append("<p>나이:");
      if(age == -1){
    	  sb.append("미지정입니다");
      }else{
    	  sb.append(age + "살입니다.");  
      }
      sb.append("</p>");
      
      sb.append("<p>좋아하는 과일은 ");
      if(fruit != null){
    	  for(int i = 0; i<fruit.length; i++){
    		  sb.append(fruit[i] + " ");
    	  }
    	  sb.append("입니다</p>");
      }else{
    	  sb.append("선택되지 않았습니다.</p>");
      }
      
      sb.append("</body>");
      sb.append("</html>");
      
      out.println(sb); //같은 함수라서 동적할당 안해줘도된다.
      out.close();
      
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("doPost");
      resp.setContentType("text/html; charset=UTF-8"); //인코딩 한글깨짐 방지 응답 부분에서 이걸해줘야함 
      PrintWriter out = resp.getWriter();
      req.setCharacterEncoding("UTF-8");
      String name = req.getParameter("name");
      String tmp = req.getParameter("age");
      int age;
      if(tmp == null || tmp.length() == 0){
    	  age = -1;
      }else{
    	  try{
    		  age = Integer.parseInt(req.getParameter("age"));
    	  }catch(NumberFormatException e){
    		  age = -1;
    	  }
      }
      
      String fruit[] = req.getParameterValues("fruit");
      
	  StringBuffer sb =new StringBuffer(); // 버퍼는 저장공간 
      sb.append("<html>");
      sb.append("<head>");
      sb.append("</head>");
      sb.append("<body>");
      
      sb.append("<p>이름:");
      sb.append(name);
      sb.append("</p>");
      
      sb.append("<p>나이:");
      if(age == -1){
    	  sb.append("미지정입니다");
      }else{
    	  sb.append(age + "살입니다.");  
      }
      sb.append("</p>");
      
      sb.append("<p>좋아하는 과일은 ");
      if(fruit != null){
    	  for(int i = 0; i<fruit.length; i++){
    		  sb.append(fruit[i] + " ");
    	  }
    	  sb.append("입니다</p>");
      }else{
    	  sb.append("선택되지 않았습니다.</p>");
      }
      
      sb.append("</body>");
      sb.append("</html>");
      
      out.println(sb); //같은 함수라서 동적할당 안해줘도된다.
      out.close();
   }
   
   

}