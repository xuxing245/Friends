<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp" %>
<script type="text/javascript" src="/js/jweixin-1.0.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3>活动信息</h3><br>
<a href="/activity/list">列表</a>
<br/>
<br/>
主题:${activity.title } 
时间:${activity.startTime } 
地址:${activity.addressName } 
参与人数:${activity.userNumber==null?0:activity.userNumber } 
<input type="hidden" id="latitude" value="${activity.latitude }"/>
<input type="hidden" id="longitude" value="${activity.longitude }"/>
<br/><br/>
<input type="button" value="查看地图" id="showmap" />
<c:choose>
	<c:when test="${SESSION_USER.id eq activity.creater }">
		<a href="/activity/cancel?id=${activity.id }">取消活动</a>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${joined }">
				<a href="/activity/quit?id=${activity.id }">退出</a>
			</c:when>
			<c:otherwise>
				<a href="/activity/join?id=${activity.id }">参加</a>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

<script type="text/javascript">

wx.config({
    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '${weixin_appid}', // 必填，公众号的唯一标识
    timestamp: ${weixin_timestamp}, // 必填，生成签名的时间戳
    nonceStr: '${weixin_noncestr}', // 必填，生成签名的随机串
    signature: '${weixin_signature}',// 必填，签名，见附录1
    jsApiList: ['checkJsApi', 'openLocation', 'getLocation'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});

wx.ready(function(){

    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	
});

$(function(){
	$('#showmap').click(function(){
		wx.openLocation({
		    latitude: $('#latitude').val(), // 纬度，浮点数，范围为90 ~ -90
		    longitude: $('#longitude').val(), // 经度，浮点数，范围为180 ~ -180。
		    name: '', // 位置名
		    address: '', // 地址详情说明
		    scale: 15, // 地图缩放级别,整形值,范围从1~28。默认为最大
		    infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
		});
	});
});

</script>
</body>
</html>