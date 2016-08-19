/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import java.util.ArrayList;
import com.fyp.swdrs.dal.owlNxml.UtilityDAL;
//import com.fyp.swdrs.dal.filing.UtilityDAL;
//import com.fyp.swdrs.dal.xml.UtilityDAL;

/**
 *
 * @author Admin
 */

public class UtilityHandler 
{
    public boolean populateList(ArrayList<String> list, String filename) 
    {
        UtilityDAL utilityDAL = new UtilityDAL();
        boolean success = utilityDAL.populateList(list, filename);
        return success;
    }
    public boolean populateDoctorList(ArrayList<String> list, String filename) 
    {
        UtilityDAL utilityDAL = new UtilityDAL();
        boolean success = utilityDAL.populateDoctorList(list, filename);
        return success;
    }
    public boolean retrieveFeedbackQuestions(ArrayList<String> list, String filename) 
    {
        UtilityDAL utilityDAL = new UtilityDAL();
        boolean success = utilityDAL.retrieveFeedbackQuestions(list, filename);
        return success;
    }
    
}
