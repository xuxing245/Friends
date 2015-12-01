package com.memoinfo.beans;

public class Relationship extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1836250634403613666L;
	
	private User owner;
	
	private User friend;
	
	private int status;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
