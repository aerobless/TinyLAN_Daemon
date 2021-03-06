package com.w1nter.TinyLAN_Beacon.DataObjects;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkReport implements Serializable{
	private static final long serialVersionUID = 8131599786114311144L;
	
	private String networkInternetIP;
	private String beaconIP;
	private String beaconName;
	private String beaconCity;
	private String beaconRegion;
	private String beaconCountry;
	
	private long unixTime;	
	
	/**
	 * Creates a new instance of this class.
	 *
	 * @param aBeaconIP
	 * @param aBeaconName
	 * @param aUnixTime
	 */
	public NetworkReport(String aBeaconIP, String aBeaconName, long aUnixTime) {
		super();
		beaconIP = aBeaconIP;
		beaconName = aBeaconName;
		unixTime = aUnixTime;
	}

	private ArrayList<DeviceStatus> deviceList = new ArrayList<DeviceStatus>();

	/**
	 * @return the networkInternetIP
	 */
	public final String getNetworkInternetIP() {
		return networkInternetIP;
	}

	/**
	 * @param aNetworkInternetIP the networkInternetIP to set
	 */
	public final void setNetworkInternetIP(String aNetworkInternetIP) {
		networkInternetIP = aNetworkInternetIP;
	}

	/**
	 * @return the beaconIP
	 */
	public final String getBeaconIP() {
		return beaconIP;
	}

	/**
	 * @return the beaconName
	 */
	public final String getBeaconName() {
		return beaconName;
	}

	/**
	 * @return the beaconCity
	 */
	public final String getBeaconCity() {
		return beaconCity;
	}

	/**
	 * @param aBeaconCity the beaconCity to set
	 */
	public final void setBeaconCity(String aBeaconCity) {
		beaconCity = aBeaconCity;
	}

	/**
	 * @return the beaconRegion
	 */
	public final String getBeaconRegion() {
		return beaconRegion;
	}

	/**
	 * @param aBeaconRegion the beaconRegion to set
	 */
	public final void setBeaconRegion(String aBeaconRegion) {
		beaconRegion = aBeaconRegion;
	}

	/**
	 * @return the beaconCountry
	 */
	public final String getBeaconCountry() {
		return beaconCountry;
	}

	/**
	 * @param aBeaconCountry the beaconCountry to set
	 */
	public final void setBeaconCountry(String aBeaconCountry) {
		beaconCountry = aBeaconCountry;
	}
	
	/**
	 * @param status
	 */
	public final void addDevice(DeviceStatus status){
		deviceList.add(status);
	}
	
	/**
	 * @return deviceList
	 */
	public final ArrayList<DeviceStatus> getDeviceList(){
		return deviceList;
	}

	/**
	 * @return the unixTime
	 */
	public final long getUnixTime() {
		return unixTime;
	}
	
}
