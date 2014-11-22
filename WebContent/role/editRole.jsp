<%@ page import="java.util.List,entity.Author,entity.Role,entity.Roleauthor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmeditRole;
		
		if(isEmpty('rolename')==false){
			alert("角色名不能为空");
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
<% List<Roleauthor> listroleauthor=(List<Roleauthor>) request.getAttribute("listroleauthor"); %>
<div class="page_title">角色管理&gt;修改角色</div>
<div class="button_bar">
<button class="common_button" onclick="" >关于</button>
<button class="common_button" onclick="back();" >返回</button>
<button class="common_button" onclick="check();">保存</button>
</div>
<br />
<form name="FrmeditRole" action="editRoleOK" method="POST">
<input type="hidden" name="role.id" value="<%=listroleauthor.get(0).getRoleid() %>" />

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><%=listroleauthor.get(0).getRoleid() %></td>
		<th>角色名</th>
		<td>
			<input type="text" name="role.name" id="rolename" value="<%=listroleauthor.get(0).getRole().getName() %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th rowspan="32">指定权限</th>
	</tr>
	<%for(Roleauthor roleauthor:listroleauthor){ %>
	<tr>
		<td colspan="3">
			<%for(int i=0;i<=roleauthor.getAuthor().getAuthorlevel();i++){out.print("&nbsp;");} %>
			<%=roleauthor.getAuthor().getName() %>
			<input type="checkbox" name="author" value="<%=roleauthor.getAuthorid() %>"
			<% if(roleauthor.getIsdel()==0){ %>
				checked="checked"
			<%} %>
			 />
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