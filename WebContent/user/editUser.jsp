<%@ page import="entity.Role" %>
<%@ page import="entity.Users" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript">
	function checkAll(){
		var frm=document.frmEditUser;
		
		if(isEmpty("username")==false){
			alert("请输入用户名");
			return;
		}
		if(isEmpty("password")==false){
			alert("请输入密码");
			return;
		}
		if(isEquals("password","repassword")==false){
			alert("两次密码输入不正确");
			return;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
<div class="page_title">用户管理&gt;编辑用户</div>
<div class="button_bar">
	<button class="common_button" onclick="" >关于</button>
	<button class="common_button" onclick="location.href='queryListusers'" >返回</button>
	<button class="common_button" onclick="checkAll();">保存</button>
</div>
<br />
<%
	Users user=(Users) request.getAttribute("user");
	List<Role> listrole=(List<Role>) request.getAttribute("listrole");
%>
<form name="frmEditUser" id="frmEditUser" action="editUserOK" method="POST" >
<input type="hidden" name="user.id" value="<%=user.getId() %>" />
	<table class="query_form_table">
		<tr>
			<th>编号:</th>
			<td><%=user.getId() %></td>
			<th>用户名</th>
			<td>
				<input type="text" name="user.username" id="username" value="<%=user.getUsername() %>" maxlength="25" />
				<span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>现任角色:</th>
			<td><%=user.getRole().getName() %></td>
			<th>角色</th>
			<td>
				<select name="user.roleid" 
				<%if(user.getId()==1){%>
				disabled="disabled"
				<%} %>
				>
					<% for(Role role:listrole){ %>
					<option value="<%=role.getId() %>"
					<%if(user.getRoleid()==role.getId()){ %>
						selected="selected"
					<%} %>
					><%=role.getName() %></option>
					<%}%>
				</select>
				<span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>密码</th>
			<td>
				<input type="password" name="user.password" id="password" maxlength="25" />
				<span class="red_star">*</span>
			</td>
			<th>确认密码</th>
			<td>
				<input type="password" name="repassword" id="repassword" maxlength="25" />
				<span class="red_star">*</span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>