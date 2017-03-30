package com.xmq.thread.practice;

public class ThreadCreationViaSubClass {
	public static void main(String[] args) {
		CustomThread thread = new CustomThread();
		System.out.println("1---->>>>>>>>"+thread.getState());
		thread.start();
		
		thread.shutDown();
		for (int i = 0; i < 10; i++) {
			System.out.println("2------>>>>>>>>>>" + thread.getState());
		}

	}
	
}

class CustomThread extends Thread {

	private boolean flag = true;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(flag){
			System.out.println(getName()+"---------->>>>>>>>>>>>"+"Running...");
		}

	}
	
	public void shutDown(){
		flag = false;
	}
	
}