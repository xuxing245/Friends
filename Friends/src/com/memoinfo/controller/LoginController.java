package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;

@Controller
@RequestMapping(value="/bindUser")
public class LoginController {

	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String showBindUser(HttpServletRequest request){
		
		return "bindUser";
	}
	
	@RequestMapping(value="/bind")
	public String bindUser(HttpServletRequest request) {
		User user = new User();
		user.setName("Temp");
		request.getSession().setAttribute(Constants.SESSION_USER, user);
		return "redirect:/home?bind=success";
	}
}
