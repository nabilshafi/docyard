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
    <body onload="myFunction()">
        <% 
            Patient patient = (Patient)request.getSession().getAttribute("patient");
            String doctorName = (String)request.getSession().getAttribute("doctorName");
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> feedbackQuestions = util.retrieveFeedbackQuestions(filename);

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
                                Feedback for "<%= doctorName%>"
                            </h1>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="feedback2success" id="feedbackfrm" role="form">
                            <div class="col-sm-4">
                                <div class="search-group">
                                    <div class="search-control">
                                        <label for="behaviour1" id="behaviour1Label">
                                            <%= feedbackQuestions.get(0)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour1Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="behaviour2" id="behaviour2Label">
                                            <%= feedbackQuestions.get(1)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour2Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="behaviour3" id="behaviour3Label">
                                            <%= feedbackQuestions.get(2)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour3Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="behaviour4" id="behaviour4Label">
                                            <%= feedbackQuestions.get(3)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour4Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="behaviour5" id="behaviour5Label">
                                            <%= feedbackQuestions.get(4)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour5Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="behaviour6" id="behaviour6Label">
                                            <%= feedbackQuestions.get(5)%>
                                        </label><br>
                                        <%for(int i=0; i<behaviourArray.size(); i++){%>
                                            <input type="radio" name="behaviour6Answer" value="<%= behaviourArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= behaviourArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction1" id="interaction1Label">
                                            <%= feedbackQuestions.get(6)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction1Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction2" id="interaction2Label">
                                            <%= feedbackQuestions.get(7)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction2Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction3" id="interaction3Label">
                                            <%= feedbackQuestions.get(8)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction3Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction4" id="interaction4Label">
                                            <%= feedbackQuestions.get(9)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction4Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction5" id="interaction5Label">
                                            <%= feedbackQuestions.get(10)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction5Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction6" id="interaction6Label">
                                            <%= feedbackQuestions.get(11)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction6Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction7" id="interaction7Label">
                                            <%= feedbackQuestions.get(12)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction7Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction8" id="interaction8Label">
                                            <%= feedbackQuestions.get(13)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction8Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="interaction9" id="interaction9Label">
                                            <%= feedbackQuestions.get(14)%>
                                        </label><br>
                                        <%for(int i=0; i<yesNoArray.size(); i++){%>
                                            <input type="radio" name="interaction9Answer" value="<%= yesNoArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= yesNoArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="diagnosisTime" id="diagnosisTimeLabel">
                                            <%= feedbackQuestions.get(15)%>
                                        </label><br>
                                        <%for(int i=0; i<diagnosisArray.size(); i++){%>
                                            <input type="radio" name="diagnosisTimeAnswer" value="<%= diagnosisArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= diagnosisArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <label for="scale" id="scaleLabel">
                                            <%= feedbackQuestions.get(16)%>
                                        </label><br>
                                        <%for(int i=0; i<scaleArray.size(); i++){%>
                                            <input type="radio" name="scaleAnswer" value="<%= scaleArray.get(i) %>" onclick="progressBarUpdate()" required>
                                            <%= scaleArray.get(i) %>
                                        <%} %> 
                                    </div>
                                    <div class="search-control">
                                        <button name="submit" type="submit" class="btn btn-lg btn-primary" id="submit">
                                            Submit
                                        </button>
                                        <input id="back" class="btn btn-lg btn-primary" type="button" value="Back" onClick="location.href='feedback'" />
                                        <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
                                    </div>
                                    <progress id="progressBar" value="0" max="17"></progress>
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
//                var x = document.getElementById("doctorName").value;
                var x = "<%= doctorName%>";
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
        <script>
            function progressBarUpdate() {
                var x = document.getElementById("progressBar").value;
                document.getElementById("progressBar").value = x + 1;
            }
        </script>
    </body>
</html>
