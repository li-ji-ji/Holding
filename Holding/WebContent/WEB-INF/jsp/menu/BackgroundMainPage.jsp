<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<style type="text/css">
	.menagement-table{
		width: 100%;
	}
</style>
<link rel="stylesheet"
	href="${basePath }/js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="${basePath }/js/jquery-3.3.1.js"></script>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">管理员界面</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree " lay-shrink="all"
					lay-filter="test" >
					<c:forEach var="menu" items="${menus}">
						<li class="layui-nav-item" id="" lay-filter=""><a
							class="" href="javascript:;">${menu.menuname} <span
								class="layui-nav-more"></span>
						</a>
							<dl class="layui-nav-child">
								<c:forEach items="${menu.menus}" var="sub">
									<dd>
										<a class="secondmenu" href="javascript:;" onclick="getid(this.id)" id="${sub.menuname}"  lay-filter="menuname">${sub.menuname}</a>
									</dd>
								</c:forEach>
							</dl> <%--
								废弃二级列表循环
								 <dl class="layui-nav-child">
									<c:forEach var="j" begin="1" end="${sessionScope.secondMenuLength}">
									<c:if test="${sessionScope.firstMenu[i].menuid==sessionScope.allSecondMenu[i].menus[i].menumid}">
										<dd>
											<a href="javascript:;">${sessionScope.allSecondMenu[j-1].menuname}</a>
										</dd>
									</c:if>
									</c:forEach>
								</dl>
								 --%></li>
					</c:forEach>
				</ul>
			</div>
		
		</div>
		<div class="layui-body">
			<iframe id="data-table" src="" width="100%" height="100%"></iframe>

			<!-- <table class="layui-table"
				lay-data="{width: 1150, height:500, url:'/Holding/user/getUserList.do', page:true, id:'idTest'}"
				lay-filter="demo">
				<thead>
					<tr>
						<th lay-data="{type:'checkbox'}">ID</th>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th
							lay-data="{field:'userno', width:120, sort: true, edit: 'text'}">用户编号</th>
						<th lay-data="{field:'name', edit: 'text', minWidth: 150}">用户名</th>
						<th lay-data="{field:'password', width:80, edit: 'text'}">密码</th>
						<th lay-data="{field:'imgurl', edit: 'text', minWidth: 100}">头像</th>
						<th lay-data="{field:'weixin', sort: true, edit: 'text'}">微信</th>
						<th lay-data="{field:'phone', sort: true, edit: 'text'}">电话</th>
						<th lay-data="{field:'email', sort: true, edit: 'text'}">邮箱</th>
						<th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					</tr>
				</thead>
			</table> -->
			<!-- <table class="layui-table"
				lay-data="{url:'/Holding/user/getUserList.do', id:'test3'}"
				lay-filter="test3">
				<thead>
					<tr>
						<th lay-data="{type:'checkbox'}">ID</th>
						<th lay-data="{field:'id', width:80, sort: true}">ID</th>
						<th
							lay-data="{field:'userno', width:120, sort: true, edit: 'text'}">用户编号</th>
						<th lay-data="{field:'name', edit: 'text', minWidth: 150}">用户名</th>
						<th lay-data="{field:'password', width:80, edit: 'text'}">密码</th>
						<th lay-data="{field:'imgurl', edit: 'text', minWidth: 100}">头像</th>
						<th lay-data="{field:'weixin', sort: true, edit: 'text'}">微信</th>
						<th lay-data="{field:'phone', sort: true, edit: 'text'}">电话</th>
						<th lay-data="{field:'email', sort: true, edit: 'text'}">邮箱</th>
					</tr>
				</thead>
			</table> -->
		</div>
	</div>

	<script src="${basePath }/js/plugins/layui/layui.js"></script>


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		//JavaScript代码区域
		
		function getid(id) {
			console.log(id);
			function getMenuUrl() {
				$("#data-table").attr("src", '/Holding/menu/getMenuUrlByMenuname.do');
			}
			$.ajax({
				"url": "/Holding/menu/getMenuUrlByMenuname.do",
				"data": "menuname="+id,
				"type": "POST",
				"dataType": "text",
				"success": getMenuUrl
			});
			 $("#data-table").attr("src", '/Holding/menu/getMenuUrlByMenuname.do'); 
		}
		
		layui.use('element', function() {
			var element = layui.element;
			element.on('nav(test)', function(data){
				  console.log(data); //得到当前点击的DOM对象
				  
				});
		});		
	</script>
</body>
</html>