<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="java.util.ArrayList"%>
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
        <% 
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> genderArray = util.populateList(filename + "Gender_Types");
            ArrayList<String> cityArray = util.populateList(filename + "Cities_Pakistan");
            ArrayList<String> countryArray = util.populateList(filename + "Countries_World");
            ArrayList<String> areaArray = util.populateList(filename + "Areas_Names");

            ArrayList<String> hospitalArray = util.populateList(filename + "Hospitals_Names");
            ArrayList<String> degreeArray = util.populateList(filename + "Doctors_Types");
            ArrayList<String> specialistArray = util.populateList(filename + "Specialist_Choice");
            ArrayList<String> specialtiesArray = util.populateList(filename + "Specialist_Types");

            Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
            String name = doctor.getName();
            String email = doctor.getEmail();
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
                            <li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Profile">
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href="index" class="scroll-link" title="Lofout">
                                    Logout
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <section id="doctorInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Doctor - Create Profile
                            </h1>
                        </div>
                        <form method="post" action="#doctorDegreeInfo" id="doctorProfileInfoForrm" role="form">
                            <div id="doctorProfileInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="name">
                                            Name? *
                                        </label>
                                        <input type="text" class="form-control" name="name" id="name" placeholder="Name?" value="<%= name%>" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">
                                            Email? *
                                        </label>
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Email?" value="<%= email%>" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Next
                                        </button>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="contact">
                                            Where is your contact number? *
                                        </label>
                                        <input type="text" class="form-control" name="contact" id="contactNumber" placeholder="Contact Number?" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="dateOfBirth">
                                            What is your Date of Birth? *
                                        </label>
                                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth?" required>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="gender">
                                            What is your gender? *
                                        </label>
                                        <!-- <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender?"> -->
                                        <select class="form-control" name="gender" id="gender" required>
                                            <%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>"><%= genderArray.get(i) %></option><%} %>
                                        </select> 
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </section>
        <section id="doctorDegreeInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Doctor - Medical Degree Information
                            </h1>
                        </div>
                        <form method="post" action="#hospitalInfo" id="doctorProfileDegreeInfoForrm" role="form">
                            <div id="doctorProfileDegreeInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="degree">
                                            Which medical degree do you hold? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="degree" id="degree" placeholder="Degree?">-->
                                        <select class="form-control" name="degree" id="degree" required>
                                            <%for(int i=0; i<degreeArray.size(); i++){%><option value="<%= degreeArray.get(i) %>"><%= degreeArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="specialist">
                                            Are you a specialist? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="specialist" id="specialist" placeholder="Specialist?">-->
                                        <select class="form-control" name="specialist" id="specialist" required>
                                            <%for(int i=0; i<specialistArray.size(); i++){%><option value="<%= specialistArray.get(i) %>"><%= specialistArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="specialties">
                                            What are your specialties? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="specialties" id="specialties" placeholder="Specialties?">-->
                                        <select class="form-control" name="specialties" id="specialties" required>
                                            <%for(int i=0; i<specialtiesArray.size(); i++){%><option value="<%= specialtiesArray.get(i) %>"><%= specialtiesArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Next
                                        </button>
                                        <br>
                                        <br>
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
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </section>
        <section id="hospitalInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Doctor - Create Profile - Hospital Information
                            </h1>
                        </div>
                        <form method="post" action="home" id="doctorProfileHospitalInfoForrm" role="form">
                            <div id="doctorProfileHospitalInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="hospital">
                                            Which hospital/clinic do you visit? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="hospital" id="hospital" placeholder="Hospital?">-->
                                        <select class="form-control" name="hospital" id="hospital" required>
                                            <%for(int i=0; i<hospitalArray.size(); i++){%><option value="<%= hospitalArray.get(i) %>"><%= hospitalArray.get(i) %></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="visitingHours">
                                            What are your visiting hours? *
                                        </label>
                                        <input type="time" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours?" required>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="feeStructure">
                                            What is your fee structure? *
                                        </label>
                                        <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure?" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="city">
                                            What is your City? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="city" id="city" placeholder="City?">-->
                                        <select class="form-control" name="city" id="city" required>
                                            <%for(int i=0; i<cityArray.size(); i++){%><option value="<%= cityArray.get(i) %>"><%= cityArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="country">
                                            What is your country? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="country" id="country" placeholder="Country?">-->
                                        <select class="form-control" name="country" id="country" required>
                                            <%for(int i=0; i<countryArray.size(); i++){%><option value="<%= countryArray.get(i) %>"><%= countryArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">
                                            What is your area? *
                                        </label>
                                        <!--<input type="text" class="form-control" name="area" id="area" placeholder="Area?">-->
                                        <select class="form-control" name="area" id="area" required>
                                            <%for(int i=0; i<areaArray.size(); i++){%><option value="<%= areaArray.get(i) %>"><%= areaArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Submit
                                        </button><br>
                                    </div>
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
            var counter = 1;
            function addInput(divName)
            {
                var newdiv = document.createElement('div');
                newdiv.innerHTML = "Entry " + (counter + 1) + "<label for='degree'>Which medical degree do you hold? *</label>";
                document.getElementById(divName).appendChild(newdiv);
                counter++;
            }
        </script>
    </body>
</html>
<!--<input type="button" value="Add More" onClick="addInput('div1');">-->
