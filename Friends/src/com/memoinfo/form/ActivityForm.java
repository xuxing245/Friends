package com.memoinfo.form;

import com.memoinfo.beans.Address;

public class ActivityForm {
	
	private String title;
	
	private String startTime;
	
	private Address address;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
