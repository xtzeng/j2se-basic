package com.xmq.net.simple;


import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
  
public class ManyClientServer {  
    private Socket client = null;  
      
    public ManyClientServer() {  
        try {  
            ServerSocket server = new ServerSocket(ArgumentsUtil.port);  
            while(true){  
                client = server.accept();  
                //print the context that is sent by client, and say hello to every client.  
                new ServerThread(client).start();  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
    public static void main(String[] args) {  
        new ManyClientServer();  
    }  
}  
