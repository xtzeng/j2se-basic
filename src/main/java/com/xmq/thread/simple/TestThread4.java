package com.xmq.thread.simple;

public class TestThread4 {

	public static void main(String[] args) {
		Runner4 runner4 = new Runner4();
		Thread thread  = new Thread(runner4);
		thread.start();
		for(int i = 0;i<100000;i++){
			if (i%10000==0 & i>  0) {
				System.out.println("in thread maini="+ i);
			}
		}
		
		System.out.println("Thread main is over");
		runner4.shutDown();
//		thread.stop();
	}
}

class Runner4 implements Runnable{
	private boolean flag = true;
	
	@Override
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println("-----------" +i++);
		}
	}
	
	public void shutDown(){
		flag = false;
	}
}