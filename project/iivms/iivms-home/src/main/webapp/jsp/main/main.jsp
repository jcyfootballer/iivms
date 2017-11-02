<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>综合智能视频监控系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/default.css" />
<link href="${ctx}/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body class="page-header-fixed">
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="navbar-brand" href="${ctx}/main/login.do"> <img
					src="${ctx}/images/logo.png" alt="logo" />
				</a>
				<!-- END LOGO -->
				<!-- BEGIN TOP NAVIGATION MENU -->
				<ul class="nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							<span class="username"><shiro:principal /></span> <i
							class="icon-angle-down"></i> </a>
						<ul class="dropdown-menu">
							<li><a href="extra_profile.html"><i class="icon-user"></i>
									My Profile</a></li>
							<li><a href="${ctx}/main/logout.do"><i class="icon-key"></i>
									Log Out</a></li>
						</ul></li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
				<!-- END TOP NAVIGATION MENU -->
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->

	</div>

	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse ">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu">
				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
<!-- 
				<li class="start active "><a href="index.html"> <i
						class="icon-home"></i> <span class="title">Dashboard</span> <span
						class="selected"></span>

				</a></li>
 -->
				<li class=""><a href="javascript:toMenu('realtimepreview/init')"> <i class="icon-map-marker"></i><span class="title">实时预览</span> <span class="arrow "></span></a>
				</li>

				<li class=""><a href="javascript:toMenu('historyplayback/init')"> <i class="icon-th"></i> <span class="title">历史回放</span> <span class="arrow "></span></a>
				</li>
				<li class=""><a href="javascript:toMenu('realtimealarm/init')"> <i class="icon-bookmark-empty"></i> <span class="title">实时告警</span> <span class="arrow "></span></a>
				</li>
				<li class=""><a href="javascript:;"> <i class="icon-cogs"></i> <span class="title">系统管理</span> <span class="arrow "></span></a>
					<ul class="sub-menu">
						<li><a href="javascript:toMenu('用户管理')">
								<i class="icon-bookmark-empty"></i><span class="title">用户管理</span></a></li>
						<li><a href="javascript:toMenu('参数分配')"> 
								<i class="icon-bookmark-empty"></i><span class="title">参数分配</span></a></li>
						<li><a href="javascript:toMenu('cameraManage/init')"> 
								<i class="icon-bookmark-empty"></i><span class="title">摄像头管理</span></a></li>
					</ul>
				</li>
				<li class=""><a href="javascript:toMenu('操作日志')"> <i class="icon-file-text"></i> <span class="title">操作日志</span> <span class="arrow "></span></a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div id="content"  class="col-md-12 col-sm-12 " >
					</div>
				</div>
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- BEGIN FOOTER -->

	<div class="footer">
		<div class="footer-inner">
			2013 &copy; 综合视频智能监控系统 <a href="" title="综合视频智能监控系统" target="_blank">综合视频智能监控系统</a> - More <a href="" target="_blank" title=""></a>
		</div>
		<div class="footer-tools">
			<span class="go-top">
			<i class="icon-angle-up"></i>
			</span>
		</div>
	</div>
	<!-- END FOOTER -->
<script src="${ctx}/js/app.js" type="text/javascript"></script>	
<script type="text/javascript">
var logInterval=null;
  jQuery(function(){
	  App.init();
	//toMenu(1);
  });

	function toMenu(url) {
		//alert(url);
		if ('1' == url) {
			url = "main/login.do?method=init";
			$.get("${ctx}/" + url, function(data) {
				   $("#content").html(data);
			    });
		} else {
			$.get("${ctx}/" + url, function(data) {
			   $("#content").html(data);
		    });
		}
		//resizeWrapper();
	}
</script>
</body>

</html>
