package com.memoinfo.weixin.response;

public class JSApiTicket extends WeixinResponse{
	private String ticket;
	
	private Integer expire_in;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpire_in() {
		return expire_in;
	}

	public void setExpire_in(Integer expire_in) {
		this.expire_in = expire_in;
	}
	
	
}
