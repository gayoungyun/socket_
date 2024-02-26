package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex04_client {
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("127.0.0.1",12345);
		Scanner input = new Scanner(System.in);
		
		OutputStream out = sock.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		
		Ex04_DTO dto = new Ex04_DTO();
		System.out.println("이름 입력");
		dto.setName(input.next());
		System.out.println("주소 입력");
		dto.setAddr(input.next());
		
		oos.writeObject(dto);
		oos.close(); out.close(); sock.close();
	}
}
