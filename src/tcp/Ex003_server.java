package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex003_server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(12345);
		while(true) {
			System.out.println("접속을 기다립니다!");
			Socket s = server.accept();
			Socket d = server.accept();
			System.out.println(s.getInetAddress()+"주소");
			System.out.println(d.getInetAddress()+"주소");
			
			OutputStream out = s.getOutputStream();
			OutputStream ot = d.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			DataOutputStream dod = new DataOutputStream(ot);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("클라이언트로 전송할 데이터");
			String sendData = sc.next();
			dos.writeUTF(sendData);
			dod.writeUTF(sendData);
			new Ex003_serverThread(s);
		}
	}

}
