package com.w1nter.TinyLAN_Tower.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.w1nter.TinyLAN_Beacon.DataObjects.NetworkReport;
import com.w1nter.TinyLAN_Tower.NetworkTracker;

/**
 * Servlet implementation class TowerServlet
 */
//@WebServlet("/TowerServlet")
public class TowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NetworkTracker tracker;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TowerServlet() {
        super();
        tracker = new NetworkTracker();
        tracker.start();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		ArrayList<NetworkReport> reportList = tracker.getReports();
		if(reportList.size()==0){
			printEmptyReportListError(out);
		} else {
			printLANStatusAsText(out, reportList);
		}
		
	}

	private void printEmptyReportListError(PrintWriter out) {
		System.out.println("empty reportlist");
		out.println("Tower Servlet:");
		out.println("Everything seems to be working, but the tower hasn't received any reports from the");
		out.println("beacons yet.. please make sure that at least one beacon is running :)!");
	}

	private void printLANStatusAsText(PrintWriter out,
			ArrayList<NetworkReport> reportList) {
		for(int i=0; i<reportList.size(); i++){
			out.println("----<<"+reportList.get(i).getBeaconName()+">>----");
			out.println("  Global IP: "+reportList.get(i).getNetworkInternetIP());
			out.println("   Local IP: "+reportList.get(i).getBeaconIP());
			out.println("       City: "+reportList.get(i).getBeaconCity());
			out.println("     Region: "+reportList.get(i).getBeaconRegion());
			out.println("    Country: "+reportList.get(i).getBeaconCountry());
			out.println();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
