<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<meta charset="UTF-8">
<meta http-equiv="" content="">
<meta>
<title>青岛晟荣环境工程有限公司-产品中心</title>
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
	href="${pageContext.request.contextPath}/css/ProductMore.css">
</head>

<body>
	<!--头部导航开始-->
	<jsp:include page="../allUse/Head.jsp" flush="true" />
	<!--头部导航结束-->
	<!--图片
	<div class="pc">
		<img src="${pageContext.request.contextPath}/img/business.jpg"
			alt="业务领域">
	</div>-->
	<!--图片结束-->

	<div id="tpl_c">
		<div id="tpl_l">
			<div class="hbsb">
				<img src="${pageContext.request.contextPath}/img/product/hbsb.jpg">
				<p>${type_name}</p>
			</div>
			<ul>
				
			</ul>
			<div><img src="${pageContext.request.contextPath}/img/product/tpl_l_f.gif"></div>
		</div>
		<div id="tpl_r">
			<div id="tpl_r_t">
				<!--  <strong>${type_name}</strong>-->
				<span>您当前所在的位置： <a href="${pageContext.request.contextPath}/ofly/ep/main/goMain"
					title="首页">首页</a> &gt; <a href="${pageContext.request.contextPath}/ofly/ep/main/goMain?source=product">产品中心</a>
					&gt; <a href="${pageContext.request.contextPath}/ofly/ep/main/goProductMore?type=${type}">${type_name}</a>
				</span>
			</div>
			<div id="tpl_r_c">
				<div class="mg_gcal">
					
				</div>
				<div class="clear"></div>
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
		</div>
	</div>

	<jsp:include page="../allUse/Foot.jsp" flush="true" />
	<script
		src="${pageContext.request.contextPath}/js/owl.carousel.2.0.0-beta.2.4/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		var view_rows = 12;
		var page_num;//总页数
		var type="${type}";
		var page = "${page}";
		//查询内容
		$(function(){
			var business_type;
			business_type = get_business_type(type);
			
			var ctx = '<%=request.getContextPath()%>';
			var url = ctx + '/productCenter/queryListByType';
			$.ajax({
				method : "POST",
				url : url,
				dataType: "json",
				data : {
					"type" : business_type,
					"rows" : view_rows,
					"page" : page
				},
				success : function(data) {
					if(data){
						$("#records").text("共"+data.total+"条"); 
						$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
						page_num = Math.ceil(data.total/view_rows);
						if(data.rows){
							data.rows.forEach(function(item){
								$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
										+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
								$("#previewImg"+item.id).show();
								$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
							});	
						}
					} 
				},
				error : function() {
					
				}
			});
		});
		//查询标题说明信息
		$(function(){
			var business_type;
			business_type = get_business_type(type);
			
			var ctx = '<%=request.getContextPath()%>';
			var url = ctx + '/ofly/ep/main/queryListByType';
			$.ajax({
				method : "POST",
				url : url,
				dataType: "json",
				data : {
					"type" : business_type,
					"sort_code_id" : 3,
				},
				success : function(data) {
					if(data){
						if(data.rows){
							data.rows.forEach(function(item){
								$("#tpl_l ul").append('<li><p>'+item.des+'</p></li>');
							});	
						}
					} 
				},
				error : function() {
				}
			});
		});
		
		
		//点击查询页
		$(function(){
			//首页
			$("#page_first").click(function() {
				page = 1;
				business_type = get_business_type(type);
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/productCenter/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : business_type,
						"rows" : view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
							$(".mg_gcal").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
											+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
									$("#previewImg"+item.id).show();
									$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
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
				if(page == "1"){
					page = 1;
				}else{
					page = parseInt(page) - 1;
				}
				
				business_type = get_business_type(type);
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/productCenter/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : business_type,
						"rows" : view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
							$(".mg_gcal").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
											+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
									$("#previewImg"+item.id).show();
									$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
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
			   if(page == page_num){
					page = page_num;
				}else{
					page = parseInt(page) + 1;
				}
				business_type = get_business_type(type);
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/productCenter/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : business_type,
						"rows" : view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
							$(".mg_gcal").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
											+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
									$("#previewImg"+item.id).show();
									$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
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
				

				business_type = get_business_type(type);
				var ctx = '<%=request.getContextPath()%>';
				var url = ctx + '/productCenter/queryListByType';
				$.ajax({
					method : "POST",
					url : url,
					dataType: "json",
					data : {
						"type" : business_type,
						"rows" : view_rows,
						"page" : page
					},
					success : function(data) {
						if(data){
							$("#records").text("共"+data.total+"条"); 
							$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
							$(".mg_gcal").empty();
							if(data.rows){
								data.rows.forEach(function(item){
									$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
											+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
									$("#previewImg"+item.id).show();
									$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
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
					
					business_type = get_business_type(type);
					var ctx = '<%=request.getContextPath()%>';
					var url = ctx + '/productCenter/queryListByType';
					$.ajax({
						method : "POST",
						url : url,
						dataType: "json",
						data : {
							"type" : business_type,
							"rows" : view_rows,
							"page" : page
						},
						success : function(data) {
							if(data){
								$("#records").text("共"+data.total+"条"); 
								$("#pagenum").text("当前页："+ page+"/"+Math.ceil(data.total/view_rows)+"页"); 
								$(".mg_gcal").empty();
								if(data.rows){
									data.rows.forEach(function(item){
										$(".mg_gcal").append('<dl><dt><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'"><img id="previewImg'+item.id+'" width="205" height="125"></a>'
												+ '</dt><dd><a href="${pageContext.request.contextPath}/ofly/ep/main/goProductInfo?id='+item.id+'&type='+type+'">'+item.title+'</a></dd></dl>');
										$("#previewImg"+item.id).show();
										$("#previewImg"+item.id).attr('src',ctx + '/file/download?id='+item.titlePicId);
									});	
								}
							} 
						},
						error : function() {
							
						}
					});
				});
		});
		function get_business_type(type){
			var business_type;
			switch(type){
				case "0":
					business_type = "01";
				    break;
				case "1":
					business_type = "02";
				    break;
				case "2":
					business_type = "03";
				    break;
				case "3":
					business_type = "04";
				    break;
				case "4":
					business_type = "05";
				    break;
				case "5":
					business_type = "06";
				    break;
			}
			return business_type;
		}
		
	</script>
</body>
</html>