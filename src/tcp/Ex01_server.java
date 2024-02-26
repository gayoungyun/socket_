package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12345);//포트번호, 2바이트크기
		System.out.println("접속을 기다립니다!");//socket만들어짐
		
		Socket sock = server.accept();//클라이언트가 연결할때까지 기다림
		//클라이언트 정보(sock)
		System.out.println("클라이언트 연결되었습니다!");
		
		InputStream is = sock.getInputStream();
		int readData = is.read();
		System.out.println("수신 데이터 : "+readData);
		//서버먼저 구동된뒤 클라이언트 실행
		is.close(); sock.close(); server.close();
		
	}

}
