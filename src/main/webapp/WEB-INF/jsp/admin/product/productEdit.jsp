<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品中心/title>
</head>
<body>
	<form id="productForm" name="productForm" enctype="multipart/form-data" style="padding: 10px;">
		<input id="id" name="id" type="hidden" value="0">
		<table width="100%">
			<colgroup>
				<col width="15%">
				<col width="85%">
			</colgroup>
			<tr>
				<td align="right" style="font-size: 24px;">业务类型:</td>
				<td><span style="font-size: 18px; color: #00c2ff">${typeName }</span>
					<input type="hidden" id="type" name="type" value="${type}"></td>
			</tr>
			<tr>
				<td align="right" style="font-size: 24px;">标题:</td>
				<td><input id="title" class="easyui-textbox"
					style="width: 100%; height: 32px"
					data-options="prompt		: '请输入标题',
							   				 required	: true,
							   				 validType	: 'length[1,30]'
							   				 ">
				</td>
			</tr>
			<tr>
				<td align="right" style="font-size: 24px;">标题图片:</td>
				<td><a href="javascript:void(0);" onclick="clickOpen()" style="border: 1px solid #e28f8f;text-decoration: none;font-size: 18px;padding: 0px 10px;color: #c5b4b4">选择图片</a>
					<input id="picFile" name="picFile" type="file"
					style="display: none"></td>
			</tr>
			<tr>
				<td align="right" style="font-size: 24px;" ></td>
				<td><img id="previewImg" src="" width="100" height="100" style="display: none;"></td>
			</tr>

			<tr>
				<td valign="top" align="right" style="font-size: 24px;">正文:</td>
				<td><script id="editor" type="text/plain"
						style="width:100%;height:300px;"></script></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/admin/news/news.js"></script>
	<script type="text/javascript">
	    //实例化编辑器
	    var ctx = '<%=request.getContextPath()%>';
		var id = '${id}';
		var editor;
		$(function() {
			editor = UE.getEditor('editor');
			 if(id) {
				var url = ctx + '/businessArea/queryByPrimarkKey';
				var params = {
					id	: id
				}
				$.post(url, params, function(data) {
					editor.ready(function(){//监听编辑器实例化完成的事件
						$('#productForm').find('#title').textbox('setValue', data.title);
						$('#productForm').find('#id').val(id);
						editor.setContent(data.content);
						// 图片显示
						$("#previewImg").show();
						$("#previewImg").attr('src',ctx + '/file/download?id='+data.titlePicId);
					});
				});
			}
			$('#picFile').change(function() {
				var file = this.files[0];
				if(file) {
					var url = getObjectURL(file);
					$('#previewImg').show();
					$('#previewImg').attr('src', url);
				}
			});
		});
		function clickOpen() {
			$('#picFile').click();
		}
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) { // basic
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) { // mozilla(firefox)
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) { // webkit or chrome
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>
</body>
</html>