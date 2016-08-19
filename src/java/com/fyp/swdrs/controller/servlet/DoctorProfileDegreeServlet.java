/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.DoctorProfile;
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

public class DoctorProfileDegreeServlet extends HttpServlet 
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
            out.print("<h1>Welcome to profile3 Servlet from doGet</h1>"); 
            out.print("<h3>User: " + (String)request.getSession().getAttribute("userType") + "</h3>"); 
            Doctor doctor = (Doctor)request.getSession().getAttribute("doctor");
            DoctorProfile doctorProfile = doctor.getDoctorProfile();
            String str = doctorProfile.getName();
            out.print("<h3>User: " + str + "</h3>"); 
            
            Object[] params = new Object[16];
            params[0] = doctorProfile.getName();
            params[1] = doctorProfile.getEmail();
            params[2] = doctorProfile.getContact();
            params[3] = doctorProfile.getDateOfBirth();
            params[4] = doctorProfile.getGender();
            params[5] = doctorProfile.getSpecialization().getDegree();
            params[6] = doctorProfile.getSpecialization().getSpecialist();
            params[7] = doctorProfile.getSpecialization().getSpecialties();
            request.getSession().setAttribute("paramsObj", params);
//            out.print("<h3>Name: " + params[0] + "</h3>"); 
//            out.print("<h3>Email: " + params[1] + "</h3>"); 
//            out.print("<h3>Contact: " + params[2] + "</h3>"); 
//            out.print("<h3>DateOfBirth: " + params[3] + "</h3>"); 
//            out.print("<h3>Gender: " + params[4] + "</h3>"); 
//            out.print("<h3>Degree: " + params[5] + "</h3>"); 
//            out.print("<h3>Specialist: " + params[6] + "</h3>"); 
//            out.print("<h3>Specialties: " + params[7] + "</h3>"); 
            String contact = (String)params[2];
            String gender = (String)params[3];
            String dob = (String)params[4];
            String degree = (String)params[5];
            String specialist = (String)params[6];
            String specialties = (String)params[7];
            request.getSession().setAttribute("contact", contact);
            request.getSession().setAttribute("gender", gender);
            request.getSession().setAttribute("dob", dob);
            request.getSession().setAttribute("degree", degree);
            request.getSession().setAttribute("specialist", specialist);
            request.getSession().setAttribute("specialties", specialties);
            
            RequestDispatcher rd=request.getRequestDispatcher("doctorProfileCreate3.jsp"); 
            rd.forward(request,response);
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
            out.print("<h1>Welcome to profile3 Servlet from doPost</h1>"); 
            Object[] params = (Object[])request.getSession().getAttribute("paramsObj");
            params[5] = request.getParameter("degree");
            params[6] = request.getParameter("specialist");
            params[7] = request.getParameter("specialties");
            request.getSession().setAttribute("paramsObj", params);

            if(((String)params[6]).equals("No"))
            {
                params[7] = "None";
            }

            out.print("<h3>Name: " + params[0] + "</h3>"); 
            out.print("<h3>Email: " + params[1] + "</h3>"); 
            out.print("<h3>Contact: " + params[2] + "</h3>"); 
            out.print("<h3>DateOfBirth: " + params[3] + "</h3>"); 
            out.print("<h3>Gender: " + params[4] + "</h3>"); 
            out.print("<h3>Degree: " + params[5] + "</h3>"); 
            out.print("<h3>Specialist: " + params[6] + "</h3>"); 
            out.print("<h3>Specialties: " + params[7] + "</h3>"); 
            out.print("<h3>User: " + (String)request.getSession().getAttribute("userType") + "</h3>"); 

            String contact = (String)request.getSession().getAttribute("contact");
            String gender = (String)request.getSession().getAttribute("gender");
            String dob = (String)request.getSession().getAttribute("dob");
            String degree = (String)params[5];
            String specialist = (String)params[6];
            String specialties = (String)params[7];
            request.getSession().setAttribute("contact", contact);
            request.getSession().setAttribute("gender", gender);
            request.getSession().setAttribute("dob", dob);
            request.getSession().setAttribute("degree", degree);
            request.getSession().setAttribute("specialist", specialist);
            request.getSession().setAttribute("specialties", specialties);

            out.print("<h3>Specialties: " + specialties + "</h3>"); 

            RequestDispatcher rd=request.getRequestDispatcher("doctorProfileCreate3.jsp"); 
            rd.forward(request,response);
            processRequest(request, response);
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
