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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    

    <title>Address</title>
    <style>
		body {
    		background: #dedede;
			}
	</style>
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
                    <a class="nav-link" href="/admin">Dashbord <span class="sr-only">(current)</span></a>
                <li class="nav-item">
                <a class="nav-link" href="/admin/service-provider-list">Service Provider List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/customers-list">Customer List</a>
                </li>
                <li class="nav-item">
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
	<div class="container ">
		<div class="row">
            <div class="col-lg-6">
                <h1 class="mt-5 bg-warning text-white">Source Address</h1>
                <div id="sourceAddress">
                    <div class="row">
                        <div class="col-md-6">
                            <label>House No</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.houseNo}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Apartment Or HomeName</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.apartmentOrHomeName}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>State</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.state}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>District</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.district}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>City Name</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.cityName }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Police Station</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.policeStation }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Land Mark</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.landMark }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Pin Code</label>
                        </div>
                        <div class="col-md-6">
                            <p>${source.pin}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <h1 class="bg-success text-white mt-5">Destination address</h1>
                <div id="destAddress">
                    <div class="row">
                        <div class="col-md-6">
                            <label>House No</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.houseNo}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Apartment Or HomeName</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.apartmentOrHomeName}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>State</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.state}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>District</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.district}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>City Name</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.cityName }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Police Station</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.policeStation }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Land Mark</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.landMark }</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Pin Code</label>
                        </div>
                        <div class="col-md-6">
                            <p>${dest.pin}</p>
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