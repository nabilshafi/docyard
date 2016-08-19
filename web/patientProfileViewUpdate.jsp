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
            Patient patient = (Patient)request.getSession().getAttribute("patient");
            String name = patient.getPatientProfile().getName();
            String email = patient.getPatientProfile().getEmail();
            String contactNumber = patient.getPatientProfile().getContact();
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
            city = city.replace("_", " ");
            country = country.replace("_", " ");
            area = area.replace("_", " ");            
            
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> genderArray = util.populateList(filename + "Gender_Types");
            ArrayList<String> cityArray = util.populateList(filename + "Cities_Pakistan");
            ArrayList<String> countryArray = util.populateList(filename + "Countries_World");
            ArrayList<String> areaArray = util.populateList(filename + "Areas_Names");
            ArrayList<String> incomeGroupArray = util.populateList(filename + "Income_Groups");
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
                                Patient - View Profile
                            </h1>
                            <br>
                        </div>
                        <form method="post" action="profileupdated" id="patientProfileForrm" role="form">
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
                                                <label for="incomeGroup">
                                                    Income Group:
                                                </label>
                                            </td>
                                            <td id="value6">
                                                <input type="text" class="form-control" name="incomeGroup" id="incomeGroup" placeholder="Income Group" value="<%= incomeGroup%>" readonly required>
                                            </td>
                                            <td>
                                                <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value6', 'incomeGroup', '6', '<%= incomeGroup%>')">
                                                    Update
                                                </p>
                                            </td>
                                            <td>
                                                <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value6', 'incomeGroup', '6', '<%= incomeGroup%>')">
                                                    Delete
                                                </p>
                                            </td>
                                            <td>
                                                <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value6', 'incomeGroup', '6', '<%= incomeGroup%>')">
                                                    Reset
                                                </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="city">
                                                    City:
                                                </label>
                                            </td>
                                            <td id="value7">
                                                <input type="text" class="form-control" name="city" id="city" placeholder="City" value="<%= city%>" readonly required>
                                            </td>
                                            <td>
                                                <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value7', 'city', '7', '<%= city%>')">
                                                    Update
                                                </p>
                                            </td>
                                            <td>
                                                <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value7', 'city', '7', '<%= city%>')">
                                                    Delete
                                                </p>
                                            </td>
                                            <td>
                                                <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value7', 'city', '7', '<%= city%>')">
                                                    Reset
                                                </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="country">
                                                    Country:
                                                </label>
                                            </td>
                                            <td id="value8">
                                                <input type="text" class="form-control" name="country" id="country" placeholder="Country" value="<%= country%>" readonly required>
                                            </td>
                                            <td>
                                                <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value8', 'country', '8', '<%= country%>')">
                                                    Update
                                                </p>
                                            </td>
                                            <td>
                                                <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value8', 'country', '8', '<%= country%>')">
                                                    Delete
                                                </p>
                                            </td>
                                            <td>
                                                <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value8', 'country', '8', '<%= country%>')">
                                                    Reset
                                                </p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label for="area">
                                                    Area:
                                                </label>
                                            </td>
                                            <td id="value9">
                                                <input type="text" class="form-control" name="area" id="area" placeholder="Area" value="<%= area%>" readonly required>
                                            </td>
                                            <td>
                                                <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('value9', 'area', '9', '<%= area%>')">
                                                    Update
                                                </p>
                                            </td>
                                            <td>
                                                <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('value9', 'area', '9', '<%= area%>')">
                                                    Delete
                                                </p>
                                            </td>
                                            <td>
                                                <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('value9', 'area', '9', '<%= area%>')">
                                                    Reset
                                                </p>
                                            </td>
                                        </tr>
                                    </table>
                                    <button name="saveBtn" type="submit" class="btn btn-lg btn-primary" id="saveBtn">
                                        Save
                                    </button>
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
                if(id2 === "incomeGroup")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='incomeGroup' id='incomeGroup' required><option value=''>Select</option>" + "<%for(int i=0; i<incomeGroupArray.size(); i++){%>" + "<option value='" + "<%= incomeGroupArray.get(i) %>" + "'" + "<%= (incomeGroupArray.get(i).equals(incomeGroup))?"selected":"" %>" + ">" + "<%= incomeGroupArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                if(id2 === "city")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='city' id='city' required><option value=''>Select</option>" + "<%for(int i=0; i<cityArray.size(); i++){%>" + "<option value='" + "<%= cityArray.get(i) %>" + "'" + "<%= (cityArray.get(i).equals(city))?"selected":"" %>" + ">" + "<%= cityArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                if(id2 === "area")
                {
                    document.getElementById(id1).innerHTML = "<select class='form-control' name='area' id='area' required><option value=''>Select</option>" + "<%for(int i=0; i<areaArray.size(); i++){%>" + "<option value='" + "<%= areaArray.get(i) %>" + "'" + "<%= (areaArray.get(i).equals(area))?"selected":"" %>" + ">" + "<%= areaArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
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
                if(id2 === "incomeGroup")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='incomeGroup' id='incomeGroup' placeholder='Income Group' value='" + id4 + "' readonly required>";
                }
                if(id2 === "city")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='city' id='city' placeholder='City' value='" + id4 + "' readonly required>";
                }
                if(id2 === "area")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='area' id='area' placeholder='Area' value='" + id4 + "' readonly required>";
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
                if(id2 === "incomeGroup")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='incomeGroup' id='incomeGroup' placeholder='Income Group' value='' readonly required>";
                }
                if(id2 === "city")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='city' id='city' placeholder='City' value='' readonly required>";
                }
                if(id2 === "area")
                {
                    document.getElementById(id1).innerHTML = "<input type='text' class='form-control' name='area' id='area' placeholder='Area' value='' readonly required>";
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
