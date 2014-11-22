<%@ page import="java.util.List,entity.Product" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
	List<Product> listproduct=(List<Product>) request.getAttribute("listproduct");
%>
<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="document.FrmqueryProductbyform.submit();">查询</button>  
</div>
<form name="FrmqueryProductbyform" action="queryProductbyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td><input type="text" name="product.name" /></td>
		<th>型号</th>
		<td><input type="text" name="product.model" /></td>
		<th>等级批次</th>
		<td><input type="text" name="product.batch" /></td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>型号</th>
		<th>等级/批次</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>备注</th>
	</tr>
<%if(listproduct!=null){for(Product product:listproduct){ %>
	<tr>
		<td class="list_data_number"><%=product.getId() %></td>
		<td class="list_data_ltext"><%=product.getName() %></td>
		<td class="list_data_text"><%=product.getModel() %></td>
		<td class="list_data_text"><%=product.getBatch() %></td>
		<td class="list_data_text"><%=product.getUnit() %></td>
		<td class="list_data_number"><%=product.getPrice() %></td>
		<td class="list_data_ltext"><%=product.getContent() %></td>		
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