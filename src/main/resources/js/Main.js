$(function() {
	$(".owl-carousel").owlCarousel({
		items : 1,
		loop : true,
		autoplay : true,
		autoplayTimeout : 4000,
		autoplayHoverPause : true
	});
});
/* 滚动导航更换背景 */
//$(function() {
//	$(window).scroll(function() {
//		var $this = $(this);
//		var targetTop = $(this).scrollTop();
//
//		var height = $(window).height();
//
//		if (targetTop > 128) {
//			$(".title").addClass("header-scrolled");
//		} else {
//			$(".title").removeClass("header-scrolled");
//		}
//
//	});
//});

// 晟荣概况
$(function() {
	$(".barpro01 li").each(function() {
		$(this).stop().hover(function() {
			$(".barpro01 li").removeClass("cur");
			$(this).addClass("cur");
			$(".projsdivq").css("display", "none");
			$("." + $(this).attr("k")).css("display", "block");
		}, function() {
		})
	})
});

/* 实现首页内跳转到模块位置 */
// on_click 定义参数，不能连续点击
$(function() {
	var on_click = false;
	
	$("#contact-field").click(function() {
		if (!on_click) {
			on_click = true;
			$(".title").addClass("header-scrolled");

			$('html,body').animate({
				scrollTop : $('.contact-field').offset().top - 178 - 215
			}, 500).animate({
				scrollTop : $('.contact-field').offset().top - 128 - 215
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}

	});
	
	$("#company-field").click(function() {
		if (!on_click) {
			on_click = true;
			$(".title").addClass("header-scrolled");

			$('html,body').animate({
				scrollTop : $('.company-field').offset().top
			}, 500).animate({
				scrollTop : $('.company-field').offset().top - 128
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}

	});

	$("#news-field").click(function() {
		if (!on_click) {
			on_click = true;
			$(".title").addClass("header-scrolled");

			$('html,body').animate({
				scrollTop : $('.news-field').offset().top
			}, 500).animate({
				scrollTop : $('.news-field').offset().top - 128
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}

	});

	$("#product-field").click(function() {
		if (!on_click) {
			on_click = true;
			$(".title").addClass("header-scrolled");

			$('html,body').animate({
				scrollTop : $('.product-field').offset().top
			}, 500).animate({
				scrollTop : $('.product-field').offset().top - 128
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}

	});
	$("#business-field").click(function() {
		if (!on_click) {
			on_click = true;
			$(".title").addClass("header-scrolled");

			$('html,body').animate({
				scrollTop : $('.business-field').offset().top
			}, 500).animate({
				scrollTop : $('.business-field').offset().top - 128
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}
	});
	$("#index").click(function() {
		if (!on_click) {
			on_click = true;

			//$(".title").removeClass("header-scrolled");
			$('html,body').animate({
				scrollTop : 0
			}, 1000, function(ev) {// 动作完成之后再做什么
				on_click = false;
			});
		}
	});

});

// 其他页面跳转到Main,到对应的
$(function() {
	if (source == "product") {
		$(".title").addClass("header-scrolled");
		$('html,body').animate({
			scrollTop : $('.product-field').offset().top
		}, 500).animate({
			scrollTop : $('.product-field').offset().top - 128
		}, 1000);
	} else if (source == "business") {
		$(".title").addClass("header-scrolled");
		$('html,body').animate({
			scrollTop : $('.business-field').offset().top
		}, 500).animate({
			scrollTop : $('.business-field').offset().top - 128
		}, 1000);
	} else if (source == "news") {
		$(".title").addClass("header-scrolled");
		$('html,body').animate({
			scrollTop : $('.news-field').offset().top
		}, 500).animate({
			scrollTop : $('.news-field').offset().top - 128
		}, 1000);
	} else if (source == "company") {
		$(".title").addClass("header-scrolled");
		$('html,body').animate({
			scrollTop : $('.company-field').offset().top
		}, 500).animate({
			scrollTop : $('.company-field').offset().top - 128
		}, 1000);
	} else if (source == "contact") {
		$(".title").addClass("header-scrolled");
		$('html,body').animate({
			scrollTop : $('.contact-field').offset().top - 178 - 215
		}, 500).animate({
			scrollTop : $('.contact-field').offset().top - 128 - 215
		}, 1000);
	}
	source = null;
});