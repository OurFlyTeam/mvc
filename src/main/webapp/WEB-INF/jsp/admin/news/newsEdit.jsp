<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/common/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/common/utf8-jsp/ueditor.all.min.js"> </script>
<title>新闻</title>
</head>
<body>
	<jsp:include page="../../../jsp/common/resources.jsp"></jsp:include>
	<form id="newsForm" name="newsForm">
			<table width="100%">
				<colgroup>
					<col width="10%">
					<col width="90%">
				</colgroup>
				<tr>
					<td align="right" style="font-size: 24px;">标题:</td>
					<td>
						<input id="title" class="easyui-textbox" style="width:100%;height:32px"
							   data-options="prompt		: '请输入标题',
							   				 required	: true,
							   				 validType	: 'length[1,30]'
							   				 ">
					</td>
				</tr>
				<tr>
					<td align="right" style="font-size: 24px;">新闻类型:</td>
					<td>
						<input id="type" class="easyui-combobox"
	    						data-options="	valueField		: 'value',
	    										textField		: 'name',
	    										url				: '<%=request.getContextPath()%>/code/getCodeListBySortCode?sortCode=newsType',
	    										required		: true,
	    										panelHeight		: 'auto',
	    										panelMaxHeight	: 150,
	    										editable		: false
	    										"/> 
					</td>
				</tr>
				<tr>
					<td valign="top" align="right" style="font-size: 24px;">正文:</td>
					<td><script id="editor" type="text/plain" style="width:100%;height:300px;"></script></td>
				</tr>
				<tr>
					<td></td>
					<td align="right">
						<a id="saveBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="news.save()">保存</a>
					</td>
				</tr>
			</table>
	</form>
	<a href="#" onclick="a()">ssssssssssssssssss</a>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/news/news.js"></script>
	<script type="text/javascript">
	    //实例化编辑器
	    var ctx = '<%=request.getContextPath()%>';
	    var editor = UE.getEditor('editor');
	    $(function() {
	    	
	    });
	   /*
	    var a = function() {
	    	var buttons = [
	    		{
	    			text	: "保存",
	    			type	: "reload",
	    			handler	: function() {
	    				alert(1);
	    			}
	    		}
	    	];
	    	OFLY.dialog("dialog",ctx+'/newsEdit/init', {}, "title", 1000, 600, buttons);
	    }
	   */
    </script>
</body>
</html>