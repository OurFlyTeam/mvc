<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />  
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<!--开发团队:OurFlyTeam@gmail.com-->
<title>青岛晟荣环境工程有限公司欢迎您</title>
<meta name="keywords" content="青岛晟荣环境工程有限公司">
<meta name="description"
	content="青岛晟荣环境工程有限公司位于风光秀丽、气候宜人的滨海度假旅游城市及国际性港口城市、国家历史文化名城——青岛，坐落在即墨华骏物流园西，是集科研、设计、生产制造、营销、安装调试、售后服务为一体的专业环保企业。">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/allUse/favicon.ico"
	type="image/x-icon" />
<link rel="icon"
	href="${pageContext.request.contextPath}/img/allUse/favicon.ico"
	sizes="32x32" />
<link rel="icon"
	href="${pageContext.request.contextPath}/img/allUse/favicon.ico"
	sizes="64x64" />
<link rel="icon"
	href="${pageContext.request.contextPath}/img/allUse/favicon.ico"
	sizes="128x128" />
</head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/allUse/reset.css">
<body>
	<div id="index-main" onmousedown="on_click()">
		<div align="center">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
				codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
				width="1400" height="900">
				<param name="movie"
					value="${pageContext.request.contextPath}/img/flash/index.swf">
				<param name="quality" value="high">
				<PARAM name=bgcolor VALUE=#fff>
				<param name="wmode" value="transparent">
				
				<embed src="${pageContext.request.contextPath}/img/flash/index.swf"
					quality="high" bgcolor=#fff
					pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"
					wmode="transparent" 
					type="application/x-shockwave-flash" width="1400" height="900">
					
			</object>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/min/jquery-1.8.3.js"></script>
<script>
	function on_click() {
		window.location.href = "${pageContext.request.contextPath}/ofly/ep/main/goMain";
	}
</script>

</html>




<!-- 
http://localhost:88/mvc/ofly/test/find/
jsp:    -forward page="/WEB-INF/jsp/application/Main.jsp"
http://localhost:88/mvc
http://localhost:88/mvc/ofly/test/test/
http://localhost:88/mvc/newsEdit/init
 -->