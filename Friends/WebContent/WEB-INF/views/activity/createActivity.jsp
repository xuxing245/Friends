<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/head.jsp" %>
<script type="text/javascript" src="/js/jweixin-1.0.0.js"></script>
<title>Insert title here</title>
</head>
<body>
创建活动
<form action="/activity/save" method="post">
	主题:<input type="text" name="title"/><br/>
	时间:<input type="text" name="startTime"/><br/>
	地址:<input type="text" name="addressName"><br>
	经度:<input type="text" name="latitude" id="latitude"><br>
	纬度:<input type="text" name="longitude" id="longitude"><br>
	<input type="hidden" name="creater" value="${SESSION_USER.id }" />
	<input type="submit" value="保存">
</form>

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
	wx.getLocation({
	    type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
	    success: function (res) {
	        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
	        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
	        var speed = res.speed; // 速度，以米/每秒计
	        var accuracy = res.accuracy; // 位置精度
	        $('#latitude').val(latitude);
	        $('#longitude').val(longitude);
	    }
	});

});

</script>

</body>
</html>