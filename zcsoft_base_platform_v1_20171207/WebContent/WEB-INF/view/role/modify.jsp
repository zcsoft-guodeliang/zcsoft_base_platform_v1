<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>::::::南安市机械装备产业科技创新服务中心入驻单位工作绩效管理系统::::::</title>
<meta name="description" content="This is page-header (.page-header &gt; h1)" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/js/ztree/css/zTreeStyle/metro.css" />
<script src="${pageContext.request.contextPath }/static/js/ztree/js/jquery.ztree.all-3.5.min.js"></script>

</head>
<body>
<div class="modal-dialog" role="document">  
        <div class="modal-content"> 
        <form class="form-horizontal " id="form" method="post" action="list.do"> 
             <div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="white">&times;</span></button>
						修改角色
					</div>
		      </div>
            <div class="modal-body">  
                	<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right">角色名称:</label>
												<div class="col-xs-12 col-sm-9">
													<div class="input_control clearfix">
													    <input type="hidden" name="id" id="id" value="${role.id}"/>
													     <input type="hidden" name="menuoids" id="menuoids" />
														<input type="text"   name="name" id="name" value="${role.name}" class="col-xs-12 col-sm-6" placeholder="输入角色名称">
													 </div>
												 </div>
															 
								 </div>
						 
								<div class="space-2"></div>
								<div class="form-group">
									<label class="control-label col-xs-12 col-sm-3 no-padding-right">菜单树:</label>
										<div class="col-xs-12 col-sm-9">
											<div class="clearfix">
													 <ul id="treeDemo" class="ztree"></ul>
											</div>
										 </div>
								</div>
							</div> 
						</div> 
            </div> 
            <div class="modal-footer">  
                <button type="button" id="btn-save"   class="btn btn-success btn-round"><i class="ace-icon fa fa-save"></i>修改</button>
				<button type="reset" class="btn btn-danger btn-round" id="btn-reset"><i class="ace-icon fa fa-repeat"></i>重置</button>
            </div> 
          </form>   
        </div> 
    </div>
</body>
<script type="text/javascript">
var setting = {
		check: {
			enable: true,
			chkStyle: "checkbox",
			radioType: "level"
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	
$(function() {
	//加载菜单树
	 $.ajax({
   		 url:webPath+'/menu/getSysPermissionTree.do',
   		 type:"get",
	   		 success:function(data){
	   			   if(data!=null){
	   				  var arr={"id":"-1","pId":"","name":"菜单树","open":true};
	   				      data.push(arr);
	   				      data=JSON.stringify(data);
	   				  var treeObj=$.fn.zTree.init($("#treeDemo"), setting, JSON.parse(data));
	   				   '<c:forEach items="${role.permissions}" var="permission" >'
            				 treeObj.checkNode(treeObj.getNodeByParam("id", '${permission.permissionId}', null), true, false);
            			'</c:forEach>'
	   			   } 
	   				   
	   		   },
	   		   error:function(){
	   			 utils.toast('发生未知错误');
	   		   }
   		 
   	 })
    //表单验证
    $("#form").validate({
        rules: {
        	name: {
                required: true
            }
        },
        messages: {
        	name: {
                required: "请输入角色名称" 
            } 
        }
    });
    $('#btn-save').on('click',function(e){
    	 var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		 var nodes = treeObj.getCheckedNodes(true);
		 var bol= $("#form").valid();
		 if(nodes.length>0){
			 for(var i in nodes){
				 if($("#menuoids").val()!='')
				  	$("#menuoids").val($("#menuoids").val()+','+nodes[i].id);
				 else
					 $("#menuoids").val(nodes[i].id); 
			 }
			 
			 if(bol){
				 var fieldArray = $('#form').serializeArray();  
		    	 var json=utils.fromToJson(fieldArray);
		    	 $.ajax({
		    		 url:webPath+'/role/update.do',
		    		 type:"post",
			   		 contentType:'application/json;charset=utf-8',//已json格式提交数据
			   		   //数据格式是json
			   		   data:JSON.stringify(json),
			   		   success:function(data){
			   			 if(data.code==0){
			   					utils.toast('操作成功');
			   					window.parent.closePModal();//关闭modal
			   			   }else if(data.code==-1){
			   					utils.toast('操作失败:'+data.errMsg);
			   			   }else
			   				utils.toast('操作失败');
			   				   
			   		   },
			   		   error:function(){
			   			 utils.toast('发生未知错误');
			   		   }
		    		 
		    	 })
			}
		 }else{
			  utils.alertErr("请选择菜单");
			 return ;
		 }
			 
	})
} );	
			
			
	 
	
</script>
 
</html>