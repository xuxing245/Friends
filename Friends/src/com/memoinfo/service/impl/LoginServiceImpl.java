package com.memoinfo.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
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
		if (StringUtils.isNotEmpty(userForm.getOpenId())) {
			request.setOpenId(userForm.getOpenId());
			return userDao.find(request);
		} else {
			request.setName(userForm.getUsername());
			User user = userDao.find(request);
			String requestPWD = DigestUtils.md5Hex(userForm.getPassword());
			String userPWD = user.getPwd();
			if (requestPWD.equals(userPWD)) {
				return user;
			} else {
				return null;
			}
		}
	}

	@Override
	public User register(UserForm userForm) {
		User request = new User();
		request.setName(userForm.getUsername());
		request.setPwd(DigestUtils.md5Hex(userForm.getPassword()));
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
