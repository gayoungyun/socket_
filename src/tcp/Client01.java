package tcp;

import java.io.*;
import java.net.*;
import java.util.*;


public class Client01 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Socket sock = new Socket("192.168.42.44",12345);
		OutputStream out = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);

		MyThread rcv = new MyThread(sock);
		rcv.start();

		while(true) {
			String data = input.next();
			dos.writeUTF(data);
		}
		//dos.close(); out.close(); sock.close();
	}

}



