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
		var frm=document.FrmeditCustomerOK;
		
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
	Customer customer=(Customer) request.getAttribute("customer");
	List<Area> listarea=(List<Area>) request.getAttribute("listarea");
	List<Customerlevel> listcustomerlevel=(List<Customerlevel>) request.getAttribute("listcustomerlevel");
	List<Users> listusers=(List<Users>) request.getAttribute("listusers");
%>
<form name="FrmeditCustomerOK" action="editCustomerOK" method="POST">
<input type="hidden" name="customer.id" value="<%=customer.getId() %>" />
<div class="page_title">客户信息管理 &gt; 客户信息</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="location.href='listCustomercontact?id=<%=customer.getId() %>';">联系人</button>
	<button class="common_button" onclick="location.href='listRelationship?id=<%=customer.getId() %>';">交往记录</button>
	<button class="common_button" onclick="location.href='queryListorders?id=<%=customer.getId() %>';">历史订单</button>
	
	<button class="common_button" onclick="location.href='queryListcustomer';">返回</button>
	<button class="common_button" onclick="check();" >保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td>
			<input type="text" name="customer.name" id="name" value="<%=customer.getName() %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>客户编号</th>
		<td>
			<input type="text" name="customer.code" id="code" value="<%if(customer.getCode()!=null){out.print(customer.getCode());} %>"  maxlength="25" />
		</td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<select name="customer.areaid">
			<% for(Area area:listarea){ %>
				<option value="<%=area.getId() %>"
				<% if(area.getId()==customer.getAreaid()){ %>
					selected="selected"
				<%} %>
				><%=area.getName() %></option>
			<%} %>
			</select>
			<span class="red_star">*</span>
		</td>
		<th>负责人</th>
		<td>
			<input type="text" name="customer.managername" id="managername" value="<%=customer.getManagername() %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<select name="customer.levelid">
			<% for(Customerlevel customerlevel:listcustomerlevel){ %>
				<option value="<%=customerlevel.getId() %>" 
				<% if(customerlevel.getId()==customer.getLevelid()){ %>
					selected="selected"
				<%} %>
				><%=customerlevel.getName() %></option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="customer.creditlevel">
			<% for(int i=1;i<6;i++){ %>
			<option value="<%=i %>" 
			<% if(i==customer.getCreditlevel()){ %>
				selected="selected"
			<%} %>
			>
			<% for(int k=i;k>0;k--){out.print("☆");} %>
			</option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>		
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="customer.agreelevel">
			<% for(int i=1;i<6;i++){ %>
			<option value="<%=i %>" 
			<% if(i==customer.getAgreelevel()){ %>
				selected="selected"
			<%} %>
			>
			<% for(int k=i;k>0;k--){out.print("☆");} %>
			</option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
		<th></th>
		<td></td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td>
			<input type="text" name="customer.address" id="address" value="<%if(customer.getAddress()!=null){out.print(customer.getAddress());} %>"  maxlength="100"  />
			<span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td>
			<input type="text" name="customer.postcode" id="postcode" value="<%if(customer.getPostcode()!=null){out.print(customer.getPostcode());} %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input type="text" name="customer.phone" id="phone" value="<%=customer.getPhone() %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>传真</th>
		<td>
			<input type="text" name="customer.fax" id="fax" value="<%if(customer.getFax()!=null){out.print(customer.getFax());} %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input type="text" name="customer.website" id="website" value="<%if(customer.getWebsite()!=null){out.print(customer.getWebsite());} %>"  maxlength="25" />
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
			<input type="text" name="customer.bussinesscode" id="bussinesscode" value="<%if(customer.getBussinesscode()!=null){out.print(customer.getBussinesscode());} %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>法人</th>
		<td>
			<input type="text" name="customer.legalperson" id="legalperson" value="<%=customer.getLegalperson() %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input type="text" name="customer.regsmoney" id="regsmoney" value="<%=customer.getRegsmoney() %>"  maxlength="25" />
		</td>
		<th>年营业额</th>
		<td>
			<input type="text" name="customer.bussinessmoney" id="bussinessmoney" value="<%=customer.getBussinessmoney() %>"  maxlength="25" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input type="text" name="customer.regbank" id="regbank" value="<%if(customer.getRegbank()!=null){out.print(customer.getRegbank());} %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td>
			<input type="text" name="customer.bankaccount" id="bankaccount" value="<%if(customer.getBankaccount()!=null){out.print(customer.getBankaccount());} %>"  maxlength="25" />
			<span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input type="text" name="customer.landtaxcode" id="landtaxcode" value="<%if(customer.getLandtaxcode()!=null){out.print(customer.getLandtaxcode());} %>"  maxlength="25" />
		</td>
		<th>国税登记号</th>
		<td>
			<input type="text" name="customer.nationaltaxcode" id="nationtaxcode" value="<%if(customer.getNationaltaxcode()!=null){out.print(customer.getNationaltaxcode());} %>"  maxlength="25" />
		</td>
	</tr>
	<!-- 
		<th>客户经理</th>
		<td>
			<select name="customer.userid">
			<% for(Users user:listusers){ %>
				<option value="<%=user.getId() %>" 
				<% if(user.getId()==customer.getUserid()){ %>
					selected="selected"
				<%} %>
				><%=user.getUsername() %></option>
			<%} %>
			</select><span class="red_star">*</span>
		</td>
	 -->
</table>
<p>　</p>
</form>
</body>
</html>