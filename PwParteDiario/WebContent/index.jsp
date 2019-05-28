<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
  <%@page import="util.Constante"%>
<%
String titulo= (String)Constante.NOMBRE_SISTEMA_LONG;
String tit= (String) Constante.NOMBRE_SISTEMA;
String contexto = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><%=tit%></title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<%=contexto%>/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=contexto%>/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=contexto%>/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=contexto%>/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=contexto%>/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="<%=contexto%>/index2.html"><b><%=titulo %></b></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Iniciar Sesión</p>

			<form action="Svalidar" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="cip"
						placeholder="CIP" required="required" value="31424836"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="clave"
						placeholder="Contraseña" required="required" value="123456"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				  <div class="container center col-md-8  col-xs-12 col-sm-12 form-control" align="center">
                                    <div  class="container col-md-12 col-sm-12 col-xs-12" align="center" style="text-align: center; align-items: center;">
									<%
										Captcha captcha = Captcha.load(request, "exampleCaptcha");
										captcha.setUserInputID("captchaCode");
										String captchaHtml = captcha.getHtml();
										out.write(captchaHtml);
									%>
									<br>
									<input name="captchaCode" type="text" id="captchaCode"
									class="form-control form-control-lg"  aria-label="captchaCode" aria-describedby="basic-addon1" required="required" style="align-content: center; text-align: center;"/>
								<br>
								</div>

				</div>
<br><br><br><br><br><br>
					<!-- /.col -->
					<div class="form-group has-feedback">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Iniciar
							Sesión</button>
					</div>
					<!-- /.col -->
				
			</form>
			
		</div>
		<c:if test="${msg!=null}">
					<div class="alert alert-danger" align="center">
						<strong>ERROR!</strong> ${msg}
					</div>
				</c:if>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="<%=contexto%>/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="<%=contexto%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="<%=contexto%>/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' /* optional */
			});
		});
	</script>
</body>
</html>
