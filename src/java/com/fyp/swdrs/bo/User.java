/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bo;

/**
 * @author Zohaib Masood (CS-121054)
 */

public abstract class User 
{
    private String name ;
    private String email ;
    private String password ;
    private String userCategory ;
    private int userHasProfile ;

    public void setName(String name) 
    {
        return;
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

    public void setPassword(String password) 
    {
        this.password = password ; 
    }
    public String getPassword() 
    {
        return this.password ; 
    }
    
    public void setUserCategory(String userCategory) 
    {
        this.userCategory = userCategory ; 
    }
    public String getUserCategory() 
    {
        return this.userCategory ; 
    }
    
    public void setUserHasProfile(int userHasProfile) 
    {
        this.userHasProfile = userHasProfile ; 
    }
    public int getUserHasProfile() 
    {
        return this.userHasProfile ; 
    }
}
