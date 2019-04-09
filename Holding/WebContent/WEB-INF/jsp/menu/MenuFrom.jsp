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
<script src="${basePath }/js/plugins/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label">菜单ID</label>
    <div class="layui-input-block">
      <input type="number" name="menuid" lay-verify="title" autocomplete="off" placeholder="请输入菜单ID" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">菜单名称</label>
    <div class="layui-input-block">
      <input type="text" name="menuname" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">是否启用</label>
    <div class="layui-input-block">
      <select name="status" lay-filter="status">
        <option value=""></option>
        <option value="0">启用</option>
        <option value="1">停用</option>
      </select>
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">开关</label>
    <div class="layui-input-block">
      <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男" checked="">
      <input type="radio" name="sex" value="女" title="女">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">文本域</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" name="desc"></textarea>
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
    </div>
  </div>
</form>
</body>
</html>