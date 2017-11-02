<%@ include file="/jsp/common/init.jsp"%> 
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="${ctx}/css/menu.css" />

<script type="text/javascript" src="${ctx}/js/jquery/jquery-2.1.3.js"></script>    
<script type="text/javascript" src="${ctx}/js/common_js.js"></script>
<script type="text/javascript">
function toMenu(url) {
	parent.window.location.href= "${ctx}/" + url;
//	$.get(ctx + "///" + url, function(data) {
		//$("#content").html(data);
		//parent.window.location.href=data;
		//setTimeout("javascript:location.href='hello.html'", 5000); 
	//});
}
</script>
</head>
<body>
	<div class="header">
		<div class="header-bd">
			<h1 class="logo"></h1>
			<div class="login-info">
				<span class="login-txt" style="color: #666666"> <shiro:notAuthenticated>
						<span id="login-btn" class="login-button">登录</span>
					</shiro:notAuthenticated> <shiro:authenticated>
						<span style="margin-right: 10px">Hi,欢迎来到风行云 </span> | 
						<a class="colorA" href="${ctx}/main/logout.do" target="_self">退出</a>
					</shiro:authenticated> <input type="hidden" id="currentLinkId" value="" />
				</span>
			</div>
			<div id="engine_nav" class="engine_nav">
				<ul>
					<li><a class="current"
						href="javascript:toMenu('main/login.do')" target="_self">首页</a></li>
					<li><a
						href="javascript:toMenu('workBrowse.do?method=init&flag=Week')"
						target="_self">日志备案</a></li>
					<li><a
						href="javascript:toMenu('workBrowse.do?method=init&flag=Year')"
						target="_self">调度系统</a></li>
				   <li><a
						href="javascript:toMenu('workBrowse.do?method=init&flag=Year')"
						target="_self">查询分析</a></li>
					<li><a href="javascript:toMenu('authManage.do?method=init')"
						target="_self">权限配置</a></li>
				</ul>	
			</div>
		</div>
	</div>
</body>
</html>