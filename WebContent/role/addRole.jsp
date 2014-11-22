<%@ page import="java.util.List,entity.Author" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmAddRole;
		
		if(isEmpty('rolename')==false){
			alert("角色名不能为空");
			return false;
		}
		
		frm.submit();
	}
</script>
<title>新建角色</title>
</head>
<body>
<% List<Author> listauthor=(List<Author>) request.getAttribute("listauthor"); %>
<div class="page_title">角色管理&gt;新建角色</div>
<div class="button_bar">
<button class="common_button" onclick="" >关于</button>
<button class="common_button" onclick="back();" >返回</button>
<button class="common_button" onclick="check();">保存</button>
</div>
<br />
<form name="FrmAddRole" action="addRoleOK" method="POST">
<table class="query_form_table">
	<tr>
		<th>角色名</th>
		<td>
			<input type="text" name="role.name" id="rolename"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<th rowspan="32">指定权限</th>
	</tr>
	<%for(Author author:listauthor){ %>
	<tr>
		<td colspan="4">
			<%for(int i=0;i<=author.getAuthorlevel();i++){out.print("&nbsp;");} %>
			<%=author.getName() %><input type="checkbox" name="author" value="<%=author.getId() %>" />
		</td>
	</tr>
	<%} %>
</table>
</form>
<table class="query_form_table">
<tr>
	<th></th>
	<td>
		<input type="button" name="selectAll" value="全选"  onclick="selectAll()" />
		<input type="button" name="unSelectAll" value="取消全选" onclick="unSelectAll();" />
	</td>
	<td></td>
	<td></td>
	<td></td>
</tr>

</table>
<script type="text/javascript">
	//全选
	function selectAll(){
		var chk_author=document.getElementsByName("author");
		var count=chk_author.length;
		for(var i=0;i<count;i++){
			chk_author.item(i).setAttribute("checked","checked");
		}
	}
	
	//取消全选
	function unSelectAll(){
		var chk_author=document.getElementsByName("author");
		var count=chk_author.length;
		for(var i=0;i<count;i++){
			chk_author.item(i).removeAttribute("checked");
		}
	}
</script>
</body>
</html>