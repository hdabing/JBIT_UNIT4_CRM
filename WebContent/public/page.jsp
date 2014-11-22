<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/common.js"></script>
<script type="text/javascript">
	function check(){
		var pagesize=document.getElementById("pagesize").value;
		var trunpage=document.getElementById("trunpage").value;
		var action=document.getElementById("action").value;
		if(isEmpty('pagesize')==false){
			alert("每页条数不能为空");
			return false;
		}
		if(isEmpty('trunpage')==false){
			alert("跳转页数不能为空");
			return false;
		}
		if(isNumber('pagesize')==false){
			alert("每页条数非法");
			return false;
		}
		if(isNumber('trunpage')==false){
			alert("跳转页数非法");
			return false;
		}

		location.href=action+'?page='+trunpage+"&pagesize="+pagesize;
	}
</script>
</head>
<body>
	共<s:property value="pagebean.totalResult"/>条记录
	每页<input type="text" id="pagesize" value=<s:property value="pagebean.pageSize" /> size="2" />条
	第<input type="text" value=<s:property value="pagebean.currentPage" /> size="2"/>页/
	共<s:property value="pagebean.totalPage"/>页
	<a href='<s:property value="pagebean.action" />?page=1'>第一页</a>
	
	<s:if test="pagebean.hasPreviousPage==true">
	<a href='<s:property value="pagebean.action" />?page=<s:property value="pagebean.currentPage-1" />'>上一页</a>
	</s:if>
	<s:else>
	<a href='<s:property value="pagebean.action" />?page=<s:property value="1" />'>上一页</a>
	</s:else>
	
	
	<s:if test="pagebean.hasNextPage==true">
	<a href='<s:property value="pagebean.action" />?page=<s:property value="pagebean.currentPage+1" />'>下一页</a>
	</s:if>
	<s:elseif test="pagebean.currentPage==pagebean.totalPage">
	<a href='<s:property value="pagebean.action" />?page=<s:property value="pagebean.totalPage" />'>下一页</a>
	</s:elseif>
	<s:else>
	<a href='<s:property value="pagebean.action" />?page=<s:property value="1" />'>下一页</a>
	</s:else>
	
	<a href='<s:property value="pagebean.action" />?page=<s:property value="pagebean.totalPage" />' >最后一页</a>
	
	转到<input type="text" id="trunpage" value="1" size="2" />页
	<input type="hidden" id="action" value=<s:property value='pagebean.action' /> />
	<button width="20" onclick='check();'>GO</button>
</body>
</html>