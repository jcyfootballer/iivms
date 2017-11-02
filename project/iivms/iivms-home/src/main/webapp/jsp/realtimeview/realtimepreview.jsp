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
background:#ff0000;
border:1px solid #ddd;
cursor: pointer;
}
</style>
</head>
<body>
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
							<input type="hidden"  name="screen_nums" value="4"/>
							<input type="hidden"  name="screen_now" value="1"/>
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
					    <!-- <tr>
						    <td class="splitscreen"></td>
						    <td class="splitscreen"></td>
					     </tr>
					    <tr>
						    <td class="splitscreen"></td>
						    <td class="splitscreen"></td>
					    </tr> -->
					</table>
				</div>
				<div class="camera_bottom">
				  <table class="table" style="margin-bottom:1px">
				   <tbody>
					    <tr>
					      <td><img src="${ctx}/images/camera_icon1_sm.png" style="cursor: pointer" onClick="func(1)"/></td>
					      <td><img src="${ctx}/images/camera_icon2_sm.png" style="cursor: pointer" onClick="func(2)"/></td>
					      <td><img src="${ctx}/images/camera_icon3_sm.png" style="cursor: pointer" onClick="func(3)"/></td>
					      <td><img src="${ctx}/images/camera_icon4_sm.png" style="cursor: pointer" onClick="func(4)"/></td>
					      <td><img src="${ctx}/images/camera_icon5_sm.png" style="cursor: pointer" onClick="func(5)"/></td>
					      <td><img src="${ctx}/images/camera_icon6_sm.png" style="cursor: pointer" onClick="func(6)"/></td>
					      <td><img src="${ctx}/images/camera_icon7_sm.png" style="cursor: pointer" onClick="func(7)"/></td>
					      <td><img src="${ctx}/images/camera_icon8_sm.png" style="cursor: pointer" onClick="func(8)"/></td>
					      <td><img src="${ctx}/images/camera_icon9_sm.png" style="cursor: pointer" onClick="func(9)"/></td>
					      <td><img src="${ctx}/images/camera_icon10_sm.png" style="cursor: pointer" onClick="func(10)"/></td>
					      <td><img src="${ctx}/images/camera_icon11_sm.png" style="cursor: pointer" onClick="func(11)"/></td>
					    </tr>
					  </tbody>
				  </table>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript" src="${ctx}/js/vedio/video.min.js"></script>	
<script type="text/javascript" src="${ctx}/js/vedio/videojs-flash.min.js"></script>	
<script>
	    var treeObj;
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
			 }, 50);
			
			 $('#cameraseek').change(function() {
				 alert( $(this).val());
			 });
			 
			 initScreent(4);

		});
		function resizeWrapper() {
	    		//自适应高度
	    		var clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight
	    				: document.body.clientHeight;
	    		var iframeOffsetTop = $(document).find("body").offset().top;
	    		var blankH = clientH - iframeOffsetTop-370;
	    		$(".treepanel").css("height", blankH);
	    		$(".screen").css("height", clientH - iframeOffsetTop);
	    		$(".splitscreen").css("height", $(".screen").height()/2-2);
	    		
	    }
		function zTreeOnClick(event, treeId, treeNode){
			console.log(treeId+","+treeNode.tId + ", " + treeNode.id+","+treeNode.pId + ", " + treeNode.type);
		  
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
		function func(ind){
			console.log(ind);
		}
		
		function initScreent(ind){
			console.log("分屏数："+ind);
			var  _4splitScreen= " <tr> <td class=\"splitscreen\" id=\"4_1\" onclick=\"locateScreen(this)\"></td><td class=\"splitscreen\" id=\"4_2\" onclick=\"locateScreen(this)\"></td></tr>"
					+"<tr><td class=\"splitscreen\" id=\"4_3\" onclick=\"locateScreen(this)\"></td><td class=\"splitscreen\" id=\"4_4\" onclick=\"locateScreen(this)\"></td></tr>";

			document.cameraForm.screen_nums.value=ind;
			if(ind==4){
				$("#screenTable").empty();
				$("#screenTable").append(_4splitScreen);
				resizeWrapper();
			}
		};
				
		
		function locateScreen(obj){
			console.log("当前屏幕:"+obj.id);
			document.cameraForm.screen_now.value=obj.id;
			var _videoStr="<video data-setup='{\"techOrder\": [\"html5\", \"flash\"]}' id=\"video_"+obj.id+"\" autoplay class=\"video-js vjs-default-skin vjs-fluid\" controls preload=\"none\">"
			+"<source src='rtmp://live.hkstv.hk.lxdns.com/live/hks' type='rtmp/flv'><p class=\"vjs-no-js\">To view this video </p></video>"
			if($(obj).hasClass('splitscreen_now')){
				alert("一初始化");
				return ;
			}
			
			$(obj).append(_videoStr);
			$(obj).addClass("splitscreen_now");
			var player = videojs("video_"+obj.id, {  }, function () {
		           console.log('Good to go!');
		           this.play(); // if you don't trust axutoplay for some reason  
		 	})
		}
	</script>	
</body>
</html>