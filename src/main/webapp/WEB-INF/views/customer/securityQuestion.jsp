<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="/customer">Dashbord <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/customer/profile">My Profile</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/customer/customer-order-request">Request History</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/customer/customer-order-history">Order History</a></li>
			</ul>
			<!-- Button trigger modal -->
			<div class="dropdown">
				<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
					id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ${customer.firstName} </a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="/customer/security-qus">Update
						SecQ</a> <a class="dropdown-item" href="/customer/change-pass">Change
						Pass</a>
				</div>
			</div>
			<button type="button" class="btn btn-success my-2 my-sm-0"
				data-toggle="modal" data-target="#exampleModal">Logout</button>
		</div>
	</nav>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Logout</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Are you sure to logout</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">No</button>
					<a href="/customer/logout" class="btn btn-primary" role="button"
						aria-disabled="true">Yes</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
	<c:if test = "${status != null}">
    	<div class="alert alert-success d-flex justify-content-center">
            	<h3>${status}</h3>
    	</div> 
    </c:if>
		<div style="margin-top: 10%">
			<div class="row justify-content-center jumbotron">
				<div class="col-sm-6">
					<form action="/customer/security-qus" method="post">
						<div class="form-group">
							<label for="exampleFormControlSelect1">Select a security
								question !</label> <select class="form-control"
								id="exampleFormControlSelect1" name="question">
								<option>What is your pet name</option>
								<option>What is your home town name</option>
								<option>What is your Date of Birth</option>
								<option>what is your Blood Group</option>
								<option>What is your 1st School Name</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Answer</label> <input
								type="text" class="form-control" id="exampleInputPassword1"
								name="ans" required>
						</div>
						<input type="hidden" value="${customer.userId}" name="userId">
						<button type="submit" class="btn btn-primary">Change
							Security Question</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>

</html>