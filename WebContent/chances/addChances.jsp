<%@ page import="java.util.List" %>
<%@ page import="entity.Customerlevel" %>
<%@ page import="entity.Area" %>
<%@ page import="entity.Users" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<script language="javascript" >
	//输入验证
	function check(){
		if(isEmpty('name')==false){
			alert("客户名称不能为空!");
			return false;
		}
		if(isEmpty('managername')==false){
			alert("负责人不能为空!");
			return false;
		}
		if(isEmpty('chancesrate')==false){
			alert("成功机率不能为空!");
			return false;
		}
		if(isEmpty('phone')==false){
			alert("公司电话不能为空!");
			return false;
		}
		if(isPhone('phone')==false){
			alert("请输入正确的公司电话!");
			return false;
		}
		if(isEmpty('content')==false){
			alert("概要不能为空!");
			return false;
		}
		if(isEmpty('chancesdesc')==false){
			alert("机会描述不能为空!");
			return false;
		}
		if(isNumber('chancesrate')==false){
			alert("成功机率必须为数字!");
			return false;
		}else{
			var input_chancesrate=document.getElementById("chancesrate").value;
			if(input_chancesrate>100){
				alert("成功机率非法!");
				return false;
			}
		}
		if(isLargelength('chancesdesc',100)==true){
			alert("机会描述长度超出!");
			return false;
		}
		
		return true;
	}
	
	function addChancesOK(){
		var frm=document.FrmAddChances;
		if(check()==true){
			frm.submit();
		}
	}
</script>
</head>
<body>
<%
	List<Customerlevel> listcustomerlevel=(List<Customerlevel>) request.getAttribute("listcustomerlevel");
	List<Area> listarea=(List<Area>) request.getAttribute("listarea");
	List<Users> listusers=(List<Users>) request.getAttribute("listusers");
%>
<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="addChancesOK();">保存</button>  
</div>
<form  id="FrmAddChances" name="FrmAddChances" class="query_form_table" action="addChancesOK" method="POST">
<table class="query_form_table">
	<tr>
		<th>
		客户名称
		</th>
		<td>
		<input type="text" name="chances.name" id="name" maxlength="25" />
		<span class="red_star">*必填项</span>
		</td>
		<th>
		负责人
		</th>
		<td>
		<input type="text" name="chances.managername" id="managername" maxlength="25" />
		<span class="red_star">*必填项</span>
		</td>
	</tr>
	<tr>
		<th>
		机会来源
		</th>
		<td>
		<input type="text" name="chances.chancesfrom" id="chancesfrom" maxlength="25" />
		</td>
		<th>
		成功机率(%)
		</th>
		<td>
		<input type="text" name="chances.successrate" id="chancesrate" maxlength="5" />
		<span class="red_star">*必填项</span>
		</td>
	</tr>
	<tr>
		<th>
		公司电话
		</th>
		<td>
		<input type="text" name="chances.phone" id="phone" maxlength="25" />
		<span class="red_star">*必填项</span>
		</td>
		<th>
		客户等级
		</th>
		<td>
		<select name="chances.levelid">
		<% for(Customerlevel customerlevel:listcustomerlevel){ %>
			<option value="<%=customerlevel.getId() %>"><%=customerlevel.getName() %></option>
		<%} %>
		</select>
		<span class="red_star">*必填项</span>
		</td>
	</tr>
	<tr>
		<th>
		概要
		</th>
		<td>
		<input type="text" name="chances.content" id="content" maxlength="25" />
		<span class="red_star">*必填项</span>
		</td>
		<th>
		地区
		</th>
		<td>
		<select name="chances.areaid">
		<% for(Area area:listarea){ %>
			<option value="<%=area.getId() %>"><%=area.getName() %></option>
		<%} %>
		</select>
		<span class="red_star">*必填项</span>
		</td>
	</tr>
	<tr>
		<th>
		机会描述
		</th>
		<td colspan="3">
		<textarea name="chances.chancesdesc" id="chancesdesc" rows="10" cols="50"></textarea>
		<span class="red_star">*必填项</span>
		</td>
	</tr>
	<input type="hidden" name="chances.createtime" id="createtime" />
</table>
<br />

<table disabled class="query_form_table" id="table1">
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
			<input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<script type="text/javascript">
	setCurTime('createtime');
</script>
</body>
</html>