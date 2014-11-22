<%@ page import="entity.Users" %>
<%@ page import="entity.Role" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">
	当前用户:
	<% 
		Users user=(Users) session.getAttribute("user");
		Role role=(Role) session.getAttribute("role");
		if(user!=null){
			out.print(user.getUsername()+"("+role.getName()+")");
		}
	%>
	&nbsp;&nbsp; 
	<a href="logOut" target="_top" >退出系统</a>
	</td>
</tr>
</table>
</body>
</html>
