package com.memoinfo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.memoinfo.beans.User;
import com.memoinfo.common.Constants;

public class LoginInterceptor implements HandlerInterceptor {
	
	private List<String> excludePathList;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String path = request.getServletPath();
		if (excludePathList.contains(path)) {
			return true;
		}
		
		if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
			User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
			
			return true;
		} else {
			response.sendRedirect("/bindUser/show");
		}
		return false;
	}

	public List<String> getExcludePathList() {
		return excludePathList;
	}

	public void setExcludePathList(List<String> excludePathList) {
		this.excludePathList = excludePathList;
	}

	

}
