package com.memoinfo.common;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;

public class WeixinAPI {
	@Value("${weixin.appid}")
	private String appid;
	
	@Value("${weixin.appsecret}")
	private String appsecret;
	
	@Value("${weixin.authorize.redirect}")
	private String authorizeRedirectUrl;
	
	@Value("${weixin.token}")
	private String token;
	
	private String urlAccessCode;
	
	private String urlAccessToken;
	
	private String urlUserInfo;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getAuthorizeRedirectUrl() {
		return authorizeRedirectUrl;
	}

	public void setAuthorizeRedirectUrl(String authorizeRedirectUrl) {
		this.authorizeRedirectUrl = authorizeRedirectUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@SuppressWarnings("deprecation")
	public String getUrlAccessCode() {
		urlAccessCode = "https://open.weixin.qq.com/connect/oauth2/authorize"
				+ "?appid=" + appid
				+ "&redirect_uri=" + URLEncoder.encode(authorizeRedirectUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		return urlAccessCode;
	}

	public void setUrlAccessCode(String urlAccessCode) {
		this.urlAccessCode = urlAccessCode;
	}

	public String getUrlAccessToken() {
		return urlAccessToken;
	}
	
	public String getUrlAccessToken(String code) {
		urlAccessToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid 
							+ "&secret=" + appsecret 
							+ "&code=" + code 
							+ "&grant_type=authorization_code";
		return urlAccessToken;
	}

	public void setUrlAccessToken(String urlAccessToken) {
		this.urlAccessToken = urlAccessToken;
	}
	
	public String getUrlUserInfo() {
		urlUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		return urlUserInfo;
	}

	public String getUrlUserInfo(String accessToken, String openid) {
		urlUserInfo = "https://api.weixin.qq.com/sns/userinfo?"
				+ "access_token=" + accessToken
				+ "&openid=" + openid
				+ "&lang=zh_CN";
		return urlUserInfo;
	}

	public void setUrlUserInfo(String urlUserInfo) {
		this.urlUserInfo = urlUserInfo;
	}
	
}
