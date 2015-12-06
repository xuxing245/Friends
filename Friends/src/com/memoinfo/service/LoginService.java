package com.memoinfo.service;

import com.memoinfo.beans.User;
import com.memoinfo.form.UserForm;

public interface LoginService {
	public User getUserForLogin(UserForm userForm);
	
	public User register(UserForm userForm);
}
