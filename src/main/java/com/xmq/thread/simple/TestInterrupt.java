package com.xmq.thread.simple;

import java.util.Date;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class TestInterrupt {

	public static void main(String[] args) {
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		myThread1.interrupt(); 不用此方式
		myThread1.flag = false;
	}
	
}

class MyThread1 extends Thread{

	boolean flag = true;
	@Override
	public void run() {
		super.run();
		
		while (flag) {
			System.out.println("----------"+ new Date()+"======");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			
		}
	}
	
}
