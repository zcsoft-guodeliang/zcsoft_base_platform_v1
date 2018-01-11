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
</head>
<body>
   	<ul class="nav nav-list" id="menuList">
					<li class="active">
						<a href="javascript:;;">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text">系统菜单 </span>
						</a>
						<b class="arrow"></b>
					</li>
					<c:if test="${activeUser!=null}">
					   <c:forEach items="${activeUser.menus}" var="menu">
					   	<li>
					   	    <a href="javascript:;;" isPoint="false"  url="" class="dropdown-toggle" id="${menu.id}">
								 <i class="${menu.icon}"></i>   
								<span class="menu-text">${menu.name}</span>
								<b class="arrow fa fa-angle-down"></b>
						  	</a>
						   <b class="arrow" id="${menu.name}"></b>
						  
					   	</li>
					   </c:forEach>
					</c:if>
	 </ul>
</body>
<script type="text/javascript">
function createMenu(obj){
	//判断当前点击元素下面是否已经展开子菜单
	var  ul=document.createElement('ul');
		 ul.className='submenu';
 	if($(obj).attr('isPoint')=='false'){
	  	$.ajax({
	   		 url:webPath+'/menu/getChildMenuJson.do?menuPid='+$(obj).attr('id'),
	   		 type:"get",
		   		 success:function(data){
		   			if(data.length>0){
		   			    for(var i in data){
		   			    	var li=document.createElement('li');
		   			  		var a=document.createElement('a');
		   			  			a.setAttribute('id',data[i].id);
		   			  			a.setAttribute('url',data[i].url);
		   			  	    	a.setAttribute('href','javascript:;;');
		   			  	    	a.setAttribute('isPoint','false');
		   			      		a.className='dropdown-toggle';
		   			      		a.innerHTML='\
		   			      					<i class="menu-icon fa fa-caret-right"></i>\
		   			      					'+data[i].name+'\
		   			      					<b class="arrow fa fa-angle-down"></b>\
		   			      					<b class="arrow"></b>';
		   			      		li.appendChild(a);
		   			      		ul.appendChild(li);
		   			        	$(obj).after(ul);
		   			         	$(obj).attr('isPoint','true');
		   			         	createMenu($(a));
			   			        $(a).click(function(){//为增加的a添加点击事件
				   			         	var url=$(this).attr('url');
				   			         	if(url!=''&&'javascript:;;'!=url){
				   			         	 	utils.loading('数据加载中.......');
					   					   $("#page-content").load(webPath+'/'+url,function(responseTxt,statusTxt,xhr){
					   						   if(statusTxt=='success'){
					   							   utils.closeLoading();
					   						   }else{
					   							   utils.closeLoading();
					   							   $("#page-content").load(webPath+'/'+'public/404.jsp');
					   						   }
					   					   }); 
				   			         	}
			   			         })
		   			   	 }  
		   			 }else{
		   				var b=$(obj).find('b');
		   				b.removeClass("arrow fa fa-angle-down");
		   			 }
		   		   },
		   		   error:function(){
		   			 utils.toast('加载左侧菜单发生未知错误');
		   		   }
	   		 
	   	 })		 
	 }
}
$(function(){
	 $('#menuList   li a').each(function(){
		 //为当前元素追加子菜单
		 	createMenu($(this));
		  //加载id
			 $(this).click(function(){
				 createMenu(this);
			 })
	  })
		   
	   })	 
</script>
</html>