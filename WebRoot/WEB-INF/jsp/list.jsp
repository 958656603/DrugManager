<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Cookie[] carr = request.getCookies();
String username = null;
String usertype = null;
if(carr!=null){
	for(Cookie c:carr){
		if("usernameCookie".equals(c.getName())){
			username = c.getValue();
		}
		if("usertypeCookie".equals(c.getName())){
			usertype = c.getValue();
		}
	}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
  </head>
  
  <body>
    <!-- 以下是人员管理表以及操作 -->
    <div id="usertable" align="center" style="background-color: yellow;">
	    <div align="center">
		    <form action="<%=basePath %>user/preAdd.action" method="post">
		    	<input type="submit" value="增加职员" align="middle">
		    </form>
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
	    </div>
	    <table border="1" align="center">
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
    
    <!-- 以下是库存列表以及操作 -->
    <!-- 
    	库存表（药品编码，库存量，生产厂家，规格，零售价）
     -->
    <div id="waredrugtable" align="center" style="background-color: pink;">
    	<form action="<%=basePath %>warehouse/preAdd.action" method="post">
		    	<input type="submit" value="增加库存" align="middle">
		</form>
    	<table border="1" align="center">
	    	<tr>
	    		<th colspan="7">药品库存清单</th>
	    	</tr>
	    	<tr>
	    		<th>药品编码</th>
	    		<th>生产厂家</th>
	    		<th>规格</th>
	    		<th>库存量</th>
	    		<th>零售价</th>
	    		<th>操作</th>
	    	<c:forEach var="warehouse" items="${warehouseList }">
	    		<tr>
	    			<td>${warehouse.drug_id }</td>
	    			<td>${warehouse.manufacturer }</td>
	    			<td>${warehouse.standard }</td>
	    			<td>${warehouse.stock_number }</td>
	    			<td>${warehouse.sale_price }</td>
	    			
	    			
	    			<td>
	    				<a href="<%=basePath %>warehouse/preEdit.action?id=${warehouse.id }&drug_id=${warehouse.drug_id }&manufacturer=${warehouse.manufacturer }&standard=${warehouse.standard }&sale_price=${warehouse.sale_price }&stock_number=${warehouse.stock_number }">修改</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
    
    <!-- 以下是进药列表以及操作 -->
    <!-- 
    	进药表（单据号，药品编码，采购价，采购数量，采购日期，供应商）
     -->
    <div id="stockdrugtable" align="center" style="background-color: green;">
    	<form action="<%=basePath %>stock/preAdd.action" method="post">
		    	<input type="submit" value="进药" align="middle">
		</form>
    	<table border="1" align="center">
	    	<tr>
	    		<th colspan="7">药品进货清单</th>
	    	</tr>
	    	<tr>
	    		<th>单据号</th>
	    		<th>药品编码</th>
	    		<th>采购价</th>
	    		<th>采购数量</th>
	    		<th>采购日期</th>
	    		<th>供应商</th>
	    		<th>操作</th>
	    	<c:forEach var="stockdrug" items="${stockDrugList }">
	    		<tr>
	    			<td>${stockdrug.bill_id }</td>
	    			<td>${stockdrug.drug_id }</td>
	    			<td>${stockdrug.price }</td>
	    			<td>${stockdrug.buy_num }</td>
	    			<td>${stockdrug.date }</td>
	    			<td>${stockdrug.supplier }</td>
	    			
	    			
	    			<td>
	    				<a href="<%=basePath %>stock/preEdit.action?id=${stockdrug.id }&bill_id=${stockdrug.bill_id }&drug_id=${stockdrug.drug_id }&price=${stockdrug.price }&buy_num=${stockdrug.buy_num }&date=${stockdrug.date }&supplier=${stockdrug.supplier }">修改</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </table>
    </div>
    
     <!-- 以下是售药列表以及操作 -->
    <!-- 
    	售药表（顾客号，药品编码，销售量，销售日期，单价）
     -->
    <div id="saledrugtable" align="center" style="background-color: red;">
    	<form action="<%=basePath %>sale/preAdd.action" method="post">
		    	<input type="submit" value="售药" align="middle">
		</form>
    	<table border="1" align="center">
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
  </body>
</html>
