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
.STYLE1 {font-size: 12px}
.STYLE2 {
	font-size: 16px;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="showUserInfo.action">
  <table width="238" height="34" border="0" align="center">
   <tr>
      <td height="28" colspan="2" ><div align="center" class="STYLE2">添加成功</div></td>
      </td>
    </tr>
    <tr>
      <td width="107" height="28" ><div align="center">
        <input type="button" name="Submit" value="继续添加"  onclick="window.location.href= 'add.jsp ' "/>
      </div></td>
      <td width="115"><div align="center">
        <div align="center"> 
        <input type="submit" name="Submit" value="返回首页" onclick="javascript:window.location.href='http://localhost:8080/Demo/showUserInfo.action';return false;" /> 
      </div>
      </div></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</form>
</body>
</html>
