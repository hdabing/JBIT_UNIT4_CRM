<%@ page import="java.util.List,entity.Customer,entity.Customercontact" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function checkDel(id){
		if(isOperator("是否删除?")==true){
			location.href='delCustomercontact?id='+id;
		}
	}
</script>
</head>
<body>
<%
	List<Customercontact> listcustomercontact=(List<Customercontact>) request.getAttribute("listcustomercontact");
	Customer customer=(Customer) request.getAttribute("customer");
%>
<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 联系人 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='addCustomercontact?id=<%=customer.getId() %>';">新建</button>  
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><%if(customer.getCode()!=null){out.print(customer.getCode());} %></td>
		<th>客户名称</th>
		<td><%=customer.getName() %></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>职位</th>
		<th>办公电话</th>
		<th>手机</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
<% if(listcustomercontact!=null){for(Customercontact customercontact:listcustomercontact){ %>
	<tr>
		<td class="list_data_text"><%=customercontact.getName() %></td>
		<td class="list_data_ltext"><%=customercontact.getGender() %></td>
		<td class="list_data_text"><%=customercontact.getPosition() %></td>
		<td class="list_data_text"><%=customercontact.getPhone() %></td>
		<td class="list_data_text"><%if(customercontact.getTelephone()!=null){out.print(customercontact.getTelephone());} %></td>
		<td class="list_data_op">
			<%if(customercontact.getContent()!=null){out.print(customercontact.getContent());} %>
		</td>
		<td class="list_data_op">
			<img onclick="location.href='editCustomercontact?id=<%=customercontact.getId() %>'" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="checkDel(<%=customercontact.getId() %>);" title="删除" src="images/bt_del.gif" class="op_button" />
		</td>
	</tr>
<%}} %>
	</table>
</body>
</html>