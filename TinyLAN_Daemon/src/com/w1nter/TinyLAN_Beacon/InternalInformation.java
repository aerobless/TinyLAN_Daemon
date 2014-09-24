package com.w1nter.TinyLAN_Beacon;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.w1nter.TinyLAN_Beacon.DataObjects.DeviceStatus;

public class InternalInformation {

	public String getHostName(){
		String hostname = "Unknown";
		try{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		} catch (UnknownHostException e){
			BeaconMain.log("Hostname can not be resolved", e);
		}
		return hostname;
	}
	
	public String getLocalIP(){
		String ip = "unkown";
		try {
			ip = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			BeaconMain.log("UnknownHostException", e);
		}
		return ip;
	}
	
	public DeviceStatus getDeviceStatus(String ip){
		boolean reachable = false;
		String hostname = "unknown";
		try {
			reachable = InetAddress.getByName(ip).isReachable(100);
			hostname =InetAddress.getByName(ip).getHostName();
		} catch (IOException e) {
			BeaconMain.log("IOException while trying to get the DeviceStatus of: "+ip, e);
		}
		return new DeviceStatus(hostname, ip, reachable);
	}	
}
