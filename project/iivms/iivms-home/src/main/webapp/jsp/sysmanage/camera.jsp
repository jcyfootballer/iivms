<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>摄像头管理页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/css/base.css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet" href="${ctx}/js/zTree/css/zTreeStyle.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/js/zTree/css/icon.css" />
<script type="text/javascript" src="${ctx}/js/zTree/js/jquery.ztree.all-3.5.js"></script>	

</head>
<body>
	<div class="container-fluid">
		<!-- BEGIN PAGE HEADER-->
		<div class="row">
			<div class="col-md-4 col-lg-3 col-sm-5">
					<div class="panel panel-success">
						<div class="panel-heading ">摄像头信息：</div>
						<div class="panel-body" >
						    <div class="treepanel"><ul id="Tree" class="ztree"></ul></div>
						 </div>
					</div>
				</div>
				<div class="col-md-8 col-lg-9 col-sm-7">
					<ul class="nav nav-tabs" id="myTab">
					  <li role="presentation" class="active" ><a href="#cameraLocationPanel" >位置信息</a></li>
					  <li role="presentation"><a href="#cameraPanel" >摄像头信息</a></li>
					</ul>
					<div class="tab-content">
				    <div class="tab-pane active" id="cameraLocationPanel">
					    <div class="panel-body">
						    <form class="form-horizontal required-validate" data-toggle="validator"  id ="cameraLocationForm" name="cameraLocationForm" role="form" method="post" >
						        <input type="hidden"  name="cameraLoactionId" value=""/>
						        <input type="hidden"  name="cameraLoactionPid" value="1"/>
						        <input type="hidden"  name="cameraLoactiontId" value=""/>
						        
						        <input type="hidden"  name="type" value="add"/>
								<div class="form-group">
									<label  class="col-sm-3 control-label" for="name">名称：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="name" required></input>
									</div>
								</div>
							<div class="btn-group btn-group-md btn-group-sm pull-right" >
							    
							  	<button type="button" class="btn btn-info" id="addCameraLoaction"    onclick="javascript:fun(this)" ><span class="glyphicon glyphicon-cog"></span>新建位置</button>
							  	<button type="button" class="btn btn-success" id="addCamera"    onclick="javascript:fun(this)" ><span class="glyphicon glyphicon-cog"></span>新建摄像头</button>
							  	<button type="submit" class="btn btn-info" data-container="#content" data-toggle="popover" data-placement="bottom" data-content="" 
									id="renewCameraLoaction"  ><span class="glyphicon glyphicon-edit"></span>保存</button>
							  	<button type="button" class="btn btn-success" data-container="#content" data-toggle="popover" data-placement="bottom" data-content="" 
							  	  id="removeCameraLoaction" onclick="javascript:fun(this)" ><span class="glyphicon glyphicon-trash"></span>删除</button>
					  		</div>
					  		</form>
						</div>
					</div>
					<div class="tab-pane " id="cameraPanel">
						 <div class="panel-body">
						    <form class="form-horizontal required-validate" data-toggle="validator" id ="cameraForm" name="cameraForm" role="form" method="post">
						        <input type="hidden"  name="cameraId" value=""/>
						        <input type="hidden"  name="cameraPid" value="1"/>
						        <input type="hidden"  name="cameratId" value=""/>
						        <input type="hidden"  name="type" value="add"/>
								<div class="form-group">
									<label  class="col-sm-3 control-label">IP：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="ip"></input>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-3 control-label">端口：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="port" value="8888"></input>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="username"></input>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="password"></input>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-3 control-label">名称：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="name"></input>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-3 control-label">限制浏览次数：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " name="limitscannum" value="100"></input>
									</div>
								</div>
							
								<div class="btn-group btn-group-md btn-group-sm pull-right" >
								  	<button type="submit" class="btn btn-success" data-container="#content" data-toggle="popover" data-placement="bottom" data-content=""  
								  	id="renewCamera"  ><span class="glyphicon glyphicon-edit"></span>保存</button>
								  	<button type="button" class="btn btn-info"  data-container="#content" data-toggle="popover" data-placement="bottom" data-content=""  
								  	id="removeCamera"   onclick="javascript:fun(this)" ><span class="glyphicon glyphicon-trash"></span>删除</button>
						  		</div>
					  		</form>
						</div>
					</div>
					</div>
				</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/js/bootstrap3/js/bootstrap-tab.js" ></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap3/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap3/js/tooltip.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap3/js/popover.js"></script>
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
		  
		  $('#myTab a').click(function (e) {
			  e.preventDefault();
			  $(this).tab('show');
		  })
		});
		function resizeWrapper() {
	    		//自适应高度
	    		var clientH = (document.compatMode && document.compatMode.toLowerCase() == "css1compat") ? document.documentElement.clientHeight
	    				: document.body.clientHeight;
	    		var iframeOffsetTop = $(document).find("body").offset().top;
	    		var blankH = clientH - iframeOffsetTop;
	    		$(".treepanel").css("height", blankH);
	    }
		function zTreeOnClick(event, treeId, treeNode){
			    //alert(treeId+","+treeNode.tId + ", " + treeNode.id+","+treeNode.pId + ", " + treeNode.type);
			    if(1 ==  treeNode.type){
			    	$('#myTab a:first').tab('show');
			    	$("#cameraLocationForm").data('bootstrapValidator').resetForm(true);
			    	var cameraLocationForm = document.cameraLocationForm;
			    	cameraLocationForm.name.value=treeNode.name;
			    	cameraLocationForm.cameraLoactionId.value=treeNode.id;
			    	cameraLocationForm.cameraLoactionPid.value=treeNode.pId;
			    	cameraLocationForm.cameraLoactiontId.value=treeNode.tId;
			    	cameraLocationForm.type.value="renew";
			    	$("#cameraLocationForm").attr("action","${ctx}/cameraManage/renewCameraLoactionInfo");
			    } else if(2 ==  treeNode.type){
			    	$('#myTab a:last').tab('show');
			    	$("#cameraForm").data('bootstrapValidator').resetForm(true);
			    	var cameraForm = document.cameraForm;
			    	cameraForm.name.value=treeNode.name;
			    	cameraForm.cameraId.value=treeNode.id;
			    	cameraForm.cameraPid.value=treeNode.pId;
			    	cameraForm.ip.value=treeNode.ip;
			    	cameraForm.port.value=treeNode.port;
			    	cameraForm.username.value=treeNode.username;
			    	cameraForm.password.value=treeNode.password;
			    	cameraForm.name.value=treeNode.name;
			    	cameraForm.limitscannum.value=treeNode.limitScanNums;
			    	cameraForm.cameratId.value=treeNode.tId;
			    	cameraForm.type.value="renew";
			    }
		}
		
		function fun(obj){
				 if('addCameraLoaction' == obj.id){
					 $("#cameraLocationForm").data('bootstrapValidator').resetForm(true);
					 var cameraLocationForm = document.cameraLocationForm;
					 cameraLocationForm.name.value="";
					 cameraLocationForm.cameraLoactionPid.value=cameraLocationForm.cameraLoactionId.value
				     cameraLocationForm.cameraLoactionId.value="";
				     cameraLocationForm.type.value="add";
				    
				 } else if('addCamera' == obj.id){
					 $("#cameraForm").data('bootstrapValidator').resetForm(true);
					 $('#myTab a:last').tab('show');
					 var cameraForm = document.cameraForm;
				    	cameraForm.name.value="";
				    	cameraForm.cameraId.value="";
				    	cameraForm.ip.value="";
				    	cameraForm.port.value=8888;
				    	cameraForm.username.value="";
				    	cameraForm.password.value="";
				    	cameraForm.name.value="";
				    	cameraForm.limitscannum.value=100;
				    	cameraForm.type.value="add";
					 cameraForm.cameraPid.value=document.cameraLocationForm.cameraLoactionId.value
				 }else if('removeCameraLoaction' == obj.id){
					 var cameraLocationForm = document.cameraLocationForm;
					 var cameraLoactionId = cameraLocationForm.cameraLoactionId.value
					 if(cameraLoactionId<1){
						 $('#removeCameraLoaction').attr("data-content","请选中要删除的节点");
						 $('#removeCameraLoaction').popover('show');
		        		 setTimeout(function () { $('#removeCameraLoaction').popover('hide');}, 2000);
		        		 return ;
					 }
					 if(cameraLoactionId==1){
						 $('#removeCameraLoaction').attr("data-content","根节点不能删除");
		        		 $('#removeCameraLoaction').popover('show');
		        		 setTimeout(function () { $('#removeCameraLoaction').popover('hide');}, 2000);
		        		 return;
					 }
					 cameraLocationForm.type.value="del";
					 $.post("${ctx}/cameraManage/removeCameraLoactionInfo",{"cameraLoactionId":cameraLoactionId},function(result) {
						 if(200==result.status){
							 var nodes = treeObj.getSelectedNodes();
							 if(nodes.length>0){
								 treeObj.reAsyncChildNodes(nodes[0].getParentNode(), "refresh");
							 }
			        	 }
			        	 $('#removeCameraLoaction').attr("data-content",result.msg);
		        		 $('#removeCameraLoaction').popover('show');
		        		 setTimeout(function () { $('#removeCameraLoaction').popover('hide');}, 2000);
		        		 $("#cameraLocationForm").data('bootstrapValidator').resetForm(true);
					}, "json");
				 }else if('removeCamera' == obj.id){
					 var cameraForm = document.cameraForm;
					 var cameraId = cameraForm.cameraId.value;
					 if(cameraId<1){
						 $('#removeCamera').attr("data-content","请选中要删除的节点");
						 $('#removeCamera').popover('show');
		        		 setTimeout(function () { $('#removeCamera').popover('hide');}, 2000);
		        		 return ;
					 }
					 cameraForm.type.value="del";
					 $.post("${ctx}/cameraManage/removeCamera",{"cameraId":cameraId},function(result) {
						 if(200==result.status){
							 var nodes = treeObj.getSelectedNodes();
							 if(nodes.length>0){
								 treeObj.reAsyncChildNodes(nodes[0].getParentNode(), "refresh");
							 }
			        	 }
			        	 $('#removeCamera').attr("data-content",result.msg);
		        		 $('#removeCamera').popover('show');
		        		 setTimeout(function () { $('#removeCamera').popover('hide');}, 2000);
		        		 $("#cameraForm").data('bootstrapValidator').resetForm(true);
					}, "json");
				 }
				
		}
		$('#cameraLocationForm').bootstrapValidator({
	         message: 'This value is not valid',
	         feedbackIcons: {/*input状态样式图片*/
	             valid: 'glyphicon glyphicon-ok',
	             invalid: 'glyphicon glyphicon-remove',
	             validating: 'glyphicon glyphicon-refresh'
	         },
	         fields: {/*验证：规则*/
	        	 name: {//验证input项：验证规则
	                 message: 'The name is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '名称不能为空'
	                     },
	                     stringLength: {
	                         min: 1,
	                         max: 50,
	                         message: '名称长度必须在1到50之间'
	                     }
	                 }
	             }
	         }
	     })
	     .on('success.form.bv', function(e) {//点击提交之后
	         // Prevent form submission
	         e.preventDefault();
	         // Get the form instance
	         var $form = $(e.target);
	         // Get the BootstrapValidator instance
	         var bv = $form.data('bootstrapValidator');
	        // alert($form.name.value);
	         // Use Ajax to submit form data 提交至form标签中的action，result自定义
	         //alert($form.serialize());
	         var type = document.cameraLocationForm.type.value;
	         var cameraLoactionPid = document.cameraLocationForm.cameraLoactionPid.value;
	         var cameraLoactionId = document.cameraLocationForm.cameraLoactionId.value;
		     if("add"==type){
		    	 if(cameraLoactionPid<1){
		    		 $('#renewCameraLoaction').attr("data-content","请选择父节点");
	        		 $('#renewCameraLoaction').popover('show');
	        		 setTimeout(function () { $('#renewCameraLoaction').popover('hide');}, 2000);
	        		 return ;
		    	 }
		    	 $("#cameraLocationForm").attr("action","${ctx}/cameraManage/addCameraLoactionInfo");
		         $.post($form.attr('action'), $form.serialize(), function(result) {
		        	 //alert(result.success)
		        	 if(200==result.status){
		        		 var node = treeObj.getNodeByTId(cameraLocationForm.cameraLoactiontId.value);
		        			if(false== node.open){
		        				treeObj.expandNode(node,true);
		        			}
		        			treeObj.reAsyncChildNodes(node, "refresh");
		        		 	
		        		 document.cameraLocationForm.type.value="renew";
		        	 }
		        	 $('#renewCameraLoaction').attr("data-content",result.msg);
	        		 $('#renewCameraLoaction').popover('show');
	        		 setTimeout(function () { $('#renewCameraLoaction').popover('hide');}, 2000);
		        	 //alert(result.msg);
				},"json");
		     }else if("renew"==type){
		    	 if(cameraLoactionPid<1 || cameraLoactionId<1){
		    		 $('#renewCameraLoaction').attr("data-content","请选择准备更新的节点");
	        		 $('#renewCameraLoaction').popover('show');
	        		 setTimeout(function () { $('#renewCameraLoaction').popover('hide');}, 2000);
	        		 return ;
		    	 }
		    	 $("#cameraLocationForm").attr("action","${ctx}/cameraManage/renewCameraLoactionInfo");
		         $.post($form.attr('action'), $form.serialize(), function(result) {
		        	 if(200==result.status){
		        		 //var nodes = treeObj.getSelectedNodes();
		        		 var node = treeObj.getNodeByTId(cameraLocationForm.cameraLoactiontId.value);
		        		 treeObj.reAsyncChildNodes(node.getParentNode(), "refresh");
		        	 }
		        	 $('#renewCameraLoaction').attr("data-content",result.msg);
	        		 $('#renewCameraLoaction').popover('show');
	        		 setTimeout(function () { $('#renewCameraLoaction').popover('hide');}, 2000);
				},"json");
		     }
	         
	     });
		
		$('#cameraForm').bootstrapValidator({
	         message: 'This value is not valid',
	         feedbackIcons: {/*input状态样式图片*/
	             valid: 'glyphicon glyphicon-ok',
	             invalid: 'glyphicon glyphicon-remove',
	             validating: 'glyphicon glyphicon-refresh'
	         },
	         fields: {/*验证：规则*/
	        	 ip: {//验证input项：验证规则
	                 message: 'The ip is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: 'IP不能为空'
	                     },
	                     ip: {
	                         message: 'IP格式不合法'
	                     },
	                     remote: {
	                    	 url: '${ctx}/cameraManage/isValidByIP',
	                    	 message: '该ip 已经使用',
	                    	 dataType: 'json',
	                    	 delay : 1000,
	                    	// /自定义提交数据，默认值提交当前input value
	                    	data: function (validator) {
	                    	  return {
	                    		  id: document.cameraForm.cameraId.value,
	                    		  ip: document.cameraForm.ip.value
	                          };
	                    	}
	                    },
	                 }
	             },
	             port: {//验证input项：验证规则
	                 message: 'The port is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '端口不能为空'
	                     },
	                     numeric: {
	                         message: '端口号不合法'
	                     }
	                 }
	             },
	             username: {//验证input项：验证规则
	                 message: 'The 用户名 is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '用户名不能为空'
	                     },
	                     regexp: {//匹配规则
	                    	 regexp: /^[a-zA-Z0-9]+$/,
	                    	 message: '密码需符合字母、数字'
	                     }
	                     
	                 }
	             },
	             password: {//验证input项：验证规则
	                 message: 'The password is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '密码不能为空'
	                     },
	                     regexp: {//匹配规则
	                    	 regexp: /^[a-zA-Z0-9]+$/,
	                    	 message: '密码需符合字母、数字'
	                     }
	                 }
	             },
	        	 name: {//验证input项：验证规则
	                 message: 'The name is not valid',
	                 validators: {
	                     notEmpty: {//非空验证：提示消息
	                         message: '名称不能为空'
	                     },
	                     stringLength: {
	                         min: 1,
	                         max: 50,
	                         message: '名称长度必须在1到50之间'
	                     }
	                 }
	             },
	             limitscannum: {//验证input项：验证规则
	                 message: 'The limitscannum is not valid',
	                 validators: {
	                	 numeric: {
	                         message: '次数不合法'
	                     }
	                 }
	             }
	             
	         }
	     })
	     .on('success.form.bv', function(e) {//点击提交之后
	         // Prevent form submission
	         e.preventDefault();
	         // Get the form instance
	         var $form = $(e.target);
	         // Get the BootstrapValidator instance
	         var bv = $form.data('bootstrapValidator');
	        // alert($form.name.value);
	         // Use Ajax to submit form data 提交至form标签中的action，result自定义
	        // alert($form.serialize());
	         var type = document.cameraForm.type.value;
	         var cameraPid = document.cameraForm.cameraPid.value;
	         var cameraId = document.cameraForm.cameraId.value;
		     if("add"==type){
		    	 if(cameraPid<1){
		    		 $('#renewCamera').attr("data-content","请选择父节点");
	        		 $('#renewCamera').popover('show');
	        		 setTimeout(function () { $('#renewCamera').popover('hide');}, 2000);
	        		 return ;
		    	 }
		    	 $("#cameraForm").attr("action","${ctx}/cameraManage/addCamera");
		         $.post($form.attr('action'), $form.serialize(), function(result) {
		        	 //alert(result.success)
		        	 if(200==result.status){
		        		 if(200==result.status){
			        		 var node = treeObj.getNodeByTId(document.cameraLocationForm.cameraLoactiontId.value);
			        			if(false== node.open){
			        				treeObj.expandNode(node,true);
			        			}
			        			treeObj.reAsyncChildNodes(node, "refresh");
			        		 	
			        		 document.cameraLocationForm.type.value="renew";
			        	 }
		        		 document.cameraForm.type.value="renew";
		        	 }
		        	 $('#renewCamera').attr("data-content",result.msg);
	        		 $('#renewCamera').popover('show');
	        		 setTimeout(function () { $('#renewCamera').popover('hide');}, 2000);
		        	 //alert(result.msg);
				},"json");
		     }else if("renew"==type){
		    	 if(cameraPid<1 || cameraId<1){
		    		 $('#renewCamera').attr("data-content","请选择准备更新的节点");
	        		 $('#renewCamera').popover('show');
	        		 setTimeout(function () { $('#renewCamera').popover('hide');}, 2000);
	        		 return ;
		    	 }
		    	 $("#cameraForm").attr("action","${ctx}/cameraManage/renewCamera");
		         $.post($form.attr('action'), $form.serialize(), function(result) {
		        	 if(200==result.status){
		        		 var node = treeObj.getNodeByTId(document.cameraForm.cameratId.value);
		        		 treeObj.reAsyncChildNodes(node.getParentNode(), "refresh");
		        	 }
		        	 $('#renewCamera').attr("data-content",result.msg);
	        		 $('#renewCamera').popover('show');
	        		 setTimeout(function () { $('#renewCamera').popover('hide');}, 2000);
				},"json");
		     }
	         
	     });
	</script>	
	
</body>

</html>