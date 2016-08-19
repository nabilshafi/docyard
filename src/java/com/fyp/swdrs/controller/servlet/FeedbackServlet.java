/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller.servlet;

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

public class FeedbackServlet extends HttpServlet 
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
            if(userType.equals("patient"))
            {
                Patient patient = (Patient)request.getSession().getAttribute("patient");
                if(patient.getUserHasProfile() > 0)
                {
                    String doctorName = (String)request.getSession().getAttribute("doctorName");
                    request.getSession().setAttribute("doctorName", doctorName);
                    RequestDispatcher rd=request.getRequestDispatcher("feedback51.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    //out.print("<h1>Please Create A Profile First</h1>"); 
                    out.println("<body onload=\"myFunction()\">");
                    out.println("</body>");
                    out.println("<script>function myFunction() {alert(\"Please Create Your Profile First!\");}</script>");
                    RequestDispatcher rd=request.getRequestDispatcher(userType + "Home.jsp"); 
                    rd.include(request,response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        { 
            out.print("<h1>Welcome to feedback Servlet from doPost</h1>"); 
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
