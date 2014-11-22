<%@ page import="java.util.List,entity.Customer,entity.Customerlost" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<%
	List<Customerlost> listcustomerlost=(List<Customerlost>) request.getAttribute("listcustomerlost");
%>
<div class="page_title">客户流失分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="document.FrmqueryAgreelostbyform.submit();">查询</button>  
</div>
<form name="FrmqueryAgreelostbyform" action="queryAgreelostbyform" method="post">
	<table class="query_form_table">
		<tr>
			<th>客户</th>
			<td><input type="text" name="customer.name" /></td>
			<th>客户经理</th>
			<td><input type="text" name="customer.users.username" /></td>
		</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>流失年份</th>
		<th>客户经理</th>
		<th>流失原因</th>
	</tr>
<% if(listcustomerlost!=null){for(Customerlost customerlost:listcustomerlost){ %>
	<tr>
		<td class="list_data_number"><%=customerlost.getId() %></td>
		<td class="list_data_text"><%=customerlost.getCustomer().getName() %></td>
		<td class="list_data_text"><%if(customerlost.getLostday()!=null){out.print(customerlost.getLostday());} %></td>
		<td class="list_data_ltext"><%=customerlost.getCustomer().getUsers().getUsername() %></td>
		<td class="list_data_text"><%=customerlost.getLostcause() %></td>
	</tr>
<%}} %>
	<tr>
		<th colspan="5" class="pager">
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