package com.memoinfo.service;

import java.util.List;
import java.util.Map;

import com.memoinfo.beans.User;
import com.memoinfo.form.UserForm;
import com.memoinfo.weixin.WeixinUser;

public interface UserService {
	public User getUserForLogin(UserForm userForm);
	
	public User register(UserForm userForm);
	
	public User register(WeixinUser user);
	
	public User findById(String id);
	
	public void update(UserForm userForm);
	
	public List<User> findAll(Map params);
}
