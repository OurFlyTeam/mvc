<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="" content="">
<meta>
<title>青岛晟荣环境工程有限公司-新闻</title>
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

<!-- Product -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/newsinfo.css">

</head>

<body>
	<!--头部导航开始-->
	<jsp:include page="../allUse/Head.jsp" flush="true" />
	<!--头部导航结束-->
	<!--图片-->
	<div class="pc">
		<img src="${pageContext.request.contextPath}/img/business.jpg"
			alt="新闻">
	</div>
	<!--图片结束-->
	<!--业务领域tab页面-->
	<div class="newsinfo-tab">
		<ul class="wrap clearfix">
			
		</ul>
	</div>
	
	<!--新闻内容-->
	<div class="newsinfo-item wrap">
		
		
	</div>
	<jsp:include page="../allUse/Foot.jsp" flush="true" />
	<script
		src="${pageContext.request.contextPath}/js/owl.carousel.2.0.0-beta.2.4/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript">
		var id="${id}";
		var ctx = '<%=request.getContextPath()%>';
		var url = ctx + '/newsEdit/queryNewsByBrimaryKey';
		$.ajax({
			method : "POST",
			url : url,
			dataType: "json",
			data : {
				"id" : id
			},
			success : function(data) {
				if(data){
					$(".newsinfo-tab ul").append('<li class="active"><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsMore?type=0">'+data.type+'</a></li>');
					$(".newsinfo-item").append('<h2>'+data.title+'</h2>');
					$(".newsinfo-item").append('<p class="info">'+data.content+'</p>');
				} 
			},
			error : function() {
				
			}
		});
	</script>
</body>
</html>