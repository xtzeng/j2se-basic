package com.xmq.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import sun.misc.OSEnvironment;

public class TalkServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket(9999);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Socket socket = null;
			
			try {
				socket = serverSocket.accept();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Client:" + br.readLine());
			line = sin.readLine();
			while (!line.equals("bye")) {
				pw.println(line);
				pw.flush();
				System.out.println("Server:"+line);
				System.out.println("Client:"+br.readLine());
				line = sin.readLine();
				
			}
			
			br.close();
			pw.close();
			socket.close();
			serverSocket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
