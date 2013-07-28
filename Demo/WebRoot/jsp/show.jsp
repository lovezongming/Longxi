<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<title>demo</title>
<SCRIPT LANGUAGE="JavaScript" src="js/jquery-1.4.2.min.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
<!--

$(document).ready(function(){
//demo1:
   //-隔行,滑动,点击 变色
 $('.cssraindemo1 tbody tr:even').addClass('odd');
 $('.cssraindemo1 tbody tr').hover(
  function() {$(this).addClass('highlight');},
  function() {$(this).removeClass('highlight');}
 );
 $('.cssraindemo1 tbody tr').click(
  function() {$(this).toggleClass('selected');}
 );

//demo2:
 $('.cssraindemo2 tbody tr:even').addClass('odd');
 $('.cssraindemo2 tbody tr').hover(
  function() {$(this).addClass('highlight');},
  function() {$(this).removeClass('highlight');}
 );

     // 如果复选框默认情况下是选择的，变色.
 $('.cssraindemo2 input[type="checkbox"]:checked').parents('tr').addClass('selected');
 // 复选框
 $('.cssraindemo2 tbody tr').click(
  function() {
   if ($(this).hasClass('selected')) {
    $(this).removeClass('selected');
    $(this).find('input[type="checkbox"]').removeAttr('checked');
   } else {
    $(this).addClass('selected');
    $(this).find('input[type="checkbox"]').attr('checked','checked');
   }
  }
 );

//demo3:
 $('.cssraindemo3 tbody tr:even').addClass('odd');
 $('.cssraindemo3 tbody tr').hover(
  function() {$(this).addClass('highlight');},
  function() {$(this).removeClass('highlight');}
 );

 // 如果单选框默认情况下是选择的，变色.
 $('.cssraindemo3 input[type="radio"]:checked').parents('tr').addClass('selected');
 
 // 单选框
 $('.cssraindemo3 tbody tr').click(
  function() {
   $(this).siblings().removeClass('selected');
   $(this).addClass('selected');
   $(this).find('input[type="radio"]').attr('checked','checked');
  }
 );


});

 


//-->
</SCRIPT>
<script type="text/javascript">


function pageAtion(){
   document.pageActionA.submit();
}
function pageAtionB(){
   document.pageActionB.submit();
}
function pageAtionC(){
   document.pageActionC.submit();
}
function pageAtionD(){
   document.pageActionD.submit();
}
function delete1(sid){
if(confirm("确定要删除么？")){

document.location.href= "delUserInfo.action?sid="+sid ;
}
return false;

}






</script>
<script type="text/javascript">

 function del(){
			var ids=document.getElementsByName("list");
			
			var selected=false;
			for(var x=0;x<ids.length;x++){
				if(ids[x].checked){
					selected=true;
					break;
				}
			}
			
			if(!selected){
				alert("请选择一条记录!");
				return false;
			}
			
			
			if(confirm("您确定要删除此条信息吗？")){
				document.form1.action="deleteAll.action";
				document.form1.submit();
			}
		}
		
		
		function CheckAll(thisform){
	        for (var i=0;i<thisform.elements.length;i++){
	            var e = thisform.elements[i];
	            if (e.Name != "chkAll"&&e.disabled!=true)
	                e.checked = thisform.chkAll.checked;
	        }
	    }


  

</script>

<style type="text/css">
h1   { font:bold 20px/26px Arial;}
table  { border:0;border-collapse:collapse;}
td { font:normal 12px/17px Arial;padding:2px;width:100px;}
th   { font:bold 12px/17px Arial;text-align:left;padding:4px;border-bottom:1px solid #333;}
tr.odd  { background:#FFF3BF;}
tr.highlight { background:#6F4DFF;}
tr.selected  { background:#aaaaaa;color:#ffffff;}
</style>

 


<!-- demo1 -->
<h1>&nbsp;</h1>
<!-- demo2 -->
<form  name="form1" name="form1" method="post" action="">
<h1 align="center">深圳市***技术有限公司</h1><input type= "button" value="导出excel" onclick="javascript:window.location.href='http://localhost:8080/Demo/report.action'"/>
<table width="696" height="40" align="center" class="cssraindemo2">
<thead>
<tr>
 
 <td width="29" height="20"><input type="checkbox" name="chkAll" onclick="CheckAll(this.form)" value="checkbox" /></td>
 <th width="119">公司名称</th>
 <th width="119">员工姓名</th>
 <th width="119">联系方式</th>
 <th width="56">&nbsp;</th>
 <th width="56"><input type="button" name="" value="添加" onclick="javascript:window.location.href='http://localhost:8080/Demo/jsp/add.jsp'"/></th>
 <th width="53"><input type="button" name="" value="批量删除" onclick="del()"/></th>
 </th>
</tr>
</thead>
<tbody>
<s:iterator value="userInfoList">
<tr>
  
  <td height="20"><input type="checkbox" name="list" value="<s:property value="id" />"  /></td>
  <input type="hidden" name="111111111id" value="<s:property value="id" />" />
 <td><s:property value="companyName" /></td>
 <td><s:property value="userName" /></td>
 <td><s:property value="mobileNumber" /></td>
 <td></td>
 <td><a href="#" onclick="javascript:window.location.href='editorIn.action?sid=<s:property value="id" />';return false; "><img src="images/editor.png" alt="编辑" width="32" height="32" /></td></a>
 <td><a href="#" onclick="delete1(sid=<s:property value="id" />);"><img src="images/delete.png" alt="删除" width="32" height="32" /></td></a>
</tr>
 </s:iterator>
</tbody>
</table>

 </form>

<!-- demo3 -->
<form name="form2" id="form2" method="post" action="">
  <table width="400" height="37" align="center" class="cssraindemo2">
    <thead>
      <tr><td width="10">
         <s:property value="currentPage"/>/<s:property value="pages"/>页        </td>
        <s:if test="%{#request.first!=0}">
        <td width="10">
         <a href="javascript:void(0);" onclick="pageAtion();return false;" style="color: blue;">首页</a>        </td>
       </s:if>
       <s:else>
        <td width="10">首页</td>
       </s:else>
       
       <s:if test="%{#request.first!=0}">
        <td width="10">
         <a href="javascript:void(0);" onclick="pageAtionB();return false;" style="color: blue;">上一页</a>        </td>
       </s:if>
       <s:else>
        <td width="10">上一页</td>
       </s:else>
       <s:if test="%{#request.first!=#request.last}">
        <td width="10">
         <a href="javascript:void(0);" onclick="pageAtionC();return false;" style="color: blue;">下一页</a>        </td>
       </s:if>
       <s:else>
        <td width="10">下一页</td>
       </s:else>
       <s:if test="%{#request.first!=#request.last}">
        <td width="10">
         <a href="javascript:void(0);" onclick="pageAtionD();return false;" style="color: blue;">尾页</a>        </td>
       </s:if>
       <s:else>
        <td width="10" height="20">尾页</td>
       </s:else>
      </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
</form>

<form action="showUserInfo.action" name="pageActionA" method="post">
          <input type="hidden" name="mode" value="1"/>
          <s:hidden name="first"/></form>
   <form action="showUserInfo.action" name="pageActionB" method="post">
          <input type="hidden" name="mode" value="2"/>
          <s:hidden name="first"/></form>
  <form action="showUserInfo.action" name="pageActionC" method="post">
          <input type="hidden" name="mode" value="3"/>
          <s:hidden name="first"/></form>
  <form action="showUserInfo.action" name="pageActionD" method="post">
          <input type="hidden" name="mode" value="4"/>
          <s:hidden name="first"/>
         
        </form>
<h1>&nbsp;</h1>
