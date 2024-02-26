package tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Ex001_clientThread extends Thread{
	Socket sock;
	public Ex001_clientThread(Socket sock) {
		this.sock = sock;
		start();
	}
	public void run() {
		try {
			InputStream in = sock.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			while(true) {
				String data = dis.readUTF();
				System.out.println("수신 데이터 : "+data);
			}
		}catch (Exception e) {

		}
	}

}
