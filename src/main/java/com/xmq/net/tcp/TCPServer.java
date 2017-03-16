package com.xmq.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(6666);
		while(true){
			Socket socket = serverSocket.accept();//accept是阻塞式的
			System.out.println("A client connect...");
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println(dis.readUTF());//readUTF也是阻塞式的
			dis.close();
			socket.close();
		}
		
	}
}
