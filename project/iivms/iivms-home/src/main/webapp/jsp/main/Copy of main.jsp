<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>风行云</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/menu.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/base.css" />	
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common_js.js"></script>
<script type="text/javascript" src="${ctx}/js/menu.js"></script>	
<script type="text/javascript">
var logInterval=null;
  jQuery(function(){
	toMainMenu();
	toMenu(1);
  });
	
	
//构造二级菜单
  function toMainMenu(){
	  $("#engine_nav_ul").empty();
	  ss = "<li id=\"shouye\"><a class=\"current\" href=\"javascript:toMenu('1')\" target=\"_self\"><h4>首页</h4></a></li>";
	  $("#engine_nav_ul").append(ss);
	  addEvent('shouye');
  	$.getJSON("${ctx}/auth/authManage.do?method=getMainMenus" , function(data) {
  		for(var t in  data){
  			if(data[t].isshow){
  			ss = "<li id=\""+data[t].id+"\"><a href=\"javascript:toSecMenu('"+data[t].id+"','"+data[t].url+"')\" target=\"_self\"><h4>"+data[t].name+"</h4></a></li>";
  			$("#engine_nav_ul").append(ss);
  			 addEvent(data[t].id);
  			}
  		}
  	 });
  	
  }

function toSecMenu(id,url){
	if(url != null &&url != ''){
		toMenu(url);
	}
	
	$("#side-menu").empty();
	$.getJSON("${ctx}/auth/authManage.do?method=getSecMenus&menuId="+id , function(data) {
		if(data==null || data=='null' || data.length<1){
			if(url != null &&url != ''){
			}else{
				toMenu('1');
			}
		}else{
  		for(var t in  data){
  			if(data[t].isshow){
  			if(data[t].haschildren){
  	  			//ss = "<li  id=\""+data[t].id+"\"><a  href=\"#"+data[t].appmenid+"\" data-parent=\"#side-menu\"  data-toggle=\"collapse\" target=\"_self\" aria-expanded=\"false\" aria-controls=\""+data[t].appmenid+"\"><i class=\""+data[t].image+"\"></i>"+data[t].name+"<span class=\"pull-right glyphicon glyphicon-chevron-down\"></span></a><ul id=\""+data[t].appmenid+"\" class=\"nav nav-second-level collapse \"></ul></li>";
  	  			ss="<div class=\"panel panel-info\"><div class=\"panel-heading\"> <h5 class=\"panel-title\"><a data-toggle=\"collapse\" data-parent=\"#side-menu\" href=\"#collapse"+data[t].id+"\" target=\"_self\"><i class=\""+data[t].image+"\"></i>"+data[t].name+"<span class=\"pull-right caret\"></span></a></h5></div>"
  	  			+"<div id=\"collapse"+data[t].id+"\" class=\"panel-collapse collapse \"><div class=\"panel-body\">"
  	            +" <div class=\"list-group\" id=\""+data[t].appmenid+"\"></div></div>";
  	  			+"</div>";
  	  			$("#side-menu").append(ss);
  	  		    //addEvent2(data[t].id);
  				for(var tt in  data[t].children){
  					if(data[t].children[tt].isshow){
  					ss = "<a class=\"list-group-item\" id=\""+data[t].children[tt].id+"\" href=\"javascript:toMenu('"+data[t].children[tt].url+"')\" target=\"_self\">"+data[t].children[tt].name+"</a>";
  		  			$("#"+data[t].appmenid).append(ss);
  		  		    //addEvent2(data[t].children[tt].id);
  					}
  				}
  			}else{
  	  		//	ss = "<li  id=\""+data[t].id+"\"><a href=\"javascript:toMenu('"+data[t].url+"')\" target=\"_self\">"+data[t].name+"</a></li>";
  	  		    ss="<div class=\"panel panel-info\"><div class=\"panel-heading\"> <h5 class=\"panel-title\"><a  data-parent=\"#side-menu\" href=\"javascript:toMenu('"+data[t].url+"')\" target=\"_self\"><i class=\""+data[t].image+"\"></i>"+data[t].name+"</a></h5></div></div>";
  	  			$("#side-menu").append(ss);
  	  		   // addEvent2(data[t].id);
  			}
  			}
  		}
  		//$("#side-menu").metisMenu();
		}
  	 });

}

	function toMenu(url) {
		if ('1' == url) {
			url = "main/login.do?method=init";
			$.get("${ctx}/" + url, function(data) {
				   $("#content").html(data);
				   hiddenMenu();
				   clearInterval(logInterval) ;
			    });
		} else {
			$.get("${ctx}/" + url, function(data) {
			   $("#content").html(data);
			   hiddenMenu();
			   clearInterval(logInterval) ;
		    });
		}
		//resizeWrapper();
	}
</script>
<style>
#content{
  padding-left:30px;
  padding-right:20px;
  overflow: auto;
  margin-top:6px;
}
</style>
</head>
<body>
	<div class="header">
	 <nav class="navbar  navbar-static-top">
		<div class="container-fluid">
			<div class="logo navbar-header"></div>
			<div id="engine_nav" class=" collapse navbar-collapse">
				<ul id="engine_nav_ul" class=" engine_nav navbar-nav ">
				</ul>
				 <ul class="nav navbar-nav navbar-right">
				     <li><h5>	<span class="login-txt  " style="margin-right: 20px"> <shiro:notAuthenticated>
						<span id="login-btn" class="login-button">登录</span>
					</shiro:notAuthenticated> <shiro:authenticated>
						<span class="colorA" style="margin-right: 10px">Hi,欢迎<shiro:principal/>来到风行云 </span> | 
						<a class="colorA" href="${ctx}/main/logout.do" target="_self">退出</a>
					</shiro:authenticated>
				</span></h5></li>
				 </ul>
			</div>
		  </div>
		</nav>
	</div>
	<div  id="contentframe" class="container-fluid" style="background-color: #F8F8F8; ">
		<div class="row">
			<div id="content"  class="col-md-12 col-sm-12 " >
			</div>
			<div id="cover"></div>
		    <div id="panel_arrow"><img id="panel_img" class="expand_right" src="${ctx}/images/transparent.gif"/>导</br>航</div>
		    <div id="area-func" class="area-func">
					<div id="func-wrap" class="func-wrap">
								<div id="func-div" class="func-div">
									<div id="func-ul" class="func-ul">
									    <div class="navbar-default " role="navigation">
										<!--	<div class="sidebar-nav  " >
												 <ul class="nav" id="side-menu"  >
												</ul> -->
												<div class="panel-group" id="side-menu">
												</div>
											<!-- </div> -->
										</div>
									</div>
								</div>
							</div>
			 </div>
		</div>
	</div><!-- 
	<div class="footer"> 
	      <h2>大数据-研发</h2>
	</div>  -->
</body>
</html>
