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
 * @author liban
 */


//searchSymptom
public class SearchSymptomServlet extends HttpServlet 
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
            out.print("<h1>Welcome to search Servlet from doGet</h1>"); 
            String searchSymptomQuery1 = (String)request.getSession().getAttribute("searchSymptomQuery1");
            String searchSymptomQuery2 = (String)request.getSession().getAttribute("searchSymptomQuery2");
            String searchSymptomQuery3 = (String)request.getSession().getAttribute("searchSymptomQuery3");
            String display = (String)request.getSession().getAttribute("display");
            request.getSession().setAttribute("searchSymptomQuery1", searchSymptomQuery1);
            request.getSession().setAttribute("searchSymptomQuery2", searchSymptomQuery2);
            request.getSession().setAttribute("searchSymptomQuery3", searchSymptomQuery3);
            request.getSession().setAttribute("display", display);
            RequestDispatcher rd=request.getRequestDispatcher("searchSymptom.jsp"); 
            rd.forward(request,response);
            //processRequest(request, response);
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
            out.print("<h1>Welcome to search Servlet from doPost</h1>"); 
            String searchSymptomQuery1 = (String)request.getSession().getAttribute("searchSymptomQuery1");
            String searchSymptomQuery2 = (String)request.getSession().getAttribute("searchSymptomQuery2");
            String searchSymptomQuery3 = (String)request.getSession().getAttribute("searchSymptomQuery3");
            String display = (String)request.getSession().getAttribute("display");
            request.getSession().setAttribute("searchSymptomQuery1", searchSymptomQuery1);
            request.getSession().setAttribute("searchSymptomQuery2", searchSymptomQuery2);
            request.getSession().setAttribute("searchSymptomQuery3", searchSymptomQuery3);
            request.getSession().setAttribute("display", display);
            RequestDispatcher rd=request.getRequestDispatcher("searchSymptom1.jsp"); 
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
