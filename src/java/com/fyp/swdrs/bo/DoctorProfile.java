/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class DoctorProfile 
{
    private String id;
    
    private String name;
    private String email;

    private String contact;
    private String dateOfBirth;
    private String gender;
    
    private Specialization specialization;
    private Hospital hospital;
    
    private int feedbackRating;
    private double systemRating;
    
    private ArrayList<Feedback> feedbacks;

    public DoctorProfile() { }
    
    public void setId(String id)
    { 
        this.id = id ; 
    }
    public String getId()
    { 
        return this.id ; 
    }

    public void setName(String name)
    { 
        this.name = name ; 
    }
    public String getName()
    { 
        return this.name ; 
    }

    public void setEmail(String email)
    { 
        this.email = email ; 
    }
    public String getEmail()
    { 
        return this.email ; 
    }

    public void setContact(String contact) 
    {
        this.contact = contact ;
    }
    public String getContact() 
    {
        return this.contact ; 
    }

    public void setDateOfBirth(String dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth ;
    }
    public String getDateOfBirth() 
    {
        return this.dateOfBirth ; 
    }

    public void setGender(String gender)
    { 
        this.gender = gender ; 
    }
    public String getGender()
    { 
        return this.gender ; 
    }

    public void setSpecialization(Specialization specialization)
    {
        this.specialization = specialization;
    }
    public Specialization getSpecialization()
    {
        return this.specialization;
    }
    
    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
    }
    public Hospital getHospital()
    {
        return this.hospital;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks)
    {
        this.feedbacks = feedbacks;
    }
    public ArrayList<Feedback> getFeedbacks()
    {
        return this.feedbacks;
    }

    public void setFeedbackRating(int feedbackRating)
    { 
        this.feedbackRating = feedbackRating ; 
    }
    public int getFeedbackRating()
    { 
        return this.feedbackRating ; 
    }

    public void setSystemRating(double systemRating)
    { 
        this.systemRating = systemRating ; 
    }
    public double getSystemRating()
    { 
        return this.systemRating ; 
    }
}