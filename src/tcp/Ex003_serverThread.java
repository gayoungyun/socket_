package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Ex003_serverThread extends Thread{
	public static ArrayList<Socket> arr;
	static {
		arr = new ArrayList<>();
	}
	private Socket s;
	public Ex003_serverThread(Socket s) {
		arr.add(s);
		this.s = s;
		start();
	}
	public void run() {
		try {
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				String msg = dis.readUTF();
				for(Socket ss : arr) {
					OutputStream os = s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);
					dos.writeUTF(msg);
				}
			}
		}catch (Exception e) {
			
		}
	}

}


