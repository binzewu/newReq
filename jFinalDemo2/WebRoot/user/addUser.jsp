<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addUser.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<div>
	    <form action="${contextPath}/user/addUser" method="post">
	    	<li>
	    		<label>用户名:</label>
	    		<input type="text" name="user.user_name">
	    	</li>
	    	<li>
	    		<label>密码:</label>
	    		<input type="text" name="user.user_passwd">
	    	</li>
	    	<li>
	    		<label>邮箱:</label>
	    		<input type="text" name="user.user_email">
	    	</li>
	    	<input type="submit" value="提交">
	    </form>
  	</div>
  </body>
</html>
