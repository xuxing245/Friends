package com.memoinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoinfo.beans.User;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.LoginService;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CommonDao<User> userDao;
	
	@Override
	public User getUserForLogin(UserForm userForm) {
		User request = new User();
		request.setName(userForm.getUsername());
		request.setPwd(userForm.getPassword());
		return userDao.find(request);
	}

}
