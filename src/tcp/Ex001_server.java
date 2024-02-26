package tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex001_server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(12345);
		while(true) {
			System.out.println("접속을 기다립니다001");
			Socket s= server.accept();
			System.out.println(s.getInetAddress()+"님 접속001");
			new Ex001_serverThread(s);
		}
	}

}
