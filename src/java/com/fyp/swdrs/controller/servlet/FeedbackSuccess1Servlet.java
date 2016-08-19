/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
import com.fyp.swdrs.utility.Utility;
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

public class FeedbackSuccess1Servlet extends HttpServlet
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
            out.print("<h1>Welcome to feedbacksuccess Servlet from doGet</h1>"); 
            //RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); 
            //rd.forward(request,response);
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
            out.print("<h1>Welcome to feedbacksuccess Servlet from doPost</h1>"); 
            Object[] params = new Object[20];
            params[0] = request.getParameter("patientName");
            params[1] = request.getParameter("patientEmail");
            params[2] = request.getParameter("doctorName");
            String doctorName = (String)params[2];
            request.getSession().setAttribute("paramsObjFeedback", params);
            request.getSession().setAttribute("doctorName", doctorName);
            
            RequestDispatcher rd=request.getRequestDispatcher("feedback52.jsp"); 
            rd.forward(request,response);
            processRequest(request, response);
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
