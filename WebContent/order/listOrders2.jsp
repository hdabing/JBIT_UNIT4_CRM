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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>  
</div>

<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><s:property value="customer.code" /></td>
		<th>客户名称</th>
		<td><s:property value="customer.name" /></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>

	<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_text"><s:property value="id" /></td>
		<td class="list_data_text"><s:date name="ordertime" /></td>
		<td class="list_data_text"><s:property value="address" /></td>
		<td class="list_data_text"><s:property value="state" /></td>
		<td class="list_data_op">
			<img onclick='location.href="listOrderlist?id=<s:property value="id" />";' title="查看明细" src="images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	</s:iterator>

	<tr>
		<th colspan="100" class="pager">
		<div class="pager">
			<s:include value="../public/page.jsp" />
		</div>
		</th>
	</tr>
	</table>
</body>
</html>