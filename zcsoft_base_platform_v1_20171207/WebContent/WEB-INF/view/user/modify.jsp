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
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/webuploader.css"/>
<script src="${pageContext.request.contextPath}/static/js/webuploader.js"></script>
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
						修改用户
					</div>
		      </div>
            <div class="modal-body">  
                	<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">用户姓名:</label>
												<div class="col-xs-12 col-sm-9">
																<div class="input_control clearfix">
																	<input type="hidden" id="roleoids" name="roleoids"/>
																	<input type="hidden" id="headImg" name="headImg" value="${user.headImg}"/>
																	<input type="hidden" id="oid" name="oid" value="${user.oid}"/>
																	<input type="text"   name="username" id="username" class="col-xs-12 col-sm-6" placeholder="输入用户姓名" value="${user.username}">
																</div>
													</div>
															<label class="control-label col-xs-12 col-sm-3 no-padding-right">性别</label>
															<div class="col-xs-12 col-sm-9">
																<div>
																	<label class="line-height-1">
																		<input name="userSex" value="1" type="radio" class="ace"  <c:if test="${user.userSex=='1'}">checked="checked"</c:if>>
																		<span class="lbl"> 男</span>
																	</label>
																</div>
																<div>
																	<label class="line-height-1">
																		<input name="userSex" value="2" type="radio" class="ace" <c:if test="${user.userSex=='2'}">checked="checked"</c:if>>
																		<span class="lbl"> 女</span>
																	</label>
																</div>
															</div>
														</div>
														<div class="space-2"></div>
														<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">登录账号:</label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<input type="text" name="code" id="tcode" class="col-xs-12 col-sm-6" value="${user.code}" placeholder="输入登录账号">
																</div>
															</div>
														</div>
													 <div class="space-2"></div>
														<div class="form-group">
														<label class="control-label col-xs-12 col-sm-3 no-padding-right">用户类型:</label>
														<div class="col-xs-12 col-sm-8">
																<div class="clearfix">
																	<select class="input-medium" id="userType" name="userType">
																		<option value="2" <c:if test="${user.userType==2}">selected="selected"</c:if>>普通用户</option>
																		<option value="1" <c:if test="${user.userType==1}">selected="selected"</c:if>>管理员</option>
																	</select>
																</div>
																
														 </div>
														</div>
														<div class="space-2"></div>
														<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="phone">联系方式:</label>
															<div class="col-xs-12 col-sm-9">
																<div class="input-group">
																	<span class="input-group-addon">
																		<i class="ace-icon fa fa-phone"></i>
																	</span>
																	<input type="text" id="userTel" name="userTel" value="${user.userTel}" placeholder="输入联系方式">
																</div>
															</div>
														</div>
														<div class="space-2"></div>
														<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="phone">邮箱:</label>
															<div class="col-xs-12 col-sm-9">
																<div class="input-group">
																	<span class="input-group-addon">
																		<i class="ace-icon fa fa-envelope-o"></i>
																	</span>
																	<input type="text" id="userEmail" name="userEmail" value="${user.userEmail}" placeholder="邮箱">
																</div>
															</div>
														</div>
														<div class="hr hr-dotted"></div>
														<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" >头像:</label>
															<div class="col-xs-12 col-sm-9">
															  <div id="thelist" class="uploader-list">
																 <img class="nav-user-photo"  id="pic" style="width: 100px;height: 50px;" src="${pageContext.request.contextPath}/picByPathServlet?path=${user.headImg}">
															 </div> 
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" >头像上传:</label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<div id="uploader">
																			<div class="btns">
																				 <div id="picker" class="webuploader-container">
																				 	<div class="webuploader-pick">选择头像</div>
																				 	<input type="file" name="file" class="webuploader-element-invisible">
																				  </div>
																			  </div>
																	</div>
																</div>
															</div>
														</div>
											<div class="form-group">
															<label class="control-label col-xs-12 col-sm-3 no-padding-right" >角色:</label>
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
                <button type="button" id="btn-save" class="btn btn-success btn-round"><i class="ace-icon fa fa-save"></i>修改</button>
				<button type="reset" class="btn btn-danger btn-round" id="btn-add"><i class="ace-icon fa fa-repeat"></i>重置</button>
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
	var modal = $('#myModal');
        modal.css('display', 'block');
      //以上代码解决 bootstrap modal与WebUploader控件冲突问题
	var uploader = WebUploader.create({
	    // swf文件路径
	    swf:    '${pageContext.request.contextPath }/static/js/Uploader.swf',
	    // 文件接收服务端。
	    server: webPath+'/user/uploadHeaderPic.do',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#picker',
	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false,
	    chunked: true, //分片 需要做分片处理 否则大文件上传速度慢 有问题
		chunkSize: 10 * 1024 * 1024, //每片5M
		chunkRetry:false,//如果失败，则不重试
		threads:1,//上传并发数。允许同时最大上传进程数。
		fileNumLimit:1,//验证文件总数量, 超出则不允许加入队列
		//runtimeOrder: 'flash', 
		// 禁掉全局的拖拽功能。这样不会出现图片拖进页面的时候，把图片打开。 
		disableGlobalDnd: true
	})
	//文件加入到队列中
	uploader.on('fileQueued', function(file) {
		  uploader.upload();//上传文件
	});
	//文件上传失败
	uploader.on('uploadError',function(file,ret){
		 utils.alertErr('头像上传失败!');
	});
	uploader.on('uploadSuccess',function(file,ret){
		uploader.removeFile(file);
		var result=ret._raw;
		  uploader.removeFile(file);
		  result= JSON.parse(result);
	      if(result.code==0){
			$("#headImg").val(result.data);
			$('#pic').attr('src','${pageContext.request.contextPath}/picByPathServlet?path='+result.data+'');
		}else  if(result.code==-1){
			utils.alertErr('头像上传失败!');
		}
	})
   uploader.addButton({
     id: '#picker',
     innerHTML: '头像上传'
     });
	//加载角色树
	 $.ajax({
 		 url:webPath+'/role/getSysRoleTreeList.do',
 		 type:"get",
	   		 success:function(data){
	   			   if(data!=null){
	   				  var arr={"id":"-1","pId":"","name":"角色树","open":true};
	   				      data.push(arr);
	   				      data=JSON.stringify(data);
	   				      console.log(data);
	   				  var treeObj=$.fn.zTree.init($("#treeDemo"), setting, JSON.parse(data));
	   			   	 // var userRoles='${user.roles}';
	   				   '<c:forEach items="${user.roles}" var="role" >'
               				 treeObj.checkNode(treeObj.getNodeByParam("id", '${role.id}', null), true, true);
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
            username: {
                required: true,
                minlength: 2,
            },
            code: {
                required: true,
                minlength: 2,
                remote:{                                          //验证用户名是否存在
                    type:"get",
                    url:webPath+"/user/checkUserCodeIsUse.do?oid="+$("#oid").val(),             //servlet
                    data:{
                      code:function(){
                    	  return  encodeURI($("#tcode").val());
                    	}
                    },
                    dataFilter: function (data, type) { //过滤返回结果
                    	var  result= JSON.parse(data);
                        if (result.code ==0)
                            return true;  //true代表用户名还未存在
                        else{
                        	utils.toast("用户名校验:"+result.errMsg);
                        	return false; //false代表用户名已经存在
                        }
                    }
                   } 
            },
            organid: {
                required: true
            }
        },
        messages: {
            username: {
                required: "请输入用户名",
                minlength: "用户名长度不能小于2个字符"
            },
            code: {
                required: "请输入账号",
                minlength: "账号长度不能小于2个字符",
                remote:'账号已存在'
            } 
        }
    });
    $('#btn-save').on('click',function(e){
    	 var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		 var nodes = treeObj.getCheckedNodes(true);
		 var bol= $("#form").valid();
		if(nodes.length==0){utils.alertErr('请选择角色!');return; }
		 if(nodes.length>0){
			 for(var i in nodes){
				 if($("#roleoids").val()!='')
				  	$("#roleoids").val($("#roleoids").val()+','+nodes[i].id);
				 else
					 $("#roleoids").val(nodes[i].id); 
			 }
		if(bol){
			 var fieldArray = $('#form').serializeArray();  
	    	 var json=utils.fromToJson(fieldArray);
	    	 $.ajax({
	    		 url:webPath+'/user/update.do',
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
		   			   }  else
		   				utils.toast('操作失败');
		   		   },
		   		   error:function(){
		   			 utils.toast('发生未知错误');
		   		   }
	    		 
	    	 })
		}
	}
	})
} );	
</script>
 
</html>