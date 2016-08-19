<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
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
            SWDRS - Update Profile
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
            ArrayList<String> incomeGroupArray = util.populateList(filename + "Income_Groups");

            Patient patient = (Patient)request.getSession().getAttribute("patient");
            String id = patient.getPatientProfile().getId();
            String name = patient.getPatientProfile().getName();
            String email = patient.getPatientProfile().getEmail();
            String contact = patient.getPatientProfile().getContact();
            String dateOfBirth = patient.getPatientProfile().getDateOfBirth();
            String gender = patient.getPatientProfile().getGender();
            String incomeGroup = patient.getPatientProfile().getIncomeGroup();
            String city = patient.getPatientProfile().getLocation().getCity();
            String country = patient.getPatientProfile().getLocation().getCountry();
            String area = patient.getPatientProfile().getLocation().getArea();
            gender = gender.substring(gender.indexOf("#")+1);
            city = city.substring(city.indexOf("#")+1);
            country = country.substring(country.indexOf("#")+1);
            area = area.substring(area.indexOf("#")+1);

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
                            <!--<li class="active" id="firstLink">
                                <div class="dropdown">
                                    <button onmouseover="myFunction()" class="dropbtn scroll-link" title="Profile">
                                        Profile
                                    </button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="profile" class="scroll-link" title="View Profile">
                                            View
                                        </a>
                                    </div>
                                </div>
                            </li>-->
                            <li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Profile">
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href="search" class="scroll-link" title="Search Doctor">
                                    Search
                                </a>
                            </li>
                            <li>
                                <a href="feedback" class="scroll-link" title="Feedback">
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
                                Patient - Update Profile
                            </h1>
                            <br>
                        </div>
                        <form method="post" action="profileupdated" id="patientProfileForrm" role="form" onsubmit="return checkForm(this);">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="name">
                                        Name:
                                    </label>
                                    <input type="text" class="form-control" name="name"  id="name" placeholder="Name?" value="<%= name%>" readonly required>
                                </div>
                                <div class="form-group">
                                    <label for="email">
                                        Email:
                                    </label>
                                    <input type="text" class="form-control" name="email" id="email" placeholder="Email?" value="<%= email%>" readonly required>
                                </div>
                                <div class="form-group">
                                    <label for="contact">
                                        Contact Number:
                                    </label>
                                    <input type="text" class="form-control" name="contact" id="contact" placeholder="Contact Number?" value="<%= contact%>" required>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="dateOfBirth">
                                        Date of Birth:
                                    </label>
                                    <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth?" value="<%= dateOfBirth%>" max="<%= maxDate%>" required>
                                </div>
                                <div class="form-group">
                                    <label for="gender">
                                        Gender:
                                    </label>
                                    <!-- <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender?"> -->
                                    <select class="form-control" name="gender" id="gender" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>"<%= (genderArray.get(i).equals(gender))?"selected":"" %>><%= genderArray.get(i) %></option><%} %>
                                    </select> 
                                </div>
                                <div class="form-group">
                                    <label for="incomeGroup">
                                        Income Group:
                                    </label>
                                    <!--<input type="text" class="form-control" name="incomeGroup" id="incomeGroup" placeholder="Income Group?">-->
                                    <select class="form-control" name="incomeGroup" id="incomeGroup" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<incomeGroupArray.size(); i++){%><option value="<%= incomeGroupArray.get(i) %>"<%= (incomeGroupArray.get(i).equals(incomeGroup))?"selected":"" %>><%= incomeGroupArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group" id="citiesDiv">
                                    <label for="city">
                                        City:
                                    </label>
                                    <!--<input type="text" class="form-control" name="city" id="city" placeholder="City?">-->
                                    <select class="form-control" name="city" id="city" onchange="myFunction1()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<cityArray.size(); i++){%><option value="<%= cityArray.get(i) %>"<%= (cityArray.get(i).equals(city))?"selected":"" %>><%= cityArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="countriesDiv">
                                    <label for="country">
                                        Country:
                                    </label>
                                    <input type="text" class="form-control" name="country" id="country" value="<%= country%>" placeholder="Country?" readonly>
                                    <%--<select class="form-control" name="country" id="country" onchange="myFunction2()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<countryArray.size(); i++){%><option value="<%= countryArray.get(i) %>"<%= (countryArray.get(i).equals(country))?"selected":"" %>><%= countryArray.get(i) %></option><%} %>
                                    </select>--%>
                                </div>
                                <div class="form-group">
                                    <label for="area">
                                        Area:
                                    </label>
                                    <!--<input type="text" class="form-control" name="area" id="area" placeholder="Area?">-->
                                    <select class="form-control" name="area" id="area" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<areaArray.size(); i++){%><option value="<%= areaArray.get(i) %>"<%= (areaArray.get(i).equals(area))?"selected":"" %>><%= areaArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Save
                                    </button>
                                    <input id="back" class="btn btn-lg btn-primary" type="button" value="Back" onClick="location.href='profile'" />
                                    <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
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
            function myFunction1() 
            {
                document.getElementById("countriesDiv").innerHTML = "<label for='country'>What is your country? *</label><input type='text' class='form-control' name='country' id='country' placeholder='Country?' value='Pakistan' required readonly>";
            }
        </script>
        <script>
            function myFunction2() 
            {
                document.getElementById("citiesDiv").innerHTML = "<label for='city'>City:</label><select class='form-control' name='city' id='city' required><option value=''>Select</option>" + "<%for(int i=0; i<cityArray.size(); i++){%>" + "<option value='" + "<%= cityArray.get(i) %>" + "'" + "<%= (cityArray.get(i).equals("Karachi"))?"selected":"" %>" + ">" + "<%= cityArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
            }
        </script>
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
	<script type="text/javascript">
            function checkForm(form)
            {
                re = /^\+([9]{1})+([2]{1})+([3]{1})+([0-9]{9})$/;
                if(!re.test(form.contact.value)) 
                {
                    alert("Please enter a valid phone number of format: +923xxxxxxxxx!");
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
