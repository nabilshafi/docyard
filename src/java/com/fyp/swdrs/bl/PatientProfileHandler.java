/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.dal.owlNxml.PatientProfileDAL;
//import com.fyp.swdrs.dal.filing.PatientProfileDAL;
//import com.fyp.swdrs.dal.xml.PatientProfileDAL;

/**
 *
 * @author Admin
 */

public class PatientProfileHandler extends FactoryHandler 
{
    @Override
    public boolean createPatientProfile(PatientProfile patientProfile, String filename)
    {
        PatientProfileDAL patientProfileDAL = new PatientProfileDAL();
        boolean success = patientProfileDAL.createPatientProfile(patientProfile, filename);
        return success;
    }
    @Override
    public boolean viewPatientProfile(PatientProfile patientProfile, String filename)
    {
        PatientProfileDAL patientProfileDAL = new PatientProfileDAL();
        boolean success = patientProfileDAL.viewPatientProfile(patientProfile, filename);
        return success;
    }
    @Override
    public boolean updatePatientProfile(PatientProfile patientProfile, String filename)
    {
        PatientProfileDAL patientProfileDAL = new PatientProfileDAL();
        boolean success = patientProfileDAL.updatePatientProfile(patientProfile, filename);
        return success;
    }
    @Override
    public boolean deletePatientProfile(PatientProfile patientProfile, String filename)
    {
        PatientProfileDAL patientProfileDAL = new PatientProfileDAL();
        boolean success = patientProfileDAL.deletePatientProfile(patientProfile, filename);
        return success;
    }
}