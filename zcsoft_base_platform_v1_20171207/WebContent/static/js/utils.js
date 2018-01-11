var utils={
		loading : function(mess){// 显示加载框
			if (mess == undefined || mess == ""){
				mess = "正在加载数据，请稍候..";
			}
			var l = layer.open({
				type:0,title: false,btn :false,shade: 0.3,closeBtn: 0,anim: -1,icon:0,content:mess,
				success: function(layero, index){
					layer.style(index, {
					  'min-width': '200px',
					  'min-height': '20px'
					}); 
				}
			});
			return l;
		},
		closeLoading : function(idx){// 关闭提示框
			if(idx)layer.close(idx);
			else layer.closeAll();
			return true;
		},
		//系统弹出框
		//content-内容，title-弹层标题，btn-按钮,are-高度，宽度，yes-确定按钮回调
		openModal : function(options){
			var default_options = {
				content:'',
				title:'',
				btn:false,
				area:['500px', '700px'],
				yes:'',
				scrollbar: false,
				maxmin: true,
				type:2
			};
			var options_ = $.extend(true, default_options, options);
			
			var l = layer.open(options_);
			return l;
		},//mess提示信息，beSure点击确定时执行的回调函数
		alert : function(mess, beSure,beCancel){//成功操作提示
			if(mess == null){
				mess = "null";
			}
			layer.open({
				  content: mess,
				  title: '系统提示',
				  btn: ['确定'],
				  yes: function(index, layero){
					  layer.close(index);
					  if (typeof beSure == 'function') {
						beSure();
					  }
				  },
				  cancel:function(index, layero) {
					  layer.close(index);
						  if (typeof beCancel == 'function') {
						  beCancel();
					  }
				  }
				});
		},
		//mess提示信息，beSure点击确定时执行的回调函数,beCancel点击右上角关闭时执行的回调函数
		alertErr : function(mess, beSure,beCancel){//警告对话框
			if(mess == null){
				mess = "null";
			}
			layer.open({
				  content: mess,
				  title: '系统提示',
				  btn: ['确定'],
				  yes: function(index, layero){
					  layer.close(index);
					  if (typeof beSure == 'function') {
						beSure();
					  }
				  },
				  cancel:function(index, layero) {
					  layer.close(index);
						  if (typeof beCancel == 'function') {
						  beCancel();
					  }
				  }
				});
		},
		//href 点击确定时进行页面跳转或执行的回调函数
		confirm : function(mess, href, closed){//确认对话框
			layer.open({
				  content: mess
				  ,title: '系统提示'
				  ,btn: ['确定', '取消']
				  ,yes: function(index, layero){
					layer.close(index);
				  	if (typeof href == 'function') {
						href();
					}else{
						location = href;
					}
				  },btn2: function(index, layero){
					  layer.close(index);
				  },cancel: function(){ 
				    //右上角关闭回调
				    if (typeof closed == 'function') {
				    	closed();
					}
				  }
				});
				return false;
		},
		/**
		 * 操作成功消息提醒
		 */
		toast : function(msg){
			layer.msg(msg, {
			  offset: '100px',
			  anim: -1  //关闭弹出动画
			});
		},
	//form表单转换成json
		fromToJson:function(fieldArray){  
		    var result = {};  
		    for (var i = 0; i < fieldArray.length; i++) {  
		        var field = fieldArray[i]; 
		       var isProperty= $('#'+field.name).attr('isProperty');
		        if(isProperty!='NO') {
		        	if (field.name in result) { 
			            result[field.name] += ',' + field.value;  
			        } else {  
			            result[field.name] = field.value;  
			        }
		        }
		    }  
		    return result;  
		},
		loadDivContent:function(url,obj){
			obj.load(webPath+'/'+url);
		},
		loadMainPage:function(url){
			$("#page-content").load(webPath+'/'+url);
		},
	 fenye:function(currentPage,totalPages,numberOfPages,url){
		 if(totalPages>1){
			 $("#pageDiv").show();
			 var options = {
			 		 currentPage:currentPage,//当前页
			 		 totalPages:totalPages,//总页数
			 		 numberOfPages:numberOfPages,
			 		 pageUrl: function(type, pageNum, current){   
			 		 	 if(pageNum!=currentPage){//超链接翻页
			 		 		// console.log(itemContent);
			 		 		 //utils.loadDivContent(webPath+'/'+url,$("#page-content"));  //加载主页面div
			 		 		//return  "javascript:void(0);";//翻页
			 		 	 }
			 		 	
			 		 },
			 		 onPageClicked:function(event, originalEvent, type,pageNum){//绑定点击事件
			 			if(pageNum!=currentPage){
			 		 		// console.log(itemContent);
			 		 		 utils.loadDivContent(encodeURI("../"+url+"&pageNum="+pageNum),$("#page-content"));  //加载主页面div
			 		 		//return  "javascript:void(0);";//翻页
			 		 	 }
			 			 
			 		 }
			 	  }
			 $('#page').bootstrapPaginator(options); 
		 }
	 },
  setRadioObject:function(id,value){
	   $('#'+id).val(value);
  }		
		
};
utils.topPath=webPath+'/top.do';//首页do
utils.leftPath=webPath+'/left.do';//左侧菜单do
utils.mainPath=webPath+'/main.do';//主页面do

