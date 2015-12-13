package com.memoinfo.controller;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;

import com.memoinfo.weixin.WeixinAPI;

@Controller
@RequestMapping(value="/weixin")
public class WeixinController {
	
	@Autowired
	private WeixinAPI weixinAPI;
	
	/**
	 * 微信验证
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/valid")
	public String wexinValid(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			String echostr = request.getParameter("echostr");
			StringBuilder weixinContent = new StringBuilder();
			if (checkSignature(request)) {
				weixinContent.append(echostr);
			} else {
				weixinContent.append("Invalid request");
			}
			response.getWriter().print(weixinContent.toString());
		} else {
			ServletInputStream in = request.getInputStream();
			acceptXML(in, response);
		}
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	private void acceptXML(InputStream in, HttpServletResponse response) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);
			String msgType = doc.getElementsByTagName("MsgType").item(0).getFirstChild().getNodeValue();
			if("text".equals(msgType)){
				String content = doc.getElementsByTagName("Content").item(0).getFirstChild().getNodeValue();
				
				if(content != null && content.length() > 0){
			             // 接收到微信服务器POST过来的文本信息		
				     // Do something
					
				}
			}else if("event".equals(msgType)){
				String event = doc.getElementsByTagName("Event").item(0).getFirstChild().getNodeValue();
				if("CLICK".equals(event)){
					
					// 接收到微信服务器POST过来的点击菜单信息
					// Do something
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkSignature(HttpServletRequest request) {
		boolean valid = false;
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature == null || timestamp == null || nonce == null) {
			return false;
		}

		List<String> array = new ArrayList<String>();
		array.add(weixinAPI.getToken());
		array.add(timestamp);
		array.add(nonce);
		Collections.sort(array);
		String tempString = array.get(0) + array.get(1) + array.get(2);

		MessageDigest sha1;
		try {
			sha1 = MessageDigest.getInstance("SHA1");
			sha1.update(tempString.getBytes());
			byte[] bytes = sha1.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				String shaHex = Integer.toHexString(bytes[i] & 0xFF);
				if (shaHex.length() < 2) {
					sb.append(0);
				}
				sb.append(shaHex);
			}
			String encodedToken = sb.toString();
			if (encodedToken.equals(signature)) {
				valid = true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return valid;
	}
}
