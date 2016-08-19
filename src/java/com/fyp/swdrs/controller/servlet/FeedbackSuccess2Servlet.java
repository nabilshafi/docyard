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

public class FeedbackSuccess2Servlet extends HttpServlet
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
//            out.print("<h1>Welcome to feedbacksuccess Servlet from doPost</h1>"); 
            String filename = request.getServletContext().getRealPath("/");
            Patient patient = (Patient)request.getSession().getAttribute("patient");
            Controller controller = new Controller();
            Object[] returnObj = null;

            Object[] params = (Object[])request.getSession().getAttribute("paramsObjFeedback");
//            params[0] = request.getParameter("patientName");
//            params[1] = request.getParameter("patientEmail");
//            params[2] = request.getParameter("doctorName");
//            params[3] = request.getParameter("rating");
//            params[3] = request.getParameter("feedbackTextArea");
//            params[4] = request.getParameter("introduction1Answer");
//            params[5] = request.getParameter("introduction2Answer");
//            params[6] = request.getParameter("introduction3Answer");
//            params[7] = request.getParameter("introduction4Answer");
            params[3] = request.getParameter("behaviour1Answer");
            params[4] = request.getParameter("behaviour2Answer");
            params[5] = request.getParameter("behaviour3Answer");
            params[6] = request.getParameter("behaviour4Answer");
            params[7] = request.getParameter("behaviour5Answer");
            params[8] = request.getParameter("behaviour6Answer");
            params[9] = request.getParameter("interaction1Answer");
            params[10] = request.getParameter("interaction2Answer");
            params[11] = request.getParameter("interaction3Answer");
            params[12] = request.getParameter("interaction4Answer");
            params[13] = request.getParameter("interaction5Answer");
            params[14] = request.getParameter("interaction6Answer");
            params[15] = request.getParameter("interaction7Answer");
            params[16] = request.getParameter("interaction8Answer");
            params[17] = request.getParameter("interaction9Answer");
            params[18] = request.getParameter("diagnosisTimeAnswer");
            params[19] = request.getParameter("scaleAnswer");
//            for (int i = 0; i < 20; i++) {
//                out.println("<h4>" + params[i] + "</h4>");
//            }
            
            returnObj = controller.processRequest(Constants.createFeedbackAction, params, filename);
            if(returnObj != null)
            {
                if(((String)returnObj[1]).equals("feedback"))
                {// Search Result Success
                    Feedback feedback = (Feedback)returnObj[0];

                    PatientProfile patientProfile = patient.getPatientProfile();
                    patientProfile.setFeedback(feedback);
                    patient.setPatientProfile(patientProfile);
//                    out.println(feedback.getDoctorRating());
//                    out.print("<br><br><h4>Patient having name: " + feedback.getPatientName()+  " gave feedback rating: " + feedback.getDoctorRating()+ ", against a doctor having name " + feedback.getDoctorName() + ".</h4>");
                    request.getSession().setAttribute("patient", patient);
                    out.println("<body onload=\"myFunction()\">");
                    out.println("</body>");
                    out.println("<script>function myFunction() {alert(\"Feedback submitted Successfully!\");}</script>");
                    RequestDispatcher rd=request.getRequestDispatcher("patientHome.jsp"); 
                    rd.include(request,response);
                }
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
