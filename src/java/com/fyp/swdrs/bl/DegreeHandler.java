/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.DegreeDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class DegreeHandler
{
    public boolean createDegree(String crudValue, String filename)
    {
        DegreeDAL adminCrudDAL = new DegreeDAL();
        boolean success = adminCrudDAL.createDegree(crudValue, filename);
        return success;
    }
    
    public boolean viewDegree(ArrayList<String> list, String filename)
    {
        DegreeDAL adminCrudDAL = new DegreeDAL();
        boolean success = adminCrudDAL.viewDegree(list, filename);
        return success;
    }
    
    public boolean updateDegree(ArrayList<String> list, String filename)
    {
        DegreeDAL adminCrudDAL = new DegreeDAL();
        boolean success = adminCrudDAL.updateDegree(list, filename);
        return success;
    }
    
    public boolean deleteDegree(String crudValue, String filename)
    {
        DegreeDAL adminCrudDAL = new DegreeDAL();
        boolean success = adminCrudDAL.deleteDegree(crudValue, filename);
        return success;
    }
}
