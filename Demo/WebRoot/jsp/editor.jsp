<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
}
.STYLE2 {font-size: 12px}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="editor.action">
  <table width="308" height="141" border="0" align="center">
    <tr>
      <td colspan="3"><div align="center" class="STYLE1">修改员工信息</div></td>
    </tr>
    <s:iterator value="userInfoList">
    <tr>
    <input type="hidden" name="sid" value="<s:property value="id" />"/>
      <td width="89"><div align="right" class="STYLE2">公司名称</div></td>
      <td width="168"><span class="STYLE2">
        <input type="text" name="companyName"  value="<s:property value="companyName" />"/>
      </span></td>
      <td width="37"><span class="STYLE2"></span></td>
    </tr>
    <tr>
      <td><div align="right" class="STYLE2">员工姓名</div></td>
      <td><span class="STYLE2">
        <input type="text" name="userName" value="<s:property value="userName" />" />
      </span></td>
      <td><span class="STYLE2"></span></td>
    </tr>
    <tr>
      <td><div align="right" class="STYLE2">联系电话</div></td>
      <td><span class="STYLE2">
        <input type="text" name="mobileNumber"  value="<s:property value="mobileNumber" />"/>
      </span></td>
      <td><span class="STYLE2"></span></td>
    </tr>
     </s:iterator>
    <tr>
      <td colspan="2">
      
           <div align="center">
             <input type="submit" name="Submit" value="提交" />  
             <input type="button" name="Submit2" value="取消" onclick="javascript:window.location.href='showUserInfo.action';return false;" />
       </div></td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</form>
</body>
</html>
