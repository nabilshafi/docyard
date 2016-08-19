<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
            Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
            String name = doctor.getName();
            String email = doctor.getEmail();
            String contact = (String)request.getSession().getAttribute("contact");
            String gender = (String)request.getSession().getAttribute("gender");
            String dob = (String)request.getSession().getAttribute("dob");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String maxDate = (dateFormat.format(date)).replace("/", "-");
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
                                <a href="index" class="scroll-link" title="Logout">
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
                        <form method="post" action="profile2" id="doctorProfileInfoForrm" role="form" onsubmit="return checkForm(this);">
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
                                        <input type="text" class="form-control" name="email" id="email" placeholder="Email?" value="<%= email%>" readonly required>
                                    </div>
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
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="contact">
                                            What is your contact number? *
                                        </label>
                                        <input type="text" class="form-control" name="contact" id="contactNumber" placeholder="Contact Number? (+92xxxxxxxxxx)" value="<%= contact %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="dateOfBirth">
                                            What is your Date of Birth? *
                                        </label>
                                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth?" max="<%= maxDate%>" value="<%= dob%>" required>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="gender">
                                            What is your gender? *
                                        </label>
                                        <select class="form-control" name="gender" id="gender" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>" <%= (genderArray.get(i).equals(gender))?"selected":"" %> ><%= genderArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>"<%= (genderArray.get(i).equals("Male"))?"selected":"" %>><%= genderArray.get(i) %></option><%} %>--%>
                                        </select> 
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
	<script type="text/javascript">
            function checkForm(form)
            {
                re = /^\+([9]{1})+([2]{1})+([3]{1})+([0-9]{9})$/;
                if(!re.test(form.contact.value)) 
                {
                    alert("Please enter a valid phone number of format: +923xxxxxxxxx");
                    form.contact.focus();
                    return false;
                }
                if(form.contact.value.length > 13) 
                {
                    alert("Please enter a valid phone number of format: +923xxxxxxxxx with correct length");
                    form.contact.focus();
                    return false;
                }
		return true;
            }
	</script>
    </body>
</html>
