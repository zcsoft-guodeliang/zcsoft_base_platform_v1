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
<div class="modal-dialog" role="document">  
        <div class="modal-content"> 
        <form class="form-horizontal " id="form" method="post"> 
        <input type="hidden" id="menuType"  value="${permission.type}"  isProperty=NO/>
        <input type="hidden" id="id" name="id" value="${permission.id}"  />
        <input type="hidden" id="available" name="available" value="${permission.available}"  />
        
             <div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="white">&times;</span></button>
						添加菜单
					</div>
		      </div>
            <div class="modal-body">  
                	<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-right">菜单名称:</label>
												<div class="col-xs-12 col-sm-9">
													<div class="input_control clearfix">
														<input type="text"   name="name" id="name" value="${permission.name}" class="col-xs-12 col-sm-6" placeholder="输入菜单名称">
													 </div>
												 </div>
															 
								 </div>
								 <div class="space-2"></div>
								<div class="form-group">
									<label class="control-label col-xs-12 col-sm-3 no-padding-right">菜单代码:</label>
										<div class="col-xs-12 col-sm-9">
											<div class="clearfix">
													<input type="text"     name="percode" id="percode" value="${permission.percode}" class="col-xs-12 col-sm-6" placeholder="输入代码">
												</div>
										 </div>
								</div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="control-label col-xs-12 col-sm-3 no-padding-right">菜单链接:</label>
										<div class="col-xs-12 col-sm-9">
											<div class="clearfix">
													<input type="text"     name="url" id="url" value="${permission.url}" class="col-xs-12 col-sm-6" placeholder="输入菜单链接">
												</div>
										 </div>
								</div>
								<div class="hr hr-dotted"></div>
								<div class="space-2"></div>
								<div class="form-group">
									<label class="control-label col-xs-12 col-sm-3 no-padding-right">父级菜单:</label>
										<div class="col-xs-12 col-sm-9">
											<div class="clearfix">
													 <select class="form-control" id="parentid" name="parentid" style="width: 200px; display:inline;" >
													 	<option value="-1" ></option>
													 	<c:forEach items="${list}" var="tree">
													 		<option value="${tree.id}"
													 		<c:if test="${permission.parentid==tree.id}" >selected="selected"</c:if>
													 		>${tree.name}</option>
													 	</c:forEach>
													 </select>
													 
											</div>
										 </div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-12 col-sm-3 no-padding-right">类型:</label>
										<div class="col-xs-12 col-sm-9">
												<div>
													<label class="line-height-1">
														<input name="type" value="menu" type="radio" class="ace" <c:if test="${permission.type=='menu'}" >checked="checked"</c:if>   onclick="utils.setRadioObject('menuType','menu');">
														<span class="lbl">菜单</span>
													</label>
												 </div>
												 <div>
													<label class="line-height-1">
														<input name="type" value="permission" type="radio" class="ace"   <c:if test="${permission.type=='permission'}" >checked="checked"</c:if> onclick="utils.setRadioObject('menuType','permission');">
															<span class="lbl">按钮</span>
													 </label>
												 </div>
											</div>
								</div>
									<div class="hr hr-dotted"></div>
											<div class="form-group">
												<label class="control-label col-xs-12 col-sm-3 no-padding-right" >图标:</label>
												<div class="col-xs-12 col-sm-9">
													  <ul class="list-unstyled">
													  	<li>
													  	  <input type="radio" value="menu-icon fa fa-adjust" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-adjust'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-adjust"></i>
													  	  <input type="radio" value="menu-icon fa fa-check-square-o" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-check-square-o'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-check-square-o"></i>
													  	  <input type="radio" value="menu-icon fa fa-barcode" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-barcode'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-barcode"></i>
													  	  <input type="radio" value="menu-icon fa fa-envelope" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-envelope'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-envelope"></i>
													  	  <input type="radio" value="menu-icon fa fa-envelope-o" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-envelope-o'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-envelope-o"></i>
													  	  <input type="radio" value="menu-icon fa fa-film" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-film'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-film"></i>
													  	  <input type="radio" value="menu-icon fa  fa-folder-open-o" name="icon" <c:if test="${permission.icon=='menu-icon fa  fa-folder-open-o'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa  fa-folder-open-o"></i>
													  	</li>
													  	
													  	<li>
													  	  <input type="radio" value="menu-icon fa  fa-desktop" name="icon" <c:if test="${permission.icon=='menu-icon fa  fa-desktop'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa  fa-desktop"></i>
													  	  <input type="radio" value="menu-icon fa fa-users" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-users'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-users"></i>
													  	  <input type="radio" value="menu-icon fa  fa-download" name="icon" <c:if test="${permission.icon=='menu-icon fa  fa-download'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa  fa-download"></i>
													  	  <input type="radio" value="menu-icon fa fa-gavel" name="icon" <c:if test="${permission.icon=='menu-icon fa fa-gavel'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa fa-gavel"></i>
													  	  <input type="radio" value="menu-icon fa  fa-lemon-o" name="icon" <c:if test="${permission.icon=='menu-icon fa  fa-lemon-o'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa  fa-lemon-o"></i>
													  	  <input type="radio" value="menu-icon fa  fa-lightbulb-o" name="icon" <c:if test="${permission.icon=='menu-icon fa  fa-lightbulb-o'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa  fa-lightbulb-o"></i>
													  	  <input type="radio" value="menu-icon fa   fa-eye-slash" name="icon" <c:if test="${permission.icon=='menu-icon fa   fa-eye-slash'}" >checked="checked"</c:if>/>
													  	  <i class="menu-icon fa   fa-eye-slash"></i>
													  	</li>
													  	
													  </ul>
													   
											    </div>
										 </div>
												 
													
							</div> 
						</div> 
            </div> 
            <div class="modal-footer">  
                <button type="button" id="btn-save"  class="btn btn-success btn-round"><i class="ace-icon  fa fa-pencil"></i>修改</button>
				<button type="reset" class="btn btn-danger btn-round" id="btn-reset"><i class="ace-icon fa fa-repeat"></i>重置</button>
            </div> 
          </form>   
        </div> 
    </div>
</body>
<script type="text/javascript">
$(function() {
    //表单验证
    $("#form").validate({
        rules: {
            name: {
                required: true
            } 
        },
        messages: {
        	name: {
                required: "请输入菜单名称" 
            }  
        }
    });
    $('#btn-save').on('click',function(e){
		var bol= $("#form").valid();
		if(bol){
			 if($('#menuType').val()==''){
				 utils.alert('请选择类型');
				 return ;
			 } 
			 var fieldArray = $('#form').serializeArray();  
	    	 var json=utils.fromToJson(fieldArray);
	    	 $.ajax({
	    		 url:webPath+'/menu/update.do',
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
		   			   }else{
		   				  	utils.toast('操作失败');
		   			   }
		   				
		   		   },
		   		   error:function(){
		   			 utils.toast('发生未知错误');
		   		   }
	    		 
	    	 })
		}
	})
} );	
			
			
	 
	
</script>
 
</html>