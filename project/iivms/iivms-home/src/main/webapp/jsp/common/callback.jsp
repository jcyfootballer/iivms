<%@ page contentType="text/html; charset=utf-8" language="java"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	</head>
	<%
		String retdata = (retdata = (String) request
				.getAttribute("retdata")) == null ? "" : retdata.trim();
		String callback = (callback = (String) request
				.getAttribute("callback")) == null ? "" : callback.trim();
	%>
	<body>
		<script type="text/javascript">
		<%
			if(!"".equals(callback)){
		%>
				var retdata = null;
				var code = null;
				var obj = null;
				
				<%
					if(!"".equals(retdata)){
						
				%>
						retdata = <%=retdata%>;
				 		code = retdata.retCode;
				 		obj = retdata.retData;
				<%
					}
				%>
				parent.<%=callback%>(code,obj);
		<%
			}
		%>
  	</script>
	</body>
</html>