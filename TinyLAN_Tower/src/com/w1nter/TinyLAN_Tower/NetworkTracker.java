package com.w1nter.TinyLAN_Tower;

public class NetworkTracker extends Thread {

	private void sleepInSeconds(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			log("Interrupted while trying to sleep", e);
		}
	}
	
	public void log(String s){
		System.out.println(s);
	}
	
	public void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}

	@Override
	public void run() {
		while(true){
			log("tracking.. ");
			sleepInSeconds(5);
		}
	}


}
