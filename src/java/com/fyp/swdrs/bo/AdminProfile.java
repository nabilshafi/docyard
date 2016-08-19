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
public class AdminProfile 
{
    private String id ;
    private String name ;
    private String email ;
    private String contact ;
        
    public AdminProfile() { }

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
}