<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>平台</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="${ctx}/css/login.css"/>	
<link type="text/css" rel="stylesheet"
	href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>

<script type="text/javascript">
	//登录提交
	var getId = function(id) {
		return document.getElementById(id);
	};

	function formValidator() {
		var userName = getId("ipt-username").value;
		var password = getId("ipt-userpass").value;
		if (userName == null || userName == "") {
			alert("请您输入用户名");
			getId("ipt-username").focus();
			return false;
		}

		if (password == null || password == "") {
			alert("请您输入密码");
			getId("ipt-userpass").focus();
			return false;
		}
		//getId("login-form").target="cback";	
		getId("login-form").submit();
	}

	function guestLogin() {
		getId("ipt-username").value = "guest";
		getId("ipt-userpass").value = "123";
		getId("login-form").submit();
	}
	
</script>
<style>

.formCss{
   margin:100px auto 0 ;
   width:400px;
   background-color:#fff;
}
.frontCss{
  font-size:14px;
   color:#000;
}
</style>
</head>
<body class="login">
    <iframe name="cback" id="cback" style="display: none;"></iframe>
	<div class=" container  ">
      <div class="row"  >
      	<div class="logo">
      	  <img src="${ctx}/images/logo-big.png" alt="" /> 
        </div>
        <div class="content">
		<form class="form-horizontal  login-form"  target="_top" id="login-form" 
			method="post" name="login-form" action="${ctx}/main/login.do">
			<h3 class="form-title">请输出您的账户</h3>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">账号</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="账号" name="username"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix" type="password" placeholder="密码" name="password"/>
					</div>
				</div>
			</div>
			<div class="box-body">
			<div class="form-group">
				<label for="ipt-username" class=" col-sm-3 control-label frontCss">用户名：</label>
				<div class="col-sm-7">
					<input type="text" class="  form-control" id="ipt-username"  name="username" 
						/>
				</div>
			</div>
			<div class="form-group">
				<label for="ipt-userpass" class=" col-sm-3 control-label frontCss">密码：</label>
				<div class=" col-sm-7">
					<input type="password" class="  form-control" id="ipt-userpass" name="password"  
						 />
				</div>
			</div>
			</div>
			<div class="box-footer">
			      <div class="col-sm-5 pull-left" style="color:#f00"><div id="res" style="float: left; height: 40px" class="" role="alert"><span>${retdata} </span></div></div>
                <button type="submit" class="btn btn-info pull-right" onclick="return formValidator();">登录</button>
            </div>
		</form>
		</div>
		</div>
	</div>
<script type="text/javascript">
   jQuery(function(){
	   setTimeout(function () { closeRes()}, 2000);
   });
	function loginCallBack(retCode,retData){
		//alert(retCode);	alert(retData);
		$("#res>span").text(retData);
	    setTimeout(function () { closeRes()}, 2000);
    }
function closeRes(){
	$("#res").removeClass();
	$("#res>span").text("");
}
</script>	
</body>
</html>