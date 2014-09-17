package com.w1nter.TinyLAN_Beacon;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;

public class Tests {
	ExternalInformationSource tracker = new ExternalInformationSource();

	@Test
	public void testGetIP(){
		NetworkReport report = new NetworkReport();
		report = tracker.insertExternalInformation(report);

		if(!(report.getNetworkInternetIP().length()>0 && report.getNetworkInternetIP() != null)){
			fail();
		}
		System.out.println("IP Demo: "+report.getNetworkInternetIP());
	}
}
