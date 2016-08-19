/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller.servlet;

import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.utility.Constants;
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

public class SearchSymptomServletSuccess extends HttpServlet 
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
            out.print("<h1>Welcome to searchsuccess Servlet from doGet</h1>"); 
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
            
            params[0] = ((Patient)request.getSession().getAttribute("patient")).getPatientProfile();
            params[1] = request.getParameter("searchSymptomQuery1");
            params[2] = request.getParameter("searchSymptomQuery2");
            params[3] = request.getParameter("searchSymptomQuery3");
            String display = (String)request.getSession().getAttribute("display");

//            out.println(((PatientProfile)params[0]).getName());
//            out.println(((String)params[1]));
//            out.println(((String)params[2]));
//            out.println(((String)params[3]));

            returnObj = controller.processRequest(Constants.searchDoctorBySymptomAction, params, filename);
            if(returnObj != null)
            {
                if(((String)returnObj[1]).equals("searchSymptom"))
                {// Search Result Success
                    ArrayList<DoctorProfile> doctorProfiles = (ArrayList<DoctorProfile>)returnObj[0];
                    if(doctorProfiles.size() > 0)
                    {
                        request.getSession().setAttribute("searchSymptomObj", returnObj[0]);
                        request.getSession().setAttribute("searchSymptomQuery1", params[1]);
                        request.getSession().setAttribute("searchSymptomQuery2", params[2]);
                        request.getSession().setAttribute("searchSymptomQuery3", params[3]);
                        request.getSession().setAttribute("display", display);
//                        RequestDispatcher rd=request.getRequestDispatcher("doctorProfileSearchSymptom.jsp");
                        RequestDispatcher rd=request.getRequestDispatcher("patientSimple2.jsp");
                        rd.forward(request,response);
                        processRequest(request, response);                    
                    }
                    else
                    {
//                        out.print("<h1>Sorry Search Query: " + (String)params[0] + " not found</h1>") ;   
                        response.sendRedirect("searchSymptomError");
//                        RequestDispatcher rd=request.getRequestDispatcher("patientSimple.jsp"); 
//                        rd.include(request,response);
//                        processRequest(request, response);
                    }
                }
            }
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
