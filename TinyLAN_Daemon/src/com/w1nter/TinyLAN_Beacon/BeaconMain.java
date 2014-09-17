package com.w1nter.TinyLAN_Beacon;

import com.w1nter.TinyLAN_Beacon.DataObjects.DeviceStatus;
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
			NetworkReport report = new NetworkReport();
			
			//Add beacon info
			report.setBeaconName(internal.getHostName());
			report.setBeaconIP(internal.getLocalIP());
			report = external.addInfoToReport(report);
			
			//Add device info
			//TODO: gather data of real network devices
			report.addDevice(new DeviceStatus("Test Device", "192.0.0.1", true));
			
			//Submit info
			
			
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
