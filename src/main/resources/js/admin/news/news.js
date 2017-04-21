/**
 * @Author			: Logan
 * @introduction 	: 新闻
 */
var news = (function(){
	var _this={};
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 初始化新闻维护界面
	 */
	var init = function() {
		var url = ctx + '/code/getCodeListBySortCode';
		var params = {
			sortCode	: 'newsType'	
		};
		$.get(url, params, function(data) {
			if(data!=null) {
				$.each(data, function(index, item) {
					$('#tabs').tabs("add",{
						title	: item.name,
						selected: false,
						value	: item.value
					});
				});
			} 
		});
	}
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 保存
	 */
	var _save = function() {
		if(!_saveValid()) {
			return;
		}
		var url = ctx +'/newsEdit/save'
		var params = {
			title	: $("#title").textbox("getValue"), 
			type	: $("#type").combobox("getValue"),
			content	: editor.getContent()
		};
		$.post(url, params, function(data) {
			$.messager.alert({
				title	: "",
				msg		: data.msg,
				icon	: 'info',
				fn		: function() {
					if(data.code==1) {
						window.location.reload();
					}
				}
			});
		});
	};
	/**
	 * @Author			: Logan
	 * @introduction 	: 保存_验证
	 */
	var _saveValid = function() {
		if(!$('#newsForm').form("validate")) {
			return false;
		}
		return true;
	}
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 新增tab页时候调用的函数
	 */
	var onAdd = function (title, index) {
		var tab = $(this).tabs("getTab", index);
		var value = tab.panel("options").value;
		var datagrid = $('<table id="datagrid_'+value+'"></table>');
		tab.html(datagrid);
		datagrid.datagrid({
			url			: ctx + '/newsEdit/queryListByType?type='+value,
			singleSelect:true,
			rownumbers	:true,
			loadMsg		:'查询中',
			pagination	:true,
			striped		:true,
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
		var url = ctx + '/newsEdit/edit'
		var params = {};
		var buttons = [{
			text	: '保存',
			iconCls : 'icon-save',
			plain	: true,
			hander	: _save
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
				debugger;
	        	editor.destroy();
	        },
		}
		var div = '<div id="addDialog"></div>';
		$(document.body).append(div); 
		$("#addDialog").dialog(options);
	}
	function _edit(event) {
		debugger;
	}
	function _del(event) {
		debugger;
	}
	_this.init = init;		// 初始化新闻维护界面
	_this.onAdd = onAdd;	// 新增tab页触发
	//_this.save = save;		// 保存
	
	return _this;
})();