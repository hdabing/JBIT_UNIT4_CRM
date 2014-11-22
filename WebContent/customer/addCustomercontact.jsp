<%@ page import="entity.Customercontact" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmaddCustomercontactOK;
		
		if(isEmpty('name')==false){
			alert("姓名不能为空");
			return false;
		}
		if(isEmpty('position')==false){
			alert("职位不能为空");
			return false;
		}
		if(isEmpty('phone')==false){
			alert("办公电话不能为空");
			return false;
		}
		if(isPhone('phone')==false){
			alert("请填写正确的办公电话");
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
<div class="page_title">客户信息管理&gt; 客户信息&gt; 联系人&gt; 添加联系人</div>
<form name="FrmaddCustomercontactOK" action="addCustomercontactOK" method="POST">
<input type="hidden" name="customercontact.customerid" value="<%=customerid %>" />
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='listCustomercontact?id=<%=customerid %>';">返回</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<table class="query_form_table" id="table1">
	<tr>
		<th>姓名</th>
		<td>
			<input type="text" name="customercontact.name" id="name" maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>性别</th>
		<td>
			<input type="radio" name="customercontact.gender" checked="checked" value="男" />男
			<input type="radio" name="customercontact.gender" value="女" />女
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td>
			<input type="text" name="customercontact.position" id="position"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>办公电话</th>
		<td>
			<input type="text" name="customercontact.phone" id="phone"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>手机</th>
		<td>
			<input type="text" name="customercontact.telephone"  maxlength="25" />
		</td>
		<th>备注</th>
		<td>
			<input type="text" name="customercontact.content"  maxlength="100" />
		</td>
	</tr>
</table>
</form>
</body>
</html>