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
	 <!-- 以下是售药列表以及操作 -->
    <!-- 
    	售药表（顾客号，药品编码，销售量，销售日期，单价）
     -->
    <div id="saledrugtable" align="center">
    	<form action="<%=basePath %>sale/find.action">
	    	<input type="text" name="drug_id" placeholder="药品编号">
	    	<input type="text" name="date" placeholder="日期">
	    	<input type="submit" value="查询">		    	
	    </form>
    	<form action="<%=basePath %>sale/preAdd.action" method="post">
		    	<input type="submit" value="售药" align="middle">
		</form>
    	<table border="1" align="center" class="addUser">
	    	<tr>
	    		<th colspan="7">药品销售清单</th>
	    	</tr>
	    	<tr>
	    		<th>顾客号</th>
	    		<th>药品编码</th>
	    		<th>销售量</th>
	    		<th>销售日期</th>
	    		<th>零售价</th>
	    		<th>操作</th>
	    	<c:forEach var="saleDrug" items="${saleDrugList }">
	    		<tr>
	    			<td>${saleDrug.customer_id }</td>
	    			<td>${saleDrug.drug_id }</td>
	    			<td>${saleDrug.sale_number }</td>
	    			<td>${saleDrug.date }</td>
	    			<td>${saleDrug.price }</td>
	    			
	    			
	    			<td>
	    				<a href="<%=basePath %>sale/preEdit.action?customer_id=${saleDrug.customer_id}&id=${saleDrug.id }&drug_id=${saleDrug.drug_id }&sale_number=${saleDrug.sale_number}&date=${saleDrug.date}&price=${saleDrug.price}">修改</a>
	    				<a href="<%=basePath %>sale/del.action?drug_id=${saleDrug.drug_id}&sale_number=${saleDrug.sale_number}&id=${saleDrug.id}">删除</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
    
    </div>
	
  </body>
</html>