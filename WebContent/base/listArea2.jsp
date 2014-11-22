<%@ page import="java.util.List,entity.Area" %>
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
			location.href='delArea?id='+id;
		}
	}
</script>
</head>
<body>
<%
	List<Area> listarea=(List<Area>) request.getAttribute("listarea");
%>
<div class="page_title">客户地区管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="location.href='addArea';">新建</button>
	<button class="common_button" onclick="document.FrmqueryAreabyform.submit();">查询</button>  
</div>
<form name="FrmqueryAreabyform" action="queryAreabyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input type="text" name="area.id" /></td>
		<th>值</th>
		<td><input type="text" name="area.name" /></td>
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
	<%if(listarea!=null){for(Area area:listarea){ %>
	<tr>
		<td class="list_data_number"><%=area.getId() %></td>
		<td class="list_data_ltext"><%=area.getName() %></td>
		<td class="list_data_op">
			<img onclick="location.href='editArea?id=<%=area.getId() %>';" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="checkDel(<%=area.getId() %>);" title="删除" src="images/bt_del.gif" class="op_button" />
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