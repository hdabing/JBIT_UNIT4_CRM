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
<%
	Chances chances=(Chances) request.getAttribute("chances");
	List<Chancesplan> listchancesplan=(List<Chancesplan>) request.getAttribute("listchancesplan");
%>
<div class="page_title">客户开发计划 &gt; 执行计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="devFail(<%=chances.getId() %>);">终止开发</button>
	<button class="common_button" onclick="location.href='queryListchancesofplan'">返回</button>
	<button class="common_button" onclick="location.href='addChancesplan?id=<%=chances.getId() %>'">制定计划</button>
	<button class="common_button" onclick="devSuccess(<%=chances.getId() %>);">开发成功</button>

	</div>

<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><%=chances.getId() %></td>
		<th>机会来源</th>
		<td>
		<%=chances.getChancesfrom() %>
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
			<%if(chances.getChancesdesc()!=null){out.print(chances.getChancesdesc());} %>
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
	<form action="executeChancesplanOK" method="post">
	<tr>
		<td class="list_data_text"><%=chancesplan.getPlantime() %></td>
		<td class="list_data_ltext"><%=chancesplan.getPlanname() %></td>
		<td class="list_data_ltext">
			<% if(chancesplan.getEffect()==null || chancesplan.getEffect().equals("")){ %>
			<input type="text" name="chancesplan.effect" id="effect" maxlength="25"/>　
			<input type="submit" class="common_button" value="保存" />
			<%}else{out.print(chancesplan.getEffect());} %>
		</td>
	</tr>
	<input type="hidden" name="chancesplan.id" value="<%=chancesplan.getId() %>" />
	<input type="hidden" name="chancesplan.planname" value="<%=chancesplan.getPlanname() %>" />
	<input type="hidden" name="chancesplan.plantime" value="<%=chancesplan.getPlantime() %>" />
	<input type="hidden" name="chancesplan.chancesid" value="<%=chancesplan.getChancesid() %>" />
	</form>
	<%}} %>
	</table>
</body>
</html>