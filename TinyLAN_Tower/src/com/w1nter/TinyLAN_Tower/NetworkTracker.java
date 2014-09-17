package com.w1nter.TinyLAN_Tower;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;

public class NetworkTracker extends Thread {
	ArrayList<NetworkReport> reportList;

	@Override
	public void run() {
		try {
		    ServerSocket server = new ServerSocket(8989);
			
		    while (true) {
		        Socket client = server.accept();
	
		        //answer to client
		        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		        out.println("333 OK");
		    }
		} catch (IOException e) {
			log("IOException in NetworkTracker Server", e);
		}
	}

	public void log(String s){
		System.out.println(s);
	}
	
	public void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}

}
