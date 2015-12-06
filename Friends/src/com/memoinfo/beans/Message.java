package com.memoinfo.beans;

public class Message extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2702880699376762565L;

	private User sender;
	
	private User receiver;
	
	private Integer type;
	
	private String content;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
