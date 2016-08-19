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

public class RedirectServlet extends HttpServlet 
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
            out.print("<h1>Welcome to redirect Servlet from doGet</h1>"); 
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
            Object[] params = new Object[4];
            params[0] = request.getParameter("name");
            params[1] = request.getParameter("email");
            String temp = request.getParameter("password");
            params[3] = request.getParameter("userCategory");
            if(temp.equals(request.getParameter("repeatPassword")))
            {
                params[2] = temp;
                returnObj = controller.processRequest(Constants.createUserAction, params, filename);
                if(returnObj != null)
                {
                    if(((String)returnObj[1]).equals("admin"))
                    {// Admin Signup Success
                        Admin admin = (Admin)returnObj[0];
                        request.getSession().setAttribute("userType", (String)returnObj[1]);
                        request.getSession().setAttribute("admin", admin);
                        out.println("<body onload=\"myFunction()\">");
                        out.println("</body>");
                        out.println("<script>function myFunction() {alert(\"Account created Successfully!\");}</script>");
                        RequestDispatcher rd=request.getRequestDispatcher("login");
                        rd.include(request,response);
                    }
                    else if(((String)returnObj[1]).equals("doctor"))
                    {// Doctor Signup Success
                        Doctor doctor = (Doctor)returnObj[0];
                        request.getSession().setAttribute("userType", (String)returnObj[1]);
                        request.getSession().setAttribute("doctor", doctor);
                        out.println("<body onload=\"myFunction()\">");
                        out.println("</body>");
                        out.println("<script>function myFunction() {alert(\"Account created Successfully!\");}</script>");
                        RequestDispatcher rd=request.getRequestDispatcher("login");
                        rd.include(request,response);
                    }
                    else if(((String)returnObj[1]).equals("patient"))
                    {// Patient Signup Success
                        Patient patient = (Patient)returnObj[0];
                        request.getSession().setAttribute("userType", (String)returnObj[1]);
                        request.getSession().setAttribute("patient", patient);
                        out.println("<body onload=\"myFunction()\">");
                        out.println("</body>");
                        out.println("<script>function myFunction() {alert(\"Account created Successfully!\");}</script>");
                        RequestDispatcher rd=request.getRequestDispatcher("login");
                        rd.include(request,response);
                    }
                    else
                    {
                        out.print("<h1>Sorry user does not exist</h1>"); 
                    }
                }
                else
                {
//                    out.print("<h1>ERROR 1: Email not found</h1>"); 
                    response.sendRedirect("signupError1");
                }
            }
            else
            {
//                out.print("<h1>ERROR 2: Password does not match</h1>"); 
                response.sendRedirect("signupError2");
            }
            
//            out.print("<h1>Welcome to redirect Servlet from doPost</h1>"); 
//            out.print("<h3>Name: " + (String)params[0] + "</h3>"); 
//            out.print("<h3>Email: " + (String)params[1] + "</h3>"); 
//            out.print("<h3>Password: " + (String)params[2] + "</h3>"); 
//            out.print("<h3>User Category: " + (String)params[3] + "</h3>"); 
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
