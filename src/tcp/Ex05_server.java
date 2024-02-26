package tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Ex05_Thread extends Thread{//start run메서드 수행
	public static int num = 1;//
	private Socket sock;
	public Ex05_Thread(Socket sock) {
		this.sock = sock;
		start();
	}
	@Override
	public void run() {
		num++;//
		InputStream in;
		String readData = null;
		while(true) {
			try {
				in = sock.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				readData = dis.readUTF();
				System.out.println("수신 데이터 : "+readData);
			}catch (Exception e) {
				
			}
			/*
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
			//System.out.println(num+"클라이언트 접속");
		}
	}
}
public class Ex05_server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12345);
		//이게 븍록 당한다
		while(true) {
			Socket sock = server.accept();
			new Ex05_Thread(sock);
		}

	}
}
