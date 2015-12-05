package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request, UserForm userForm){
		User user = loginService.getUserForLogin(userForm);
		if (user != null) {
			request.getSession().setAttribute(Constants.SESSION_USER, user);
			return "redirect:/home?login=success";
		} else {
			return "redirect:/login/show";
		}
	}
	
	@RequestMapping(value="/show")
	public String showLogin(){
		
		return "login";
	}

	@RequestMapping(value="/bindUser/show", method=RequestMethod.GET)
	public String showBindUser(HttpServletRequest request){
		
		return "bindUser";
	}
	
	@RequestMapping(value="/bindUser/bind")
	public String bindUser(HttpServletRequest request) {
		User user = new User();
		user.setName("Temp");
		request.getSession().setAttribute(Constants.SESSION_USER, user);
		return "redirect:/home?bind=success";
	}
}
