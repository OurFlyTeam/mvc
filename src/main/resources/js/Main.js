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

/**/
$(function(){
	
    $("#business-field").click(function(){
        $(".title").addClass("header-scrolled");

        $('html,body').animate({scrollTop:$('.business-field').offset().top},500)
                      .animate({scrollTop:$('.business-field').offset().top-128},1000);
        // $("#whole").animate({top:"-435px"});
    });
    $("#index").click(function(){
        $(".title").removeClass("header-scrolled");
        $('html,body').animate({scrollTop:0},1000);
    });
    

});