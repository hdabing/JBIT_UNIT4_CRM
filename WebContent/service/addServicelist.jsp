<%@ page import="java.util.List,entity.Customer,entity.Service,entity.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmaddServicelistOK;
		
		if(isEmpty('summary')==false){
			alert("概要不能为空");
			return false;
		}
		if(isEmpty('content')==false){
			alert("服务请求不能为空");
			return false;
		}
		if(isLargelength('content',100)==true){
			alert("服务请求超出长度");
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
<%
	List<Customer> listcustomer=(List<Customer>) request.getAttribute("listcustomer");
	List<Service> listservice=(List<Service>) request.getAttribute("listservice");
	Users createuser=(Users) session.getAttribute("user");
%>
<div class="page_title">客户服务管理 &gt; 服务创建</div>
<form name="FrmaddServicelistOK" action="addServicelistOK" method="POST">
<input type="hidden" name="servicelist.createuserid" value="<%if(createuser!=null){out.print(createuser.getId());}%>" />
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>客户</th>
		<td>
			<select name="servicelist.customerid">
			<%for(Customer customer:listcustomer){ %>
				<option value="<%=customer.getId() %>"><%=customer.getName() %></option>
			<%} %>
			</select>
			<span class="red_star">*</span>
		</td>
		<th>服务类型</th>
		<td>
			<select name="servicelist.serviceid">
			<%for(Service service:listservice){ %>
				<option value="<%=service.getId() %>"><%=service.getName() %></option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
			<input name="creater" value="<%if(createuser!=null){out.print(createuser.getUsername());} %>" readonly size="20"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>状态</th>
		<td>新创建</td>
	</tr>
	<tr>
		<th>概要</th>
		<td>
			<input type="text" name="servicelist.summary" id="summary"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>创建时间</th>
		<td>
			<input type="text" name="servicelist.createtime" id="createtime" readonly="readonly" />
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">
			<textarea name="servicelist.content" id="content" rows="6" cols="50"></textarea>
			<span class="red_star">*</span>
		</td>
	</tr>
	</table>
</form>
<script>
	setCurTime('createtime');
</script>
</body>
</html>