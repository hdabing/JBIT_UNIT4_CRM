<%@ page import="entity.Users" %>
<%@ page import="entity.Role" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	function checkDel(delId){
		if(isOperator("是否要删除此操作员?")==true){
			if(delId==1){
				alert("超级管理员不能被删除");
				return;
			}
			window.location.href='delUser?user.id='+delId;
		}
	}
</script>
</head>
<body>
<div class="page_title">用户管理</div>
<div class="button_bar">
	<button class="common_button" onclick="" >关于</button>
	<button class="common_button" onclick="location.href='addUser'" >新建</button>
	<button class="common_button" onclick="document.FrmqueryUsersbyform.submit();">查询</button>  
</div>
<form name="FrmqueryUsersbyform" action="queryUsersbyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input type="text" name="uid" />
		</td>
		<th>用户名</th>
		<td><input type="text" name="uname" />
		</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>用户名</th>
		<th>操作</th>
	</tr>
	<%
		Users sessionuser=(Users) session.getAttribute("user");
		List<Users> listusers=(List<Users>) request.getAttribute("listusers");
		if(listusers!=null){
			for(Users user:listusers){
	%>
	<tr>
		<td align="center"><%=user.getId() %></td>
		<td align="center"><%=user.getUsername() %></td>
		<td>
		<img src="./images/bt_edit.gif" alt="修改" onclick="location.href='editUser?user.id=<%=user.getId() %>'" /> 
		<%if(user.getId()!=1){if(sessionuser!=null){if(user.getId()!=sessionuser.getId()){ %>
		<img src="./images/bt_del.gif" alt="删除" onclick="checkDel(<%=user.getId() %>)" /> 
		<%}}} %>
		</td>
	</tr>
	<% }} %>
	<tr>
		<th colspan="3" class="pager">
		<div class="pager">
			<s:include value="../public/page.jsp" >
				<s:param name="pagebean" value="pagebean" />
			</s:include>
		</div>
		</th>
	</tr>
</table>
</body>
</html>