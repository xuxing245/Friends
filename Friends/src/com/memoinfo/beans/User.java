package com.memoinfo.beans;

public class User extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5692445387926186332L;

	private String name;
	
	private String pwd;
	
	private UserInfo detail;
	
	private int status;
	
	private String openId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserInfo getDetail() {
		return detail;
	}

	public void setDetail(UserInfo detail) {
		this.detail = detail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
