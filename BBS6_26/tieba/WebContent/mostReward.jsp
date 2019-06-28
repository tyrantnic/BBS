<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>最多悬赏</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/css/global.css">
<script src="res/layui/layui.js"></script>
</head>
<body>
	<iframe src="head.jsp" scrolling="no" width="100%" height="65px"></iframe>
	<div class="main layui-clear">
		<div class="wrap">
			<div class="content" style="margin-right: 0">
				<div class="fly-tab">

					<span> 
					    <a href="${pageContext.request.contextPath}/index.jsp">全部留言</a> 
						<a href="${pageContext.request.contextPath}/moreViewNoteServlet" >最多浏览</a>
          				
          				<a href="${pageContext.request.contextPath}/moreComNoteServlet">最近热议</a>
		  				<a href="${pageContext.request.contextPath}/moreRewardNoteServlet" class="tab-this">最多悬赏</a> 
	<c:if test="${!empty(user)}">
	    <a href="${pageContext.request.contextPath}/myNotesServlet" >我的留言</a>
    </c:if>
					</span>

					<form action="${pageContext.request.contextPath}/searchNoteServlet" class="fly-search" name="searchform" >
						<a onClick="searchform.submit()"><i class="iconfont icon-sousuo"></i> </a>
						<input class="layui-input" autocomplete="off" placeholder="搜索内容" type="text" name="search_key">
					</form>
					<a href="${pageContext.request.contextPath}/add.jsp"
						class="layui-btn jie-add">发布留言</a>
				</div>

				<ul class="fly-list">
					<c:forEach items="${requestScope.notes}" var="note" varStatus="s">
						<li class="fly-list-li">
						    <a class="fly-list-avatar"> 
						        <img src="${note.avatar }" alt="">
						    </a>
							<h2 class="fly-tip">
								<a href="${pageContext.request.contextPath}/detailNoteServlet?nid=${note.nid}">${note.topic}</a>
							</h2>
							<p>
								<span><a href="">楼主：${note.uname}</a></span> 
								<span>发布时间：${note.time}</span>
								<span><em style="color: #FF9E3F">悬赏：${note.reward}</em> </span>
								 <span class="fly-list-hint">
									<i class="iconfont">&#xe60b;</i> ${note.seenum}
									<i class="iconfont" title="回答">&#xe60c;</i>
									${note.comnum}
								</span>
							</p></li>
					</c:forEach>
					
				</ul>

				<!-- <div class="fly-none">并无相关数据</div> -->

				<!-- <div style="text-align: center">
					<div class="laypage-main">
						<span class="laypage-curr">1</span> 
						<a href="">2</a> 
						<a href="">3</a>
						<a href="">4</a> 
						<a href="">5</a>
						<span>…</span> 
						<a href="" class="laypage-last" title="尾页">尾页</a> 
						<a href="" class="laypage-next">下一页</a>
					</div>
				</div> -->

			</div>
		</div>
	</div>
</body>

</html>