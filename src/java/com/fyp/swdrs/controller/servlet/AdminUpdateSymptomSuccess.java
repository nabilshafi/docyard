/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
import com.fyp.swdrs.utility.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author liban
 */

public class AdminUpdateSymptomSuccess extends HttpServlet 
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
            out.print("<h1>Welcome to adminUpdateSymptom Servlet from doGet</h1>"); 
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
//            out.print("<h1>Welcome to adminUpdateSymptomSuccess Servlet from doPost</h1>"); 
//            processRequest(request, response);
            String filename = request.getServletContext().getRealPath("/");
            ArrayList<String> list = (ArrayList<String>)request.getSession().getAttribute("symptomList");
            ArrayList<String> newList = new ArrayList();
            for(int i=0; i<list.size(); i++) { newList.add(request.getParameter("symptomTxt" + Integer.toString(i))); }
            Controller controller = new Controller();
            Object[] returnObj = null;
            Object[] params = new Object[1];
            params[0] = newList;
//            out.println((String)params[0]);

            returnObj = controller.processRequest(Constants.updateSymptomAction, params, filename);
            if(returnObj != null)
            {
                if(((String)returnObj[0]).equals("symptom"))
                {// Search Result Success
                    ArrayList<String> list2 = Utility.viewSymptom(filename);
                    request.getSession().setAttribute("symptomList", list2);
                    out.println("<body onload=\"myFunction()\">");
                    out.println("</body>");
                    out.println("<script>function myFunction() {alert(\"Symptoms updated Successfully!\");}</script>");
                    RequestDispatcher rd=request.getRequestDispatcher("adminCreate9.jsp"); 
                    rd.forward(request,response);
                }
                else
                {
                    out.print("<h1>Sorry</h1>") ;   
//                    response.sendRedirect("searchSymptomError");
//                    RequestDispatcher rd=request.getRequestDispatcher("patientSimple.jsp"); 
//                    rd.include(request,response);
//                    processRequest(request, response);
                }
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
