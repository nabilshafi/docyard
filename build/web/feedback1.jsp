<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
            SWDRS - Feedback
        </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen">
	<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/stylesheet.css">
	<link href="css/animate.css" rel="stylesheet" media="screen">
	<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link href="font/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <% 
            Patient patient = (Patient)request.getSession().getAttribute("patient");
            String name = patient.getName();
            //String email = patient.getEmail();
            int count = patient.getUserHasProfile();
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> doctorNameArray = util.populateDoctorNameList(filename);
//            ArrayList<String> doctorNameArray = util.removeDuplicates(util.populateDoctorNameList(filename));
            //ArrayList<String> doctorEmailArray = util.populateDoctorEmail(filename + "DoctorProfile");
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
                                <a href="home" class="scroll-link" title="Home">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="profile" class="scroll-link" title="Profile">
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href="search" class="scroll-link" title="Search Doctor">
                                    Search
                                </a>
                            </li>
                            <li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Feedback">
                                    Feedback
                                </a>
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
        <section id="feedback" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Feedback
                            </h1>
                            <br>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="feedbacksuccess" id="feedbackfrm" role="form">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="patientName">
                                        Patient Name: *
                                    </label>
                                    <input type="text" class="form-control" name="patientName" id="patientName" placeholder="Enter Name" title="Please enter your name" value="<%= name%>" readonly required>
                                </div>
                                <div class="form-group">
                                    <label for="doctorName">
                                        Doctor Name: *
                                    </label>
                                    <select class="form-control" name="doctorName" id="doctorName" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<doctorNameArray.size(); i++){%><option value="<%= doctorNameArray.get(i) %>"><%= doctorNameArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <%-- <div class="form-group">
                                    <label for="patientEmail">
                                        Patient Email: *
                                    </label>
                                    <input type="text" class="form-control" name="patientEmail" id="patientEmail" placeholder="Enter Email" title="Please enter a valid email address" value="<%= email%>" readonly required>
                                </div> --%>
                                <div class="form-group">
                                    <label for="question1">
                                        Question 1: *
                                    </label>
                                    <input type="text" class="form-control" name="question1" id="question1" placeholder="Question" title="Question" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Submit
                                    </button>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="question2">
                                        Question 2: *
                                    </label>
                                    <input type="text" class="form-control" name="question2" id="question2" placeholder="Question" title="Question" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="question3">
                                        Question 3: *
                                    </label>
                                    <input type="text" class="form-control" name="question3" id="question3" placeholder="Question" title="Question" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="question4">
                                        Question 4: *
                                    </label>
                                    <input type="text" class="form-control" name="question4" id="question4" placeholder="Question" title="Question" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="doctorRating">
                                        Doctor Rating: *
                                    </label>
                                    <span class="starRating">
                                        <input id="rating5" type="radio" name="rating" value="5" required>
                                        <label for="rating5">5</label>
                                        <input id="rating4" type="radio" name="rating" value="4" required>
                                        <label for="rating4">4</label>
                                        <input id="rating3" type="radio" name="rating" value="3" required>
                                        <label for="rating3">3</label>
                                        <input id="rating2" type="radio" name="rating" value="2" required>
                                        <label for="rating2">2</label>
                                        <input id="rating1" type="radio" name="rating" value="1" required>
                                        <label for="rating1">1</label>
                                    </span>
                                    <!--<input type="text" class="form-control" name="userEmail" id="userEmail" placeholder="Enter Email" title="Please enter a valid email address"  value="" > -->
                                </div>
                                <%-- <div class="form-group">
                                    <label for="doctorEmail">
                                        Doctor Email: *
                                    </label>
                                    <select class="form-control" name="doctorEmail" id="doctorEmail" required>
                                        <option value="">Select
                                        <%for(int i=0; i<doctorEmailArray.size(); i++){%><option value="<%= doctorEmailArray.get(i) %>"><%= doctorEmailArray.get(i) %></option><%} %>
                                    </select>
                                </div> --%>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="question5">
                                        Question 5: *
                                    </label>
                                    <input type="text" class="form-control" name="question5" id="question5" placeholder="Question" title="Question" value="" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="feedback">
                                        Feedback: *
                                    </label>
                                    <textarea name="feedbackTextArea" class="form-control" id="feedbackTextArea" cols="5" rows="5" placeholder="Feedback: " title="Please enter your feedback" required></textarea>
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
