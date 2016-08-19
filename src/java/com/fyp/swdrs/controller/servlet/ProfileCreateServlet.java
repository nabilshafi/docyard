/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */

public class ProfileCreateServlet extends HttpServlet 
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
            String filename = request.getServletContext().getRealPath("/");
            Controller controller = new Controller();
            Object[] returnObj = null;
            out.print("<h1>Welcome to profile Servlet from doGet</h1>"); 
            if(userType.equals("admin"))
            {
                Admin admin = (Admin)request.getSession().getAttribute("admin");
                if(admin.getUserHasProfile() == 0)
                {
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileCreate.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    Object[] params = new Object[2];
                    params[0] = admin.getName();
                    params[1] = admin.getEmail();
                    if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))))
                    {
                        returnObj = controller.processRequest(Constants.viewAdminProfileAction, params, filename);
                        if(returnObj != null)
                        {
                            if(((String)returnObj[1]).equals("adminProfile"))
                            {
                                AdminProfile adminProfile = (AdminProfile)returnObj[0];
                                request.getSession().setAttribute("adminProfile", adminProfile);
                                admin.setAdminProfile(adminProfile);
                                request.getSession().setAttribute("admin", admin);
                                RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileView.jsp"); 
                                rd.forward(request,response);
                            }
                        }
                    }
                }
            }
            else if(userType.equals("doctor"))
            {
                Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
                if(doctor.getUserHasProfile() == 0)
                {
                    String contact = (String)request.getSession().getAttribute("contact");
                    String gender = (String)request.getSession().getAttribute("gender");
                    String dob = (String)request.getSession().getAttribute("dob");
                    request.getSession().setAttribute("contact", contact);
                    request.getSession().setAttribute("gender", gender);
                    request.getSession().setAttribute("dob", dob);

                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileCreate1.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    Object[] params = new Object[2];
                    params[0] = doctor.getName();
                    params[1] = doctor.getEmail();
                    if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))))
                    {
                        out.println("1");
                        returnObj = controller.processRequest(Constants.viewDoctorProfileAction, params, filename);
                        out.println("1");
                        if(returnObj != null)
                        {
                            out.println("1");
                            if(((String)returnObj[1]).equals("doctorProfile"))
                            {
                                out.println("1");
                                ArrayList<DoctorProfile> doctorProfiles = (ArrayList<DoctorProfile>)returnObj[2];
                                request.getSession().setAttribute("doctorProfiles", doctorProfiles);
                                doctor.setDoctorProfiles(doctorProfiles);
                                request.getSession().setAttribute("doctor", doctor);
                                RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileView.jsp"); 
                                rd.forward(request,response);
                            }
                        }
                    }
                }
            }
            else if(userType.equals("patient"))
            {
                Patient patient = (Patient)request.getSession().getAttribute("patient");
                if(patient.getUserHasProfile() == 0)
                {
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileCreate.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    Object[] params = new Object[2];
                    params[0] = patient.getName();
                    params[1] = patient.getEmail();
                    if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))))
                    {
                        returnObj = controller.processRequest(Constants.viewPatientProfileAction, params, filename);
                        if(returnObj != null)
                        {
                            if(((String)returnObj[1]).equals("patientProfile"))
                            {
                                PatientProfile patientProfile = (PatientProfile)returnObj[0];
                                request.getSession().setAttribute("patientProfile", patientProfile);
                                patient.setPatientProfile(patientProfile);
                                request.getSession().setAttribute("patient", patient);
                                RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileViewUpdate.jsp"); 
                                rd.forward(request,response);
//                                out.println("<h1>Patient Name: " + patient.getName() + "</h1>"); 
//                                out.println("<h1>Patient Email: " + patient.getEmail()+ "</h1>"); 
//                                out.println("<h1>Patient UserType: " + patient.getUserCategory()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Count: " + patient.getUserHasProfile()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Id: " + patient.getPatientProfile().getId() + "</h1>"); 
//                                out.println("<h1>Patient Profile Name: " + patient.getPatientProfile().getName() + "</h1>"); 
//                                out.println("<h1>Patient Profile Email: " + patient.getPatientProfile().getEmail()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Contact: " + patient.getPatientProfile().getContact()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Date of Birth: " + patient.getPatientProfile().getDateOfBirth()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Gender: " + patient.getPatientProfile().getGender()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Income Group: " + patient.getPatientProfile().getIncomeGroup()+ "</h1>"); 
//                                out.println("<h1>Patient Profile City: " + patient.getPatientProfile().getLocation().getCity()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Country: " + patient.getPatientProfile().getLocation().getCountry()+ "</h1>"); 
//                                out.println("<h1>Patient Profile Area: " + patient.getPatientProfile().getLocation().getArea()+ "</h1>"); 
                            }
                        }
                    }
                }
            }
            else
            {
                out.print("<h1>Sorry user does not exist</h1>"); 
            }
            processRequest(request, response);
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
            String userType = (String)request.getSession().getAttribute("userType");
            String link = "Profile.jsp";
            out.print("<h1>Welcome to profile Servlet from doPost</h1>"); 
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
    public String getServletInfo() 
    {
        return "Short description";
    }
}
