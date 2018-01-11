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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/ztree/css/zTreeStyle/metro.css" />
<script src="${pageContext.request.contextPath }/static/js/ztree/js/jquery.ztree.all-3.5.min.js"></script>
</head>
<body> 
   <div class="row">
		<div class="col-sm-3">
			<div class="widget-box widget-color-blue">
					<div class="widget-header">
						<h4 class="widget-title lighter smaller">菜单树</h4>
					</div>

					<div class="widget-body">
						<div class="widget-main padding-8">
								<div id="tree">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
						</div>
					</div>
		  </div>
	  </div>
 
	<div class="col-sm-9">
	<div class="table-header">菜单管理</div>
	<table width="100%" class="CSSearchTbl" cellpadding="0" cellspacing="0">
				                                <tr>
				                                	<td> 菜单名称：<input type="text" class="form-control" name="menuname"   id="menuname"  value="${obj.name}"  style="width: 200px; display:inline;" />
				                                	</td>
				                                	<td >
														<button class="btn btn-success btn-round" type="button" onclick="query();"><i class="ace-icon fa fa-search">查询</i></button>
														<button class="btn btn-danger btn-round" type="button"  id="addButton" onclick="showAddModal();"><i class="ace-icon fa fa-plus">添加</i></button>
				                                    </td>
				                                </tr>
	</table>
				
							<div class="table-responsive">
											<table id="sample-table-2" class="table table-bordered table-striped">
												<thead>
													<tr>
													   <td>编号</td>
				                                       <td>菜单名称</td>
				                                       <td>代码</td>
				                                       <td>菜单链接</td>
				                                       <td>菜单图标</td>
				                                       <td>类型</td>
				                                       <td>操作</td>
													</tr>
												</thead>
												<tbody>
											
												<c:forEach items="${page}" var="menu" varStatus="status">
													<tr>
															<td>${status.count}</td>
					                                        <td>${menu.name}</td>
					                                        <td>${menu.percode}</td>
					                                        <td>${menu.url}</td>
					                                        <td><i class="${menu.icon}"></i></td>
					                                        <td>
					                                        	 
																<c:if test="${menu.type=='menu'}">菜单</c:if>
																<c:if test="${menu.type=='permission'}"><font  style="color: red;">按钮</font></c:if>
															</td>
															<td>
																<div class="hidden-sm hidden-xs btn-group">
																	<button class="btn btn-xs btn-info btn-round" onclick="showMenuModifyModal('${menu.id}');">
																		<i class="ace-icon fa fa-pencil bigger-120" title="修改"></i>
																	</button>
	
																	<button class="btn btn-xs btn-danger btn-round" onclick="delMenu('${menu.id}');">
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
   <div class="modal fade" id="myModal" tabindex="-1"   ></div>	 
</body>
<script type="text/javascript">
var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "level"
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: function(event, treeId, treeNode){
				if(treeNode.id=='-1')
					utils.loadDivContent('menu/pageQuery.do?parentid=',$("#page-content"));  //加载主页面div
				else
					utils.loadDivContent('menu/pageQuery.do?parentid='+treeNode.id,$("#page-content")); 
			}
		}
	};
	$(function(){
		//加载菜单树
		 $.ajax({
	    		 url:webPath+'/menu/getSysPermissionTree.do',
	    		 type:"get",
		   		 success:function(data){
		   			   if(data!=null){
		   				  var arr={"id":"-1","pId":"","name":"菜单树","open":true};
		   				      data.push(arr);
		   				      data=JSON.stringify(data);
		   				  var treeObj=  $.fn.zTree.init($("#treeDemo"), setting, JSON.parse(data));
		   				   	  treeObj.expandAll(true); 
		   				   	var parentId='${obj.parentid}';
		   				   	if(parentId!='')
		   				  	 treeObj.checkNode(treeObj.getNodeByParam("id", parentId, null), true, false);
		   				   	  
		   			   } 
		   				   
		   		   },
		   		   error:function(){
		   			 utils.toast('发生未知错误');
		   		   }
	    		 
	    	 })
	})
	function showAddModal(){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/menu/add.do",
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
	}
	function closePModal(){
		 $('#myModal').modal('hide');//关闭modal
		 $('#modal').removeData(); //清除modal缓存数据
		 $(".modal-backdrop").addClass("modalclose");
		 utils.loadDivContent('menu/pageQuery.do',$("#page-content"));  //加载主页面div
	}
	function query(){
		utils.loading('数据加载中.......');
		var menuname=encodeURI(encodeURI($("#menuname").val()));
		 $("#page-content").load(webPath+'/menu/pageQuery.do?name='+menuname,function(responseTxt,statusTxt,xhr){
			   if(statusTxt=='success'){
				   utils.closeLoading();
			   }else{
				   utils.closeLoading();
				   $("#page-content").load(webPath+'/'+'public/404.jsp');
			   }
			   
		   }); 
		 
	}	
  function showMenuModifyModal(id){
	  $('#myModal').removeData(); //清除modal缓存数据
	  $("#myModal").modal({
		    remote:webPath+"/menu/modify.do?id="+id,
		    backdrop:'static'//禁用点击空白处关闭modal框
		}); 
  }
  function delMenu(menuoid){
	  utils.confirm('确认删除?',function(){
			$.ajax({
				 url:webPath+'/menu/del.do?id='+menuoid,
				 type:"get",
		   		 success:function(data){
		   			   if(data.code==0){
		   					utils.toast('操作成功');
		   				    utils.loadDivContent('menu/pageQuery.do',$("#page-content"));  //加载主页面div
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