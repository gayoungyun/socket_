package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex01_client {
	public static void main(String[] args) throws Exception {
		//192.168.42.121
		Socket sock = new Socket("192.168.42.121", 12345);
		System.out.println("클라이언트 실행!!");
		
		OutputStream os = sock.getOutputStream();//데이터출력, 서버로 데이터전송
		
		Scanner input = new Scanner(System.in);
		System.out.println("수 입력");
		int data = input.nextInt();
		
		os.write(data);//0~255바이트 256입력시 0으로 뜸 그이후는 다시 처음으로 돌아가서1부터
		
		os.close(); sock.close();
		
	}

}
