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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/ztree/css/zTreeStyle/metro.css" />
<script src="${pageContext.request.contextPath }/static/js/ztree/js/jquery.ztree.all-3.5.min.js"></script>

</head>
<body>
<div class="modal-dialog" role="document">  
<input type="hidden" value="${message}" id="errMsg"/>
        <div class="modal-content"> 
        <form class="form-horizontal " id="form" method="post" action="list.do"> 
             <div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="white">&times;</span></button>
						 错误提示 
					</div>
		      </div>
            <div class="modal-body">  
                	<div class="row">
							<div class="col-xs-12">
								<div class="form-group" style="font-weight: bold;font-size: red;color: red;" align="center">
									 ${message}
								 </div>
						  
							</div> 
						</div> 
            </div> 
          </form>   
        </div> 
    </div>
</body>
</html>