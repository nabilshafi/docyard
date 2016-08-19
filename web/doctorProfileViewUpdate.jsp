<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
            request.getSession().setAttribute("profileNumber", profileNumber);
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

            String hospitalName = "";
            String days = "";
            String visitingHours = "";
            String visitingHours2 = "";
            String feeStructure = "";
            String city = "";
            String country = "";
            String area = "";
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String maxDate = (dateFormat.format(date)).replace("/", "-");

            String idForTd1 = "";
            String idForTd2 = "";
            String idForTd3 = "";
            String idForTd4 = "";
            String idForTd5 = "";
            String idForTd6 = "";
            String idForTd7 = "";
            String idForTd8 = "";
            String id1 = "";
            String id2 = "";
            String id3 = "";
            String id4 = "";
            String id5 = "";
            String id6 = "";
            String id7 = "";
            String id8 = "";
            String str1 = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            String str8 = "";
            int x = 9;
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
                        <form method="post" action="profileupdated" id="doctorProfileInfoForrm" role="form">
                            <div id="doctorProfileInfo">
                                <div class="col-sm-4">
                                    <div class="search-group">
                                        <table id="myTable" width="1000">
                                            <tr>
                                                <td>
                                                    <label for="name">
                                                        Name:
                                                    </label>
                                                </td>
                                                <td id="value1">
                                                    <input type="text" class="form-control" name="name"  id="name" placeholder="Name" value="<%= name%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value1', 'name', '1', '<%= name%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value1', 'name', '1', '<%= name%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value1', 'name', '1', '<%= name%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="email">
                                                        Email:
                                                    </label>
                                                </td>
                                                <td id="value2">
                                                    <input type="text" class="form-control" name="email"  id="email" placeholder="Email" value="<%= email%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value2', 'email', '2', '<%= email%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value2', 'email', '2', '<%= email%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value2', 'email', '2', '<%= email%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="contact">
                                                        Contact:
                                                    </label>
                                                </td>
                                                <td id="value3">
                                                    <input type="text" class="form-control" name="contact"  id="contact" placeholder="Contact" value="<%= contactNumber%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value3', 'contact', '3', '<%= contactNumber%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value3', 'contact', '3', '<%= contactNumber%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value3', 'contact', '3', '<%= contactNumber%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="dateOfBirth">
                                                        Date Of Birth:
                                                    </label>
                                                </td>
                                                <td id="value4">
                                                    <input type="text" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Date of Birth" value="<%= dateOfBirth%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value4', 'dateOfBirth', '4', '<%= dateOfBirth%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value4', 'dateOfBirth', '4', '<%= dateOfBirth%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value4', 'dateOfBirth', '4', '<%= dateOfBirth%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="gender">
                                                        Gender:
                                                    </label>
                                                </td>
                                                <td id="value5">
                                                    <input type="text" class="form-control" name="gender" id="gender" placeholder="Gender" value="<%= gender%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value5', 'gender', '5', '<%= gender%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value5', 'gender', '5', '<%= gender%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value5', 'gender', '5', '<%= gender%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="degree">
                                                        Degree:
                                                    </label>
                                                </td>
                                                <td id="value6">
                                                    <input type="text" class="form-control" name="degree" id="degree" placeholder="Degree" value="<%= degree%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value6', 'degree', '6', '<%= degree%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value6', 'degree', '6', '<%= degree%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value6', 'degree', '6', '<%= degree%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="specialist">
                                                        Specialist:
                                                    </label>
                                                </td>
                                                <td id="value7">
                                                    <input type="text" class="form-control" name="specialist" id="specialist" placeholder="Specialist" value="<%= specialist%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value7', 'specialist', '7', '<%= specialist%>')">
                                                    Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value7', 'specialist', '7', '<%= specialist%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value7', 'specialist', '7', '<%= specialist%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="specialties">
                                                        Specialties:
                                                    </label>
                                                </td>
                                                <td id="value8">
                                                    <input type="text" class="form-control" name="specialties" id="specialties" placeholder="Specialties" value="<%= specialties%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value8', 'specialties', '8', '<%= specialties%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value8', 'specialties', '8', '<%= specialties%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value8', 'specialties', '8', '<%= specialties%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <%for(int i=0; i<doctorProfile.size(); i++){
                                                hospitalName = doctorProfile.get(i).getHospital().getHospitalName();
                                                days = doctorProfile.get(i).getHospital().getDays();
                                                visitingHours = doctorProfile.get(i).getHospital().getVisitingHours();
                                                visitingHours2 = doctorProfile.get(i).getHospital().getVisitingHours2();
                                                feeStructure = doctorProfile.get(i).getHospital().getFeeStructure();
                                                city = doctorProfile.get(i).getHospital().getLocation().getCity();
                                                country = doctorProfile.get(i).getHospital().getLocation().getCountry();
                                                area = doctorProfile.get(i).getHospital().getLocation().getArea();
                                                city = city.substring(city.indexOf("#")+1);
                                                country = country.substring(country.indexOf("#")+1);
                                                area = area.substring(area.indexOf("#")+1);
                                                
                                                 str1 = "value" + Integer.toString((x + i));
                                                 id1 = Integer.toString((x + i)); x += 1;
                                                 str2 = "value" + Integer.toString((x + i));
                                                 id2 = Integer.toString((x + i)); x += 1;
                                                 str3 = "value" + Integer.toString((x + i));
                                                 id3 = Integer.toString((x + i)); x += 1;
                                                 str4 = "value" + Integer.toString((x + i));
                                                 id4 = Integer.toString((x + i)); x += 1;
                                                 str5 = "value" + Integer.toString((x + i));
                                                 id5 = Integer.toString((x + i)); x += 1;
                                                 str6 = "value" + Integer.toString((x + i));
                                                 id6 = Integer.toString((x + i)); x += 1;
                                                 str7 = "value" + Integer.toString((x + i));
                                                 id7 = Integer.toString((x + i)); x += 1;
                                                 str8 = "value" + Integer.toString((x + i));
                                                 id8 = Integer.toString((x + i)); 
                                                 idForTd1 = "hospitalName" + Integer.toString(i); 
                                                 idForTd2 = "day" + Integer.toString(i); 
                                                 idForTd3 = "visitingHours" + Integer.toString(i); 
                                                 idForTd4 = "visitingHours2" + Integer.toString(i); 
                                                 idForTd5 = "feeStructure" + Integer.toString(i); 
                                                 idForTd6 = "city" + Integer.toString(i); 
                                                 idForTd7 = "country" + Integer.toString(i); 
                                                 idForTd8 = "area" + Integer.toString(i); 
                                            %>
                                            <tr>
                                                <td>
                                                </td>
                                                <td>
                                                    <br>
                                                    <label>
                                                        <strong>
                                                            Hospital <%= i+1%> Information
                                                        </strong>
                                                    </label>
                                                    <br>
                                                    <br>
                                                </td>
                                                <td>
                                                </td>
                                                <td>
                                                </td>
                                                <td>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd1%>">
                                                        Hospital Name:
                                                    </label>
                                                </td>
                                                <td id="<%= str1%>">
                                                    <input type="text" class="form-control" name="<%= idForTd1%>" id="<%= idForTd1%>" placeholder="Hospital Name" value="<%= hospitalName%>" readonly required>
                                                  </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateHospitalNameBtn('<%= str1%>', '<%= idForTd1%>', '<%= id1%>', '<%= hospitalName%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteHospitalNameBtn('<%= str1%>', '<%= idForTd1%>', '<%= id1%>', '<%= hospitalName%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetHospitalNameBtn('<%= str1%>', '<%= idForTd1%>', '<%= id1%>', '<%= hospitalName%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd2%>">
                                                        Day:
                                                    </label>
                                                </td>
                                                <td id="<%= str2%>">
                                                    <input type="text" class="form-control" name="<%= idForTd2%>" id="<%= idForTd2%>" placeholder="Day" value="<%= days%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateDayBtn('<%= str2%>', '<%= idForTd2%>', '<%= id2%>', '<%= days%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteDayBtn('<%= str2%>', '<%= idForTd2%>', '<%= id2%>', '<%= days%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetDayBtn('<%= str2%>', '<%= idForTd2%>', '<%= id2%>', '<%= days%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd3%>">
                                                        Visiting Hours From:
                                                    </label>
                                                </td>
                                                <td id="<%= str3%>">
                                                    <input type="text" class="form-control" name="<%= idForTd3%>" id="<%= idForTd3%>" placeholder="Visiting Hours From" value="<%= visitingHours%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateVisitingHoursBtn('<%= str3%>', '<%= idForTd3%>', '<%= id3%>', '<%= visitingHours%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteVisitingHoursBtn('<%= str3%>', '<%= idForTd3%>', '<%= id3%>', '<%= visitingHours%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetVisitingHoursBtn('<%= str3%>', '<%= idForTd3%>', '<%= id3%>', '<%= visitingHours%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd4%>">
                                                        Visiting Hours To:
                                                    </label>
                                                </td>
                                                <td id="<%= str4%>">
                                                    <input type="text" class="form-control" name="<%= idForTd4%>" id="<%= idForTd4%>"  placeholder="Visiting Hours To" value="<%= visitingHours2%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateVisitingHours2Btn('<%= str4%>', '<%= idForTd4%>', '<%= id4%>', '<%= visitingHours2%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteVisitingHours2Btn('<%= str4%>', '<%= idForTd4%>', '<%= id4%>', '<%= visitingHours2%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetVisitingHours2Btn('<%= str4%>', '<%= idForTd4%>', '<%= id4%>', '<%= visitingHours2%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd5%>">
                                                        Fee Structure:
                                                    </label>
                                                </td>
                                                <td id="<%= str5%>">
                                                    <input type="text" class="form-control" name="<%= idForTd5%>" id="<%= idForTd5%>"  placeholder="Fee Structure" value="<%= feeStructure%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('<%= str5%>', '<%= idForTd5%>', '<%= id5%>', '<%= feeStructure%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('<%= str5%>', '<%= idForTd5%>', '<%= id5%>', '<%= feeStructure%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('<%= str5%>', '<%= idForTd5%>', '<%= id5%>', '<%= feeStructure%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd6%>">
                                                        City:
                                                    </label>
                                                </td>
                                                <td id="<%= str6%>">
                                                    <input type="text" class="form-control" name="<%= idForTd6%>" id="<%= idForTd6%>"  placeholder="City" value="<%= city%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateCityBtn('<%= str6%>', '<%= idForTd6%>', '<%= id6%>', '<%= city%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteCityBtn('<%= str6%>', '<%= idForTd6%>', '<%= id6%>', '<%= city%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetCityBtn('<%= str6%>', '<%= idForTd6%>', '<%= id6%>', '<%= city%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd7%>">
                                                        Country:
                                                    </label>
                                                </td>
                                                <td id="<%= str7%>">
                                                    <input type="text" class="form-control" name="<%= idForTd7%>" id="<%= idForTd7%>"  placeholder="Country" value="<%= country%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('<%= str7%>', '<%= idForTd7%>', '<%= id7%>', '<%= country%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('<%= str7%>', '<%= idForTd7%>', '<%= id7%>', '<%= country%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('<%= str7%>', '<%= idForTd7%>', '<%= id7%>', '<%= country%>')">
                                                        Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label for="<%= idForTd8%>">
                                                        Area:
                                                    </label>
                                                </td>
                                                <td id="<%= str8%>">
                                                    <input type="text" class="form-control" name="<%= idForTd8%>" id="<%= idForTd8%>"  placeholder="Area" value="<%= area%>" readonly required>
                                                </td>
                                                <td>
                                                    <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateAreaBtn('<%= str8%>', '<%= idForTd8%>', '<%= id8%>', '<%= area%>')">
                                                        Update
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteAreaBtn('<%= str8%>', '<%= idForTd8%>', '<%= id8%>', '<%= area%>')">
                                                        Delete
                                                    </p>
                                                </td>
                                                <td>
                                                    <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetAreaBtn('<%= str8%>', '<%= idForTd8%>', '<%= id8%>', '<%= area%>')">
                                                    Reset
                                                    </p>
                                                </td>
                                            </tr>
                                            <%} %>
                                        </table>
                                        <button name="saveBtn" type="submit" class="btn btn-lg btn-primary" id="saveBtn">
                                            Save
                                        </button>
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
        <script type = "text/javascript">
            function updateBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                if(id2 === "dateOfBirth")
                {
                    document.getElementById(id1).innerHTML = "<input type='date' class='form-control' name='dateOfBirth' id='dateOfBirth' placeholder='Date of Birth' value='" + "<%= dateOfBirth%>" + "' max='" + "<%= maxDate%>" + "' required>";
                }
                if(id2 === "gender")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='gender' id='gender' required><option value=''>Select</option>" + "<%for(int i=0; i<genderArray.size(); i++){%>" + "<option value='" + "<%= genderArray.get(i) %>" + "'" + "<%= (genderArray.get(i).equals(gender))?"selected":"" %>" + ">" + "<%= genderArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                if(id2 === "degree")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='degree' id='degree' required><option value=''>Select</option>" + "<%for(int i=0; i<degreeArray.size(); i++){%>" + "<option value='" + "<%= degreeArray.get(i) %>" + "'" + "<%= (degreeArray.get(i).equals(degree))?"selected":"" %>" + ">" + "<%= degreeArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                if(id2 === "specialist")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='specialist' id='specialist' required><option value=''>Select</option>" + "<%for(int i=0; i<specialistArray.size(); i++){%>" + "<option value='" + "<%= specialistArray.get(i) %>" + "'" + "<%= (specialistArray.get(i).equals(specialist))?"selected":"" %>" + ">" + "<%= specialistArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                if(id2 === "specialties")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='specialties' id='specialties' required><option value=''>Select</option>" + "<%for(int i=0; i<specialtiesArray.size(); i++){%>" + "<option value='" + "<%= specialtiesArray.get(i) %>" + "'" + "<%= (specialtiesArray.get(i).equals(specialties))?"selected":"" %>" + ">" + "<%= specialtiesArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
            }
        </script>
        <script type = "text/javascript">
            function saveBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = true;
            }
        </script>
        <script type = "text/javascript">
            function resetBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                if(id2 === "dateOfBirth")
                {
                    document.getElementById(id1).innerHTML = "<input type='date' class='form-control' name='dateOfBirth' id='dateOfBirth' placeholder='Date of Birth' value='" + id4 + "' required readonly>";
                }
                if(id2 === "gender")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='gender' id='gender' placeholder='Gender' value='" + id4 + "' readonly required>";
                }
                if(id2 === "degree")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='degree' id='degree' placeholder='Degree' value='" + id4 + "' readonly required>";
                }
                if(id2 === "specialist")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='specialist' id='specialist' placeholder='Specialist' value='" + id4 + "' readonly required>";
                }
                if(id2 === "specialties")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='specialties' id='specialties' placeholder='Specialties' value='" + id4 + "' readonly required>";
                }
            }
        </script>
        <script type = "text/javascript">
            function deleteBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                if(id2 === "dateOfBirth")
                {
                    document.getElementById(id1).innerHTML = "<input type='date' class='form-control' name='dateOfBirth' id='dateOfBirth' placeholder='Date of Birth' value='' required readonly>";
                }
                if(id2 === "gender")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='gender' id='gender' placeholder='Gender' value='' readonly required>";
                }
                if(id2 === "degree")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='degree' id='degree' placeholder='Degree' value='' readonly required>";
                }
                if(id2 === "specialist")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='specialist' id='specialist' placeholder='Specialist' value='' readonly required>";
                }
                if(id2 === "specialties")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='specialties' id='specialties' placeholder='Specialties' value='' readonly required>";
                }
            }
        </script>
        <script type = "text/javascript">
            function updateHospitalNameBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                alert(id1 + ", " + id2 + ", " + id3 + ", " + id4);
                alert(document.getElementById(id2).value);
                document.getElementById(id1).innerHTML = "<select class='form-control' name='" + id2 + "' id='" + id2 + "' required><option value='"+ id2 +"'>Select</option>" + "<%for(int i=0; i<hospitalArray.size(); i++){%>" + "<option value='" + "<%= hospitalArray.get(i) %>" + "'" + "<%= (hospitalArray.get(i).equals(id4))?"selected":"" %>" + ">" + "<%= hospitalArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";            
            }
        </script>
        <script type = "text/javascript">
            function resetHospitalNameBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Hospital Name' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteHospitalNameBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Hospital Name' value='' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function updateDaysBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                alert(id1 + ", " + id2 + ", " + id3 + ", " + id4);
                document.getElementById(id1).innerHTML = "<select class='form-control' name='" + id2 + "' id='" + id2 + "' required><option value=''>Select</option>" + "<%for(int i=0; i<daysArray.size(); i++){%>" + "<option value='" + "<%= daysArray.get(i) %>" + "'" + "<%= (daysArray.get(i).equals(id4))?"selected":"" %>" + ">" + "<%= daysArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";            
            }
        </script>
        <script type = "text/javascript">
            function resetDaysBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Days' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteDaysBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Days' value='' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function updateVisitingHoursBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Visiting Hours From' value='" + id4 + "' required>";
            }
        </script>
        <script type = "text/javascript">
            function resetVisitingHoursBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='visiting Hours From' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteVisitingHoursBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='visiting Hours From' value='' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function updateVisitingHours2Btn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Visiting Hours From' value='" + id4 + "' required>";
            }
        </script>
        <script type = "text/javascript">
            function resetVisitingHours2Btn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Visiting Hours To' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteVisitingHours2Btn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='time' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Visiting Hours To' value='' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function updateAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                document.getElementById(id1).innerHTML = "<select class='form-control' name='" + id2 + "' id='" + id2 + "' required><option value=''>Select</option>" + "<%for(int i=0; i<cityArray.size(); i++){%>" + "<option value='" + "<%= cityArray.get(i) %>" + "'" + "<%= (cityArray.get(i).equals(id4))?"selected":"" %>" + ">" + "<%= cityArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";            
            }
        </script>
        <script type = "text/javascript">
            function resetAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Area' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Area' value='' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function updateAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
                alert(id1 + ", " + id2 + ", " + id3 + ", " + id4);
                document.getElementById(id1).innerHTML = "<select class='form-control' name='" + id2 + "' id='" + id2 + "' required><option value=''>Select</option>" + "<%for(int i=0; i<areaArray.size(); i++){%>" + "<option value='" + "<%= areaArray.get(i) %>" + "'" + "<%= (areaArray.get(i).equals(id4))?"selected":"" %>" + ">" + "<%= areaArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";            
            }
        </script>
        <script type = "text/javascript">
            function resetAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = id4;
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Area' value='" + id4 + "' readonly required>";
            }
        </script>
        <script type = "text/javascript">
            function deleteAreaBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
                document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='" + id2 + "' id='" + id2 + "' placeholder='Area' value='' readonly required>";
            }
        </script>
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