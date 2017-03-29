package com.xmq.thread.simple;

public class TestThread2 {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		
		for(int i=0;i<100;i++){
    		System.out.println("Main Thread:----"+i);
    	}
	}
}



class MyThread extends Thread{

	@Override
	public void run() {
		super.run();
		for(int i =0;i<100;i++){
			System.out.println("MyThread---------"+i);
		}
	}
	
	
}