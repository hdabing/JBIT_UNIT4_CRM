<%@ page import="java.util.List,entity.Orders,entity.Orderlist" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
	List<Orderlist> listorderlist=(List<Orderlist>) request.getAttribute("listorderlist");
	Orders orders=(Orders) request.getAttribute("orders");
	
%>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='queryListorders';">返回</button>  
</div>
<table class="query_form_table" height="59">
	<tr>
		<th>订单编号</th>
		<td><%=orders.getId() %></td>
		<th>日期</th>
		<td><%=orders.getOrdertime() %></td>
	</tr>
	<tr>
		<th height="28">送货地址</th>
		<td><%=orders.getAddress() %></td>
		<th height="28">总金额（元）</th>
		<td><%=orders.getAmount() %></td>
	</tr>
	<tr>
		<th height="28">状态</th>
		<td><%=orders.getState() %></td>
		<th height="28">&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>商品</th>
		<th>数量</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>金额（元）</th>
	</tr>
<%if(listorderlist!=null){for(Orderlist orderlist:listorderlist){ %>
	<tr>
		<td class="list_data_text"><%=orderlist.getProduct().getName() %></td>
		<td class="list_data_ltext"><%=orderlist.getQuantity() %></td>
		<td class="list_data_text"><%=orderlist.getProduct().getUnit() %></td>
		<td class="list_data_text"><%=orderlist.getPrice() %></td>
		<td class="list_data_text"><%=orderlist.getAmount() %></td>
	</tr>
<%}} %>
	</table>
</body>
</html>