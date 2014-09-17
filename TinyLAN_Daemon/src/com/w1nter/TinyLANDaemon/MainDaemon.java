package com.w1nter.TinyLANDaemon;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;



/**
 * A tiny java daemon that keeps track of a local network and
 * publishes the uptime and dynamic IP changes to an external server.
 * 
 * @author Theo Winter
 */
public class MainDaemon {
	static boolean enabled = true;
	static InformationTracker tracker = new InformationTracker();
	
	
	public static void main(String args[]) {
		log("TinyLAN Daemon starting...");
		while(enabled){
			try {
				System.out.println(tracker.getIP());
			} catch (ParserConfigurationException | SAXException | IOException e) {
				log("Error while trying to get information from the external source..", e);
			}
			
			//Temp
			try {
				Thread.sleep(5000);
			} catch (InterruptedException anEx) {
				// TODO Auto-generated catch block
				anEx.printStackTrace();
			}
		}
	}
	
	
	
	public static void log(String s){
		System.out.println(s);
	}
	
	public static void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}
}
