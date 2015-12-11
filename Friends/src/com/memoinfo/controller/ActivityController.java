package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/activity")
public class ActivityController {

	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		
		return "activityList";
	}
	
	@RequestMapping(value="/detail")
	public String detail(HttpServletRequest request) {
		
		return "viewActivity";
	}
	
	@RequestMapping(value="/showcreate")
	public String create() {
		
		return "createActivity";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save() {
		
		String id = "";
		return "redirect:/activity/detail?id=" + id;
	}
	
	@RequestMapping(value="/cancel")
	public String cancel(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		return "redirect:/activity/detail?id=" + id;
	}
	
	@RequestMapping(value="/join")
	public String join(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		return "redirect:viewActivity?id=" + id;
	}
	
	@RequestMapping(value="/quit")
	public String quit(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		return "redirect:viewActivity?id=" + id;
	}
	
}
