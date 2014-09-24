package com.w1nter.TinyLAN_Beacon;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;

/**
 * A tiny java daemon that keeps track of a local network and
 * publishes the uptime and dynamic IP changes to an external server.
 * 
 * @author Theo Winter
 */
public class BeaconMain {
	static boolean enabled = true;
	static InternalInformation internal = new InternalInformation();
	static ExternalInformation external = new ExternalInformation();
	
	public static void main(String args[]) {
		log("TinyLAN Daemon starting...");
		while(enabled){
			
			long unixTime = System.currentTimeMillis() / 1000L;
			NetworkReport report = new NetworkReport(internal.getLocalIP(), internal.getHostName(), unixTime);
			
			//Add beacon info
			report = external.addInfoToReport(report);
			
			//Add device info
			//TODO: gather data of real network devices
			report.addDevice(internal.getDeviceStatus("127.0.0.1"));
			
			//Submit info
			try {
				Socket server = new Socket("localhost", 8989); //TODO: get from config.
				
		    	OutputStream os = server.getOutputStream();  
		    	ObjectOutputStream oos = new ObjectOutputStream(os);  
		
				oos.writeObject(report);
				
				InputStream is = server.getInputStream();  
	        	ObjectInputStream ois = new ObjectInputStream(is);
				try {
					String response = (String)ois.readObject();
				    log(response);
				} catch (ClassNotFoundException anEx) {
					// TODO Auto-generated catch block
					anEx.printStackTrace();
				}

		    	oos.close();  
		    	os.close();  
		    	server.close();
			} catch (IOException anEx) {
				log("IOException while trying to communicate with tower.");
			}
			//Wait for next cycle
			sleepInSeconds(5);
		}
	}

	private static void sleepInSeconds(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			log("Interrupted while trying to sleep", e);
		}
	}

	public static void log(String s){
		System.out.println(s);
	}
	
	public static void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}
}
