package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
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

}
