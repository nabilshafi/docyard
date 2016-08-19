<%@page import="com.fyp.swdrs.bo.Admin"%>
<%@page import="com.fyp.swdrs.bo.Doctor"%>
<%@page import="com.fyp.swdrs.bo.Patient"%>
<%@page import="com.fyp.swdrs.controller.Controller"%>
<%@page import="com.fyp.swdrs.utility.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            SWDRS - Home
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
                //String filename = application.getRealPath("/");
                //Controller controller = new Controller();
                //Object[] returnObj = null;
            String temp = "";
            String user = "Invalid Username &/or Password";
            Object[] params = new Object[2];
            params[0] = request.getParameter("email");
            temp = request.getParameter("newPassword");
            if(temp.equals(request.getParameter("repeatPassword")))
            {
                params[1] = temp;
                /*
                returnObj = controller.processRequest(Constants.changePasswordAction, params, filename);
                if(returnObj != null)
                {
                    if(((String)returnObj[1]).equals("admin"))
                    {// Admin Login Success
                        Admin admin = (Admin)returnObj[0];
                        user = "SWDRS - Welcome " + admin.getName() + ", " + admin.getEmail() + ", " + admin.getUserCategory();
                    }
                    else if(((String)returnObj[1]).equals("doctor"))
                    {// Doctor Login Success
                        Doctor doctor = (Doctor)returnObj[0];
                        user = "SWDRS - Welcome " + doctor.getName() + ", " + doctor.getEmail() + ", " + doctor.getUserCategory();
                    }
                    else if(((String)returnObj[1]).equals("patient"))
                    {// Patient Login Success
                        Patient patient = (Patient)returnObj[0];
                        user = "SWDRS - Welcome " + patient.getName() + ", " + patient.getEmail() + ", " + patient.getUserCategory();
                    }
                    else 
                    {
                        user = "ERROR: User Does Not Exist.";
                    }
                }*/
            }
            else
            {
                user = "ERROR: New Password does not match to Repeat Password";
            }
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
                    <a href="#">
                        <b>
                            <i>
                                <h1>
                                    <%=user%>
                                </h1>
                                <h3>
                                    <%=(String)params[0]%>
                                </h3>
                                <h3>
                                    <%=(String)params[1]%>
                                </h3>
                            </i>
                        </b>
                    </a> 
                </div>
                <nav class="navbar navbar-inverse" role="navigation">
                    <div id="main-nav" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav" id="mainNav">
                            <li class="active" id="firstLink">
                                <a href="index.jsp" class="scroll-link">
                                    Home
                                </a>
                            </li>
                            <li>
                                <%
                                    String url = "index.jsp";
                                    String text = "Logout";
                                    if(user.equals("Invalid Username &/or Password"))
                                    {
                                        text = " ";
                                    }
                                %>
                                <a href="<%=url%>" class="scroll-link">
                                    <%=text%>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <section id="home">
            <div class="banner-container"> 
                <img src="images/banner1.jpg" alt="banner">
                <div class="container banner-content">
                    <div class="hero-text animated fadeInDownBig">
                        <!-- <a href="#" class="arrow-link"> <i class="fa fa-arrow-circle-down fa-2x"> </i> </a> -->
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
    </body>
</html>
