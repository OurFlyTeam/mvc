
//自动获取时间
(function(){
    var on_click = false;
	$(".tbn div.left").click(function(ev) {//鼠标点击
		if(on_click){
			return;
		}
		click("left");
		on_click = true;
	});
	$(".tbn div.right").click(function(ev) {//鼠标点击
		if(on_click){
			return;
		}
		click("right");
		on_click = true;
	});
	
	function click(dir){
		
		var T=[],L=[],W=[],H=[],O=[],Z=[];
		//循环获取li的属性
		$(".showimg-layout ul li").each(function(i){
			W[i] = $(this).css("width");//获取li属性的width值
			L[i] = $(this).css("left");
			T[i] = $(this).css("top");
			H[i] = $(this).css("height");
			O[i] = $(this).css("opacity");
			Z[i] = $(this).css("z-index");
		});
		var change;
		if(dir == "left"){
			//console.log("左");
			$(".showimg-layout ul li").each(function(i){
				if(i == 0){
					change = 8;
				}else{
					change = i - 1;
				}
				$(this).css("z-index",Z[change]) ;
				$(this).animate({
					width : W[change],
					left : L[change],
					top : T[change],
					height : H[change],
					opacity : O[change]
				}, 200, function(ev) {//动作完成之后再做什么
					on_click = false;
				});
			});
			
		}else if(dir == "right"){
			//console.log("右");
			$(".showimg-layout ul li").each(function(i){
				if(i == 8){
					change = 0;
				}else{
					change = i + 1;
				}
				$(this).css("z-index",Z[change]) ;
				$(this).animate({
					width : W[change],
					left : L[change],
					top : T[change],
					height : H[change],
					opacity : O[change]
				}, 200, function(ev) {//动作完成之后再做什么
					on_click = false;
				});
			});
		}
		
	}
})();
