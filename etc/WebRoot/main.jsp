<%@ page language="java" import="java.util.*,org.model.Userinfo,org.model.Feature" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>毕业设计</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/Chart.js/2.5.0/Chart.js"></script>
	<script src="http://cdn.static.runoob.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		var msg="<s:property value="msg"/>";
		if(msg!=""){
			alert(msg);
		}
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
 		 $(".test").click(function(){
   			 $(".test").css("color","black");
   			 $(".testcontent").css("color","black");
  	});
	});
	$(document).ready(function(){
 		 $("#tmp1head").click(function(){
   			 $(this).css("color","#CC6633");
   			 $("#tmp1content").css("color","#CC6633");
			 document.getElementById("modelName").innerHTML="卡方检验";
			 document.getElementById("modelT").value="ST";
  	});
	});
	$(document).ready(function(){
 		 $("#tmp2head").click(function(){
   			 $(this).css("color","#CC6633");
   			 $("#tmp2content").css("color","#CC6633");
   			 document.getElementById("modelName").innerHTML="互信息";
   			 document.getElementById("modelT").value="MT";
  	});
	});
	$(document).ready(function(){
 		 $("#tmp3head").click(function(){
   			 $(this).css("color","#CC6633");
   			 $("#tmp3content").css("color","#CC6633");
   			 document.getElementById("modelName").innerHTML="Fisher方法";
   			 document.getElementById("modelT").value="FT";
  	});
	});
	</script>
	<%
		Userinfo user=(Userinfo)session.getAttribute("user");
		if(null == user){
			response.sendRedirect("login.jsp");
    		return;
		}
	%>
	</head>
	<body style="background-color:#EEEEEE;" >
	  <nav class="navbar navbar-default navbar-static-top" style="background-color:#EEEEEE;">
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
	  <div class="container theme-showcase" role="main" >
		<div class="jumbotron" style="background-image:url('main.jpg');background-size: cover; -moz-background-size: cover;height:350px;">
			<div style="color:#FFF"><h1>Feature Select</h1></div> 
			<div style="color:#FFF"><p>点击下面的按钮，上传你的文件</p><p>右边的按钮将引导你查看你的操作结果</p></div>
			<form action="upload" method="post" enctype="multipart/form-data">
				<div style="color:#FFF"><p><input type="file" id="InputFile" accept="text/*" name="fileInput.file"></input></p></div>
				<p><button class="btn btn-primary btn-lg" type="submit">确认上传</button>
			</form>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a style="color:#000" href="openspace.action">查看个人空间</a></h3>
						<p>点击这里查看你保存的特征记录和保存的数据文件</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-file" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a style="color:#000" href="savedata.action">保存数据文件</a></h3>
						<p>将你上传的文件保存到你的个人空间中，以便你后续查看。你的文件将被妥善保存，并对其余用户不可见。</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a style="color:#000" href="savefeature.action">保存特征文件</a></h3>
						<p class="testcontent">你此时生成的特征将被保存到你的个人空间中，以便你后续查看。你的文件将被妥善保存，并对其余用户不可见。</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-align-center" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a class="test" id="tmp1head" style="color:#000" href="javascript:void(0)">卡方检验</a></h3>
						<p><a id="tmp1content" class="testcontent" href="ST/index.html" style="color:#000">运用卡方检验，进行特征选择，查看关于卡方检验的更多信息请点击这里</a></p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-align-right" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a class="test" id="tmp2head" style="color:#000" href="javascript:void(0)">互信息</a></h3>
						<p><a id="tmp2content" class="testcontent" href="MT/index.html" style="color:#000">运用互信息方法，进行特征选择，查看互信息方法的更多信息请点击这里</a></p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4">
				<div class="media">
					<div class="media-object media-left wow fadeIn">
						<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
					</div>
					<div class="media-body wow fadeIn">
						<h3 class="media-heading"><a class="test" id="tmp3head" style="color:#000" href="javascript:void(0)">Fisher</a></h3>
						<p><a id="tmp3content" class="testcontent" href="FT/index.html" style="color:#000">运用Fisher方法，进行特征选择，查看Fisher方法的更多信息请点击这里</a></p>
					</div>
				</div>
			</div>
		</div>
		<div class="page-header">
			<h1>打开的文件</h1>
			<div class="well" style="height:200px; overflow:auto;" >
				<s:if test="#session.file!=null">
					<p><strong><s:property value="#session.file.getFileName()"/></strong></p>
				  	<p><s:property value="#session.file.OpenFile()" escape="false"/></p>
				</s:if>
				<s:else>
				  	<p><strong>你选取的数据将会显示在这里</strong></p>
				</s:else>
			</div>
			<form action="start" method="post">
				<div class="text-right">
					<span style="font-size:20px">您选取的方法是：<strong><label id="modelName"></label></strong></span>
					<input type="hidden" id="modelT" name="modelTag"/>
					<button class="btn btn-primary btn-lg" type="submit">开始特征选择</button>
				</div>
			</form>
		</div>
		<div class="page-header">
			<h1>分析结果</h1>
			<s:if test="#session.flist!=null">
		    	<s:set name="flist" value="#session.flist" />
		    		<script>
		    			var fnamelist=[];
						var fposlist=[];
						var fneglist=[];
						var fvaluelist=[];
						var bgbarposlist=[];
						var bgbarneglist=[];
						var bgpielist=[];
				        var randomScalingFactor_255 = function(){ return Math.round(Math.random()*255)};
		    		<%
		    			ArrayList<Feature> flist=(ArrayList<Feature>)request.getAttribute("flist");
		    			int pp=flist.size()/10;
		    			if(pp>15){	pp=15;	}
						for(int i=0;i<pp;i++){%>
							fnamelist.push("<%=flist.get(i).getName() %>" );
							fposlist.push("<%=flist.get(i).getPosFeq() %>" );
							fneglist.push("<%=flist.get(i).getNegFeq() %>" );
							fvaluelist.push("<%=flist.get(i).getValue() %>" );
							bgbarposlist.push('rgba(0,153,0,0.6)');
							bgbarneglist.push('rgba(153,0,0,0.3)');
							bgpielist.push("rgba(" + randomScalingFactor_255() + "," + randomScalingFactor_255() + "," + randomScalingFactor_255() + ",0.6)");
					<%}%>
					</script>
		    		<div class="row">
						<div class="col-md-6">
							<canvas id="myChartBar" width="200" height="200"></canvas>
							<script>
								var ctxBar = document.getElementById("myChartBar");
								var myChartBar = new Chart(ctxBar,{
								    type: 'bar',
								    data: {
								        labels : fnamelist,
										datasets : [
											{
												label: "积极",
												backgroundColor:bgbarposlist,
												data : fposlist,
											},
											{
												label: "消极",
												backgroundColor: bgbarneglist,
												data : fneglist
											}
										]
								    },
								    options: {
								        title: {
								            display: true,
								            text: '词频统计'
								        },
								    }
								});
								</script>
						</div>
						<div class="col-md-6">
							<canvas id="myChartPie" width="200" height="200"></canvas>
							<script>
								var ctxPie = document.getElementById("myChartPie");
								var myChartPie = new Chart(ctxPie,{
								    type: 'pie',
								    data: {
								        labels : fnamelist,
										datasets : [
											{
												label: "相关值",
												backgroundColor:bgpielist,
												data : fvaluelist,
											},
										]
								    },
								    options: {
								        title: {
								            display: true,
								            text: '相关值统计'
								        }
								    }
								});
								</script>
						</div>
					</div>
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
			    </s:if>
			<s:else>
				<div class="alert alert-info" role="alert"><strong>您还没有选择方法进行分析！</strong></div>
			</s:else>
		</div>
	  </div>
	</body>
</html>
