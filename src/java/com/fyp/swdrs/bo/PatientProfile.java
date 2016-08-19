/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.bo;

/**
 * @author Zohaib Masood (CS-121054)
 */

public class PatientProfile 
{
    private String id;
    private String name;
    private String email;
    private String contact;
    private String dateOfBirth;
    private String gender;
    private String incomeGroup;
    private Location location;
    
    private Feedback feedback;
    
    public PatientProfile() { }
    
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

    public void setIncomeGroup(String incomeGroup)
    { 
        this.incomeGroup = incomeGroup ; 
    }
    public String getIncomeGroup()
    { 
        return this.incomeGroup ; 
    }

    public void setLocation(Location location)
    { 
        this.location = location ; 
    }
    public Location getLocation()
    { 
        return this.location ; 
    }

    public void setFeedback(Feedback feedback)
    { 
        this.feedback = feedback ; 
    }
    public Feedback getFeedback()
    { 
        return this.feedback ; 
    }
}