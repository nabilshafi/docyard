                                                    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.PatientProfile;
import com.fyp.swdrs.bo.Location;
import com.fyp.swdrs.utility.Constants;
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
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
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

public class PatientProfileDAL extends FactoryDAL
{
    @Override
    public boolean createPatientProfile(PatientProfile patientProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            OntClass patientProfileClass = model.getOntClass(Constants.PATIENT_CLASS_URL);
            Iterator iterator = patientProfileClass.listInstances();
            int size = Iterators.size(iterator);
//            doctorProfile.setId("p" + Integer.toString(size+1) + "_" + (patientProfile.getName().replace(" ", "_")));
            patientProfile.setId("p" + Integer.toString(size+2));
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + patientProfile.getId(), patientProfileClass);
            
            File xmlFile = new File(filename + "PatientProfiles.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("PatientProfiles");
            Node node = nodeList.item(0);
            Element elem = (Element)node;

            Element information = document.createElement("PatientProfile");
            elem.appendChild(information);

            Element id = document.createElement("hasId");
            id.appendChild(document.createTextNode(patientProfile.getId()));
            information.appendChild(id);
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getId());

            Element name = document.createElement("hasName");
            name.appendChild(document.createTextNode(patientProfile.getName()));
            information.appendChild(name);
            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getName());

            Element email = document.createElement("hasEmail");
            email.appendChild(document.createTextNode(patientProfile.getEmail()));
            information.appendChild(email);
            myproperty = model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getEmail());

            Element contact = document.createElement("hasContact");
            contact.appendChild(document.createTextNode(patientProfile.getContact()));
            information.appendChild(contact);
            myproperty = model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getContact());

            Element dateOfBirth = document.createElement("hasDateOfBirth");
            dateOfBirth.appendChild(document.createTextNode(patientProfile.getDateOfBirth()));
            information.appendChild(dateOfBirth);
            myproperty = model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getDateOfBirth());

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getGender());
            Element gender = document.createElement("hasGender");
            gender.appendChild(document.createTextNode(patientProfile.getGender()));
            information.appendChild(gender);
            myproperty = model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            Element incomeGroup = document.createElement("hasIncomeGroup");
            incomeGroup.appendChild(document.createTextNode(patientProfile.getIncomeGroup()));
            information.appendChild(incomeGroup);
            myproperty = model.getProperty(Constants.INCOME_GROUP_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getIncomeGroup());

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCity());
            Element city = document.createElement("hasCity");
            city.appendChild(document.createTextNode(patientProfile.getLocation().getCity()));
            information.appendChild(city);
             myproperty = model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCountry());
            Element country = document.createElement("hasCountry");
            country.appendChild(document.createTextNode(patientProfile.getLocation().getCountry()));
            information.appendChild(country);
            myproperty = model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getArea());
            Element area = document.createElement("hasArea");
            area.appendChild(document.createTextNode(patientProfile.getLocation().getArea()));
            information.appendChild(area);
            myproperty = model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename + "PatientProfiles.xml"));
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
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean viewPatientProfile(PatientProfile patientProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass doctorClass = model.getOntClass(Constants.PATIENT_CLASS_URL);
            Iterator insIter = doctorClass.listInstances();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                if((individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString().equals(patientProfile.getName()))&&(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString().equals(patientProfile.getEmail())))
                {
                    Location location = new Location();
                    patientProfile.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                    patientProfile.setName(individual.getPropertyValue(model.getProperty(Constants.NAME_ATTRIBUTE_URL)).toString());
                    patientProfile.setEmail(individual.getPropertyValue(model.getProperty(Constants.EMAIL_ATTRIBUTE_URL)).toString());
                    patientProfile.setContact(individual.getPropertyValue(model.getProperty(Constants.CONTACT_ATTRIBUTE_URL)).toString());
                    patientProfile.setDateOfBirth(individual.getPropertyValue(model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL)).toString());
                    patientProfile.setGender(individual.getPropertyValue(model.getProperty(Constants.GENDER_ATTRIBUTE_URL)).toString());
                    patientProfile.setIncomeGroup(individual.getPropertyValue(model.getProperty(Constants.INCOME_GROUP_ATTRIBUTE_URL)).toString());
                    location.setCity(individual.getPropertyValue(model.getProperty(Constants.CITY_ATTRIBUTE_URL)).toString());
                    location.setCountry(individual.getPropertyValue(model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL)).toString());
                    location.setArea(individual.getPropertyValue(model.getProperty(Constants.AREA_ATTRIBUTE_URL)).toString());
                    patientProfile.setLocation(location);
                    success = true;
                    break;
                }
            }
            success = true;
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }

    @Override
    public boolean updatePatientProfile(PatientProfile patientProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            OntClass patientProfileClass = model.getOntClass(Constants.PATIENT_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + patientProfile.getId());
            String id = patientProfile.getId();
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + id, patientProfileClass);
            
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getId());

            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getName());

            myproperty = model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getEmail());

            myproperty = model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getContact());

            myproperty = model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getDateOfBirth());

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getGender());
            myproperty = model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            myproperty = model.getProperty(Constants.INCOME_GROUP_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getIncomeGroup());

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCity());
            myproperty = model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCountry());
            myproperty = model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty,gend);

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getArea());
            myproperty = model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty, gend);

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

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
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(patientProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patientProfile.getEmail()))))
                    {
                        element.getElementsByTagName("hasId").item(0).setTextContent(patientProfile.getId());
                        element.getElementsByTagName("hasName").item(0).setTextContent(patientProfile.getName());
                        element.getElementsByTagName("hasEmail").item(0).setTextContent(patientProfile.getEmail());
                        element.getElementsByTagName("hasContact").item(0).setTextContent(patientProfile.getContact());
                        element.getElementsByTagName("hasDateOfBirth").item(0).setTextContent(patientProfile.getDateOfBirth());
                        element.getElementsByTagName("hasGender").item(0).setTextContent(patientProfile.getGender());
                        element.getElementsByTagName("hasIncomeGroup").item(0).setTextContent(patientProfile.getIncomeGroup());
                        element.getElementsByTagName("hasCity").item(0).setTextContent(patientProfile.getLocation().getCity());
                        element.getElementsByTagName("hasCountry").item(0).setTextContent(patientProfile.getLocation().getCountry());
                        element.getElementsByTagName("hasArea").item(0).setTextContent(patientProfile.getLocation().getArea());
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename + "PatientProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean deletePatientProfile(PatientProfile patientProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            

            OntClass patientProfileClass = model.getOntClass(Constants.PATIENT_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + patientProfile.getId());
            String id = patientProfile.getId();
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + id, patientProfileClass);

            
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, patientProfile.getId());

            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.DATE_OF_BIRTH_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            Individual gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getGender());
            myproperty = model.getProperty(Constants.GENDER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.INCOME_GROUP_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCity());
            myproperty = model.getProperty(Constants.CITY_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getCountry());
            myproperty = model.getProperty(Constants.COUNTRY_ATTRIBUTE_URL);
            ind.addProperty(myproperty,"...");

            gend = model.getIndividual( Constants.SOURCE_URL +Constants.NS+ patientProfile.getLocation().getArea());
            myproperty = model.getProperty(Constants.AREA_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

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
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(patientProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(patientProfile.getEmail()))))
                    {
                        element.getElementsByTagName("hasId").item(0).setTextContent("...");
                        element.getElementsByTagName("hasName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasEmail").item(0).setTextContent("...");
                        element.getElementsByTagName("hasContact").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDateOfBirth").item(0).setTextContent("...");
                        element.getElementsByTagName("hasGender").item(0).setTextContent("...");
                        element.getElementsByTagName("hasIncomeGroup").item(0).setTextContent("...");
                        element.getElementsByTagName("hasCity").item(0).setTextContent("...");
                        element.getElementsByTagName("hasCountry").item(0).setTextContent("...");
                        element.getElementsByTagName("hasArea").item(0).setTextContent("...");
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename + "PatientProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
