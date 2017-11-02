<%@ include file="/jsp/common/init.jsp"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>平台</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link type="text/css" rel="stylesheet" href="${ctx}/js/bootstrap3/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/css/login.css"/>

<script type="text/javascript" src="${ctx}/js/jquery/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap3/js/bootstrap.min.js"></script>

</head>
<body class="login">
    <iframe name="cback" id="cback" style="display: none;"></iframe>
	<div class="container">
      <div class="row"  >
      	<div class="logo">
      	  <img src="${ctx}/images/logo.png" alt="" /> 
        </div>
        <div class="content">
		<form class="form-horizontal login-form required-validate" data-toggle="validator"  id="login-form" role="form"
			method="post" name="login-form" action="${ctx}/main/login">
			<h4 class="form-title">请输入账户</h4>
			 
			<div class="form-group">
				<div class="controls">
					<div class="input-group">
						<span class="input-group-addon " id="sizing-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> </span>
						<input class="form-control" aria-describedby="sizing-addon1" type="text" placeholder="账号" name="username"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="controls">
					<div class="input-group">
						<span class="input-group-addon " id="sizing-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
						<input class="form-control" aria-describedby="sizing-addon2" type="password" placeholder="密码" name="password"/>
					</div>
				</div>
			</div> 
			<div class="alert alert-warning hide">
				<span id="alertResult"></span>
			</div>
			<div class="form-actions">
					<label >
					<input type="checkbox" name="remember" value="1"/> Remember me
					</label>
					<button type="submit" class="btn btn-info pull-right">登录 </span> 
					</button>
			</div>		
		</form>
		</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/js/bootstrap3/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/login.js" ></script>      
	<script>
		jQuery(document).ready(function() { 
		  Login.init();
		});
		function callback(){
			 window.location.href = "${ctx}/main/init"; 
		}
	</script>
</body>
</html>