package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Ex003_clientThread extends Thread{
	Socket sock;
	public Ex003_clientThread(Socket sock) {
		this.sock = sock;
		start();
	}
	public void run() {
		try {
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				String data = dis.readUTF();
				System.out.println("수신 데이터 : "+data);
			}
			OutputStream out = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
		}catch (Exception e) {
		}
	}

}
