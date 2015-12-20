package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.UserService;

@Controller
public class HomeController {
	public static final Logger LOG = Logger.getLogger(HomeController.class);
	
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/")
	public String main() {
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/home")
	public String home(HttpServletRequest request) {
		String bind = request.getParameter("bind");
		if (StringUtils.isNotEmpty(bind)) {
			request.setAttribute("bindSuccess", true);
		}
		
		if (StringUtils.isNoneEmpty(request.getParameterValues("login"))) {
			request.setAttribute("loginSuccess", true);
		}
		
		if (StringUtils.isNoneEmpty(request.getParameterValues("register"))) {
			request.setAttribute("registerSuccess", true);
		}
		
		return "home";
	}
	
	@RequestMapping(value="/user/detail")
	public String userDetail(HttpServletRequest request) {
		
		return "user/detail";
	}
	
	@RequestMapping(value="/user/update")
	public String updateMineInfo(HttpServletRequest request) {
		
		return "user/update";
	}
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)
	public String saveMineInfo(HttpServletRequest request, UserForm form) {
		userService.update(form);
		User user = userService.findById(form.getId());
		request.getSession().setAttribute(Constants.SESSION_USER, user);
		return "redirect:/user/detail";
	}

}
