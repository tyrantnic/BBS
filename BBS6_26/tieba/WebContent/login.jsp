<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/global.css">
		<script src="res/layui/layui.js"></script>
		<script type="text/javascript">
    function refreshCode() {
		var vcode=document.getElementById("vcode");
		vcode.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
	}
    </script>
	</head>

	<body>
		<iframe src="head.jsp" scrolling="no" width="100%" height="65px"></iframe>
		<div class="main layui-clear">
			<div class=" layui-container fly-marginTop">
				<div class="fly-panel fly-panel-user" pad20="">
					<div class="layui-tab layui-tab-brief" lay-filter="user">
						<ul class="layui-tab-title">
							<li class="layui-this">登入</li>
							<li>
								<a href="register.jsp">注册</a>
							</li>
						</ul>
						<div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
							<div class="layui-tab-item layui-show">
								<div class="layui-form layui-form-pane">
									<form method="post" action="${pageContext.request.contextPath}/userFindServlet">
										<div class="layui-form-item"> <label for="L_email" class="layui-form-label">用户名</label>
											<div class="layui-input-inline"> <input type="text" id="userName" name="uname" required=""  placeholder="请输入用户名" lay-verify="required" autocomplete="off" class="layui-input"> </div>
										</div>
										<div class="layui-form-item"> <label for="L_pass" class="layui-form-label">密码</label>
											<div class="layui-input-inline"> <input type="password" id="L_pass" name="psw"  placeholder="请输入密码" required="" lay-verify="required" autocomplete="off" class="layui-input"> </div>
										</div>
										<div class="layui-form-item"><label for="L_pass" class="layui-form-label">验证码</label>
										<div class="layui-input-inline"><input type="text" id="L_pass" name="verifycode"  placeholder="请输入验证码" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
										<div style="padding-top: 2px"><a href="javascript:refreshCode()" ><img src="${pageContext.request.contextPath}/checkCodeServlet"  title="看不清点击刷新" id="vcode"/></a></div>
										</div>
										<div class="layui-form-item"> <button class="layui-btn" lay-filter="*" lay-submit="">立即登录</button> <span style="padding-left:20px;"> 
										<div class="layui-form-item"><font color="red">${error}</font></div>
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