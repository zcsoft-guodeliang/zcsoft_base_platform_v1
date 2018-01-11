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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/login.css" />
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
</head>
<body class="modal-open">
 <div class="modal fade in" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: block;"><div style="display:table; width:100%; height:100%;">
	<div style="vertical-align:middle; display:table-cell;">
		<div class="modal-dialog modal-sm" style="width:540px;">
        <div class="modal-content">
            <div class="col-left"></div>
            <div class="col-right">
                <div class="modal-header">
                    <h4 class="modal-title" id="loginModalLabel" style="font-size: 18px;">登录</h4>
                </div>
                <div class="modal-body">
                        <form id="login_form" method="post" autocomplete="off" action="login.do">
                            <ul>
                                <li class="form-group"><input class="form-control" id="account" maxlength="50" name="usercode" placeholder="请输入登录账号" type="text"></li>
                                <li class="form-group"><input class="form-control" id="password" name="password" placeholder="请输入密码" type="password"></li>
                            </ul>
                        </form>
                        <div class="login-box marginB10">
                            <button id="login_btn" type="button" class="btn btn-micv5 btn-block globalLogin">登录</button>
                            <div id="login-form-tips" class="tips-error bg-danger" style="display: none;"></div>
                        </div>
                        
                </div>
            </div>
        </div>
    </div>
    </div>
   </div>
   </div>
    <div class="modal-backdrop fade in">
    	
    </div>
</body>
 <script type="text/javascript">
 var errMsg='${errMsg}';
 if(errMsg!='')
 	utils.alert('<font style="color: red;">${errMsg}</font>'+'<font style="color: red;">请重新注册！</font>');
 function login(){
		if($("#account").val()==''){
				document.getElementById('login-form-tips').innerHTML='<font color="red">*登录账号不能为空!</font>';
				$("#login-form-tips").show();
				return ;
			}
		if($("#password").val()==''){
			document.getElementById('login-form-tips').innerHTML='<font color="red">*密码不能为空!</font>';
			$("#login-form-tips").show();
				return ;
			}
		login_form.submit();
	 
 }
 	 $(function(){
   	 //回车事件
	   	document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	login(); 
		     }
		}
	 
 		$("#login_btn").on('click',function(){
 			login();
 		})
 		 
 	 })
 </script>
</html>