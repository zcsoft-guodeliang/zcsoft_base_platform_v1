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
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style_gg.css" />
</head>
<body> 
	<div class="gzt_box">
			<ul>
				<li>
					<a onclick="loadDiv('enterprise/zfqy_list.do');" href="javascript:;;"> 
						<span class="col_1">
							<i class="fa fa-address-book-o" style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_1">走访企业管理</p>
					</a>
				</li>
				<li>
					<a onclick="loadDiv('enterprise/dyqy_list.do');" href="javascript:;;"> 
						<span class="col_2">
							<i class="fa fa-address-card"  style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_2">调研企业管理</p>
					</a>
				</li>
				<li>
					<a onclick="loadDiv('technicalDocking/projectInfo_list.do');" href="javascript:;;"> 
						<span class="col_3" >
							<i class="fa fa-cog"  style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_3" >项目信息上报</p>
					</a>
				</li>
				 <li>
				  <a onclick="loadDiv('technicalDocking/proWay_list.do');" href="javascript:;;"> 
						<span class="col_4">
							<i class="fa fa-cube" style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_4">项目进展情况</p>
					</a>
				</li>
				<li>
					<a onclick="loadDiv('scientific/list.do');" href="javascript:;;"> 
						<span class="col_5">
							<i class="fa fa-calendar"  style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_5">申报科技项目管理</p>
					</a>
				</li>
				<li>
				  <a onclick="loadDiv('innovationActivityManagement/zfbmxjhd_list.do');" href="javascript:;;"> 
						<span class="col_6">
							<i class="fa fa-flash" style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_6">政府部门宣讲活动</p>
					</a>
				</li>
				<li>
				  <a onclick="loadDiv('innovationActivityManagement/cyhytjhd_list.do');" href="javascript:;;"> 
						<span class="col_7">
							<i class="fa fa-film" style="margin-top: 40px;"></i>
						</span>
						<p class="col_text_7">产业行业推介活动</p>
					</a>
				</li>
			  
				 
			</ul>
			
		</div> 
</body>
 <script type="text/javascript">
 function loadDiv(url){
	 utils.loadDivContent(url,$("#page-content"));  //加载主页面div
}
 </script>
 
</html>