/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.dal.owlNxml.LoginDAL;
//import com.fyp.swdrs.dal.filing.LoginDAL;
//import com.fyp.swdrs.dal.xml.LoginDAL;

/**
 *
 * @author Admin
 */

public class LoginHandler extends FactoryHandler
{
    @Override
    public boolean verifyAdminLogin(Admin admin, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.verifyAdminLogin(admin, filename);
        return success;
    }
    @Override
    public boolean changeAdminPassword(Admin admin, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.changeAdminPassword(admin, filename);
        return success;
    }

    @Override
    public boolean verifyDoctorLogin(Doctor doctor, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.verifyDoctorLogin(doctor, filename);
        return success;
    }
    @Override
    public boolean changeDoctorPassword(Doctor doctor, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.changeDoctorPassword(doctor, filename);
        return success;
    }

    @Override
    public boolean verifyPatientLogin(Patient patient, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.verifyPatientLogin(patient, filename);
        return success;
    }
    @Override
    public boolean changePatientPassword(Patient patient, String filename)
    {
        LoginDAL loginDAL = new LoginDAL();
        boolean success = loginDAL.changePatientPassword(patient, filename);
        return success;
    }

}
