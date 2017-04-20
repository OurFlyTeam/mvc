/**
 * @Author			: Logan
 * @introduction 	: 新闻
 */
var news = (function(){
	var _this={};
	
	/**
	 * @Author			: Logan
	 * @introduction 	: 保存
	 */
	var save = function() {
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
	
	_this.save = save;	// 保存
	
	return _this;
})();