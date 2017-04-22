/*跳转到什么type*/
$(function() {

	if (type == "1" || type == "2" || type == "3" || type == "4" || type == "0") {
		// 实现选中状态

		$(".business-tab li").removeClass("active");
		$(".business-tab li").eq(type).addClass("active");
		$(".business-item").hide().eq(type).show();
	}

	$(".business-tab li").click(function() {
		$(".business-tab li").removeClass("active");
		$(this).addClass("active");
		$(".business-item").hide().eq($(this).index()).show();
	});

});
