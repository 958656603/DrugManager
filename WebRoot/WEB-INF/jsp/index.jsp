<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginMessage = (String)request.getAttribute("loginMessage");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		window.onload = function(){
			var msg = "<%=loginMessage %>";
			if(msg!="null"){
				alert(msg);
			}
		};
		
	</script>
	
	<style type="text/css">
		body {
			background: url("img/xingkong.jpg") no-repeat;
			background-size: 100%;
		}
		
		.login{
			position: absolute;
			left:50%;
			margin-left:-150px;
			border: 1px none;
			width: 300px;
			height: 200px;
			margin-top: 10%;
			font-family: "楷体","楷体_GB2312";
			font-size: 25px;
			color: purple;
		}
	</style>
	
  </head>
  
  <body>
	 <form action="<%=basePath %>userLogin/login.action" method="post">
    	<table class="login" align="center">
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="username"></td>
    		</tr>
    		<tr>
	    		<td>密码</td>
	    		<td><input type="password" name="password"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="登录">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
