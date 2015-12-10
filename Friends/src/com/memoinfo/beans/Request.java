package com.memoinfo.beans;

public class Request extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -605102408411524525L;

	private User sender;
	
	private User receiver;
	
	/**
	 * 0: request phone
	 * 1: request weixin
	 */
	private int type;
	
	/**
	 * 0: new
	 * 1: accepted
	 * 2: rejected
	 */
	private int status;

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
