/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

/**
 * @author Admin
 */

public class Hospital 
{
    private String hospitalName;
    private String days;
    private String visitingHours;
    private String visitingHours2;
    private String feeStructure;

    private Location location;
    
    public Hospital() { }
    
    public void setHospitalName(String hospitalName)
    { 
        this.hospitalName = hospitalName ; 
    }
    public String getHospitalName()
    { 
        return this.hospitalName ; 
    }

    public void setDays(String days)
    { 
        this.days = days ; 
    }
    public String getDays()
    { 
        return this.days ; 
    }

    public void setVisitingHours(String visitingHours)
    { 
        this.visitingHours = visitingHours ; 
    }
    public String getVisitingHours()
    { 
        return this.visitingHours ; 
    }

    public void setVisitingHours2(String visitingHours2)
    { 
        this.visitingHours2 = visitingHours2 ; 
    }
    public String getVisitingHours2()
    { 
        return this.visitingHours2 ; 
    }

    public void setFeeStructure(String feeStructure)
    { 
        this.feeStructure = feeStructure ; 
    }
    public String getFeeStructure()
    { 
        return this.feeStructure ; 
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }
    public Location getLocation()
    {
        return this.location;
    }
}
