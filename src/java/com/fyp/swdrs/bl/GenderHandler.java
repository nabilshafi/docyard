/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.GenderDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class GenderHandler 
{
    public boolean createGender(String crudValue, String filename)
    {
        GenderDAL adminCrudDAL = new GenderDAL();
        boolean success = adminCrudDAL.createGender(crudValue, filename);
        return success;
    }
    
    public boolean viewGender(ArrayList<String> list, String filename)
    {
        GenderDAL adminCrudDAL = new GenderDAL();
        boolean success = adminCrudDAL.viewGender(list, filename);
        return success;
    }
    
    public boolean updateGender(ArrayList<String> list, String filename)
    {
        GenderDAL adminCrudDAL = new GenderDAL();
        boolean success = adminCrudDAL.updateGender(list, filename);
        return success;
    }
    
    public boolean deleteGender(String crudValue, String filename)
    {
        GenderDAL adminCrudDAL = new GenderDAL();
        boolean success = adminCrudDAL.deleteGender(crudValue, filename);
        return success;
    }
}
