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

public class DoctorProfileUpdateAddMoreServlet extends HttpServlet 
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
            out.print("<h1>Welcome to profileupdateAddMore Servlet from doGet</h1>"); 
            RequestDispatcher rd=request.getRequestDispatcher("doctorProfileCreateAddMore3.jsp"); 
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
            out.print("<h1>Welcome to profileupdateAddMore Servlet from doPost</h1>"); 
            Object[] params = new Object[16];
            params[0] = request.getParameter("name");
            params[1] = request.getParameter("email");
            params[2] = request.getParameter("contact");
            params[3] = request.getParameter("dateOfBirth");
            params[4] = request.getParameter("gender");
            params[5] = request.getParameter("degree");
            params[6] = request.getParameter("specialist");
            params[7] = request.getParameter("specialties");
            request.getSession().setAttribute("paramsObj", params);
            
            out.print("<h3>Name: " + params[0] + "</h3>"); 
            out.print("<h3>Email: " + params[1] + "</h3>"); 
            out.print("<h3>Contact: " + params[2] + "</h3>"); 
            out.print("<h3>DateOfBirth: " + params[3] + "</h3>"); 
            out.print("<h3>Gender: " + params[4] + "</h3>"); 
            out.print("<h3>Degree: " + params[5] + "</h3>"); 
            out.print("<h3>Specialist: " + params[6] + "</h3>"); 
            out.print("<h3>Specialties: " + params[7] + "</h3>"); 
            RequestDispatcher rd=request.getRequestDispatcher("doctorProfileCreateAddMore3.jsp"); 
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
