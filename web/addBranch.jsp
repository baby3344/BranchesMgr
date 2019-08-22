<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加营业网点信息</title>
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
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#businessNo").blur(function(){
			var businessNo=$("#businessNo").val();
			
			if(businessNo==""||businessNo==null){
				return;
			}
			
			$.post("checkBusinessNo","businessNo="+businessNo,function(data){
				if(data[0].result=="true"){
					$("#tip").html("营业执照号"+businessNo+"已注册！");
					$("#mySubmit").attr("disabled","false");
				}else{
					$("#tip").html("可以注册");
					$("#mySubmit").removeAttr("disabled");
				}
			},"JSON");
		});
		
		$("#mySubmit").click(function(){
			var name=$("#name").val().trim();
			
			if(name==""||name==null){
				alert("网点名称不能为空！");
				return false;
			}
			
			var businessNo=$("#businessNo").val().trim();
			
			if(businessNo==""||businessNo==null){
				alert("营业执照号不能为空！");
				return false;
			}
			
			var cityArea=$("#cityArea").val().trim();
			
			if(cityArea==""||cityArea==null){
				alert("所在地区不能为空！");
				return false;
			}
			
			var address=$("#address").val().trim();
			
			if(address==""||address==null){
				alert("网点地址不能为空！");
				return false;
			}
			
			return true;
		});
	});
</script>
</head>
<body>
	<form action="addBranch" method="post">
		<div class="section">
			<h2>营业网点查询</h2>
			<table>
				<tr>
					<td>网点名称：</td>
					<td>
						<input type="text" id="name" name="name"/>
					</td>
				</tr>
				
				<tr>
					<td>营业执照号：</td>
					<td>
						<input type="text" id="businessNo" name="businessNo"/><span id="tip"></span>
					</td>
				</tr>
				
				<tr>
					<td>所在城市：</td>
					<td>
						<input type="text" id="cityArea" name="cityArea"/>
					</td>
				</tr>
				
				<tr>
					<td>网点地址：</td>
					<td>
						<input type="text" id="address" name="address"/>
					</td>
				</tr>
				
				<tr>
					<td>联系电话：</td>
					<td>
						<input type="text" id="telephone" name="telephone"/>
					</td>
				</tr>
				
				<tr>
					<td>网点简介：</td>
					<td>
						<textarea name="summary" id="summary" rows="8" cols="10"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" id="mySubmit" value="提交"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>