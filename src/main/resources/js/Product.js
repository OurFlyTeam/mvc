/*跳转到什么type*/
$(function() {
if(type=="0"||type=="1"||type=="2"){
	//实现选中状态
	$(".product-tab li").removeClass("active");
	$(".product-tab li").eq(type).addClass("active");
	$(".product-item").hide().eq(type).show();
	
}

$(".product-tab li").click(function() {
				$(".product-tab li").removeClass("active");
				$(this).addClass("active");
				$(".product-item").hide().eq($(this).index()).show();
			});
}) 
    
