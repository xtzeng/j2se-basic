package com.xmq.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocketClient {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			Socket socket = new Socket("localhost", 7777);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeUTF("hey,server");
			String str = null;
			
			if ((str=dis.readUTF())!=null) {
				System.out.println(str);
			}
			
			dos.close();
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
