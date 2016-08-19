<%@page import="java.util.ArrayList"%>
<%@page import="com.fyp.swdrs.utility.Utility"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
                                    <select class="form-control" name="doctorName" id="doctorName" onchange="myFunction()" required>
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
                                    <label for="behaviour1" id="behaviour1Label">
                                        <!--Was the doctor warm and friendly?*-->
                                        <%= feedbackQuestions.get(0)%>
                                    </label>
                                    <select class="form-control" name="behaviour1Answer" id="behaviour1Answer" onchange="myFunction1()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="behaviour2Div">
                                    <label for="behaviour2" id="behaviour2Label">
                                        <!--Was the doctor respectful?*-->
                                        <%= feedbackQuestions.get(1)%>
                                    </label>
                                    <select class="form-control" name="behaviour2Answer" id="behaviour2Answer" onchange="myFunction2()" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="behaviour3Div">
                                    <label for="behaviour3" id="behaviour3Label">
                                        <!--Was the doctor attentive?*-->
                                        <%= feedbackQuestions.get(2)%>
                                    </label>
                                    <select class="form-control" name="behaviour3Answer" id="behaviour3Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="behaviour4Div">
                                    <label for="behaviour4" id="behaviour4Label">
                                        <!--Was the doctor concerned?*-->
                                        <%= feedbackQuestions.get(3)%>
                                    </label>
                                    <select class="form-control" name="behaviour4Answer" id="behaviour4Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="behaviour5Div">
                                    <label for="behaviour5" id="behaviour5Label">
                                        <!--Was the doctor telling things properly?*-->
                                        <%= feedbackQuestions.get(4)%>
                                    </label>
                                    <select class="form-control" name="behaviour5Answer" id="behaviour5Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group" id="behaviour6Div">
                                    <label for="behaviour6" id="behaviour6Label">
                                        <!--Did the doctor give you ample time?*-->
                                        <%= feedbackQuestions.get(5)%>
                                    </label>
                                    <select class="form-control" name="behaviour6Answer" id="behaviour6Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%><option value="<%= behaviourArray.get(i) %>"><%= behaviourArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <!--</div>
                            <div class="col-sm-4">-->
                                <div class="form-group" id="interaction1Div">
                                    <label for="interaction1" id="interaction1Label">
                                        <!--Did the doctor understand and ask questions regarding your health history?*-->
                                        <%= feedbackQuestions.get(6)%>
                                    </label>
                                    <select class="form-control" name="interaction1Answer" id="interaction1Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction2Div">
                                    <label for="interaction2" id="interaction2Label">
                                        <!--Did the doctor discuss treatment option with you?*-->
                                        <%= feedbackQuestions.get(7)%>
                                    </label>
                                    <select class="form-control" name="interaction2Answer" id="interaction2Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction3Div">
                                    <label for="interaction3" id="interaction3Label">
                                        <!--Did the doctor explain drugs, other treatments, their expected effects and side effects?*-->
                                        <%= feedbackQuestions.get(8)%>
                                    </label>
                                    <select class="form-control" name="interaction3Answer" id="interaction3Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction4Div">
                                    <label for="interaction4" id="interaction4Label">
                                        <!--Did the doctor answer questions to your satisfaction?*-->
                                        <%= feedbackQuestions.get(9)%>
                                    </label>
                                    <select class="form-control" name="interaction4Answer" id="interaction4Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction5Div">
                                    <label for="interaction5" id="interaction5Label">
                                        <!--Did the doctor give you advice on what to do if symptoms persist or worsen?*-->
                                        <%= feedbackQuestions.get(10)%>
                                    </label>
                                    <select class="form-control" name="interaction5Answer" id="interaction5Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group" id="interaction6Div">
                                    <label for="interaction6" id="interaction6Label">
                                        <!--Did your doctor give advice to you on ways to stay healthy?*-->
                                        <%= feedbackQuestions.get(11)%>
                                    </label>
                                    <select class="form-control" name="interaction6Answer" id="interaction6Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction7Div">
                                    <label for="interaction7" id="interaction7Label">
                                        <!--Did your doctor treated you well?*-->
                                        <%= feedbackQuestions.get(12)%>
                                    </label>
                                    <select class="form-control" name="interaction7Answer" id="interaction7Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction8Div">
                                    <label for="interaction8" id="interaction8Label">
                                        <!--Would you be happy to see the doctor again?*-->
                                        <%= feedbackQuestions.get(13)%>
                                    </label>
                                    <select class="form-control" name="interaction8Answer" id="interaction8Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="interaction9Div">
                                    <label for="interaction9" id="interaction9Label">
                                        <!--Do you think the doctor is good and will give you the right care?*-->
                                        <%= feedbackQuestions.get(14)%>
                                    </label>
                                    <select class="form-control" name="interaction9Answer" id="interaction9Answer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%><option value="<%= yesNoArray.get(i) %>"><%= yesNoArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <!--</div>
                            <div class="col-sm-4">-->
                                <div class="form-group" id="diagnosisTimeDiv">
                                    <label for="diagnosisTime" id="diagnosisTimeLabel">
                                        <!--How much time did the doctor take in diagnosis?*-->
                                        <%= feedbackQuestions.get(15)%>
                                    </label>
                                    <select class="form-control" name="diagnosisTimeAnswer" id="diagnosisTimeAnswer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<diagnosisArray.size(); i++){%><option value="<%= diagnosisArray.get(i) %>"><%= diagnosisArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <div class="form-group" id="scaleDiv">
                                    <label for="scale" id="scaleLabel">
                                        <!--On the scale of 1-10, (1 being the lowest and 10 being the highest), mention your extent of satisfaction?*-->
                                        <%= feedbackQuestions.get(16)%>
                                    </label>
                                    <select class="form-control" name="scaleAnswer" id="scaleAnswer" required>
                                        <option value="">Select</option>
                                        <%for(int i=0; i<scaleArray.size(); i++){%><option value="<%= scaleArray.get(i) %>"><%= scaleArray.get(i) %></option><%} %>
                                    </select>
                                </div>
                                <!--<div class="form-group">
                                    <label for="feedback">
                                        Feedback: *
                                    </label>
                                    <textarea name="feedbackTextArea" class="form-control" id="feedbackTextArea" cols="5" rows="5" placeholder="Feedback: " title="Please enter your feedback" required></textarea>
                                </div>-->
                                <div class="form-group">
                                    <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                        Submit
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
        <script>
            function myFunction() 
            {
                var x = document.getElementById("doctorName").value;
                x = "Dr. " + x;
                if(x === "") {
                    x = "the doctor";
                }
                document.getElementById("behaviour1Label").innerHTML = "Was " + x + " warm and friendly?*";
                document.getElementById("behaviour2Label").innerHTML = "Was " + x + " respectful?*";
                document.getElementById("behaviour3Label").innerHTML = "Was " + x + " attentive?*";
                document.getElementById("behaviour4Label").innerHTML = "Was " + x + " concerned?*";
                document.getElementById("behaviour5Label").innerHTML = "Was " + x + " telling things properly?*";
                document.getElementById("behaviour6Label").innerHTML = "Did " + x + " give you ample time?*";
                document.getElementById("interaction1Label").innerHTML = "Did " + x + " understand and ask questions regarding your health history?*";
                document.getElementById("interaction2Label").innerHTML = "Did " + x + " discuss treatment option with you?*";
                document.getElementById("interaction3Label").innerHTML = "Did " + x + " explain drugs, other treatments, their expected effects and side effects?*";
                document.getElementById("interaction4Label").innerHTML = "Did " + x + " answer questions to your satisfaction?*";
                document.getElementById("interaction5Label").innerHTML = "Did " + x + " give you advice on what to do if symptoms persist or worsen?*";
                document.getElementById("interaction6Label").innerHTML = "Did " + x + " give advice to you on ways to stay healthy?*";
                document.getElementById("interaction7Label").innerHTML = "Did " + x + " treated you well?*";
                document.getElementById("interaction8Label").innerHTML = "Would you be happy to see " + x + " again?*";
                document.getElementById("interaction9Label").innerHTML = "Do you think " + x + " is good and will give you the right care?*";
                document.getElementById("diagnosisTimeLabel").innerHTML = "How much time did " + x + " take in diagnosis?*";
                document.getElementById("scaleLabel").innerHTML = "On the scale of 1-10, (1 being the lowest and 10 being the highest), mention your extent of satisfaction?*";
            }
        </script>
    </body>
</html>
