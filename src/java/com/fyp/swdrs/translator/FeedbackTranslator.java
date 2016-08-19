/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.translator;

import com.fyp.swdrs.bo.Feedback;

/**
 *
 * @author Admin
 */

public class FeedbackTranslator 
{
    public Feedback feedbackInfoTranslator(Object patientName,Object doctorName, Object doctorRating, Object patientFeedback) 
    {
        Feedback feedback = new Feedback();
        feedback.setPatientName((String)patientName);
        feedback.setDoctorName((String)doctorName);
        feedback.setDoctorRating((String)doctorRating);
        feedback.setPatientFeedback((String)patientFeedback);
        return feedback;
    }
    public Feedback feedbackInfoTranslator(Object patientName, Object patientEmail, Object doctorName, Object doctorRating, Object patientFeedback, Object introduction1Answer, Object introduction2Answer, Object introduction3Answer, Object introduction4Answer, Object behavior1Answer, Object behavior2Answer, Object behavior3Answer, Object behavior4Answer, Object behavior5Answer, Object behavior6Answer, Object interaction1Answer, Object interaction2Answer, Object interaction3Answer, Object interaction4Answer, Object interaction5Answer, Object interaction6Answer, Object interaction7Answer, Object interaction8Answer, Object interaction9Answer, Object diagnosisTimeAnswer, Object scaleAnswer) 
    {
        Feedback feedback = new Feedback();
        feedback.setPatientName((String)patientName);
        feedback.setPatientEmail((String)patientEmail);
        feedback.setDoctorName((String)doctorName);
        feedback.setDoctorRating((String)doctorRating);
        feedback.setPatientFeedback((String)patientFeedback);
        feedback.setIntroduction1Answer((String)introduction1Answer);
        feedback.setIntroduction2Answer((String)introduction2Answer);
        feedback.setIntroduction3Answer((String)introduction3Answer);
        feedback.setIntroduction4Answer((String)introduction4Answer);
        feedback.setBehavior1Answer((String)behavior1Answer);
        feedback.setBehavior2Answer((String)behavior2Answer);
        feedback.setBehavior3Answer((String)behavior3Answer);
        feedback.setBehavior4Answer((String)behavior4Answer);
        feedback.setBehavior5Answer((String)behavior5Answer);
        feedback.setBehavior6Answer((String)behavior6Answer);
        feedback.setInteraction1Answer((String)interaction1Answer);
        feedback.setInteraction2Answer((String)interaction2Answer);
        feedback.setInteraction3Answer((String)interaction3Answer);
        feedback.setInteraction4Answer((String)interaction4Answer);
        feedback.setInteraction5Answer((String)interaction5Answer);
        feedback.setInteraction6Answer((String)interaction6Answer);
        feedback.setInteraction7Answer((String)interaction7Answer);
        feedback.setInteraction8Answer((String)interaction8Answer);
        feedback.setInteraction9Answer((String)interaction9Answer);
        feedback.setDiagnosisTimeAnswer((String)diagnosisTimeAnswer);
        feedback.setScaleAnswer((String)scaleAnswer);
        return feedback;
    }
    public Feedback feedbackInfoTranslator(Object patientName, Object patientEmail, Object doctorName, Object behavior1Answer, Object behavior2Answer, Object behavior3Answer, Object behavior4Answer, Object behavior5Answer, Object behavior6Answer, Object interaction1Answer, Object interaction2Answer, Object interaction3Answer, Object interaction4Answer, Object interaction5Answer, Object interaction6Answer, Object interaction7Answer, Object interaction8Answer, Object interaction9Answer, Object diagnosisTimeAnswer, Object scaleAnswer) 
    {
        Feedback feedback = new Feedback();
        feedback.setPatientName((String)patientName);
        feedback.setPatientEmail((String)patientEmail);
        feedback.setDoctorName((String)doctorName);
        feedback.setBehavior1Answer((String)behavior1Answer);
        feedback.setBehavior2Answer((String)behavior2Answer);
        feedback.setBehavior3Answer((String)behavior3Answer);
        feedback.setBehavior4Answer((String)behavior4Answer);
        feedback.setBehavior5Answer((String)behavior5Answer);
        feedback.setBehavior6Answer((String)behavior6Answer);
        feedback.setInteraction1Answer((String)interaction1Answer);
        feedback.setInteraction2Answer((String)interaction2Answer);
        feedback.setInteraction3Answer((String)interaction3Answer);
        feedback.setInteraction4Answer((String)interaction4Answer);
        feedback.setInteraction5Answer((String)interaction5Answer);
        feedback.setInteraction6Answer((String)interaction6Answer);
        feedback.setInteraction7Answer((String)interaction7Answer);
        feedback.setInteraction8Answer((String)interaction8Answer);
        feedback.setInteraction9Answer((String)interaction9Answer);
        feedback.setDiagnosisTimeAnswer((String)diagnosisTimeAnswer);
        feedback.setScaleAnswer((String)scaleAnswer);
        return feedback;
    }    
}
