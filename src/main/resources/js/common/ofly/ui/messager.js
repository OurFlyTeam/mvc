/**
 * @Author			: Logan
 * @introduction 	: 消息提示框
 * [
 * 		msg		: 提示内容
 * 		fn		: 回调函数
 * 		level	: 提示级别
 * 					[
 * 						error,
 * 						question,
 * 						info,
 * 						warning
 * 					]
 * ]
 */
OFLY.message = function(msg, fn, level) {
	$.messager.alert({
		title	: '',
		msg		: msg,
		icon	: level==null?'info':level,
		fn		: function() {
			if($.isFunction(fn)) {
				fn.call(this);
			}
		}
	});
};

/**
 * @Author			: Logan
 * @introduction 	: 确认框
 * [
 * 		msg		: 提示信息
 * 		sucFn	: 确认后回调函数
 * 		failFn	: 取消后回调函数
 * ]
 */
OFLY.confirm = function(msg, sucFn, failFn) {
	$.messager.confirm('', msg, function(flag){
		if(flag && $.isFunction(sucFn)) {
			sucFn.call(this);
		}
		if(!flag && $.isFunction(failFn)) {
			failFn.call(this);
		}
	});
}
/**
 * @Author			: Logan
 * @introduction 	: Dialog框
 * [
 * 		id		: dialog ID
 * 		url		: 统一资源定位
 * 		params	: 入参
 * 		title	: 标题
 * 		width	: 宽度
 * 		height	: 高度
 * 		buttons	: 底层按钮(为数组，数组内部对象如下)格式为[{text:'',type:'',handler:fn},{text:'',type:'',handler:fn}...]
 * 				  [
 * 					text	: 按钮名称
 * 					type	: 按钮类型
 * 							 ['save','reload']
 * 					handler	: 点击出来的方法
 * 				  ]
 * 		
 * ]
 */
OFLY.dialog = function(id, url, params, title, width, height, buttons) {
	var div = '<div id="'+id+'"></div>';
	$(document.body).append(div); 
	var options = {
		title	: title,
		width	: width,
		height	: height,
		href	: url+ "?"+$.param(params),
		closed	: false,
        cache	: false,
        modal	: true,
        onClose	: function() {
        	editor.destroy();
        }
	}
	// 转换type 的为样式图标
	var map = {
		save	: 'icon-save',
		reload	: 'icon-reload',
		close	: 'icon-close'
		
	};
	if(buttons!=null && buttons.length>0) {
		$.each(buttons,function(index, item) {
			item.iconCls 	= map[item.type];
			item.plain 		= true;
			delete item.type;
		});
		options['buttons'] = buttons;
	}
	$('#'+id).dialog(options);
}
/**
 * @Author			: Logan
 * @introduction 	: 关闭dialog 
 * [
 * 		id	: dialog ID
 * ]
 */
OFLY.dialog.close = function(id) {
	$('#'+id).dialog('close');
}