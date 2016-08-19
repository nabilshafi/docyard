<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<title>
            SWDRS - Sign Up
        </title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/isotope.css" media="screen">
	<link rel="stylesheet" href="js/fancybox/jquery.fancybox.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel="stylesheet" href="css/style.css">
	<link href="css/animate.css" rel="stylesheet" media="screen">
	<link href="js/owl-carousel/owl.carousel.css" rel="stylesheet">
	<link rel="stylesheet" href="css/styles.css">
	<link href="font/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
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
                                <a href="login" class="scroll-link" title="Login">
                                    Login
                                </a>
                            </li>
                            <li>
                                <a href="index" class="scroll-link" title="Cancel">
                                    Cancel
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <section id="home">
            <div class="banner-container"> 
                <img src="images/banner1.jpg" alt="banner" />
            </div>
        </section>
        <section id="login">
            <div class="logmod">
                <div class="login-card">
                    <h2>
                        Sign Up
                    </h2>
                    <br>
                    <form name="Sign Up Action Form" action="redirect" method="post" value=""><!--onsubmit="return checkForm(this);">-->
                        <label>
                            Name: * 
                        </label>
                        <input maxlength="50" size="50" type="text" name="name" value="" placeholder="Name" title="Enter Name" required>
                        <label>
                            Email: * 
                        </label>
                        <input maxlength="25" size="50" type="email" name="email" value="" placeholder="Email" title="Enter Email" required>
                        <label>
                            Password: * 
                        </label>
                        <input maxlength="15" size="50" type="password" name="password" value="" placeholder="Password" title="Enter Password" required>
                        <label>
                            Confirm Password: * 
                        </label>
                        <input maxlength="15" size="50" type="password" name="repeatPassword" value="" placeholder="Password" title="Re-Enter Password" required>
                        <div class="login-help">
                            <input type="radio" name="userCategory" value="DOCTOR" title="Signup as Doctor" required>
                            <label>
                                Doctor
                            </label>
                            <input type="radio" name="userCategory" value="PATIENT" title="Signup as Patient" required>
                            <label>
                                Patient
                            </label>
                        </div>
                        <input type="submit" name="signup" class="login login-submit" value="Signup" />
                    </form>
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
        <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'> </script>
        <script src="js/index.js"> </script>
	<script type="text/javascript">
            function checkForm(form)
            {
                re = /^\w+$/;
                if(form.password.value != "" && form.password.value == form.repeatPassword.value) {
                    if(form.password.value.length < 8) {
                        alert("Please enter atleast eight characters in your password!");
                        form.password.focus();
                        return false;
                    }
                    if(form.password.value == form.name.value) {
                        alert("Please enter a unique password different from your name!");
                        form.password.focus();
                        return false;
                    }
                    if(form.password.value == form.email.value) {
                       alert("Please enter a unique password different from your email!");
                        form.password.focus();
                        return false;
                    }
                    re = /[0-9]/;
                    if(!re.test(form.password.value)) {
                        alert("Please enter a unique password containing atlease one number!");
                        form.password.focus();
                        return false;
                    }
                    re = /[a-z]/;
                    if(!re.test(form.password.value)) {
                        alert("Please enter a unique password containing atlease one lowercase letter!");
                        form.password.focus();
                        return false;
                    }
                    re = /[A-Z]/;
                    if(!re.test(form.password.value)) {
                        alert("Please enter a unique password containing atlease one uppercase letter!");
                        form.password.focus();
                        return false;
                    }
                } 
                else {
                    alert("Please confirm the password correctly!");
                    form.password.focus();
                    return false;
                }
                return true;
            }
	</script>
    </body>
</html>
