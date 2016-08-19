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
import com.fyp.swdrs.bo.Hospital;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.bo.Specialization;

public class UsersTranslator extends FactoryTranslator
{
    @Override
    public Admin adminLoginInfoTranslator(Object email, Object password) 
    {
        Admin admin = new Admin();
        admin.setEmail((String)email);
        admin.setPassword((String)password);
        return admin;
    }
    @Override
    public Admin adminInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    {
        Admin admin = new Admin();
        admin.setName((String)name);
        admin.setEmail((String)email);
        admin.setPassword((String)password);
        admin.setUserCategory((String)userCategory);
        return admin;
    }
    @Override
    public AdminProfile adminProfileTranslator(Object name, Object email)
    {
        AdminProfile adminProfile = new AdminProfile();
        adminProfile.setName((String)name);
        adminProfile.setEmail((String)email);
        return adminProfile;
    }
    @Override
    public AdminProfile adminProfileInfoTranslator(Object name, Object email, Object contact) 
    {
        AdminProfile adminProfile = new AdminProfile();
        adminProfile.setName((String)name);
        adminProfile.setEmail((String)email);
        adminProfile.setContact((String)contact);
        return adminProfile;
    }
    @Override
    public AdminProfile adminProfileInfoTranslator(Object id, Object name, Object email, Object contact) 
    {
        AdminProfile adminProfile = new AdminProfile();
        adminProfile.setId((String)id);
        adminProfile.setName((String)name);
        adminProfile.setEmail((String)email);
        adminProfile.setContact((String)contact);
        return adminProfile;
    }
    @Override
    public Admin adminTranslator(Object name, Object email)
    {
        Admin admin = new Admin();
        admin.setName((String)name);
        admin.setEmail((String)email);
        return admin;
    }

    @Override
    public Doctor doctorLoginInfoTranslator(Object email, Object password) 
    {
        Doctor doctor = new Doctor();
        doctor.setEmail((String)email);
        doctor.setPassword((String)password);
        return doctor;
    }
    @Override
    public Doctor doctorInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    {
        Doctor doctor = new Doctor();
        doctor.setName((String)name);
        doctor.setEmail((String)email);
        doctor.setPassword((String)password);
        doctor.setUserCategory((String)userCategory);
        return doctor;
    }
    @Override
    public DoctorProfile doctorProfileTranslator(Object name, Object email)
    {
        DoctorProfile doctorProfile = new DoctorProfile();
        doctorProfile.setName((String)name);
        doctorProfile.setEmail((String)email);
        return doctorProfile;
    }
    @Override
    public DoctorProfile doctorProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object visitingHours2, Object feeStructure, Object city, Object country, Object area)
//    public DoctorProfile doctorProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object feeStructure, Object city, Object country, Object area)
    {
        DoctorProfile doctorProfile = new DoctorProfile();
        Location location = new Location();
        Hospital hospital = new Hospital();
        Specialization specialization = new Specialization();
        doctorProfile.setName((String)name);
        doctorProfile.setEmail((String)email);
        doctorProfile.setContact((String)contact);
        doctorProfile.setDateOfBirth((String)dateOfBirth);
        doctorProfile.setGender((String)gender);
        specialization.setDegree((String)degree);
        specialization.setSpecialist((String)specialist);
        specialization.setSpecialties((String)specialties);
        hospital.setHospitalName((String)hospitalName);
        hospital.setDays((String)day);
        hospital.setVisitingHours((String)visitingHours);
        hospital.setVisitingHours2((String)visitingHours2);
        hospital.setFeeStructure((String)feeStructure);
        location.setCity((String)city);
        location.setCountry((String)country);
        location.setArea((String)area);
        hospital.setLocation(location);
        doctorProfile.setHospital(hospital);
        doctorProfile.setSpecialization(specialization);
        return doctorProfile;
    }
    @Override
    public DoctorProfile doctorProfileInfoTranslator(Object id, Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object visitingHours2, Object feeStructure, Object city, Object country, Object area)
//    public DoctorProfile doctorProfileInfoTranslator(Object id, Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object degree, Object specialist, Object specialties, Object hospitalName, Object day, Object visitingHours, Object feeStructure, Object city, Object country, Object area)
    {
        DoctorProfile doctorProfile = new DoctorProfile();
        Location location = new Location();
        Hospital hospital = new Hospital();
        Specialization specialization = new Specialization();
        doctorProfile.setId((String)id);
        doctorProfile.setName((String)name);
        doctorProfile.setEmail((String)email);
        doctorProfile.setContact((String)contact);
        doctorProfile.setDateOfBirth((String)dateOfBirth);
        doctorProfile.setGender((String)gender);
        specialization.setDegree((String)degree);
        specialization.setSpecialist((String)specialist);
        specialization.setSpecialties((String)specialties);
        hospital.setHospitalName((String)hospitalName);
        hospital.setDays((String)day);
        hospital.setVisitingHours((String)visitingHours);
        hospital.setVisitingHours2((String)visitingHours);
        hospital.setFeeStructure((String)feeStructure);
        location.setCity((String)city);
        location.setCountry((String)country);
        location.setArea((String)area);
        hospital.setLocation(location);
        doctorProfile.setHospital(hospital);
        doctorProfile.setSpecialization(specialization);
        return doctorProfile;
    }
    @Override
    public Doctor doctorTranslator(Object name, Object email)
    {
        Doctor doctor = new Doctor();
        doctor.setName((String)name);
        doctor.setEmail((String)email);
        return doctor;
    }

    @Override
    public Patient patientLoginInfoTranslator(Object email, Object password) 
    {
        Patient patient = new Patient();
        patient.setEmail((String)email);
        patient.setPassword((String)password);
        return patient;
    }
    @Override
    public Patient patientInfoTranslator(Object name, Object email, Object password, Object userCategory) 
    {
        Patient patient = new Patient();
        patient.setName((String)name);
        patient.setEmail((String)email);
        patient.setPassword((String)password);
        patient.setUserCategory((String)userCategory);
        return patient;
    }
    @Override
    public PatientProfile patientProfileTranslator(Object name, Object email)
    {
        PatientProfile patientProfile = new PatientProfile();
        patientProfile.setName((String)name);
        patientProfile.setEmail((String)email);
        return patientProfile;
    }
    @Override
    public PatientProfile patientProfileInfoTranslator(Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object incomeGroup, Object city, Object country, Object area)
    {   
        PatientProfile patientProfile = new PatientProfile();
        patientProfile.setName((String)name);
        patientProfile.setEmail((String)email);
        patientProfile.setContact((String)contact);
        patientProfile.setDateOfBirth((String)dateOfBirth);
        patientProfile.setGender((String)gender);
        patientProfile.setIncomeGroup((String)incomeGroup);
        Location location = new Location();
        location.setCity((String)city);
        location.setCountry((String)country);
        location.setArea((String)area);
        patientProfile.setLocation(location);
        return patientProfile;
    }
    @Override
    public PatientProfile patientProfileInfoTranslator(Object id, Object name, Object email, Object contact, Object dateOfBirth, Object gender, Object incomeGroup, Object city, Object country, Object area)
    {   
        PatientProfile patientProfile = new PatientProfile();
        patientProfile.setId((String)id);
        patientProfile.setName((String)name);
        patientProfile.setEmail((String)email);
        patientProfile.setContact((String)contact);
        patientProfile.setDateOfBirth((String)dateOfBirth);
        patientProfile.setGender((String)gender);
        patientProfile.setIncomeGroup((String)incomeGroup);
        Location location = new Location();
        location.setCity((String)city);
        location.setCountry((String)country);
        location.setArea((String)area);
        patientProfile.setLocation(location);
        return patientProfile;
    }
    @Override
    public Patient patientTranslator(Object name, Object email)
    {
        Patient patient = new Patient();
        patient.setName((String)name);
        patient.setEmail((String)email);
        return patient;
    }
}
