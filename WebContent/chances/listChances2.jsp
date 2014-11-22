<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function checkDel(id){
		if(isOperator("确认删除?")==true){
			alert("删除成功!");
			location.href='delChances?id='+id;
		}
	}
</script>
</head>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='addChances';">新建</button>  
	<button class="common_button" onclick="document.FrmqueryChances.submit();">查询</button> 
</div>
<form name="FrmqueryChances" action="queryChancesbyform" method="post">
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input type="text" name="chances.name" /></td>
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
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
<s:iterator value="pagebean.list">
	<tr>
		<td class="list_data_number"><s:property value="id" /></td>
		<td class="list_data_text"><s:property value="name" /></td>
		<td class="list_data_ltext"><s:property value="content" /></td>
		<td class="list_data_text"><s:property value="managername" /></td>
		<td class="list_data_text"><s:property value="phone" /></td>
		<td class="list_data_text"><s:date name="createtime" format="yyyy-MM-dd" /></td>
		<td class="list_data_op">
			<img onclick="location.href='grantChances?id=<s:property value="id" />';" title="指派" src="images/bt_linkman.gif" class="op_button" />
			<img onclick="location.href='editChances?id=<s:property value="id" />';" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<s:if test="createuserid==#session.user.id">
			<img onclick="checkDel(<s:property value="id" />);" title="删除" src="images/bt_del.gif" class="op_button" />
			</s:if>
		</td>
	</tr>
</s:iterator>
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