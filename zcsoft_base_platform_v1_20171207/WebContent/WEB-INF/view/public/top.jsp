<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>::::::智蝉科技基础平台::::::</title>
<meta name="description" content="This is page-header (.page-header &gt; h1)" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
</head>
<body>
     <div class="navbar-container" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
					<span class="sr-only">Toggle sidebar</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="navbar-header pull-left">
					<a  class="navbar-brand">
						<small>
						 <img src="${pageContext.request.contextPath }/static/images/avatars/logo.png" alt=""/>
						 </small>
					</a>
				</div>
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo"  src="${pageContext.request.contextPath}/picByPathServlet?path=${activeUser.headImage}" />
								<span class="user-info">
									欢迎您<br />
									${activeUser.username}
								</span>
								<i class="ace-icon fa fa-caret-down"></i>
							</a>
							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li class="divider"></li>
								<li><a href="javascript:;;" id="workTab"><i class="ace-icon fa fa-desktop"></i>工作台</a></li>
								<li class="divider"></li>
								<li>
										<a href="javascript:;;" id="userinfo">
											<i class="ace-icon fa fa-user"></i>
											个人信息设置
										</a>
								</li>
								<li class="divider"></li>
								<li><a href="javascript:;;" id="logout"><i class="ace-icon fa fa-power-off"></i>登出</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div> 
</body>
<script type="text/javascript">
var outTimeMsg='${sessionScope.outTimeMsg}';
if(outTimeMsg!='')
	  utils.toast(outTimeMsg);
		$(function(){
			 $("#workTab").on('click',function(){
				 $("#page-content").load(webPath+'/main.do',function(responseTxt,statusTxt,xhr){
					   if(statusTxt=='success'){
						   utils.closeLoading();
					   }else{
						   utils.closeLoading();
						   $("#page-content").load(webPath+'/'+'public/404.jsp');
					   }
					   
				   });
				
			 })
			 $("#logout").on('click',function(){
				 utils.confirm('确认退出系统？',function(){
					 location.href="logout.do";
				 })
				
			 })
			 
			$("#userinfo").on('click',function(){
				 utils.loading('数据加载中.......');
				   $("#page-content").load(webPath+'/user/info.do',function(responseTxt,statusTxt,xhr){
					   if(statusTxt=='success'){
						   utils.closeLoading();
					   }else{
						   utils.closeLoading();
						   $("#page-content").load(webPath+'/'+'public/404.jsp');
					   }
					   
				   }); 
				
			 })
			 
		})
	
</script>
</html>