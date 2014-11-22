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
<div class="page_title">查询库存</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="document.FrmqueryStorebyform.submit();">查询</button>  
</div>
<form name="FrmqueryStorebyform" action="queryStorebyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>产品</th>
		<td><input type="text" name="product.name" /></td>
		<th>仓库</th>
		<td><input type="text" name="product.store" /></td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
<%if(listproduct!=null){for(Product product:listproduct){ %>
	<tr>
		<td class="list_data_number"><%=product.getId() %></td>
		<td class="list_data_ltext"><%=product.getName() %></td>
		<td class="list_data_text"><%=product.getStorename() %></td>
		<td class="list_data_text"><%=product.getHousename() %></td>
		<td class="list_data_text"><%=product.getQuantity() %></td>
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