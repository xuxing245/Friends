package com.memoinfo.interceptor;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.memoinfo.common.Constants;
import com.memoinfo.common.Sha1Util;
import com.memoinfo.weixin.AccessTokenUtil;
import com.memoinfo.weixin.WeixinAPI;

public class BaseInterceptor implements HandlerInterceptor {
	
	private List<String> excludePathList;
	
	@Autowired
	private WeixinAPI wexinAPI;
	
	@Autowired
	private AccessTokenUtil accessTokenUtil;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		String jsticket = accessTokenUtil.getJSApiTicket();
		String noncestr= Sha1Util.getNonceStr();
		String timestamp = Sha1Util.getTimeStamp();
		String url = request.getRequestURL() + "?" + request.getQueryString();
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		signParams.put("jsapi_ticket", jsticket);
		signParams.put("noncestr", noncestr);
		signParams.put("timestamp", timestamp);
		signParams.put("url", url);
		
		String signature = Sha1Util.createSHA1Sign(signParams);
		request.setAttribute("weixin_appid", wexinAPI.getAppid());
		request.setAttribute("weixin_noncestr", noncestr);
		request.setAttribute("weixin_timestamp", timestamp);
		request.setAttribute("weixin_signature", signature);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String path = request.getServletPath();
		if (excludePathList.contains(path)) {
			return true;
		}
		
		if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
			//User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
			
			return true;
		} else {
			//response.sendRedirect(wexinAPI.getUrlAuthorizeAccessCode());
			response.sendRedirect("/login/show");
		}
		return false;
	}

	public List<String> getExcludePathList() {
		return excludePathList;
	}

	public void setExcludePathList(List<String> excludePathList) {
		this.excludePathList = excludePathList;
	}

	public WeixinAPI getWexinAPI() {
		return wexinAPI;
	}

	public void setWexinAPI(WeixinAPI wexinAPI) {
		this.wexinAPI = wexinAPI;
	}

}
