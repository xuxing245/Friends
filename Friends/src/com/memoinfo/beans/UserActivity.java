package com.memoinfo.beans;

public class UserActivity extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8186840319402770617L;

	private String user;
	
	private String activity;
	
	public UserActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserActivity(String user, String activity) {
		super();
		this.user = user;
		this.activity = activity;
	}

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
	
}
