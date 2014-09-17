package com.w1nter.TinyLAN_Beacon;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.w1nter.TinyLAN_Beacon.ExternalInformationSource;

public class Tests {
	ExternalInformationSource tracker = new ExternalInformationSource();

	@Test
	public void testGetIP(){
		String ip = null;
		try {
			ip = tracker.getIP();
		} catch (ParserConfigurationException | SAXException | IOException anEx) {
			anEx.printStackTrace();
			fail();
		}
		if(!(ip.length()>0 && ip != null)){
			fail();
		}
		System.out.println("IP Demo: "+ip);
	}
}
