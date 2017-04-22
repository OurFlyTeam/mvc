

$(function(){
    $(".owl-carousel").owlCarousel({
        items:1,
        loop:true,
        autoplay:true,
        autoplayTimeout:1000,
        autoplayHoverPause:true
    });
});
/*滚动导航更换背景*/
$(function(){
    $(window).scroll(function(){
        var $this = $(this);
        var targetTop = $(this).scrollTop();
        
        var height = $(window).height();
        
        if (targetTop > 128){
            $(".title").addClass("header-scrolled");
        }else{
            $(".title").removeClass("header-scrolled");
        }
        
    });
});

/*实现首页内跳转到模块位置*/
//on_click 定义参数，不能连续点击
var on_click = false;
$(function(){
	$("#product-field").click(function(){
		if(!on_click){
			on_click = true;
			$(".title").addClass("header-scrolled");

	        $('html,body').animate({scrollTop:$('.product-field').offset().top},500)
	                      .animate({scrollTop:$('.product-field').offset().top-128},1000
	                    		  ,function(ev) {//动作完成之后再做什么
	  						on_click = false;
	  					});
		}
        
        // $("#whole").animate({top:"-435px"});
    });
    $("#business-field").click(function(){
		if(!on_click){
			on_click = true;
	        $(".title").addClass("header-scrolled");
	
	        $('html,body').animate({scrollTop:$('.business-field').offset().top},500)
	                      .animate({scrollTop:$('.business-field').offset().top-128},1000
                    		  ,function(ev) {//动作完成之后再做什么
	  						on_click = false;
	  					});
		}
        // $("#whole").animate({top:"-435px"});
    });
    $("#index").click(function(){
        $(".title").removeClass("header-scrolled");
        $('html,body').animate({scrollTop:0},1000);
    });
    

});