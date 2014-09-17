package com.w1nter.TinyLAN_Beacon;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternalInformation {

	public InternalInformation() {
		// TODO Auto-generated constructor stub
	}
	
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

}
