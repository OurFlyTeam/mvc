<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻</title>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/common/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/common/utf8-jsp/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/common/utf8-jsp/lang/zh-cn/zh-cn.js"> </script>
</head>
<body>
	<jsp:include page="../../../jsp/common/resources.jsp"></jsp:include>
	<div id="tabs" class="easyui-tabs" 
		 data-options=" tabPosition	: 'top',pill:true,onAdd:news.onAdd,onSelect:news.onSelect">
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/news/news.js"></script>
	<script type="text/javascript">
		var ctx = '<%=request.getContextPath()%>';
		$(function() {
			news.init();
		});
    </script>
</body>
</html>