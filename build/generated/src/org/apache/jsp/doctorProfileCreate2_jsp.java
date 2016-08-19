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

public final class doctorProfileCreate2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
            ArrayList<String> degreeArray = util.populateList(filename + "Doctors_Types");
            ArrayList<String> specialistArray = util.populateList(filename + "Specialist_Choice");
            ArrayList<String> specialtiesArray = util.populateList(filename + "Specialist_Types");
        
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
      out.write("                                <a href=\"index\" class=\"scroll-link\" title=\"Lofout\">\n");
      out.write("                                    Logout\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <section id=\"doctorDegreeInfo\" class=\"contact-parlex\">\n");
      out.write("            <div class=\"parlex-back\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row mrgn30\">\n");
      out.write("                        <div class=\"heading text-center\"> \n");
      out.write("                            <h1>\n");
      out.write("                                Doctor - Medical Degree Information\n");
      out.write("                            </h1>\n");
      out.write("                        </div>\n");
      out.write("                        <form method=\"post\" action=\"profile3\" id=\"doctorProfileDegreeInfoForrm\" role=\"form\">\n");
      out.write("                            <div id=\"doctorProfileDegreeInfo\">\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"degree\">\n");
      out.write("                                            Which medical degree do you hold? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"degree\" id=\"degree\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<degreeArray.size(); i++){
      out.write("<option value=\"");
      out.print( degreeArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( degreeArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <!--<input id=\"back\" class=\"btn btn-lg btn-primary\" type=\"button\" value=\"Back\" onClick=\"location.href='profile'\">-->\n");
      out.write("                                        <button name=\"submit\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"submit\">\n");
      out.write("                                            Next\n");
      out.write("                                        </button>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                        <br>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label for=\"specialist\">\n");
      out.write("                                            Are you a specialist? *\n");
      out.write("                                        </label>\n");
      out.write("                                        <select class=\"form-control\" name=\"specialist\" id=\"specialist\" onchange=\"myFunction()\" required>\n");
      out.write("                                            <option value=\"\">Select</option>\n");
      out.write("                                            ");
for(int i=0; i<specialistArray.size(); i++){
      out.write("<option value=\"");
      out.print( specialistArray.get(i) );
      out.write('"');
      out.write('>');
      out.print( specialistArray.get(i) );
      out.write("</option>");
} 
      out.write("\n");
      out.write("                                            ");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"form-group\" id=\"specialtiesDiv\">\n");
      out.write("                                        ");
      out.write("\n");
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
      out.write("            function myFunction() \n");
      out.write("            {\n");
      out.write("                var x = document.getElementById(\"specialist\").value;\n");
      out.write("                if(x === \"Yes\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"specialtiesDiv\").style.visibility= \"visible\";\n");
      out.write("                    document.getElementById(\"specialtiesDiv\").innerHTML = \"<label for='specialties'>What are your specialties? *</label><select class='form-control' name='specialties' id='specialties' required><option value=''>Select</option>\" + \"");
for(int i=0; i<specialtiesArray.size(); i++){
      out.write("\" + \"<option value='\" + \"");
      out.print( specialtiesArray.get(i) );
      out.write("\" + \"'\" + \">\" + \"");
      out.print( specialtiesArray.get(i) );
      out.write("\" + \"</option>\" + \"");
} 
      out.write("\" + \"</select>\";\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"specialtiesDiv\").style.visibility= \"hidden\";\n");
      out.write("                }\n");
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
