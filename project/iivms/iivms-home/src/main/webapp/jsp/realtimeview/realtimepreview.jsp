<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>实时预览页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/base.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/view.css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrapValidator.min.css" />
 <link href="${ctx}/js/vedio/video-js.min.css" type="text/css" rel="stylesheet" />	
<script type="text/javascript"
	src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet"
	href="${ctx}/js/zTree/css/zTreeStyle.css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/zTree/css/icon.css" />
<script type="text/javascript"
	src="${ctx}/js/zTree/js/jquery.ztree.all-3.5.js"></script>
<style>
.splitscreen{
background:#303133;
border:1px solid #ddd;
cursor: pointer;
}
.splitscreen_now{
background:#008aff;
border:1px solid #ddd;
cursor: pointer;
}
</style>
</head>
<body >
	<div class="container-fluid">
		<!-- BEGIN PAGE HEADER-->
		<div class="row">
			<div class="col-md-4 col-lg-3 col-sm-5">
				<div class="panel panel-success" style="margin-bottom: 5px">
					<div class="panel-heading ">
						 <div class="input-group input-group-md ">
						  <span class="input-group-addon " id="basic-addon1">摄像头信息：</span>
							  <input type="text" class="form-control" placeholder="搜索" aria-describedby="basic-addon1" id="cameraseek"/>
						 </div>
					 </div>
					<div class="panel-body">
						<div class="treepanel">
							<ul id="Tree" class="ztree"></ul>
						</div>
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 5px">
					<div class="panel-body">
						<div class=" holderpic">
						  <img src="${ctx}/images/holder.png" style="margin: 0 auto;display:block; "></img>
						</div>
						<hr style="height:1px;border:none;border-top:1px solid #555555;" />
						<form class="form-horizontal"  id ="cameraForm" name="cameraForm">
							<input type="hidden"  name="cameraId" value=""/>
							<input type="hidden"  name="screen_nums" value=""/>
							<input type="hidden"  name="screen_now" value=""/>
							  <div class="form-group">
							    <label for="yuzhidian" class="col-sm-4 control-label">预置点：</label>
							    <div class="col-sm-4">
							       <select class=" col-sm-4 form-control" id="yuzhidian"> 
									  <option>1</option>
									  <option>2</option>
									  <option>3</option>
									  <option>4</option>
									  <option>5</option>
								   </select>
							    </div>
							  </div>
								   <p class="pull-right" style="margin-top:5px">
									  <button type="button" class="btn btn-primary btn-sm" onclick="javascript:fun(1)">设置</button>
									  <button type="button" class="btn btn-primary btn-sm" onclick="javascript:fun(2)">调用</button>
									  <button type="button" class="btn btn-primary btn-sm" onclick="javascript:fun(3)">删除</button>
									</p>
						</form>			
					</div>		
				</div>
			</div>
			<div class="col-md-8 col-lg-9 col-sm-7">
				<div class="screen">
					 <table id="screenTable"class="table" style="margin-bottom:1px">
					</table>
				</div>
				  <table class="screenBtn table " style="margin-bottom:1px">
				   <tbody >
					    <tr>
					     <td><div class="camera_nomusic"></div></td>
					     <td><div class="camera_music"></div></td>
					     <td><div class="camera_printscreen"></div></td>
					     <td><div class="camera_video"></div></td>
					     <td><div class="camera_stop"></div></td>
					     <td><div class="camera_stopall"></div></td>
					     <td><div class="camera_screen_1" onClick="switchScreen(1)"></div></td>
					     <td><div class="camera_screen_4" onClick="switchScreen(4)"></div></td>
					     <td><div class="camera_screen_6" onClick="switchScreen(6)"></div></td>
					     <td><div class="camera_screen_9" onClick="switchScreen(9)"></div></td>
					     <td><div class="camera_screen_16" onClick="switchScreen(16)" ></div></td>
					     <td><div class="camera_screen_open"></div></td>
					     <td><div class=""></div></td>
					     <td><div class=""></div></td>
					    </tr>
					  </tbody>
				  </table>
				</div>
			</div>
	</div>
<!-- 
<script type="text/javascript" src="${ctx}/js/vedio/video.min.js"></script>	
<script type="text/javascript" src="${ctx}/js/vedio/videojs-flash.min.js"></script>	 -->
<script type="text/javascript" src="${ctx}/js/vlcScreen.js"></script>	
<script>
	    var treeObj;
	    var screenTemplate;
		jQuery(document).ready(function() { 
			resizeWrapper();
			var setting = {
		    		async: {
		    			enable: true,
		    			url: "${ctx}/cameraManage/getData",
		    			autoParam: ["id","type"]				
		    		},
		            view: {
		                dblClickExpand: true,
		                showLine: true,
		                showTitle:true
		            }, 
		            data: {
		                key: {
		                    title:"title"
		                },
		                simpleData: {
		                    enable: false 
		                }
		            },
		            callback: {
		               onClick: zTreeOnClick
		            }
		    }
			var myTree=$.fn.zTree.init($("#Tree"), setting,null);
		     treeObj = $.fn.zTree.getZTreeObj("Tree");
			//var newNode = {"id":"0","name":"智能综合视频监控平台","type":0,"iconSkin":"home"};
			//newNode = treeObj.addNodes(null, newNode);
			 setTimeout(function () { 
				 var nodes = treeObj.getNodes();
				 treeObj.expandNode( nodes[0], true, true, true);
			 }, 100);
			
			 $('#cameraseek').change(function() {
				 alert( $(this).val());
			 });
			 checkBrowser();
			 screenTemplate = new ScreenTemplate($("#cameraForm"),4);
		});
		function resizeWrapper() {
	    		//自适应高度
	    		var clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight
	    				: document.body.clientHeight;
	    		var iframeOffsetTop = $(document).find("body").offset().top;
	    		var blankH = clientH - iframeOffsetTop-370;
	    		$(".treepanel").css("height", blankH);
	    		$(".screen").css("height", clientH - iframeOffsetTop+20);
	    		//$(".splitscreen").css("height", $(".screen").height()/2-2);
	    		
	    }
		function zTreeOnClick(event, treeId, treeNode){
			console.log(treeId+","+treeNode.tId + ", " + treeNode.id+","+treeNode.pId + ", " + treeNode.type);
			document.cameraForm.cameraId.value=treeNode.id;
			
		}
		function fun(ind){
			console.log("设置点数："+$("#yuzhidian").val());
			if(1==ind){
				console.log("设置");
			}else if(2==ind){
				console.log("调用");
			}else if(3==ind){
				console.log("删除");
			}
		}
		function switchScreen(ind){
			screenTemplate.initScreen(ind);
		}
		function locateScreen(obj){
			console.log("当前屏幕:"+obj.id);
			var _screen_now = document.cameraForm.screen_now.value;
			if(_screen_now==this.id){
				return;
			}
			document.cameraForm.screen_now.value=this.id;
			$(".splitscreen_now").removeClass("splitscreen_now");
			$("#"+this.id).addClass("splitscreen_now");
			var url = "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov"
			
			var cameraId = document.cameraForm.cameraId.value;
			if(cameraId==''){
					alert("请选择要查看的摄像头");
					return ;
			}	
			
			$.get("${ctx}/realtimepreview/vediomanage/"+cameraId,function(result) {
				 if(200==result.status){
					 var data = result.data;
					 alert(data.cameraId);
					 alert(data.rtsp);
					 var html = screenTemplate.showVlcPlayer(this.id,data.rtsp);
					 console.log(html)
					 $("#"+this.id).append(html);
	        	 }
			}, "json");
			
			//var _videoStr="<video data-setup='{\"techOrder\": [\"html5\", \"flash\"]}' id=\"video_"+obj.id+"\" autoplay class=\"video-js vjs-default-skin vjs-fluid\" controls preload=\"none\">"
			//+"<source src='rtmp://172.28.3.113:1935/live/livestream' type='rtmp/flv'><p class=\"vjs-no-js\">To view this video </p></video>"
			
			//var _videoStr="";
			
		//	$(obj).append(_videoStr);
		//	$(obj).addClass("splitscreen_now");
		//	var player = videojs("video_"+obj.id, {  }, function () {
		           //console.log('Good to go!');
		  //         this.play(); // if you don't trust axutoplay for some reason  
		 //	})
		}
	</script>	
</body>
</html>