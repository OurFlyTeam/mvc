$(".product-tab li").click(function() {
				$(".product-tab li").removeClass("active");
				$(this).addClass("active");

				$(".product-item").hide().eq($(this).index()).show();
			});

/*跳转到首页 对应模块*/
    
