/**
 * 业务领域模块
 */
var product = (function(){
	var _this= {};
	var currentTabIndex;
	var init = function() {
		var url = ctx + '/code/getCodeListBySortCode';
		var params = {
			sortCode	: 'productCenterType'	
		};
		$.get(url, params, function(data) {
			
			if(data!=null) {
				$.each(data, function(index, item) {
					$('#tabsProduct').tabs("add",{
						title	: item.name,
						selected: index==0?true:false ,
						value	: item.value
					});
				});
			} 
		});
	}
	
	var onAdd = function(title, index) {
		var tab = $(this).tabs("getTab", index);
		var value = tab.panel("options").value;
		var datagrid = $('<table id="datagrid_product_'+value+'"></table>');
		tab.html(datagrid);
		datagrid.datagrid({
			url			: ctx + '/productCenter/queryListByType?type='+value,
			singleSelect: true,
			rownumbers	: true,
			loadMsg		: '查询中',
			pagination	: true,
			striped		: true,
			width		: '100%',
			columns		: [[
				      	   {field:"title",		title:"标题", 		align:'center', width:"50%"},
				      	   {field:"creatTime", 	title:"创建时间", 	align:'center', width:"50%"}
					      ]],
			toolbar 	: [
			        	   	{text:'新增',iconCls:'icon-add',handler: _add},'-',
			        	   	{text:'修改',iconCls:'icon-edit',handler: _edit},'-',
			        	   	{text:'删除',iconCls:'icon-remove',handler: _del}
			        	   ]
		});
	}
	
	function _add(event) {
		var type = $('#tabsProduct').tabs("getSelected").panel("options").value;
		var url = ctx + '/productCenter/add';
		var params = {
				type	: type
		};
		var buttons = [{
			text	: '保存',
			iconCls	: 'icon-save',
			plain	: true,
			handler	: _save
		}];
		var options = {
			title	: "新增",
			width	: 1000,
			height	: 610,
			href	: url+ "?"+$.param(params),
			closed	: false,
	        cache	: false,
	        modal	: true,
			buttons	: buttons,
			onClose	: function() {
	        	editor.destroy();
	        }
		}
		var div = '<div id="addDialog"></div>';
		$(document.body).append(div); 
		$("#addDialog").dialog(options);
		
	}
	
	var _edit = function (event) {
		var type = $('#tabsProduct').tabs("getSelected").panel("options").value;
		var row = $('#datagrid_product_'+type).datagrid("getSelected");
		if(!row) {
			OFLY.message("请先选择一条数据");
			return;
		}
		var url = ctx + '/productCenter/edit';
		var params = {
			id	: row.id,
			type: type
		}
		var buttons = [{
			text	: '保存',
			iconCls : 'icon-save',
			plain	: true,
			handler	: _save
		}];
		var options = {
			title	: "修改",
			width	: 1000,
			height	: 610,
			href	: url+ "?"+$.param(params),
			closed	: false,
	        cache	: false,
	        modal	: true,
			buttons	: buttons,
			onClose	: function() {
	        	editor.destroy();
	        },
		}
		var div = '<div id="addDialog"></div>';
		$(document.body).append(div); 
		$("#addDialog").dialog(options);
	}
	var _del = function (event) {
		var type = $('#tabsProduct').tabs("getSelected").panel("options").value;
		var row = $('#datagrid_product_'+type).datagrid("getSelected");
		if(!row) {
			OFLY.message("请先选择一条数据");
			return;
		}
		var url = ctx + '/productCenter/delete';
		var params = {
			id	: row.id
		}
		OFLY.confirm("确认删除该数据?", function(){
			$.post(url, params, function(data) {
				OFLY.message(data.msg, function() {
					if(data.code){
						var type = $('#tabsProduct').tabs("getSelected").panel("options").value;
						$('#datagrid_product_'+type).datagrid("reload");
					}
				});
			});
		});
	}
	
	var _save = function () {
		var _this = this;
		if(!_saveValid()) {
			return;
		}
		var url = ctx +'/productCenter/save';
		var formData = new FormData($('#productForm')[0]);
		formData.append("content",editor.getContent());
		formData.append("title",$('#productForm').find("#title").textbox("getValue"));
		OFLY.confirm("确认保存?", function() {
			$(_this).linkbutton("disable");
			$.ajax({
			    url			: url,
			    type		: 'POST',
			    cache		: false,
			    processData	: false,
			    contentType	: false,
			    data		: formData
			}).done(function(res) {
				OFLY.message(res.msg,function() {
					if(res.code) {
						var type = $('#tabsProduct').tabs("getSelected").panel("options").value;
						$("#datagrid_product_"+type).datagrid("reload");
						OFLY.dialog.close("addDialog");
					}
				});
			}).fail(function(res) {
				$(_this).linkbutton("enable");
				OFLY.message(res);
			});
		});
	}
	
	var _saveValid = function() {
		if(!$('#productForm').form("validate")) {
			return false;
		}
		//验证图片
		if(!$('#productForm').find('#picFile').val() && !id) {
			OFLY.message("请选择标题图片");
			return false;
		}
		// 验证内容
		if(!$.trim(editor.getContent()).length) {
			OFLY.message("请填写正文");
			return false;
		}
		
		return true;
	}
	_this.init					= init;
	_this.onAdd					= onAdd;
	return _this;
})();