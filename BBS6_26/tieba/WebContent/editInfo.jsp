<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/global.css">
		<script src="res/layui/layui.js"></script>
		<script type="text/javascript">
		// 选择图片显示
		function imgChange(obj) {
		//获取点击的文本框
		var file =document.getElementById("file");
		var imgUrl =window.URL.createObjectURL(file.files[0]);
		var img =document.getElementById('imghead');
		img.setAttribute('src',imgUrl); // 修改img标签src属性值
		};
		</script>

	</head>

	<body>
		<iframe src="head.jsp" scrolling="no" width="100%" height="65px"></iframe>
		<div class="main layui-clear">
		<div class="layui-container fly-marginTop">
			<div class="fly-panel fly-panel-user" pad20="">
				<div class="layui-tab layui-tab-brief" lay-filter="user">
					<ul class="layui-tab-title">
						<li class="layui-this">编辑信息</li>
					</ul>
					<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
						<div class="layui-tab-item layui-show">
							<div class="layui-form layui-form-pane">
								<form method="post" action="${pageContext.request.contextPath}/updateUserServlet" enctype="multipart/form-data">
								<div class="layui-form-item"> <label for="L_email" class="layui-form-label">头像</label>
										<div class="avatar">
										<c:if test="${empty(user.avatar)}">
										<img id="imghead" src="res/images/avatar/00.jpg" width="260" height="180" />
										</c:if>
										<c:if test="${!empty(user.avatar)}">
										<img id="imghead" src="${user.avatar}" width="260" height="180" />
										</c:if>
										</div>
										
										<input type="file" name="file" id="file" accept="image/*" onchange="imgChange(this);"/> 
									</div>
									<div class="layui-form-item"> <label for="L_email" class="layui-form-label">用户名</label>
										<div class="layui-input-inline"> <input type="text" id="L_pass" name="uname" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${user.uname}" disabled="disabled"/> </div>
										<div class="layui-form-mid layui-word-aux">不允许修改</div>
									</div>
									<div class="layui-form-item"> <label for="L_username" class="layui-form-label" >电话</label>
										<div class="layui-input-inline"> <input type="text" id="name" value="${user.tel}" name="tel" required="" lay-verify="required" autocomplete="off" class="layui-input"> </div>
									</div>
									<div class="layui-form-item"> <label for="L_username" class="layui-form-label" >昵称</label>
										<div class="layui-input-inline"> <input type="text" id="L_username" value="${user.nickname}" name="nickname" required="" lay-verify="required" autocomplete="off" class="layui-input"> 
										<input type="hidden" name="uid" value="${user.uid }" />
										</div>
									</div>
									
									
									<div class="layui-form-item"> <button class="layui-btn" lay-filter="*" lay-submit="">立即修改</button> </div>
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</body>
</html>