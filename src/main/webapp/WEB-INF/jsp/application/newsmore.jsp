<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="" content="">
<meta>
<title>青岛晟荣环境工程有限公司-业务领域</title>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/allUse/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/allUse/Head.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/allUse/Foot.css">
<!-- business -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/newsmore.css">
</head>

<body>
	<!--头部导航开始-->
	<jsp:include page="../allUse/Head.jsp" flush="true" />
	<!--头部导航结束-->
	<!--图片-->
	<div class="pc">
		<img src="${pageContext.request.contextPath}/img/business.jpg"
			alt="业务领域">
	</div>
	<!--图片结束-->
	<!--业务领域tab页面-->
	<div class="business-tab">
		<ul class="wrap clearfix">
			<li class="active">公司新闻</li>
			<li>行业新闻</li>
		</ul>
	</div>
	<!--公司新闻-->
	<div class="news-lists wrap show">
		<!--新闻列表-->
		<div class="news"></div>
		<!-- 分页 -->
		<div class="page">
			<ul class="page-lists">
				<li><a href="#">首页</a></li>
				<li><a href="#">上一页</a></li>
				<li><a href="#">下一页</a></li>
				<li><a href="#">末页</a></li>
				<li>页次: 1/51页</li>
				<li>共602条记录</li>
				<li class="go">转<input type="text">页<a href="#">GO</a></li>
			</ul>
		</div>
	</div>
	<!--行业新闻-->
	<div class="business-item wrap"></div>

	<jsp:include page="../allUse/Foot.jsp" flush="true" />
	<script
		src="${pageContext.request.contextPath}/js/owl.carousel.2.0.0-beta.2.4/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		var type = "${type}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/Business.js"></script>
	<script type="text/javascript">
		var ctx = '<%=request.getContextPath()%>';
		var url = ctx + '/newsEdit/queryListByType';
		$.ajax({
			method : "POST",
			url : url,
			dataType: "json",
			data : {
				"type" : "01",
				"rows" : 10,
				"page" : 1
			},
			success : function(data) {
				if(data){
					if(data.rows){
						data.rows.forEach(function(item){
							$(".news").append('<dl class="news_dl"><dt><a href="" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');

						});	
					}
				} 
			},
			error : function() {
				
			}
		});
	</script>
</body>
</html>