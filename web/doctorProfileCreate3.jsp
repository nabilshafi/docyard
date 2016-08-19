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
            String hospital = (String)request.getSession().getAttribute("hospital");
            String days = (String)request.getSession().getAttribute("days");
            String visitingHours = (String)request.getSession().getAttribute("visitingHours");
            String visitingHours2 = (String)request.getSession().getAttribute("visitingHours2");
            String feeStructure = (String)request.getSession().getAttribute("feeStructure");
            String city = (String)request.getSession().getAttribute("city");
            String country = (String)request.getSession().getAttribute("country");
            String area = (String)request.getSession().getAttribute("area");
            
            ArrayList<String> hospitalArray = util.populateList(filename + "Hospitals_Names");
            ArrayList<String> daysArray = util.populateList(filename + "Days_Names");
            ArrayList<String> cityArray = util.populateList(filename + "Cities_Pakistan");
            ArrayList<String> countryArray = util.populateList(filename + "Countries_World");
            ArrayList<String> areaArray = util.populateList(filename + "Areas_Names");
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
        <section id="hospitalInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Doctor - Create Profile - Hospital Information
                            </h1>
                        </div>
                        <form method="post" action="profilecreated" id="doctorProfileHospitalInfoForrm" role="form">
                            <div id="doctorProfileHospitalInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="hospital">
                                            Which hospital/clinic do you sit? *
                                        </label>
                                        <select class="form-control" name="hospital" id="hospital" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<hospitalArray.size(); i++){%><option value="<%= hospitalArray.get(i) %>" <%= (hospitalArray.get(i).equals(hospital))?"selected":"" %> <%= (hospitalArray.get(i).equals(hospital))?"selected":"" %> ><%= hospitalArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<hospitalArray.size(); i++){%><option value="<%= hospitalArray.get(i) %>"<%= (hospitalArray.get(i).equals("PNS Rahat"))?"selected":"" %>><%= hospitalArray.get(i) %></option><%} %>--%>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="day">
                                            At what day? *
                                        </label>
                                        <select class="form-control" name="day" id="day" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<daysArray.size(); i++){%><option value="<%= daysArray.get(i) %>" <%= (daysArray.get(i).equals(days))?"selected":"" %> ><%= daysArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<daysArray.size(); i++){%><option value="<%= daysArray.get(i) %>"<%= (daysArray.get(i).equals("Monday"))?"selected":"" %>><%= daysArray.get(i) %></option><%} %>--%>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="visitingHours">
                                            What are your visiting hours (from)? *
                                        </label>
                                        <input type="time" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours From?" value="<%= visitingHours%>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="visitingHours2">
                                            What are your visiting hours (to)? *
                                        </label>
                                        <input type="time" class="form-control" name="visitingHours2" id="visitingHours2" placeholder="Visiting Hours To?" value="<%= visitingHours2%>" required>
                                    </div><br><br>
                                    <button name="addMore" type="submit" class="btn btn-lg btn-primary" id="addMore" formmethod="post" formaction="profile3AddMore">
                                        Add Hospital
                                    </button> 
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="feeStructure">
                                            What is your fee structure? *
                                        </label>
                                        <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure?" value="<%= feeStructure%>" required>
                                    </div>
                                    <div class="form-group" id="citiesDiv">
                                        <label for="city">
                                            What is your City? *
                                        </label>
                                        <select class="form-control" name="city" id="city" onchange="myFunction1()" required>
                                            <option value="" >Select</option>
                                            <%for(int i=0; i<cityArray.size(); i++){%><option value="<%= cityArray.get(i) %>" <%= (cityArray.get(i).equals(city))?"selected":"" %> ><%= cityArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<cityArray.size(); i++){%><option value="<%= cityArray.get(i) %>"<%= (cityArray.get(i).equals("Karachi"))?"selected":"" %>><%= cityArray.get(i) %></option><%} %>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group" id="countriesDiv">
                                        <label for="country">
                                            What is your country? *
                                        </label>
                                        <input type="text" class="form-control" name="country" id="country" placeholder="Country?" value="<%= country%>" required readonly>
                                        <%--<select class="form-control" name="country" onchange="myFunction2()" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<countryArray.size(); i++){%><option value="<%= countryArray.get(i) %>" <%= (countryArray.get(i).equals(country))?"selected":"" %> ><%= countryArray.get(i) %></option><%} %>
                                            <%for(int i=0; i<countryArray.size(); i++){%><option value="<%= countryArray.get(i) %>"<%= (countryArray.get(i).equals("Pakistan"))?"selected":"" %>><%= countryArray.get(i) %></option><%} %>
                                        </select>--%>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">
                                            What is your area? *
                                        </label>
                                        <select class="form-control" name="area" id="area" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<areaArray.size(); i++){%><option value="<%= areaArray.get(i) %>" <%= (areaArray.get(i).equals(area))?"selected":"" %> ><%= areaArray.get(i) %></option><%} %>
                                            <%--<%for(int i=0; i<areaArray.size(); i++){%><option value="<%= areaArray.get(i) %>"<%= (areaArray.get(i).equals("North Karachi"))?"selected":"" %>><%= areaArray.get(i) %></option><%} %>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Save
                                        </button>
                                        <input id="back" class="btn btn-lg btn-primary" type="button" value="Back" onClick="location.href='profile2'" />
                                        <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
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
            function myFunction1() 
            {
                document.getElementById("countriesDiv").innerHTML = "<label for='country'>What is your country? *</label><input type='text' class='form-control' name='country' id='country' placeholder='Country?' value='Pakistan' required readonly>";
            }
        </script>
        <script>
            function myFunction2() 
            {
                document.getElementById("citiesDiv").innerHTML = "<label for='city'>What is your city? *</label><select class='form-control' name='city' id='city' required><option value='" + "<%= city%>" + "'>Select</option>" + "<%for(int i=0; i<cityArray.size(); i++){%>" + "<option value='" + "<%= cityArray.get(i) %>" + "'" + "<%= (cityArray.get(i).equals("Karachi"))?"selected":"" %>" + ">" + "<%= cityArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
            }
        </script>
    </body>
</html>
