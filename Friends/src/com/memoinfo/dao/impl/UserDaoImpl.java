package com.memoinfo.dao.impl;

import java.sql.Timestamp;
import java.util.UUID;

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
	
	private static final String SQL_USER_FINDFIRST = "select * from user where name=? and pwd=? and status=?";
	private static final String SQL_USER_ADD = "insert into user(id, name, pwd, status, openId, createDate) values(?,?,?,?,?,?)";
	
	@Override
	public User find(User user) {
		Object[] params = new Object[3];
		params[0] = user.getName();
		params[1] = user.getPwd();
		params[2] = Constants.USER_STATUS_VALID;
		return dbUtilsTemplate.findFirst(User.class, SQL_USER_FINDFIRST, params);
	}
	
	@Override
	public int add(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		Object[] params = new Object[6];
		params[0] = user.getId();
		params[1] = user.getName();
		params[2] = user.getPwd();
		params[3] = Constants.USER_STATUS_VALID;
		params[4] = "";
		params[5] = user.getCreateDate();
		int n = dbUtilsTemplate.update(SQL_USER_ADD, params);
		return n;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DbUtilsTemplate getDbUtilsTemplate() {
		return dbUtilsTemplate;
	}

	public void setDbUtilsTemplate(DbUtilsTemplate dbUtilsTemplate) {
		this.dbUtilsTemplate = dbUtilsTemplate;
	}


}
