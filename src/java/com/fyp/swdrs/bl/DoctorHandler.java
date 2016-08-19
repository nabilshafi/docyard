/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.dal.owlNxml.DoctorDAL;
//import com.fyp.swdrs.dal.filing.DoctorDAL;
//import com.fyp.swdrs.dal.xml.DoctorDAL;

/**
 *
 * @author Admin
 */

public class DoctorHandler extends FactoryHandler
{
    @Override
    public boolean createDoctor(Doctor doctor, String filename)
    {
        DoctorDAL doctorDAL = new DoctorDAL();
        boolean success = doctorDAL.createDoctor(doctor, filename);
        return success;
    }
    @Override
    public boolean viewDoctor(Doctor doctor, String filename)
    {
        DoctorDAL doctorDAL = new DoctorDAL();
        boolean success = doctorDAL.viewDoctor(doctor, filename);
        return success;
    }
    @Override
    public boolean updateDoctor(Doctor doctor, String filename)
    {
        DoctorDAL doctorDAL = new DoctorDAL();
        boolean success = doctorDAL.updateDoctor(doctor, filename);
        return success;
    }
    @Override
    public boolean deleteDoctor(Doctor doctor, String filename)
    {
        DoctorDAL doctorDAL = new DoctorDAL();
        boolean success = doctorDAL.deleteDoctor(doctor, filename);
        return success;
    }    
}