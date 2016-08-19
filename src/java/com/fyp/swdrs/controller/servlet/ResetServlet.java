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

public class ResetServlet extends HttpServlet 
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
            out.print("<h1>Welcome to reset Servlet from doGet</h1>"); 
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
            String filename = request.getServletContext().getRealPath("/");
            Controller controller = new Controller();
            Object[] returnObj = null;
            Object[] params = new Object[2];
            params[0] = request.getParameter("email");
            String temp = request.getParameter("newPassword");
            if(temp.equals(request.getParameter("repeatPassword")))
            {
                params[1] = temp;
                returnObj = controller.processRequest(Constants.changePasswordAction, params, filename);
                if(returnObj != null)
                {
                    if(((String)returnObj[1]).equals("admin"))
                    {// Admin Login Success
                        Admin admin = (Admin)returnObj[0];
                        RequestDispatcher rd=request.getRequestDispatcher("login"); 
                        rd.forward(request,response);
                    }
                    else if(((String)returnObj[1]).equals("doctor"))
                    {// Doctor Login Success
                        Doctor doctor = (Doctor)returnObj[0];
                        RequestDispatcher rd=request.getRequestDispatcher("login"); 
                        rd.forward(request,response);
                    }
                    else if(((String)returnObj[1]).equals("patient"))
                    {// Patient Login Success
                        Patient patient = (Patient)returnObj[0];
                        RequestDispatcher rd=request.getRequestDispatcher("login"); 
                        rd.forward(request,response);
                    }
                    else
                    {  
                        out.print("<h1>Sorry user does not exist</h1>"); 
                    }
                }
                else
                {
//                    out.print("<h1>ERROR 1: Email not found</h1>"); 
                    response.sendRedirect("forgotError1");
                }
            }
            else
            {
//                out.print("<h1>ERROR 2: Password does not match</h1>"); 
                response.sendRedirect("forgotError2");
            }
            
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
