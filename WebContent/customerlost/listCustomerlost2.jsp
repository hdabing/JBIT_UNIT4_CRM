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
<div class="page_title">客户流失管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="document.FrmqueryCustomerlostbyform.submit();">查询</button>  
</div>
<form name="FrmqueryCustomerlostbyform" action="queryCustomerlostbyform" method="POST" >
	<table class="query_form_table">
		<tr>
			<th>客户</th>
			<td><input type="text" name="customer.name"/></td>
			<th>客户经理</th>
			<td><input type="text" name="customer.users.username" /></td>
			<th>状态</th>
			<td>
				<select name="customerlost.state">
					<option value='0'>全部</option>
					<option value="流失预警">流失预警</option>
					<option value="暂缓流失">暂缓流失</option>
					<option value="确认流失">确认流失</option>
				</select>
			</td>
		</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>上次下单时间</th>
		<th>确认流失时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_number"><s:property value="id" /></td>
		<td class="list_data_text"><s:property value="customer.name" /></td>
		<td class="list_data_ltext"><s:property value="customer.users.username" /></td>
		<td class="list_data_text"><s:date name="lastorder" format="yyyy年MM月dd日"  /></td>
		<td class="list_data_text">
		<s:if test="state=='确认流失'">
			<s:date name="lostday" format="yyyy年MM月dd日" />
		</s:if>
		</td>
		<td class="list_data_text"><s:property value="state" /></td>
		<td class="list_data_op">
			<s:if test="state!='确认流失'" >
				<s:if test="state!='流失预警'">
				<img onclick='location.href="agreeLost?id=<s:property value="id" />";' title="确认流失" src="images/bt_confirm.gif" class="op_button" />
				</s:if>
				<img onclick='location.href="delayLost?id=<s:property value="id" />";' title="暂缓流失" src="images/bt_relay.gif" class="op_button" />
			</s:if>
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
	<div class="pager">
		<s:include value="../public/page.jsp" />
	</div>
		</th>
	</tr>
</table>
</body>
</html>