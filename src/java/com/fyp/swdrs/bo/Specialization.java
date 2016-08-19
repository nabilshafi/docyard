/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

/**
 * @author Admin
 */

public class Specialization 
{
    private String degree;
    private String specialist;
    private String specialties;

    public Specialization() { }

    public void setDegree(String degree)
    { 
        this.degree = degree ; 
    }
    public String getDegree()
    { 
        return this.degree ; 
    }

    public void setSpecialist(String specialist)
    { 
        this.specialist = specialist ; 
    }
    public String getSpecialist()
    { 
        return this.specialist ; 
    }
    
    public void setSpecialties(String specialties)
    { 
        this.specialties = specialties ; 
    }
    public String getSpecialties()
    { 
        return this.specialties ; 
    }
}
