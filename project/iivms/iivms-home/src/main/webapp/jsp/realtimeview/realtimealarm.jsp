<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="com.cars.iivmshome.sysmanage.model.AlarmTypeModel"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>实时告警页面</title>
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
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>
<link href="${ctx}/js/bootstrap3/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen" />


<link type="text/css" rel="stylesheet" href="${ctx}/js/bootstrap3/css/bootstrap-table.min.css" />
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
					<div class="panel-heading ">
						 <div class="input-group "> 查询告警记录
						 </div>
					 </div>
					<div class="panel-body">
						<form class="form-horizontal"  id ="alarmForm" name="alarmForm">
							<input type="hidden"  name="cameraId"    id="cameraId" value=""/>
							<input type="hidden"  name="screen_nums" id="screen_nums" value="4"/>
							<input type="hidden"  name="screen_now"  id="screen_now" value="1"/>
							<div class="form-group">
									<label  class="col-sm-offset-1 col-sm-3 control-label" style="font-weight:100;font-size:10px">告警类型：</label>
									<div class="col-sm-7">
										<select class="form-control "  name="alarm_type" id="alarm_type"  readonly> 
										    <option value="">全部</option>
											<c:forEach var="u" items="${alarmTypeList}" >
												<option value="${u.type}">${u.name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
							<div class="form-group">
									<label  class="col-sm-offset-1 col-sm-3 control-label" style="font-weight:100;font-size:10px">开始时间：</label>
									<div class=" col-sm-7">
										<input class="form-control form_datetime" type="text"  id="start_time"   value=""
											name="start_time" readonly />
									</div>
							</div>
							<div class="form-group">
									<label  class="col-sm-offset-1 col-sm-3 control-label" style="font-weight:100;font-size:10px">结束时间：</label>
									<div class=" col-sm-7">
										<input class="form-control form_datetime" type="text"  id="end_time"  value=""
											name="end_time" readonly />
									</div>
							</div>
							
							<div class=" col-sm-offset-3 col-sm-7">
							   <button type="button" class="btn btn-info btn-md pull-left" onclick="javascript:fun(1)">查询</button>
							   <button type="button" class="btn btn-info btn-md pull-right" onclick="javascript:fun(1)">恢复</button>
							</div>
							
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
		<div class="row">
			<div class="col-md-12 ">
			 <table id="grid-data"></table>
			</div>	    
		</div>
	</div>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap-datetimepicker.min.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/locales/bootstrap-datetimepicker.zh-CN.js"	charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/vedio/ie8/videojs-ie8.min.js"></script>
<script type="text/javascript" src="${ctx}/js/vedio/video.min.js"></script>	
<script type="text/javascript" src="${ctx}/js/bootstrap3/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap3/js/locales/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
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
			
			 $('.form_datetime').datetimepicker({
					format: 'yyyy/mm/dd hh:ii:ss',
				    language:  'zh-CN',
				    weekStart: 1,
				    todayBtn:  1,
					autoclose: 'true',
					todayHighlight: 1,
					startView: 2,
					forceParse: 0,
					 showMeridian: 1
			});
			 
			 TableInit.init();
			 
			 
		});
		function resizeWrapper() {
	    		//自适应高度
	    		var clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight
	    				: document.body.clientHeight;
	    		var iframeOffsetTop = $(document).find("body").offset().top;
	    		var blankH = clientH - iframeOffsetTop-250;
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

			$("#screen_now").val=ind;
			if(ind==4){
				$("#screenTable").empty();
				$("#screenTable").append(_4splitScreen);
				resizeWrapper();
			}
		};
				
		
		function locateScreen(obj){
			console.log("当前屏幕:"+obj.id);
			$("#screen_now").val=obj.id;
			var _videoStr="<video id=\"video_"+obj.id+"\" class=\"video-js vjs-default-skin vjs-fluid\" controls preload=\"none\">"
			+"<source src=\"http://vjs.zencdn.net/v/oceans.mp4\" type=\"video/mp4\"><p class=\"vjs-no-js\">To view this video </p></video>"
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
		
var TableInit = function () {
		    //初始化Table
		 return {    
			 init: function () {
				 myGrid= $('#grid-data').bootstrapTable({
		            url: '${ctx}/realtimealarm/getData',         //请求后台的URL（*）
		            method: 'get',                      //请求方式（*）
		          //  toolbar: '#toolbar',                //工具按钮用哪个容器
		            striped: true,                      //是否显示行间隔色
		            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		            pagination: true,                   //是否显示分页（*）
		            sortable: false,                     //是否启用排序
		            sortOrder: "asc",                   //排序方式
		            queryParams: TableInit.queryParams,           //传递参数（*）
		            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
		            pageNumber:1,                       //初始化加载第一页，默认第一页
		            pageSize: 10,                       //每页的记录行数（*）
		            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		            strictSearch: true,
		            showColumns: false,                  //是否显示所有的列
		            showRefresh: true,                  //是否显示刷新按钮
		            minimumCountColumns: 2,             //最少允许的列数
		            clickToSelect: true,                //是否启用点击选中行
		           // height: 550,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
		            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
		            cardView: false,                    //是否显示详细视图
		            detailView: false,                   //是否显示父子表
		            columns: [{  
                        //field: 'Number',//可不加  
                        title: '序号',//标题  可不加  
                        formatter: function (value, row, index) {  
                            return index+1;  
                        } ,
                        align: 'center'
		            }, {
		                field: 'id',
		                title: 'id',
		                align: 'center',
		                visible:false
		            }, {
		                field: 'alarmType',
		                title: '警告类型',
		                align: 'center',
		                formatter: function (value, row, index) {  
		                	alarmType=row.alarmType; 
		                	<c:forEach var="u" items="${alarmTypeList}" >
		                		if (alarmType == "${u.type}") {
					    			return "${u.name}";
			        		 }	
							</c:forEach>
                        } 
		            }, {
		                field: 'alarmTitle',
		                title: '警告名称',
		                align: 'center'
		            }, {
		                field: 'alarmStarttime',
		                title: '开始时间',
		                align: 'center',
		                formatter: function (value, row, index) {  
		                	return  switchTimeFormate(value);
                        } 
		            }, {
		                field: 'alarmEndtime',
		                title: '结束时间',
		                align: 'center',
		                formatter: function (value, row, index) {  
		                	return  switchTimeFormate(value);
                        } 
		            }, {
		                field: 'alarmDesc',
		                title: '警告描述',
		                align: 'center'
		            }, {
		                field: 'ip',
		                title: '操作',
		                align: 'center',
		                formatter: function (value, row, index) {  
		                	return '<div class=" btn-group btn-group-md btn-group-sm"><button  title="播放" type="button" class="btn btn-info"  name="viewVedio" data-row-id="' + value +'" aria-label="Left Align">  <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></button></div>';
                        } 
		            }],
		            onLoadSuccess:function(data){
		            	myGrid.find("button[name='viewVedio']").on("click", function(e){
		            		alert($(this).data("row-id"));
		            		
		            	});
		            }
		        })
		    },

		    //得到查询的参数
		    queryParams : function (params) {
		        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		            limit: params.limit,   //页面大小
		            offset: params.offset,  //页码
		            cameraId: $("#cameraId").val(),
		            alerm_type: $("#alarm_type").val(),
		            start_time: $("#start_time").val(),
		            end_time: $("#end_time").val()
		        };
		        return temp;
		   	  }
		    }
		}();	
		function fun(ind){
			if(1==ind){
				var opt = {
				        silent: true,
				        query:{
				        	 cameraId: $("#cameraId").val(),
				        	 alarm_type: $("#alarm_type").val(),
					         start_time: $("#start_time").val(),
					         end_time: $("#end_time").val()
				        }
				    };

				$('#grid-data').bootstrapTable('refresh',opt);
			}
		}
	</script>	
</body>
</html>