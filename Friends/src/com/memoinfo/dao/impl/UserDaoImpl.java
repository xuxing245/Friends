package com.memoinfo.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.dao.DbUtilsTemplate;

@Service(value="userDao")
public class UserDaoImpl implements CommonDao<User> {

	@Autowired
	private DbUtilsTemplate dbUtilsTemplate;
	
	private static final String SQL_FINDFIRST = "select * from user where name=? and status=?";
	
	private static final String SQL_FINDOPENID = "select * from user where openId=?";
	
	private static final String SQL_FINDBYID = "select * from user where id=?";
	
	private static final String SQL_FINDALL = "select * from user where id<>? and status=?";
	
	private static final String SQL_ADD = "insert into user(id, name, pwd, status, openId, createDate) "
																		+"values(?,?,?,?,?,?)";
	
	private static final String SQL_UPDATE = "update user set nickName=?, age=?, gender=?, phone=?, hobbies=?, description=?, addressName=? where id=?";
	
	@Override
	public User find(User user) {
		if (StringUtils.isNotEmpty(user.getOpenId())) {
			Object[] params = new Object[2];
			params[0] = user.getOpenId();
			params[1] = Constants.STATUS_VALID;
			return dbUtilsTemplate.findFirst(User.class, SQL_FINDOPENID, params);
		} else {
			Object[] params = new Object[2];
			params[0] = user.getName();
			params[1] = Constants.STATUS_VALID;
			return dbUtilsTemplate.findFirst(User.class, SQL_FINDFIRST, params);
		}
		
	}
	
	@Override
	public User find(String id) {
		Object[] p = new Object[1];
		p[0] = id;
		return dbUtilsTemplate.findFirst(User.class, SQL_FINDBYID, p);
	}

	@Override
	public List<User> find(Map<String, String> params) {
		Object[] p = new Object[2];
		p[0] = params.get("userid");
		p[1] = Constants.STATUS_VALID;
		return dbUtilsTemplate.find(User.class, SQL_FINDALL, p);
	}

	@Override
	public int add(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setStatus(Constants.STATUS_VALID);
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		Object[] params = new Object[6];
		params[0] = user.getId();
		params[1] = user.getName();
		params[2] = user.getPwd();
		params[3] = user.getStatus();
		params[4] = user.getOpenId();
		params[5] = user.getCreateDate();
		int n = dbUtilsTemplate.update(SQL_ADD, params);
		return n;
	}

	@Override
	public int update(User user) {
		Object[] params = new Object[8];
		params[0] = user.getNickName();
		params[1] = user.getAge();
		params[2] = user.getGender();
		params[3] = user.getPhone();
		params[4] = user.getHobbies();
		params[5] = user.getDescription();
		params[6] = user.getAddressName();
		params[7] = user.getId();
		
		int n = dbUtilsTemplate.update(SQL_UPDATE, params);
		return n;
	}

	public DbUtilsTemplate getDbUtilsTemplate() {
		return dbUtilsTemplate;
	}

	public void setDbUtilsTemplate(DbUtilsTemplate dbUtilsTemplate) {
		this.dbUtilsTemplate = dbUtilsTemplate;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
