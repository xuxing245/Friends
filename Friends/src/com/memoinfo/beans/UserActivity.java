package com.memoinfo.beans;

public class UserActivity extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8186840319402770617L;

	private String user;
	
	private String activity;
	
	/**
	 * 0:invalid, 1:valid
	 */
	private int status;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
