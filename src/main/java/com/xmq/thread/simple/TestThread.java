package com.xmq.thread.simple;

public class TestThread {
    public static void main(String[] args) {
		
    	Runner1 runner1 = new Runner1();
    	Thread thread = new Thread(runner1);
    	thread.start();
    	
    	for(int i=0;i<100;i++){
    		System.out.println("Main Thread:----"+i);
    	}
	}
}


class Runner1 implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			System.out.println("Runner1 ：" + i);
		}
		
	}
	
}