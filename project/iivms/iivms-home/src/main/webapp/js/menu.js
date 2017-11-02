jQuery(function(){
	resizeWrapper();
	var resizeTimeout;
	$(window).resize(function() {
		clearTimeout(resizeTimeout);
		resizeTimeout = setTimeout(function() {
			resizeWrapper();
		}, 500);
	});
	//初始化菜单
	$("#func-ul").css("left", "-200px");
	formatMenu();

	$("#panel_arrow").click(function(event) {
		if ($("#panel_img").hasClass("collapse_right")) {
			hiddenMenu();
		} else {
			showMenu();
		}
		event.stopPropagation();
	});
	$("#cover").click(function(event) {
		hiddenMenu();
		event.stopPropagation();
	});
	$("#func-div").click(function(event) {
		//hiddenMenu();
		//event.stopPropagation();
	});
})	

function resizeWrapper() {
		//自适应高度
		var clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight
				: document.body.clientHeight;
		var clientW = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientWidth
				: document.body.clientWidth;
		var iframeOffsetTop = $(document).find("body").offset().top;
		var blankH = clientH - iframeOffsetTop - 75;
		$("#content").css("height", blankH + 10);
		$("#cover").css("height", blankH);
		$("#area-func").css("height", blankH - 10);
		formatMenu();
	}


function formatMenu() {
		var funcWeight = 200;
		$("#func-ul").css("width", funcWeight);
		var temp = "-" + funcWeight + "px";
		if ("0px" != $("#func-ul").css("right")) {
			$("#func-ul").css("right", temp);
		}
	}

	function showMenu() {
		$("#area-func").css("visibility", "visible");
		$("#cover").css({
			"filter" : "alpha(opacity = 80)",
			"opacity" : "0.8"
		});
		$("#cover").fadeIn();
		$("#func-ul").animate({
			left : 50
		}, 500).animate({
			left : 0
		}, 200);
		$("#panel_img").removeClass("expand_right").addClass("collapse_right");
	}

	function hiddenMenu() {
		var funcMenuWidth = $("#func-ul").width();
		var temp = "-" + funcMenuWidth + "px";
		$("#func-ul").animate({
			left : 50
		}, 200).animate({
			left : temp
		}, 500, "", function() {
			$("#area-func").css("visibility", "hidden");
			$("#cover").fadeOut();
		});
		$("#panel_img").removeClass("collapse_right").addClass("expand_right");
	}
