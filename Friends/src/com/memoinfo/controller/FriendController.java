package com.memoinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memoinfo.beans.User;

@Controller
@RequestMapping(value="/friend")
public class FriendController {

	@RequestMapping(value="/list")
	public String list(HttpServletRequest request) {
		
		User test1 = new User();
		test1.setId("e3r4t5");
		test1.setName("name123");
		
		User test2 = new User();
		test2.setId("q1w2e3");
		test2.setName("name456");
		
		List<User> friendList = new ArrayList<User>();
		friendList.add(test1);
		friendList.add(test2);
		
		request.setAttribute("list", friendList);
		return "friendList";
	}
	
	@RequestMapping(value="/detail")
	public String detail(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		User friend = new User();
		friend.setId(id);
		friend.setName("name" + id);
		request.setAttribute("friend", friend);
		return "user/viewUserInfo";
	}
}
