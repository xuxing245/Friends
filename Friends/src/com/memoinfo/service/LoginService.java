package com.memoinfo.service;

import com.memoinfo.beans.User;
import com.memoinfo.form.UserForm;
import com.memoinfo.weixin.WeixinUser;

public interface LoginService {
	public User getUserForLogin(UserForm userForm);
	
	public User register(UserForm userForm);
	
	public User register(WeixinUser user);
}
