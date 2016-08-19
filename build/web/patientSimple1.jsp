<%@page import="java.util.HashMap"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="com.fyp.swdrs.bo.DoctorProfile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
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
            ArrayList<DoctorProfile> doctorProfiles = (ArrayList<DoctorProfile>)request.getSession().getAttribute("searchObj");
            String searchQuery = (String)request.getSession().getAttribute("searchQuery");
            HashMap<String, ArrayList<Integer>> uniqueMap =  Utility.removeDoctorProfiles(doctorProfiles);
            double systemRating = 0;
            String name = "", email = "", contact = "", dateOfBirth = "", gender = "", degree = "", specialist = "", specialties = "", hospitalName = "", days = "", visitingHours = "", feeStructure = "", city = "", country = "", area = "";
            String tempHospitalName = "", tempDays = "", tempVisitingHours = "", tempFeeStructure = "", tempCity = "", tempCountry = "", tempArea = "";
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
                                    SWDRS - Search Results
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
        <section id="doctorInfo">
                <div class="container">
                    <div class="row mrgn30">
                        <div class="heading text-center"> 
                            <h1><br>
                                For "<%= searchQuery%>"
                            </h1>
                        </div>
                        <%for(int i=0; i<doctorProfiles.size(); i++) {
                            DoctorProfile doctorProfile = doctorProfiles.get(i);
                            if(doctorProfile != null)
                            {
                                name = doctorProfile.getName();
                                email = doctorProfile.getEmail();
                                contact = doctorProfile.getContact();
                                dateOfBirth = doctorProfile.getDateOfBirth();
                                ArrayList<Integer> ageArray = Utility.calculateAge(dateOfBirth);
                                String age = Integer.toString(ageArray.get(0));
                                gender = doctorProfile.getGender();
                                gender = gender.substring(gender.indexOf("#")+1).replace("_", " ");
                                degree = doctorProfile.getSpecialization().getDegree();
                                degree = degree.substring(degree.indexOf("#")+1).replace("_", " ");
                                specialist = doctorProfile.getSpecialization().getSpecialist();
                                specialties = doctorProfile.getSpecialization().getSpecialties();
                                specialties = specialties.substring(specialties.indexOf("#")+1).replace("_", " ");
                                systemRating = doctorProfile.getSystemRating();
//                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
//                                systemRating = decimalFormat.format(systemRating));
                                hospitalName = doctorProfile.getHospital().getHospitalName();
                                days = doctorProfile.getHospital().getDays();
                                visitingHours = doctorProfiles.get(i).getHospital().getVisitingHours();
                                visitingHours = Utility.timeFormat(visitingHours);
                                feeStructure = doctorProfile.getHospital().getFeeStructure();
                                city = doctorProfile.getHospital().getLocation().getCity();
                                city = city.substring(city.indexOf("#")+1).replace("_", " ");
                                country = doctorProfile.getHospital().getLocation().getCountry();
                                country = country.substring(country.indexOf("#")+1).replace("_", " ");
                                area = doctorProfile.getHospital().getLocation().getArea();
                                area = area.substring(area.indexOf("#")+1).replace("_", " ");
                            %>
                            <h4>
                                <a><u><%= name%>, <%= degree%></u></a><br> 
                                <%= name%>, (<%= gender.toLowerCase()%>), who is  <%= age%> years old is <%= ((specialist.equals("Yes")) ? " a" : " not a")%> specialist having a medical degree of <%= degree%> <%= ((specialist.equals("Yes")) ? ", specialist of " + specialties : "")%>.<br>
                                <%= name%> have a rating: <%= systemRating%>.<br>
                                Contact at email: <%= email%>, phone: <%= contact%><br>
                                He sits at the following hospitals:-<br>
                                <li><%= hospitalName%> on <%= days%>, at <%= visitingHours%>, located in <%= area%>, <%= city%>, <%= country%>, fee: <%= feeStructure%> PKR.</li>
                                <%
                                    ArrayList<Integer> value = uniqueMap.get(email);
                                    for (int j = 1; j < value.size(); j++) {
                                        int index = value.get(j);
                                        tempHospitalName = doctorProfiles.get(index).getHospital().getHospitalName();
                                        tempDays = doctorProfiles.get(index).getHospital().getDays();
                                        tempVisitingHours = doctorProfiles.get(index).getHospital().getVisitingHours();
                                        tempVisitingHours = Utility.timeFormat(tempVisitingHours);
                                        tempFeeStructure = doctorProfiles.get(index).getHospital().getFeeStructure();
                                        tempCity = doctorProfiles.get(index).getHospital().getLocation().getCity();
                                        tempCity = tempCity.substring(tempCity.indexOf("#")+1).replace("_", " ");
                                        tempCountry = doctorProfiles.get(index).getHospital().getLocation().getCountry();
                                        tempCountry = tempCountry.substring(tempCountry.indexOf("#")+1).replace("_", " ");
                                        tempArea = doctorProfiles.get(index).getHospital().getLocation().getArea();
                                        tempArea = tempArea.substring(tempArea.indexOf("#")+1).replace("_", " ");
                                        doctorProfiles.set(index, null);
                                    %>
                                    <li><%= tempHospitalName%> on <%= tempDays%>, at <%= tempVisitingHours%>, located in <%= tempArea%>, <%= tempCity%>, <%= tempCountry%>, fee: <%= tempFeeStructure%> PKR.</li>
                                <%}%>
                            </h4>
                            <%}%>
                        <%}%>
                    </div>
                    <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Back" onClick="location.href='search'" />
                    <!--<button name="backBtn" type="submit" class="btn btn-lg btn-primary" id="back" value="Back" >
                        Back
                    </button>-->
                </div>
        </section> 
        <!--<section class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 text-center"> 
                        Copyright 2015 | All Rights Reserved By SWDRS. 
                    </div>
                </div>
            </div>
        </section>-->
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
    </body>
</html>
