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
											角色管理
										</div>
										<table width="100%" class="CSSearchTbl" cellpadding="0" cellspacing="0">
				                                <tr>
				                                	<td >
														<button type="button" onclick="showRoleAddModal();" class="btn btn-info btn-round" id="btn-add"><i class="ace-icon fa fa-pencil"></i>添加角色</button>
				                                    </td>
				                                </tr>
				                            </table> 
										<div class="table-responsive">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>编号</th>
				                                        <th>角色名称</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
											
												<c:forEach items="${page}" var="role" varStatus="status">
													<tr>
															<td>${status.count}</td>
					                                        <td>${role.name}</td>
															<td>
																<div class="hidden-sm hidden-xs btn-group">
																	<button class="btn btn-xs btn-info" onclick="showRoleModifyModal('${role.id}');">
																		<i class="ace-icon fa fa-pencil bigger-120" title="修改"></i>
																	</button>
	
																	<button class="btn btn-xs btn-danger" onclick="delRole('${role.id}');">
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
 
function showRoleAddModal(){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/role/add.do",
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
}
function showRoleModifyModal(roleId){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/role/modify.do?roleId="+roleId,
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
}
function closePModal(){
	 $('#myModal').modal('hide');//关闭modal
	 $('#modal').removeData(); //清除modal缓存数据
	 $(".modal-backdrop").addClass("modalclose");
	 utils.loadDivContent('role/pageQuery.do',$("#page-content"));  //加载主页面div
}

function delRole(oid){
	utils.confirm('确认删除?',function(){
		$.ajax({
			 url:webPath+'/role/del.do?roleId='+oid,
			 type:"get",
	   		 success:function(data){
	   		   if(data.code==0){
  					utils.toast('操作成功');
  				    utils.loadDivContent('role/pageQuery.do',$("#page-content"));  //加载主页面div
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