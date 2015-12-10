package com.memoinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.User;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.LoginService;
import com.memoinfo.weixin.WeixinUser;

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

	@Override
	public User register(UserForm userForm) {
		User request = new User();
		request.setName(userForm.getUsername());
		request.setPwd(userForm.getPassword());
		request.setOpenId(userForm.getOpenId());
		int n = userDao.add(request);
		if (n>0) {
			return request;
		} else {
			return null;
		}
	}

	@Override
	public User register(WeixinUser user) {
		User request = new User();
		request.setNickName(user.getNickname());
		request.setOpenId(user.getOpenid());
		int n = userDao.add(request);
		if (n>0) {
			return request;
		} else {
			return null;
		}
	}

}
