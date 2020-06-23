<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">

    <title>Order Requests</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="../">
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
                    <a class="nav-link" href="/admin">Dashbord <span class="sr-only">(current)</span></a>
                <li class="nav-item">
                <a class="nav-link" href="/admin/service-provider-list">Service Provider List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/customers-list">Customer List</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/order-request">Order Requests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/service-completed">Services Completed</a>
                </li>
            </ul>
            <!-- Button trigger modal -->
            <p>${admin.firstName}</p>
            <button type="button" class="btn btn-success my-2 my-sm-0" data-toggle="modal"
                data-target="#logoutModal">Logout</button>
        </div>
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Logout</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure to logout
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <a href="/admin/logout" class="btn btn-primary" role="button" aria-disabled="true">Yes</a>
                </div>
            </div>
        </div>
    </div>
<div class="container">
		<c:if test = "${orders.isEmpty()}">
    			<div class="alert alert-danger d-flex justify-content-center mt-5">
            		<h3>No order request yet</h3>
    			</div> 
        </c:if>
		<c:forEach var="order" items="${orders}">
			<section class="myOrderContainer">
				<div class="row">
					<div class="col-sm">Order Id : ${order.orderId}</div>
					<div class="col-sm">Service Type : ${order.serviceType}</div>
					<div class="col-sm">User Id : ${order.userId}</div>
					<div class="col-sm">Date Of Service : ${order.dateOfService}</div>
					<div class="col-sm"><a class="btn btn-primary" href="/admin/address/${order.sourceAddHouseNo}/${order.destAddHouseNo}">View Address</a></div>
					<div class="col-sm"><a class="btn btn-primary" href="/admin/itemlist/${order.orderId}">Items List</a></div>
				</div>
			</section>
		</c:forEach>
	</div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>

</html>