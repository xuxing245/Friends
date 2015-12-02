package com.memoinfo.beans;

public class Address extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3148962582169807290L;

	private String name;
	
	private String description;
	
	private Double latitude;
	
	private Double longtitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}
