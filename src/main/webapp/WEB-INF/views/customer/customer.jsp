<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/login.css">

<title>Customer Login</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/"> <img src="/image/logo.jpg"
			width="30" height="30" class="d-inline-block align-top" alt="logo">
			MakeItEasy
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/">Home <span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item"><a class="nav-link" href="/admin">Admin
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/customer">Customer</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/serviceprovider">Service Provider</a></li>
				<li class="nav-item"><a class="nav-link" href="/aboutUs">About
						Us</a></li>
				<li class="nav-item"><a class="nav-link" href="/contactUs">Contact
						Us</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<c:if test = "${msg != null}">
    		<div class="alert alert-danger d-flex justify-content-center">
            	<h3>${msg}</h3>
    		</div> 
        </c:if>
		<h2 class="text-success text-center">${status}</h2>
		<div id="logindiv">
			<div class="card-body">
				<img src="../image/avtar.png" alt="Avatar" class="avatar">
				<form action="/customer/login" method="post">
					<div class="form-group">
						<label for="UserIdInput">Username</label> <input type="text"
							class="form-control" name="userId" placeholder="Username" id="UserIdInput"
							required>
					</div>
					<div class="form-group">
						<label for="PasswordInput">Password</label> <input type="password"
							class="form-control" name="passwd" placeholder="Password" id="PasswordInput"
							required>
					</div>
					<button type="submit" class="btn btn-primary" id="loginBtn">Login</button>
				</form>
				<span class="psw">Forgot <a href="/customer/forgot-pass">password?</a></span>&nbsp;&nbsp;&nbsp;
				<span class="psw">New User <a href="customer/registration">Sign
						Up</a></span>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>

<script type="text/javascript">

	$("#PasswordInput").keyup(
			function() {
				var pw = $("#PasswordInput").val();
				if (pw.length < 6) {
					$("#loginBtn").prop('disabled', true);
				} else {
					$("#loginBtn").prop('disabled', false);
				}

			});
</script>

</html>