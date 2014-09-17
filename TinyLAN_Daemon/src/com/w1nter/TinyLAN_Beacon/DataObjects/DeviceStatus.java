package com.w1nter.TinyLAN_Beacon.DataObjects;

import java.io.Serializable;

public class DeviceStatus implements Serializable{
	private static final long serialVersionUID = -4986155271071116337L;
	
	private String deviceName;
	private String deviceIP;
	private boolean reachable;
	
	public DeviceStatus(String name, String ip, boolean reachable) {
		this.deviceName = name;
		this.deviceIP = ip;
		this.reachable = reachable;
	}

	/**
	 * @return the deviceName
	 */
	public final String getDeviceName() {
		return deviceName;
	}

	/**
	 * @return the deviceIP
	 */
	public final String getDeviceIP() {
		return deviceIP;
	}

	/**
	 * @return the reachable
	 */
	public final boolean isReachable() {
		return reachable;
	}
	
}
