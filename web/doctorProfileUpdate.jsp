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
            ArrayList<String> degreeArray = util.populateList(filename + "Doctors_Types");
            ArrayList<String> specialistArray = util.populateList(filename + "Specialist_Choice");
            ArrayList<String> specialtiesArray = util.populateList(filename + "Specialist_Types");
            ArrayList<String> cityArray = util.populateList(filename + "Cities_Pakistan");
            ArrayList<String> countryArray = util.populateList(filename + "Countries_World");
            ArrayList<String> areaArray = util.populateList(filename + "Areas_Names");
            ArrayList<String> hospitalArray = util.populateList(filename + "Hospitals_Names");
            ArrayList<String> daysArray = util.populateList(filename + "Days_Names");
            Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
            int profileNumber = doctor.getProfileNumber();
            String name = doctor.getDoctorProfiles().get(profileNumber).getName();
            String email = doctor.getDoctorProfiles().get(profileNumber).getEmail();
            String contactNumber = doctor.getDoctorProfiles().get(profileNumber).getContact();
            String dateOfBirth = doctor.getDoctorProfiles().get(profileNumber).getDateOfBirth();
            String gender = doctor.getDoctorProfiles().get(profileNumber).getGender();
            String degree = doctor.getDoctorProfiles().get(profileNumber).getSpecialization().getDegree();
            String specialist = doctor.getDoctorProfiles().get(profileNumber).getSpecialization().getSpecialist();
            String specialties = doctor.getDoctorProfiles().get(profileNumber).getSpecialization().getSpecialties();
            String hospitalName = doctor.getDoctorProfiles().get(profileNumber).getHospital().getHospitalName();
            String day = doctor.getDoctorProfiles().get(profileNumber).getHospital().getDays();
            String visitingHours = doctor.getDoctorProfiles().get(profileNumber).getHospital().getVisitingHours();
            String visitingHours2 = doctor.getDoctorProfiles().get(profileNumber).getHospital().getVisitingHours2();
            String feeStructure = doctor.getDoctorProfiles().get(profileNumber).getHospital().getFeeStructure();
            String city = doctor.getDoctorProfiles().get(profileNumber).getHospital().getLocation().getCity();
            String country = doctor.getDoctorProfiles().get(profileNumber).getHospital().getLocation().getCountry();
            String area = doctor.getDoctorProfiles().get(profileNumber).getHospital().getLocation().getArea();
            gender = gender.substring(gender.indexOf("#")+1);
            degree = degree.substring(degree.indexOf("#")+1);
            specialties = specialties.substring(specialties.indexOf("#")+1);
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
                                        <a href="profileupdateAddMore" class="scroll-link" title="Add Profile">
                                            Add another Profile
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
                                Doctor - Update Profile
                            </h1>
                        </div>
                        <form method="post" action="profileupdated" id="doctorProfileInfoForrm" role="form">
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
                                        <input type="text" class="form-control" name="contact" id="contactNumber" placeholder="Contact Number?" value="<%= contactNumber%>" required>
                                    </div>
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
                                        <select class="form-control" name="gender" id="gender" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>"<%= (genderArray.get(i).equals(gender))?"selected":"" %>><%= genderArray.get(i) %></option><%} %>
                                        </select> 
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="degree">
                                            Medical Degree:
                                        </label>
                                        <select class="form-control" name="degree" id="degree" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<degreeArray.size(); i++){%><option value="<%= degreeArray.get(i) %>"<%= (degreeArray.get(i).equals(degree))?"selected":"" %>><%= degreeArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="specialist">
                                            Specialist:
                                        </label>
                                        <select class="form-control" name="specialist" id="specialist" onchange="myFunction0()" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<specialistArray.size(); i++){%><option value="<%= specialistArray.get(i) %>"<%= (specialistArray.get(i).equals(specialist))?"selected":"" %>><%= specialistArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group" id="specialtiesDiv">
                                        <label for="specialties">
                                            Specialty:
                                        </label>
                                        <select class="form-control" name="specialties" id="specialties" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<specialtiesArray.size(); i++){%><option value="<%= specialtiesArray.get(i) %>"<%= (specialtiesArray.get(i).equals(specialties))?"selected":"" %>><%= specialtiesArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="hospital">
                                            Hospital Name:
                                        </label>
                                        <select class="form-control" name="hospital" id="hospital" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<hospitalArray.size(); i++){%><option value="<%= hospitalArray.get(i) %>"<%= (hospitalArray.get(i).equals(hospitalName))?"selected":"" %>><%= hospitalArray.get(i) %></option><%} %>
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label for="day">
                                            Day:
                                        </label>
                                        <select class="form-control" name="day" id="day" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<daysArray.size(); i++){%><option value="<%= daysArray.get(i) %>"<%= (daysArray.get(i).equals(day))?"selected":"" %>><%= daysArray.get(i) %></option><%} %>
                                        </select> 
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="visitingHours">
                                            Visiting Hours From:
                                        </label>
                                        <input type="time" class="form-control" name="visitingHours" id="visitingHours" placeholder="Visiting Hours From?" value="<%= visitingHours%>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="visitingHours2">
                                            Visiting Hours To:
                                        </label>
                                        <input type="time" class="form-control" name="visitingHours2" id="visitingHours2" placeholder="Visiting Hours To?" value="<%= visitingHours2%>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="feeStructure">
                                            Fee Structure:
                                        </label>
                                        <input type="text" class="form-control" name="feeStructure" id="feeStructure" placeholder="Fee Structure?" value="<%= feeStructure%>" required>
                                    </div>
                                    <div class="form-group" id="citiesDiv">
                                        <label for="city">
                                            City:
                                        </label>
                                        <select class="form-control" name="city" id="city" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<cityArray.size(); i++){%><option value="<%= cityArray.get(i) %>"<%= (cityArray.get(i).equals(city))?"selected":"" %>><%= cityArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                    <div class="form-group" id="countriesDiv">
                                        <label for="country">
                                            Country:
                                        </label>
                                        <input type="text" class="form-control" name="country" id="country" value="<%= country%>" placeholder="Country?" readonly>
                                        <%--<select class="form-control" name="country" id="country" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<countryArray.size(); i++){%><option value="<%= countryArray.get(i) %>"<%= (countryArray.get(i).equals(country))?"selected":"" %>><%= countryArray.get(i) %></option><%} %>
                                        </select>--%>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">
                                            Area:
                                        </label>
                                        <select class="form-control" name="area" id="area" required>
                                            <option value="">Select</option>
                                            <%for(int i=0; i<areaArray.size(); i++){%><option value="<%= areaArray.get(i) %>"<%= (areaArray.get(i).equals(area))?"selected":"" %>><%= areaArray.get(i) %></option><%} %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Update
                                        </button>
                                        <button name="addMore" type="submit" class="btn btn-lg btn-primary" id="addMore" formaction="profileupdateAddMore">
                                            Add Hospital
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
            function myFunction0() 
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
                }
            }
        </script>
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
    </body>
</html>