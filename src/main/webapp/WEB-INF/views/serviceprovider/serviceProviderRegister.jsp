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

    <title>Service Provider Registration</title>
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
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/serviceprovider/registration">Service Provider</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/aboutUs">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contactUs">Contact Us</a>
                </li>
            </ul>
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
        <form action="/serviceprovider/registration" method="POST">
            <div class="row justify-content-around">
                <div class="col-md-4">
                	<div class="form-group">
						<label for="userId">User Id</label>
						<input type="text" placeholder="Enter User Id" class="form-control" name="userId" required>
					</div>
                	<div class="form-group">
						<label for="password">Password</label>
						<input type="password" placeholder="Enter Password" class="form-control" name="password" required>
                	</div>
                	<div class="form-group">
						<label>Company Name</label>
						<input type="text" placeholder="Enter Company Name" class="form-control" name="companyName" required>
					</div>
					<div class="form-group">
						<label for="email">E-Mail ID</label>
						<input type="email" placeholder="Enter E-mail Id" class="form-control" name="emailId" required>
					</div>
				</div>
            	<div class="col-md-6">
            		<div class="row">
            			<div class="col-md-6">
							<div class="form-group">
								<label for="phoneNo">Phone no</label>
								<input type="number" placeholder="Enter Phone Number" class="form-control" name="phoneNo" required>
							</div>
                			<div class="form-group">
								<label for="serviceProviderType">Service Type</label>
								<select class="form-control" name="serviceProviderType" >
                               		<option value="home">Home Shifting</option>
                               		<option value="product">Product Shifting</option>
                           		</select>
							</div>
                			<div class="form-group">
                    			<label for="address.houseNo">House number</label>
                    			<input type="text" placeholder="Enter House Number" class="form-control" name="address.houseNo" required>
               				 </div>
                			<div class="form-group">
                    			<label for="address.apartmentOrHomeName">Apartment / House Name</label>
                    			<input type="text" placeholder="Enter Appartment Or HomeName" class="form-control"
                       				name="address.apartmentOrHomeName" required>
                			</div>
                			<div class="form-group">
                    			<label>police station</label>
                    			<input type="text" placeholder="Enter Police Station Name" class="form-control"
                        			name="address.policeStation" required>
                			</div>
            			</div>
                		<div class="col-md-6">
                			<div class="form-group">
                    			<label>City</label>
                    			<input type="text" placeholder="Enter city Name " class="form-control" name="address.cityName" required>
                			</div>
                			<div class="form-group">
                    			<label>District</label>
                    			<input type="text" placeholder="Enter District Name" class="form-control" name="address.district" required>
                			</div>
                			<div class="form-group">
                    			<label>State</label>
                    			<input type="text" placeholder="Enter State" class="form-control" name="address.state" required>
                    		</div>
                			<div class="form-group">
                    			<label>Landmark</label>
                    			<input type="text" placeholder="Enter Landmark " class="form-control" name="address.landMark" required>
                			</div>
                			<div class="form-group">
                    			<label>Pin Code</label>
                    			<input type="number" placeholder="Enter Pin Code" class="form-control" name="address.Pin" required>
                			</div>
                		</div>
            		</div>
            		<Button type="submit" class="btn btn-lg btn-success float-right" id="regBtn">Register</Button>
            	</div>
            </div>  
        </form>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="../css/bootstrap.min.css"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>

</html>