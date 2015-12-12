package com.memoinfo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;
import com.memoinfo.common.WeixinAPI;
import com.memoinfo.form.UserForm;
import com.memoinfo.service.UserService;
import com.memoinfo.weixin.AccessToken;
import com.memoinfo.weixin.WeixinHttpUtil;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	public static final Logger LOG = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WeixinAPI weixinAPI;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request, UserForm userForm){
		User user = userService.getUserForLogin(userForm);
		if (user != null) {
			request.getSession().setAttribute(Constants.SESSION_USER, user);
			return "redirect:/home?login=success";
		}
		return "redirect:/login/show";
	}
	
	@RequestMapping(value="/show")
	public String showLogin(){
		
		return "login/login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, UserForm userForm) {
		User user = userService.register(userForm);
		if (user != null) {
			request.getSession().setAttribute(Constants.SESSION_USER, user);
			return "redirect:/home?register=success";
		}
		return "redirect:/login/register/show";
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
		String code = request.getParameter("code");
		if (StringUtils.isNotEmpty(code)) {
			try {
				String accessTokenJson = WeixinHttpUtil.get(WeixinHttpUtil.getHTTPSClient(), weixinAPI.getUrlAccessToken(code));
				AccessToken accessToken = mapper.readValue(accessTokenJson, AccessToken.class);
				if (StringUtils.isNotEmpty(accessToken.getOpenid())) {
					UserForm userForm = new UserForm();
					userForm.setOpenId(accessToken.getOpenid());
					// get user by openid
					User user = userService.getUserForLogin(userForm);
					if (user == null) {
						//String userInfoJson = WeixinHttpUtil.get(WeixinHttpUtil.getHTTPSClient(), weixinAPI.getUrlUserInfo(accessToken.getAccess_token(), accessToken.getOpenid()));
						//WeixinUser weixinUser = mapper.readValue(userInfoJson, WeixinUser.class);
						// create user by openid
						user = userService.register(userForm);
					}
					request.getSession().setAttribute(Constants.SESSION_USER, user);
					return "redirect:/home?bind=success";
				}
			} catch (Exception e) {
				LOG.error(e.getMessage());
			} 
			
		}
		return "redirect:/login/show";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constants.SESSION_USER);
		request.getSession().invalidate();
		return "redirect:/login/show";
	}
	
}
