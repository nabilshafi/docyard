/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.DiseaseDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class DiseaseHandler
{
    public boolean createDisease(String crudValue, String filename)
    {
        DiseaseDAL adminCrudDAL = new DiseaseDAL();
        boolean success = adminCrudDAL.createDisease(crudValue, filename);
        return success;
    }
    
    public boolean viewDisease(ArrayList<String> list, String filename)
    {
        DiseaseDAL adminCrudDAL = new DiseaseDAL();
        boolean success = adminCrudDAL.viewDisease(list, filename);
        return success;
    }
    
    public boolean updateDisease(ArrayList<String> list, String filename)
    {
        DiseaseDAL adminCrudDAL = new DiseaseDAL();
        boolean success = adminCrudDAL.updateDisease(list, filename);
        return success;
    }
    
    public boolean deleteDisease(String crudValue, String filename)
    {
        DiseaseDAL adminCrudDAL = new DiseaseDAL();
        boolean success = adminCrudDAL.deleteDisease(crudValue, filename);
        return success;
    }
}
