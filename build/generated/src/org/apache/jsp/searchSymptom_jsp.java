package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.fyp.swdrs.bo.Doctor;
import java.util.ArrayList;
import com.fyp.swdrs.utility.Utility;

public final class searchSymptom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en-gb\" class=\"no-js\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\t<title>\n");
      out.write("            SWDRS - Symptom Search Doctor\n");
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
      out.write("                            <li>\n");
      out.write("                                <a href=\"profile\" class=\"scroll-link\" title=\"Profile\">\n");
      out.write("                                    Profile\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"active\" id=\"firstLink\">\n");
      out.write("                                <a href=\"\" class=\"scroll-link\" title=\"Search\">\n");
      out.write("                                    Search\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"feedback\" class=\"scroll-link\" title=\"Feedback\">\n");
      out.write("                                    Feedback\n");
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
      out.write("        <section id=\"feedback\" class=\"contact-parlex\">\n");
      out.write("            <div class=\"parlex-back\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row mrgn30\">\n");
      out.write("                        <div class=\"heading text-center\"> \n");
      out.write("                            <h1>\n");
      out.write("                                Symptom Search Doctor\n");
      out.write("                            </h1>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row mrgn30\">\n");
      out.write("                        <button name=\"addBTN\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"addBTN\" onclick=\"addFunction()\">Add</button>\n");
      out.write("                        <button name=\"removeBTN\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"removeBTN\" onclick=\"removeFunction()\">Remove</button>\n");
      out.write("                        <form method=\"post\" action=\"searchSymptomSuccess\" id=\"searchfrm\" role=\"form\">\n");
      out.write("                            <table id=\"myTable\"><div class=\"col-sm-4\">\n");
      out.write("                                <div class=\"search-group\">\n");
      out.write("                                    <label for=\"searchSymptomQuery\">\n");
      out.write("                                        Symptom Search Doctor: *\n");
      out.write("                                    </label>\n");
      out.write("                                    <select class=\"search-control\" name=\"searchSymptomQuery\" id=\"searchSymptomQuery\" required>\n");
      out.write("                                        <option value=\"\">Select</option>\n");
      out.write("                                        <option value=\"1\">1</option>\n");
      out.write("                                        <option value=\"2\">2</option>\n");
      out.write("                                        <option value=\"3\">3</option>\n");
      out.write("                                    </select> \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <button name=\"symptomSearchBtn\" type=\"submit\" class=\"btn btn-lg btn-primary\" id=\"search\">\n");
      out.write("                                        Symptom Search\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                            </div></table>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
      out.write("            function addFunction() {\n");
      out.write("                var count = 3;\n");
      out.write("                var table = document.getElementById(\"myTable\");\n");
      out.write("                var x = document.getElementById(\"myTable\").rows.length;\n");
      out.write("                var row = table.insertRow(x);\n");
      out.write("                var cell = row.insertCell(0);\n");
      out.write("                document.getElementById(\"demo\").innerHTML = \"Total rows: \" + (x+1);\n");
      out.write("                if(x < 3)\n");
      out.write("                {\n");
      out.write("                    cell.innerHTML = \"<div  class=\\\"search-group\\\"><select class=\\\"search-control\\\" name=\\\"searchSymptomQuery\\\" id=\\\"searchSymptomQuery\\\" required><option value=\\\"\\\">Select</option><option value=\\\"1\\\">1</option><option value=\\\"2\\\">2</option><option value=\\\"3\\\">3</option></select> </div>\";\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    cell.innerHTML = \"DONE\t\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function removeFunction() {\n");
      out.write("                var x = document.getElementById(\"myTable\").rows.length;\n");
      out.write("                document.getElementById(\"demo\").innerHTML = \"Total rows: \" + (x-1);\n");
      out.write("                document.getElementById(\"myTable\").deleteRow(x-1);\t\n");
      out.write("            }\n");
      out.write("\n");
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
