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
	<div class="newsmore-tab">
		<ul class="wrap clearfix">
			<li class="active" title="01">公司新闻</li>
			<li title="02">行业新闻</li>
		</ul>
	</div>
	<!--公司新闻-->
	<div class="news-lists wrap show">
		<!--新闻列表-->
		<div class="news"></div>
		<!-- 分页 -->
		<div class="page">
			<ul class="page-lists">	
				<li><a href="javascript:;" id="page_first">首页</a></li>
				<li><a href="javascript:;" id="page_prev">上一页</a></li>
				<li><a href="javascript:;" id="page_next")>下一页</a></li>
				<li><a href="javascript:;" id="page_last">末页</a></li>
				<li id="pagenum"></li>
				<li id="records"></li>
				<li class="go">转<input id="news_page_go" type="text">页<a href="javascript:;" id="page_go">GO</a></li>
			</ul>
		</div>
	</div>

	<jsp:include page="../allUse/Foot.jsp" flush="true" />
	<script
		src="${pageContext.request.contextPath}/js/owl.carousel.2.0.0-beta.2.4/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		var news_view_rows = 3;
		var page_num;
		var type="${type}";
		var page = "${page}";
		$(function(){
			var news_type;
			
			if(type === "0"){
				news_type = "01";
			}else{
				news_type = "02";
			}
			
			//当前页面是公司新闻或者行业新闻
			if (type == "1" || type == "0") {
				// 实现选中状态
				$(".newsmore-tab li").removeClass("active");
				$(".newsmore-tab li").eq(type).addClass("active");
			}
			
			
			var ctx = '<%=request.getContextPath()%>';
			var url = ctx + '/newsEdit/queryListByType';
			$.ajax({
				method : "POST",
				url : url,
				dataType: "json",
				data : {
					"type" : news_type,
					"rows" : news_view_rows,
					"page" : page
				},
				success : function(data) {
					if(data){
						$("#records").text("共"+data.total+"条"); 
						$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
						page_num = Math.ceil(data.total/news_view_rows);
						if(data.rows){
							data.rows.forEach(function(item){
								$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
									
							});	
						}
					} 
				},
				error : function() {
					
				}
			});
		});
		
		//跳转到公司新闻或者网页新闻
		$(function() {
			$(".newsmore-tab li").click(function() {
				$(".newsmore-tab li").removeClass("active");
				$(this).addClass("active");
				
				if($(this).attr("title") === "01"){
					news_type = "01";
					type = "0";
				}else if($(this).attr("title") === "02"){
					news_type = "02";
					type = "1";
				}
				page = 1;
				//查询
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/newsEdit/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : news_type,
						"rows" : news_view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
							page_num = Math.ceil(data.total/news_view_rows);
							$(".news").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
										
								});	
							}
						} 
					},
					error : function() {
						
					}
				});
			});

		});
		
		//点击查询页
		$(function(){
			//首页
			$("#page_first").click(function() {
				page = 1;
				
				if(type === "0"){
					news_type = "01";
				}else{
					news_type = "02";
				}
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/newsEdit/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : news_type,
						"rows" : news_view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
							$(".news").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
										
								});	
							}
						} 
					},
					error : function() {
						
					}
				});
			});
			
			//上一页
			$("#page_prev").click(function() {
				if(page === "1"){
						page = 1;
					}else{
						page = parseInt(page) - 1;
					}
				
				if(type === "0"){
					news_type = "01";
				}else{
					news_type = "02";
				}
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/newsEdit/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : news_type,
						"rows" : news_view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
							$(".news").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
										
								});	
							}
						} 
					},
					error : function() {
						
					}
				});
			});
			//下一页
			$("#page_next").click(function() {
				if(page === page_num){
						page = page_num;
					}else{
						page = parseInt(page) + 1;
					}
				
				if(type === "0"){
					news_type = "01";
				}else{
					news_type = "02";
				}
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/newsEdit/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : news_type,
						"rows" : news_view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
							$(".news").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
										
								});	
							}
						} 
					},
					error : function() {
						
					}
				});
			});
			//末页
			$("#page_last").click(function() {
				page = page_num;
				
				if(type === "0"){
					news_type = "01";
				}else{
					news_type = "02";
				}
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/newsEdit/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : news_type,
						"rows" : news_view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
							$(".news").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
										
								});	
							}
						} 
					},
					error : function() {
						
					}
				});
			});
			
			
			//go页
			$("#page_go").click(function() {
					page = $("#news_page_go").val();
					
					if(type === "0"){
						news_type = "01";
					}else{
						news_type = "02";
					}
					var ctx = '<%=request.getContextPath()%>';
					var url = ctx + '/newsEdit/queryListByType';
					$.ajax({
						method : "POST",
						url : url,
						dataType: "json",
						data : {
							"type" : news_type,
							"rows" : news_view_rows,
							"page" : page
						},
						success : function(data) {
							if(data){
								$("#records").text("共"+data.total+"条"); 
								$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/news_view_rows)+"页"); 
								$(".news").empty();
								if(data.rows){
									data.rows.forEach(function(item){
										$(".news").append('<dl class="news_dl"><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goNewsInfo?id='+item.id+'&type='+type+'" title="'+item.title +'" class="dt_1">'+item.title +'</a><span class="dt_2">['+ item.creatTime+']</span></dt><dd>'+item.content+ '</dd></dl>');
											
									});	
								}
							} 
						},
						error : function() {
							
						}
					});
				});
			
		});
	</script>
</body>
</html>