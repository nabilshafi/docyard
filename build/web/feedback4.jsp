<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3">
	<title>
            SWDRS - Feedback
        </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen">
	<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/stylesheet.css">
	<link href="css/animate.css" rel="stylesheet" media="screen">
	<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link href="font/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        <% 
            Patient patient = (Patient)request.getSession().getAttribute("patient");
            String name = patient.getName();
            String email = patient.getEmail();
            int count = patient.getUserHasProfile();
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> feedbackQuestions = util.retrieveFeedbackQuestions(filename);
            ArrayList<String> doctorNameArray1 = util.populateDoctorNameList(filename);
            ArrayList<String> doctorNameArray = util.removeDuplicates(doctorNameArray1);

            ArrayList<String> yesNoArray = util.populateList(filename + "Yes_No");
            ArrayList<String> visitArray = util.populateList(filename + "Visit");
            ArrayList<String> behaviourArray = util.populateList(filename + "Behaviour");
            ArrayList<String> scaleArray = util.populateList(filename + "Scale");
            ArrayList<String> diagnosisArray = util.populateList(filename + "Diagnosis");
//            ArrayList<String> doctorNameArray = util.removeDuplicates(util.populateDoctorNameList(filename));
            //ArrayList<String> doctorEmailArray = util.populateDoctorEmail(filename + "DoctorProfile");
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
                            <li>
                                <a href="search" class="scroll-link" title="Search Doctor">
                                    Search
                                </a>
                            </li>
                            <li class="active" id="firstLink">
                                <a href="" class="scroll-link" title="Feedback">
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
                                Feedback
                            </h1>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="feedbacksuccess" id="feedbackfrm" role="form">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="patientName">
                                        Patient Name:*
                                    </label>
                                    <input type="text" class="form-control" name="patientName" id="patientName" placeholder="Enter Name" title="Please enter your name" value="<%= name%>" readonly required>
                                </div>
                                <div class="form-group">
                                    <label for="patientEmail">
                                        Patient Email:*
                                    </label>
                                    <input type="text" class="form-control" name="patientEmail" id="patientEmail" placeholder="Enter Email" title="Please enter a valid email address" value="<%= email%>" readonly required>
                                </div> 
                                <div class="form-group">
                                    <label for="doctorName">
                                        Doctor Name:*
                                    </label>
                                    <select class="form-control" name="doctorName" id="doctorName" onchange="myFunction0()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<doctorNameArray.size(); i++){%><option value="<%= doctorNameArray.get(i) %>"><%= doctorNameArray.get(i) %></option><%} %>
                                    </select>
                                </div> 
                                <%--</div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="introduction1" id="introduction1Label">
                                        <!--Have you seen a doctor for more than 3 times for the same condition?*-->
                                        <%= feedbackQuestions.get(0)%>
                                    </label>
                                    <select class="form-control" name="introduction1Answer" id="introduction1Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="introduction2" id="introduction2Label">
                                        <!--Was it easy to get an appointment?*-->
                                        <%= feedbackQuestions.get(1)%>
                                    </label>
                                    <select class="form-control" name="introduction2Answer" id="introduction2Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="introduction3" id="introduction3Label">
                                        <!--Did the doctor introduce himself/herself?*-->
                                        <%= feedbackQuestions.get(2)%>
                                    </label>
                                    <select class="form-control" name="introduction3Answer" id="introduction3Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="introduction4" id="introduction4Label">-->
                                        <!--When was your last visit to the doctor for the same condition?*
                                        <%= feedbackQuestions.get(3)%>
                                    </label>
                                    <select class="form-control" name="introduction4Answer" id="introduction4Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<visitArray.size(); i++){%><option value="<%= visitArray.get(i) %>"><%= visitArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">--%>
                                <div class="form-group" id="behaviour1Div">
                                </div>
                                <div class="form-group" id="behaviour2Div">
                                </div>
                                <div class="form-group" id="behaviour3Div">
                                </div>
                                <div class="form-group" id="behaviour4Div">
                                </div>
                                <div class="form-group" id="behaviour5Div">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group" id="behaviour6Div">
                                </div>
                                <div class="form-group" id="interaction1Div">
                                </div>
                                <div class="form-group" id="interaction2Div">
                                </div>
                                <div class="form-group" id="interaction3Div">
                                </div>
                                <div class="form-group" id="interaction4Div">
                                </div>
                                <div class="form-group" id="interaction5Div">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group" id="interaction6Div">
                                </div>
                                <div class="form-group" id="interaction7Div">
                                </div>
                                <div class="form-group" id="interaction8Div">
                                </div>
                                <div class="form-group" id="interaction9Div">
                                </div>
                                <!--</div>
                            <div class="col-sm-4">-->
                                <div class="form-group" id="diagnosisTimeDiv">
                                </div>
                                <div class="form-group" id="scaleDiv">
                                </div>
                            
                                <!--<div class="form-group">
                                    <label for="feedback">
                                        Feedback: *
                                    </label>
                                    <textarea name="feedbackTextArea" class="form-control" id="feedbackTextArea" cols="5" rows="5" placeholder="Feedback: " title="Please enter your feedback" required></textarea>
                                </div>-->
                            </div>
                                <div class="col-sm-4" id="buttonDiv">
<!--                                     <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Submit
                                    </button>-->
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
                var y = document.getElementById("doctorName").value;
                if(y === "") {
                    document.getElementById("behaviour1Div").style.visibility= "hidden";
                    document.getElementById("brDiv").style.visibility= "hidden";
                    y = "the doctor";
                }
                else {
                    document.getElementById("behaviour1Div").style.visibility= "visible";
                    document.getElementById("behaviour1Div").innerHTML = "<label for='behaviour1' id='behaviour1Label'>" + "<%= feedbackQuestions.get(0)%>" + "</label><select class='form-control' name='behaviour1Answer' id='behaviour1Answer' onchange='myFunction1()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";

                    document.getElementById("behaviour1Label").innerHTML = "Was " + y + " warm and friendly?*";
                    document.getElementById("behaviour2Label").innerHTML = "Was " + y + " respectful?*";
                    document.getElementById("behaviour3Label").innerHTML = "Was " + y + " attentive?*";
                    document.getElementById("behaviour4Label").innerHTML = "Was " + y + " concerned?*";
                    document.getElementById("behaviour5Label").innerHTML = "Was " + y + " telling things properly?*";
                    document.getElementById("behaviour6Label").innerHTML = "Did " + y + " give you ample time?*";
                    document.getElementById("interaction1Label").innerHTML = "Did " + y + " understand and ask questions regarding your health history?*";
                    document.getElementById("interaction2Label").innerHTML = "Did " + y + " discuss treatment option with you?*";
                    document.getElementById("interaction3Label").innerHTML = "Did " + y + " explain drugs, other treatments, their expected effects and side effects?*";
                    document.getElementById("interaction4Label").innerHTML = "Did " + y + " answer questions to your satisfaction?*";
                    document.getElementById("interaction5Label").innerHTML = "Did " + y + " give you advice on what to do if symptoms persist or worsen?*";
                    document.getElementById("interaction6Label").innerHTML = "Did " + y + " give advice to you on ways to stay healthy?*";
                    document.getElementById("interaction7Label").innerHTML = "Did " + y + " treated you well?*";
                    document.getElementById("interaction8Label").innerHTML = "Would you be happy to see " + y + " again?*";
                    document.getElementById("interaction9Label").innerHTML = "Do you think " + y + " is good and will give you the right care?*";
                    document.getElementById("diagnosisTimeLabel").innerHTML = "How much time did " + y + " take in diagnosis?*";
                    document.getElementById("scaleLabel").innerHTML = "On the scale of 1-10, (1 being the lowest and 10 being the highest), mention your extent of satisfaction?*";
                }
            }
        </script>
        
        <script>
            function myFunction1() {
                var x = document.getElementById("behaviour1Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("behaviour2Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("behaviour2Div").style.visibility= "visible";
                    document.getElementById("behaviour2Div").innerHTML = "<label for='behaviour2' id='behaviour2Label'>" + "<%= feedbackQuestions.get(1)%>" + "</label><select class='form-control' name='behaviour2Answer' id='behaviour2Answer' onchange='myFunction2()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("behaviour2Label").innerHTML = "Was " + y + " respectful?*";
                }
                
            }
        </script>
        <script>
            function myFunction2() {
                var x = document.getElementById("behaviour2Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("behaviour3Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("behaviour3Div").style.visibility= "visible";
                    document.getElementById("behaviour3Div").innerHTML = "<label for='behaviour3' id='behaviour3Label'>" + "<%= feedbackQuestions.get(2)%>" + "</label><select class='form-control' name='behaviour3Answer' id='behaviour3Answer' onchange='myFunction3()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("behaviour3Label").innerHTML = "Was " + y + " attentive?*";
                }
            }
        </script>
        <script>
            function myFunction3() {
                var x = document.getElementById("behaviour3Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("behaviour4Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("behaviour4Div").style.visibility= "visible";
                    document.getElementById("behaviour4Div").innerHTML = "<label for='behaviour4' id='behaviour4Label'>" + "<%= feedbackQuestions.get(3)%>" + "</label><select class='form-control' name='behaviour4Answer' id='behaviour4Answer' onchange='myFunction4()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("behaviour4Label").innerHTML = "Was " + y + " concerned?*";
                }
            }
        </script>
        <script>
            function myFunction4() {
                var x = document.getElementById("behaviour4Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("behaviour5Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("behaviour5Div").style.visibility= "visible";
                    document.getElementById("behaviour5Div").innerHTML = "<label for='behaviour5' id='behaviour5Label'>" + "<%= feedbackQuestions.get(4)%>" + "</label><select class='form-control' name='behaviour5Answer' id='behaviour5Answer' onchange='myFunction5()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("behaviour5Label").innerHTML = "Was " + y + " telling things properly?*";
                }
            }
        </script>
        <script>
            function myFunction5() {
                var x = document.getElementById("behaviour5Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("behaviour6Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("behaviour6Div").style.visibility= "visible";
                    document.getElementById("behaviour6Div").innerHTML = "<label for='behaviour6' id='behaviour6Label'>" + "<%= feedbackQuestions.get(5)%>" + "</label><select class='form-control' name='behaviour6Answer' id='behaviour6Answer' onchange='myFunction6()' required><option value=''>Select</option>" + "<%for(int i=0; i<behaviourArray.size(); i++){%>" + "<option value='" + "<%= behaviourArray.get(i) %>" + "'" + ">" + "<%= behaviourArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("behaviour6Label").innerHTML = "Did " + y + " give you ample time?*";
                }
            }
        </script>
        <script>
            function myFunction6() {
                var x = document.getElementById("behaviour6Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction1Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction1Div").style.visibility= "visible";
                    document.getElementById("interaction1Div").innerHTML = "<label for='interaction1' id='interaction1Label'>" + "<%= feedbackQuestions.get(6)%>" + "</label><select class='form-control' name='interaction1Answer' id='interaction1Answer' onchange='myFunction7()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction1Label").innerHTML = "Did " + y + " understand and ask questions regarding your health history?*";
                }
            }
        </script>
        <script>
            function myFunction7() {
                var x = document.getElementById("interaction1Answer").value;
                if(x === "")
                {
                    document.getElementById("interaction2Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction2Div").style.visibility= "visible";
                    document.getElementById("interaction2Div").innerHTML = "<label for='interaction2' id='interaction2Label'>" + "<%= feedbackQuestions.get(7)%>" + "</label><select class='form-control' name='interaction2Answer' id='interaction2Answer' onchange='myFunction8()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction2Label").innerHTML = "Did " + y + " discuss treatment option with you?*";
                }
            }
        </script>
        <script>
            function myFunction8() {
                var x = document.getElementById("interaction2Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction3Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction3Div").style.visibility= "visible";
                    document.getElementById("interaction3Div").innerHTML = "<label for='interaction3' id='interaction3Label'>" + "<%= feedbackQuestions.get(8)%>" + "</label><select class='form-control' name='interaction3Answer' id='interaction3Answer' onchange='myFunction9()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction3Label").innerHTML = "Did " + y + " explain drugs, other treatments, their expected effects and side effects?*";
                }
            }
        </script>
        <script>
            function myFunction9() {
                var x = document.getElementById("interaction3Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction4Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction4Div").style.visibility= "visible";
                    document.getElementById("interaction4Div").innerHTML = "<label for='interaction4' id='interaction4Label'>" + "<%= feedbackQuestions.get(9)%>" + "</label><select class='form-control' name='interaction4Answer' id='interaction4Answer' onchange='myFunction10()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction4Label").innerHTML = "Did " + y + " answer questions to your satisfaction?*";
                }
            }
        </script>
        <script>
            function myFunction10() {
                var x = document.getElementById("interaction4Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction5Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction5Div").style.visibility= "visible";
                    document.getElementById("interaction5Div").innerHTML = "<label for='interaction5' id='interaction5Label'>" + "<%= feedbackQuestions.get(10)%>" + "</label><select class='form-control' name='interaction5Answer' id='interaction5Answer' onchange='myFunction11()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction5Label").innerHTML = "Did " + y + " give you advice on what to do if symptoms persist or worsen?*";
                }
            }
        </script>
        <script>
            function myFunction11() {
                var x = document.getElementById("interaction5Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction6Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction6Div").style.visibility= "visible";
                    document.getElementById("interaction6Div").innerHTML = "<label for='interaction6' id='interaction6Label'>" + "<%= feedbackQuestions.get(11)%>" + "</label><select class='form-control' name='interaction6Answer' id='interaction6Answer' onchange='myFunction12()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction6Label").innerHTML = "Did " + y + " give advice to you on ways to stay healthy?*";
                }
            }
        </script>
        <script>
            function myFunction12() {
                var x = document.getElementById("interaction6Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction7Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction7Div").style.visibility= "visible";
                    document.getElementById("interaction7Div").innerHTML = "<label for='interaction7' id='interaction7Label'>" + "<%= feedbackQuestions.get(12)%>" + "</label><select class='form-control' name='interaction7Answer' id='interaction7Answer' onchange='myFunction13()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction7Label").innerHTML = "Did " + y + " treated you well?*";
                }
            }
        </script>
        <script>
            function myFunction13() {
                var x = document.getElementById("interaction7Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction8Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction8Div").style.visibility= "visible";
                    document.getElementById("interaction8Div").innerHTML = "<label for='interaction8' id='interaction8Label'>" + "<%= feedbackQuestions.get(13)%>" + "</label><select class='form-control' name='interaction8Answer' id='interaction8Answer' onchange='myFunction14()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction8Label").innerHTML = "Would you be happy to see " + y + " again?*";
                }
            }
        </script>
        <script>
            function myFunction14() {
                var x = document.getElementById("interaction8Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("interaction9Div").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("interaction9Div").style.visibility= "visible";
                    document.getElementById("interaction9Div").innerHTML = "<label for='interaction9' id='interaction9Label'>" + "<%= feedbackQuestions.get(14)%>" + "</label><select class='form-control' name='interaction9Answer' id='interaction9Answer' onchange='myFunction15()' required><option value=''>Select</option>" + "<%for(int i=0; i<yesNoArray.size(); i++){%>" + "<option value='" + "<%= yesNoArray.get(i) %>" + "'" + ">" + "<%= yesNoArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("interaction9Label").innerHTML = "Do you think " + y + " is good and will give you the right care?*";
                }
            }
        </script>
        <script>
            function myFunction15() {
                var x = document.getElementById("interaction9Answer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("diagnosisTimeDiv").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("diagnosisTimeDiv").style.visibility= "visible";
                    document.getElementById("diagnosisTimeDiv").innerHTML = "<label for='diagnosisTime' id='diagnosisTimeLabel'>" + "<%= feedbackQuestions.get(15)%>" + "</label><select class='form-control' name='diagnosisTimeAnswer' id='diagnosisTimeAnswer' onchange='myFunction16()' required><option value=''>Select</option>" + "<%for(int i=0; i<diagnosisArray.size(); i++){%>" + "<option value='" + "<%= diagnosisArray.get(i) %>" + "'" + ">" + "<%= diagnosisArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("diagnosisTimeLabel").innerHTML = "How much time did " + y + " take in diagnosis?*";
                }
            }
        </script>
        <script>
            function myFunction16() {
                var x = document.getElementById("diagnosisTimeAnswer").value;
                var y = document.getElementById("doctorName").value;
                if(x === "")
                {
                    document.getElementById("scaleDiv").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("scaleDiv").style.visibility= "visible";
                    document.getElementById("scaleDiv").innerHTML = "<label for='scale' id='scaleLabel'>" + "<%= feedbackQuestions.get(16)%>" + "</label><select class='form-control' name='scaleAnswer' id='scaleAnswer' onchange='myFunction17()' required><option value=''>Select</option>" + "<%for(int i=0; i<scaleArray.size(); i++){%>" + "<option value='" + "<%= scaleArray.get(i) %>" + "'" + ">" + "<%= scaleArray.get(i) %>" + "</option>" + "<%} %>" + "</select>";
                    document.getElementById("scaleLabel").innerHTML = "On the scale of 1-10, (1 being the lowest and 10 being the highest), mention your extent of satisfaction?*";
                }
            }
        </script>
        <script>
            function myFunction17() {
                var x = document.getElementById("scaleAnswer").value;
                if(x === "")
                {
                    document.getElementById("buttonDiv").style.visibility= "hidden";
                }
                else
                {
                    document.getElementById("buttonDiv").style.visibility= "visible";
                    document.getElementById("buttonDiv").innerHTML = "<button name='submit' type='submit' class='btn btn-lg btn-primary' id='submit'>Submit</button>";
                }
            }
        </script>
    </body>
</html>
