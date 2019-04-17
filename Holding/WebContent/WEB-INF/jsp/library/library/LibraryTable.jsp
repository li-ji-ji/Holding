<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="basePath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${basePath }/js/plugins/layui/css/layui.css" media="all">
<script type="text/javascript" src="${basePath }/js/jquery-3.3.1.js"></script>
</head>
<body>
	<table class="layui-table"
				lay-data="{width: 1100, height:500, url:'/Holding/api/user/getUserList.do', page:true, id:'idTest'}"
				lay-filter="demo">
				<thead>
					<tr>
						<th lay-data="{type:'checkbox'}"></th>
						<th lay-data="{field:'id', width:100, sort: true}">图书馆ID</th>
						<th lay-data="{field:'address', width:100, sort: true}">所在学校</th>
						<th
							lay-data="{field:'imageurl', width:100, sort: true, edit: 'text'}">图片链接</th>
						<th lay-data="{field:'cityid', edit: 'text', Width: 80}">所在城市ID</th>
						<th lay-data="{field:'startTime', width:150, edit: 'text'}">开馆时间</th>
						<th lay-data="{field:'endTime', edit: 'text', minWidth: 150}">闭馆时间</th>
						<th lay-data="{field:'status', edit: 'text', minWidth: 150}">状态</th>
						<th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
					</tr>
				</thead>
			</table>
		<script src="${basePath }/js/plugins/layui/layui.js"></script>


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		//JavaScript代码区域
		
		layui.use('element', function() {
			var element = layui.element;

		});
		layui.use('table', function(){
			  var table = layui.table;
			  //监听表格复选框选择
			  table.on('checkbox(demo)', function(obj){
			    console.log(obj)
			  });
			  //监听工具条
			  table.on('tool(demo)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'detail'){
			      layer.msg('ID：'+ data.id + ' 的查看操作');
			    } else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del();
			        console.log(data.menuid);
			        $.ajax({
			        	"url" : "${basePath}/menu/deleteMenuById.do",
			        	"data" : "menuid="+data.menuid,
			        	"type" : "post",
			        	"dataType" : "text",
			        	"success" : function (returnMsg) {
							if(returnMsg==1){
								layer.alert("删除成功");
							}else{
								layer.alert("删除失败");
							}
						}
			        })
			        layer.close(index);
			        
			      });
			    } else if(obj.event === 'edit'){
			      json=JSON.stringify(data);
			      $.ajax({
			    	  "url" : "/Holding/menu/getMenuToFrom.do",
			    	  "data" : "menuid="+data.menuid,
			    	  "type" : "get",
			    	  "dataType" : "text",
			    	  "success"	: function (menu) {
			    		  layer.open({
					    	  type: 2, 
					    	  content: '/Holding/menu/getMenuFrom.do',
					    	  area: ['80%', '80%'],
					    	  shade: 0.5,
					    	  
					    	}); 
					}
			      });
			      
			    }
			  });
			  
			  var $ = layui.$, active = {
			    getCheckData: function(){ //获取选中数据
			      var checkStatus = table.checkStatus('idTest')
			      ,data = checkStatus.data;
			      layer.alert(JSON.stringify(data));
			    }
			    ,getCheckLength: function(){ //获取选中数目
			      var checkStatus = table.checkStatus('idTest')
			      ,data = checkStatus.data;
			      layer.msg('选中了：'+ data.length + ' 个');
			    }
			    ,isAll: function(){ //验证是否全选
			      var checkStatus = table.checkStatus('idTest');
			      layer.msg(checkStatus.isAll ? '全选': '未全选')
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			});
	</script>
</body>
</html>