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

    <title>Dashbord</title>
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
                <li class="nav-item active">
                    <a class="nav-link" href="/serviceprovider">Dashbord <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/serviceprovider/profile">My Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/serviceprovider/service-history">Service History</a>
                </li>
            </ul>
            <!-- Button trigger modal -->
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${serviceProvider.companyName}
                </a>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                  <a class="dropdown-item" href="/serviceprovider/security-qus">Update SecQ</a>
                  <a class="dropdown-item" href="/serviceprovider/change-pass">Change Pass</a>
                </div>
              </div>
            <button type="button" class="btn btn-success my-2 my-sm-0" data-toggle="modal"
                data-target="#exampleModal">Logout</button>
        </div>
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
                    <a href="/serviceprovider/logout" class="btn btn-primary" role="button" aria-disabled="true">Yes</a>
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
    	<c:if test = "${orders.isEmpty()}">
    		<div class="alert alert-danger d-flex justify-content-center mt-5">
            	<h3>No request found </h3>
    		</div> 
        </c:if>
        <c:if test = "${priceSet != null}">
    		<script type="text/javascript">
    			alert("${priceSet}");
    		</script>
        </c:if>
		<c:forEach var="order" items="${orders}">
			<section class="myOrderContainer">
				<div class="row">
					<div class="col-sm">Order Id : ${order.orderId}</div>
					<div class="col-sm">Service Type : ${order.serviceType}</div>
					<div class="col-sm">User Id : ${order.userId}</div>
					<div class="col-sm">Date Of Service : ${order.dateOfService}.</div>
					<div class="col-sm"><a class="btn btn-primary" href="/serviceprovider/address?shno=${order.sourceAddHouseNo}&dhno=${order.destAddHouseNo}">View Address</a></div>
					<div class="col-sm"><a class="btn btn-primary" href="/serviceprovider/itemlist/${order.orderId}">Items List</a></div>
				</div>
				<div>
					<form class="form-inline" action="serviceprovider/submit-price"
						method="post">
						<input type="hidden" value="${order.orderId}" name="orderId">
						<div class="form-group mx-sm-3 mb-2">
							<input type="number" class="form-control" name="price"
								placeholder="Enter Amount" required>
						</div>
						<input type="hidden" value="${serviceProvider.userId}" name="spId">
						<button type="submit" class="btn btn-primary mb-2">Submit</button>
					</form>
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