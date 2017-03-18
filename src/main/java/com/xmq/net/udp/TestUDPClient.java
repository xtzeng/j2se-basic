package com.xmq.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {

	public static void main(String[] args) throws IOException {
		
		long ll = 1000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(ll);
		
		byte[] buf = baos.toByteArray();
		System.out.println(buf.length);
		
		
		/*byte[] buf = new String("hello,xmq").getBytes();*/
		DatagramPacket dp = new DatagramPacket(buf, buf.length,new InetSocketAddress("127.0.0.1", 56789));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	}
}
