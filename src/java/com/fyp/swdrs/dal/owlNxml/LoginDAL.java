/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Admin;
import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.Patient;
import com.fyp.swdrs.bo.Hospital;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.bo.Specialization;
import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.PatientProfile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */

public class LoginDAL extends FactoryDAL
{
    
    
    @Override
    public boolean verifyAdminLogin(Admin admin, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Admins.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Admin");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(admin.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(admin.getPassword()))))
                    {
                        
                        
                        
                        admin.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                        admin.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                        admin.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                        admin.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                        admin.setUserHasProfile(0);

                        File xmlFile2 = new File(filename + "AdminProfiles.xml");
                        DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                        Document document2 = documentBuilder2.parse(xmlFile2);
                        NodeList nodeList2 = document2.getElementsByTagName("AdminProfile");
                        for (int j = 0; j < nodeList2.getLength(); j++) 
                        {
                            Node node2 = nodeList2.item(j);
                            if(node2.getNodeType() == Node.ELEMENT_NODE)
                            {
                                Element element2 = (Element)node2;
                                AdminProfile adminProfile = new AdminProfile();
                                if((element2.getElementsByTagName("hasName").item(0).getTextContent().equals(admin.getName()))&&((element2.getElementsByTagName("hasEmail").item(0).getTextContent().equals(admin.getEmail()))))
                                {
                                    admin.setUserHasProfile(admin.getUserHasProfile() + 1);
                                    adminProfile.setId(element2.getElementsByTagName("hasId").item(0).getTextContent());
                                    adminProfile.setName(element2.getElementsByTagName("hasName").item(0).getTextContent());
                                    adminProfile.setEmail(element2.getElementsByTagName("hasEmail").item(0).getTextContent());
                                    adminProfile.setContact(element2.getElementsByTagName("hasContact").item(0).getTextContent());
                                    admin.setAdminProfile(adminProfile);                    
                                }
                            }
                        }
                        success = true;
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
 
    @Override
    public boolean changeAdminPassword(Admin admin, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Admins.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            ArrayList<String> list1 = new ArrayList();
            ArrayList<String> list2 = new ArrayList();
            NodeList nodeList1 = document.getElementsByTagName("Admin");
            for (int i = 0; i < nodeList1.getLength(); i++) 
            {
                Node node = nodeList1.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list1.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                    list2.add(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                }
            }
//            if((list1.contains(admin.getEmail())) && (!(list2.contains(admin.getPassword()))))
            if(list1.contains(admin.getEmail()))
            {
                NodeList nodeList = document.getElementsByTagName("Admin");
                for (int i = 0; i < nodeList.getLength(); i++) 
                {
                    Node node = nodeList.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if(element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(admin.getEmail()))
                        {
                            element.getElementsByTagName("hasEmail").item(0).setTextContent(admin.getEmail());
                            element.getElementsByTagName("hasPassword").item(0).setTextContent(admin.getPassword());
                            document.normalize();
                        }
                    }
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                StreamResult streamResult = new StreamResult(new File(filename + "Admins.xml"));
    //            StreamResult streamResult = new StreamResult(System.out);

                transformer.transform(source, streamResult);

                File xmlFile2 = new File(filename + "Admins.xml");
                DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                Document document2 = documentBuilder2.parse(xmlFile2);
                NodeList nodeList2 = document2.getElementsByTagName("Admin");
                for (int i = 0; i < nodeList2.getLength(); i++) 
                {
                    Node node = nodeList2.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(admin.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(admin.getPassword()))))
                        {
                            admin.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                            admin.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                            admin.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                            admin.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                            success = true;
                        }
                    }
                }            
            }
            else
            {
                success = false;
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean verifyDoctorLogin(Doctor doctor, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Doctors.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Doctor");

//            Connection myconnection = null;
//        Statement mystatement = null;
//        ResultSet myresultstat=null;
//        
//        myconnection = DriverManager.getConnection("jdbc:mysql://localhost:5000/doctor","root","123");
//        mystatement = myconnection.createStatement();
//        
//        String sql = "select * from Users";
//        String a = null;
//        //if the update query was successful it will return the no. of rows affected
//        myresultstat = mystatement.executeQuery(sql);
//        while(myresultstat.next()){
//            a = myresultstat.getString("docEmail")+","+myresultstat.getString("docName");
//            System.out.println(a);
//            if(myresultstat.getString("docEmail").equals(doctor.getEmail())&&myresultstat.getString("docPassword").equals(doctor.getPassword())){
//                        doctor.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
//                        doctor.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
//                        doctor.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
//                        doctor.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
//                        doctor.setUserHasProfile(0);
//
//                        File xmlFile2 = new File(filename + "DoctorProfiles.xml");
//                        DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
//                        DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
//                        Document document2 = documentBuilder2.parse(xmlFile2);
//                        NodeList nodeList2 = document2.getElementsByTagName("DoctorProfile");
//                        for (int j = 0; j < nodeList2.getLength(); j++) 
//                        {
//                            Node node2 = nodeList2.item(j);
//                            if(node2.getNodeType() == Node.ELEMENT_NODE)
//                            {
//                                Element element2 = (Element)node2;
//                                Location location = new Location();
//                                Hospital hospital = new Hospital();
//                                Specialization specialization = new Specialization();
//                                DoctorProfile doctorProfile = new DoctorProfile();
//                                if((element2.getElementsByTagName("hasName").item(0).getTextContent().equals(doctor.getName()))&&((element2.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))))
//                                {
//                                    doctor.setUserHasProfile(doctor.getUserHasProfile() + 1);
//                                    doctorProfile.setName(element2.getElementsByTagName("hasName").item(0).getTextContent());
//                                    doctorProfile.setEmail(element2.getElementsByTagName("hasEmail").item(0).getTextContent());
//                                    doctorProfile.setContact(element2.getElementsByTagName("hasContact").item(0).getTextContent());
//                                    doctorProfile.setDateOfBirth(element2.getElementsByTagName("hasDateOfBirth").item(0).getTextContent());
//                                    doctorProfile.setGender(element2.getElementsByTagName("hasGender").item(0).getTextContent());
//                                    specialization.setDegree(element2.getElementsByTagName("hasDegree").item(0).getTextContent());
//                                    specialization.setSpecialist(element2.getElementsByTagName("hasSpecialist").item(0).getTextContent());
//                                    specialization.setSpecialties(element2.getElementsByTagName("hasSpecialties").item(0).getTextContent());
//                                    hospital.setHospitalName(element2.getElementsByTagName("hasHospitalName").item(0).getTextContent());
//                                    hospital.setDays(element2.getElementsByTagName("hasDay").item(0).getTextContent());
//                                    hospital.setVisitingHours(element2.getElementsByTagName("hasVisitingHours").item(0).getTextContent());
//                                    hospital.setVisitingHours2(element2.getElementsByTagName("hasVisitingHours2").item(0).getTextContent());
//                                    hospital.setFeeStructure(element2.getElementsByTagName("hasFeeStructure").item(0).getTextContent());
//                                    location.setCity(element2.getElementsByTagName("hasCity").item(0).getTextContent());
//                                    location.setCountry(element2.getElementsByTagName("hasCountry").item(0).getTextContent());
//                                    location.setArea(element2.getElementsByTagName("hasArea").item(0).getTextContent());
//                                    hospital.setLocation(location);
//                                    doctorProfile.setSpecialization(specialization);
//                                    doctorProfile.setHospital(hospital);
//                                    doctor.setDoctorProfile(doctorProfile);                    
//                                }
//                            }
//                        }
//                        success = true;
//                
//            }
//        }
        
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(doctor.getPassword()))))
                    {
                        doctor.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                        doctor.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                        doctor.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                        doctor.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                        doctor.setUserHasProfile(0);

                        File xmlFile2 = new File(filename + "DoctorProfiles.xml");
                        DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                        Document document2 = documentBuilder2.parse(xmlFile2);
                        NodeList nodeList2 = document2.getElementsByTagName("DoctorProfile");
                        for (int j = 0; j < nodeList2.getLength(); j++) 
                        {
                            Node node2 = nodeList2.item(j);
                            if(node2.getNodeType() == Node.ELEMENT_NODE)
                            {
                                Element element2 = (Element)node2;
                                Location location = new Location();
                                Hospital hospital = new Hospital();
                                Specialization specialization = new Specialization();
                                DoctorProfile doctorProfile = new DoctorProfile();
                                if((element2.getElementsByTagName("hasName").item(0).getTextContent().equals(doctor.getName()))&&((element2.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))))
                                {
                                    doctor.setUserHasProfile(doctor.getUserHasProfile() + 1);
                                    doctorProfile.setId(element2.getElementsByTagName("hasId").item(0).getTextContent());
                                    doctorProfile.setName(element2.getElementsByTagName("hasName").item(0).getTextContent());
                                    doctorProfile.setEmail(element2.getElementsByTagName("hasEmail").item(0).getTextContent());
                                    doctorProfile.setContact(element2.getElementsByTagName("hasContact").item(0).getTextContent());
                                    doctorProfile.setDateOfBirth(element2.getElementsByTagName("hasDateOfBirth").item(0).getTextContent());
                                    doctorProfile.setGender(element2.getElementsByTagName("hasGender").item(0).getTextContent());
                                    specialization.setDegree(element2.getElementsByTagName("hasDegree").item(0).getTextContent());
                                    specialization.setSpecialist(element2.getElementsByTagName("hasSpecialist").item(0).getTextContent());
                                    specialization.setSpecialties(element2.getElementsByTagName("hasSpecialties").item(0).getTextContent());
                                    hospital.setHospitalName(element2.getElementsByTagName("hasHospitalName").item(0).getTextContent());
                                    hospital.setDays(element2.getElementsByTagName("hasDay").item(0).getTextContent());
                                    hospital.setVisitingHours(element2.getElementsByTagName("hasVisitingHours").item(0).getTextContent());
                                    hospital.setVisitingHours2(element2.getElementsByTagName("hasVisitingHours2").item(0).getTextContent());
                                    hospital.setFeeStructure(element2.getElementsByTagName("hasFeeStructure").item(0).getTextContent());
                                    location.setCity(element2.getElementsByTagName("hasCity").item(0).getTextContent());
                                    location.setCountry(element2.getElementsByTagName("hasCountry").item(0).getTextContent());
                                    location.setArea(element2.getElementsByTagName("hasArea").item(0).getTextContent());
                                    hospital.setLocation(location);
                                    doctorProfile.setSpecialization(specialization);
                                    doctorProfile.setHospital(hospital);
                                    doctor.setDoctorProfile(doctorProfile);                    
                                }
                            }
                        }
                        success = true;
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (SQLException ex) {
//            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return success;
    }
 
    @Override
    public boolean changeDoctorPassword(Doctor doctor, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Doctors.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            ArrayList<String> list1 = new ArrayList();
            ArrayList<String> list2 = new ArrayList();
            NodeList nodeList1 = document.getElementsByTagName("Doctor");
            for (int i = 0; i < nodeList1.getLength(); i++) 
            {
                Node node = nodeList1.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list1.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                    list2.add(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                }
            }
//            if((list1.contains(doctor.getEmail())) && (!(list2.contains(doctor.getPassword()))))
            if(list1.contains(doctor.getEmail()))
            {
                NodeList nodeList = document.getElementsByTagName("Doctor");
                for (int i = 0; i < nodeList.getLength(); i++) 
                {
                    Node node = nodeList.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if(element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))
                        {
                            element.getElementsByTagName("hasEmail").item(0).setTextContent(doctor.getEmail());
                            element.getElementsByTagName("hasPassword").item(0).setTextContent(doctor.getPassword());
                            document.normalize();
                        }
                    }
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                StreamResult streamResult = new StreamResult(new File(filename + "Doctors.xml"));
    //            StreamResult streamResult = new StreamResult(System.out);

                transformer.transform(source, streamResult);

                File xmlFile2 = new File(filename + "Doctors.xml");
                DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                Document document2 = documentBuilder2.parse(xmlFile2);
                NodeList nodeList2 = document2.getElementsByTagName("Doctor");
                for (int i = 0; i < nodeList2.getLength(); i++) 
                {
                    Node node = nodeList2.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(doctor.getPassword()))))
                        {
                            doctor.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                            doctor.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                            doctor.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                            doctor.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                            success = true;
                        }
                    }
                }
            }
            else
            {
                success = false;
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    @Override
    public boolean verifyPatientLogin(Patient patient, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Patients.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Patient");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patient.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(patient.getPassword()))))
                    {
                        patient.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                        patient.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                        patient.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                        patient.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                        patient.setUserHasProfile(0);

                        File xmlFile2 = new File(filename + "PatientProfiles.xml");
                        DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                        Document document2 = documentBuilder2.parse(xmlFile2);
                        NodeList nodeList2 = document2.getElementsByTagName("PatientProfile");
                        for (int j = 0; j < nodeList2.getLength(); j++) 
                        {
                            Node node2 = nodeList2.item(j);
                            if(node2.getNodeType() == Node.ELEMENT_NODE)
                            {
                                Element element2 = (Element)node2;
                                Location location = new Location();
                                PatientProfile patientProfile = new PatientProfile();
                                if((element2.getElementsByTagName("hasName").item(0).getTextContent().equals(patient.getName()))&&((element2.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patient.getEmail()))))
                                {
                                    patient.setUserHasProfile(patient.getUserHasProfile() + 1);
                                    patientProfile.setId(element2.getElementsByTagName("hasId").item(0).getTextContent());
                                    patientProfile.setName(element2.getElementsByTagName("hasName").item(0).getTextContent());
                                    patientProfile.setEmail(element2.getElementsByTagName("hasEmail").item(0).getTextContent());
                                    patientProfile.setContact(element2.getElementsByTagName("hasContact").item(0).getTextContent());
                                    patientProfile.setDateOfBirth(element2.getElementsByTagName("hasDateOfBirth").item(0).getTextContent());
                                    patientProfile.setGender(element2.getElementsByTagName("hasGender").item(0).getTextContent());
                                    patientProfile.setIncomeGroup(element2.getElementsByTagName("hasIncomeGroup").item(0).getTextContent());
                                    location.setCity(element2.getElementsByTagName("hasCity").item(0).getTextContent());
                                    location.setCountry(element2.getElementsByTagName("hasCountry").item(0).getTextContent());
                                    location.setArea(element2.getElementsByTagName("hasArea").item(0).getTextContent());
                                    patientProfile.setLocation(location);
                                    patient.setPatientProfile(patientProfile);                    
                                }
                            }
                        }
                        success = true;
                    }
                }
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
 
    @Override
    public boolean changePatientPassword(Patient patient, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Patients.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            ArrayList<String> list1 = new ArrayList();
            ArrayList<String> list2 = new ArrayList();
            NodeList nodeList1 = document.getElementsByTagName("Patient");
            for (int i = 0; i < nodeList1.getLength(); i++) 
            {
                Node node = nodeList1.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list1.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                    list2.add(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                }
            }
//            if((list1.contains(patient.getEmail())) && (!(list2.contains(patient.getPassword()))))
            if(list1.contains(patient.getEmail()))
            {
                NodeList nodeList = document.getElementsByTagName("Patient");
                for (int i = 0; i < nodeList.getLength(); i++) 
                {
                    Node node = nodeList.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if(element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patient.getEmail()))
                        {
                            element.getElementsByTagName("hasEmail").item(0).setTextContent(patient.getEmail());
                            element.getElementsByTagName("hasPassword").item(0).setTextContent(patient.getPassword());
                            document.normalize();
                        }
                    }
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                StreamResult streamResult = new StreamResult(new File(filename + "Patients.xml"));
    //            StreamResult streamResult = new StreamResult(System.out);

                transformer.transform(source, streamResult);


                File xmlFile2 = new File(filename + "Patients.xml");
                DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
                Document document2 = documentBuilder2.parse(xmlFile2);
                NodeList nodeList2 = document2.getElementsByTagName("Patient");
                for (int i = 0; i < nodeList2.getLength(); i++) 
                {
                    Node node = nodeList2.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element element = (Element)node;
                        if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patient.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(patient.getPassword()))))
                        {
                            patient.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                            patient.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                            patient.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                            patient.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                            success = true;
                        }
                    }
                }            
            }
            else
            {
                success = false;
            }
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(LoginDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
