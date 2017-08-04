<%@ page language="java" import="java.util.*,org.model.Userinfo,org.model.FileClass,org.model.Feature" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人空间</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/Chart.js/2.5.0/Chart.js"></script>
	<script src="https://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.js"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var msg="<s:property value="msg"/>";
		if(msg!=""){
			alert(msg);
		}
	</script>
	<%
		Userinfo user=(Userinfo)session.getAttribute("user");
		if(null == user){
			response.sendRedirect("login.jsp");
    		return;
		}
	%>
  </head>
  
  <body style="background-color:#EEEEEE;">
    <nav class="navbar navbar-default">
	    <div class="container-fluid">
	      <div class="navbar-header">
	        <a class="navbar-brand" href="#">GD</a>
	      </div>
	      <div class="collapse navbar-collapse" id="collapseFilter">
	        <ul class="nav navbar-nav">
	          <li class="active"><a href="main.jsp">主页<span class="sr-only"></span></a></li>
	          <li><a href="about/index.html">关于网站</a></li>
	        </ul>
	      </div><!-- /.navbar-collapse -->
	    </div><!-- /.container-fluid -->
	</nav>
	<div class="container theme-showcase" role="main">
		<div class="page-header">
	      <h1>数据文件</h1>
	    </div>
	    <s:if test="#request.dflist!=null">
	    	<s:set name="dflist" value="#request.dflist" />
	    	<div class="row">
	    		<s:iterator value="dflist" status="st">
	    			<div class="col-md-4">
			  			<div class="panel panel-primary">
							<div class="panel-heading">
							    <h3 class="panel-title"><s:property value="getFileName()"/></h3>
							</div>
							<div class="panel-body">
								<s:property value="openFileContent()" escape="false"/>
							</div>
							<div class="panel-footer">
								<form action="loadfile" method="get" enctype="multipart/form-data">
									<input type="hidden" name="file" value=<s:property value="getFile()"/> />
									<button class="btn btn-default" type="submit">特征选择</button>
								</form>
							</div>
						</div>
			  		</div>
	    		</s:iterator>
	    	</div>
	    </s:if>
	    <s:else>
	    	<div class="alert alert-info" role="alert">
	    		<strong>您暂时还没有数据文件！</strong><a href="main.jsp" class="alert-link">点击这里开始特征选择</a>
	    	</div>
	    </s:else>
		<div class="page-header">
	      <h1>结果文件</h1>
	    </div>
	    <s:if test="#request.rflist!=null">
	    	<s:set name="rflist" value="#request.rflist" />
	    	<div class="row">
	    		<s:iterator value="rflist" status="st">
	    			<s:set name="flist" value="openFileResultToFeature()"></s:set>
	    			<div class="col-md-6">
			  			<div class="panel panel-primary">
							<div class="panel-heading">
							    <h3 class="panel-title"><s:property value="getFileName()"/></h3>
							</div>
							<div class="panel-body">
					            <table class="table table-hover">
						        	<tr>
							        	<th>特征</th>
							            <th>特征值</th>
							           	<th>状态</th>
							           	<th>积极</th>
					                   	<th>消极</th>
						           	</tr>
					               	<s:iterator value="flist" status="st">
						    		<tr>
							   			<td><s:property value="name" /></td>
						  				<td><s:property value="value" /></td>
							    		<td>
								    	  <s:if test="posFeq>negFeq"><span class="label label-success">积极</span></s:if>
								   		  <s:else><span class="label label-warning">消极</span></s:else>
								   		</td>
								    	<td><s:property value="posFeq" /></td>
							    	 	<td><s:property value="negFeq" /></td>
									 </tr>
						   			 </s:iterator>
					              </table>
					        </div>
							<div class="panel-footer">
							  	<a class="btn btn-default" href="download.action?fname=<s:property value="getFileName()"/>">下载(有待发布后开发)</a>
							 </div>
						</div>
			  		</div>
	    		</s:iterator>
	    	</div>
	    </s:if>
	    <s:else>
	    	<div class="alert alert-info" role="alert">
	    		<strong>你暂时还没有可用的结果文件！</strong><a href="main.jsp" class="alert-link">点击这里开始特征选择</a>
	    	</div>
	    </s:else>
	</div>
 </body>
</html>
