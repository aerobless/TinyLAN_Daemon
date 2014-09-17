package com.w1nter.TinyLAN_Beacon;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;

public class Tests {
	ExternalInformation external = new ExternalInformation();
	InternalInformation internal = new InternalInformation();

	@Test
	public void testGetIP(){
		NetworkReport report = new NetworkReport();
		report = external.addInfoToReport(report);

		if(!(report.getNetworkInternetIP().length()>0 && report.getNetworkInternetIP() != null)){
			fail();
		}
		System.out.println("IP Demo: "+report.getNetworkInternetIP());
	}
	
	@Test
	public void testGettingHostname(){
		String hostname = internal.getHostName();
		if(hostname.equals("Unkown")){
			System.out.println("FAIL: Hostname unkown..");
			fail();
		}
		System.out.println("Hostname Demo: "+hostname);
	}
}
