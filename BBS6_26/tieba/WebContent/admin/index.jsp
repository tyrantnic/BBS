<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page import="java.util. *,cn.edu.hainu.domain.Note" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>海大留言社区BBS后台管理</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
  <link rel="stylesheet" href="./css/global.css">
  <link rel="stylesheet" href="./icheck/minimal/red.css">
  <script type="text/javascript">
  function  check() {
	  
	var check=window.confirm("删除后无法恢复，确定吗？")
	return check;
}
  function select() {
		var id=document.getElementsByName("id");
		var ids="";
		for (var i = 0; i < id.length; i++) {
			if(id[i].checked){
			ids=ids+"nid="+id[i].value+"&";	
			}
		}
		location.href="${pageContext.request.contextPath}/deleteNoteServlet?"+ids;
		
	}
  
  </script>
</head>
<body class="layui-layout-body">
<c:if test="${empty(admin)}">
  <script type="text/javascript">
      alert('非法访问');
      location.href='${pageContext.request.contextPath}/admin/login.jsp';
  </script>
</c:if>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">海大留言社区BBS后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
      
        <a href="javascript:;">
          <img src="http://localhost:8080/images/1561385249.jpg" class="layui-nav-img">
          ${admin.aname}
        </a>
        
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/quitAdminServlet">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed"><a href="index.jsp">控制台</a></li>
        
        <li class="layui-nav-item ">
          <a href="javascript:;">留言管理</a>
          <dl class="layui-nav-child">
            <dd><a  href="admin.jsp">留言列表</a></dd>
          </dl>
        </li>
        
        <li class="layui-nav-item">
                <a href="javascript:;">用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="member.jsp">用户列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item ">
                <a href="javascript:;">评论管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="comment.jsp">评论列表</a></dd>
                </dl>
            </li>
        
        
      </ul>
    </div>
  </div>

 <div class="layui-body">
  <div style="padding: 15px;">
        <fieldset class="layui-elem-field">
            <legend>控制台-管理员信息</legend>
            <div class="layui-field-box">
            欢迎，管理员：${admin.aname}
            </div>
        </fieldset>
        <fieldset class="layui-elem-field">
          <legend>控制台-最新公告</legend>
          <div class="layui-field-box">
              海纳百川，大道致远！！
          </div>
      </fieldset>
  </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script type="text/javascript" src="./javascript/jquery.min.js"></script>
<script type="text/javascript" src="./layui/layui.js"></script>
<script type="text/javascript" src="./icheck/icheck.js"></script>
<script type="text/javascript" src="./javascript/dw.js"></script>
</body>
</html>