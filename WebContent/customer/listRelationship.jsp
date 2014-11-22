<%@ page import="java.util.List,entity.Relationship,entity.Customer" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
			location.href='delRelationship?id='+id;
		}
	}
</script>
</head>
<body>
<%
	List<Relationship> listrelationship=(List<Relationship>) request.getAttribute("listrelationship");
	Customer customer=(Customer) request.getAttribute("customer");
%>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='addRelationship?id=<%=customer.getId() %>';">新建</button>  
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><%if(customer.getCode()!=null){out.print(customer.getCode());} %></td>
		<th>客户名称</th>
		<td><%=customer.getName() %></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th width="232">时间</th>
		<th>地点</th>
		<th>概要</th>
		<th>详细信息</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
<% if(listrelationship!=null){for(Relationship relationship:listrelationship){ %>
	<tr>
		<td class="list_data_text" width="230"><%=relationship.getRelationtime() %></td>
		<td class="list_data_text"><%=relationship.getAddress() %></td>
		<td class="list_data_ltext"><%=relationship.getSummary() %></td>
		<td class="list_data_ltext"><%if(relationship.getDetail()!=null){out.print(relationship.getDetail());} %></td>
		<td class="list_data_op">
			<%if(relationship.getContent()!=null){out.print(relationship.getContent());} %>
		</td>
		<td class="list_data_op">
			<img onclick="location.href='editRelationship?id=<%=relationship.getId() %>';" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="checkDel(<%=relationship.getId() %>);" title="删除" src="images/bt_del.gif" class="op_button" />
		</td>
	</tr>
<%}} %>
	</table>
</body>
</html>