/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.DaysDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class DaysHandler
{
    public boolean createDays(String crudValue, String filename)
    {
        DaysDAL adminCrudDAL = new DaysDAL();
        boolean success = adminCrudDAL.createDays(crudValue, filename);
        return success;
    }
    
    public boolean viewDays(ArrayList<String> list, String filename)
    {
        DaysDAL adminCrudDAL = new DaysDAL();
        boolean success = adminCrudDAL.viewDays(list, filename);
        return success;
    }
    
    public boolean updateDays(ArrayList<String> list, String filename)
    {
        DaysDAL adminCrudDAL = new DaysDAL();
        boolean success = adminCrudDAL.updateDays(list, filename);
        return success;
    }
    
    public boolean deleteDays(String crudValue, String filename)
    {
        DaysDAL adminCrudDAL = new DaysDAL();
        boolean success = adminCrudDAL.deleteDays(crudValue, filename);
        return success;
    }
}
