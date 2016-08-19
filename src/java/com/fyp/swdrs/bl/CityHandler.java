/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.CityDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class CityHandler
{
    public boolean createCity(String crudValue, String filename)
    {
        CityDAL adminCrudDAL = new CityDAL();
        boolean success = adminCrudDAL.createCity(crudValue, filename);
        return success;
    }
    
    public boolean viewCity(ArrayList<String> list, String filename)
    {
        CityDAL adminCrudDAL = new CityDAL();
        boolean success = adminCrudDAL.viewCity(list, filename);
        return success;
    }
    
    public boolean updateCity(ArrayList<String> list, String filename)
    {
        CityDAL adminCrudDAL = new CityDAL();
        boolean success = adminCrudDAL.updateCity(list, filename);
        return success;
    }
    
    public boolean deleteCity(String crudValue, String filename)
    {
        CityDAL adminCrudDAL = new CityDAL();
        boolean success = adminCrudDAL.deleteCity(crudValue, filename);
        return success;
    }
}
