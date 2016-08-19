/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import java.util.ArrayList;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.dal.owlNxml.DoctorProfileDAL;
//import com.fyp.swdrs.dal.filing.DoctorProfileDAL;
//import com.fyp.swdrs.dal.xml.DoctorProfileDAL;

/**
 *
 * @author Admin
 */

public class DoctorProfileHandler extends FactoryHandler
{
    @Override
    public boolean createDoctorProfile(DoctorProfile doctorProfile, String filename)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.createDoctorProfile(doctorProfile, filename);
        return success;
    }
    @Override
    public boolean viewDoctorProfile(DoctorProfile doctorProfile, String filename)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.viewDoctorProfile(doctorProfile, filename);
        return success;
    }
    @Override
    public boolean updateDoctorProfile(DoctorProfile doctorProfile, String filename)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.updateDoctorProfile(doctorProfile, filename);
        return success;
    }
    @Override
    public boolean deleteDoctorProfile(DoctorProfile doctorProfile, String filename)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.deleteDoctorProfile(doctorProfile, filename);
        return success;
    }

    public boolean viewDoctorProfile1(Doctor doctor, String filename, ArrayList<DoctorProfile> drProfile)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.viewDoctorProfile1(doctor, filename, drProfile);
        return success;
    }
    public boolean updateDoctorProfile1(DoctorProfile doctorProfile, String filename, int profileNumber)
    {
        DoctorProfileDAL doctorProfileDAL = new DoctorProfileDAL();
        boolean success = doctorProfileDAL.updateDoctorProfile1(doctorProfile, filename, profileNumber);
        return success;
    }
}