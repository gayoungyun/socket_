package tcp;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex003_client02 {
	public static void main(String[] args) throws Exception{
		Socket sock = new Socket("127.0.0.1",12345);
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		String msg = null;
		new Ex003_clientThread(sock);
		
		while(true) {
			System.out.println("전송 데이터 입력");
			msg = sc.next();
			dos.writeUTF(msg);
			System.out.println("데이터 수신함");
		}
	}

}
