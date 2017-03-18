package com.xmq.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class TestUDPServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket ds = new DatagramSocket(56789);
		
		while(true){
			ds.receive(dp);
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readLong());
	/*		System.out.println(new String(buf,0,dp.getLength()));*/
		}
			
	}
}
