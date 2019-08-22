<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>营业网点是信息列表页面</title>
<style type="text/css">
	*{
		margin:0px;
		padding:0px;
	}
	
	.section{
		width:800px;
		margin:0px auto;
		border:1px solid orange;
		text-align:center;
		padding:35px;
	}
	
	.section>p{
		text-align: right;
	}
	
	.section>table{
		width:100%;
	}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".section>table tr:even").css("background-color","lightblue");
	});
</script>
</head>
<body>
	<div class="section">
		<h3>营业网点查询</h3>
		<p><a href="addBranch.jsp">新增网点</a></p>
		<c:if test="${empty requestScope.branches}">
			<c:redirect url="QueryAll"></c:redirect>
		</c:if>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr><th>网点名称</th><th>所在城区</th><th>网点地址</th><th>联系电话</th><th>操作</th></tr>
		
			<c:forEach var="branch" items="${requestScope.branches}">
				<tr>
					<td>${branch.name}</td>
					<td>${branch.cityArea}</td>
					<td>${branch.address}</td>
					<td>${branch.telephone }</td>
					<td><a href="details?id=${branch.id}">查询</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>