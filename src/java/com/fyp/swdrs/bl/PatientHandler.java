/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.dal.owlNxml.PatientDAL;
//import com.fyp.swdrs.dal.filing.PatientDAL;
//import com.fyp.swdrs.dal.xml.PatientDAL;

/**
 *
 * @author Admin
 */

public class PatientHandler extends FactoryHandler
{
    @Override
    public boolean createPatient(Patient patient, String filename)
    {
        PatientDAL patientDAL = new PatientDAL();
        boolean success = patientDAL.createPatient(patient, filename);
        return success;
    }
    @Override
    public boolean viewPatient(Patient patient, String filename)
    {
        PatientDAL patientDAL = new PatientDAL();
        boolean success = patientDAL.viewPatient(patient, filename);
        return success;
    }
    @Override
    public boolean updatePatient(Patient patient, String filename)
    {
        PatientDAL patientDAL = new PatientDAL();
        boolean success = patientDAL.updatePatient(patient, filename);
        return success;
    }
    @Override
    public boolean deletePatient(Patient patient, String filename)
    {
        PatientDAL patientDAL = new PatientDAL();
        boolean success = patientDAL.deletePatient(patient, filename);
        return success;
    }
}