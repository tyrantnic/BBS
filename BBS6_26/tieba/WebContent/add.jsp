<%@page contentType="text/html; charset=UTF-8" language="java" import="java.util. *" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>发表留言</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="res/layui/css/layui.css">
  <link rel="stylesheet" href="res/css/global.css">
<script src="res/layui/layui.js"></script>
</head>
<body>
<iframe  src="head.jsp" scrolling="no" width="100%" height="65px" ></iframe>
<c:if test="${empty(user)}">
    <script type="text/javascript">
        alert('请先登录！');
        location.href='${pageContext.request.contextPath}/login.jsp';
    </script>
</c:if>
<div class="main layui-clear">
  <div class="fly-panel" pad20>
    <h2 class="page-title">发表留言</h2>
    
    <!-- <div class="fly-none">并无权限</div> -->

    <div class="layui-form layui-form-pane">
      <form action="${pageContext.request.contextPath}/newNoteServlet" method="post">
        <input type="hidden" name="uid" value="${user.uid}">
        <input type="hidden" name="unickname" value="${user.nickname}">
        <input type="hidden" name="avatar" value="${user.avatar}">
        <div class="layui-form-item">
          <label for="L_title" class="layui-form-label">主题</label>
          <div class="layui-input-block">
            <input type="text" id="topic" name="topic" required lay-verify="required" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item layui-form-text">
          <div class="layui-input-block">
             <div class="editor">
    			<textarea id="content" name="content" style="width:1040px;height:450px;visibility:hidden;"></textarea>
  			 </div>
          </div>
          <label for="L_content" class="layui-form-label" style="top: -2px;">内容</label>
        </div>
        <div class="layui-form-item">
          <label for="L_title" class="layui-form-label">悬赏</label>
          <div class="layui-input-block">
            <input type="number"  name="reward" required lay-verify="required" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item">
          <input type="submit" value="立即发布" class="layui-btn" >
        </div>
      </form>
    </div>
  </div>
</div>

 <script type="text/javascript" charset="utf-8" src="res/js/kindeditor.js"></script>
  <script type="text/javascript">
    KE.show({
        id : 'content',
		resizeMode : 1,
        cssPath : './index.css',
        items : [
        'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
        'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        'insertunorderedlist', 'emoticons', 'image', 'link']
    });
  </script>
<script>

layui.cache.page = '';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "2.0.0"
  ,base: '../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>
</body>
</html>