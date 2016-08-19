/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;


import com.fyp.swdrs.bo.Doctor;
import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.bo.Hospital;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.bo.Specialization;
import com.fyp.swdrs.utility.Constants;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import java.util.Iterator;
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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.jena.ext.com.google.common.collect.Iterators;
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

public class DoctorProfileDAL extends FactoryDAL
{
    @Override
    public boolean createDoctorProfile(DoctorProfile doctorProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 
             OntModel model = ModelFactory .createOntologyModel( );
            model.read(reader,null);
            
            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator iterator = doctorProfileClass.listInstances();
            int size = Iterators.size(iterator);
//            doctorProfile.setId("d" + Integer.toString(size+1) + "_" + (doctorProfile.getName().replace(" ", "_")));
             doctorProfile.setId("d" + Integer.toString(size+1));
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + doctorProfile.getId(), doctorProfileClass);
            
            File xmlFile = new File(filename + "DoctorProfiles.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("DoctorProfiles");
            Node node = nodeList.item(0);
            Element elem = (Element)node;

            Element information = document.createElement("DoctorProfile");
            elem.appendChild(information);

            Element id = document.createElement("hasId");
            id.appendChild(document.createTextNode(doctorProfile.getId()));
            information.appendChild(id);
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getId());

            Element name = document.createElement("hasName");
            name.appendChild(document.createTextNode(doctorProfile.getName()));
            information.appendChild(name);
            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getName());
          
            Element email = document.createElement("hasEmail");
            email.appendChild(document.createTextNode(doctorProfile.getEmail()));
            information.appendChild(email);
            myproperty =  model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getEmail());
            
            Element contact = document.createElement("hasContact");
            contact.appendChild(document.createTextNode(doctorProfile.getContact()));
            information.appendChild(contact);
            myproperty =  model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getContact());
            
            Element dateOfBirth = document.createElement("hasDateOfBirth");
            dateOfBirth.appendChild(document.createTextNode(doctorProfile.getDateOfBirth()));
            information.appendChild(dateOfBirth);
            myproperty =  model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getDateOfBirth());

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getGender());
            Element gender = document.createElement("hasGender");
            gender.appendChild(document.createTextNode(doctorProfile.getGender()));
            information.appendChild(gender);
            myproperty =  model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getDegree());
            Element degree = document.createElement("hasDegree");
            degree.appendChild(document.createTextNode(doctorProfile.getSpecialization().getDegree()));
            information.appendChild(degree);
            myproperty =  model.getProperty(Constants.DEGREE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            Element specialist = document.createElement("hasSpecialist");
            specialist.appendChild(document.createTextNode(doctorProfile.getSpecialization().getSpecialist()));
            information.appendChild(specialist);
            myproperty =  model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getSpecialization().getSpecialist());

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getSpecialties());
            Element specialties = document.createElement("hasSpecialties");
            specialties.appendChild(document.createTextNode(doctorProfile.getSpecialization().getSpecialties()));
            information.appendChild(specialties);
            myproperty =  model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            Element hospitalName = document.createElement("hasHospitalName");
            hospitalName.appendChild(document.createTextNode(doctorProfile.getHospital().getHospitalName()));
            information.appendChild(hospitalName);
            myproperty =  model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getHospitalName());
            
            Element day = document.createElement("hasDay");
            day.appendChild(document.createTextNode(doctorProfile.getHospital().getDays()));
            information.appendChild(day);
            myproperty =  model.getProperty(Constants.DAY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getDays());
            
            Element visitingHours = document.createElement("hasVisitingHours");
            visitingHours.appendChild(document.createTextNode(doctorProfile.getHospital().getVisitingHours()));
            information.appendChild(visitingHours);
            myproperty =  model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getVisitingHours());

            Element visitingHours2 = document.createElement("hasVisitingHours2");
            visitingHours2.appendChild(document.createTextNode(doctorProfile.getHospital().getVisitingHours2()));
            information.appendChild(visitingHours2);
            myproperty =  model.getProperty(Constants.VISITING_HOURS_2_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getVisitingHours2());

            Element feeStructure = document.createElement("hasFeeStructure");
            feeStructure.appendChild(document.createTextNode(doctorProfile.getHospital().getFeeStructure()));
            information.appendChild(feeStructure);
            myproperty =  model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, doctorProfile.getHospital().getFeeStructure());
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCity());
            Element city = document.createElement("hasCity");
            city.appendChild(document.createTextNode(doctorProfile.getHospital().getLocation().getCity()));
            information.appendChild(city);
            myproperty =  model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);
            
             gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCountry());
            Element country = document.createElement("hasCountry");
            country.appendChild(document.createTextNode(doctorProfile.getHospital().getLocation().getCountry()));
            information.appendChild(country);
            myproperty =  model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getArea());
            Element area = document.createElement("hasArea");
            area.appendChild(document.createTextNode(doctorProfile.getHospital().getLocation().getArea()));
            information.appendChild(area);
            myproperty =  model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);
            
            Element systemRating = document.createElement("hasSystemRating");
            systemRating.appendChild(document.createTextNode(Double.toString(0)));
            information.appendChild(systemRating);
            myproperty = model.getProperty(Constants.SYSTEM_RATING_ATTRIBUTE_URL);
            ind.addProperty(myproperty, Double.toString(0));
          
            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename + "DoctorProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);
            transformer.transform(source, streamResult);
            success = true;
        }
        catch (ParserConfigurationException parserConfigurationException) 
        {
            parserConfigurationException.printStackTrace();
        }
        catch (TransformerException transformerException) 
        {
            transformerException.printStackTrace();
        }
        catch (SAXException ex) 
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean viewDoctorProfile(DoctorProfile doctorProfile, String filename)
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
                    Location location = new Location();
                    Specialization specialization = new Specialization();
                    Hospital hospital = new Hospital();
                    doctorProfile.setId(element.getElementsByTagName("hasId").item(0).getTextContent());
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
                    doctorProfile.setSystemRating(Double.parseDouble(element.getElementsByTagName("hasSystemRating").item(0).getTextContent()));                    
                    hospital.setLocation(location);
                    doctorProfile.setSpecialization(specialization);
                    doctorProfile.setHospital(hospital);
                }
            }
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean updateDoctorProfile(DoctorProfile doctorProfile, String filename)
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

            myproperty =  model.getProperty(Constants.SYSTEM_RATING_ATTRIBUTE_URL);
            ind.addProperty(myproperty, Double.toString(doctorProfile.getSystemRating()));

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
                        element.getElementsByTagName("hasSystemRating").item(0).setTextContent(Double.toString(doctorProfile.getSystemRating()));      
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

    @Override
    public boolean deleteDoctorProfile(DoctorProfile doctorProfile, String filename)
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
            ind.addProperty(myproperty, "...");
          
            myproperty =  model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            myproperty =  model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            myproperty =  model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getGender());
            myproperty =  model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getDegree());
            myproperty =  model.getProperty(Constants.DEGREE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            myproperty =  model.getProperty(Constants.SPECIALIST_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getSpecialization().getSpecialties());
            myproperty =  model.getProperty(Constants.SPECIALTIES_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty =  model.getProperty(Constants.HOSPITAL_NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            myproperty =  model.getProperty(Constants.DAY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            myproperty =  model.getProperty(Constants.VISITING_HOURS_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty =  model.getProperty(Constants.FEE_STRUCTURE_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCity());
            myproperty =  model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getCountry());
            myproperty =  model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");
            
            gend = model.getIndividual(Constants.SOURCE_URL +Constants.NS+doctorProfile.getHospital().getLocation().getArea());
            myproperty =  model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty =  model.getProperty(Constants.SYSTEM_RATING_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

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
                        element.getElementsByTagName("hasId").item(0).setTextContent("...");
                        element.getElementsByTagName("hasName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasEmail").item(0).setTextContent("...");
                        element.getElementsByTagName("hasContact").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDateOfBirth").item(0).setTextContent("...");
                        element.getElementsByTagName("hasGender").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDegree").item(0).setTextContent("...");
                        element.getElementsByTagName("hasSpecialist").item(0).setTextContent("...");
                        element.getElementsByTagName("hasSpecialties").item(0).setTextContent("...");
                        element.getElementsByTagName("hasHospitalName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDay").item(0).setTextContent("...");
                        element.getElementsByTagName("hasVisitingHours").item(0).setTextContent("...");
                        element.getElementsByTagName("hasVisitingHours2").item(0).setTextContent("...");
                        element.getElementsByTagName("hasFeeStructure").item(0).setTextContent("...");
                        element.getElementsByTagName("hasCity").item(0).setTextContent("...");
                        element.getElementsByTagName("hasCountry").item(0).setTextContent("...");
                        element.getElementsByTagName("hasArea").item(0).setTextContent("...");   
                        element.getElementsByTagName("hasSystemRating").item(0).setTextContent("...");   
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

    public boolean viewDoctorProfile1(Doctor doctor, String filename, ArrayList<DoctorProfile> drProfile) 
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 

            OntModel model = ModelFactory .createOntologyModel(OntModelSpec.OWL_DL_MEM );
            model.read(reader,null);

            OntClass doctorClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator insIter = doctorClass.listInstances();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                
                if((individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString().equals(doctor.getName()))&&(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString().equals(doctor.getEmail())))
                {
                    DoctorProfile doctorProfile = new DoctorProfile();
                    Location location = new Location();
                    Specialization specialization = new Specialization();
                    Hospital hospital = new Hospital();
                    doctorProfile.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                    doctorProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                    doctorProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                    doctorProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                    doctorProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                    doctorProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                    specialization.setDegree(individual.getPropertyValue(model.getObjectProperty(Constants.DEGREE_ATTRIBUTE_URL)).toString());
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
                    doctorProfile.setSystemRating(Double.parseDouble(individual.getPropertyValue(model.getProperty(Constants.SYSTEM_RATING_ATTRIBUTE_URL)).toString()));                  
                    hospital.setLocation(location);
                    doctorProfile.setSpecialization(specialization);
                    doctorProfile.setHospital(hospital);
                    drProfile.add(doctorProfile);
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
    
    public boolean updateDoctorProfile1(DoctorProfile doctorProfile, String filename, int profileNumber)
    {
        boolean success = false;
        try 
        {
           File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            
            
            
            OntClass doctorProfileClass = model.getOntClass(Constants.DOCTOR_CLASS_URL);
            Iterator iterator = doctorProfileClass.listInstances();
            int size = Iterators.size(iterator);
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

           // Individual gend = (Individual) model.getIndividual( Constants.SOURCE_URL +Constants.NS+ doctorProfile.getGender());
            String abc = Constants.SOURCE_URL +Constants.NS+ doctorProfile.getGender();
            Individual gend = (Individual) model.getIndividual( Constants.SOURCE_URL +Constants.NS+ "Male");
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

            myproperty =  model.getProperty(Constants.SYSTEM_RATING_ATTRIBUTE_URL);
            ind.addProperty(myproperty, Double.toString(doctorProfile.getSystemRating()));

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
            int count = 0;
            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {                    
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(doctorProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctorProfile.getEmail()))))
                    {
                        if(count == profileNumber)
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
                            element.getElementsByTagName("hasSystemRating").item(0).setTextContent(Double.toString(doctorProfile.getSystemRating()));
                            document.normalize();
                        }
                        count++;
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