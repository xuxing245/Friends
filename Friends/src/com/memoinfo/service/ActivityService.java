package com.memoinfo.service;

import java.util.List;
import java.util.Map;

import com.memoinfo.beans.Activity;
import com.memoinfo.beans.UserActivity;
import com.memoinfo.form.ActivityForm;

public interface ActivityService {
	
	public List<Activity> findActivities(Map<String, String> params);
	
	public Activity findById(String id);
	
	public Activity create(ActivityForm activity);
	
	public void cancel(String id);
	
	public Boolean isJoined(UserActivity ua);
	
	public void join(UserActivity ua);
	
	public void quit(UserActivity ua);
}
