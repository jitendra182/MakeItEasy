<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">

    <title>Customer Registration</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="/">
            <img src="/image/logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="logo">
            MakeItEasy
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/admin">Admin </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/customer/registration">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/serviceprovider">Service Provider</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/aboutUs">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contactUs">Contact Us</a>
                </li>
            </ul>
            <!-- Button trigger modal -->
        </div>
    </nav>

	<div class="container">
		<c:if test = "${registerStatus !=null}">
    		<script type="text/javascript">
    			alert("${registerStatus}");
    		</script>
        </c:if>
		<div class="jumbotron">
			<h2 class="text-center">Registration Form</h2>
			<hr>
			<form action="/customer/registration" method="POST">
				<div class="row justify-content-around">
					<div class="col-md-4">
						<div class="form-group">
							<label for="userId">User Id</label> <input type="text"
								placeholder="Enter User Id" class="form-control" name="userId"
								id="userId" required minlength="6">
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								placeholder="Enter Password" class="form-control"
								name="password" id="password" required>
						</div>
						<div class="form-group">
							<label for="firstName">First Name</label> <input type="text"
								placeholder="Enter First Name" class="form-control"
								name="firstName" id="firstName" required>
						</div>
						<div class="form-group">
							<label for="lastName">Last Name</label> <input type="text"
								placeholder="Enter Last Name" class="form-control"
								name="lastName" id="lastName" required>
						</div>
						<div class="form-group">
							<label for="emailId">Email Id</label> <input type="email"
								placeholder="Enter E-mail Id" class="form-control"
								name="emailId" id="emailId" required>
						</div>
					</div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="phoneNo">Phone no</label> <input type="number"
										placeholder="Enter Phone Number" class="form-control"
										name="phoneNo" id="phoneNo" required>
								</div>
								<div class="form-group">
									<label for="houseNo">House no</label> <input type="text"
										placeholder="Enter House Number" class="form-control"
										name="address.houseNo" id="houseNo" required>
								</div>
								<div class="form-group">
									<label for="apartmentOrHomeName">Apartment Or Home Name</label>
									<input type="text" placeholder="Enter Appartment Or HomeName"
										class="form-control" name="address.apartmentOrHomeName"
										id="apartmentOrHomeName" required>
								</div>
								<div class="form-group">
									<label for="policeStation">Police Station </label> <input
										type="text" placeholder="Enter Police Station"
										class="form-control" name="address.policeStation"
										id="policeStation" required>
								</div>
								<div class="form-group">
									<label for="cityName">City</label> <input type="text"
										placeholder="Enter city" class="form-control"
										name="address.cityName" id="cityName" required>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="district">District</label> <input type="text"
										placeholder="Enter District" class="form-control"
										name="address.district" id="district" required>
								</div>
								<div class="form-group">
									<label for="state">State</label> <input type="text"
										placeholder="Enter State" class="form-control"
										name="address.state" id="state" required>
								</div>
								<div class="form-group">
									<label for="landMark">Landmark</label> <input type="text"
										placeholder="Enter Landmark " class="form-control"
										name="address.landMark" id="landMark" required>
								</div>
								<div class="form-group">
									<label for="pin">Pin code</label> <input type="number"
										placeholder="Enter Pin Code" class="form-control"
										name="address.Pin" id="pin" required>
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-lg btn-success float-right"
							id="regBtn">Register</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/myReg.js"></script>
</body>

</html>