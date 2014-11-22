function reload(){
	window.location.reload();
}
function help(msg){
	alert('欢迎使用'+msg);
}

function to(url){
	window.location.href=url;
}
function back(){
	history.go(-1);
}
function save(url){
	alert('保存成功！');
	to(url);
}
function add(url){
	alert('新建成功！');
	to(url);
}
function del(msg){
	if (window.confirm("确认删除"+msg+"？")){
		reload();
	}
}

function setCurTime(oid){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth();
	var day=now.getDate();
	var hours=now.getHours();
	var minutes=now.getMinutes();
	var seconds=now.getSeconds();
	month=month+1;
	var timeString = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	var oCtl = document.getElementById(oid);
	oCtl.value = timeString;
}

//检测控件内容是否为空，不为空返回true，为空返回false
function isEmpty(inputId){
	var checkid=document.getElementById(inputId).value;
	if(checkid.length==0){
		return false;
	}
	return true;
}

//检测两个控件的值是否相等，相等返回true，否则返回false
function isEquals(input1,input2){
	var check1=document.getElementById(input1).value;
	var check2=document.getElementById(input2).value;
	
	if(check1==check2){
		return true;
	}
	return false;
}

//询问回答,点击确定则返回true，否则返回false
function isOperator(msg){
	if(confirm(msg)==true){
		return true;
	}
	return false;
}

//检测输入是否为数字，为数字返回true，否则返回false
function isNumber(input1){
	var reg_l=document.getElementById(input1).value;
	sl=reg_l.search(/[^\d.]/g);
	if(sl==-1)
	{
		return true;
	}
	
	return false;
}


//检测字符串长度是否超出     如果输入框输入字符超出预定的长度，则返回true，否则返回false
function isLargelength(input1,strlen){
	var inputid=document.getElementById(input1).value;
	if(inputid.length>strlen){
		return true;
	}
	return false;
}

//手机号码验证
function isTelephone(input1){
	var sMobile = document.getElementById(input1).value;
	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))){
		return false;
	}
	if(!(sMobile.length==11)){
		return false;
	}
	return true;
}


//电话号码验证
function isPhone(input1){
	var InputValue=document.getElementById(input1).value;
	var reg=/^([0-9]|[-])+$/g;
	var isValid;
	
	isValid=reg.exec(InputValue);
	if(!isValid){
		return false;
	}
	return true;
}

//检测网址
function isUrl(input1)
{
var urlreg=/^[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
var url=document.getElementById(input1).value;
if(!urlreg.test(url)){
   return false;
  }
  return true;
}