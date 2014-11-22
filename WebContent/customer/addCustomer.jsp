<%@ page import="java.util.List" %>
<%@ page import="entity.Customer" %>
<%@ page import="entity.Area" %>
<%@ page import="entity.Customerlevel" %>
<%@ page import="entity.Users" %>
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
		var frm=document.FrmaddCustomerOK;
		
		if(isEmpty('name')==false){
			alert("客户名称不能为空");
			return false;
		}
		if(isEmpty('managername')==false){
			alert("负责人不能为空");
			return false;
		}
		if(isEmpty('address')==false){
			alert("地址不能为空");
			return false;
		}
		if(isEmpty('postcode')==false){
			alert("邮编不能为空");
			return false;
		}
		if(isEmpty('phone')==false){
			alert("电话不能为空");
			return false;
		}
		if(isEmpty('fax')==false){
			alert("传真不能为空");
			return false;
		}
		if(isEmpty('website')==false){
			alert("网址不能为空");
			return false;
		}
		if(isEmpty('bussinesscode')==false){
			alert("营业执照注册号不能为空");
			return false;
		}
		if(isEmpty('legalperson')==false){
			alert("法人不能为空");
			return false;
		}
		if(isEmpty('regbank')==false){
			alert("开户银行不能为空");
			return false;
		}
		if(isEmpty('bankaccount')==false){
			alert("银行账号不能为空");
			return false;
		}
		if(isPhone('phone')==false){
			alert("请填写正确的电话号码");
			return false;
		}
		if(isPhone('fax')==false){
			alert("请填写正确的传真号");
			return false;
		}
		frm.submit();
	}
	
</script>
</head>
<body>
<%
	List<Area> listarea=(List<Area>) request.getAttribute("listarea");
	List<Customerlevel> listcustomerlevel=(List<Customerlevel>) request.getAttribute("listcustomerlevel");
	List<Users> listusers=(List<Users>) request.getAttribute("listusers");
%>
<form name="FrmaddCustomerOK" action="addCustomerOK" method="POST">
<div class="page_title">客户信息管理 &gt; 新增客户信息</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td>
			<input type="text" name="customer.name" id="name"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>客户编号</th>
		<td>
			<input type="text" name="customer.code" id="code"  maxlength="25" />
		</td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<select name="customer.areaid">
			<% for(Area area:listarea){ %>
				<option value="<%=area.getId() %>"><%=area.getName() %></option>
			<%} %>
			</select>
			<span class="red_star">*</span>
		</td>
		<th>客户经理</th>
		<td>
			<select name="customer.userid">
			<% for(Users user:listusers){ %>
				<option value="<%=user.getId() %>"><%=user.getUsername() %></option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<select name="customer.levelid">
			<% for(Customerlevel customerlevel:listcustomerlevel){ %>
				<option value="<%=customerlevel.getId() %>"><%=customerlevel.getName() %></option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
		<th>负责人</th>
		<td>
			<input type="text" name="customer.managername" id="managername"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="customer.agreelevel">
			<% for(int i=1;i<6;i++){ %>
			<option value="<%=i %>">
			<% for(int k=i;k>0;k--){out.print("☆");} %>
			</option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="customer.creditlevel">
			<% for(int i=1;i<6;i++){ %>
			<option value="<%=i %>">
			<% for(int k=i;k>0;k--){out.print("☆");} %>
			</option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td>
			<input type="text" name="customer.address" id="address" maxlength="100"  />
			<span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td>
			<input type="text" name="customer.postcode" id="postcode"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input type="text" name="customer.phone" id="phone"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>传真</th>
		<td>
			<input type="text" name="customer.fax" id="fax"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input type="text" name="customer.website" id="website"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td>
			<input type="text" name="customer.bussinesscode" id="bussinesscode"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>法人</th>
		<td>
			<input type="text" name="customer.legalperson" id="legalperson"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input type="text" name="customer.regsmoney" id="regsmoney"  maxlength="25" />
		</td>
		<th>年营业额</th>
		<td>
			<input type="text" name="customer.bussinessmoney" id="bussinessmoney"  maxlength="25" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input type="text" name="customer.regbank" id="regbank"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td>
			<input type="text" name="customer.bankaccount" id="bankaccount"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input type="text" name="customer.landtaxcode" id="landtaxcode"  maxlength="25" />
		</td>
		<th>国税登记号</th>
		<td>
			<input type="text" name="customer.nationaltaxcode" id="nationtaxcode"  maxlength="25" />
		</td>
	</tr>
</table>
<p>　</p>
</form>
</body>
</html>