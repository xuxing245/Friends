package com.memoinfo.form;

public class ActivityForm {
	
	private String title;
	
	private String description;
	
	/**
	 * format: yyyy-MM-dd HH:mm:ss
	 */
	private String startTime;
	
	private String addressName;
	
	private Double latitude;
	
	private Double longitude;
	
	private Double distance;
	
	private String creater;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longtitude) {
		this.longitude = longtitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

}
