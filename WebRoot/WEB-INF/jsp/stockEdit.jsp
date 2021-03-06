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
		 <form action="<%=basePath %>stock/edit.action" method="post">
    <input type="hidden" name="buyNum" value="${stockDrug.buy_num }">
    <input type="hidden" name="drugid" value="${stockDrug.drug_id }">
    <input type="hidden" name="id" value="${stockDrug.id }">
    	<table align="center" border="1" class="addUser">
    		<tr>
    			<td>单据号</td>
    			<td><input type="text" name="bill_id" value="${stockDrug.bill_id }"></td>
    		</tr>
    		<tr>
    			<td>药品编码</td>
    			<td><input type="text" name="drug_id" value="${stockDrug.drug_id }"></td>
    		</tr>
    		<tr>
    			<td>采购价</td>
    			<td><input type="text" name="price" value="${stockDrug.price }"></td>
    		</tr>
    		<tr>
    			<td>采购数量</td>
    			<td><input type="text" name="buy_num" value="${stockDrug.buy_num }"></td>
    			
    		</tr>
    		<tr>
    			<td>采购日期</td>
    			<td><input type="text" name="date" value="${stockDrug.date }"></td>
    		</tr>
    		<tr>
    			<td>供应商</td>
    			<td><input type="text" name="supplier" value="${stockDrug.supplier }"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交修改">
    			</td>
    		</tr>
    	</table>
    </form>
		
	</div>
    
  </body>
</html>
