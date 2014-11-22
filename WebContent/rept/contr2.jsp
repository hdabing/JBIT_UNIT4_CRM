<%@ page import="java.util.List,entity.Orders" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" >
	function showimg(){
		document.getElementById("img").setAttribute("width", 600);
	}
</script>
</head>
<body>
<%
	List listorders=(List) request.getAttribute("listorders");
%>
<div class="page_title">客户贡献分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="showimg();">统计图</button>
	<button class="common_button" onclick="location.href='downLoadContr?filename=excelContr.xls';">Excel</button>
	<button class="common_button" onclick="location.href='downLoadPDFContr?filename=pdfContr.pdf';">Pdf文件</button>
	<button class="common_button" onclick="document.FrmqueryContrbyform.submit();">查询</button> 
</div>
<form name="FrmqueryContrbyform" action="queryContrbyform" method="POST">
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input type="text" name="customer.name" /></td>
	</tr>
</table>
</form>
<br />
<%
	
%>
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>客户名称</th>
		<th>订单金额（元）</th>
	</tr>
<%
	if(listorders!=null){
		for(int i=0;i<listorders.size();i++){
			Object[] obj=(Object[]) listorders.get(i);
%>
	<tr>
		<td class="list_data_number"><%=i+1 %></td>
		<td class="list_data_ltext"><%=obj[0].toString() %></td>
		<td class="list_data_number"><%=obj[1].toString() %></td>
	</tr>
<%}} %>
	<tr>
		<th colspan="3" class="pager">
		<div class="pager">
			<s:include value="../public/page.jsp" >
				<s:param name="pagebean" value="pagebean" />
			</s:include>
		</div>
		</th>
	</tr>
</table>

<div align="center">
<%
	String requesturl=request.getRequestURL().toString();
	String imagepath=requesturl.substring(0, requesturl.lastIndexOf("/"));
	imagepath+="/contr.jpeg";
%>
<img id="img" src="<%=imagepath %>" width="0"/>
</div>
</body>
</html>