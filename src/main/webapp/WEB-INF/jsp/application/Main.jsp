<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公司</title>
	<meta name="keywords" content="关键字">
	<meta name="description" content="简介">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/allUse/Layout.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/allUse/Head.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/allUse/Foot.css">
</head>

<body>
	<div id="mainPage" class="main">
		<jsp:include   page="/WEB-INF/jsp/allUse/Head.jsp" flush="true"/>  
		<div id="showimg-box">
			<div class="showimg-layout">
				<ul>
					<li class="first"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/1.jpg"></li>
					<li class="center"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/2.jpg"></li>
					<li class="last"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/9.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/3.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/4.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/5.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/6.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/7.jpg"></li>
					<li class="follow"><img alt="美女"
						src="${pageContext.request.contextPath}/public/img/viewpicture/8.jpg"></li>
				</ul>
		
				<div class="tbn">
					<div class="left"><</div>
					<div class="right">></div>
				</div>
			</div>
		</div>
		<div id="content-box">
			<div class="content-layout">
				<div class="main-nav"></div>
				<div class="main-category"></div>
			</div>
		</div>
		<jsp:include   page="/WEB-INF/jsp/allUse/Foot.jsp" flush="true"/>  
	</div>
	<script src="${pageContext.request.contextPath}/public/js/min/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/min/header.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/Main.js"></script>
	
</body>
</html>