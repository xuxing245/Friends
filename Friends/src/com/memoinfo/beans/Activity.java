package com.memoinfo.beans;

import java.sql.Timestamp;

public class Activity extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819500260232943830L;
	
	private String title;
	
	private String description;
	
	private Timestamp startTime;
	
	private User creater;
	
	/**
	 * 1: valid
	 * 0: invaid
	 */
	private Integer status;
	
	private String addressName;
	
	private Double latitude;
	
	private Double longtitude;
	
	private Double distance;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
