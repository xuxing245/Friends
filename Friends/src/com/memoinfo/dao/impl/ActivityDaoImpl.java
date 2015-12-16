package com.memoinfo.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.Activity;
import com.memoinfo.common.Constants;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.dao.DbUtilsTemplate;

@Service(value="activityDao")
public class ActivityDaoImpl implements CommonDao<Activity> {

	@Autowired
	private DbUtilsTemplate dbUtilsTemplate;
	
	private static final String SQL_ADD = "insert into activity(id, title, description, startTime, addressName, latitude, longitude, status, createDate, creater) "
															+ " values(?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SQL_FINDBYID = "select * from activity where id=?";
	
	private static final String SQL_FINDALL = "select * from activity where status=1 order by startTime asc";
	
	private static final String SQL_UPDATE_STATUS = "update activity set status=? where id=?";
	
	@Override
	public int add(Activity t) {
		t.setId(UUID.randomUUID().toString());
		t.setStatus(Constants.STATUS_VALID);
		t.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		Object[] p = new Object[10];
		p[0] = t.getId();
		p[1] = t.getTitle();
		p[2] = t.getDescription();
		p[3] = t.getStartTime();
		p[4] = t.getAddressName();
		p[5] = t.getLatitude();
		p[6] = t.getLongitude();
		p[7] = t.getStatus();
		p[8] = t.getCreateDate();
		p[9] = t.getCreater();
		
		return dbUtilsTemplate.update(SQL_ADD, p);
	}

	@Override
	public int update(Activity t) {
		Object[] p;
		if (t.getStatus() != null) {
			p = new Object[2];
			p[0] = t.getStatus();
			p[1] = t.getId();
			return dbUtilsTemplate.update(SQL_UPDATE_STATUS, p);
		}
		return 0;
	}

	@Override
	public Activity find(Activity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity find(String id) {
		Object[] p = new Object[1];
		p[0] = id;
		return dbUtilsTemplate.findFirst(Activity.class, SQL_FINDBYID, p);
	}
	
	@Override
	public List<Activity> find(Map<String, String> params) {
		// TODO Auto-generated method stub
		return dbUtilsTemplate.find(Activity.class, SQL_FINDALL);
	}

	@Override
	public int delete(Activity t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
