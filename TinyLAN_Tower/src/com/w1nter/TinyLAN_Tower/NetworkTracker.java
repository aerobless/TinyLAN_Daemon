package com.w1nter.TinyLAN_Tower;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;

public class NetworkTracker extends Thread {
	ArrayList<NetworkReport> reportList = new ArrayList<NetworkReport>();
	
	@Override
	public void run() {
		ServerSocket server = null;
		try {
			//TODO: read from config
		    server = new ServerSocket(8989);
			
		    while (true) {
		        Socket client = server.accept();
		        
		        InputStream is = client.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				
				//Get report & store it
				try {
					NetworkReport networkReportFromClient = (NetworkReport) ois.readObject();
					addReport(networkReportFromClient);
				} catch (ClassNotFoundException e) {
					log("NetworkReport Class not found", e);
				}
				
				//Send Response
				OutputStream os = client.getOutputStream();  
				ObjectOutputStream oos = new ObjectOutputStream(os); 
				oos.writeObject("333 THX");

				oos.close();  
				os.close();  	
				is.close();  
				client.close();
		    }
		} catch (IOException e) {
			log("IOException in NetworkTracker Server", e);
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				log("IOException while trying to close the server connection..", e);
			}
		}
	}

	private void addReport(NetworkReport networkReportFromClient) {
		for(int i = 0; i<reportList.size(); i++){
			if(beaconExists(networkReportFromClient, i)){
				reportList.set(i, networkReportFromClient);
			} else {
				reportList.add(networkReportFromClient);
			}
		}
	}

	private boolean beaconExists(NetworkReport networkReportFromClient, int i) {
		return reportList.get(i).getBeaconName().equals(networkReportFromClient.getBeaconName());
	}

	public void log(String s){
		System.out.println(s);
	}
	
	public void log(String s, Exception e){
		System.out.println(s+ e.getMessage());
	}
	
	public synchronized ArrayList<NetworkReport> getReports(){
		return reportList;
	}
}
