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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/fullcalendar.css" />
<style type="text/css">
	.ui-widget-content {
    border: 0px solid;
    height:100px;
    background:#EE4000;
    color: #fff;
    cursor: pointer;
</style>
</head>
<body> 
	<div class="page-content-area">
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-sm-9">
										<div id="calendar"></div>
									</div>
									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h4>添加活动</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="external-events">
														<div id="active" class="external-event label-success" data-class="label-success">
															<i class="icon-move"></i>
															 拖拽添加活动
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div>
</body>
<script type="text/javascript">
 $(function(){
	 	var eventObject = {
				title: $.trim($('#active').text()) 
			};
	 	$('#active').data('eventObject', eventObject);
	 	$('#active').draggable({
				zIndex: 999,
				revert: true,      
				revertDuration: 0   
		});
 
	        //初始化FullCalendar 
	       var calendar = $('#calendar').fullCalendar({
	            //设置头部信息，如果不想显示，可以设置header为false
	            header: {
	                //日历头部左边：初始化切换按钮
	                left: 'prev,next today',
	                //日历头部中间：显示当前日期信息
	                center: 'title' 
	            },
	            //设置是否显示周六和周日，设为false则不显示  
	            weekends: true,
	            //日历初始化时显示的日期，月视图显示该月，周视图显示该周，日视图显示该天，和当前日期没有关系
	            //日程数据 
	            events: [
	                {
	                    title: '参加电话会议',
	                    start: '2017-09-11',
	                    className:'ui-widget-content'
	                }
	            ],
	            editable: true,
	    		droppable: true,
	    		drop:function(date, allDay) {//拖拽添加
	    			var originalEventObject = $(this).data('eventObject');
	    			var $extraEventClass = $(this).attr('data-class');
	    			var copiedEventObject = $.extend({}, originalEventObject);
	    			copiedEventObject.start = date;
	    			copiedEventObject.allDay = allDay;
	    			if($extraEventClass) copiedEventObject['className'] = 'ui-widget-content';
	    			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
	    			if ($('#drop-remove').is(':checked')) {
	    				$(this).remove();
	    			}
	    		},
	            eventMouseover:function(event, jsEvent, view){//鼠标移入事件
	            	 console.log(event.start);
	            },
	            eventClick:function(calEvent, jsEvent, view){//点击事件
	            	var form = $("<div style='margin-top:25px;'><form class='form-inline'><label>活动名称:</label></form></div>");
	    			form.append("<input class='middle' autocomplete=off type=text value='" + calEvent.title + "' /> ");
	            	var div = bootbox.dialog({
	    				message: form,
	    				buttons: {
	    					"save" : {
	    						"label" : "<i class='ace-icon fa fa-save'></i>修改",
	    						"className" : "btn btn-success btn-round",
	    						"callback": function() {
	    							calendar.fullCalendar('removeEvents' , function(ev){
	    								calEvent.title = form.find("input[type=text]").val();
	    								calendar.fullCalendar('updateEvent', calEvent);
	    							})
	    						}
	    					} 
	    				}

	    			});
	            }
	        });
 })
  
</script>
 
</html>