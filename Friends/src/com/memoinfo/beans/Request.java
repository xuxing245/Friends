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
	private Integer type;
	
	/**
	 * 0: new
	 * 1: accepted
	 * 2: rejected
	 */
	private Integer status;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
