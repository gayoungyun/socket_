package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex004_server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		System.out.println("접속 대기...");
		Socket sock01 = server.accept();
		Socket sock02 = server.accept();
		System.out.println(sock01.getInetAddress());//현재접속한주소
		System.out.println(sock02.getInetAddress());
		
		InputStream in = sock01.getInputStream();
		InputStream is = sock02.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		DataInputStream ds = new DataInputStream(is);
		
		String readData = dis.readUTF();
		System.out.println("수신 데이터 : "+readData);
		
		OutputStream out = sock01.getOutputStream();
		OutputStream ot = sock02.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		DataOutputStream dms = new DataOutputStream(ot);
		
		Scanner input = new Scanner(System.in);
		System.out.println("클라이언트로 전송할 데이터 입력");
		String sendData = input.next();
		dos.writeUTF(sendData);
		
		dis.close(); in.close(); 
		dos.close(); out.close();
		sock01.close(); sock02.close(); server.close();
	}

}
