/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.bo;

/**
 *
 * @author Admin
 */
public class Birth 
{
    private String dateOfBirth;
    private String day;
    private String month;
    private String year;
    private String age;
    //2015-01-01
    
    public Birth() { }
    
    public void setDateOfBirth(String dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth ;
    }
    public String getDateOfBirth() 
    {
        return this.dateOfBirth ; 
    }

    public void setDay(String day) 
    {
        this.day = day ;
    }
    public String getDay() 
    {
        return this.day ; 
    }

    public void setMonth(String month) 
    {
        this.month = month ;
    }
    public String getMonth() 
    {
        return this.month ; 
    }

    public void setYear(String year) 
    {
        this.year = year ;
    }
    public String getYear() 
    {
        return this.year ; 
    }

    public void setAge(String age) 
    {
        this.age = age ;
    }
    public String getAge() 
    {
        return this.age ; 
    }

    
}
