<%@ page import="entity.Service" language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var frm=document.FrmeditServiceOK;
		
		if(isEmpty('name')==false){
			alert("服务类型不能为空");
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
<% Service service=(Service) request.getAttribute("service"); %>
<div class="page_title">服务类型管理&gt;编辑服务类型</div>
<form name="FrmeditServiceOK" action="editServiceOK" method="POST">
<input type="hidden" name="service.id" value="<%=service.getId() %>" />
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="check();">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>值</th>
		<td>
			<input type="text" name="service.name" id="name" value="<%=service.getName() %>" maxlength="25"/>
			<span class="red_star">*</span>
		</td>
	</tr>	
</table>
</form>
</body>
</html>