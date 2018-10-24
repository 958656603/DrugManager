<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		a{
			text-decoration: none;
		}
	
		*{
			padding: 0px;
			margin: 0px;
		}
	
		.header{
					position: fixed;
					height: 60px;
					width: 100%;
					padding: 15px 0px;
					background: #30394D;
					z-index: 10;
					border-bottom: 3px solid #242B3A;
				}
		
		.logo{
				position: relative;
				left: 140px;
				height: 62px;
				width: 64.59px;
				background: url("img/110708.gif") no-repeat;
				background-size: cover;
			}
			
		li{
			display: inline-block;	
		}
		
		.headerlist li a{
			color: white;
		}
		
		.headerlist li{
			position: relative;
			font-weight: bold;
			font-size: 20px;
			padding-left: 100px;
			
		}
		
		.headerlist{
			position: absolute;
			left: 300px;
			top: 30px;
			color: white;
		}
		
		.photodiv{
			height: 533px;
			width: 100%;
			/*border: 1px solid;*/
			position: absolute;
			top: 93px;
			background-color: #30394D;;
		}
		
		.photodiscribe{
			position: absolute;
			left: 122.5px;
			top: 200px;
			font-weight: bold;
			color: white;
			font-size: 50px;
		}
		
		.cookie{
			font-weight: bold;
			font-size: 20px;
			position: absolute;
			right: 0px;
			bottom: 0px;
			color: white;
		}
		
		.exit{
			font-size:5px;
			cursor: pointer;
		}
		.addUser{
			color: white;
			height: 100%;
			width: 100%;
			font-size: 
		}
	</style>
  </head>
  
  <body>
    <div class="header">
    	<div class="logo"></div>
    	<c:if test="${cookie.usertypeCookie.value == 3}">
			<ul class="headerlist">
				<li><a href="<%=basePath %>user/login.action">人员管理</a></li>
				<li><a href="<%=basePath %>warehouse/login.action">库存管理</a></li>
				<li><a href="<%=basePath %>stock/login.action">进药管理</a></li>
				<li><a href="<%=basePath %>sale/login.action">售药管理</a></li>
			</ul>
		</c:if>
		<c:if test="${cookie.usertypeCookie.value == 2}">
			<ul class="headerlist">
				<li><a href="<%=basePath %>warehouse/login.action">库存管理</a></li>
				<li><a href="<%=basePath %>stock/login.action">进药管理</a></li>
			</ul>
		</c:if>	
		<c:if test="${cookie.usertypeCookie.value == 1}">
			<ul class="headerlist">
				<li><a href="<%=basePath %>warehouse/login.action">库存管理</a></li>
				<li><a href="<%=basePath %>sale/login.action">售药管理</a></li>
			</ul>
		</c:if>
		<div class="cookie">
			欢迎光临！${cookie.username.value}  <span class ="exit"><a href="<%=basePath %>user/exit.action">退出</a></span>
		</div>
    </div>
    <div class="photodiv" id="photodiv">
		 <!-- 以下是人员修改界面 -->
    <form action="<%=basePath %>user/edit.action">
    	<table border="1" align="center" class="addUser">
    		
    		<tr>
    			<td>职员用户名</td>
    			<td align="center">${user.username }</td>
    			<input type="hidden" value="${user.username }" name="username">
    			<input type="hidden" value="${user.id }" name="id">
    		</tr>
    		<tr>
    			<td>职员密码</td>
    			<td><input type="text" name="password" value="${user.password }"></td>
    		</tr>
    		<tr>
    			<td>职员类型</td>
    			
				<c:if test="${user.usertype == 3}">
   					<td>
						<input type="radio" value="3" name="usertype" checked="checked">管理员
		    			<input type="radio" value="1" name="usertype">销售人员
		    			<input type="radio" value="2" name="usertype">仓库管理员
					</td>
   				</c:if>
    			<c:if test="${user.usertype == 1}">
    				<td>
						<input type="radio" value="3" name="usertype">管理员
		    			<input type="radio" value="1" name="usertype" checked="checked">销售人员
		    			<input type="radio" value="2" name="usertype">仓库管理员
					</td>
    			</c:if>
    			<c:if test="${user.usertype == 2}">
    				<td>
						<input type="radio" value="3" name="usertype">管理员
		    			<input type="radio" value="1" name="usertype">销售人员
		    			<input type="radio" value="2" name="usertype"  checked="checked">仓库管理员
					</td>
    			</c:if>
	    		
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交修改"></td>
    		</tr>
    	</table>
    </form>
		
	</div>
  	
  </body>
   
  </body>
</html>
