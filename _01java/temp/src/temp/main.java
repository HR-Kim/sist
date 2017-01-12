package temp;

import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "250--문자-hello";
		
		StringTokenizer st 
			= new StringTokenizer(str, "-");
		int count = st.countTokens();
		System.out.println("토큰의 갯수:" + count);
		
		int protocol = Integer.parseInt(st.nextToken());
		String to = st.nextToken();
		String msg = st.nextToken();
		
		System.out.println("protocol:" + (protocol + 1));
		System.out.println("to:" + to);
		System.out.println("msg:" + msg);
			
		
		
		String[] split = str.split("-");
				
		System.out.println("split.length:" + split.length);
		System.out.println("split[0]:" + split[0]);
		System.out.println("split[1]:" + split[1]);
		System.out.println("split[2]:" + split[2]);
		System.out.println("split[3]:" + split[3]);
	}

}
