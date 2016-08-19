/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.controller;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.bl.LoginHandler;
import com.fyp.swdrs.bl.AdminHandler;
import com.fyp.swdrs.bl.DoctorHandler;
import com.fyp.swdrs.bl.PatientHandler;
import com.fyp.swdrs.bl.AdminProfileHandler;
import com.fyp.swdrs.bl.AreaHandler;
import com.fyp.swdrs.bl.CityHandler;
import com.fyp.swdrs.bl.DaysHandler;
import com.fyp.swdrs.bl.DegreeHandler;
import com.fyp.swdrs.bl.DoctorProfileHandler;
import com.fyp.swdrs.bl.PatientProfileHandler;
import com.fyp.swdrs.bl.SearchHandler;
import com.fyp.swdrs.bl.FeedbackHandler;
import com.fyp.swdrs.bl.GenderHandler;
import com.fyp.swdrs.bl.HospitalHandler;
import com.fyp.swdrs.bl.IncomeGroupHandler;
import com.fyp.swdrs.bl.SpecialtiesHandler;
import com.fyp.swdrs.bl.SymptomHandler;
import com.fyp.swdrs.bl.DiseaseHandler;
import com.fyp.swdrs.bl.AddressHandler;
import com.fyp.swdrs.bl.FeedbackQuestionHandler;
import com.fyp.swdrs.bl.UtilityHandler;
import com.fyp.swdrs.translator.UsersTranslator;
import com.fyp.swdrs.translator.FeedbackTranslator;
import com.fyp.swdrs.utility.Constants;
import java.util.ArrayList;

/**
 * @author Zohaib Masood (CS-121054)
 */

public class Controller 
{
    public Object[] processRequest(int action, Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        switch(action)
        {
            case Constants.loginAction                      : returnObj = verifyLogin               ( parameters, filename ) ; break ;
            case Constants.changePasswordAction             : returnObj = changePassword            ( parameters, filename ) ; break ;

            case Constants.adminLoginAction                 : returnObj = verifyAdminLogin          ( parameters, filename ) ; break ;
            case Constants.adminChangePasswordAction        : returnObj = changeAdminPassword       ( parameters, filename ) ; break ;

            case Constants.doctorLoginAction                : returnObj = verifyDoctorLogin         ( parameters, filename ) ; break ;
            case Constants.doctorChangePasswordAction       : returnObj = changeDoctorPassword      ( parameters, filename ) ; break ;

            case Constants.patientLoginAction               : returnObj = verifyPatientLogin        ( parameters, filename ) ; break ;
            case Constants.patientChangePasswordAction      : returnObj = changePatientPassword     ( parameters, filename ) ; break ;

            case Constants.createUserAction                 : returnObj = createUser                ( parameters, filename ) ; break ;
            case Constants.viewUserAction                   : returnObj = viewUser                  ( parameters, filename ) ; break ;
            case Constants.updateUserAction                 : returnObj = updateUser                ( parameters, filename ) ; break ;
            case Constants.deleteUserAction                 : returnObj = deleteUser                ( parameters, filename ) ; break ;

            case Constants.createAdminAction                : returnObj = createAdmin               ( parameters, filename ) ; break ;
            case Constants.viewAdminAction                  : returnObj = viewAdmin                 ( parameters, filename ) ; break ;
            case Constants.updateAdminAction                : returnObj = updateAdmin               ( parameters, filename ) ; break ;
            case Constants.deleteAdminAction                : returnObj = deleteAdmin               ( parameters, filename ) ; break ;

            case Constants.createDoctorAction               : returnObj = createDoctor              ( parameters, filename ) ; break ;
            case Constants.viewDoctorAction                 : returnObj = viewDoctor                ( parameters, filename ) ; break ;
            case Constants.updateDoctorAction               : returnObj = updateDoctor              ( parameters, filename ) ; break ;
            case Constants.deleteDoctorAction               : returnObj = deleteDoctor              ( parameters, filename ) ; break ;

            case Constants.createPatientAction              : returnObj = createPatient             ( parameters, filename ) ; break ;
            case Constants.viewPatientAction                : returnObj = viewPatient               ( parameters, filename ) ; break ;
            case Constants.updatePatientAction              : returnObj = updatePatient             ( parameters, filename ) ; break ;
            case Constants.deletePatientAction              : returnObj = deletePatient             ( parameters, filename ) ; break ;

            case Constants.createUserProfileAction          : returnObj = createUserProfile         ( parameters, filename ) ; break ;
            case Constants.viewUserProfileAction            : returnObj = viewUserProfile           ( parameters, filename ) ; break ;
            case Constants.updateUserProfileAction          : returnObj = updateUserProfile         ( parameters, filename ) ; break ;
            case Constants.deleteUserProfileAction          : returnObj = deleteUserProfile         ( parameters, filename ) ; break ;
            
            case Constants.createAdminProfileAction         : returnObj = createAdminProfile        ( parameters, filename ) ; break ;
            case Constants.viewAdminProfileAction           : returnObj = viewAdminProfile          ( parameters, filename ) ; break ;
            case Constants.updateAdminProfileAction         : returnObj = updateAdminProfile        ( parameters, filename ) ; break ;
            case Constants.deleteAdminProfileAction         : returnObj = deleteAdminProfile        ( parameters, filename ) ; break ;
            
            case Constants.createDoctorProfileAction        : returnObj = createDoctorProfile       ( parameters, filename ) ; break ;
            case Constants.viewDoctorProfileAction          : returnObj = viewDoctorProfile         ( parameters, filename ) ; break ;
            case Constants.updateDoctorProfileAction        : returnObj = updateDoctorProfile       ( parameters, filename ) ; break ;
            case Constants.deleteDoctorProfileAction        : returnObj = deleteDoctorProfile       ( parameters, filename ) ; break ;

            case Constants.createPatientProfileAction       : returnObj = createPatientProfile      ( parameters, filename ) ; break ;
            case Constants.viewPatientProfileAction         : returnObj = viewPatientProfile        ( parameters, filename ) ; break ;
            case Constants.updatePatientProfileAction       : returnObj = updatePatientProfile      ( parameters, filename ) ; break ;
            case Constants.deletePatientProfileAction       : returnObj = deletePatientProfile      ( parameters, filename ) ; break ;

            case Constants.createFeedbackAction             : returnObj = createFeedback            ( parameters, filename ) ; break ;
            case Constants.viewFeedbackAction               : returnObj = viewFeedback              ( parameters, filename ) ; break ;
            case Constants.updateFeedbackAction             : returnObj = updateFeedback            ( parameters, filename ) ; break ;
            case Constants.deleteFeedbackAction             : returnObj = deleteFeedback            ( parameters, filename ) ; break ;
            
            case Constants.searchDoctorAction               : returnObj = searchDoctor              ( parameters, filename ) ; break ;
            case Constants.searchDoctorBySymptomAction      : returnObj = searchDoctorBySymptom     ( parameters, filename ) ; break ;
     
            case Constants.populateListAction               : returnObj = populateList              ( parameters, filename ) ; break ;
            case Constants.populateDoctorListAction         : returnObj = populateDoctorList        ( parameters, filename ) ; break ;
            case Constants.retrieveFeedbackQuestionsAction  : returnObj = retrieveFeedbackQuestions ( parameters, filename ) ; break ;

            case Constants.createGenderAction               : returnObj = createGender              ( parameters, filename ) ; break ;
            case Constants.viewGenderAction                 : returnObj = viewGender                ( parameters, filename ) ; break ;
            case Constants.updateGenderAction               : returnObj = updateGender              ( parameters, filename ) ; break ;
            case Constants.deleteGenderAction               : returnObj = deleteGender              ( parameters, filename ) ; break ;
            
            case Constants.createIncomeGroupAction          : returnObj = createIncomeGroup         ( parameters, filename ) ; break ;
            case Constants.viewIncomeGroupAction            : returnObj = viewIncomeGroup           ( parameters, filename ) ; break ;
            case Constants.updateIncomeGroupAction          : returnObj = updateIncomeGroup         ( parameters, filename ) ; break ;
            case Constants.deleteIncomeGroupAction          : returnObj = deleteIncomeGroup         ( parameters, filename ) ; break ;
            
            case Constants.createDegreeAction               : returnObj = createDegree              ( parameters, filename ) ; break ;
            case Constants.viewDegreeAction                 : returnObj = viewDegree                ( parameters, filename ) ; break ;
            case Constants.updateDegreeAction               : returnObj = updateDegree              ( parameters, filename ) ; break ;
            case Constants.deleteDegreeAction               : returnObj = deleteDegree              ( parameters, filename ) ; break ;
            
            case Constants.createSpecialtiesAction          : returnObj = createSpecialties         ( parameters, filename ) ; break ;
            case Constants.viewSpecialtiesAction            : returnObj = viewSpecialties           ( parameters, filename ) ; break ;
            case Constants.updateSpecialtiesAction          : returnObj = updateSpecialties         ( parameters, filename ) ; break ;
            case Constants.deleteSpecialtiesAction          : returnObj = deleteSpecialties         ( parameters, filename ) ; break ;
            
            case Constants.createHospitalAction             : returnObj = createHospital            ( parameters, filename ) ; break ;
            case Constants.viewHospitalAction               : returnObj = viewHospital              ( parameters, filename ) ; break ;
            case Constants.updateHospitalAction             : returnObj = updateHospital          ( parameters, filename ) ; break ;
            case Constants.deleteHospitalAction             : returnObj = deleteHospital          ( parameters, filename ) ; break ;
            
            case Constants.createDaysAction                 : returnObj = createDays                ( parameters, filename ) ; break ;
            case Constants.viewDaysAction                   : returnObj = viewDays                  ( parameters, filename ) ; break ;
            case Constants.updateDaysAction                 : returnObj = updateDays                ( parameters, filename ) ; break ;
            case Constants.deleteDaysAction                 : returnObj = deleteDays                ( parameters, filename ) ; break ;
            
            case Constants.createCityAction                 : returnObj = createCity                ( parameters, filename ) ; break ;
            case Constants.viewCityAction                   : returnObj = viewCity                  ( parameters, filename ) ; break ;
            case Constants.updateCityAction                 : returnObj = updateCity                ( parameters, filename ) ; break ;
            case Constants.deleteCityAction                 : returnObj = deleteCity                ( parameters, filename ) ; break ;
            
            case Constants.createAreaAction                 : returnObj = createArea                ( parameters, filename ) ; break ;
            case Constants.viewAreaAction                   : returnObj = viewArea                  ( parameters, filename ) ; break ;
            case Constants.updateAreaAction                 : returnObj = updateArea                ( parameters, filename ) ; break ;
            case Constants.deleteAreaAction                 : returnObj = deleteArea                ( parameters, filename ) ; break ;
            
            case Constants.createSymptomAction              : returnObj = createSymptom             ( parameters, filename ) ; break ;
            case Constants.viewSymptomAction                : returnObj = viewSymptom               ( parameters, filename ) ; break ;
            case Constants.updateSymptomAction              : returnObj = updateSymptom             ( parameters, filename ) ; break ;
            case Constants.deleteSymptomAction              : returnObj = deleteSymptom             ( parameters, filename ) ; break ;
            
            case Constants.createDiseaseAction              : returnObj = createDisease             ( parameters, filename ) ; break ;
            case Constants.viewDiseaseAction                : returnObj = viewDisease               ( parameters, filename ) ; break ;
            case Constants.updateDiseaseAction              : returnObj = updateDisease             ( parameters, filename ) ; break ;
            case Constants.deleteDiseaseAction              : returnObj = deleteDisease             ( parameters, filename ) ; break ;
            
            case Constants.createAddressAction              : returnObj = createAddress             ( parameters, filename ) ; break ;
            case Constants.viewAddressAction                : returnObj = viewAddress               ( parameters, filename ) ; break ;
            case Constants.updateAddressAction              : returnObj = updateAddress             ( parameters, filename ) ; break ;
            case Constants.deleteAddressAction              : returnObj = deleteAddress             ( parameters, filename ) ; break ;
            
            case Constants.createFeedbackQuestionAction     : returnObj = createFeedbackQuestion    ( parameters, filename ) ; break ;
            case Constants.viewFeedbackQuestionAction       : returnObj = viewFeedbackQuestion      ( parameters, filename ) ; break ;
            case Constants.updateFeedbackQuestionAction     : returnObj = updateFeedbackQuestion    ( parameters, filename ) ; break ;
            case Constants.deleteFeedbackQuestionAction     : returnObj = deleteFeedbackQuestion    ( parameters, filename ) ; break ;
        }
        return returnObj;
    }

    private Object[] verifyLogin(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        returnObj = verifyAdminLogin(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
        {
            return returnObj;
        }
        returnObj = verifyDoctorLogin(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
        {
            return returnObj;
        }
        returnObj = verifyPatientLogin(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
        {
            return returnObj;
        }
        else
        {
            return null;
        }
    }
    private Object[] changePassword(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        returnObj = changeAdminPassword(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
        {
            return returnObj;
        }
        returnObj = changeDoctorPassword(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
        {
            return returnObj;
        }
        returnObj = changePatientPassword(parameters, filename);
        if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
        {
            return returnObj;
        }
        else
        {
            return null;
        }
    }

    private Object[] verifyAdminLogin(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Admin admin = usersTranslator.adminLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.verifyAdminLogin(admin, filename);
        if(success)
        {// verifyAdminLogin
            returnObj = new Object[2] ;
            returnObj[0] = admin ;
            returnObj[1] = (String)"admin" ;
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] changeAdminPassword(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Admin admin = usersTranslator.adminLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.changeAdminPassword(admin, filename);
        if(success)//(admin.getName()!= null && !admin.getName().equals(""))
        {// changeAdminPassword
            returnObj = new Object[2] ;
            returnObj[0] = admin ;
            returnObj[1] = (String)"admin";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] verifyDoctorLogin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Doctor doctor = usersTranslator.doctorLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.verifyDoctorLogin(doctor, filename);
        if(success)//(doctor.getName()!= null && !doctor.getName().equals(""))
        {// verifyDoctorLogin
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] changeDoctorPassword(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Doctor doctor = usersTranslator.doctorLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.changeDoctorPassword(doctor, filename);
        if(success)//(doctor.getName()!= null && !doctor.getName().equals(""))
        {// changeDoctorPassword
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] verifyPatientLogin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Patient patient = usersTranslator.patientLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.verifyPatientLogin(patient, filename);
        if(success)//(patient.getName()!= null && !patient.getName().equals(""))
        {// verifyPatientLogin
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] changePatientPassword(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        LoginHandler loginHandler  = new LoginHandler();
        Patient patient = usersTranslator.patientLoginInfoTranslator(parameters[0], parameters[1]);
        boolean success = loginHandler.changePatientPassword(patient, filename);
        if(success)//patient.getName()!= null && !patient.getName().equals(""))
        {// changePatientPassword
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }

    private Object[] createUser(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[3]).equals("ADMIN"))
        {
            returnObj = createAdmin(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("DOCTOR"))
        {
            returnObj = createDoctor(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("PATIENT"))
        {
            returnObj = createPatient(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] viewUser(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[3]).equals("ADMIN"))
        {
            returnObj = viewAdmin(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("DOCTOR"))
        {
            returnObj = viewDoctor(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("PATIENT"))
        {
            returnObj = viewPatient(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] updateUser(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[3]).equals("ADMIN"))
        {
            returnObj = updateAdmin(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("DOCTOR"))
        {
            returnObj = updateDoctor(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("PATIENT"))
        {
            returnObj = updatePatient(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] deleteUser(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[3]).equals("ADMIN"))
        {
            returnObj = deleteAdmin(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("DOCTOR"))
        {
            returnObj = deleteDoctor(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[3]).equals("PATIENT"))
        {
            returnObj = deletePatient(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    
    private Object[] createAdmin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminHandler adminHandler  = new AdminHandler();
        Admin admin = usersTranslator.adminInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = adminHandler.createAdmin(admin, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = admin;
            returnObj[1] = (String)"admin";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewAdmin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminHandler adminHandler  = new AdminHandler();
        Admin admin = usersTranslator.adminInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = adminHandler.viewAdmin(admin, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = admin;
            returnObj[1] = (String)"admin";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateAdmin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminHandler adminHandler  = new AdminHandler();
        Admin admin = usersTranslator.adminInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = adminHandler.updateAdmin(admin, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = admin;
            returnObj[1] = (String)"admin";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteAdmin(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminHandler adminHandler  = new AdminHandler();
        Admin admin = usersTranslator.adminInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = adminHandler.deleteAdmin(admin, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = admin;
            returnObj[1] = (String)"admin";
            return returnObj;
        }
        return returnObj;
    }
    
    private Object[] createDoctor(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorHandler doctorHandler  = new DoctorHandler();
        Doctor doctor = usersTranslator.doctorInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = doctorHandler.createDoctor(doctor, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] viewDoctor(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorHandler doctorHandler  = new DoctorHandler();
        Doctor doctor = usersTranslator.doctorInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = doctorHandler.viewDoctor(doctor, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] updateDoctor(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorHandler doctorHandler  = new DoctorHandler();
        Doctor doctor = usersTranslator.doctorInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = doctorHandler.updateDoctor(doctor, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] deleteDoctor(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorHandler doctorHandler  = new DoctorHandler();
        Doctor doctor = usersTranslator.doctorInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = doctorHandler.deleteDoctor(doctor, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctor";
            return returnObj ;
        }
        return returnObj;
    }

    private Object[] createPatient(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientHandler patientHandler  = new PatientHandler();
        Patient patient = usersTranslator.patientInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = patientHandler.createPatient(patient, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] viewPatient(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientHandler patientHandler  = new PatientHandler();
        Patient patient = usersTranslator.patientInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = patientHandler.viewPatient(patient, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] updatePatient(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientHandler patientHandler  = new PatientHandler();
        Patient patient = usersTranslator.patientInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = patientHandler.updatePatient(patient, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] deletePatient(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientHandler patientHandler  = new PatientHandler();
        Patient patient = usersTranslator.patientInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = patientHandler.deletePatient(patient, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patient ;
            returnObj[1] = (String)"patient";
            return returnObj ;
        }
        return returnObj;
    }

    private Object[] createUserProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[0]).equals("ADMIN"))
        {
            returnObj = createAdminProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("DOCTOR"))
        {
            returnObj = createDoctorProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("PATIENT"))
        {
            returnObj = createPatientProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] viewUserProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[0]).equals("ADMIN"))
        {
            returnObj = viewAdminProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("DOCTOR"))
        {
            returnObj = viewDoctorProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("PATIENT"))
        {
            returnObj = viewPatientProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] updateUserProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[0]).equals("ADMIN"))
        {
            returnObj = updateAdminProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("DOCTOR"))
        {
            returnObj = updateDoctorProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("PATIENT"))
        {
            returnObj = updatePatientProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }
    private Object[] deleteUserProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        if(((String)parameters[0]).equals("ADMIN"))
        {
            returnObj = deleteAdminProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("admin")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("DOCTOR"))
        {
            returnObj = deleteDoctorProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("doctor")))
            {
                return returnObj;
            }
        }
        else if(((String)parameters[0]).equals("PATIENT"))
        {
            returnObj = deletePatientProfile(parameters, filename);
            if((returnObj != null) && (((String)returnObj[1]).equals("patient")))
            {
                return returnObj;
            }
        }
        return returnObj;
    }

    private Object[] createAdminProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminProfileHandler adminProfileHandler  = new AdminProfileHandler();
        AdminProfile adminProfile = usersTranslator.adminProfileInfoTranslator(parameters[0], parameters[1], parameters[2]);
        boolean success = adminProfileHandler.createAdminProfile(adminProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = adminProfile;
            returnObj[1] = (String)"adminProfile";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewAdminProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminProfileHandler adminProfileHandler  = new AdminProfileHandler();
        AdminProfile adminProfile = usersTranslator.adminProfileTranslator(parameters[0], parameters[1]);
        boolean success = adminProfileHandler.viewAdminProfile(adminProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = adminProfile;
            returnObj[1] = (String)"adminProfile";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateAdminProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminProfileHandler adminProfileHandler  = new AdminProfileHandler();
        AdminProfile adminProfile = usersTranslator.adminProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = adminProfileHandler.updateAdminProfile(adminProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = adminProfile;
            returnObj[1] = (String)"adminProfile";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteAdminProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        AdminProfileHandler adminProfileHandler  = new AdminProfileHandler();
        AdminProfile adminProfile = usersTranslator.adminProfileInfoTranslator(parameters[0], parameters[1], parameters[2]);
        boolean success = adminProfileHandler.deleteAdminProfile(adminProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = adminProfile;
            returnObj[1] = (String)"adminProfile";
            return returnObj;
        }
        return returnObj;
    }
    
    private Object[] createDoctorProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorProfileHandler doctorProfileHandler  = new DoctorProfileHandler();
//        DoctorProfile doctorProfile = usersTranslator.doctorProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10], parameters[11], parameters[12], parameters[13], parameters[14]);
        DoctorProfile doctorProfile = usersTranslator.doctorProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10], parameters[11], parameters[12], parameters[13], parameters[14], parameters[15]);
        boolean success = doctorProfileHandler.createDoctorProfile(doctorProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctorProfile ;
            returnObj[1] = (String)"doctorProfile";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] viewDoctorProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorProfileHandler doctorProfileHandler = new DoctorProfileHandler();
        Doctor doctor = usersTranslator.doctorTranslator(parameters[0], parameters[1]);
        ArrayList<DoctorProfile> drProfile = new ArrayList();
        boolean success = doctorProfileHandler.viewDoctorProfile1(doctor, filename, drProfile);
        if(success)
        {
            returnObj = new Object[3] ;
            returnObj[0] = doctor ;
            returnObj[1] = (String)"doctorProfile";
            returnObj[2] = drProfile ;
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] updateDoctorProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorProfileHandler doctorProfileHandler  = new DoctorProfileHandler();
        DoctorProfile doctorProfile = usersTranslator.doctorProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10], parameters[11], parameters[12], parameters[13], parameters[14], parameters[15], parameters[16]);
        int profileNumber = (Integer)parameters[17];
        boolean success = doctorProfileHandler.updateDoctorProfile1(doctorProfile, filename, profileNumber);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctorProfile ;
            returnObj[1] = (String)"doctorProfile";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] deleteDoctorProfile(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        DoctorProfileHandler doctorProfileHandler  = new DoctorProfileHandler();
        DoctorProfile doctorProfile = usersTranslator.doctorProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10], parameters[11], parameters[12], parameters[13], parameters[14], parameters[15]);
        boolean success = doctorProfileHandler.deleteDoctorProfile(doctorProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctorProfile ;
            returnObj[1] = (String)"doctorProfile";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] createPatientProfile(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientProfileHandler patientProfileHandler  = new PatientProfileHandler();
        PatientProfile patientProfile = usersTranslator.patientProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8]);
        boolean success = patientProfileHandler.createPatientProfile(patientProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patientProfile ;
            returnObj[1] = (String)"patientProfile";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] viewPatientProfile(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientProfileHandler patientProfileHandler  = new PatientProfileHandler();
        PatientProfile patientProfile = usersTranslator.patientProfileTranslator(parameters[0], parameters[1]);
        boolean success = patientProfileHandler.viewPatientProfile(patientProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patientProfile ;
            returnObj[1] = (String)"patientProfile";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] updatePatientProfile(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientProfileHandler patientProfileHandler  = new PatientProfileHandler();
        PatientProfile patientProfile = usersTranslator.patientProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9]);
        boolean success = patientProfileHandler.updatePatientProfile(patientProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patientProfile ;
            returnObj[1] = (String)"patientProfile";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] deletePatientProfile(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        UsersTranslator usersTranslator = new UsersTranslator();
        PatientProfileHandler patientProfileHandler  = new PatientProfileHandler();
        PatientProfile patientProfile = usersTranslator.patientProfileInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8]);
        boolean success = patientProfileHandler.deletePatientProfile(patientProfile, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = patientProfile ;
            returnObj[1] = (String)"patientProfile";
            return returnObj ;
        }
        return returnObj;
    }

    private Object[] createFeedback(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        FeedbackTranslator feedbackTranslator = new FeedbackTranslator();
        FeedbackHandler feedbackHandler  = new FeedbackHandler();
//        Feedback feedback = feedbackTranslator.feedbackInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        Feedback feedback = feedbackTranslator.feedbackInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10], parameters[11], parameters[12], parameters[13], parameters[14], parameters[15], parameters[16], parameters[17], parameters[18], parameters[19]);
        boolean success = feedbackHandler.createFeedback(feedback, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = feedback ;
            returnObj[1] = (String)"feedback";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] viewFeedback(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        FeedbackTranslator feedbackTranslator = new FeedbackTranslator();
        FeedbackHandler feedbackHandler  = new FeedbackHandler();
        Feedback feedback = feedbackTranslator.feedbackInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = feedbackHandler.viewFeedback(feedback, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = feedback ;
            returnObj[1] = (String)"feedback";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] updateFeedback(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        FeedbackTranslator feedbackTranslator = new FeedbackTranslator();
        FeedbackHandler feedbackHandler  = new FeedbackHandler();
        Feedback feedback = feedbackTranslator.feedbackInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = feedbackHandler.updateFeedback(feedback, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = feedback ;
            returnObj[1] = (String)"feedback";
            return returnObj ;
        }
        return returnObj;
    }
    private Object[] deleteFeedback(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        FeedbackTranslator feedbackTranslator = new FeedbackTranslator();
        FeedbackHandler feedbackHandler  = new FeedbackHandler();
        Feedback feedback = feedbackTranslator.feedbackInfoTranslator(parameters[0], parameters[1], parameters[2], parameters[3]);
        boolean success = feedbackHandler.deleteFeedback(feedback, filename);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = feedback ;
            returnObj[1] = (String)"feedback";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] searchDoctor(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        SearchHandler searchHandler = new SearchHandler();
        ArrayList<DoctorProfile> doctorProfiles = new ArrayList();
        boolean success = searchHandler.searchDoctor((String)parameters[0], filename, doctorProfiles, (PatientProfile)parameters[1]);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctorProfiles ;
            returnObj[1] = (String)"search";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] searchDoctorBySymptom(Object[] parameters, String filename)
    {
        Object[] returnObj = null;
        SearchHandler searchHandler = new SearchHandler();
        ArrayList<DoctorProfile> doctorProfiles = new ArrayList();
//        boolean success = searchHandler.searchDoctorBySymptom((PatientProfile)parameters[0], filename, doctorProfiles, (String)parameters[1]);
        boolean success = searchHandler.searchDoctorBySymptoms((PatientProfile)parameters[0], filename, doctorProfiles, (String)parameters[1], (String)parameters[2], (String)parameters[3]);
        if(success)
        {
            returnObj = new Object[2] ;
            returnObj[0] = doctorProfiles ;
            returnObj[1] = (String)"searchSymptom";
            return returnObj ;
        }
        return returnObj;
    }
    
    private Object[] populateList(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UtilityHandler utilityHandler = new UtilityHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = utilityHandler.populateList(list, filename);
        if(success)
        {
            returnObj = new Object[1];
            returnObj[0] = list;
        }
        return returnObj;
    }

    private Object[] populateDoctorList(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UtilityHandler utilityHandler = new UtilityHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = utilityHandler.populateDoctorList(list, filename);
        if(success)
        {
            returnObj = new Object[1];
            returnObj[0] = list;
        }
        return returnObj;
    }
    private Object[] retrieveFeedbackQuestions(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        UtilityHandler utilityHandler = new UtilityHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = utilityHandler.retrieveFeedbackQuestions(list, filename);
        if(success)
        {
            returnObj = new Object[1];
            returnObj[0] = list;
        }
        return returnObj;
   }

    private Object[] createGender(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        GenderHandler adminCrudHandler = new GenderHandler();
        boolean success = adminCrudHandler.createGender((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"gender";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewGender(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        GenderHandler adminCrudHandler = new GenderHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewGender(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateGender(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        GenderHandler adminCrudHandler = new GenderHandler();
        boolean success = adminCrudHandler.updateGender((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"gender";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteGender(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        GenderHandler adminCrudHandler = new GenderHandler();
        boolean success = adminCrudHandler.deleteGender((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"gender";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createIncomeGroup(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        IncomeGroupHandler adminCrudHandler = new IncomeGroupHandler();
        boolean success = adminCrudHandler.createIncomeGroup((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"incomeGroup";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewIncomeGroup(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        IncomeGroupHandler adminCrudHandler = new IncomeGroupHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewIncomeGroup(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateIncomeGroup(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        IncomeGroupHandler adminCrudHandler = new IncomeGroupHandler();
        boolean success = adminCrudHandler.updateIncomeGroup((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"incomeGroup";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteIncomeGroup(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        IncomeGroupHandler adminCrudHandler = new IncomeGroupHandler();
        boolean success = adminCrudHandler.deleteIncomeGroup((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"incomeGroup";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createDegree(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DegreeHandler degreeHandler = new DegreeHandler();
        boolean success = degreeHandler.createDegree((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"degree";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewDegree(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DegreeHandler degreeHandler = new DegreeHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = degreeHandler.viewDegree(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateDegree(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DegreeHandler adminCrudHandler = new DegreeHandler();
        boolean success = adminCrudHandler.updateDegree((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"degree";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteDegree(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DegreeHandler adminCrudHandler = new DegreeHandler();
        boolean success = adminCrudHandler.deleteDegree((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"degree";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createSpecialties(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SpecialtiesHandler specialtiesHandler = new SpecialtiesHandler();
        boolean success = specialtiesHandler.createSpecialties((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"specialties";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewSpecialties(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SpecialtiesHandler adminCrudHandler = new SpecialtiesHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewSpecialties(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateSpecialties(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SpecialtiesHandler adminCrudHandler = new SpecialtiesHandler();
        boolean success = adminCrudHandler.updateSpecialties((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"specialties";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteSpecialties(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SpecialtiesHandler adminCrudHandler = new SpecialtiesHandler();
        boolean success = adminCrudHandler.deleteSpecialties((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"specialties";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createHospital(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        HospitalHandler hospitalHandler = new HospitalHandler();
        boolean success = hospitalHandler.createHospital((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"hospital";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewHospital(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        HospitalHandler adminCrudHandler = new HospitalHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewHospital(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateHospital(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        HospitalHandler adminCrudHandler = new HospitalHandler();
        boolean success = adminCrudHandler.updateHospital((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"hospital";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteHospital(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        HospitalHandler adminCrudHandler = new HospitalHandler();
        boolean success = adminCrudHandler.deleteHospital((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"hospital";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createDays(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DaysHandler daysHandler = new DaysHandler();
        boolean success = daysHandler.createDays((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"days";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewDays(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DaysHandler adminCrudHandler = new DaysHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewDays(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateDays(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DaysHandler adminCrudHandler = new DaysHandler();
        boolean success = adminCrudHandler.updateDays((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"days";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteDays(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DaysHandler adminCrudHandler = new DaysHandler();
        boolean success = adminCrudHandler.deleteDays((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"days";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createCity(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        CityHandler cityHandler = new CityHandler();
        boolean success = cityHandler.createCity((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"city";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewCity(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        CityHandler adminCrudHandler = new CityHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewCity(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateCity(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        CityHandler adminCrudHandler = new CityHandler();
        boolean success = adminCrudHandler.updateCity((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"city";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteCity(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        CityHandler adminCrudHandler = new CityHandler();
        boolean success = adminCrudHandler.deleteCity((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"city";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createArea(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AreaHandler areaHandler = new AreaHandler();
        boolean success = areaHandler.createArea((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"area";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewArea(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AreaHandler adminCrudHandler = new AreaHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewArea(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateArea(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AreaHandler adminCrudHandler = new AreaHandler();
        boolean success = adminCrudHandler.updateArea((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"area";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteArea(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AreaHandler adminCrudHandler = new AreaHandler();
        boolean success = adminCrudHandler.deleteArea((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"area";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createSymptom(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SymptomHandler adminCrudHandler = new SymptomHandler();
        boolean success = adminCrudHandler.createSymptom((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"symptom";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewSymptom(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SymptomHandler adminCrudHandler = new SymptomHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewSymptom(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateSymptom(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SymptomHandler adminCrudHandler = new SymptomHandler();
        boolean success = adminCrudHandler.updateSymptom((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"symptom";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteSymptom(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        SymptomHandler adminCrudHandler = new SymptomHandler();
        boolean success = adminCrudHandler.deleteSymptom((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"symptom";
            return returnObj;
        }
        return returnObj;
    }
    
    private Object[] createDisease(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DiseaseHandler adminCrudHandler = new DiseaseHandler();
        boolean success = adminCrudHandler.createDisease((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"disease";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewDisease(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DiseaseHandler adminCrudHandler = new DiseaseHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewDisease(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateDisease(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DiseaseHandler adminCrudHandler = new DiseaseHandler();
        boolean success = adminCrudHandler.updateDisease((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"disease";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteDisease(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        DiseaseHandler adminCrudHandler = new DiseaseHandler();
        boolean success = adminCrudHandler.deleteDisease((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"disease";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createAddress(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AddressHandler adminCrudHandler = new AddressHandler();
        boolean success = adminCrudHandler.createAddress((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"address";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewAddress(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AddressHandler adminCrudHandler = new AddressHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewAddress(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateAddress(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AddressHandler adminCrudHandler = new AddressHandler();
        boolean success = adminCrudHandler.updateAddress((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"address";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteAddress(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        AddressHandler adminCrudHandler = new AddressHandler();
        boolean success = adminCrudHandler.deleteAddress((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"address";
            return returnObj;
        }
        return returnObj;
    }

    private Object[] createFeedbackQuestion(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        FeedbackQuestionHandler adminCrudHandler = new FeedbackQuestionHandler();
        boolean success = adminCrudHandler.createFeedbackQuestion((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"feedbackQuestion";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] viewFeedbackQuestion(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        FeedbackQuestionHandler adminCrudHandler = new FeedbackQuestionHandler();
        ArrayList<String> list = (ArrayList<String>)parameters[0];
        boolean success = adminCrudHandler.viewFeedbackQuestion(list, filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] = list;
            return returnObj;
        }
        return returnObj;
    }
    private Object[] updateFeedbackQuestion(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        FeedbackQuestionHandler adminCrudHandler = new FeedbackQuestionHandler();
        boolean success = adminCrudHandler.updateFeedbackQuestion((ArrayList<String>)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"feedbackQuestion";
            return returnObj;
        }
        return returnObj;
    }
    private Object[] deleteFeedbackQuestion(Object[] parameters, String filename) 
    {
        Object[] returnObj = null;
        FeedbackQuestionHandler adminCrudHandler = new FeedbackQuestionHandler();
        boolean success = adminCrudHandler.deleteFeedbackQuestion((String)parameters[0], filename);
        if(success)
        {
            returnObj = new Object[1] ;
            returnObj[0] =(String)"feedbackQuestion";
            return returnObj;
        }
        return returnObj;
    }
}