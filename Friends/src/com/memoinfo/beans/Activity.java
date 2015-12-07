package com.memoinfo.beans;

import java.sql.Timestamp;

public class Activity extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819500260232943830L;
	
	private String title;
	
	private Timestamp startTime;
	
	private Address address;
	
	private User creater;
	
	private Integer status;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
	
	
}
