/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

/**
 * @author Zohaib Masood (CS-121054)
 */

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;

public abstract class FactoryHandler 
{
    public FactoryHandler() { }
    
    public boolean verifyAdminLogin(Admin admin, String filename) 
    { return true; }
    public boolean changeAdminPassword(Admin admin, String filename) 
    { return true; }

    public boolean verifyDoctorLogin(Doctor doctor, String filename) 
    { return true; }
    public boolean changeDoctorPassword(Doctor doctor, String filename) 
    { return true; }
    
    public boolean verifyPatientLogin(Patient patient, String filename) 
    { return true; }
    public boolean changePatientPassword(Patient patient, String filename)
    { return true; }
 
    public boolean createAdmin(Admin admin, String filename)
    { return true; }
    public boolean viewAdmin(Admin admin, String filename) 
    { return true; }
    public boolean updateAdmin(Admin admin, String filename) 
    { return true; }
    public boolean deleteAdmin(Admin admin, String filename) 
    { return true; }

    public boolean createDoctor(Doctor doctor, String filename)
    { return true; }
    public boolean viewDoctor(Doctor doctor, String filename) 
    { return true; }
    public boolean updateDoctor(Doctor doctor, String filename) 
    { return true; }
    public boolean deleteDoctor(Doctor doctor, String filename) 
    { return true; }
    
    public boolean createPatient(Patient patient, String filename) 
    { return true; }
    public boolean viewPatient(Patient patient, String filename) 
    { return true; }
    public boolean updatePatient(Patient patient, String filename) 
    { return true; }
    public boolean deletePatient(Patient patient, String filename) 
    { return true; }
 
    public boolean createAdminProfile(AdminProfile adminProfile, String filename) 
    { return true; }
    public boolean viewAdminProfile(AdminProfile adminProfile, String filename) 
    { return true; }
    public boolean updateAdminProfile(AdminProfile adminProfile, String filename) 
    { return true; }
    public boolean deleteAdminProfile(AdminProfile adminProfile, String filename) 
    { return true; }
    
    public boolean createDoctorProfile(DoctorProfile doctorProfile, String filename) 
    { return true; }
    public boolean viewDoctorProfile(DoctorProfile doctorProfile, String filename) 
    { return true; }
    public boolean updateDoctorProfile(DoctorProfile doctorProfile, String filename)
    { return true; }
    public boolean deleteDoctorProfile(DoctorProfile doctorProfile, String filename) 
    { return true; }
    
    public boolean createPatientProfile(PatientProfile patientProfile, String filename)
    { return true; }
    public boolean viewPatientProfile(PatientProfile patientProfile, String filename)
    { return true; }
    public boolean updatePatientProfile(PatientProfile patientProfile, String filename)
    { return true; }
    public boolean deletePatientProfile(PatientProfile patientProfile, String filename) 
    { return true; }
}