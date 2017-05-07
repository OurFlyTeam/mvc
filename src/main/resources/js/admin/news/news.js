
/**
 * @Author			: Logan
 * @introduction 	: 新闻
 */
var news = (function(){
	var _this={};
	var currentTabIndex;
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
					$('#tabsNews').tabs("add",{
						title	: item.name,
						selected: index==0?true:false ,
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
	var _save  = function() {
		var _this = this;
		if(!_saveValid()) {
			return;
		}
		var url = ctx +'/newsEdit/save'
		var params = {
			
			title	: $('#newsForm').find("#title").textbox("getValue"), 
			type	: $('#newsForm').find("#type").combobox("getValue"),
			content	: editor.getContent()
		};
		if($('#newsForm').find('#id').val()) {
			params.id = $('#newsForm').find('#id').val();
		}
		OFLY.confirm("确认保存?", function() {
			$(_this).linkbutton("disable");
			$.post(url, params, function(data) {
				$.messager.alert({
					title	: "",
					msg		: data.msg,
					icon	: 'info',
					fn		: function() {
						if(data.code==1) {
							var newsValue = $('#newsForm').find("#type").combobox("getValue");
							$('#addDialog').dialog("close");
							$("#datagrid_news_"+newsValue).datagrid("reload");
						} else {
							$(_this).linkbutton("enable");
						}
					}
				});
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
		var datagrid = $('<table id="datagrid_news_'+value+'"></table>');
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
	/**
	 * @Author			: Logan
	 * @introduction 	: 新增弹出界面
	 */
	function _add(event) {
		var url = ctx + '/newsEdit/add'
		var params = {};
		var buttons = [{
			text	: '保存',
			iconCls : 'icon-save',
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
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 编辑弹出界面
	 */
	function _edit(event) {
		var newsValue = $('#tabsNews').tabs("getTab", currentTabIndex).panel('options').value;
		var row = $('#datagrid_news_'+newsValue).datagrid("getSelected");
		if(!row) {
			OFLY.message("请先选择一条数据");
			return;
		}
		var url = ctx + '/newsEdit/edit';
		var params = {
			id	: row.id
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
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 删除弹出界面
	 * 
	 */
	function _del(event) {
		var newsValue = $('#tabsNews').tabs("getTab", currentTabIndex).panel('options').value;
		var row = $('#datagrid_news_'+newsValue).datagrid("getSelected");
		if(!row) {
			OFLY.message("请先选择一条数据");
			return;
		}
		var url = ctx + '/newsEdit/delete';
		var params = {
			id	: row.id
		}
		OFLY.confirm("确认删除该数据?", function(){
			$.post(url, params, function(data) {
				OFLY.message(data.msg, function() {
					if(data.code){
						var newsValue = $('#tabsNews').tabs("getTab", currentTabIndex).panel('options').value;
						$('#datagrid_news_'+newsValue).datagrid("reload");
					}
				});
			});
		});
		
	}
	var onSelect = function(title, index) {
		currentTabIndex = index;
	} 
	
	_this.init = init;			// 初始化新闻维护界面
	_this.onAdd = onAdd;		// 新增tab页触发
	_this.onSelect = onSelect;	// 选择tab后触发事件
	//_this.save = save;		// 保存
	
	return _this;
})();