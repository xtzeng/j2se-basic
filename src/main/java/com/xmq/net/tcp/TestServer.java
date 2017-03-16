package com.xmq.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server往外写数据
 * @author xiaoti
 *
 */
public class TestServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				Socket socket = serverSocket.accept();
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hi,"+socket.getInetAddress()+"port#"+socket.getPort()+"bye-bye");
				dos.close();
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
