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