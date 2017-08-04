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
    <title>登录</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
	        <h1 class="text-center text-primary">登录</h1>
	      </div>
	      <div class="modal-body">
	        <form action="login" class="form col-md-12 center-block" method="post">
	          <div class="form-group">
	            <input type="text" class="form-control input-lg" placeholder="电子邮件" name="user.email">
	          </div>
	          <div class="form-group">
	            <input type="password" class="form-control input-lg" placeholder="登录密码" name="user.password">
	          </div>
	          <div class="form-group">
	            <button class="btn btn-primary btn-lg btn-block" type="submit">立刻登录</button>
	            <span><a href="#">找回密码</a></span>
	            <span><a href="register.jsp" class="pull-right">注册</a></span>
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
