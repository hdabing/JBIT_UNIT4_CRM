<%@ page import="java.util.List,entity.Area,entity.Customerlevel" %>
<%@ page language="java" contentType="text/html;charsert=UTF-8" pageEncoding="UTF-8" %>
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
		if(isOperator("相关信息同时被删除，是否确认删除此客户?")==true){
			location.href='delCustomer?id='+id;
		}
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="document.FrmqueryCustomerbyform.submit();">查询</button>
	<button class="common_button" onclick="location.href='addCustomer';">添加</button>   
</div>
<form name="FrmqueryCustomerbyform" action="queryCustomerbyform">
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><input type="text" name="customer.code" /></td>
		<th>名称</th>
		<td><input type="text" name="customer.name"  /></td>
		<th>地区</th>
		<td>
			<select name="customer.areaid">
			<option value='0'>请选择...</option>
			<s:iterator value="listarea">
				<option value='<s:property value="id" />'><s:property value="name" /></option>
			</s:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td><input type="text" name="customer.managername"  /></td>
		<th>客户等级</th>
		<td>
			<select name="customer.levelid">
			<option value='0'>请选择...</option>
			<s:iterator value="listcustomerlevel">
				<option value='<s:property value="id" />'><s:property value="name" /></option>
			</s:iterator>
			</select>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>客户编号</th>
		<th>名称</th>
		<th>地区</th>
		<th>客户经理</th>
		<th>客户等级</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_number"><s:property value="id" /></td>
		<td class="list_data_text"><s:property value="code" /></td>
		<td class="list_data_ltext"><s:property value="name" /></td>
		<td class="list_data_text"><s:property value="area.name" /></td>
		<td class="list_data_text"><s:property value="managername" /></td>
		<td class="list_data_text"><s:property value="customerlevel.name" /></td>
		<td class="list_data_op">
			<img onclick='location.href="editCustomer?id=<s:property value="id" />";' title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick='location.href="listCustomercontact?id=<s:property value="id" />";' title="联系人" src="images/bt_linkman.gif" class="op_button" />
			<img onclick='location.href="listRelationship?id=<s:property value="id" />";' title="交往记录" src="images/bt_acti.gif" class="op_button" />
			<img onclick='location.href="queryListorders?id=<s:property value="id" />";' title="历史订单" src="images/bt_orders.gif" class="op_button" />
			<img onclick='checkDel("<s:property value="id" />");' title="删除" src="images/bt_del.gif" class="op_button" />
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