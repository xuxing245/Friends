package com.memoinfo.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.UserActivity;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.dao.DbUtilsTemplate;

@Service(value="userActivityDao")
public class UserActivityDaoImpl implements CommonDao<UserActivity> {

	@Autowired
	private DbUtilsTemplate dbUtilsTemplate;
	
	private static final String SQL_ADD = "insert into useractivity(id, user, activity, createDate) values(?,?,?,?)";
	
	private static final String SQL_DELETE = "delete from useractivity where user=? and activity=?";
	
	private static final String SQL_FINDJOINED = "select * from useractivity where user=? and activity=?";
	
	@Override
	public int add(UserActivity t) {
		t.setId(UUID.randomUUID().toString());
		t.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		Object[] p = new Object[4];
		p[0] = t.getId();
		p[1] = t.getUser();
		p[2] = t.getActivity();
		p[3] = t.getCreateDate();
		return dbUtilsTemplate.update(SQL_ADD, p);
	}

	@Override
	public int update(UserActivity t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserActivity find(UserActivity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserActivity find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserActivity> find(Map<String, String> params) {
		Object[] p = new Object[2];
		p[0] = params.get("user");
		p[1] = params.get("activity");
 		return dbUtilsTemplate.find(UserActivity.class, SQL_FINDJOINED, p);
	}

	@Override
	public int delete(UserActivity t) {
		Object[] p = new Object[2];
		p[0] = t.getUser();
		p[1] = t.getActivity();
		return dbUtilsTemplate.update(SQL_DELETE, p);
	}

}
