package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Ex06_serverThread extends Thread{//사용자에게 데이터를 모두 보내는
	public static ArrayList<Socket> arr;
	static {
		arr = new ArrayList<>();
	}
	private Socket s;
	public Ex06_serverThread(Socket s) {
		arr.add(s);
		this.s = s;
		start();
	}
	public void run() {
		try {
			//InputStream in = arr.get(arr.size()-1).getInputStream();
			InputStream in = s.getInputStream();//위에처럼써도 된다(private this추가)
			DataInputStream dis = new DataInputStream(in);
			while(true) {
				String msg = dis.readUTF();
				for(Socket ss : arr) {
					OutputStream out = ss.getOutputStream();
					DataOutputStream dos = new DataOutputStream(out);
					dos.writeUTF(msg);
				}
			}
		}catch (Exception e) {
			
		}
		
	}
}



