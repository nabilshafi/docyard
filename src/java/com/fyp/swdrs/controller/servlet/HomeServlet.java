/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
import com.fyp.swdrs.utility.Utility;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */

public class HomeServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</html>");
        }
        finally
        {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        { 
            String userType = (String)request.getSession().getAttribute("userType");
            String link = "Home.jsp";
            out.print("<h1>Welcome to index Servlet from doGet</h1>"); 
            out.print("<h1>User Type: " + userType + "</h1>"); 
            out.print("<h1>Link: " + link + "</h1>"); 
            out.print("<h1>Go to: </h1>"); 
            out.print("<h1><a href=\"" + userType + link + "\">Link</a></h1>"); 
            
            RequestDispatcher rd=request.getRequestDispatcher(userType + link); 
            rd.forward(request,response);
            //processRequest(request, response);
        }
        finally 
        {            
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        { 
            String filename = request.getServletContext().getRealPath("/");
            Controller controller = new Controller();
            Object[] returnObj = null;
            Object[] params = new Object[2];
            params[0] = request.getParameter("email");
            params[1] = request.getParameter("password");
            returnObj = controller.processRequest(Constants.loginAction, params, filename);
            if(returnObj != null)
            {
                if(((String)returnObj[1]).equals("admin"))
                {// Admin Login Success
                    Admin admin = (Admin)returnObj[0];
                    ArrayList<String> areaList = Utility.viewArea(filename);
                    ArrayList<String> cityList = Utility.viewCity(filename);
                    ArrayList<String> daysList = Utility.viewDays(filename);
                    ArrayList<String> degreeList = Utility.viewDegree(filename);
                    ArrayList<String> genderList = Utility.viewGender(filename);
                    ArrayList<String> hospitalList = Utility.viewHospital(filename);
                    ArrayList<String> incomeGroupList = Utility.viewIncomeGroup(filename);
                    ArrayList<String> specialtiesList = Utility.viewSpecialties(filename);
                    ArrayList<String> symptomList = Utility.viewSymptom(filename);
                    ArrayList<String> diseaseList = Utility.viewDisease(filename);
                    ArrayList<String> addressList = Utility.viewAddress(filename);
                    ArrayList<String> feedbackQuestionList = Utility.viewFeedbackQuestion(filename);

                    request.getSession().setAttribute("userType", (String)returnObj[1]);
                    request.getSession().setAttribute("admin", admin);
                    request.getSession().setAttribute("areaList", areaList);
                    request.getSession().setAttribute("cityList", cityList);
                    request.getSession().setAttribute("daysList", daysList);
                    request.getSession().setAttribute("degreeList", degreeList);
                    request.getSession().setAttribute("genderList", genderList);
                    request.getSession().setAttribute("hospitalList", hospitalList);
                    request.getSession().setAttribute("incomeGroupList", incomeGroupList);
                    request.getSession().setAttribute("specialtiesList", specialtiesList);
                    request.getSession().setAttribute("symptomList", symptomList);
                    request.getSession().setAttribute("diseaseList", diseaseList);
                    request.getSession().setAttribute("addressList", addressList);
                    request.getSession().setAttribute("feedbackQuestionList", feedbackQuestionList);

                    request.getSession().setAttribute("userType", (String)returnObj[1]);
                    request.getSession().setAttribute("admin", admin);
                    RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp"); 
                    rd.forward(request,response);
                }
                else if(((String)returnObj[1]).equals("doctor"))
                {// Doctor Login Success
                    Doctor doctor = (Doctor)returnObj[0];

                    String contact = "";
                    String dob = "";
                    String gender = "";
                    String degree = "";
                    String specialist = "";
                    String specialties = "";
                    String hospital = "";
                    String days = "";
                    String visitingHours = "";
                    String visitingHours2 = "";
                    String feeStructure = "";
                    String city = "";
                    String country = "";
                    String area = "";
                    request.getSession().setAttribute("contact", contact);
                    request.getSession().setAttribute("dob", dob);
                    request.getSession().setAttribute("gender", gender);
                    request.getSession().setAttribute("degree", degree);
                    request.getSession().setAttribute("specialist", specialist);
                    request.getSession().setAttribute("specialties", specialties);
                    request.getSession().setAttribute("hospital", hospital);
                    request.getSession().setAttribute("visitingHours", visitingHours);
                    request.getSession().setAttribute("visitingHours2", visitingHours2);
                    request.getSession().setAttribute("feeStructure", feeStructure);
                    request.getSession().setAttribute("days", days);
                    request.getSession().setAttribute("city", city);
                    request.getSession().setAttribute("country", country);
                    request.getSession().setAttribute("area", area);
                    
                    request.getSession().setAttribute("userType", (String)returnObj[1]);
                    request.getSession().setAttribute("doctor", doctor);
                    RequestDispatcher rd=request.getRequestDispatcher("doctorHome.jsp"); 
                    rd.forward(request,response);
                }
                else if(((String)returnObj[1]).equals("patient"))
                {// Patient Login Success
                    Patient patient = (Patient)returnObj[0];

                    String doctorName = "";
                    String searchQuery = "";
                    String searchSymptomQuery1 = "";
                    String searchSymptomQuery2 = "";
                    String searchSymptomQuery3 = "";
                    String display = "one";
                    request.getSession().setAttribute("doctorName", doctorName);
                    request.getSession().setAttribute("searchQuery", searchQuery);
                    request.getSession().setAttribute("searchSymptomQuery1", searchSymptomQuery1);
                    request.getSession().setAttribute("searchSymptomQuery2", searchSymptomQuery2);
                    request.getSession().setAttribute("searchSymptomQuery3", searchSymptomQuery3);
                    request.getSession().setAttribute("display", display);

                    request.getSession().setAttribute("userType", (String)returnObj[1]);
                    request.getSession().setAttribute("patient", patient);
                    RequestDispatcher rd=request.getRequestDispatcher("patientHome.jsp");
                    rd.forward(request,response);
                }
                else
                {  
                    out.print("<h1>Sorry user does not exist</h1>"); 
                }
            }
            else 
            {
//                out.print("<h1>Sorry email &/or password does not exist</h1>");
                response.sendRedirect("loginError");
            }
        }
        finally 
        {            
            out.close();
        }
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }
}