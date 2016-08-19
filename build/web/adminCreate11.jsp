<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-gb" class="no-js">
    <head>
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>
            SWDRS - Feedback Question CRUD
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
//            String filename = application.getRealPath("/");
            ArrayList<String> list = (ArrayList<String>)request.getSession().getAttribute("feedbackQuestionList");
            String idForBtn1 = "";
            String idForBtn2 = "";
            String idForBtn3 = "";
            String idForBtn4 = "";
            String idForTd = "";
            String id = "";
            String str = "";
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
                                <div class="dropdown">
                                    <button onmouseover="myFunction()" class="dropbtn scroll-link" title="CRUD">
                                        CRUD
                                    </button>
                                    <div id="myDropdown" class="dropdown-content">
                                        <a class="scroll-link" title="Gender">
                                            Gender
                                        </a>
                                        <a href="create2" class="scroll-link" title="Income Group">
                                            Income Group
                                        </a>
                                        <a href="create3" class="scroll-link" title="Degree">
                                            Degree
                                        </a>
                                        <a href="create4" class="scroll-link" title="Specialties">
                                            Specialties
                                        </a>
                                        <a href="create5" class="scroll-link" title="Hospital">
                                            Hospital
                                        </a>
                                        <a href="create6" class="scroll-link" title="Day">
                                            Days
                                        </a>
                                        <a href="create7" class="scroll-link" title="City">
                                            City
                                        </a>
                                        <a href="create8" class="scroll-link" title="Area">
                                            Area
                                        </a>
                                        <a href="create9" class="scroll-link" title="Symptom">
                                            Symptom
                                        </a>
                                        <a href="create10" class="scroll-link" title="Disease">
                                            Disease
                                        </a>
                                        <a class="scroll-link" title="Feedback Question">
                                            Feedback Question
                                        </a>
                                        <a href="create12" class="scroll-link" title="Address">
                                            Address
                                        </a>
                                    </div>
                                </div>
                            </li>
                           <li>
                                <a href="index" class="scroll-link" title="Logout">
                                    Logout
                                    <!--<img src="logout1.gif">-->
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
                                Feedback Question CRUD
                            </h1>
                            <br>
                        </div>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="create11Success" id="createFeedbackQuestionForm1" role="form">
                            <div class="col-sm-4">
                                <div class="search-group">
                                    <label for="feedbackQuestionTxt">
                                        Feedback Question:
                                    </label>
                                    <input type="text" class="search-control" name="feedbackQuestionTxt" id="feedbackQuestionTxt" placeholder="Feedback Question" title="Feedback Question" required>
                                    <button name="feedbackQuestionTxtBtn" type="submit" class="btn btn-lg btn-primary" id="feedbackQuestionTxtBtn">
                                        Create
                                    </button>
                                    <input id="cancel" class="btn btn-lg btn-primary" type="button" value="Cancel" onClick="location.href='home'" />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="row mrgn30">
                        <form method="post" action="update11Success" id="createFeedbackQuestionForm2" role="form">
                            <div class="col-sm-4">
                                <div class="search-group">
                                    <table id="myTable" width="1000">
                                        <%for(int i=0; i<list.size(); i++) { id = "feedbackQuestionTxt" + Integer.toString(i); idForTd = "td" + Integer.toString(i); idForBtn1 = "td" + Integer.toString(i) + "Btn1"; idForBtn2 = "td" + Integer.toString(i) + "Btn2"; idForBtn3 = "td" + Integer.toString(i) + "Btn3"; idForBtn4 = "td" + Integer.toString(i) + "Btn4";%>
                                        <tr>
                                            <td>
                                                <label for="feedbackQuestionTxt">
                                                    Feedback Question: 
                                                </label>
                                            </td>
                                            <td id="<%= idForTd%>">
                                                <input type="text" class="form-control" name="<%= id%>"  id="<%= id%>" placeholder="Feedback Question" title="Feedback Question" value="<%= list.get(i)%>" required readonly >
                                            </td> 
                                            <td id="<%= idForBtn1%>">
                                                <p name="updateBtn" class="btn btn-lg btn-primary" id="updateBtn" value="Update" onclick="updateBtn('<%= idForTd%>', '<%= id%>', '<%= Integer.toString(i)%>', '<%= list.get(i)%>')" >
                                                    Update
                                                </p>
                                            </td>
                                            <%--<td id="<%= idForBtn2%>">
                                                <p name="saveBtn" class="btn btn-lg btn-primary" id="saveBtn" value="Save" onclick="saveBtn('<%= idForTd%>', '<%= id%>', '<%= Integer.toString(i)%>', '<%= list.get(i)%>')" >
                                                    Save
                                                </p>
                                            </td>--%>
                                            <td id="<%= idForBtn4%>">
                                                <p name="deleteBtn" class="btn btn-lg btn-primary" id="deleteBtn" value="Delete" onclick="deleteBtn('<%= idForTd%>', '<%= id%>', '<%= Integer.toString(i)%>', '<%= list.get(i)%>')" >
                                                    Delete
                                                </p>
                                            </td>
                                            <td id="<%= idForBtn3%>">
                                                <p name="resetBtn" class="btn btn-lg btn-primary" id="resetBtn" value="Reset" onclick="resetBtn('<%= idForTd%>', '<%= id%>', '<%= Integer.toString(i)%>', '<%= list.get(i)%>')" >
                                                    Reset
                                                </p>
                                            </td>
                                        </tr>
                                        <% }%>
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
<!--        <script>
            document.getElementById("tableUpdateId").style.visibility= "hidden";
        </script>-->
        <script type = "text/javascript">
            function updateBtn(id1, id2, id3, id4){
                document.getElementById(id2).readOnly = false;
//                alert(id1 + ", " + id2 + ", " + id3 + ", " + id4);
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
//                var s = document.getElementById(id2).value ;
//                alert(id2 + ": " + s);
            }
        </script>
        <script type = "text/javascript">
            function deleteBtn(id1, id2, id3, id4){
                document.getElementById(id2).value = "";
                document.getElementById(id2).readOnly = true;
            }
        </script>
        <script>
        function addMore() {
            var x = document.getElementById("myTable").rows.length;
            var table = document.getElementById("myTable");
            var row = table.insertRow(x);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            cell1.innerHTML = "<label for='feedbackQuestionTxt'>Feedback Question: </label>";
            cell2.innerHTML = "<input type='text' class='form-control' name='feedbackQuestionTxt' id='feedbackQuestionTxt' placeholder='Feedback Question' title='Feedback Question' required >";
            cell2.id = "td" + (x + 1);
            cell3.innerHTML = "<p name='updateBtn' class='btn btn-lg btn-primary' id='updateBtn' value='Update' onclick='updateBtn('td" + (x + 1) + "')'>Update</p>";
            cell3.id = "td" + (x + 1) + "Btn1";
            //cell4.innerHTML = "<p name='resetBtn' class='btn btn-lg btn-primary' id='resetBtn' value='Reset' onclick='resetBtn('td" + (x + 1) + "')'>Reset</p>";
            //cell4.id = "td" + (x + 1) + "Btn2";
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
<!--	<script type="text/javascript">
            function checkForm(form)
            {
                re = /^\+([9]{1})+([2]{1})+([3]{1})+([0-9]{9})$/;
                if(!re.test(form.feedbackQuestionTxt.value)) 
                {
                    alert("Please enter a valid feedbackQuestion!");
                    form.contact.focus();
                    return false;
                }
                return true;
            }
	</script>-->
    </body>
</html>
