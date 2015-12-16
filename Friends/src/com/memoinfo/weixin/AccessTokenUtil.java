package com.memoinfo.weixin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.memoinfo.weixin.response.AccessToken;
import com.memoinfo.weixin.response.JSApiTicket;

public class AccessTokenUtil {
	private static final Logger LOG = Logger.getLogger(AccessTokenUtil.class);
	
	private static AccessTokenUtil instance = new AccessTokenUtil();
	
	protected final ScheduledExecutorService executorService;
	
	private WeixinAPI weixinAPI;

	private AccessTokenGetter accessTokenGetter = new AccessTokenGetter();
	
	public void start(){
		//启动定时执行线程池,7000秒刷新一次, Weixin access_token 默认有效期是否7200s
		accessTokenGetter.setWeixinAPI(weixinAPI);
		executorService.scheduleWithFixedDelay(accessTokenGetter, 0, 7000, TimeUnit.SECONDS);
	} 
	
	private AccessTokenUtil(){
		executorService = Executors.newScheduledThreadPool(1);
	}
	
	public static AccessTokenUtil getInstance(){
		return instance;
	}
	
	public String getAccessToken(){
		return accessTokenGetter.getAccessToken();
	}
	
	public String getJSApiTicket() {
		return accessTokenGetter.getJsApiTicket();
	}
	
	public void setWeixinAPI(WeixinAPI weixinAPI) {
		this.weixinAPI = weixinAPI;
		
		this.start();
	}

	private static class AccessTokenGetter implements Runnable{
		private WeixinAPI weixinAPI;
		
		private volatile String accessToken = "";
		
		private volatile String jsApiTicket = "";
		
		public void run() {
			try {
				CloseableHttpClient httpClient = WeixinHttpUtil.getHTTPSClient();
				String accessTokenJSONStr = WeixinHttpUtil.get(httpClient, weixinAPI.getUrlAccessToken());
				AccessToken obj = JSON.parseObject(accessTokenJSONStr, AccessToken.class);
				accessToken = obj.getAccess_token();
				
				httpClient = WeixinHttpUtil.getHTTPSClient();
				String jsTicketJSONStr = WeixinHttpUtil.get(httpClient, weixinAPI.getUrlJSApiTicket(accessToken));
				JSApiTicket ticket = JSON.parseObject(jsTicketJSONStr, JSApiTicket.class);
				jsApiTicket = ticket.getTicket();
			} catch (Exception e) {
				LOG.error("error at get access token", e);
			}
		}
		
		public void setWeixinAPI(WeixinAPI weixinAPI) {
			this.weixinAPI = weixinAPI;
		}

		public String getAccessToken(){
			return accessToken;
		}
		
		public String getJsApiTicket() {
			return jsApiTicket;
		}
	}
}
