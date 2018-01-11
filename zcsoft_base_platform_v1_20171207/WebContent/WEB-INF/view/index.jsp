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
<%@ include file="/public/common.jsp"%>	
</head>
<body  class="no-skin" style="overflow: auto;">
   <!-- header  开始 -->
     <div id="navbar" class="navbar navbar-default"></div>
   <!-- header  结束 -->
   <!-- main-container  开始-->
   	<div class="main-container" id="main-container">
   	  <!-- left menu  开始 -->
   	     <div id="sidebar" class="sidebar responsive"></div>
   	  <!-- left menu  结束 -->
   	  <!-- main content 开始 -->
   	     <div id="main-content" class="main-content">
   	       <!-- main content 导航 开始 -->
   	     	<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i>
							<a href="javasrcipt:void(0);" url="main.do">工作台</a>
						</li>
						<!--    
							<li>
								<a href="javascript:void(0)">表格</a>
							</li>
							<li>
								<a href="javascript:void(0)">简单通用表格</a>
							</li>
						 -->
					</ul> 
			 </div>
		   <!-- main content 导航 结束 -->
		   <div id="page-content" class="page-content" style="overflow: auto;"></div>
   	     </div>
   	  <!-- main content 结束 -->
   	  <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	  </a>
   	</div>
    <!-- main-container  结束-->
</body>
<script type="text/javascript">
	$(function(){
	    $("#navbar").load(utils.topPath,
	    		function(responseTxt,statusTxt,xhr){
				 if(statusTxt=='success'){//加载头部
					 $("#sidebar").load(utils.leftPath,function(responseTxt,statusTxt,xhr){//加载左侧菜单
						   if(statusTxt=='success'){
							   $("#page-content").load(utils.mainPath); 
						   }
					   });
			 	}
		});
		$('.breadcrumb  li a').each(function(){
			 $(this).click(function(){
				 $("#page-content").load(webPath+'/'+$(this).attr('url')); 
			 })
			 
		})
	})
</script>
</html>