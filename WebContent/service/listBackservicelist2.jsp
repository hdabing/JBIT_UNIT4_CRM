<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<div class="page_title">客户服务管理 &gt; 服务反馈</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="document.queryServicelistbyform.submit();">查询</button>  
</div>
<form name="queryServicelistbyform" action="queryServicelistbyform" method="post">
<table class="query_form_table" height="53">
	<tr>
		<th height="28">客户</th>
		<td><input type="text" name="customer.name" /></td>
		<th height="28">概要</th>
		<td><input type="text" name="servicelist.summary" /></td>
		<th height="28">服务类型</th>
		<td>
			<select name="servicelist.serviceid">
				<option value='0'>请选择</option>
					<s:iterator value="listservice">
						<option value='<s:property value="id" />'><s:property value="name" /></option>
					</s:iterator>
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
		<th>服务类型</th>
		<th>创建人</th>
		<th>创建日期</th>
		<th>概要</th>
		<th>操作</th>
	</tr>
<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_number"><s:property value="id" /></td>
		<td class="list_data_text"><s:property value="customer.name" /></td>
		<td class="list_data_text"><s:property value="service.name" /></td>
		<td class="list_data_text"><s:property value="createuser.username" /></td>
		<td class="list_data_text"><s:date name="createtime" format="yyyy-MM-dd" /></td>
		<td class="list_data_ltext"><s:property value="summary" /></td>
		<td class="list_data_op">
			<img onclick='location.href="backServicelist?id=<s:property value="id" />";' title="处理" src="images/bt_feedback.gif" class="op_button" />
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