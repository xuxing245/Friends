package com.memoinfo.beans;

public class UserInfo extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8650589125733623368L;
	
	private User owner;

	private String nickName;
	
	private int age;
	
	/**
	 * 0: 女， 1:男
	 */
	private int gender;
	
	private Address address;
	
	private String phone;
	
	private String hobbies;
	
	private String description;
	
	/*
	 * 信誉分
	 */
	private int score;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
