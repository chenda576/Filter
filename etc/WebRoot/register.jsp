<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.js"></script>
	<script type="text/javascript">
		var msg="<s:property value="msg"/>";
		if(msg!=""){
			alert(msg);
		}
	</script>
  </head>
  
  <body>
	<div id="loginModal" class="modal show">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="text-center text-primary">注册</h1>
	      </div>
	      <div class="modal-body">
	        <form action="register" class="form col-md-12 center-block" onsubmit="return validateform()">
	          <div class="form-group">
	            <input type="text" id="nickname" class="form-control input-lg" placeholder="昵称" name="user.username">
	          </div>
	          <div class="form-group">
	            <input type="text" id="email" name="user.email" class="form-control input-lg" placeholder="电子邮件">
	          </div>
	          <div class="form-group">
	            <input type="password" id="password" class="form-control input-lg" placeholder="登录密码" name="user.password">
	          </div>
	          <div class="form-group">
	            <input type="password" id="repassword" class="form-control input-lg" placeholder="确认密码">
	          </div>
	          <div class="form-group">
	            <button class="btn btn-primary btn-lg btn-block" type="submit">立刻注册</button>
	            <span><a href="login.jsp" class="pull-right">已有账号？登陆</a></span>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	      </div>
	    </div>
	  </div>
	</div>
  </body>
</html>