package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.fyp.swdrs.utility.Utility;
import java.util.ArrayList;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.utility.Constants;
import com.fyp.swdrs.controller.Controller;

public final class doctorProfileCreate3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en-gb\" class=\"no-js\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\t<title>\n");
      out.write("            SWDRS - Create Profile\n");
      out.write("        </title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/isotope.css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"js/fancybox/jquery.fancybox.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("\t<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\t<link href=\"css/animate.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("\t<link href=\"js/owl-carousel/owl.carousel.css\" rel=\"stylesheet\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("\t<link href=\"font/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            String filename = application.getRealPath("/");
            Utility util = new Utility();
            ArrayList<String> cityArray = util.populateList(filename + "Cities_Pakistan");
            ArrayList<String> countryArray = util.populateList(filename + "Countries_World");
            ArrayList<String> areaArray = util.populateList(filename + "Areas_Names");
            ArrayList<String> hospitalArray = util.populateList(filename + "Hospitals_Names");
            ArrayList<String> daysArray = util.populateList(filename + "Days_Names");
        
      out.write("\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" id=\"nav-toggle\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#main-nav\">\n");
      out.write("                        <span class=\"sr-only\">\n");
      out.write("                            Toggle navigation\n");
      out.write("                        </span> \n");
      out.write("                        <span class=\"icon-bar\"> </span> \n");
      out.write("                        <span class=\"icon-bar\"> </span> \n");
      out.write("                        <span class=\"icon-bar\"> </span> \n");
      out.write("                    </button>\n");
      out.write("                    <a>\n");
      out.write("                        <b>\n");
      out.write("                            <i>\n");
      out.write("                                <h1>\n");
      out.write("                                    SWDRS\n");
      out.write("                                </h1>\n");
      out.write("                            </i>\n");
      out.write("                        </b>\n");
      out.write("                    </a> \n");
      out.write("                </div>\n");
      out.write("                <nav class=\"navbar navbar-inverse\" role=\"navigation\">\n");
      out.write("                    <div id=\"main-nav\" class=\"collapse navbar-collapse\">\n");
      out.write("                        <ul class=\"nav navbar-nav\" id=\"mainNav\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"home\" class=\"scroll-link\" title=\"Home\">\n");
      out.write("                                    Home\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"active\" id=\"firstLink\">\n");
      out.write("                                <a href=\"\" class=\"scroll-link\" title=\"Profile\">\n");
      out.write("                                    Profile\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"index\" class=\"scroll-link\" title=\"Logout\">\n");
      out.write("                                    Logout\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <section id=\"hospitalInfo\" class=\"contact-parlex\">\n");
      out.write("            <div class=\"parlex-back\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row mrgn30\">\n");
      out.write("                        <div class=\"heading text-center\"> \n");
      out.write("                            <h1>\n");
      out.write("                                Doctor - Create Profile - Hospital Information\n");
      out.write("                            </h1>\n");
      out.write("                        </div>\n");
      out.write("                        <form method=\"post\" action=\"profilecreated\" id=\"doctorProfileHospitalInfoForrm\" role=\"form\">\n");
      out.write("                            <div id=\"doctorProfileHospitalInfo\">\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"hospital\">\n");
      out.write("                                            Which hospital/clinic do you visit? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"hospital\" id=\"hospital\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<hospitalArray.size(); i++){
      out.write("<option value=\"");
      out.print( hospitalArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( hospitalArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select> \n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"day\">\n");
      out.write("                                            At what day? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"day\" id=\"day\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<daysArray.size(); i++){
      out.write("<option value=\"");
      out.print( daysArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( daysArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select> \n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"visitingHours\">\n");
      out.write("                                            What are your visiting hours? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <input type=\"time\" class=\"form-control\" name=\"visitingHours\" id=\"visitingHours\" placeholder=\"Visiting Hours?\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"feeStructure\">\n");
      out.write("                                            What is your fee structure? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" name=\"feeStructure\" id=\"feeStructure\" placeholder=\"Fee Structure?\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\" id=\"citiesDiv\">\n");
      out.write("                                        <label for=\"city\">\n");
      out.write("                                            What is your City? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"city\" id=\"city\" onchange=\"myFunction1()\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<cityArray.size(); i++){
      out.write("<option value=\"");
      out.print( cityArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( cityArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\" id=\"countriesDiv\">\n");
      out.write("                                        <label for=\"country\">\n");
      out.write("                                            What is your country? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"country\" onchange=\"myFunction2()\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<countryArray.size(); i++){
      out.write("<option value=\"");
      out.print( countryArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( countryArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"area\">\n");
      out.write("                                            What is your area? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"area\" id=\"area\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<areaArray.size(); i++){
      out.write("<option value=\"");
      out.print( areaArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( areaArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <!--<input id=\"back\" class=\"btn btn-lg btn-primary\" type=\"button\" value=\"Back\" onClick=\"location.href='profile2'\" />-->\n");
      out.write("                                        <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"submit\">\n");
      out.write("                                            Save\n");
      out.write("                                        </button>\n");
      out.write("                                        <button name=\"addMore\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"addMore\" formmethod=\"post\" formaction=\"profile3AddMore\">\n");
      out.write("                                            Add Hospital\n");
      out.write("                                        </button> \n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <section class=\"copyright\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12 text-center\"> \n");
      out.write("                        Copyright 2015 | All Rights Reserved By SWDRS. \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <script src=\"js/modernizr-latest.js\"> </script> \n");
      out.write("        <script src=\"js/jquery-1.8.2.min.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/jquery.isotope.min.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/fancybox/jquery.fancybox.pack.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/jquery.nav.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/jquery.fittext.js\"> </script> \n");
      out.write("        <script src=\"js/waypoints.js\"> </script> \n");
      out.write("        <script src=\"js/custom.js\" type=\"text/javascript\"> </script> \n");
      out.write("        <script src=\"js/owl-carousel/owl.carousel.js\"> </script>\n");
      out.write("        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'> </script>\n");
      out.write("        <script src=\"js/index.js\"> </script>\n");
      out.write("        <script>\n");
      out.write("            function myFunction1() \n");
      out.write("            {\n");
      out.write("                document.getElementById(\"countriesDiv\").innerHTML = \"<label for='country'>What is your country? *</label><select class='form-control' name='country' id='country' required><option value=''>Select</option>\" + \"");
for(int i=0; i<countryArray.size(); i++){
      out.write("\" + \"<option value='\" + \"");
      out.print( countryArray.get(i) );
      out.write("\" + \"'\" + \"");
      out.print( (countryArray.get(i).equals("Pakistan"))?"selected":"" );
      out.write("\" + \">\" + \"");
      out.print( countryArray.get(i) );
      out.write("\" + \"</option>\" + \"");
} 
      out.write("\" + \"</select>\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function myFunction2() \n");
      out.write("            {\n");
      out.write("                document.getElementById(\"citiesDiv\").innerHTML = \"<label for='city'>What is your city? *</label><select class='form-control' name='city' id='city' required><option value=''>Select</option>\" + \"");
for(int i=0; i<cityArray.size(); i++){
      out.write("\" + \"<option value='\" + \"");
      out.print( cityArray.get(i) );
      out.write("\" + \"'\" + \"");
      out.print( (cityArray.get(i).equals("Karachi"))?"selected":"" );
      out.write("\" + \">\" + \"");
      out.print( cityArray.get(i) );
      out.write("\" + \"</option>\" + \"");
} 
      out.write("\" + \"</select>\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
