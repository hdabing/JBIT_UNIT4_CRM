<%@ page import="java.util.List,entity.Customerlevel" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function checkDel(id){
		if(isOperator("是否删除?")==true){
			location.href='delCustomerlevel?id='+id;
		}
	}
</script>
</head>
<body>
<%
	List<Customerlevel> listcustomerlevel=(List<Customerlevel>) request.getAttribute("listcustomerlevel");
%>
<div class="page_title">客户等级管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="location.href='addCustomerlevel';">新建</button>
	<button class="common_button" onclick="document.FrmqueryCustomerlevelbyform.submit();">查询</button>  
</div>
<form name="FrmqueryCustomerlevelbyform" action="queryCustomerlevelbyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input type="text" name="customerlevel.id" /></td>
		<th>值</th>
		<td><input type="text" name="customerlevel.name" /></td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>值</th>
		<th>操作</th>
	</tr>
	<%if(listcustomerlevel!=null){for(Customerlevel customerlevel:listcustomerlevel){ %>
	<tr>
		<td class="list_data_number"><%=customerlevel.getId() %></td>
		<td class="list_data_ltext"><%=customerlevel.getName() %></td>
		<td class="list_data_op">
			<img onclick="location.href='editCustomerlevel?id=<%=customerlevel.getId() %>';" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="checkDel(<%=customerlevel.getId() %>);" title="删除" src="images/bt_del.gif" class="op_button" />
		</td>
	</tr>
	<%}} %>
	<tr>
		<th colspan="7" class="pager">
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