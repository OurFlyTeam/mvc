var loadMask = (function(){
	var _this = this;
	var _imgWidth = 28;
	var _imgHeight = 28;
	var loading = function(id) {
		var loading = $('<span ><span>');//class="maskImg"
		var html = $('<div id="maskDiv" ></div>');//class="mask"
		html.append(loading);
		$('#'+id).append(html);
		// 初始遮罩层样式
		for(var name in _cssOptions.mask) {
			html.css(name,_cssOptions.mask[name]);
		}
		// 遮罩层位置
		html.css("height",$('#'+id).height());
		html.css("width",$('#'+id).width());
		html.css("top",$('#'+id).offset().top);
		html.css("left",$('#'+id).offset().left);
		var z_index = $('#'+id).css('z-index');
		if(isNaN(z_index)) {// 自动auto
			z_index = 0;
		}
		html.css('z-index', z_index+1);
		//初始遮罩层图片样式
		for(var name in _cssOptions.maskImg) {
			loading.css(name,_cssOptions.maskImg[name]);
		}
		// 遮罩层图表位置
		loading.css("margin-top",($('#'+id).height()-_imgHeight)/2);
		loading.css("margin-left",($('#'+id).width()-_imgWidth)/2);
	}
	var remove = function(id) {
		$('#'+id).find('#maskDiv').remove();
	}
	
	var _cssOptions = {
			mask:{
				position: 'absolute',
				top: '0',
				left:'0',
				opacity	: '0.5',
				background: 'gray'
			},
			maskImg: {
			    background: 'url(../../../../img/common/loading.gif)',
			    height: '28px',
			    width: '28px',
			    display: 'block',
			    position: 'fixed'
			}
	}
	
	_this.loading = loading;
	_this.remove = remove;
	return _this;
})();