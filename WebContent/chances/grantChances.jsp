<%@ page import="java.util.List" %>
<%@ page import="entity.Customerlevel" %>
<%@ page import="entity.Area" %>
<%@ page import="entity.Users" %>
<%@ page import="entity.Chances" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script language="javascript" >
	function editChancesOK(){
		var frm=document.FrmGrantChances;
		frm.submit();
	}
</script>
</head>
<body>
<%
	List<Customerlevel> listcustomerlevel=(List<Customerlevel>) request.getAttribute("listcustomerlevel");
	List<Area> listarea=(List<Area>) request.getAttribute("listarea");
	List<Users> listusers=(List<Users>) request.getAttribute("listusers");
	Chances chances=(Chances) request.getAttribute("chances");
%>
<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="editChancesOK();">保存</button>  
</div>
<form  id="FrmGrantChances" name="FrmGrantChances"  action="grantChancesOK" method="POST">
<table class="query_form_table">
	<tr>
		<th>
		客户名称
		</td>
		<td>
		<%=chances.getName() %>
		</td>
		<th>
		负责人
		</th>
		<td>
		<%=chances.getManagername() %>
		</td>
	</tr>
	<tr>
		<th>
		机会来源
		</th>
		<td>
		<%if(chances.getChancesfrom()!=null){out.print(chances.getChancesfrom());} %>
		</td>
		<th>
		成功机率(%)
		</th>
		<td>
		<%=chances.getSuccessrate() %>
		</td>
	</tr>
	<tr>
		<th>
		公司电话
		</th>
		<td>
		<%=chances.getPhone() %>
		</td>
		<th>
		客户等级
		</th>
		<td>
		<%=chances.getCustomerlevel().getName() %>
		</td>
	</tr>
	<tr>
		<th>
		概要
		</th>
		<td>
		<%=chances.getContent() %>
		</td>
		<th>
		地区
		</th>
		<td>
		<%=chances.getArea().getName() %>
		</td>
	</tr>
	<tr>
		<th>
		机会描述
		</th>
		<td colspan="3">
		<%=chances.getChancesdesc() %>
		</td>
	</tr>
	
	<input type="hidden" name="chances.createtime" id="createtime" value="<%=chances.getChancestime() %>" />
	<input type="hidden" name="chances.createuserid" id="createuserid" value="<%=chances.getCreateuserid() %>" />
</table>
<br />

<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
			<select name="chances.userid">
			<% for(Users user:listusers){ %>
				<option value="<%=user.getId() %>"><%=user.getUsername() %></option>
			<%} %>
			</select> <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input type="text" name="chances.chancestime" id="chancestime" size="20" readonly="readonly" /><span class="red_star">*</span></td>
	</tr>
	<input type="hidden" name="chances.id" id="id" value="<%=chances.getId() %>" />
</table>
</form>
<script>
	setCurTime('chancestime');
</script>
</body>
</html>