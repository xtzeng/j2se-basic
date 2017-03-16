package com.xmq.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocketServer {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			Socket socket = serverSocket.accept();
			in = socket.getInputStream();
			out = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			String str = null;
			if ((str = dis.readUTF())!=null) {
				System.out.println(str);
				System.out.println("from==>>>"+socket.getInetAddress());
				System.out.println("Port#==>>>"+socket.getPort());
			}
			dos.writeUTF("hello,clients");
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
