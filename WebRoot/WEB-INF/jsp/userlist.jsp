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
			color: white;
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
			height: auto;
			min-height:533px;
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
			height: auto;
			width: 100%;
			line-height: 30px
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
		<!-- 以下是人员管理表以及操作 -->
    <div id="usertable" align="center" style="margin-top: 10px">
	    <div align="center">
		    
		    <form action="<%=basePath %>user/queryUserByCondition.action">
		    	<input type="text" name="username" placeholder="职员用户名">
		    	<select name="usertype">
		    		<option value="-1" selected="selected">请选择</option>
		    		<option value="3">管理人员</option>
		    		<option value="1">销售人员</option>
		    		<option value="2">仓库管理员</option>
		    	</select>
		    	<input type="submit" value="查询">		    	
		    </form>
		    <form action="<%=basePath %>user/preAdd.action" method="post">
		    	<input type="submit" value="增加职员" align="middle">
		    </form>
	    </div>
	    <table border="1" align="center" class="addUser">
	    	<tr>
	    		<th colspan="4">公司职员名单</th>
	    	</tr>
	    	<tr>
	    		<th>职员用户名</th>
	    		<th>职员密码</th>
	    		<th>职员类型</th>
	    		<th>操作</th>
	    	<c:forEach var="user" items="${userList }">
	    		<tr>
	    			<td>${user.username }</td>
	    			<td>${user.password }</td>
	    			<c:if test="${user.usertype == 3}">
	    				<td>管理人员</td>
	    			</c:if>
	    			<c:if test="${user.usertype == 1}">
	    				<td>销售人员</td>
	    			</c:if>
	    			<c:if test="${user.usertype == 2}">
	    				<td>仓库管理员</td>
	    			</c:if>
	    			<td>
	    				<a href="<%=basePath %>user/delUser.action?id=${user.id }">删除</a>
	    				<a href="<%=basePath %>user/preEdit.action?id=${user.id }&username=${user.username }&password=${user.password }&usertype=${user.usertype }">修改</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
	</div>
    
  </body>
</html>
