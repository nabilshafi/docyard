/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.SpecialtiesDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class SpecialtiesHandler
{
    public boolean createSpecialties(String crudValue, String filename)
    {
        SpecialtiesDAL adminCrudDAL = new SpecialtiesDAL();
        boolean success = adminCrudDAL.createSpecialties(crudValue, filename);
        return success;
    }
    
    public boolean viewSpecialties(ArrayList<String> list, String filename)
    {
        SpecialtiesDAL adminCrudDAL = new SpecialtiesDAL();
        boolean success = adminCrudDAL.viewSpecialties(list, filename);
        return success;
    }
    
    public boolean updateSpecialties(ArrayList<String> list, String filename)
    {
        SpecialtiesDAL adminCrudDAL = new SpecialtiesDAL();
        boolean success = adminCrudDAL.updateSpecialties(list, filename);
        return success;
    }
    
    public boolean deleteSpecialties(String crudValue, String filename)
    {
        SpecialtiesDAL adminCrudDAL = new SpecialtiesDAL();
        boolean success = adminCrudDAL.deleteSpecialties(crudValue, filename);
        return success;
    }
}
