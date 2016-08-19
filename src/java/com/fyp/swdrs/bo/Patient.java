/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

/**
 * @author Zohaib Masood (CS-121054)
 */

public class Patient extends User
{
    private String name ;
    private String email ;
    private String password ;
    private String userCategory ;
    private int userHasProfile ;

    private PatientProfile patientProfile ;

    public Patient() { }

    @Override
    public void setName(String name)
    { 
        this.name = name ; 
    }
    @Override
    public String getName() 
    { 
        return this.name ; 
    }

    @Override
    public void setEmail(String email) 
    {
        this.email = email ; 
    }
    @Override
    public String getEmail() 
    {
        return this.email ; 
    }
    
    @Override
    public void setPassword(String password) 
    {
        this.password = password ; 
    }
    @Override
    public String getPassword() 
    {
        return this.password ; 
    }

    @Override
    public void setUserCategory(String userCategory) 
    {
        this.userCategory = userCategory ; 
    }
    @Override
    public String getUserCategory() 
    {
        return this.userCategory ; 
    }

    @Override
    public void setUserHasProfile(int userHasProfile) 
    {
        this.userHasProfile = userHasProfile ; 
    }
    @Override
    public int getUserHasProfile() 
    {
        return this.userHasProfile ; 
    }

    public void setPatientProfile(PatientProfile patientProfile) 
    {
        this.patientProfile = patientProfile ; 
    }
    public PatientProfile getPatientProfile() 
    {
        return this.patientProfile ; 
    }

}