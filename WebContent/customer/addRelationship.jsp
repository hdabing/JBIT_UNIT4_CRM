<%@ page import="entity.Relationship" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmaddRelationshipOK;
		
		if(isEmpty('relationtime')==false){
			alert("交往时间不能为空");
			return false;
		}
		if(isEmpty('address')==false){
			alert("地点不能为空");
			return false;
		}
		if(isEmpty('summary')==false){
			alert("概要不能为空");
			return false;
		}
		if(isLargelength('content',100)==true){
			alert("备注长度超出");
			return false;
		}
		if(isLargelength('detail',100)==true){
			alert("详细信息长度超出");
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
<%
	int customerid=(Integer) request.getAttribute("customerid");
%>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录&gt; 新建交往记录</div>
<form name="FrmaddRelationshipOK" action="addRelationshipOK" method="POST">
<input type="hidden" name="relationship.customerid" value="<%=customerid %>" />
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>时间</th>
		<td>
			<input type="text" name="relationship.relationtime" id="relationtime" readonly="readonly" />
			<span class="red_star">*</span>
		</td>
		<th>地点</th>
		<td>
			<input type="text" name="relationship.address" id="address" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>概要</th>
		<td>
			<input type="text" name="relationship.summary" id="summary" />
			<span class="red_star">*</span>
		</td>
		<th>备注</th>
		<td>
			<input type="text" name="relationship.content" id="content" />
		</td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<textarea name="relationship.detail" id="detail" cols="50" rows="6"></textarea>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	setCurTime('relationtime');
</script>
</body>
</html>