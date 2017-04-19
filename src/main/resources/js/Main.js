/*滚动导航更换背景 使用插件*/
$(function(){
    $(".owl-carousel").owlCarousel({
        items:1,
        loop:true,
        autoplay:true,
        autoplayTimeout:3000,
        autoplayHoverPause:true
    });
});
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
