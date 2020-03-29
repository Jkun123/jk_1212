<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>

</head>
<body>
	<form action="queryAll" method="post">
			编号:<input type="text" name="id"><br><br>
			关键字:<input type="text" name="keyword"><br><br>
			描述:<input type="text" name="mes"><br><br>
			公司名称:<input type="text" name="name"><br><br>
			主营产品:<input type="text" name="product"><br><br>
			地址:<input type="text" name="address"><br><br>
			资本:<input type="text" name="startCapital">~<input type="text" name="endCapital"><br><br>
			成立时间:<input type="text" name="startIdate">~<input type="text" name="endIdate"><br><br>
			查询:<input type="submit" value="查询"><br><br>
	</form>
	
	<table>
		<tr>
			<td>编号</td>
			<td>关键字</td>
			<td>描述</td>
			<td>公司名称</td>
			<td>产品</td>
			<td>地址</td>
			<td>资本</td>
			<td>成立时间</td>
			<td>年间日期</td>
			<td>状态</td>
			<td>备注</td>
			<td>操作</td>
		</tr>

		
		<c:forEach items="${pi.list }" var="a">
			<tr>
				<td>${a.id }</td>
				<td>${a.keyword }</td>
				<td>${a.mes }</td>
				<td>${a.name }</td>
				<td>${a.product }</td>
				<td>${a.address }</td>
				<td>${a.capital }</td>
				<td>${a.idate }</td>
				<td>${a.inspection_time }</td>
				<td>
					${a.status.name }
				</td>
				<td>${a.remark }</td>
				<td>
					<a href="queryById?id=${a.id }"><input type="button" value="年检审核"></a>
				 </td>
			</tr>
		</c:forEach>
		<tr >
			<td colspan="99">
				共${pi.total }数据/共${pi.pages }页
				<c:forEach begin="1" end="${pi.pages }" step="1" var="aa" >
					<a href="queryAll?pageNum=${aa }">${aa }</a>
				</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>