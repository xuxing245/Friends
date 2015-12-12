package com.memoinfo.beans;

public class Message extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2702880699376762565L;

	private String sender;
	
	private String receiver;
	
	/**
	 * 0: user message
	 * 1: system message
	 */
	private Integer type;
	
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
