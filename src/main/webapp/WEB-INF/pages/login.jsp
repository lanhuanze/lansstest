<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>欢迎登录</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="resources/css/signin.css" rel="stylesheet">
</head>
<body>
	<!-- Bootstrap
    <h1>Hello, world!</h1>
    <script src="resources/js/jquery-1.11.1.js"></script>
    <script src="resources/js/bootstrap.js"></script>
	-->
	<div class="container">

		<form name='loginForm'
			action="<c:url value='j_spring_security_check' />" method='POST'
			class="form-signin" role="form">
			<c:if test="${param.error != null}">
				<h3 class="form-error">用户名或密码错误</h3>
			</c:if>
			<c:if test="${param.logout != null}">
				<h3 class="form-logout">你已经退出系统</h3>
			</c:if>
			<h2 class="form-signin-heading">请登录</h2>
			<input type="email" id="username" name="username"
				class="form-control" placeholder="邮箱" required autofocus> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="密码" required>
			<div class="checkbox">
				<label> <input id="_spring_security_remember_me"
					name="_spring_security_remember_me" type="checkbox" value="false" />
					记住登录状态
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
			<!-- 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			 -->
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</body>
</html>