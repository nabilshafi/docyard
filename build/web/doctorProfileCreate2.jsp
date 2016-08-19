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
    <body onload="myFunction()">
        <% 
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            String degree = (String)request.getSession().getAttribute("degree");
            String specialist = (String)request.getSession().getAttribute("specialist");
            String specialties = (String)request.getSession().getAttribute("specialties");
            ArrayList<String> degreeArray = util.populateList(filename + "Doctors_Types");
            ArrayList<String> specialistArray = util.populateList(filename + "Specialist_Choice");
            ArrayList<String> specialtiesArray = util.populateList(filename + "Specialist_Types");
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
        <section id="doctorDegreeInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Doctor - Medical Degree Information
                            </h1>
                        </div>
                        <form method="post" action="profile3" id="doctorProfileDegreeInfoForrm" role="form">
                            <div id="doctorProfileDegreeInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="degree">
                                            Which medical degree do you hold? *
                                        </label>
                                        <select class="form-control" name="degree" id="degree" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<degreeArray.size(); i++){%><option value="<%= degreeArray.get(i) %>" <%= (degreeArray.get(i).equals(degree))?"selected":"" %> ><%= degreeArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<degreeArray.size(); i++){%><option value="<%= degreeArray.get(i) %>"<%= (degreeArray.get(i).equals("Dentist"))?"selected":"" %>><%= degreeArray.get(i) %></option><%} %>--%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Next
                                        </button>
                                        <input id="back" class="btn btn-lg btn-primary" type="button" value="Back" onClick="location.href='profile'" />
                                        <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
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
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="specialist">
                                            Are you a specialist? *
                                        </label>
                                        <select class="form-control" name="specialist" id="specialist" onchange="myFunction()" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<specialistArray.size(); i++){%><option value="<%= specialistArray.get(i) %>" <%= (specialistArray.get(i).equals(specialist))?"selected":"" %> ><%= specialistArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<specialistArray.size(); i++){%><option value="<%= specialistArray.get(i) %>"<%= (specialistArray.get(i).equals("No"))?"selected":"" %>><%= specialistArray.get(i) %></option><%} %>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group" id="specialtiesDiv">
                                        <%--<label for="specialties">
                                            What are your specialties? *
                                        </label>
                                        <select class="form-control" name="specialties" id="specialties" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<specialtiesArray.size(); i++){%><option value="<%= specialtiesArray.get(i) %>" <%= (specialtiesArray.get(i).equals(specialties))?"selected":"" %> ><%= specialtiesArray.get(i) %></option><%} %>
                                            <!--<%for(int i=0; i<specialtiesArray.size(); i++){%><option value="<%= specialtiesArray.get(i) %>"<%= (specialtiesArray.get(i).equals("Oncology"))?"selected":"" %>><%= specialtiesArray.get(i) %></option><%} %>-->
                                        </select> --%>
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
            function myFunction() 
            {
                var x = document.getElementById("specialist").value;
                if(x === "Yes")
                {
                    document.getElementById("specialtiesDiv").style.visibility= "visible";
                    document.getElementById("specialtiesDiv").innerHTML = "<label for='specialties'>What are your specialties? *</label><select class='form-control' name='specialties' id='specialties' required><option value=''>Select</option>" + "<%for(int i=0; i<specialtiesArray.size(); i++){%>" + "<option value='" + "<%= specialtiesArray.get(i) %>" + "'" + "<%= (specialtiesArray.get(i).equals(specialties))?"selected":"" %>" + ">" + "<%= specialtiesArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                else
                {
                    document.getElementById("specialtiesDiv").style.visibility= "hidden";
                    document.getElementById("specialtiesDiv").innerHTML = "";
                }
            }
        </script>
    </body>
</html>
