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
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">

<title>Price List</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/"> <img src="/image/logo.jpg"
			width="30" height="30" class="d-inline-block align-top" alt="logo">
			MakeItEasy
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
                    <a class="nav-link" href="/customer">Dashbord <span
                            class="sr-only">(current)</span></a>
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
	<c:if test="${priceList.isEmpty()}">
		<div class="alert alert-danger d-flex justify-content-center mt-5">
            	<h3>No Price </h3>
    	</div>
	</c:if>
	<c:if test="${priceList.isEmpty()==false}">
		<table class="table">
			<caption>List of Prices</caption>
			<thead>
				<tr>
					<th scope="col">Sl.</th>
					<th scope="col">Service provider ID</th>
					<th scope="col">Amount</th>
					
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pList" items="${priceList}" varStatus="myIndex">
					<form action="/customer/acceptOrder" method="post">
					<input type="hidden" value="${pList.spId}" name="spId">
					<input type="hidden" value="${pList.price}" name="price">
					<input type="hidden" value="${pList.orderId }" name="orderId">
						<tr>
							<th scope="row">${myIndex.index+1}</th>
							<td>${pList.spId}</td>
							<td>${pList.price}</td>
							<th scope="col"><button type="submit" class="btn btn-success" ${exist}>Accept Request</button></th>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/js/jquery.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>

</html>