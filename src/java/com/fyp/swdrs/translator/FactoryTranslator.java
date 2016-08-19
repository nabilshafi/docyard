/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.translator;

/**
 * @author Zohaib Masood (CS-121054)
 */

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;

public abstract class FactoryTranslator
{
    public Admin adminLoginInfoTranslator(Object email, Object password) 
    { return null; }
    public Admin adminInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    { return null; }
    public AdminProfile adminProfileTranslator(Object name, Object email)
    { return null; }
    public AdminProfile adminProfileInfoTranslator(Object name, Object email, Object contact) 
    { return null; }
    public AdminProfile adminProfileInfoTranslator(Object id, Object name, Object email, Object contact) 
    { return null; }
    public Admin adminTranslator(Object name, Object email)
    { return null; }

    public Doctor doctorLoginInfoTranslator(Object email, Object password) 
    { return null; }
    public Doctor doctorInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    { return null; }
    public DoctorProfile doctorProfileTranslator(Object name, Object email)
    { return null; }
    public DoctorProfile doctorProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object visitingHours2, Object feeStructure, Object city, Object country, Object area)
//    public DoctorProfile doctorProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object feeStructure, Object city, Object country, Object area)
    { return null; }
    public DoctorProfile doctorProfileInfoTranslator(Object id, Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object visitingHours2, Object feeStructure, Object city, Object country, Object area)
    { return null; }
    public Doctor doctorTranslator(Object name, Object email)
    { return null; }

    public Patient patientLoginInfoTranslator(Object email, Object password) 
    { return null; }
    public Patient patientInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    { return null; }
    public PatientProfile patientProfileTranslator(Object name, Object email)
    { return null; }
    public PatientProfile patientProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object incomeGroup, Object city, Object country, Object area)
    { return null; }
    public PatientProfile patientProfileInfoTranslator(Object id, Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object incomeGroup, Object city, Object country, Object area)
    { return null; }
    public Patient patientTranslator(Object name, Object email)
    { return null; }
}