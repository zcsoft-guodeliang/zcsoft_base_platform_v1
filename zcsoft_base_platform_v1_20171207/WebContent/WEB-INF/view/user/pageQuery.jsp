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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/table.css" />
</head>
<body> 
		<div class="page-content-area">
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<div class="table-header">
											用户管理
										</div>
											<table width="100%" class="CSSearchTbl" cellpadding="0" cellspacing="0">
				                                <tr>
				                                    <td>真实姓名：<input type="text" class="form-control" name="username"   id="username" value="${obj.username}"  style="width: 200px; display:inline;" /></td>
				                                    <td>登录账号：<input type="text" class="form-control" name="code"  	   id="code" value="${obj.code}"  style="width: 200px; display:inline;"/></td>
				                                </tr>
				                                <tr>
				                                    <td colspan="4" align="center">
														<button type="button" class="btn btn-success btn-round" onclick="query();"><i class="ace-icon fa fa-search"></i>查        询</button>
														<button type="button" onclick="showUserAddModal();" class="btn btn-info btn-round" id="btn-add"><i class="ace-icon fa fa-pencil"></i>添加用户</button>
				                                  
				                                	</td>
				                                </tr>
				                            </table> 
			                            
										<div class="table-responsive">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>编号</th>
				                                        <th>真实姓名</th>
				                                        <th>登录姓名</th>
				                                        <th>用户类型</th>
				                                        <th>所属角色</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
											
												<c:forEach items="${page}" var="user" varStatus="status">
													<tr>
															<td>${status.count}</td>
					                                        <td>${user.username}</td>
					                                        <td>${user.code}</td>
					                                        <td>
					                                        	<c:if test="${user.userType==1}">管理员用户</c:if>
					                                        	<c:if test="${user.userType==2}">普通用户</c:if>
					                                        	<c:if test="${user.userType==3}">其他用户</c:if>
					                                        </td>
					                                        <td>
					                                        	<c:forEach items="${user.roles}" var="role" >
					                                        		${role.name};
					                                        	</c:forEach>
					                                        </td>
															<td>
																<div class="hidden-sm hidden-xs btn-group">
																	<button class="btn btn-xs btn-info" onclick="showUserModifyModal('${user.oid}');">
																		<i class="ace-icon fa fa-pencil bigger-120" title="修改"></i>
																	</button>
	
																	<button class="btn btn-xs btn-danger" onclick="delUser('${user.oid}');">
																		<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
																	</button>
	 
																</div>
															</td>
														</tr>
												</c:forEach>
													
												</tbody>
											</table>
										  <!-- 分页 -->
										 <%@ include file="/public/page.jsp"%>	
										</div>
									</div>
								</div>
							</div> 
						</div> 
					</div> 
	     <div class="modal fade" id="myModal" tabindex="-1"   ></div>	 
</body>
<script type="text/javascript">
 
function showUserAddModal(){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/user/add.do",
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
}
function showUserModifyModal(oid){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/user/modify.do?oid="+oid,
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
}
function closePModal(){
	 $('#myModal').modal('hide');//关闭modal
	 $('#modal').removeData(); //清除modal缓存数据
	 $(".modal-backdrop").addClass("modalclose");
	 utils.loadDivContent('user/pageQuery.do',$("#page-content"));  //加载主页面div
}
function query(){
	utils.loading('数据加载中.......');
	var username=encodeURI(encodeURI($("#username").val()));
	var code=encodeURI(encodeURI($("#code").val()));
	 $("#page-content").load(webPath+'/user/pageQuery.do?username='+username+'&code='+code,function(responseTxt,statusTxt,xhr){
		   if(statusTxt=='success'){
			   utils.closeLoading();
		   }else{
			   utils.closeLoading();
			   $("#page-content").load(webPath+'/'+'public/404.jsp');
		   }
		   
	   }); 
}

function delUser(oid){
	utils.confirm('确认删除?',function(){
		$.ajax({
			 url:webPath+'/user/del.do?oid='+oid,
			 type:"get",
	   		 success:function(data){
	   		  if(data.code==0){
 					utils.toast('操作成功');
 				    utils.loadDivContent('user/pageQuery.do',$("#page-content"));  //加载主页面div
 			   }else if(data.code==-1){
 					utils.toast('操作失败:'+data.errMsg);
 			   } else
 					utils.toast('删除失败');
	   		   },
	   		   error:function(){
	   			 utils.toast('发生未知错误');
	   		   }
			 
		 })
		
	})
}
 
	
</script>
 
</html>