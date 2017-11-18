//仅适用于IE浏览器是，并且安装有vlc插件，则返回true；  
function isInsalledIEVLC() {
	var vlcObj = null;
	var vlcInstalled = false;
	try {
		vlcObj = new ActiveXObject("VideoLAN.Vlcplugin.1");
		if (vlcObj != null) {
			vlcInstalled = true
		}
	} catch (e) {
		vlcInstalled = false;
	}
	return vlcInstalled;
}

// 仅适用于firefox浏览器是，并且安装有vlc插件，则返回true；
function isInsalledFFVLC() {
	var numPlugins = navigator.plugins.length;
	for (i = 0; i < numPlugins; i++) {
		plugin = navigator.plugins[i];
		if (plugin.name.indexOf("VideoLAN") > -1
				|| plugin.name.indexOf("VLC") > -1) {
			return true;
		}
	}
	return false;
}

/* 浏览器检测 */
function checkBrowser() {
	var browser = navigator.appName
	var b_version = navigator.appVersion
	var version = parseFloat(b_version)
	if (browser == "Netscape" && version >= 4) {
		if (isInsalledFFVLC()) {
			//alert("已装VLC插件");
		} else {
			alert("未装VLC插件");
			//location.href = "http://download.videolan.org/pub/videolan/vlc/2.2.1/";
		}
	} else if (browser == "Microsoft Internet Explorer" && version >= 4) {
		if (isInsalledIEVLC()) {
			alert("已装VLC插件");
		} else {
			alert("未装VLC插件,请先安装插件");
			//location.href = "http://download.videolan.org/pub/videolan/vlc/2.2.1/";
		}
	}
}
var Screen = function() {
	var _4splitScreen = " <tr> <td class='splitscreen' onclick='locateScreen(1)'></td><td class='splitscreen' onclick='locateScreen(2)'></td></tr>"
			+ "<tr><td class='splitscreen' onclick='locateScreen(3)'></td><td class='splitscreen' onclick='locateScreen(4)'></td></tr>";

};

var  ScreenTemplate  = function(element, index){
	this.element = $(element);
    //this.currentdb=-1;
	this.currentindex = index;
//	this.element.find("#currentFormId").val(this.currentindex);
	//this.element.find("#mainform form").attr({ id: "form"+this.currentindex, name: "form"+this.currentindex });
	//this.element.find("#form"+this.currentindex+" #queryTable").attr({ id: "queryTable"+this.currentindex, name: "queryTable"+this.currentindex });
	//this.element.find("#form"+this.currentindex+" #queryResult").attr({ id: "queryResult"+this.currentindex, name: "queryResult"+this.currentindex });
	//this.element.find("#form"+this.currentindex+" #queryCondition").attr({ id: "queryCondition"+this.currentindex, name: "queryCondition"+this.currentindex });
	
	
	this.initScreen(index);
	
	
};
	
ScreenTemplate.prototype = {
	constructor: ScreenTemplate,
	
	_tabIndex:function(){
		 return this.currentindex;
	},
   initScreen:function(ind){
	console.log("分屏数："+ind);
	var _ind = document.cameraForm.screen_nums.value;
	if(_ind == ind){
		return;
	}
	document.cameraForm.screen_nums.value=ind;
	$("#screenTable").empty();
	if(ind==1){
		$("#screenTable").append(Templatelobal._1splitScreen);
	}else if(ind==4){
		$("#screenTable").append(Templatelobal._4splitScreen);
	}else if(ind==6){
		$("#screenTable").append(Templatelobal._6splitScreen);
	}else if(ind==9){
		$("#screenTable").append(Templatelobal._9splitScreen);
	}else if(ind==16){
		$("#screenTable").append(Templatelobal._16splitScreen);
	}
	this.calucatedHeight(ind);
	document.cameraForm.screen_now.value="";
	$(".splitscreen").on("click",function(){
		console.log(this.id);
	
		locateScreen(this);
		/**
		 * 
		var _screen_now = document.cameraForm.screen_now.value;
		if(_screen_now==this.id){
			return;
		}
		document.cameraForm.screen_now.value=this.id;
		$(".splitscreen_now").removeClass("splitscreen_now");
		$("#"+this.id).addClass("splitscreen_now");
		var url = "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov"
		var html = screenTemplate.showVlcPlayer(this.id,url);
		console.log(html)
		$("#"+this.id).append(html);
		 */
	});
	
   },
   calucatedHeight:function(ind){
	   var screenHeight = $(".screen").height();
	   var screenWidth = $(".screen").width();
	   if(ind==1){
		   $(".splitscreen").css("height", screenHeight-2);
		   $(".splitscreen").css("width", screenWidth-2);
	   }else if(ind==4){
		   $(".splitscreen").css("height", screenHeight/2-2);
		   $(".splitscreen").css("width", screenWidth/2-2);
	   }else if(ind==6){
		   $(".splitscreen").css("height", screenHeight/3-2);
		   $(".splitscreen").css("width", screenWidth-2);
		   $(".splitscreenbig").css("height", screenHeight/3*2-2);
		   $(".splitscreenbig").css("width", screenWidth/3*2-2);
	   }else if(ind==9){
		   $(".splitscreen").css("height", screenHeight/3-2);
		   $(".splitscreen").css("width", screenWidth/3-2);
	   }else if(ind==16){
			$(".splitscreen").css("height", screenHeight/4-2);
			$(".splitscreen").css("width", screenWidth/4-2);
	   } 
   },
   
   showVlcPlayer: function(id,url){    
	    var vhtml = "<object id='vlc_"+id+"'";    
	    var userAg = navigator.userAgent;    
	    //if(-1 != userAg.indexOf("MSIE")){    
	        vhtml+=" classid='clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921'";    
	    //}    
	    //else if(-1 != userAg.indexOf("Firefox") || -1 != userAg.indexOf("Chrome") || -1 != userAg.indexOf("Opera") || -1 != userAg.indexOf("Safari")){    
	        vhtml+=" type='application/x-vlc-plugin'";    
	    //}    
	    vhtml+=" width='30' height='20'>";    
	    
	    //vhtml+=" >";   
	    //下面这些播放器的参数自己配置吧    
	    vhtml+="<param name='mrl' value='"+url+"' />";  
	    vhtml+="<param name='autoplay' value='true' />";   
	    vhtml+="<param name='volume' value='50' />";   
	    vhtml+="<param name='loop' value='false' />";   
	    vhtml+="<param name='fullscreen' value='false' />";   
	    vhtml+="</object>";  
	    
	    var html = "<object  classid='clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921' codebase='http://download.videolan.org/pub/videolan/vlc/last/win32/axvlc.cab' id='vlc_"+id+"'> "+
		"<embed autoplay='yes' type='application/x-vlc-plugin' pluginspage='http://www.videolan.org' name='vlc_"+id+"' width='100%' height='100%'/>"+
		"<param name='autostart' value='true' />"+
		"<param name='mrl' value='"+url+"' />"+
		"<param name='allowfullscreen' value='false' />"+
		"</object>"
	    
		var html1='			 <object classid="clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921"'+
     'autostart="true" codebase="'+url+'"'+
    'name="vlc_'+id+'">'+
    '<param name="MRL" value="'+url+'" />'+
    '<embed autostart="true" type="application/x-vlc-plugin" '+
        'pluginspage="http://www.videolan.org" '+
        'version="VideoLAN.VLCPlugin.2" width="100%" height="100%" id="vlc_'+id+'" '+
        'target="'+url+'"> '+
    '</embed></object><input type="hidden" id="vlc_cameraId" value=""/>'
	    return html1;    
	}    
   
}

var Templatelobal = {
		 _1splitScreen : " <tr><td class='splitscreen' id='s_1_1'></td></tr>"
				,
		 _4splitScreen : " <tr> <td class='splitscreen' id='s_4_1'></td><td class='splitscreen' id='s_4_2'></td></tr>"
			+ "<tr><td class='splitscreen' id='s_4_3'></td><td class='splitscreen' id='s_4_4'></td></tr>"
			,
	     _6splitScreen : " <tr> <td class='splitscreen splitscreenbig' colspan='2'  rowspan='2' id='s_6_1' ></td>" +
	     		"<td class='splitscreen' id='s_6_2'></td></tr>"
					+ "<tr><td class='splitscreen' id='s_6_3'></td></tr>"
					+ "<tr><td class='splitscreen' id='s_6_4'></td>" +
							"<td class='splitscreen' id='s_6_5'></td>" +
							"<td class='splitscreen' id='s_6_6'></td></tr>"
					,
		_9splitScreen : " <tr> <td class='splitscreen' id='s_9_1'></td>" +
				"<td class='splitscreen' id='s_9_2'></td>" +
				"<td class='splitscreen' id='s_9_3'></td></tr>"
				+ "<tr><td class='splitscreen' id='s_9_4'></td>" +
				"<td class='splitscreen' id='s_9_5'></td>" +
				"<td class='splitscreen' id='s_9_6'></td></tr>"
				+ "<tr><td class='splitscreen' id='s_9_7'></td>" +
						"<td class='splitscreen' id='s_9_8'></td>" +
						"<td class='splitscreen' id='s_9_9'></td></tr>"
					,
		_16splitScreen : " <tr><td class='splitscreen' id='s_16_1'></td><td class='splitscreen' id='s_16_2'></td>" +
				         "<td class='splitscreen' id='s_16_3'></td><td class='splitscreen' id='s_16_4'></td></tr>"+
		" <tr> <td class='splitscreen' id='s_16_5'></td><td class='splitscreen' id='s_16_6'></td>" +
        "<td class='splitscreen'id='s_16_7'></td><td class='splitscreen' id='s_16_8'></td></tr>"+
		" <tr> <td class='splitscreen' id='s_16_9'></td><td class='splitscreen' id='s_16_10'></td>" +
        "<td class='splitscreen' id='s_16_11'></td><td class='splitscreen' id='s_16_12'></td></tr>"+
		" <tr> <td class='splitscreen' id='s_16_13'></td><td class='splitscreen' id='s_16_14'></td>" +
        "<td class='splitscreen' id='s_16_15'></td><td class='splitscreen' id='s_16_16'></td></tr>"
//		initScreenTemplate:'  <tr id="row1"><td id="_tfindType"><input  type="hidden" name="_t_1_1_1" id="_t_1_1_1" value=""/><select class="selectCss form-control" id="_t_1_1_1_1" name="_t_1_1_1_1" ><option value="singleTable" selected>单表查询</option><option value="MultTable">多表关联</option></select></td>'+
//		   '<td> <input class="inputCss2" type="text"  id="_t_1_1_2" name="_t_1_1_2"  title="" placeholder="Hive表"/></td> '+
//	       '<td><input class="inputCss1" type="text" id="_t_1_1_3"  name="_t_1_1_3" readonly hidden value="as"/></td>'+
//		   '<td><input class="inputCss22" type="text"  id="_t_1_1_4"  name="_t_1_1_4" readonly hidden/></td>'+
//		   '<td colspan="8"><span  style="width:200px; display: block;"></span></td>'+
//		   '<td><div class="btn-group btn-group-md btn-group-xs" ><button type="button" class="btn btn-info hidden"  id="plusbtn1" onclick="javascript:_tablePlusAll(1)"><span   class="glyphicon glyphicon-plus spanCss" ></span></button><button type="button" class="btn-info hidden" id="minusbtn1"><span class="glyphicon glyphicon-minus spanCss" ></span></button></div></td>'+
//	       '</tr>',	
		,
		_vlcConfig : "<object classid='clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921' codebase='http://download.videolan.org/pub/videolan/vlc/last/win32/axvlc.cab' id='vlc'> "+
						"<embed type='application/x-vlc-plugin' pluginspage='http://www.videolan.org' name='vlc' />"+
						"<param name='autostart' value='true' />"+
						"<param name='mrl' value='_mrl' />"+
						"<param name='allowfullscreen' value='false' />"+
						"</object><input type='hidden' id='vlc_cameraId' value=''/>"
		
		
}	       














