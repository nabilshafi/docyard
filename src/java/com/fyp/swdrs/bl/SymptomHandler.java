/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.SymptomDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class SymptomHandler
{
    public boolean createSymptom(String crudValue, String filename)
    {
        SymptomDAL adminCrudDAL = new SymptomDAL();
        boolean success = adminCrudDAL.createSymptom(crudValue, filename);
        return success;
    }
    
    public boolean viewSymptom(ArrayList<String> list, String filename)
    {
        SymptomDAL adminCrudDAL = new SymptomDAL();
        boolean success = adminCrudDAL.viewSymptom(list, filename);
        return success;
    }
    
    public boolean updateSymptom(ArrayList<String> list, String filename)
    {
        SymptomDAL adminCrudDAL = new SymptomDAL();
        boolean success = adminCrudDAL.updateSymptom(list, filename);
        return success;
    }
    
    public boolean deleteSymptom(String crudValue, String filename)
    {
        SymptomDAL adminCrudDAL = new SymptomDAL();
        boolean success = adminCrudDAL.deleteSymptom(crudValue, filename);
        return success;
    }
}
