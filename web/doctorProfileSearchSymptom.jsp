<%@page import="com.fyp.swdrs.bo.DoctorProfile"%>
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
            SWDRS - Search Results
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
            ArrayList<DoctorProfile> doctorProfile = (ArrayList<DoctorProfile>)request.getSession().getAttribute("searchSymptomObj");
            String searchSymptomQuery1 = (String)request.getSession().getAttribute("searchSymptomQuery1");
            String searchSymptomQuery2 = (String)request.getSession().getAttribute("searchSymptomQuery2");
            String searchSymptomQuery3 = (String)request.getSession().getAttribute("searchSymptomQuery3");
            String name = doctorProfile.get(0).getName();
            String email = doctorProfile.get(0).getEmail();
            String contact = doctorProfile.get(0).getContact();
            String dateOfBirth = doctorProfile.get(0).getDateOfBirth();
            String gender = doctorProfile.get(0).getGender();
            String degree = doctorProfile.get(0).getSpecialization().getDegree();
            String specialist = doctorProfile.get(0).getSpecialization().getSpecialist();
            String specialties = doctorProfile.get(0).getSpecialization().getSpecialties();
            String hospitalName = doctorProfile.get(0).getHospital().getHospitalName();
            String days = doctorProfile.get(0).getHospital().getDays();
            String visitingHours = doctorProfile.get(0).getHospital().getVisitingHours();
            String feeStructure = doctorProfile.get(0).getHospital().getFeeStructure();
            String city = doctorProfile.get(0).getHospital().getLocation().getCity();
            String country = doctorProfile.get(0).getHospital().getLocation().getCountry();
            String area = doctorProfile.get(0).getHospital().getLocation().getArea();
            double systemRating = doctorProfile.get(0).getSystemRating();
            gender = gender.substring(gender.indexOf("#")+1).replace("_", " ");
            degree = degree.substring(degree.indexOf("#")+1).replace("_", " ");
            specialties = specialties.substring(specialties.indexOf("#")+1).replace("_", " ");
            city = city.substring(city.indexOf("#")+1).replace("_", " ");
            country = country.substring(country.indexOf("#")+1).replace("_", " ");
            area = area.substring(area.indexOf("#")+1).replace("_", " ");
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
                            <li class="active" id="firstLink">
                                <a href="search" class="scroll-link" title="Search">
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
        <section id="doctorInfo" class="contact-parlex">
            <div class="parlex-back">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1>
                                Search Results for "<%= searchSymptomQuery1%>", "<%= searchSymptomQuery2%>", "<%= searchSymptomQuery3%>"
                            </h1>
                        </div>
                        <form method="post" action="profileupdate" id="doctorProfileInfoForrm" role="form">
                            <div id="doctorProfileInfo">
                                <div class="col-sm-4">
                                    <div class="form-group" id="nameDiv">
                                        <label for="name">
                                            Name:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="name" id="name" placeholder="Name:" value="<%= name%>" readonly required> --%>
                                        <select class="form-control" name="name" id="name" onchange="myFunctionChange1()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getName() %>"><%= doctorProfile.get(i).getName() %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group" id="emailDiv">
                                        <label for="email">
                                            Email:
                                        </label>
                                        <input type="text" class="form-control" name="email" id="email" placeholder="Email:" value="<%= email%>" readonly required> 
                                        <%-- <select class="form-control" name="email" id="email" onchange="myFunction2()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getEmail()%>"><%= doctorProfile.get(i).getEmail()%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="contactDiv">
                                        <label for="contact">
                                            Contact Number:
                                        </label>
                                        <input type="text" class="form-control" name="contact" id="contactNumber" placeholder="Contact Number:" value="<%= contact%>" readonly required>
                                        <%-- <select class="form-control" name="contact" id="contactNumber" onchange="myFunction3()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getContact()%>"><%= doctorProfile.get(i).getContact()%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="dateOfBirthDiv">
                                        <label for="dateOfBirth">
                                            Date of Birth:
                                        </label>
                                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth:" value="<%= dateOfBirth%>" readonly>
                                        <%-- <select class="form-control" name="dateOfBirth" id="dateOfBirth" onchange="myFunction4()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getDateOfBirth()%>"><%= doctorProfile.get(i).getDateOfBirth()%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="genderDiv">
                                        <label for="gender">
                                            Gender:
                                        </label>
                                        <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender:" value="<%= gender%>" readonly required>
                                        <%-- <select class="form-control" name="gender" id="gender" onchange="myFunction5()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getGender().substring(doctorProfile.get(i).getGender().indexOf("#")+1)%>"><%= doctorProfile.get(i).getGender().substring(doctorProfile.get(i).getGender().indexOf("#")+1)%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group">
                                        <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Ok" onClick="location.href='home'" />
                                        <!-- <button name="update" type="submit" class="btn btn-lg btn-primary" id="update">
                                            Update Profile
                                        </button> -->
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group" id="degreeDiv">
                                        <label for="degree">
                                            Medical Degree:
                                        </label>
                                        <input type="text" class="form-control" name="degree" id="degree" placeholder="Degree:" value="<%= degree%>" readonly required>
                                        <%-- <select class="form-control" name="degree" id="degree" onchange="myFunction6()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getSpecialization().getDegree().substring(doctorProfile.get(i).getSpecialization().getDegree().indexOf("#")+1)%>"><%= doctorProfile.get(i).getSpecialization().getDegree().substring(doctorProfile.get(i).getSpecialization().getDegree().indexOf("#")+1)%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="specialistDiv">
                                        <label for="specialist">
                                            Specialist:
                                        </label>
                                        <input type="text" class="form-control" name="specialist" id="specialist" placeholder="Specialist:" value="<%= specialist%>" readonly required>
                                        <%-- <select class="form-control" name="specialist" id="specialist" onchange="myFunction7()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getSpecialization().getSpecialist()%>"><%= doctorProfile.get(i).getSpecialization().getSpecialist()%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="specialtiesDiv">
                                        <label for="specialties">
                                            Specialty:
                                        </label>
                                        <input type="text" class="form-control" name="specialties" id="specialties" placeholder="Specialties:" value="<%= specialties%>" readonly required>
                                        <%-- <select class="form-control" name="specialties" id="specialties" onchange="myFunction8()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getSpecialization().getSpecialties().substring(doctorProfile.get(i).getSpecialization().getSpecialties().indexOf("#")+1)%>"><%= doctorProfile.get(i).getSpecialization().getSpecialties().substring(doctorProfile.get(i).getSpecialization().getSpecialties().indexOf("#")+1)%></option><%} %>
                                        </select> --%>
                                    </div>
                                    <div class="form-group" id="hospitalNameDiv">
                                        <label for="hospital">
                                            Hospital Name:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="hospitalName" id="hospitalName" placeholder="Hospital Name:" value="<%= hospitalName%>" readonly required>--%>
                                        <select class="form-control" name="hospitalName" id="hospitalName" onchange="myFunctionChange2()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getHospitalName() %>"><%= doctorProfile.get(i).getHospital().getHospitalName() %></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group" id="dayDiv">
                                        <label for="day">
                                            Days:
                                        </label>
                                        <input type="text" class="form-control" name="day" id="day" placeholder="Day:" value="<%= days%>" readonly required>
                                        <%-- <select class="form-control" name="day" id="day" onchange="myFunction10()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getDays()%>"><%= doctorProfile.get(i).getHospital().getDays()%></option><%} %>
                                        </select> --%>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group" id="visitingHoursDiv">
                                        <label for="hospital">
                                            Visiting Hours:
                                        </label>
                                        <input type="text" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours:" value="<%= visitingHours%>" readonly required>
                                        <%-- <select class="form-control" name="visitingHours" id="visitingHours" onchange="myFunction11()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getVisitingHours()%>"><%= doctorProfile.get(i).getHospital().getVisitingHours()%></option><%} %>
                                        </select>  --%>
                                    </div>
                                    <div class="form-group" id="feeStructureDiv">
                                        <label for="feeStructure">
                                            Fee Structure:
                                        </label>
                                        <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure:" value="<%= feeStructure%>" readonly required>
                                        <%-- <select class="form-control" name="feeStructure" id="feeStructure" onchange="myFunction12()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getFeeStructure()%>"><%= doctorProfile.get(i).getHospital().getFeeStructure()%></option><%} %>
                                        </select>  --%>
                                    </div>
                                    <div class="form-group" id="cityDiv">
                                        <label for="city">
                                            City:
                                        </label>
                                        <input type="text" class="form-control" name="city" id="city" placeholder="City:" value="<%= city%>" readonly required>
                                        <%-- <select class="form-control" name="city" id="city" onchange="myFunction13()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getCity().substring(doctorProfile.get(i).getHospital().getLocation().getCity().indexOf("#")+1) %>"><%= doctorProfile.get(i).getHospital().getLocation().getCity().substring(doctorProfile.get(i).getHospital().getLocation().getCity().indexOf("#")+1)%></option><%} %>
                                        </select>  --%>
                                    </div>
                                    <div class="form-group" id="countryDiv">
                                        <label for="country">
                                            Country:
                                        </label>
                                        <input type="text" class="form-control" name="country" id="country" placeholder="Country:" value="<%= country%>" readonly required>
                                        <%-- <select class="form-control" name="country" id="country" onchange="myFunction14()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getCountry().substring(doctorProfile.get(i).getHospital().getLocation().getCountry().indexOf("#")+1)%>"><%= doctorProfile.get(i).getHospital().getLocation().getCountry().substring(doctorProfile.get(i).getHospital().getLocation().getCountry().indexOf("#")+1)%></option><%} %>
                                        </select>  --%>
                                    </div>
                                    <div class="form-group" id="areaDiv">
                                        <label for="area">
                                            Area:
                                        </label>
                                        <input type="text" class="form-control" name="area" id="area" placeholder="Area:" value="<%= area%>" readonly required>
                                        <%-- <select class="form-control" name="area" id="area" onchange="myFunction15()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getArea().substring(doctorProfile.get(i).getHospital().getLocation().getArea().indexOf("#")+1)%>"><%= doctorProfile.get(i).getHospital().getLocation().getArea().substring(doctorProfile.get(i).getHospital().getLocation().getArea().indexOf("#")+1)%></option><%} %>
                                        </select>  --%>
                                    </div>
                                    <div class="form-group" id="ratingDiv">
                                        <label for="rating">
                                            System Rating:
                                        </label>
                                        <input type="text" class="form-control" name="rating" id="rating" placeholder="Rating:" value="<%= systemRating%>" readonly required>
                                        <%-- <select class="form-control" name="rating" id="rating" onchange="myFunction16()" required readonly>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getSystemRating()%>"><%= doctorProfile.get(i).getSystemRating()%></option><%} %>
                                        </select>  --%>
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
                var x = document.getElementById("name").selectedIndex;
                var y = document.getElementById("name").options;
                //document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction2() 
            {
                var x = document.getElementById("email").selectedIndex;
                var y = document.getElementById("email").options;
                document.getElementById("name").selectedIndex = y[x].index;
//                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction3() 
            {
                var x = document.getElementById("contactNumber").selectedIndex;
                var y = document.getElementById("contactNumber").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
//                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction4() 
            {
                var x = document.getElementById("dateOfBirth").selectedIndex;
                var y = document.getElementById("dateOfBirth").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
//                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction5() 
            {
                var x = document.getElementById("gender").selectedIndex;
                var y = document.getElementById("gender").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
//                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction6() 
            {
                var x = document.getElementById("degree").selectedIndex;
                var y = document.getElementById("degree").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
//                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction7() 
            {
                var x = document.getElementById("specialist").selectedIndex;
                var y = document.getElementById("specialist").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
//                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction8() 
            {
                var x = document.getElementById("specialties").selectedIndex;
                var y = document.getElementById("specialties").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
//                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction9() 
            {
                var x = document.getElementById("hospitalName").selectedIndex;
                var y = document.getElementById("hospitalName").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
//                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction10() 
            {
                var x = document.getElementById("day").selectedIndex;
                var y = document.getElementById("day").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
//                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction11() 
            {
                var x = document.getElementById("visitingHours").selectedIndex;
                var y = document.getElementById("visitingHours").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
//                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction12() 
            {
                var x = document.getElementById("feeStructure").selectedIndex;
                var y = document.getElementById("feeStructure").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
//                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction13() 
            {
                var x = document.getElementById("city").selectedIndex;
                var y = document.getElementById("city").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
//                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction14() 
            {
                var x = document.getElementById("country").selectedIndex;
                var y = document.getElementById("country").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
//                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction15() 
            {
                var x = document.getElementById("area").selectedIndex;
                var y = document.getElementById("area").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
//                document.getElementById("area").selectedIndex = y[x].index;
                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction16() 
            {
                var x = document.getElementById("area").selectedIndex;
                var y = document.getElementById("area").options;
                document.getElementById("name").selectedIndex = y[x].index;
                document.getElementById("email").selectedIndex = y[x].index;
                document.getElementById("contactNumber").selectedIndex = y[x].index;
                document.getElementById("dateOfBirth").selectedIndex = y[x].index;
                document.getElementById("gender").selectedIndex = y[x].index;
                document.getElementById("degree").selectedIndex = y[x].index;
                document.getElementById("specialist").selectedIndex = y[x].index;
                document.getElementById("specialties").selectedIndex = y[x].index;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
//                document.getElementById("rating").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunctionChange1() 
            {
                var x = document.getElementById("name").selectedIndex;
                var y = document.getElementById("name").options;
                <%
                    for(int i = 0; i<doctorProfile.size(); i++) {
                        name = doctorProfile.get(i).getName();
                        email = doctorProfile.get(i).getEmail();
                        contact = doctorProfile.get(i).getContact();
                        dateOfBirth = doctorProfile.get(i).getDateOfBirth();
                        gender = doctorProfile.get(i).getGender();
                        degree = doctorProfile.get(i).getSpecialization().getDegree();
                        specialist = doctorProfile.get(i).getSpecialization().getSpecialist();
                        specialties = doctorProfile.get(i).getSpecialization().getSpecialties();
                        hospitalName = doctorProfile.get(i).getHospital().getHospitalName();
                        days = doctorProfile.get(i).getHospital().getDays();
                        visitingHours = doctorProfile.get(i).getHospital().getVisitingHours();
                        feeStructure = doctorProfile.get(i).getHospital().getFeeStructure();
                        city = doctorProfile.get(i).getHospital().getLocation().getCity();
                        country = doctorProfile.get(i).getHospital().getLocation().getCountry();
                        area = doctorProfile.get(i).getHospital().getLocation().getArea();
                        systemRating = doctorProfile.get(i).getSystemRating();
                        gender = gender.substring(gender.indexOf("#")+1).replace("_", " ");
                        degree = degree.substring(degree.indexOf("#")+1).replace("_", " ");
                        specialties = specialties.substring(specialties.indexOf("#")+1).replace("_", " ");
                        city = city.substring(city.indexOf("#")+1).replace("_", " ");
                        country = country.substring(country.indexOf("#")+1).replace("_", " ");
                        area = area.substring(area.indexOf("#")+1).replace("_", " ");
                %>
                if(x == "<%= i%>")
                {
                    document.getElementById("emailDiv").innerHTML = "<label for='email'>Email:</label><input type='text' class='form-control' name='email' id='email' placeholder='Email:' value='" + "<%= email%>" + "' readonly required>";
                    document.getElementById("contactDiv").innerHTML = "<label for='contact'>Contact Number:</label><input type='text' class='form-control' name='contact' id='contactNumber' placeholder='Contact Number:' value='" + "<%= contact%>" + "' readonly required>";
                    document.getElementById("dateOfBirthDiv").innerHTML = "<label for='dateOfBirth'>Date of Birth:</label><input type='date' class='form-control' name='dateOfBirth' id='dateOfBirth' placeholder='Date of Birth (YYYY-MM-DD):' value='" + "<%= dateOfBirth%>" + "' readonly required>";
                    document.getElementById("genderDiv").innerHTML = "<label for='gender'>Gender:</label><input type='text' class='form-control' name='gender' id='gender' placeholder='Gender:' value='" + "<%= gender%>" + "' readonly required>";
                    document.getElementById("degreeDiv").innerHTML = "<label for='degree'>Medical Degree:</label><input type='text' class='form-control' name='degree' id='degree' placeholder='Degree:' value='" + "<%= degree%>" + "' readonly required>";
                    document.getElementById("specialistDiv").innerHTML = "<label for='specialist'>Specialist:</label><input type='text' class='form-control' name='specialist' id='specialist' placeholder='Specialist:' value='" + "<%= specialist%>" + "' readonly required>";
                    document.getElementById("specialtiesDiv").innerHTML = "<label for='specialties'>Specialty:</label><input type='text' class='form-control' name='specialties' id='specialties' placeholder='Specialties:' value='" + "<%= specialties%>" + "' readonly required>";
                    document.getElementById("hospitalName").selectedIndex = y[x].index;
                    document.getElementById("dayDiv").innerHTML = "<label for='day'>Days:</label><input type='text' class='form-control' name='day' id='day' placeholder='Day:' value='" + "<%= days%>" + "' readonly required>";
                    document.getElementById("visitingHoursDiv").innerHTML = "<label for='visitingHours'>Visiting Hours:</label><input type='text' class='form-control' name='visitingHours' id='visitingHours' placeholder='Visiting Hours (HH:MM):' value='" + "<%= visitingHours%>" + "' readonly required>";
                    document.getElementById("feeStructureDiv").innerHTML = "<label for='feeStructure'>Fee Structure:</label><input type='text' class='form-control' name='feeStructure' id='feeStructure' placeholder='Fee Structure:' value='" + "<%= feeStructure%>" + "' readonly required>";
                    document.getElementById("cityDiv").innerHTML = "<label for='city'>City:</label><input type='text' class='form-control' name='city' id='city' placeholder='City:' value='" + "<%= city%>" + "' readonly required>";
                    document.getElementById("countryDiv").innerHTML = "<label for='country'>Country:</label><input type='text' class='form-control' name='country' id='country' placeholder='Country:' value='" + "<%= country%>" + "' readonly required>";
                    document.getElementById("areaDiv").innerHTML = "<label for='area'>Area:</label><input type='text' class='form-control' name='area' id='area' placeholder='Area:' value='" + "<%= area%>" + "' readonly required>";
                    document.getElementById("ratingDiv").innerHTML = "<label for='rating'>System Rating:</label><input type='text' class='form-control' name='rating' id='rating' placeholder='Rating:' value='" + "<%= systemRating%>" + "' readonly required>";
                }
                <%}%>
            }
        </script>
        <script>
            function myFunctionChange2() 
            {
                var x = document.getElementById("hospitalName").selectedIndex;
                var y = document.getElementById("hospitalName").options;
                <%
                    for(int i = 0; i<doctorProfile.size(); i++) {
                        name = doctorProfile.get(i).getName();
                        email = doctorProfile.get(i).getEmail();
                        contact = doctorProfile.get(i).getContact();
                        dateOfBirth = doctorProfile.get(i).getDateOfBirth();
                        gender = doctorProfile.get(i).getGender();
                        degree = doctorProfile.get(i).getSpecialization().getDegree();
                        specialist = doctorProfile.get(i).getSpecialization().getSpecialist();
                        specialties = doctorProfile.get(i).getSpecialization().getSpecialties();
                        hospitalName = doctorProfile.get(i).getHospital().getHospitalName();
                        days = doctorProfile.get(i).getHospital().getDays();
                        visitingHours = doctorProfile.get(i).getHospital().getVisitingHours();
                        feeStructure = doctorProfile.get(i).getHospital().getFeeStructure();
                        city = doctorProfile.get(i).getHospital().getLocation().getCity();
                        country = doctorProfile.get(i).getHospital().getLocation().getCountry();
                        area = doctorProfile.get(i).getHospital().getLocation().getArea();
                        systemRating = doctorProfile.get(i).getSystemRating();
                        gender = gender.substring(gender.indexOf("#")+1).replace("_", " ");
                        degree = degree.substring(degree.indexOf("#")+1).replace("_", " ");
                        specialties = specialties.substring(specialties.indexOf("#")+1).replace("_", " ");
                        city = city.substring(city.indexOf("#")+1).replace("_", " ");
                        country = country.substring(country.indexOf("#")+1).replace("_", " ");
                        area = area.substring(area.indexOf("#")+1).replace("_", " ");
                %>
                if(x == "<%= i%>")
                {
                    document.getElementById("name").selectedIndex = y[x].index;
                    document.getElementById("emailDiv").innerHTML = "<label for='email'>Email:</label><input type='text' class='form-control' name='email' id='email' placeholder='Email:' value='" + "<%= email%>" + "' readonly required>";
                    document.getElementById("contactDiv").innerHTML = "<label for='contact'>Contact Number:</label><input type='text' class='form-control' name='contact' id='contactNumber' placeholder='Contact Number:' value='" + "<%= contact%>" + "' readonly required>";
                    document.getElementById("dateOfBirthDiv").innerHTML = "<label for='dateOfBirth'>Date of Birth:</label><input type='date' class='form-control' name='dateOfBirth' id='dateOfBirth' placeholder='Date of Birth (YYYY-MM-DD):' value='" + "<%= dateOfBirth%>" + "' readonly required>";
                    document.getElementById("genderDiv").innerHTML = "<label for='gender'>Gender:</label><input type='text' class='form-control' name='gender' id='gender' placeholder='Gender:' value='" + "<%= gender%>" + "' readonly required>";
                    document.getElementById("degreeDiv").innerHTML = "<label for='degree'>Medical Degree:</label><input type='text' class='form-control' name='degree' id='degree' placeholder='Degree:' value='" + "<%= degree%>" + "' readonly required>";
                    document.getElementById("specialistDiv").innerHTML = "<label for='specialist'>Specialist:</label><input type='text' class='form-control' name='specialist' id='specialist' placeholder='Specialist:' value='" + "<%= specialist%>" + "' readonly required>";
                    document.getElementById("specialtiesDiv").innerHTML = "<label for='specialties'>Specialty:</label><input type='text' class='form-control' name='specialties' id='specialties' placeholder='Specialties:' value='" + "<%= specialties%>" + "' readonly required>";
                    document.getElementById("dayDiv").innerHTML = "<label for='day'>Days:</label><input type='text' class='form-control' name='day' id='day' placeholder='Day:' value='" + "<%= days%>" + "' readonly required>";
                    document.getElementById("visitingHoursDiv").innerHTML = "<label for='visitingHours'>Visiting Hours:</label><input type='text' class='form-control' name='visitingHours' id='visitingHours' placeholder='Visiting Hours (HH:MM):' value='" + "<%= visitingHours%>" + "' readonly required>";
                    document.getElementById("feeStructureDiv").innerHTML = "<label for='feeStructure'>Fee Structure:</label><input type='text' class='form-control' name='feeStructure' id='feeStructure' placeholder='Fee Structure:' value='" + "<%= feeStructure%>" + "' readonly required>";
                    document.getElementById("cityDiv").innerHTML = "<label for='city'>City:</label><input type='text' class='form-control' name='city' id='city' placeholder='City:' value='" + "<%= city%>" + "' readonly required>";
                    document.getElementById("countryDiv").innerHTML = "<label for='country'>Country:</label><input type='text' class='form-control' name='country' id='country' placeholder='Country:' value='" + "<%= country%>" + "' readonly required>";
                    document.getElementById("areaDiv").innerHTML = "<label for='area'>Area:</label><input type='text' class='form-control' name='area' id='area' placeholder='Area:' value='" + "<%= area%>" + "' readonly required>";
                    document.getElementById("ratingDiv").innerHTML = "<label for='rating'>System Rating:</label><input type='text' class='form-control' name='rating' id='rating' placeholder='Rating:' value='" + "<%= systemRating%>" + "' readonly required>";
                }
                <%}%>
            }
        </script>
    </body>
</html>
