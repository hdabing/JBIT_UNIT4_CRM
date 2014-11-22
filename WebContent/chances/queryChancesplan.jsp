<%@ page import="java.util.List" %>
<%@ page import="entity.Chances" %>
<%@ page import="entity.Chancesplan" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<%
	Chances chances=(Chances) request.getAttribute("chances");
	List<Chancesplan> listchancesplan=(List<Chancesplan>) request.getAttribute("listchancesplan");
%>
<div class="page_title">客户开发计划 &gt; 查看明细</div>

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><%=chances.getId() %></td>
		<th>机会来源</th>
		<td>
		<%if(chances.getChancesfrom()!=null){out.print(chances.getChancesfrom());} %>
		</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>
			<%=chances.getName() %>
		</td>
		<th>成功机率（%）</th>
		<td>
			<%=chances.getSuccessrate() %>
		</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">
			<%=chances.getContent() %>
		</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>
			<%=chances.getManagername() %>
		</td>
		<th>联系人电话</th>
		<td>
			<%=chances.getPhone() %>
		</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">
			<%=chances.getChancesdesc() %>
		</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
			<%=chances.getCreateuser().getUsername() %>
		</td>
		<th>创建时间</th>
		<td>
			<%=chances.getCreatetime() %>
		</td>
	</tr>
	<tr>
		<th>指派给</th>
		<td>
			<%=chances.getGrantuser().getUsername() %>
		</td>
		<th>指派时间</th>
		<td>
			<%=chances.getChancestime() %>
		</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	<%
		if(listchancesplan!=null){
			for(Chancesplan chancesplan:listchancesplan){
	%>
	<tr>
		<td class="list_data_text"><%=chancesplan.getPlantime() %></td>
		<td class="list_data_ltext"><%=chancesplan.getPlanname() %></td>
		<td class="list_data_ltext">
			<% if(chancesplan.getEffect()==null || chancesplan.getEffect().equals("")){
				
				}else{
					out.print(chancesplan.getEffect());
				}
			%>
		</td>
	</tr>
	<%}} %>
	</table>
</body>
</html>