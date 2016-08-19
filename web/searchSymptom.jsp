<%@page import="com.fyp.swdrs.bo.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
            SWDRS - Symptom Search Doctor
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
    <body onload="loadForm()">
        <% 
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> symptomArray = util.populateList(filename + "Symptom_Types");
            String searchSymptomQuery1 = (String)request.getSession().getAttribute("searchSymptomQuery1");
            String searchSymptomQuery2 = (String)request.getSession().getAttribute("searchSymptomQuery2");
            String searchSymptomQuery3 = (String)request.getSession().getAttribute("searchSymptomQuery3");
            String display = (String)request.getSession().getAttribute("display");
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
                                <div class="dropdown">
                                    <button onmouseover="myFunction()" class="dropbtn scroll-link" title="Search">
                                        Search
                                    </button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a href="search" class="scroll-link" title="Search Doctor">
                                            Search
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <!--<li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Search">
                                    Search
                                </a>
                            </li>-->
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
                                Symptom Search Doctor
                            </h1>
                            <br>
                            <br>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <button name="addBTN" type="submit" class="btn-sm" id="addBTN" onclick="addFunction()">
                            Add
                        </button>
                        <button name="removeBTN" type="submit" class="btn-sm" id="removeBTN" onclick="removeFunction()">
                            Remove
                        </button><br>
                        <form method="post" action="searchSymptomSuccess" id="searchfrm" role="form" onsubmit="return checkForm(this);">
                            <div class="col-sm-4">
                                <div class="search-group">
                                    <label for="searchSymptomQuery1">
                                        Search Doctor by Symptom: 1 *
                                    </label>
                                    <select class="search-control" name="searchSymptomQuery1" id="searchSymptomQuery1" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<symptomArray.size(); i++){%><option value="<%= symptomArray.get(i) %>" <%= (symptomArray.get(i).equals(searchSymptomQuery1))?"selected":"" %> ><%= symptomArray.get(i) %></option><%} %>
                                        <%--<%for(int i=0; i<genderArray.size(); i++){%><option value="<%= genderArray.get(i) %>"<%= (genderArray.get(i).equals("Male"))?"selected":"" %>><%= genderArray.get(i) %></option><%} %>--%>
                                    </select> 
                                </div>
                                <div class="search-group" id="searchQueryDiv2">
                                    <%-- <label for="searchSymptomQuery2">
                                        Search Doctor by Symptom: 2 *
                                    </label>
                                    <select class="search-control" name="searchSymptomQuery2" id="searchSymptomQuery2" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<symptomArray.size(); i++){%><option value="<%= symptomArray.get(i) %>" <%= (symptomArray.get(i).equals(searchSymptomQuery2))?"selected":"" %> ><%= symptomArray.get(i) %></option><%} %>
                                    </select> --%>
                                </div>
                                <div class="search-group" id="searchQueryDiv3">
                                    <%-- <label for="searchSymptomQuery3">
                                        Search Doctor by Symptom3: 3 *
                                    </label>
                                    <select class="search-control" name="searchSymptomQuery3" id="searchSymptomQuery3" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<symptomArray.size(); i++){%><option value="<%= symptomArray.get(i) %>" <%= (symptomArray.get(i).equals(searchSymptomQuery3))?"selected":"" %> ><%= symptomArray.get(i) %></option><%} %>
                                    </select> --%>
                                </div>
                                <div class="form-group">
                                    <button name="symptomSearchBtn" type="submit" class="btn btn-lg btn-primary" id="search">
                                        Search Symptom
                                    </button>
                                </div>
                                <br>
                                <br>
                                <br>
                                <br>
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
            var count = 0 ;
        </script>
        <script>
            function loadForm() 
            {
                var d = "<%= display%>" ;
                if(d === "one")
                {
                    document.getElementById("searchSymptomQuery1").value = "<%= searchSymptomQuery1%>";
                }
                if(d === "two")
                {
                    document.getElementById("searchSymptomQuery1").value = "<%= searchSymptomQuery1%>";
                    document.getElementById("searchQueryDiv2").style.visibility= "visible";
                    document.getElementById("searchQueryDiv2").innerHTML = "<label for='searchSymptomQuery2'>Search Doctor by Symptom: 2 *</label><select class='search-control' name='searchSymptomQuery2' id='searchSymptomQuery2' onchange='checkList1()' required><option value=''>Select</option>" + "<%for(int i=0; i<symptomArray.size(); i++){%>" + "<option value='" + "<%= symptomArray.get(i) %>" + "'" + "<%= (symptomArray.get(i).equals(searchSymptomQuery2))?"selected":"" %>" + ">" + "<%= symptomArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    count = 1;
                }
                if(d === "three")
                {
                    document.getElementById("searchSymptomQuery1").value = "<%= searchSymptomQuery1%>";
                    document.getElementById("searchQueryDiv2").style.visibility= "visible";
                    document.getElementById("searchQueryDiv2").innerHTML = "<label for='searchSymptomQuery2'>Search Doctor by Symptom: 2 *</label><select class='search-control' name='searchSymptomQuery2' id='searchSymptomQuery2' onchange='checkList1()' required><option value=''>Select</option>" + "<%for(int i=0; i<symptomArray.size(); i++){%>" + "<option value='" + "<%= symptomArray.get(i) %>" + "'" + "<%= (symptomArray.get(i).equals(searchSymptomQuery2))?"selected":"" %>" + ">" + "<%= symptomArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("searchQueryDiv3").style.visibility= "visible";
                    document.getElementById("searchQueryDiv3").innerHTML = "<label for='searchSymptomQuery3'>Search Doctor by Symptom: 3 *</label><select class='search-control' name='searchSymptomQuery3' id='searchSymptomQuery3' onchange='checkList2()' required><option value=''>Select</option>" + "<%for(int i=0; i<symptomArray.size(); i++){%>" + "<option value='" + "<%= symptomArray.get(i) %>" + "'" + "<%= (symptomArray.get(i).equals(searchSymptomQuery3))?"selected":"" %>" + ">" + "<%= symptomArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    count = 2;
                }
                
            }
        </script>
        <script>
            function addFunction() 
            {
                count++;
                if(count === 1)
                {
                    document.getElementById("searchQueryDiv2").style.visibility= "visible";
                    document.getElementById("searchQueryDiv2").innerHTML = "<label for='searchSymptomQuery2'>Search Doctor by Symptom: 2 *</label><select class='search-control' name='searchSymptomQuery2' id='searchSymptomQuery2' onchange='checkList1()' required><option value=''>Select</option>" + "<%for(int i=0; i<symptomArray.size(); i++){%>" + "<option value='" + "<%= symptomArray.get(i) %>" + "'" + "<%= (symptomArray.get(i).equals(searchSymptomQuery2))?"selected":"" %>" + ">" + "<%= symptomArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                else if(count === 2)
                {
                    document.getElementById("searchQueryDiv3").style.visibility= "visible";
                    document.getElementById("searchQueryDiv3").innerHTML = "<label for='searchSymptomQuery3'>Search Doctor by Symptom: 3 *</label><select class='search-control' name='searchSymptomQuery3' id='searchSymptomQuery3' onchange='checkList2()' required><option value=''>Select</option>" + "<%for(int i=0; i<symptomArray.size(); i++){%>" + "<option value='" + "<%= symptomArray.get(i) %>" + "'" + "<%= (symptomArray.get(i).equals(searchSymptomQuery3))?"selected":"" %>" + ">" + "<%= symptomArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                }
                else 
                {
                    count = 2;
                }

            }
        </script>
        <script>
            function removeFunction() 
            {
                if(count === 2)
                {
//                    document.getElementById("searchQueryDiv3").style.visibility= "hidden";
                    document.getElementById("searchQueryDiv3").innerHTML = "";
                    count=1;
                }
                else if(count === 1)
                {
//                    document.getElementById("searchQueryDiv2").style.visibility= "hidden";
                    document.getElementById("searchQueryDiv2").innerHTML = "";
                    count=0;
                }
            }
        </script>
        <script>
            function checkForm(form) 
            {
                var s1 = form.searchSymptomQuery1.value;
                var s2 = form.searchSymptomQuery2.value;
                var s3 = form.searchSymptomQuery3.value;
                if((s1 === s2)||((s1 === s2)&&(s1 === s3)))
                {
                    alert("Please Select different symptoms!");
                    return false;
                }
//                alert(s1 + ", " + s2);
                return true;
            }
        </script>
        <script>
            function checkList1() 
            {
                var s1 = document.getElementById("searchSymptomQuery1").value;
                var s2 = document.getElementById("searchSymptomQuery2").value;
                if(s1 === s2)
                {
                    alert("Please Select two different symptoms!");
                }
//                alert(s1 + ", " + s2);
            }
        </script>
        <script>
            function checkList2() 
            {
                var s1 = document.getElementById("searchSymptomQuery1").value;
                var s2 = document.getElementById("searchSymptomQuery2").value;
                var s3 = document.getElementById("searchSymptomQuery3").value;
                if((s1 === s2)&&(s1 === s3))
                {
                    alert("Please Select three different symptoms!");
                }
//                alert(s1 + ", " + s2 + ", " + s3);
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
