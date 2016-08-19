/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.AreaDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class AreaHandler
{
    public boolean createArea(String crudValue, String filename)
    {
        AreaDAL adminCrudDAL = new AreaDAL();
        boolean success = adminCrudDAL.createArea(crudValue, filename);
        return success;
    }
    
    public boolean viewArea(ArrayList<String> list, String filename)
    {
        AreaDAL adminCrudDAL = new AreaDAL();
        boolean success = adminCrudDAL.viewArea(list, filename);
        return success;
    }
    
    public boolean updateArea(ArrayList<String> list, String filename)
    {
        AreaDAL adminCrudDAL = new AreaDAL();
        boolean success = adminCrudDAL.updateArea(list, filename);
        return success;
    }
    
    public boolean deleteArea(String crudValue, String filename)
    {
        AreaDAL adminCrudDAL = new AreaDAL();
        boolean success = adminCrudDAL.deleteArea(crudValue, filename);
        return success;
    }
}
