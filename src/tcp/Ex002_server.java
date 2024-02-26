package tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex002_server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(12345);
		while(true) {
			System.out.println("접속을 기다립니다002");
			Socket s = server.accept();
			System.out.println(s.getInetAddress()+"님 주소002");
			new Ex002_serverThread(s);
		}
	}

}
