package com.memoinfo.beans;

public class UserActivity extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8186840319402770617L;

	private User user;
	
	private Activity activity;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}
