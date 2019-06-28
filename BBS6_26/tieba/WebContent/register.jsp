<%@page contentType="text/html; charset=UTF-8" language="java" %>
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
		<iframe src="head.jsp" scrolling="no" width="100%" height="65px"></iframe>
		<div class="main layui-clear">
		<div class="layui-container fly-marginTop">
			<div class="fly-panel fly-panel-user" pad20="">
				<div class="layui-tab layui-tab-brief" lay-filter="user">
					<ul class="layui-tab-title">
						<li>
							<a href="login.jsp">登入</a>
						</li>
						<li class="layui-this">注册</li>
					</ul>
					<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
						<div class="layui-tab-item layui-show">
							<div class="layui-form layui-form-pane">
								<form method="post" action="${pageContext.request.contextPath}/insertUserServlet">
									<div class="layui-form-item"> <label for="L_email" class="layui-form-label">用户名</label>
										<div class="layui-input-inline"> <input type="text" id="userName" name="uname" placeholder="请输入用户名" required="" lay-verify="userName"  class="layui-input"> </div>
										<div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
									</div>
									
									<div class="layui-form-item"> <label for="L_pass" class="layui-form-label">密码</label>
										<div class="layui-input-inline"> <input type="password" id="L_pass" placeholder="请输入密码" name="psw" required="" lay-verify="required" autocomplete="off" class="layui-input"> </div>
										<div class="layui-form-mid layui-word-aux">6到16个字符</div>
									</div>
									<div class="layui-form-item"> <label for="L_repass" class="layui-form-label">确认密码</label>
										<div class="layui-input-inline"> <input type="password" id="L_repass" name="repass" required="" placeholder="请输入确认密码" lay-verify="required" autocomplete="off" class="layui-input"> </div>
									</div>
									<div class="layui-form-item"> <label for="L_username" class="layui-form-label" >电话</label>
										<div class="layui-input-inline"> <input type="text" id="name" placeholder="请输入电话" name="tel" required="" lay-verify="required" autocomplete="off" class="layui-input"> </div>
									</div>
									<div class="layui-form-item"> <label for="L_username" class="layui-form-label" >昵称</label>
										<div class="layui-input-inline"> <input type="text" id="L_username" placeholder="请输入昵称" name="nickname" required="" lay-verify="required" autocomplete="off" class="layui-input"> </div>
									</div>
									
									
									<div class="layui-form-item"> <button class="layui-btn" lay-filter="*" lay-submit="">立即注册</button> </div>
									
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