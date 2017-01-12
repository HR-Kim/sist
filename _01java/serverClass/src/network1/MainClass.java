package network1;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 종단 시스템 : host = pc, 워크스테이션, pda, printer, scanner
		 * 
		 * router : hardware
		 * 
		 * protocol : 통신규약 (TCP, UDP)
		 * 
		 * 7 layer
		 * 	1계층 : Physical layer
		 *  2계층 : Data Link layer
		 *  3계층 : Network layer
		 *  4계층 : Transport layer	- TCP / UDP
		 *  5계층 : Session layer
		 *  6계층 : Presentation layer
		 *  7계층 : Application layer 
		 * 
		 * TCP : Transmission Control Protocol
		 * 		신사적인 통신규약 = 연결형 통신규약
		 * 		전화, 채팅
		 * 		1 대 1 통신(unicast)
		 * 			따라서 누가 발신했는지 체크해줄 수 있는 Thread가 필요!
		 * UDP : User Datagram Protocol
		 * 		비연결형 통신규약 = 
		 * 		편지, 지상파와 비슷아
		 * 		1 대 1 뿐만아니라 1 대 다 통신까지 가능(broadcast)
		 * 		다 대 다 (multicast)
		 *
		 * Packet : 제어 정보가 결합된 형태로 실제 데이터가 전송되는 요소를 의미
		 * 		TCP/UDP 정보와 함께
		 * 		메세지 == 문자열
		 * 		
		 * IP : Internet Protocol
		 * 		0 ~ 255.0~255.0~255.0~255
		 * 		IPv4
		 * 		host를 구별하기 위해 host를 구별해주는 것이 IP
		 * 
		 * Port(Number) : 프로세스 구별을 하기 위한 고유 번호
		 * 		패킷이 알맞은 프로세스로 발수신 될 수 있도록 프로세스를 구별해 주는 것이 port
		 * 		1024 까지는 내부에서 이미 정해져 있기 때문에 2000번 이상으로 설정해주는 것이 안전하다.
		 * 
		 * Socket : 통신을 하기 위한 중요 요소
		 *		네트워크를 하기 위한 관문
		 *		여러개 있을 수 있다. 
		 *
		 * 
		 * 
		 * 
		 * 
		 * 	 
		 */
		
	}

}
