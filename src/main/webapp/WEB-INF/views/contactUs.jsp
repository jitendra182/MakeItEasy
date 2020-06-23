<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Contact Us</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="/">
            <img src="/image/logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
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
                <li class="nav-item">
                    <a class="nav-link" href="/serviceprovider">Service Provider</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/aboutUs">About Us</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/contactUs">Contact Us</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
    	<div class="row">
    		<div class="col-xl-12 bg-warning">
    			<h1 class="text-center text-uppercase">Have Some Question ?</h1>
    			<p class="text-center text-capitalize	"> Feel free to ask any query, we will reach you as soon as possible.
    		</div>
    	</div>
        <div class="row mt-5 bg-secondary">
            <div class="col-xl-6">
            	<img src="image/ContactUs.png" class="img-fluid" alt="Responsive image">
            </div>
            <div class="col-6">
                <div class="card">
                    <h5 class="card-header text-center">Contact Us Form</h5>
                    <div class="card-body">
                        <p class="card-text">Do you have any questions? Please do not hesitate to contact us
                            directly. Our team will come back to you within
                            a matter of hours to help you.</p>
                        <form action="/contact" method="post">
                            <div class="form-group">
                                <label for="formGroupExampleInput2">Email Address</label>
                                <input type="email" class="form-control" id="emailid" name="emailId" placeholder="Enter your mail id" required>
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput">Name</label>
                                <input type="text" class="form-control" id="fname" name="name" placeholder="Enter your name" required>
                            </div>
                            <div class="form-group">
                                <label for="formGroupExampleInput2">Enter your message</label>
                                <textarea class="form-control rounded-0" id="message" name="msg" rows="5" required></textarea>
                            </div>
                            <button type="submit" class="btn btn-lg btn-info">Submit</button>
                            <h4 class="text-center text-success">${msg}</h4>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <section class="row mt-5 justify-content-center">
        		<div class="col-xl-4">
        			<div class="row justify-content-center">
        				<div class="col">
			        		<a href="#" class="fa fa-facebook">Facebook</a>
        				</div>
        				<div class="col">
							<a href="#" class="fa fa-twitter">Twitter</a>
        				</div>
        				<div class="col">
							<a href="#" class="fa fa-instagram">Instagram</a>
        				</div>
        			</div>
        		</div>
        </section>
    </div>
    
    <footer class="container-fluid">
        	<div class="my-foot-left">Copyrights &copy 2020 jeetnayak.com All Rights Reserved.</div>
    </footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>