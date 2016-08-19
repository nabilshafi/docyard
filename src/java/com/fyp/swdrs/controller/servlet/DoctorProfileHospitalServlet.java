/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.controller.servlet;

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

public class DoctorProfileHospitalServlet extends HttpServlet 
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
            out.print("<h1>Welcome to profile2 Servlet from doGet</h1>"); 
            RequestDispatcher rd=request.getRequestDispatcher(userType + "ProfileCreate2.jsp"); 
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
            Object[] params = new Object[16];
            params[0] = request.getParameter("name");
            params[1] = request.getParameter("email");
            params[2] = request.getParameter("contact");
            params[3] = request.getParameter("dateOfBirth");
            params[4] = request.getParameter("gender");
            request.getSession().setAttribute("paramsObj", params);
            
//            out.print("<h1>Welcome to profile2 Servlet from doPost</h1>"); 
//            out.print("<h3>Name: " + params[0] + "</h3>"); 
//            out.print("<h3>Email: " + params[1] + "</h3>"); 
//            out.print("<h3>Contact: " + params[2] + "</h3>"); 
//            out.print("<h3>DateOfBirth: " + params[3] + "</h3>"); 
//            out.print("<h3>Gender: " + params[4] + "</h3>"); 
//            out.print("<h3><a href=\"profile3\">Go To:</a></h3>"); 

            String contact = (String)params[2];
            String gender = (String)params[4];
            String dob = (String)params[3];
            String degree = (String)request.getSession().getAttribute("degree");
            String specialist = (String)request.getSession().getAttribute("specialist");
            String specialties = (String)request.getSession().getAttribute("specialties");
            request.getSession().setAttribute("contact", contact);
            request.getSession().setAttribute("gender", gender);
            request.getSession().setAttribute("dob", dob);
            request.getSession().setAttribute("degree", degree);
            request.getSession().setAttribute("specialist", specialist);
            request.getSession().setAttribute("specialties", specialties);

            RequestDispatcher rd=request.getRequestDispatcher("doctorProfileCreate2.jsp"); 
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
