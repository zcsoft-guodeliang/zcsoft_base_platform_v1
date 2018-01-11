<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>::::::系统注册::::::</title>
<meta name="description" content="This is page-header (.page-header &gt; h1)" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" />
<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath }/static/js/jquery.min.js'>"+"<"+"/script>");
		</script>
	<!-- <![endif]-->
	<!--[if IE]>
		<script type="text/javascript">
			 window.jQuery || document.write("<script src='${pageContext.request.contextPath }/static/js/jquery1x.min.js'>"+"<"+"/script>");
		</script>
	<![endif]-->
<script type="text/javascript">
		var webPath='${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath }/static/js/layer.js"></script>
<script src="${pageContext.request.contextPath }/static/js/utils.js"></script>
 <style type="text/css">
 .col-center-block {  
    float: none;  
    display: block;  
    margin-top:5%;
    margin-left: auto;  
    margin-right: auto;  
}  
 </style>
</head>
<body>
 <div class="container">  
    <div class="col-xs-9 col-md-6 col-center-block"> 
		 <form class="form-horizontal" id="form" name="form">
			  <div class="form-group col-center-block">
			    <label for="inputEmail3" class="col-sm-2 control-label">客户名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="customName"  name="customName" readonly="readonly" value="${config.value}"  placeholder="客户名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">机器码</label>
			    <div class="col-sm-10">
			      <input type="text" readonly="readonly"  class="form-control" id="serviceCode"  name="serviceCode"  value="${serial}"  placeholder="机器码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">注册码</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="4" id="registerCode"  name="registerCode" placeholder="注册码"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			     <button type="button" class="btn btn-success" style="width: 100px;" onclick="register();">注册</button>
			     <button type="reset" class="btn btn-danger" style="width: 100px;">重置</button>
			    </div>
		  	  </div>
		</form>
	 </div>
	</div>
</body>
 <script type="text/javascript">
 function register(){
	 if($('#customName').val().trim()==''){
		 utils.alert('请输入客户名称');
		 return ;
	 }
	 if($('#serviceCode').val().trim()==''){
		 utils.alert('请输入机器码');
		 return ;
	 }
	 if($('#registerCode').val().trim()==''){
		 utils.alert('请输入注册码');
		 return ;
	 }
	 var fieldArray = $('#form').serializeArray();  
	 var json=utils.fromToJson(fieldArray);
	 $.ajax({
		 url:webPath+'/register/register.do',
		 type:"post",
			 contentType:'application/json;charset=utf-8',//已json格式提交数据
			   //数据格式是json
			   data:JSON.stringify(json),
			   success:function(data){
				   if(data.code==0){
						utils.toast('操作成功');
				   }else if(data.code==-1){
						utils.toast('操作失败:'+data.errMsg);
				   }else{
					   console.log(data);
					   utils.toast('操作失败');
				   }
					
			   },
			   error:function(){
				 utils.toast('发生未知错误');
			   }
	 }) 
	 
 }

 </script>
</html>