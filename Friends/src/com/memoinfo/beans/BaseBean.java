package com.memoinfo.beans;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class BaseBean implements Serializable {

	private String id;
	
	private Timestamp createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	
}
