/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.dal.owlNxml.AdminProfileDAL;
//import com.fyp.swdrs.dal.filing.AdminProfileDAL;
//import com.fyp.swdrs.dal.xml.AdminProfileDAL;

/**
 *
 * @author Admin
 */

public class AdminProfileHandler extends FactoryHandler
{
    @Override
    public boolean createAdminProfile(AdminProfile adminProfile, String filename)
    {
        AdminProfileDAL adminProfileDAL = new AdminProfileDAL();
        boolean success = adminProfileDAL.createAdminProfile(adminProfile, filename);
        return success;
    }
    @Override
    public boolean viewAdminProfile(AdminProfile adminProfile, String filename)
    {
        AdminProfileDAL adminProfileDAL = new AdminProfileDAL();
        boolean success = adminProfileDAL.viewAdminProfile(adminProfile, filename);
        return success;
    }
    @Override
    public boolean updateAdminProfile(AdminProfile adminProfile, String filename)
    {
        AdminProfileDAL adminProfileDAL = new AdminProfileDAL();
        boolean success = adminProfileDAL.updateAdminProfile(adminProfile, filename);
        return success;
    }
    @Override
    public boolean deleteAdminProfile(AdminProfile adminProfile, String filename)
    {
        AdminProfileDAL adminProfileDAL = new AdminProfileDAL();
        boolean success = adminProfileDAL.deleteAdminProfile(adminProfile, filename);
        return success;
    }
}