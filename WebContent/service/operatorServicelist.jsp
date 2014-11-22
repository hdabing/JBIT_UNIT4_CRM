<%@ page import="entity.Servicelist,entity.Users" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmoperatorServicelistOK;
		
		if(isEmpty('operatorcontent')==false){
			alert("服务处理不能为空");
			return false;
		}
		if(isLargelength('operatorcontent',100)==true){
			alert("服务处理长度超出");
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
<%
	Servicelist servicelist=(Servicelist) request.getAttribute("servicelist");
	Users user=(Users) session.getAttribute("user");
%>
<div class="page_title">客户服务管理 &gt; 服务处理</div>
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
		<td><%=servicelist.getOperator().getUsername() %></td>
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
<form name="FrmoperatorServicelistOK" action="operatorServicelistOK" method="post">
<input type="hidden" name="servicelist.id" value="<%=servicelist.getId() %>" />
<input type="hidden" name="servicelist.operatorid" value="<%=user.getId() %>" />
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">
			<textarea name="servicelist.operatorcontent" id="operatorcontent" rows="6" cols="50"></textarea>
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>
			<input name="servicelist.createuser" value="<%=user.getUsername() %>" readonly="readonly" size="20" />
			<span class="red_star">*</span>
		</td>
		<th>处理时间</th>
		<td>
			<input name="servicelist.operatortime" id="operatortime" readonly="readonly" size="20" />
			<span class="red_star">*</span>
		</td>
	</tr>
</table>
</form>
<script>
	setCurTime('operatortime');
</script>
</body>
</html>