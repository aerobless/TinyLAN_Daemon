package com.w1nter.TinyLANDaemon;


/**
 * A tiny java daemon that keeps track of a local network and
 * publishes the uptime and dynamic IP changes to an external server.
 * 
 * @author Theo Winter
 */
public class MainDaemon {
	static boolean enabled = true;
	
	public static void main(String args[]) {
		log("TinyLAN Daemon starting...");
		while(enabled){
			
		}
	}
	
	
	
	public static void log(String s){
		System.out.println(s);
	}
	
	public static void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}
}
