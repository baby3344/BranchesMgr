<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网点信息详情页面</title>
<style type="text/css">
	*{
		margin:0px;
		padding:0px;
	}
	
	.section{
		width:650px;
		margin:0px auto;
		border:1px solid orange;
		text-align:center;
		padding:100px;
	}
	
	.section>table{
		width:100%;
		text-align: left;
	}
	
	.section>table tr td:first-child{
		width:150px;
	}
	
	.section>table tr td input{
		width:250px;
		font-size:20px;
	}
	
	.section>table tr td textarea {
		width: 450px;
		resize: none;
		height:100px;
	}
	
	.section>table tr:last-child{
		text-align: center;
	}
	
	.section>table tr:last-child td input{
		margin-top:10px;
	}
</style>
</head>
<body>
		<div class="section">
			<h2>网点详细信息</h2>
			<table>
				<tr>
					<td>网点名称：</td>
					<td>
						<input type="text" readonly="readonly" id="name" name="name" value="${requestScope.branch.name}"/>
					</td>
				</tr>
				
				<tr>
					<td>营业执照号：</td>
					<td>
						<input type="text" readonly="readonly" id="businessNo" name="businessNo" value="${requestScope.branch.businessNo}"/><span id="tip"></span>
					</td>
				</tr>
				
				<tr>
					<td>所在城市：</td>
					<td>
						<input type="text" readonly="readonly" id="cityArea" name="cityArea" value="${requestScope.branch.cityArea}"/>
					</td>
				</tr>
				
				<tr>
					<td>网点地址：</td>
					<td>
						<input type="text" readonly="readonly" id="address" name="address" value="${requestScope.branch.address}"/>
					</td>
				</tr>
				
				<tr>
					<td>联系电话：</td>
					<td>
						<input type="text" readonly="readonly" id="telephone" name="telephone" value="${requestScope.branch.telephone}"/>
					</td>
				</tr>
				
				<tr>
					<td>网点简介：</td>
					<td>
						<textarea name="summary" readonly="readonly" id="summary" rows="8" cols="10">${requestScope.branch.summary}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" id="myBack" onclick="history.back();" value="返回"/>
					</td>
				</tr>
			</table>
		</div>
</body>
</html>