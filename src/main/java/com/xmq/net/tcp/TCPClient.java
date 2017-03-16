package com.xmq.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1",6666);//申请连接
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(30000);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		socket.close();
	}
}
