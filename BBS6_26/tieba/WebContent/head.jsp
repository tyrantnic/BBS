<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/global.css">
		<script src="res/layui/layui.js"></script>
		
	</head>
	<body>
		<div class="header">
			<div class="main">
				<a class="title" href="${pageContext.request.contextPath}/index.jsp" target="_parent" title="海大"> 
					<i class="iconfont icon-jiaoliu layui-hide-xs" style="font-size: 22px;"></i>
					海大留言社区BBS</a>
				<div class="nav-user">
					<c:if test="${!empty(user)}">
					<a href="editInfo.jsp" class="avatar" target="_parent">
					<c:if test="${empty(user.avatar)}">
					<img  src="res/images/avatar/00.jpg">
					</c:if>
					<c:if test="${!empty(user.avatar)}">
					<img src="${user.avatar}" />
					</c:if>
					<span>${user.nickname}</span>
					</a>
					<div class="nav">
						<a href="${pageContext.request.contextPath}/quitServlet"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退出</a>
					</div>
					</c:if>
					<!--
                    	作者：634072111@qq.com
                    	时间：2017-12-28
                    	描述：登录后的样子
                   
					<a class="avatar" href="">
						<img src="res/images/avatar/11.jpg">
						<cite>贤心</cite>
					</a>
					<div class="nav">
						<a href=""><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退出</a>
					</div>
					 -->
					 
					 
					<!--
                    	作者：634072111@qq.com
                    	时间：2017-12-28
                    	描述：未登录的样子
                    -->
                    <c:if test="${empty(user)}">
                    <a   class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;">
                    </a>
                    <div class="nav"  style=" font-size:14px; color: white;margin-top: -5px;margin-left: 1px;"  >
                    	<a href="login.jsp"  target="_parent" >登录</a>
                    	<a href="register.jsp" target="_parent" >注册</a>
                   </div>
                    </c:if>
                    </div>
				</div>
			</div>
	</body>
</html>