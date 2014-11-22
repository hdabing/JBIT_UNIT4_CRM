<%@ page import="entity.Servicelist" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmbackServicelistOK;
		
		if(isEmpty('resultcontent')==false){
			alert("处理结果不能为空");
			return false;
		}
		if(isLargelength('resultcontent')==true){
			alert("处理结果长度超出");
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
<%
	Servicelist servicelist=(Servicelist) request.getAttribute("servicelist");
%>
<div class="page_title">客户服务管理 &gt; 服务反馈</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
	<button class="common_button" onclick="check();">保存</button> 
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><%=servicelist.getId() %></td>
		<th>服务类型</th>
		<td><%=servicelist.getService().getName() %></td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3"><%=servicelist.getSummary() %></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><%=servicelist.getCustomer().getName() %></td>
		<th>状态</th>
		<td><%=servicelist.getService().getName() %></td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3"><%=servicelist.getContent() %><br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><%=servicelist.getCreateuser().getUsername() %></td>
		<th>创建时间</th>
		<td><%=servicelist.getCreatetime() %></td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td><%=servicelist.getManager().getUsername() %></td>
		<th>分配时间</th>
		<td><%=servicelist.getGranttime() %></td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><%=servicelist.getOperatorcontent() %></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><%=servicelist.getOperator().getUsername() %></td>
		<th>处理时间</th>
		<td><%=servicelist.getOperatortime() %></td>
	</tr>
</table>
<br />
<form name="FrmbackServicelistOK" action="backServicelistOK" method="post">
<input type="hidden" name="servicelist.id" value="<%=servicelist.getId() %>" />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td>
			<input type="text" name="servicelist.resultcontent" id="resultcontent" maxlength="100" />
			<span class="red_star">*</span>
		</td>
		<th>满意度</th>
		<td>
			<select name="servicelist.agreelevel">
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select>
			<span class="red_star">*</span>
		</td>
	</tr>
</table>
</form>
</body>
</html>