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
		
		return "login/login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, UserForm userForm) {
		User user = loginService.register(userForm);
		if (user != null) {
			request.getSession().setAttribute(Constants.SESSION_USER, user);
			return "redirect:/home?register=success";
		} else {
			return "redirect:/login/register/show";
		}
	}
	
	@RequestMapping(value="/register/show")
	public String showRegister() {
		
		return "login/register";
	}

	@RequestMapping(value="/bindUser/show", method=RequestMethod.GET)
	public String showBindUser(HttpServletRequest request){
		
		return "login/bindUser";
	}
	
	@RequestMapping(value="/bindUser/bind")
	public String bindUser(HttpServletRequest request) {
		User user = new User();
		user.setName("Temp");
		request.getSession().setAttribute(Constants.SESSION_USER, user);
		return "redirect:/home?bind=success";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.SESSION_USER);
		request.getSession().invalidate();
		return "redirect:/login/show";
	}
}
