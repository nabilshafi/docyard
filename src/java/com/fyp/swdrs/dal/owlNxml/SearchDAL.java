/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Hospital;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.bo.Specialization;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.utility.Utility;
import com.fyp.swdrs.utility.Constants;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Admin
 */

public class SearchDAL
{
    public static ArrayList<String>namesDoctors = new ArrayList();

    public boolean searchDoctorBySymptoms(PatientProfile patientProfile, String filename, ArrayList<DoctorProfile> doctorforProfiles, String symptomSearchQuery1, String symptomSearchQuery2, String symptomSearchQuery3) 
    {
         boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 

            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator insIter = doctorProfileClass.listInstances();

          //  OntClass symptomClass = model.getOntClass(Constants.SOURCE_URL + Constants.NS+symptomSearchQuery");
            ArrayList<String> query = new ArrayList<String>();
            if(symptomSearchQuery1 != null){
                query.add(symptomSearchQuery1);
            }
            if(symptomSearchQuery2!=null){
                query.add(symptomSearchQuery2);
            }
            if(symptomSearchQuery3 != null){
                query.add(symptomSearchQuery3);
            }
            
            
            for(int i = 0;i<query.size(); i++) {
                Individual acc = model.getIndividual(Constants.SOURCE_URL +Constants.NS+query.get(i));
                ObjectProperty treatby = model.getObjectProperty(Constants.TREAT_BY_URL );

                model.prepare();	
                printPropertyValues(acc, treatby);
           }
            ArrayList<String> list2 = new ArrayList();
        
        Set<String> hs = new HashSet();
        hs.addAll(namesDoctors);
        namesDoctors.clear();
        list2.addAll(hs);
        ArrayList<Integer> county = new ArrayList<Integer>();

            for(int i = 0 ; i< list2.size();i++){
                
                Individual individual =model.getIndividual(Constants.SOURCE_URL +Constants.NS+list2.get(i));
                DoctorProfile doctorProfile = new DoctorProfile();
                int count =0;
                if((Constants.SOURCE_URL +Constants.NS+patientProfile.getLocation().getArea()).equals(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString())){
                    count+=2;
                }
                if((Constants.SOURCE_URL +Constants.NS+patientProfile.getLocation().getCity()).equals(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString())){
                    count++;
                }
                if((Constants.SOURCE_URL +Constants.NS+patientProfile.getLocation().getCountry()).equals(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString())){
                      count++;
                }
                
                //Matching Doctor Fee with patient Income
                      int value =Integer.parseInt(individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString());
                      String kamai = patientProfile.getIncomeGroup();
                      kamai= kamai.replaceAll(",", "");
                      String[] income  = kamai.split("-");
                      income[0] = income[0].replace(" ", "");
                      income[1] = income[1].replace(" ", "");
                      int min = Integer.parseInt(income[0]);
                      int max = Integer.parseInt(income[1]);
                      if((value <= max)&&(value >= min)){
                          count+=2;
                          value =200000000;
                      }
                      if((value <=max))
                          count++;
                      
                
                Location location = new Location();
                Specialization specialization = new Specialization();
                Hospital hospital = new Hospital();
                Utility utility = new Utility();
                doctorProfile.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                doctorProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                doctorProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                doctorProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                doctorProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                doctorProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                specialization.setDegree(individual.getPropertyValue(model.getProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString());
                specialization.setSpecialist(individual.getPropertyValue(model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL)).toString());
                specialization.setSpecialties(individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString());
                hospital.setHospitalName(individual.getPropertyValue(model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL)).toString());
                hospital.setDays(individual.getPropertyValue(model.getProperty(Constants.DAY_ATTRIBUTE_URL)).toString());
                hospital.setVisitingHours(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL)).toString());
                hospital.setVisitingHours2(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL)).toString());
                hospital.setFeeStructure(individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString());
                location.setCity(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString());
                location.setCountry(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString());
                location.setArea(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString());
                hospital.setLocation(location);
                doctorProfile.setSpecialization(specialization);
                doctorProfile.setHospital(hospital);
                doctorProfile.setSystemRating(utility.calculateSystemRating(doctorProfile.getName(), filename));
                doctorforProfiles.add(doctorProfile);
                county.add(count);
            }
            int temp;
            Object profiles;
            for(int i = 0 ; i < county.size()-1;i++){
                for(int j = i+1 ; j < county.size();j++){
                    if(county.get(j-1)<county.get(j)){
                        temp = county.get(j-1);
                        county.set(j-1, county.get(j));
                        county.set(j, temp);
                        
                        profiles = doctorforProfiles.get(j-1);
                        doctorforProfiles.set(j-1,doctorforProfiles.get(j));
                       doctorforProfiles.set(j,(DoctorProfile)profiles);

                    }
                    
                }
            }
            
            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        } 
        return success;
    }
            
    public static boolean searchDoctor(String searchQuery, String filename, ArrayList<DoctorProfile> doctorProfiles, PatientProfile patientProfile) 
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);

            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator insIter = doctorProfileClass.listInstances();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
//                if((individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||(individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase())||(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))))
                if(
                    (individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString().toLowerCase().equals(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.DAY_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString().toLowerCase().contains(searchQuery.toLowerCase())))
                {
                    DoctorProfile doctorProfile = new DoctorProfile();
                    Location location = new Location();
                    Specialization specialization = new Specialization();
                    Hospital hospital = new Hospital();
                    Utility utility = new Utility();
                    doctorProfile.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                    doctorProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                    doctorProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                    doctorProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                    doctorProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                    doctorProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                    specialization.setDegree(individual.getPropertyValue(model.getProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString());
                    specialization.setSpecialist(individual.getPropertyValue(model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL)).toString());
                    specialization.setSpecialties(individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString());
                    hospital.setHospitalName(individual.getPropertyValue(model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL)).toString());
                    hospital.setDays(individual.getPropertyValue(model.getProperty(Constants.DAY_ATTRIBUTE_URL)).toString());
                    hospital.setVisitingHours(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL)).toString());
                    hospital.setVisitingHours2(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL)).toString());
                    hospital.setFeeStructure(individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString());
                    location.setCity(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString());
                    location.setCountry(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString());
                    location.setArea(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString());
                    hospital.setLocation(location);
                    doctorProfile.setSpecialization(specialization);
                    doctorProfile.setHospital(hospital);
                 //  double Rate = utility.calculateSystemRating(doctorProfile.getName(), filename);
                    doctorProfile.setSystemRating(utility.calculateSystemRating(doctorProfile.getName(), filename));
                   // doctorProfile.setSystemRating(2.0);
                    doctorProfiles.add(doctorProfile);
                    success = true;
                }
            }
            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        } 
        return success;
    }

    public boolean searchDoctorBySymptom(PatientProfile patientProfile, String filename, ArrayList<DoctorProfile> doctorProfiles, String symptomSearchQuery) 
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 

            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);

          //  OntClass symptomClass = model.getOntClass(Constants.SOURCE_URL + Constants.NS+symptomSearchQuery");
            Individual acc = model.getIndividual(Constants.SOURCE_URL +Constants.NS+symptomSearchQuery);
            ObjectProperty treatby = model.getObjectProperty(Constants.TREAT_BY_URL );

            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator insIter = doctorProfileClass.listInstances();
            model.prepare();	
            printPropertyValues(acc, treatby);
            for(int i = 0 ; i< namesDoctors.size();i++)
            {
                Individual individual =model.getIndividual(Constants.SOURCE_URL +Constants.NS+namesDoctors.get(i));
                DoctorProfile doctorProfile = new DoctorProfile();
                Location location = new Location();
                Specialization specialization = new Specialization();
                Hospital hospital = new Hospital();
                Utility utility = new Utility();
                doctorProfile.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                doctorProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                doctorProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                doctorProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                doctorProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                doctorProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                specialization.setDegree(individual.getPropertyValue(model.getProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString());
                specialization.setSpecialist(individual.getPropertyValue(model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL)).toString());
                specialization.setSpecialties(individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString());
                hospital.setHospitalName(individual.getPropertyValue(model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL)).toString());
                hospital.setDays(individual.getPropertyValue(model.getProperty(Constants.DAY_ATTRIBUTE_URL)).toString());
                hospital.setVisitingHours(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL)).toString());
                hospital.setVisitingHours2(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL)).toString());
                hospital.setFeeStructure(individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString());
                location.setCity(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString());
                location.setCountry(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString());
                location.setArea(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString());
                hospital.setLocation(location);
                doctorProfile.setSpecialization(specialization);
                doctorProfile.setHospital(hospital);
                doctorProfile.setSystemRating(utility.calculateSystemRating(doctorProfile.getName(), filename));

                doctorProfiles.add(doctorProfile);
            }
          /*  while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                if(
                    (individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString().toLowerCase().equals(symptomSearchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString().toLowerCase().contains(symptomSearchQuery.toLowerCase()))||
                    (individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString().toLowerCase().contains(symptomSearchQuery.toLowerCase())))
                {
                    DoctorProfile doctorProfile = new DoctorProfile();
                    Location location = new Location();
                    Specialization specialization = new Specialization();
                    Hospital hospital = new Hospital();
                    doctorProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                    doctorProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                    doctorProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                    doctorProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                    doctorProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                    specialization.setDegree(individual.getPropertyValue(model.getProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString());
                    specialization.setSpecialist(individual.getPropertyValue(model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL)).toString());
                    specialization.setSpecialties(individual.getPropertyValue(model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL)).toString());
                    hospital.setHospitalName(individual.getPropertyValue(model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL)).toString());
                    hospital.setDays(individual.getPropertyValue(model.getProperty(Constants.DAY_ATTRIBUTE_URL)).toString());
                    hospital.setVisitingHours(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL)).toString());
                    hospital.setVisitingHours2(individual.getPropertyValue(model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL)).toString());
                    hospital.setFeeStructure(individual.getPropertyValue(model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL)).toString());
                    location.setCity(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString());
                    location.setCountry(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString());
                    location.setArea(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString());                  
                    hospital.setLocation(location);
                    doctorProfile.setSpecialization(specialization);
                    doctorProfile.setHospital(hospital);
                    doctorProfiles.add(doctorProfile);
                    success = true;

                }
            }*/
            success = true;
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        } 
        return success;
    }

    public boolean searchDoctor1(String searchQuery, String filename, ArrayList<DoctorProfile> doctorProfiles)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "DoctorProfiles.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            NodeList nodeList = document.getElementsByTagName("DoctorProfile");
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if(
                            (element.getElementsByTagName("hasName").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasEmail").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasContact").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasDateOfBirth").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasGender").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasDegree").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasSpecialist").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasSpecialties").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasHospitalName").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasDay").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasVisitingHours").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasVisitingHours2").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasFeeStructure").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasCity").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasCountry").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase()))||
                            (element.getElementsByTagName("hasArea").item(0).getTextContent().toLowerCase().contains(searchQuery.toLowerCase())))
                    {
                        DoctorProfile doctorProfile = new DoctorProfile();
                        Specialization specialization = new Specialization();
                        Location location = new Location();
                        Hospital hospital = new Hospital();
                        doctorProfile.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                        doctorProfile.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                        doctorProfile.setContact(element.getElementsByTagName("hasContact").item(0).getTextContent());
                        doctorProfile.setDateOfBirth(element.getElementsByTagName("hasDateOfBirth").item(0).getTextContent());
                        doctorProfile.setGender(element.getElementsByTagName("hasGender").item(0).getTextContent());
                        specialization.setDegree(element.getElementsByTagName("hasDegree").item(0).getTextContent());
                        specialization.setSpecialist(element.getElementsByTagName("hasSpecialist").item(0).getTextContent());
                        specialization.setSpecialties(element.getElementsByTagName("hasSpecialties").item(0).getTextContent());
                        hospital.setHospitalName(element.getElementsByTagName("hasHospitalName").item(0).getTextContent());
                        hospital.setDays(element.getElementsByTagName("hasDay").item(0).getTextContent());
                        hospital.setVisitingHours(element.getElementsByTagName("hasVisitingHours").item(0).getTextContent());
                        hospital.setVisitingHours2(element.getElementsByTagName("hasVisitingHours2").item(0).getTextContent());
                        hospital.setFeeStructure(element.getElementsByTagName("hasFeeStructure").item(0).getTextContent());
                        location.setCity(element.getElementsByTagName("hasCity").item(0).getTextContent());
                        location.setCountry(element.getElementsByTagName("hasCountry").item(0).getTextContent());
                        location.setArea(element.getElementsByTagName("hasArea").item(0).getTextContent());
                        UtilityDAL utilityDAL = new UtilityDAL();
                        doctorProfile.setFeedbacks(utilityDAL.loadFeedbacks(doctorProfile.getName(), filename));
                        hospital.setLocation(location);
                        doctorProfile.setHospital(hospital);
                        doctorProfile.setSpecialization(specialization);
                        doctorProfiles.add(doctorProfile);
                    }
                }
            }
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(SearchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(SearchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(SearchDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public static ArrayList<String> printPropertyValues(Individual ind, Property prop) 
    {
        System.out.print( ind.getLocalName() + " has " + prop.getLocalName() + "(s): " );
        printIterator( ind.listPropertyValues( prop ) );
        return namesDoctors;
    }

    public static void printInstances(OntClass cls) 
    {
        System.out.print( cls.getLocalName() + " instances: " );
        printIterator( cls.listInstances() );
    }

    public static ArrayList<String> printIterator(ExtendedIterator i) 
    {
        if( !i.hasNext() ) {
            System.out.print( "none" );
        }
        else {
            while( i.hasNext() ) {
                Resource val = (Resource) i.next();
                System.out.print( val.getLocalName() );
                namesDoctors.add(val.getLocalName());
                if( i.hasNext() )
                    System.out.print( ", " );
            }
        }
        System.out.println();
        return namesDoctors;
    }

    public boolean updateDoctorProfile(DoctorProfile doctorProfile, String filename, int systemRating)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 
            OntModel model = ModelFactory .createOntologyModel( );
            model.read(reader,null);
            
            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + doctorProfile.getId());
            String id = doctorProfile.getId();
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + id, doctorProfileClass);
            
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getId());

            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getName());
          
            myproperty =  model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getEmail());
            
            myproperty =  model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getContact());
            
            myproperty =  model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getDateOfBirth());

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getGender());
            myproperty =  model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getDegree());
            myproperty =  model.getProperty(Constants.DEGREE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            myproperty =  model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getSpecialization().getSpecialist());

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getSpecialties());
            myproperty =  model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            myproperty =  model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getHospitalName());
            
            myproperty =  model.getProperty(Constants.DAY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getDays());
            
            myproperty =  model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getVisitingHours());
            
            myproperty =  model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getVisitingHours2());

            myproperty =  model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getFeeStructure());
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCity());
            myproperty =  model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCountry());
            myproperty =  model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getArea());
            myproperty =  model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

            File xmlFile = new File(filename + "DoctorProfiles.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("DoctorProfile");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(doctorProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctorProfile.getEmail()))))
                    {
                        element.getElementsByTagName("hasId").item(0).setTextContent(doctorProfile.getId());
                        element.getElementsByTagName("hasName").item(0).setTextContent(doctorProfile.getName());
                        element.getElementsByTagName("hasEmail").item(0).setTextContent(doctorProfile.getEmail());
                        element.getElementsByTagName("hasContact").item(0).setTextContent(doctorProfile.getContact());
                        element.getElementsByTagName("hasDateOfBirth").item(0).setTextContent(doctorProfile.getDateOfBirth());
                        element.getElementsByTagName("hasGender").item(0).setTextContent(doctorProfile.getGender());
                        element.getElementsByTagName("hasDegree").item(0).setTextContent(doctorProfile.getSpecialization().getDegree());
                        element.getElementsByTagName("hasSpecialist").item(0).setTextContent(doctorProfile.getSpecialization().getSpecialist());
                        element.getElementsByTagName("hasSpecialties").item(0).setTextContent(doctorProfile.getSpecialization().getSpecialties());
                        element.getElementsByTagName("hasHospitalName").item(0).setTextContent(doctorProfile.getHospital().getHospitalName());
                        element.getElementsByTagName("hasDay").item(0).setTextContent(doctorProfile.getHospital().getDays());
                        element.getElementsByTagName("hasVisitingHours").item(0).setTextContent(doctorProfile.getHospital().getVisitingHours());
                        element.getElementsByTagName("hasVisitingHours2").item(0).setTextContent(doctorProfile.getHospital().getVisitingHours2());
                        element.getElementsByTagName("hasFeeStructure").item(0).setTextContent(doctorProfile.getHospital().getFeeStructure());
                        element.getElementsByTagName("hasCity").item(0).setTextContent(doctorProfile.getHospital().getLocation().getCity());
                        element.getElementsByTagName("hasCountry").item(0).setTextContent(doctorProfile.getHospital().getLocation().getCountry());
                        element.getElementsByTagName("hasArea").item(0).setTextContent(doctorProfile.getHospital().getLocation().getArea());      
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename + "DoctorProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
}
