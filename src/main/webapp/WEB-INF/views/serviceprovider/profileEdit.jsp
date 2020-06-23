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

<title>Profile</title>
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
					href="/serviceprovider">Dashbord <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="/serviceprovider/profile">My Profile</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/serviceprovider/service-history">Service History</a></li>
			</ul>
			<!-- Button trigger modal -->
			<div class="dropdown">
				<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
					id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ${serviceProvider.companyName} </a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
					<a class="dropdown-item" href="/serviceprovider/security-qus">Update
						SecQ</a> <a class="dropdown-item" href="/serviceprovider/change-pass">Change
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
					<a href="/serviceprovider/logout" class="btn btn-primary"
						role="button" aria-disabled="true">Yes</a>
				</div>
			</div>
		</div>
	</div>
	<!------ Include the above in your HEAD tag ---------->
	<div class="container emp-profile">
		<form action="/serviceprovider/update-profile" method="post">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img src="/image/profile_Image.png" alt="profile" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h3>${serviceProvider.companyName}</h3>
						<p></p>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">Profile</a></li>
							<li class="nav-item"><a class="nav-link" id="profile-tab"
								data-toggle="tab" href="#profile" role="tab"
								aria-controls="profile" aria-selected="false">Address</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2">
					<input type="submit" value="Save Changes" class="btn btn-success"/>
					<a href="/serviceprovider/profile" class="btn btn-danger">Cancel</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<div class="row">
								<div class="col-md-6">
									<label>User Id</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
											<input type="text" class="form-control" value="${serviceProvider.userId}" disabled>
									</div>
									<input type="hidden" value="${serviceProvider.userId}" name="userId">
									<input type="hidden" value="${serviceProvider.password}" name="password">
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Name</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
								 		<input type="text" class="form-control" value="${serviceProvider.companyName}" 
								 			name="companyName" required >
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.emailId}" name="emailId">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Phone</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.phoneNo}" name="phoneNo">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Service Provider Type</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<select class="form-control" name="serviceProviderType" >
                               				<option value="${serviceProvider.serviceProviderType}">${serviceProvider.serviceProviderType} shifting</option>
                               				<option value="product">Product Shifting</option>
                           				</select>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="profile" role="tabpanel"
							aria-labelledby="profile-tab">
							<div class="row">
								<div class="col-md-6">
									<label>House No</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.houseNo}" name="address.houseNo">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Apartment Or HomeName</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.apartmentOrHomeName}" name="address.apartmentOrHomeName">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>State</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.state}" name="address.state">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>District</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.district}" name="address.district">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>City Name</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.cityName}" name="address.cityName">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>policeStation</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.policeStation}" name="address.policeStation">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Land Mark</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.landMark}" name="address.landMark">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Pin Code</label>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" value="${serviceProvider.address.pin}" name="address.pin">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>

</html>