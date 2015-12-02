package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(HttpServletRequest request) {
		String bind = request.getParameter("bind");
		if (StringUtils.isNotEmpty(bind)) {
			request.setAttribute("bindSuccess", true);
		}
		
		
		return "home";
	}

}