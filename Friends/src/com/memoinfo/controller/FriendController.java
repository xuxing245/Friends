package com.memoinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;
import com.memoinfo.service.UserService;

@Controller
@RequestMapping(value="/friend")
public class FriendController {
	public static final Logger LOG = Logger.getLogger(FriendController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", user.getId());
		List<User> friendList = userService.findAll(params);
		
		request.setAttribute("list", friendList);
		return "friendList";
	}
	
	@RequestMapping(value="/detail")
	public String detail(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		User friend = userService.findById(id);
		request.setAttribute("friend", friend);
		return "friend/detail";
	}
}
