<%@page import="com.fyp.swdrs.bo.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
            SWDRS - Home
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
        <%
            Admin admin = (Admin)request.getSession().getAttribute("admin");
            String name = admin.getName();
        %>
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
                                    SWDRS - Welcome <%= name%>
                                </h1>
                            </i>
                        </b>
                    </a> 
                </div>
                <nav class="navbar navbar-inverse" role="navigation">
                    <div id="main-nav" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav" id="mainNav">
                            <li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Home">
                                    Home
                                </a>
                            </li>
                            <li class="active" id="firstLink">
                                <div class="dropdown">
                                    <button onmouseover="myFunction()" class="dropbtn scroll-link" title="Create">
                                        Create
                                    </button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="create1" class="scroll-link" title="Gender">
                                            Gender
                                        </a>
                                        <a href="create2" class="scroll-link" title="Income Group">
                                            Income Group
                                        </a>
                                        <a href="create3" class="scroll-link" title="Degree">
                                            Degree
                                        </a>
                                        <a href="create4" class="scroll-link" title="Specialties">
                                            Specialties
                                        </a>
                                        <a href="create5" class="scroll-link" title="Hospital">
                                            Hospital
                                        </a>
                                        <a href="create6" class="scroll-link" title="Day">
                                            Days
                                        </a>
                                        <a href="create7" class="scroll-link" title="City">
                                            City
                                        </a>
                                        <a href="create8" class="scroll-link" title="Area">
                                            Area
                                        </a>
                                        <a href="create9" class="scroll-link" title="Symptom">
                                            Symptom
                                        </a>
                                        <a href="create10" class="scroll-link" title="Disease">
                                            Disease
                                        </a>
                                        <a href="create11" class="scroll-link" title="Feedback Question">
                                            Feedback Question
                                        </a>
                                        <a href="create12" class="scroll-link" title="Address">
                                            Address
                                        </a>
                                    </div>
                                </div>
                            </li>
                           <li>
                                <a href="index" class="scroll-link" title="Logout">
                                    Logout
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <section id="home">
            <div class="banner-container"> 
                <img src="images/banner1.jpg" alt="banner">
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
        <script>
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }
        window.onclick = function(event) {
            if (!event.target.matches('.dropbtn')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }
        </script>
    </body>
</html>
