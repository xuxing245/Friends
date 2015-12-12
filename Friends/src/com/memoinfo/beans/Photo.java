package com.memoinfo.beans;

public class Photo extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4244648187889678661L;

	private String owner;
	
	private String path;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
