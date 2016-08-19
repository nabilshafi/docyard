<%@page import="com.fyp.swdrs.bo.Patient"%>
<%@page import="com.fyp.swdrs.bo.Doctor"%>
<%@page import="com.fyp.swdrs.bo.Admin"%>
<%@page import="com.fyp.swdrs.utility.Constants"%>
<%@page import="com.fyp.swdrs.controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
            SWDRS - Create Profile
        </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen">
	<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
	<link href="css/animate.css" rel="stylesheet" media="screen">
	<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link rel="stylesheet" href="css/styles.css">
	<link href="font/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <header class="header">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
                        <span class="sr-only">
                            Toggle navigation
                        </span> 
                        <span class="icon-bar"> </span> 
                        <span class="icon-bar"> </span> 
                        <span class="icon-bar"> </span> 
                    </button>
                    <a>
                        <b>
                            <i>
                                <h1>
                                    SWDRS
                                </h1>
                            </i>
                        </b>
                    </a> 
                </div>
                <nav class="navbar navbar-inverse" role="navigation">
                    <div id="main-nav" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav" id="mainNav">
                            <li>
                                <a href="home.jsp" class="scroll-link" title="Home">
                                    Home
                                </a>
                            </li>
                            <li class="active" id="firstLink">
                                <a href="adminProfile.jsp" class="scroll-link" title="Profile">
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href="index.jsp" class="scroll-link" title="Logout">
                                    Logout
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <section id="feedback" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Admin - Create Profile
                            </h1>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="createDoctorProfileSuccess.jsp" id="doctorProfileForrm" role="form">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="name">
                                        Name? *
                                    </label>
                                    <input type="text" class="form-control" name="name" id="name" placeholder="Name?">
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        Email? *
                                    </label>
                                    <input type="text" class="form-control" name="email" id="email" placeholder="Email?">
                                </div>
                                <div class="form-group">
                                    <label for="hospital">
                                        Which hospital/clinic do you visit? *
                                    </label>
                                    <input type="text" class="form-control" name="hospital" id="hospital" placeholder="Hospital?">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="visitingHours">
                                        What are your visiting hours? *
                                    </label>
                                    <input type="text" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours?">
                                </div>
                                <div class="form-group">
                                    <label for="feeStructure">
                                        What is your fee structure? *
                                    </label>
                                    <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure?">
                                </div>
                                <div class="form-group">
                                    <label for="location">
                                        Where is/are the hospital located? *
                                    </label>
                                    <input type="text" class="form-control" name="location" id="location" placeholder="Location?">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="degree">
                                        Which medical degree do you hold? *
                                    </label>
                                    <input type="text" class="form-control" name="degree" id="degree" placeholder="Degree?">
                                </div>
                                <div class="form-group">
                                    <label for="specialist">
                                        Are you a specialist? *
                                    </label>
                                    <input type="text" class="form-control" name="specialist" id="specialist" placeholder="Specialist?">
                                </div>
                                <div class="form-group">
                                    <label for="specialties">
                                        What are your specialties? *
                                    </label>
                                    <input type="text" class="form-control" name="specialties" id="specialties" placeholder="Specialties?">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Submit
                                    </button><br>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <section class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 text-center"> 
                        Copyright 2015 | All Rights Reserved By SWDRS. 
                    </div>
                </div>
            </div>
        </section>
        <script src="js/modernizr-latest.js"> </script> 
        <script src="js/jquery-1.8.2.min.js" type="text/javascript"> </script> 
        <script src="js/bootstrap.min.js" type="text/javascript"> </script> 
        <script src="js/jquery.isotope.min.js" type="text/javascript"> </script> 
        <script src="js/fancybox/jquery.fancybox.pack.js" type="text/javascript"> </script> 
        <script src="js/jquery.nav.js" type="text/javascript"> </script> 
        <script src="js/jquery.fittext.js"> </script> 
        <script src="js/waypoints.js"> </script> 
        <script src="js/custom.js" type="text/javascript"> </script> 
        <script src="js/owl-carousel/owl.carousel.js"> </script>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'> </script>
        <script src="js/index.js"> </script>
    </body>
</html>
