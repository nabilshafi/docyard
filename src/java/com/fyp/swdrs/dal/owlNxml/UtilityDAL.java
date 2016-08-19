/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Hospital;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.bo.Specialization;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.utility.Constants;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

public class UtilityDAL 
{
    public boolean populateList(ArrayList<String> list, String filename) 
    {
        boolean success = false;
        try 
        {
            FileReader fr = new FileReader(filename + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null) 
            {
                list.add(str);
            }   fr.close(); br.close();
            success = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found!");
        } 
        catch (IOException ex) 
        {
            System.err.println("Exception occured: LoginDAL::verifyLogin !");
        }
        return success;
    }

    public ArrayList<Feedback> loadFeedbacks(String doctorName, String filename)
    {
        ArrayList<Feedback> feedbacks = new ArrayList(); 
        try
        {
            File xmlFile = new File(filename + "Feedbacks.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            NodeList nodeList = document.getElementsByTagName("Feedback");
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if(element.getElementsByTagName("hasDoctorName").item(0).getTextContent().equals(doctorName))
                    {
                        Feedback feedback = new Feedback();
                        feedback.setPatientName(element.getElementsByTagName("hasPatientName").item(0).getTextContent());
                        feedback.setDoctorName(element.getElementsByTagName("hasDoctorName").item(0).getTextContent());
                        feedback.setDoctorRating(element.getElementsByTagName("hasDoctorRating").item(0).getTextContent());
                        feedback.setPatientFeedback(element.getElementsByTagName("hasPatientFeedback").item(0).getTextContent());
                        feedbacks.add(feedback);
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feedbacks;
    }

    public ArrayList<PatientProfile> loadPatientProfiles(String name, String email, String filename)
    {
        ArrayList<PatientProfile> patientProfiles = new ArrayList(); 
        try
        {
            File xmlFile = new File(filename + "PatientProfiles.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            NodeList nodeList = document.getElementsByTagName("PatientProfile");
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(name))&&(element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(email)))
                    {
                        PatientProfile patientProfile = new PatientProfile();
                        Location location = new Location();
                        patientProfile.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                        patientProfile.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                        patientProfile.setContact(element.getElementsByTagName("hasContact").item(0).getTextContent());
                        patientProfile.setDateOfBirth(element.getElementsByTagName("hasDateOfBirth").item(0).getTextContent());
                        patientProfile.setGender(element.getElementsByTagName("hasGender").item(0).getTextContent());
                        patientProfile.setIncomeGroup(element.getElementsByTagName("hasIncomeGroup").item(0).getTextContent());
                        location.setCity(element.getElementsByTagName("hasCity").item(0).getTextContent());
                        location.setCountry(element.getElementsByTagName("hasCountry").item(0).getTextContent());
                        location.setArea(element.getElementsByTagName("hasArea").item(0).getTextContent());
                        patientProfile.setLocation(location);
                        patientProfiles.add(patientProfile);
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientProfiles;
    }

    public ArrayList<DoctorProfile> loadDoctorProfiles(String name, String filename)
    {
        ArrayList<DoctorProfile> doctorProfiles = new ArrayList(); 
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
                    if(element.getElementsByTagName("hasName").item(0).getTextContent().equals(name))
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
                        hospital.setLocation(location);
                        doctorProfile.setHospital(hospital);
                        doctorProfile.setSpecialization(specialization);
                        doctorProfiles.add(doctorProfile);
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctorProfiles;
    }

//    public ArrayList<DoctorProfile> populateDOctorList(String name, String filename)
    public boolean populateDoctorList(ArrayList<String> list, String filename) 
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
                    list.add(element.getElementsByTagName("hasName").item(0).getTextContent());
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public static double calculateSystemRating(String doctorName, String filename)
    {
        double averageRating = 0;
        double sum = 0;
        try
        {
            File xmlFile = new File(filename + "Feedbacks.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            NodeList nodeList = document.getElementsByTagName("Feedback");
            ArrayList<Double> arrI = new ArrayList();
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if(element.getElementsByTagName("hasDoctorName").item(0).getTextContent().equals(doctorName))
                    {
                        arrI.add(Double.parseDouble(element.getElementsByTagName("hasDoctorRating").item(0).getTextContent()));
                    }
                }
            }
            if(arrI.size()>0) 
            {
                for(int j=0; j<arrI.size(); j++)
                {
                    sum += arrI.get(j);
                }
                averageRating = sum/arrI.size();
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return averageRating;
    }

    public boolean retrieveFeedbackQuestions(ArrayList<String> list, String filename)
    {
        boolean success = false;
        FileReader reader = null;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass doctorClass = model.getOntClass(Constants.FEEDBACK_QUESTION_CLASS_URL);
            Iterator insIter = doctorClass.listInstances();
           ArrayList<Integer> op = new ArrayList<Integer>();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                String URI = individual.getURI();
                URI= URI.substring(URI.indexOf(Constants.NS)+1).replace("_", " ");
                op.add(Integer.parseInt(URI));
                //list.add(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                
            }
            Collections.sort(op);
            for(int i =0 ; i < op.size();i++){
                Individual indi = model.getIndividual(Constants.SOURCE_URL+Constants.NS+(op.get(i)+""));
                 list.add(indi.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());        
            }
            success = true;
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(UtilityDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return success;
    }

}
