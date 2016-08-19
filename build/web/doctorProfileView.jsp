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
            SWDRS - View Profile
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
            Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
            ArrayList<DoctorProfile> doctorProfile = doctor.getDoctorProfiles();
            String name = doctorProfile.get(0).getName();
            String email = doctorProfile.get(0).getEmail();
            String contactNumber = doctorProfile.get(0).getContact();
            String dateOfBirth = doctorProfile.get(0).getDateOfBirth();
            String gender = doctorProfile.get(0).getGender();
            String degree = doctorProfile.get(0).getSpecialization().getDegree();
            String specialist = doctorProfile.get(0).getSpecialization().getSpecialist();
            String specialties = doctorProfile.get(0).getSpecialization().getSpecialties();
            gender = gender.substring(gender.indexOf("#")+1);
            degree = degree.substring(degree.indexOf("#")+1);
            specialties = specialties.substring(specialties.indexOf("#")+1);
            gender = gender.replace("_", " ");
            degree = degree.replace("_", " ");
            specialties = specialties.replace("_", " ");            
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
                                        <a href="profileupdate" class="scroll-link" title="Update Profile">
                                            Update
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
                                Doctor - View Profile
                            </h1>
                        </div>
                        <form method="post" action="profileupdate" id="doctorProfileInfoForrm" role="form">
                            <div id="doctorProfileInfo">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="name">
                                            Name:
                                        </label>
                                        <input type="text" class="form-control" name="name" id="name" placeholder="Name?" value="<%= name%>" readonly required>
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
                                        <input type="text" class="form-control" name="contact" id="contactNumber" placeholder="Contact Number?" value="<%= contactNumber%>" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label for="dateOfBirth">
                                            Date of Birth:
                                        </label>
                                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth?" value="<%= dateOfBirth%>" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="gender">
                                            Gender:
                                        </label>
                                        <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender?" value="<%= gender%>" readonly required>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="degree">
                                            Medical Degree:
                                        </label>
                                        <input type="text" class="form-control" name="degree" id="degree" placeholder="Degree?" value="<%= degree%>" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label for="specialist">
                                            Specialist:
                                        </label>
                                        <input type="text" class="form-control" name="specialist" id="specialist" placeholder="Specialist?" value="<%= specialist%>" readonly required>
                                    </div>
                                    <div class="form-group" id="specialtiesDiv">
                                        <label for="specialties">
                                            Specialty:
                                        </label>
                                        <input type="text" class="form-control" name="specialties" id="specialties" placeholder="Specialties?" value="<%= specialties%>" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label for="hospital">
                                            Hospital Name:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="hospitalName" id="hospitalName" placeholder="Hospital Name?" value="<%= hospitalName%>" readonly required> --%>
                                        <select class="form-control" name="hospitalName" id="hospitalName" onchange="myFunction1()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getHospitalName() %>"><%= doctorProfile.get(i).getHospital().getHospitalName() %></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="day">
                                            Days:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="day" id="day" placeholder="Day?" value="<%= day%>" readonly required> --%>
                                        <select class="form-control" name="day" id="day" onchange="myFunction2()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getDays()%>"><%= doctorProfile.get(i).getHospital().getDays()%></option><%} %>
                                        </select> 
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="visitingHours">
                                            Visiting Hours From:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours From?" value="<%= visitingHours%>" readonly required> --%>
                                        <select class="form-control" name="visitingHours" id="visitingHours" onchange="myFunction31()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getVisitingHours()%>"><%= doctorProfile.get(i).getHospital().getVisitingHours()%></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="visitingHours2">
                                            Visiting Hours To:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="visitingHours2" id="visitingHours2" placeholder="Visiting Hours To?" value="<%= visitingHours2%>" readonly required> --%>
                                        <select class="form-control" name="visitingHours2" id="visitingHours2" onchange="myFunction32()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getVisitingHours2()%>"><%= doctorProfile.get(i).getHospital().getVisitingHours2()%></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="feeStructure">
                                            Fee Structure:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure?" value="<%= feeStructure%>" readonly required> --%>
                                        <select class="form-control" name="feeStructure" id="feeStructure" onchange="myFunction4()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getFeeStructure()%>"><%= doctorProfile.get(i).getHospital().getFeeStructure()%></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="city">
                                            City:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="city" id="city" placeholder="City?" value="<%= city%>" readonly required> --%>
                                        <select class="form-control" name="city" id="city" onchange="myFunction5()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getCity().substring(doctorProfile.get(i).getHospital().getLocation().getCity().indexOf("#")+1) %>"><%= doctorProfile.get(i).getHospital().getLocation().getCity().substring(doctorProfile.get(i).getHospital().getLocation().getCity().indexOf("#")+1)%></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="country">
                                            Country:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="country" id="country" placeholder="Country?" value="<%= country%>" readonly required> --%>
                                        <select class="form-control" name="country" id="country" onchange="myFunction6()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getCountry().substring(doctorProfile.get(i).getHospital().getLocation().getCountry().indexOf("#")+1)%>"><%= doctorProfile.get(i).getHospital().getLocation().getCountry().substring(doctorProfile.get(i).getHospital().getLocation().getCountry().indexOf("#")+1)%></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="area">
                                            Area:
                                        </label>
                                        <%-- <input type="text" class="form-control" name="area" id="area" placeholder="Area?" value="<%= area%>" readonly required> --%>
                                        <select class="form-control" name="area" id="area" onchange="myFunction7()" required>
                                            <%for(int i=0; i<doctorProfile.size(); i++){%><option value="<%= doctorProfile.get(i).getHospital().getLocation().getArea().substring(doctorProfile.get(i).getHospital().getLocation().getArea().indexOf("#")+1)%>"><%= doctorProfile.get(i).getHospital().getLocation().getArea().substring(doctorProfile.get(i).getHospital().getLocation().getArea().indexOf("#")+1)%></option><%} %>
                                        </select> 
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <button name="update" type="submit" class="btn btn-lg btn-primary" id="update">
                                            Update
                                        </button>
                                        <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
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
                var x = document.getElementById("hospitalName").selectedIndex;
                var y = document.getElementById("hospitalName").options;
                //document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction2() 
            {
                var x = document.getElementById("day").selectedIndex;
                var y = document.getElementById("day").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                //document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction31() 
            {
                var x = document.getElementById("visitingHours").selectedIndex;
                var y = document.getElementById("visitingHours").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                //document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction32() 
            {
                var x = document.getElementById("visitingHours").selectedIndex;
                var y = document.getElementById("visitingHours").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                //document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction4() 
            {
                var x = document.getElementById("feeStructure").selectedIndex;
                var y = document.getElementById("feeStructure").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                //document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction5() 
            {
                var x = document.getElementById("city").selectedIndex;
                var y = document.getElementById("city").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                //document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction6() 
            {
                var x = document.getElementById("country").selectedIndex;
                var y = document.getElementById("country").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                //document.getElementById("country").selectedIndex = y[x].index;
                document.getElementById("area").selectedIndex = y[x].index;
            }
        </script>
        <script>
            function myFunction7() 
            {
                var x = document.getElementById("area").selectedIndex;
                var y = document.getElementById("area").options;
                document.getElementById("hospitalName").selectedIndex = y[x].index;
                document.getElementById("day").selectedIndex = y[x].index;
                document.getElementById("visitingHours").selectedIndex = y[x].index;
                document.getElementById("visitingHours2").selectedIndex = y[x].index;
                document.getElementById("feeStructure").selectedIndex = y[x].index;
                document.getElementById("city").selectedIndex = y[x].index;
                document.getElementById("country").selectedIndex = y[x].index;
                //document.getElementById("area").selectedIndex = y[x].index;
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
    </body>
</html>
