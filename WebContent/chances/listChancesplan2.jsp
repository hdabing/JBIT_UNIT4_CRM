<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function devSuccess(id){
		alert("开发成功，已归档");
		location.href='successChances?id='+id;
	}
	function devFail(id){
		alert("开发失败，已归档");
		location.href='failChances?id='+id;
	}
</script>
</head>
<body>

<div class="page_title">客户开发计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="document.FrmqueryChancesplan.submit();">查询</button> 
</div>
<form name="FrmqueryChancesplan" action="queryChancesplanbyform" method="post">
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input type="text" name="chances.name" /></td>
		<th>负责人</th>
		<td>
			<input type="text" name="chances.managername" />
		</td>
		<th>概要</th>
		<td>
			<input type="text" name="chances.content" size="20" />
		</td>
	</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>负责人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_number"><s:property value="id" /></td>
		<td class="list_data_text"><s:property value="name" /></td>
		<td class="list_data_ltext"><s:property value="content" /></td>
		<td class="list_data_text"><s:property value="managername" /></td>
		<td class="list_data_text"><s:property value="phone" /></td>
		<td class="list_data_text"><s:date name="createtime"  format="yyyy-MM-dd" /></td>
		<td class="list_data_text"><s:property value="chancestate.name" /></td>
		<td class="list_data_op">
		<s:if test="state==2">
			<img onclick='location.href="addChancesplan?id=<s:property value='id' />";' title="制定计划" src="images/bt_plan.gif" class="op_button" />
			<img onclick='location.href="executeChancesplan?id=<s:property value='id' />";' title="执行计划" src="images/bt_feedback.gif" class="op_button" />
			<img onclick='devSuccess("<s:property value="id" />");' title="开发成功" src="images/bt_yes.gif" class="op_button" />
		</s:if>
		<s:else>
			<img onclick='location.href="queryChancesplan?id=<s:property value='id' />";' title="查看" src="images/bt_detail.gif" class="op_button" />
		</s:else>
		</td>
	</tr>
</s:iterator>
	<tr>
		<th colspan="10" class="pager">
	<div class="pager">
	<s:include value="../public/page.jsp">
		<s:param name="pagebean" value="pagebean" />
	</s:include>
</div>
		</th>
	</tr>
</table>
</body>
</html>