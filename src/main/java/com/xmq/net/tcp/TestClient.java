package com.xmq.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 8888);
			InputStream is =socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
