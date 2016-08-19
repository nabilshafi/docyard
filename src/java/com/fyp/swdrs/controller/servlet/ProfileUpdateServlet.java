/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
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

public class ProfileUpdateServlet extends HttpServlet
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
            out.println("</body>");
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
        PrintWriter out = response.getWriter();
        try 
        {
//            out.print("<h1>Welcome to profileupdate Servlet from doGet</h1>"); 
            doPost(request, response);
        } 
        finally 
        {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        try 
        {
            String userType = (String)request.getSession().getAttribute("userType");
            out.print("<h1>Welcome to profileupdate Servlet from doPost</h1>"); 
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
                    out.print("<h1>Admin Name: " + admin.getName() + "</h1>"); 
                    out.print("<h1>Admin Email: " + admin.getEmail()+ "</h1>"); 
                    out.print("<h1>Admin UserType: " + admin.getUserCategory()+ "</h1>"); 
                    out.print("<h1>Admin Profile Count: " + admin.getUserHasProfile()+ "</h1>"); 
                    processRequest(request, response);
                }
            }
            else if(userType.equals("doctor"))
            {
                Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
                if(doctor.getUserHasProfile() == 0)
                {
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileCreate1.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    for (int i = 0; i < doctor.getDoctorProfiles().size(); i++) 
                    {
                        if(
                            (doctor.getDoctorProfiles().get(i).getHospital().getHospitalName().equals(request.getParameter("hospitalName")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getDays().equals(request.getParameter("day")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getVisitingHours().equals(request.getParameter("visitingHours")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getVisitingHours2().equals(request.getParameter("visitingHours2")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getFeeStructure().equals(request.getParameter("feeStructure")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getLocation().getCity().substring(doctor.getDoctorProfiles().get(i).getHospital().getLocation().getCity().indexOf("#")+1).equals(request.getParameter("city")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getLocation().getCountry().substring(doctor.getDoctorProfiles().get(i).getHospital().getLocation().getCountry().indexOf("#")+1).equals(request.getParameter("country")))&&
                            (doctor.getDoctorProfiles().get(i).getHospital().getLocation().getArea().substring(doctor.getDoctorProfiles().get(i).getHospital().getLocation().getArea().indexOf("#")+1).equals(request.getParameter("area")))
                        )
                        {    
                            doctor.setProfileNumber(i);
                        }    
                    }
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileUpdate.jsp"); 
                    rd.forward(request,response);
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
//                    out.println("<h1>Patient Name: " + patient.getName() + "</h1>"); 
//                    out.println("<h1>Patient Email: " + patient.getEmail()+ "</h1>"); 
//                    out.println("<h1>Patient UserType: " + patient.getUserCategory()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Count: " + patient.getUserHasProfile()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Id: " + patient.getPatientProfile().getId() + "</h1>"); 
//                    out.println("<h1>Patient Profile Name: " + patient.getPatientProfile().getName() + "</h1>"); 
//                    out.println("<h1>Patient Profile Email: " + patient.getPatientProfile().getEmail()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Contact: " + patient.getPatientProfile().getContact()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Date of Birth: " + patient.getPatientProfile().getDateOfBirth()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Gender: " + patient.getPatientProfile().getGender()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Income Group: " + patient.getPatientProfile().getIncomeGroup()+ "</h1>"); 
//                    out.println("<h1>Patient Profile City: " + patient.getPatientProfile().getLocation().getCity()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Country: " + patient.getPatientProfile().getLocation().getCountry()+ "</h1>"); 
//                    out.println("<h1>Patient Profile Area: " + patient.getPatientProfile().getLocation().getArea()+ "</h1>"); 
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileUpdate.jsp"); 
                    rd.forward(request,response);
                }
            }
            else
            {
                out.print("<h1>User Type does not exist</h1>"); 
                processRequest(request, response);
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
