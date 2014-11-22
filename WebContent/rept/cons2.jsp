<%@ page import="java.util.List" language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
<% List listlevel=(List) request.getAttribute("listlevel"); %>
<div class="page_title">客户构成分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">关于</button>
	<button class="common_button" onclick="showimg();">统计图</button>
	<button class="common_button" onclick="location.href='downLoadCountlevel?filename=excelCountlevel.xls';">Excel</button>
	<button class="common_button" onclick="location.href='downLoadPDFCountlevel?filename=pdfCountlevel.pdf';">Pdf文件</button>
</div>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>等级</th>
		<th>客户数量</th>
	</tr>
<%if(listlevel!=null){for(int i=0;i<listlevel.size();i++){
	Object[] obj=(Object[])listlevel.get(i);	
%>
	<tr>
		<td class="list_data_number"><%=i+1 %></td>
		<td class="list_data_text"><%=obj[0] %></td>
		<td class="list_data_number"><%=obj[1] %></td>
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
	imagepath+="/cons.jpeg";
%>
<img id="img" src="<%=imagepath %>" width="0"/>
</div>
</body>
</html>