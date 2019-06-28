<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>留言详情</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="fly,layui,前端社区">
<meta name="description" content="">
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/css/global.css">
<script src="res/layui/layui.js"></script>
<script src="js/jquery.js"></script>
<style type="text/css" rel="stylesheet">
form {
	margin: 0;
}

.editor {
	margin-top: 5px;
	margin-bottom: 5px;
}
</style>

</head>
<body>
	<iframe src="head.jsp" scrolling="no" width="100%" height="65px"></iframe>
	<div class="main layui-clear">
		<div class="wrap">
			<div class="content detail">
				<div class="fly-panel detail-box">
					<h1>${note.topic}</h1>
					<!-- <div class="fly-tip fly-detail-hint" data-id="">
						<span class="fly-tip-stick">置顶帖</span><span class="jie-admin"> <a
							href="">点击置顶</a> </span> <span
							class="layui-btn layui-btn-mini jie-admin"> <a href="">取消置顶</a>
						</span> <span class="jie-admin" type="del" style="margin-left: 20px;">
							<a>删除该帖</a> </span> 
						</span>
						<div class="fly-list-hint">
							<i class="iconfont" title="回答">&#xe60c;</i> 2 
						</div>
					</div> -->
					<div class="detail-about">
						<a class="jie-user" href=""> <img src="${note.avatar }"
							alt="头像"> <cite> ${note.uname} <em>${note.time}发布</em>
						</cite>
						</a>
						<div class="detail-hits">
						    <span><em style="color: #FF9E3F">悬赏：${note.reward}</em> </span>
						</div>
						<!-- <div class="detail-hits" data-id="{{rows.id}}">
							 <span class="layui-btn layui-btn-mini jie-admin"><a
								href="#">已完帖，无法编辑</a> </span> <span
								class="layui-btn layui-btn-mini jie-admin" type="collect"
								data-type="add"> <a id="collectPost">收藏</a> </span> <span
								class="layui-btn layui-btn-mini jie-admin  layui-btn-danger"
								type="collect" data-type="add"> <a>取消收藏</a> </span>

						</div> -->
					</div>
					<div class="detail-body photos" style="margin-bottom: 20px;">
						<p>${note.content}</p>
					</div>
				</div>
				<div class="fly-panel detail-box" style="padding-top: 0;">
					<a name="comment"></a>
					<ul class="jieda photos" id="jieda">
					<c:forEach items="${requestScope.comments}" var="comment" varStatus="s">
						<li data-id="12" class="jieda-daan"><a
							name="item-121212121212"></a>
							<div class="detail-about detail-about-reply">
								<a class="jie-user" href=""> <img src="${comment.avatar }"
									alt=""> <cite> <i>${comment.myname}</i> 
									<c:if test="${note.uid==comment.myid}">
									<em>(楼主)</em> 
									</c:if>
									<!-- <em style="color:#5FB878">(管理员)</em> -->
								</cite>
								</a>
								<div class="detail-hits">
									<span>${comment.time}</span>
								</div>
								<c:if test="${comment.accept==1}">
								    <i class="iconfont icon-caina" title="最佳答案"></i>
								</c:if>
							</div>
							<div class="detail-body jieda-body">
								<p><%-- <a>@${comment.yourname}</a> --%> ${comment.content}</p>
							</div>
							<div class="jieda-reply">
									<span class="jieda-zan zanok" type="zan"><i
										class="iconfont icon-zan"></i><em>${comment.likenum }</em> </span> 
								<c:if test="${!empty(user)&&user.uid==note.uid&&comment.accept==0}">
									<div class="jieda-admin">
										<span class="jieda-accept" type="accept">
										<a href="${pageContext.request.contextPath}/acceptCommentServlet?cid=${comment.cid}&nid=${note.nid}" class="layui-btn  layui-btn-small">采纳</a></span>
									</div>
								</c:if>
							</div>
						
					    </li>
					</c:forEach>
						<%-- <li data-id="13"><a name="item-121212121212"></a>
							<div class="detail-about detail-about-reply">
								<a class="jie-user" href=""> <img src="res/images/uer.jpg"
									alt=""> <cite> <i>香菇</i> <em
										style="color: #FF9E3F">活雷锋</em>
								</cite>
								</a>
								<div class="detail-hits">
									<span>刚刚</span>
								</div>
							</div>
							<div class="detail-body jieda-body">
								<p>蓝瘦</p>
							</div>
							<div class="jieda-reply">
								<span class="jieda-zan" type="zan"><i
									class="iconfont icon-zan"></i><em>0</em> </span>
								<div class="jieda-admin">
									<span type="del"><a href="#"
										class="layui-btn layui-btn-danger layui-btn-small">删除</a></span> <span
										class="jieda-accept" type="accept"> <a href="#"
										class="layui-btn  layui-btn-small">采纳</a></span>
								</div>
							</div></li> --%>

						<!-- <li class="fly-none">没有任何回答</li> -->
					</ul>
					<c:if test="${!empty(user)}">
						<span id="toName">@${note.uname}(楼主)</span>
						<div class="layui-form layui-form-pane">
							<form name="addcomment" action="${pageContext.request.contextPath}/newCommentServlet" method="post">
							    <input type="hidden" name="nid" value="${note.nid}" />
							    <input type="hidden" name="myid" value="${user.uid}" />
							    <input type="hidden" name="yourid" value="${note.uid}" />
							    <input type="hidden" name="mynickname" value="${user.nickname}" />
							    <input type="hidden" name="yournickname" value="${note.uname}" />
							    <input type="hidden" name="avatar" value="${user.avatar}" />
								<div class="layui-form-item layui-form-text">
									<div class="layui-input-block">
										<textarea id="content" name="content" required
											lay-verify="required" placeholder="我要评论"
											class="layui-textarea fly-editor" style="height: 150px;"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<a onClick="addcomment.submit()" class="layui-btn">提交评论</a>
								</div>
							</form>
						</div>
					</c:if>
					<c:if test="${empty(user)}">
					    <p style="color:#5FB878">您还未登录，不能发表评论哦...<br>快点击右上角的登录吧！</p>
					</c:if>


				</div>
			</div>
		</div>

		<div class="edge">
			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">热门留言</dt>
					<c:forEach items="${requestScope.notes1}" var="note1" begin="0" end="7" step="1" varStatus="s1">
						<dd>
							<a href="${pageContext.request.contextPath}/detailNoteServlet?nid=${note1.nid}">
							${note1.topic}</a> 
							<span><i class="iconfont">&#xe60b;</i> ${note1.seenum}</span>
						</dd>
				    </c:forEach>
				
			</dl>

			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">近期热议</dt>
				<c:forEach items="${requestScope.notes2}" var="note2" begin="0" end="7" step="1" varStatus="s2">
					<dd>
						<a href="${pageContext.request.contextPath}/detailNoteServlet?nid=${note2.nid}">
						${note2.topic}</a> <span><i
							class="iconfont">&#xe60c;</i> ${note2.comnum}</span>
					</dd>
				</c:forEach>
				
			</dl>
			
			<dl class="fly-panel fly-list-one">
				<dt class="fly-panel-title">悬赏最多</dt>
				<c:forEach items="${requestScope.notes3}" var="note3" begin="0" end="7" step="1" varStatus="s3">
					<dd>
						<a href="${pageContext.request.contextPath}/detailNoteServlet?nid=${note3.nid}">
						${note3.topic}</a> 
						<span><em style="color: #FF9E3F">悬赏：${note3.reward}</em> </span>
					</dd>
				</c:forEach>
				
			</dl>
			
		</div>
	</div>
	<script type="text/javascript" charset="utf-8"
		src="res/js/kindeditor.js"></script>
	<script type="text/javascript">
		KE.show({
			id : 'L_content',
			resizeMode : 1,
			items : [ 'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold',
					'italic', 'underline', 'removeformat', 'justifyleft',
					'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', 'emoticons', 'image', 'link' ]
		});
	</script>
</body>
</html>