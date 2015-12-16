package com.memoinfo.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoinfo.beans.Activity;
import com.memoinfo.beans.UserActivity;
import com.memoinfo.common.Constants;
import com.memoinfo.dao.CommonDao;
import com.memoinfo.form.ActivityForm;
import com.memoinfo.service.ActivityService;

@Service(value="activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private CommonDao<Activity> activityDao;
	
	@Autowired
	private CommonDao<UserActivity> userActivityDao;
	
	@Override
	public List<Activity> findActivities(Map<String, String> params) {
		return activityDao.find(params);
	}

	@Override
	public Activity findById(String id) {
		return activityDao.find(id);
	}

	@Override
	public Activity create(ActivityForm form) {
		Activity request = new Activity();
		request.setTitle(form.getTitle());
		request.setDescription(form.getDescription());
		request.setStartTime(Timestamp.valueOf(form.getStartTime()));
		request.setAddressName(form.getAddressName());
		request.setLatitude(form.getLatitude());
		request.setLongitude(form.getLongitude());
		request.setCreater(form.getCreater());
		
		int n = activityDao.add(request);
		if (n > 0) {
			return request;
		} else {
			return null;
		}
	}

	@Override
	public void cancel(String id) {
		Activity request = new Activity();
		request.setId(id);
		request.setStatus(Constants.STATUS_INVALID);
		activityDao.update(request);
	}

	@Override
	public Boolean isJoined(UserActivity ua) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("user", ua.getUser());
		params.put("activity", ua.getActivity());
		List<UserActivity> list = userActivityDao.find(params);
		return (list==null || list.isEmpty()) ? false : true;
	}

	@Override
	public void join(UserActivity ua) {
		userActivityDao.add(ua);
	}

	@Override
	public void quit(UserActivity ua) {
		userActivityDao.delete(ua);
	}

}
