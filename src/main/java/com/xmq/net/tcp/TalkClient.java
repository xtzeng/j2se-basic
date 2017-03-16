package com.xmq.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import sun.misc.OSEnvironment;

public class TalkClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String str = null;
			str = sin.readLine();
			while (!str.equals("bye")) {
				pw.println(str);
				pw.flush();
				System.out.println("Client:"+str);
				System.out.println("Server:"+br.readLine());
				str = sin.readLine();
			}
			
			pw.close();
			br.close();
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
