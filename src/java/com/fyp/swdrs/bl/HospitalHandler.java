/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.HospitalDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class HospitalHandler 
{
    public boolean createHospital(String crudValue, String filename)
    {
        HospitalDAL adminCrudDAL = new HospitalDAL();
        boolean success = adminCrudDAL.createHospital(crudValue, filename);
        return success;
    }
    
    public boolean viewHospital(ArrayList<String> list, String filename)
    {
        HospitalDAL adminCrudDAL = new HospitalDAL();
        boolean success = adminCrudDAL.viewHospital(list, filename);
        return success;
    }
    
    public boolean updateHospital(ArrayList<String> list, String filename)
    {
        HospitalDAL adminCrudDAL = new HospitalDAL();
        boolean success = adminCrudDAL.updateHospital(list, filename);
        return success;
    }
    
    public boolean deleteHospital(String crudValue, String filename)
    {
        HospitalDAL adminCrudDAL = new HospitalDAL();
        boolean success = adminCrudDAL.deleteHospital(crudValue, filename);
        return success;
    }
}
