package com.memoinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memoinfo.beans.Activity;
import com.memoinfo.beans.User;
import com.memoinfo.beans.UserActivity;
import com.memoinfo.common.Constants;
import com.memoinfo.form.ActivityForm;
import com.memoinfo.service.ActivityService;

@Controller
@RequestMapping(value="/activity")
public class ActivityController {
	
	public static final Logger LOG = Logger.getLogger(ActivityController.class);
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		List<Activity> activityList = activityService.findActivities(params);
		request.setAttribute("activityList", activityList);
		return "activityList";
	}
	
	@RequestMapping(value="/detail")
	public String detail(HttpServletRequest request) {
		String activityId = request.getParameter("id");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		if (StringUtils.isNotEmpty(activityId)) {
			Activity act = activityService.findById(activityId);
			boolean joined = activityService.isJoined(new UserActivity(user.getId(), activityId));
			request.setAttribute("activity", act);
			request.setAttribute("joined", joined);
		}
		return "activity/viewActivity";
	}
	
	@RequestMapping(value="/create")
	public String create() {
		
		return "activity/createActivity";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(HttpServletRequest request, ActivityForm activityForm) {
		LOG.info("title: " + activityForm.getTitle());
		Activity act = activityService.create(activityForm);
		if (act != null) {
			return "redirect:/activity/detail?id=" + act.getId();
		} 
		return "redirect:/activity/create";
	}
	
	@RequestMapping(value="/cancel")
	public String cancel(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (StringUtils.isNotEmpty(id)) {
			Activity activity = activityService.findById(id);
			User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
			if (activity.getCreater().equals(user.getId())) {
				activityService.cancel(id);
			}
		}
		return "redirect:/activity/list";
	}
	
	@RequestMapping(value="/join")
	public String join(HttpServletRequest request) {
		String activityId = request.getParameter("id");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		if (StringUtils.isNotEmpty(activityId)) {
			activityService.join(new UserActivity(user.getId(), activityId));
		}
		return "redirect:/activity/detail?id=" + activityId;
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request) {
		String activityId = request.getParameter("id");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		if (StringUtils.isNotEmpty(activityId)) {
			activityService.quit(new UserActivity(user.getId(), activityId));
		}
		return "redirect:/activity/detail?id=" + activityId;
	}
	
}
