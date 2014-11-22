<%@ page import="entity.Users" %>
<%@ page import="entity.Role" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	function checkDel(delId){
		if(isOperator("是否要删除此角色?")==true){
			location.href='delRole?role.id='+delId;
		}
	}
</script>
</head>
<body>
<div class="page_title">角色管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='addRole';">新建</button>  
	<button class="common_button" onclick="document.FrmqueryRolebyform.submit();">查询</button>  
</div>
<form name="FrmqueryRolebyform" action="queryRolebyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input type="text" name="role.id" /></td>
		<th>角色</th>
		<td><input type="text" name="role.name" /></td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>角色名</th>
		<th>操作</th>
	</tr>
	<%
		List<Role> listrole=(List<Role>) request.getAttribute("listrole");
		if(listrole!=null){
			for(Role role:listrole){
	%>
	<tr>
		<td align="center"><%=role.getId() %></td>
		<td align="center"><%=role.getName() %></td>
		<td>
		<img src="./images/bt_edit.gif" alt="修改" onclick="location.href='editRole?id=<%=role.getId() %>'" />
		<%if(role.getId()!=1){ %>
		<img src="./images/bt_del.gif" alt="删除" onclick="checkDel(<%=role.getId() %>);" /> 
		<%} %>
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