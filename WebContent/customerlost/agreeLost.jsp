<%@ page import="entity.Customerlost" language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmagreeLostOK;
		
		if(isEmpty('lostcause')==false){
			alert("流失原因不能为空");
			return false;
		}
		if(isLargelength('lostcause',100)==true){
			alert("流失原因超出长度");
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
<%
	Customerlost customerlost=(Customerlost) request.getAttribute("customerlost");
%>
<form name="FrmagreeLostOK" action="agreeLostOK" method="POST">
<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<input type="hidden" name="customerlost.id" id="id" value="<%=customerlost.getId() %>" />
<input type="hidden" name="customerlost.customerid" id="customerid" value="<%=customerlost.getCustomerid() %>" />
<input type="hidden" name="customerlost.lastorder" id="lastorder" value="<%=customerlost.getLastorder() %>" />
<input type="hidden" name="customerlost.content" id="content" value="<%=customerlost.getContent() %>" />
<input type="hidden" name="customerlost.state" id="state" value="<%=customerlost.getState() %>" />
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>
			<%=customerlost.getId() %>
		</td>
		<th>客户</th>
		<td>
			<%=customerlost.getCustomer().getName() %>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			<%=customerlost.getCustomer().getUsers().getUsername() %>
		</td>
		<th>上次下单时间</th>
		<td>
			<%=customerlost.getLastorder() %>
		</td>
	</tr>
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">
			<%=customerlost.getContent() %>
		</td>
	</tr>	
	<tr>
		<th>流失原因</th>
		<td colspan="3">
			<textarea name="customerlost.lostcause" id="lostcause" rows="6" cols="50"></textarea>
			<span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
</form>
</body>
</html>