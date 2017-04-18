/*滚动导航更换背景*/
$(function(){
    var index = 1;
    play();

    function play(){   
        timer = setInterval(function(){
            if(index >= 4){
                index = 0;
            }
            $(".banner li").eq(index).attr("class","on").siblings().removeClass("on");
            $(".banner").fadeTo(100,0.6,function(){
                $(this).css({
                        "background":"url(img/main_viewpictures/"+(++index)+".jpg) no-repeat",
                        "background-size":"cover"}).fadeTo(300,1);
            });                  
        }, 3000);
    }

    $(".banner li").click(function(){
        var num = $(this).attr("data-num");
        $(this).attr("class","on").siblings().removeClass("on");
        $(".banner").fadeTo(100,0.6,function(){
            $(this).css({
                "background":"url(img/main_viewpictures/"+num+".jpg) no-repeat",
                "background-size":"cover"}).fadeTo(300,1);
        });
    });

    $(".banner").mouseover(function(){
        clearInterval(timer);
    });

    $(".banner").mouseout(function(){
        play();
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
