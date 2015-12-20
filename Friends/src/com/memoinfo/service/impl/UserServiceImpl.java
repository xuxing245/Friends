package com.memoinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.User;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.UserService;
import com.memoinfo.weixin.WeixinUser;

@Service(value="userService")
public class UserServiceImpl implements UserService {

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
			if (user == null) {
				return null;
			}
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

	@Override
	public User findById(String id) {
		return userDao.find(id);
	}

	@Override
	public void update(UserForm userForm) {
		
		User user = new User();
		user.setId(userForm.getId());
		user.setNickName(userForm.getNickName());
		user.setAge(userForm.getAge());
		user.setGender(userForm.getGender());
		user.setPhone(userForm.getPhone());
		user.setHobbies(userForm.getHobbies());
		user.setDescription(userForm.getDescription());
		user.setAddressName(userForm.getAddressName());
		
		userDao.update(user);
	}

	@Override
	public List<User> findAll(Map params) {
		// TODO Auto-generated method stub
		return userDao.find(params);
	}
	
	

}
