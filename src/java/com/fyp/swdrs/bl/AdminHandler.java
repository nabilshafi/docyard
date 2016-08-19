/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.dal.owlNxml.AdminDAL;
//import com.fyp.swdrs.dal.filing.AdminDAL;
//import com.fyp.swdrs.dal.xml.AdminDAL;

/**
 *
 * @author Admin
 */

public class AdminHandler extends FactoryHandler
{
    @Override
    public boolean createAdmin(Admin admin, String filename)
    {
        AdminDAL adminDAL = new AdminDAL();
        boolean success = adminDAL.createAdmin(admin, filename);
        return success;
    }
    @Override
    public boolean viewAdmin(Admin admin, String filename)
    {
        AdminDAL adminDAL = new AdminDAL();
        boolean success = adminDAL.viewAdmin(admin, filename);
        return success;
    }
    @Override
    public boolean updateAdmin(Admin admin, String filename)
    {
        AdminDAL adminDAL = new AdminDAL();
        boolean success = adminDAL.updateAdmin(admin, filename);
        return success;
    }
    @Override
    public boolean deleteAdmin(Admin admin, String filename)
    {
        AdminDAL adminDAL = new AdminDAL();
        boolean success = adminDAL.deleteAdmin(admin, filename);
        return success;
    }
}