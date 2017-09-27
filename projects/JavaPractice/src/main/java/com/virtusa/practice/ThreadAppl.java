package com.virtusa.practice;

public class ThreadAppl implements Runnable {

	@Override
	public void run() {
		System.out.println("inside the run method");
		String array[]={"abcd","efgh","ijgl","mnop"};
		
		for (int i = 0; i < array.length; i++) {
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				 
				return;
			}
			
			System.out.println(array[i]);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new ThreadAppl()).start();
		
		
	}

}
