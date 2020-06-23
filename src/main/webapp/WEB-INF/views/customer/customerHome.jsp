<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="java.util.List"%>
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

<title>Customer Dashbord</title>
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
				<li class="nav-item active"><a class="nav-link"
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
		<c:if test = "${registerStatus !=null}">
    		<script type="text/javascript">
    			alert("${registerStatus}");
    		</script>
        </c:if>
<%--         <c:if test = "${status != null}"> --%>
<!--     		<div class="alert alert-danger d-flex justify-content-center"> -->
<%--             	<h3>${status}</h3> --%>
<!--     		</div>  -->
<%--         </c:if> --%>
		<div class="my-input">
			<h1 class="well text-center">Add Order Request</h1>
			<div class="col-lg-12 well">
				<div class="row">
					<form action="/customer/add-item" method="post" >
						<div class="col-sm-12">
								<div id="TextBoxDiv1">
									<label>Item Name : </label>
									        <input type='text' id='tb2' name="itemName" required>
									 <label>Specification : </label>
									 		<input	type='text' id='tb3' name="itemDescription">
									 		<input	type='hidden' value="1" name="orderId">
								</div>
						</div>
						<input type="submit" class="btn btn-primary" value='Add Item' id='addButton'> 
					</form>
					<div>
						<table class="table">
							<caption>List of Items</caption>
							<thead>
								<tr>
									<th scope="col">Sl.</th>
									<th scope="col">Item Name</th>
									<th scope="col">Item Description</th>
									<th scope="col">Order Id</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="itm" items="${itemList}" varStatus="myIndex">
									<tr>
            							<th scope="row">${myIndex.index+1}</th> 
										<td>${itm.itemName}</td>
										<td>${itm.itemDescription}</td>
										<td>${itm.orderId }</td>
										<td><a href="customer/delete-item/${myIndex.index}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<section class="col-sm-12">
						<h3 class="text-center text-warning">Source Address</h3>
						<div class="container">
						<form action="/customer/submit-order" method="post">
							<div class="row">
								<div class="col-sm">
									House No: <input type="text" value="${customer.address.houseNo}" name="houseNo" required>
								</div>
								<div class="col-sm">
									Appartment Or HomeName:<input type="text" value="${customer.address.apartmentOrHomeName}" name="apartmentOrHomeName" required>
								</div>
								<div class="col-sm">
									District :<input type="text" value="${customer.address.district}" name="district" required>
								</div>
								<div class="col-sm">
									State :<input type="text" value="${customer.address.state}" name="state" required>
								</div>
								<div class="col-sm">
									City Name :<input type="text" value="${customer.address.cityName}" name="cityName" required>
								</div>
								<div class="col-sm">
									Police Station: <input type="text" value="${customer.address.policeStation}" name="policeStation" required>
								</div>
								<div class="col-sm">
									Land Mark :<input type="text" value="${customer.address.landMark}" name="landMark" required>
								</div>
								<div class="col-sm">
									Pin Code: <input type="number" value="${customer.address.pin}" name="pin" required>
								</div>
							</div>
						</div>
						<h3 class="text-center text-primary">Destination Address</h3>
						<div class="container">
							<div class="row">
								<div class="col-sm">
									House No: <input type="text" name="dhouseNo" required>
								</div>
								<div class="col-sm">
									Appartment Or HomeName:<input type="text" name="dapartmentOrHomeName" required>
								</div>
								<div class="col-sm">
									District :<input type="text" name="ddistrict" required>
								</div>
								<div class="col-sm">
									State :<input type="text" name="dstate" required>
								</div>
								<div class="col-sm">
									City Name :<input type="text"  name="dcityName" required>
								</div>
								<div class="col-sm">
									Police Station :<input type="text" name="dpoliceStation" required>
								</div>
								<div class="col-sm">
									Land Mark: <input type="text" name="dlandmark" required>
								</div>
								<div class="col-sm">
									Pin Code: <input type="number" name="dpin" required>
								</div>
							</div>
						</div>
					</section>
					<div>
						<label for="exampleFormControlSelect1">Choose Type of Service</label>
							 <select class="form-control" name="serviceType">
								<option>home</option>
								<option>product</option>
							</select>
							<label for="Duration">Date of Service</label>
							<input type="date" name="dateOfService" required>
							<input type="hidden" value="${customer.address.houseNo}" name="addressHouseNo"/>
							<input type="hidden" value="${customer.userId}" name="userId"/>
							<input type='submit' class="btn btn-success"
								value='Submit Request' />
						</form>
					</div>
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