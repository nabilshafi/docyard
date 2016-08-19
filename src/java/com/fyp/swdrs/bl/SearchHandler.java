/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import java.util.ArrayList;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.dal.owlNxml.SearchDAL;
//import com.fyp.swdrs.dal.owlNxml.SearchDAL;
//import com.fyp.swdrs.dal.filing.SearchDAL;
//import com.fyp.swdrs.dal.xml.SearchDAL;


/**
 *
 * @author Zohaib Masood (CS-121054)
 */

public class SearchHandler 
{
    public boolean searchDoctor(String searchQuery, String filename, ArrayList<DoctorProfile> doctorProfiles, PatientProfile patientProfile)
    {
        SearchDAL searchDAL = new SearchDAL();
        boolean success = searchDAL.searchDoctor(searchQuery, filename, doctorProfiles, patientProfile);
        return success;
    }
    public boolean searchDoctorBySymptom(PatientProfile patientProfile, String filename, ArrayList<DoctorProfile> doctorProfiles, String searchQuery)
    {
        SearchDAL searchDAL = new SearchDAL();
        boolean success = searchDAL.searchDoctorBySymptom(patientProfile, filename, doctorProfiles, searchQuery);
        return success;
    }
    public boolean searchDoctorBySymptoms(PatientProfile patientProfile, String filename, ArrayList<DoctorProfile> doctorProfiles, String searchQuery1, String searchQuery2, String searchQuery3)
    {
        SearchDAL searchDAL = new SearchDAL();
        boolean success = searchDAL.searchDoctorBySymptoms(patientProfile, filename, doctorProfiles, searchQuery1, searchQuery2, searchQuery3);
        return success;
    }
}
