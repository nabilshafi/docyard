/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

/**
 * @author Admin
 */

public class Location 
{
    private String city;
    private String country;
    private String area;
    
    public Location() { }
    
    public void setCity(String city)
    { 
        this.city = city ; 
    }
    public String getCity()
    { 
        return this.city ; 
    }

    public void setCountry(String country)
    { 
        this.country = country ; 
    }
    public String getCountry()
    { 
        return this.country ; 
    }

    public void setArea(String area)
    { 
        this.area = area ; 
    }
    public String getArea()
    { 
        return this.area ; 
    }
}
