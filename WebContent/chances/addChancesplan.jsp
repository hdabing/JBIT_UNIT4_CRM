<%@ page import="entity.Chances" %>
<%@ page import="entity.Chancesplan" %>
<%@ page import="java.util.List" %>
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
		var frm=document.FrmaddChancesplanOK;
		if(isEmpty('planname')==true){
			frm.submit();
		}else{
			alert("计划项不能为空!");
		}
	}
	function checkDel(id){
		if(isOperator("是否删除?")==true){
			location.href='delChancesplanOK?id='+id;
		}
	}
</script>
</head>
<body>
<%
	Chances chances=(Chances) request.getAttribute("chances");
	List<Chancesplan> listchancesplan=(List<Chancesplan>) request.getAttribute("listchancesplan");
%>
<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='executeChancesplan?id=<%=chances.getId() %>';">执行计划</button>
	<button class="common_button" onclick="location.href='queryListchancesofplan';">返回</button>
</div>
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
		<td><%=chances.getName() %></td>
		<th>成功机率（%）</th>
		<td><%=chances.getSuccessrate() %></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><%=chances.getContent() %></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><%=chances.getManagername() %></td>
		<th>联系人电话</th>
		<td><%=chances.getPhone() %></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><%=chances.getChancesdesc() %></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><%=chances.getCreateuser().getUsername() %></td>
		<th>创建时间</th>
		<td><%=chances.getCreatetime() %></td>
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
		<th width="150px">日期</th>
		<th height="31">计划项</th>
	</tr>
	<% 
		if(listchancesplan!=null){
			for(Chancesplan chancesplan:listchancesplan){ 
	%>
	<tr>
		<td class="list_data_text" height="24"><%=chancesplan.getPlantime() %></td>
		<td class="list_data_ltext" height="24"><input readonly="readonly" size="50" value="<%=chancesplan.getPlanname() %>" />
		<button class="common_button" onclick="checkDel(<%=chancesplan.getId() %>);">删除</button>
		</td>
	</tr>
	<%}} %>
</table>
<form name="FrmaddChancesplanOK" action="addChancesplanOK" method="POST">
<input type="hidden" name="chancesplan.chancesid" value="<%=chances.getId() %>" />
<div class="button_bar">
	<input type="button" class="common_button" value="添加" onclick="check();" />
	</div>
<table class="query_form_table" id="table2">
	<tr>
		<th>日期</th>
		<td><input type="text" name="chancesplan.plantime" id="plantime" readonly="readonly" /><span class="red_star">*</span></td>
		<th>计划项</th>
		<td>
			<input type="text" size="50" name="chancesplan.planname" id="planname" maxlength="25" /><span class="red_star">*</span>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	setCurTime('plantime');
</script>
</body>
</html>