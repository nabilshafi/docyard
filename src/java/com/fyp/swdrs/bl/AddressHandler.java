/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.AddressDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class AddressHandler
{
    public boolean createAddress(String crudValue, String filename)
    {
        AddressDAL adminCrudDAL = new AddressDAL();
        boolean success = adminCrudDAL.createAddress(crudValue, filename);
        return success;
    }
    
    public boolean viewAddress(ArrayList<String> list, String filename)
    {
        AddressDAL adminCrudDAL = new AddressDAL();
        boolean success = adminCrudDAL.viewAddress(list, filename);
        return success;
    }
    
    public boolean updateAddress(ArrayList<String> list, String filename)
    {
        AddressDAL adminCrudDAL = new AddressDAL();
        boolean success = adminCrudDAL.updateAddress(list, filename);
        return success;
    }
    
    public boolean deleteAddress(String crudValue, String filename)
    {
        AddressDAL adminCrudDAL = new AddressDAL();
        boolean success = adminCrudDAL.deleteAddress(crudValue, filename);
        return success;
    }
}
