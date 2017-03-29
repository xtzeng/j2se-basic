package com.xmq.thread.simple;

import com.sun.javafx.font.t2k.T2KFactory;

public class TestJoin {

	public static void main(String[] args) {
		MyThread2 thread2 = new MyThread2("thread2");
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			
		}
		
		for(int i=1;i<=10;i++){
			System.out.println("i am main thread");
		}
	}
}



class MyThread2 extends Thread {
	
	public MyThread2(String s) {
		super(s);
	}
	
	public void run(){
		for(int i = 1;i<=10;i++){
			System.out.println("i-------->>>>"+getName());
			try{
				sleep(1000);
			}catch (InterruptedException e){
				return;
			}
			
		}
	}
}