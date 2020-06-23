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
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">

<title>Customer Details</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="../"> <img src="/image/logo.jpg"
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
				<li class="nav-item"><a class="nav-link" href="/admin">Dashbord
						<span class="sr-only">(current)</span>
				</a>
				<li class="nav-item"><a class="nav-link"
					href="/admin/service-provider-list">Service Provider List</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/admin/customers-list">Customer List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/admin/order-request">Order Requests</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/admin/service-completed">Services Completed</a></li>
			</ul>
			<!-- Button trigger modal -->
			<p>${admin.firstName}</p>
			<button type="button" class="btn btn-success my-2 my-sm-0"
				data-toggle="modal" data-target="#logoutModal">Logout</button>
		</div>
	</nav>

	<!-- Modal -->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
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
					<a href="/admin/logout" class="btn btn-primary" role="button"
						aria-disabled="true">Yes</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<!------ Include the above in your HEAD tag ---------->
		<div class="container emp-profile">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img src="/image/profile_Image.png" alt="profile" />

					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h3>${cdata.firstName} ${cdata.lastName}</h3>
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
									<p>${cdata.userId}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Name</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.firstName}${cdata.lastName}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.emailId}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Phone</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.phoneNo}</p>
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
									<p>${cdata.address.houseNo}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Apartment Or HomeName</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.apartmentOrHomeName}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>State</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.state}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>District</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.district}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>City Name</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.cityName}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>policeStation</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.policeStation}</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Land Mark</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.landMark}</p>
								</div>

							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Pin Code</label>
								</div>
								<div class="col-md-6">
									<p>${cdata.address.pin}</p>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>

</html>