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
            String doctorName = (String)request.getSession().getAttribute("doctorName");
            String name = patient.getName();
            String email = patient.getEmail();
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> doctorNameArray1 = util.populateDoctorNameList(filename);
            ArrayList<String> doctorNameArray = util.removeDuplicates(doctorNameArray1);
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
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="feedback1success" id="feedbackfrm" role="form">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="patientName">
                                        Patient Name:*
                                    </label>
                                    <input type="text" class="form-control" name="patientName" id="patientName" placeholder="Enter Name" title="Please enter your name" value="<%= name%>" readonly required>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="patientEmail">
                                        Patient Email:*
                                    </label>
                                    <input type="text" class="form-control" name="patientEmail" id="patientEmail" placeholder="Enter Email" title="Please enter a valid email address" value="<%= email%>" readonly required>
                                </div> 
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="doctorName">
                                        Doctor Name:*
                                    </label>
                                    <select class="form-control" name="doctorName" id="doctorName" onchange="myFunction()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<doctorNameArray.size(); i++){%><option value="<%= doctorNameArray.get(i) %>" <%= (doctorNameArray.get(i).equals(doctorName))?"selected":"" %> ><%= doctorNameArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Next
                                    </button>
                                    <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
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
        <script>
            function myFunction() 
            {
                var x = document.getElementById("doctorName").value;
                x = "Dr. " + x;
                if(x === "") {
                    x = "the doctor";
                }
                document.getElementById("behaviour1Label").innerHTML = "Was " + x + " warm and friendly?*";
                document.getElementById("behaviour2Label").innerHTML = "Was " + x + " respectful?*";
                document.getElementById("behaviour3Label").innerHTML = "Was " + x + " attentive?*";
                document.getElementById("behaviour4Label").innerHTML = "Was " + x + " concerned?*";
                document.getElementById("behaviour5Label").innerHTML = "Was " + x + " telling things properly?*";
                document.getElementById("behaviour6Label").innerHTML = "Did " + x + " give you ample time?*";
                document.getElementById("interaction1Label").innerHTML = "Did " + x + " understand and ask questions regarding your health history?*";
                document.getElementById("interaction2Label").innerHTML = "Did " + x + " discuss treatment option with you?*";
                document.getElementById("interaction3Label").innerHTML = "Did " + x + " explain drugs, other treatments, their expected effects and side effects?*";
                document.getElementById("interaction4Label").innerHTML = "Did " + x + " answer questions to your satisfaction?*";
                document.getElementById("interaction5Label").innerHTML = "Did " + x + " give you advice on what to do if symptoms persist or worsen?*";
                document.getElementById("interaction6Label").innerHTML = "Did " + x + " give advice to you on ways to stay healthy?*";
                document.getElementById("interaction7Label").innerHTML = "Did " + x + " treated you well?*";
                document.getElementById("interaction8Label").innerHTML = "Would you be happy to see " + x + " again?*";
                document.getElementById("interaction9Label").innerHTML = "Do you think " + x + " is good and will give you the right care?*";
                document.getElementById("diagnosisTimeLabel").innerHTML = "How much time did " + x + " take in diagnosis?*";
                document.getElementById("scaleLabel").innerHTML = "On the scale of 1-10, (1 being the lowest and 10 being the highest), mention your extent of satisfaction?*";
            }
        </script>
    </body>
</html>
