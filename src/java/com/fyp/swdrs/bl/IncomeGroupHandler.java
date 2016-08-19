/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.IncomeGroupDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class IncomeGroupHandler
{
    public boolean createIncomeGroup(String crudValue, String filename)
    {
        IncomeGroupDAL adminCrudDAL = new IncomeGroupDAL();
        boolean success = adminCrudDAL.createIncomeGroup(crudValue, filename);
        return success;
    }
    
    public boolean viewIncomeGroup(ArrayList<String> list, String filename)
    {
        IncomeGroupDAL adminCrudDAL = new IncomeGroupDAL();
        boolean success = adminCrudDAL.viewIncomeGroup(list, filename);
        return success;
    }
    
    public boolean updateIncomeGroup(ArrayList<String> list, String filename)
    {
        IncomeGroupDAL adminCrudDAL = new IncomeGroupDAL();
        boolean success = adminCrudDAL.updateIncomeGroup(list, filename);
        return success;
    }
    
    public boolean deleteIncomeGroup(String crudValue, String filename)
    {
        IncomeGroupDAL adminCrudDAL = new IncomeGroupDAL();
        boolean success = adminCrudDAL.deleteIncomeGroup(crudValue, filename);
        return success;
    }
}
