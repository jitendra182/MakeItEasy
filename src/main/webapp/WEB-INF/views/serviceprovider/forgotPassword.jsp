<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">

<title>Security Question</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/"> <img src="/image/logo.jpg"
			width="30" height="30" class="d-inline-block align-top" alt="logo">
			MakeItEasy
		</a>
	</nav>
	<div class="container">
		<h1>${status}</h1>
		<div style="margin-top: 10%">
			<form action="/customer/valid-security-pass" method="post">
				<div class="row justify-content-center">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="userId">Enter User ID</label> <input type="text"
								class="form-control" id="userId" name="userId" required>
						</div>
						<div class="form-group">
							<label for="securityQuestion">Choose Security Question</label> <select
								class="form-control" id="securityQuestion" name="question">
								<option>What is your pet name</option>
								<option>What is your home town name</option>
								<option>What is your Date of Birth</option>
								<option>what is your Blood Group</option>
								<option>What is your 1st School Name</option>
							</select>
						</div>
						<div class="form-group">
							<label for="answer">Answer</label> <input type="text"
								class="form-control" id="answer" name="ans" required>
						</div>
						<div class="form-group">
							<label for="password">Enter New Password</label> <input
								type="text" class="form-control" id="password" name="pass"
								required>
						</div>
						<div>
							<button class="btn btn-primary" type="submit">Set
								Password</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>

</html>