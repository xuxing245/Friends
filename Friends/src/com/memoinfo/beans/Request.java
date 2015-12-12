package com.memoinfo.beans;

public class Request extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -605102408411524525L;

	private String sender;
	
	private String receiver;
	
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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
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
