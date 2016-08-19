/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
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

public class ProfileUpdateSuccessServlet extends HttpServlet 
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
            out.print("<h1>Welcome to profileupdated Servlet from doGet</h1>"); 
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
        PrintWriter out = response.getWriter();
        try 
        {
            String userType = (String)request.getSession().getAttribute("userType");
            String filename = request.getServletContext().getRealPath("/");

            Controller controller = new Controller();
            Object[] returnObj = null;
            if(userType.equals("admin"))
            {
                Admin admin = (Admin)request.getSession().getAttribute("admin");
                Object[] params = new Object[4];
                params[0] = admin.getAdminProfile().getId();
                params[1] = request.getParameter("name");
                params[2] = request.getParameter("email");
                params[3] = request.getParameter("contact");
                if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))&&(((String)params[2]).equals(""))&&(((String)params[3]).equals(""))))
                {
                    returnObj = controller.processRequest(Constants.updateAdminProfileAction, params, filename);
                    if(returnObj != null)
                    {
                        if(((String)returnObj[1]).equals("adminProfile"))
                        {
                            AdminProfile adminProfile = (AdminProfile)returnObj[0];
                            request.getSession().setAttribute("adminProfile", adminProfile);
                            admin.setAdminProfile(adminProfile);
                            request.getSession().setAttribute("admin", admin);
                            out.println("<body onload=\"myFunction()\">");
                            out.println("</body>");
                            out.println("<script>function myFunction() {alert(\"Profile updated Successfully!\");}</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp"); 
                            rd.include(request,response);
                        }
                    }
                }
            }
            else if(userType.equals("doctor"))
            {
                Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
                Object[] params = new Object[18];
                params[0] = doctor.getDoctorProfiles().get(doctor.getProfileNumber()).getId();
                params[1] = request.getParameter("name");
                params[2] = request.getParameter("email");
                params[3] = request.getParameter("contact");
                params[4] = request.getParameter("dateOfBirth");
                params[5] = request.getParameter("gender");
                params[6] = request.getParameter("degree");
                params[7] = request.getParameter("specialist");
                params[8] = request.getParameter("specialties");
                params[9] = request.getParameter("hospital");
                params[10] = request.getParameter("day");
                params[11] = request.getParameter("visitingHours");
                params[12] = request.getParameter("visitingHours2");
                params[13] = request.getParameter("feeStructure");
                params[14] = request.getParameter("city");
                params[15] = request.getParameter("country");
                params[16] = request.getParameter("area");
                params[17] = doctor.getProfileNumber();

                if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))&&(((String)params[2]).equals(""))&&(((String)params[3]).equals(""))&&(((String)params[4]).equals(""))&&(((String)params[5]).equals(""))&&(((String)params[6]).equals(""))&&(((String)params[7]).equals(""))&&(((String)params[8]).equals(""))&&(((String)params[9]).equals(""))&&(((String)params[10]).equals(""))&&(((String)params[11]).equals(""))&&(((String)params[12]).equals(""))&&(((String)params[13]).equals(""))&&(((String)params[14]).equals(""))&&(((String)params[15]).equals(""))&&(((String)params[16]).equals(""))&&(((String)params[17]).equals(""))))
                {
                    returnObj = controller.processRequest(Constants.updateDoctorProfileAction, params, filename);
                    if(returnObj != null)
                    {
                        if(((String)returnObj[1]).equals("doctorProfile"))
                        {
                            DoctorProfile doctorProfile = (DoctorProfile)returnObj[0];
                            request.getSession().setAttribute("doctorProfile", doctorProfile);
                            doctor.setDoctorProfile(doctorProfile);
                            request.getSession().setAttribute("doctor", doctor);
                            out.println("<body onload=\"myFunction()\">");
                            out.println("</body>");
                            out.println("<script>function myFunction() {alert(\"Profile updated Successfully!\");}</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("doctorHome.jsp"); 
                            rd.include(request,response);
                        }
                    }
                }
            }
            else if(userType.equals("patient"))
            {
                Patient patient = (Patient)request.getSession().getAttribute("patient");
                Object[] params = new Object[10];
                params[0] = patient.getPatientProfile().getId();
                params[1] = request.getParameter("name");
                params[2] = request.getParameter("email");
                params[3] = request.getParameter("contact");
                params[4] = request.getParameter("dateOfBirth");
                params[5] = request.getParameter("gender");
                params[6] = request.getParameter("incomeGroup");
                params[7] = request.getParameter("city");
                params[8] = request.getParameter("country");
                params[9] = request.getParameter("area");

                if(!((((String)params[0]).equals(""))&&(((String)params[1]).equals(""))&&(((String)params[2]).equals(""))&&(((String)params[3]).equals(""))&&(((String)params[4]).equals(""))&&(((String)params[5]).equals(""))&&(((String)params[6]).equals(""))&&(((String)params[7]).equals(""))&&(((String)params[8]).equals(""))&&(((String)params[9]).equals(""))))
                {
                    returnObj = controller.processRequest(Constants.updatePatientProfileAction, params, filename);
                    if(returnObj != null)
                    {
                        if(((String)returnObj[1]).equals("patientProfile"))
                        {
                            PatientProfile patientProfile = (PatientProfile)returnObj[0];
                            request.getSession().setAttribute("patientProfile", patientProfile);
                            patient.setPatientProfile(patientProfile);
                            request.getSession().setAttribute("patient", patient);
                            out.println("<body onload=\"myFunction()\">");
                            out.println("</body>");
                            out.println("<script>function myFunction() {alert(\"Profile updated Successfully!\");}</script>");
                            RequestDispatcher rd=request.getRequestDispatcher("patientHome.jsp"); 
                            rd.include(request,response);
                        }
                    }
                }
            }
            else
            {
                out.print("<h1>User Type does not exist</h1>"); 
            }
//            processRequest(request, response);
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
