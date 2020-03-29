<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function shenghe(id){
		var status = $("#status").val();
		
		$.post("updateStatus",{"id":id,"status":status},function(bb){
			if(bb){
				alert("成功");
				location= "queryAll";
			}else{
				location="update";
			}
		})
	}
</script>
</head>
<!-- 	private String keyword;// VARCHAR(50), -- 关键字
	private String mes;// varchar(200),#描述
	private String name;// VARCHAR(200),-- 公司名称
	private String product;// varchar(200), -- 产品
	private String address;// varchar(200), -- 地址
	private Double capital;// DOUBLE, -- 注册资本
	private Date idate;// date, -- 成立时间
	private Date inspection_time;// date, -- 年检日期
	private Status status;// varchar(200), -- 年间状态
	private String remark;// varchar(200) -- 备注 -->
<body>

	<form action="updateStatus" method="post">
			关键字:<input type="text" name="keyword" value="${ss.keyword }"> 描述:<input type="text" name="mes" value="${ss.mes }"> <br><br>
			编号:	<input type="text" name="id" value="${ss.id }"> 	公司名称:<input type="text" name="name" value="${ss.name }"> <br><br>
			产品:	<input type="text" name="product" value="${ss.product }"> 	地址:<input type="text" name="address" value="${ss.address }"> <br><br>
			资本:	<input type="text" name="capital" value="${ss.capital }"> 	
			成立时间:<input type="date" name="idate" value="<fmt:formatDate value="${ss.idate }" pattern="yyyy-MM-dd"/>">
			 <br><br>
			年检日期:<input type="date" name="inspection_time" value="<fmt:formatDate value="${ss.inspection_time }" pattern="yyyy-MM-dd"/>"> <br><br>
			年检状态:<select id="status" >
				<option value="通过" <c:if test="${ss.status.name == '通过' }">selected="selected"</c:if>>通过</option>
				<option value="未通过" <c:if test="${ss.status.name == '未通过' }">selected="selected"</c:if>>未通过</option>
				<option value="待年检" <c:if test="${ss.status.name == '待年检' }">selected="selected"</c:if>>待年检</option>
			</select>
			<br><br>
			备注:<textarea rows="10" cols="100" name="remark">${ss.remark }</textarea>
			
			<input type="button" value="审核" onclick="shenghe(${ss.id })">
	</form>
	
</body>
</html>