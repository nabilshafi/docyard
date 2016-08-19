package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.AdminProfile;
import com.fyp.swdrs.utility.Constants;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
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

public class AdminProfileDAL extends FactoryDAL
{
    @Override
    public boolean createAdminProfile(AdminProfile adminProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File xmlFile = new File(filename + "AdminProfiles.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("AdminProfiles");
            Node node = nodeList.item(0);
            Element elem = (Element)node;

            Element information = document.createElement("AdminProfile");
            elem.appendChild(information);

            Element name = document.createElement("hasName");
            name.appendChild(document.createTextNode(adminProfile.getName()));
            information.appendChild(name);

            Element email = document.createElement("hasEmail");
            email.appendChild(document.createTextNode(adminProfile.getEmail()));
            information.appendChild(email);

            Element password = document.createElement("hasContact");
            password.appendChild(document.createTextNode(adminProfile.getContact()));
            information.appendChild(password);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename + "AdminProfiles.xml"));
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
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean viewAdminProfile(AdminProfile adminProfile, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "AdminProfiles.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("AdminProfile");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    adminProfile.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                    adminProfile.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                    adminProfile.setContact(element.getElementsByTagName("hasContact").item(0).getTextContent());
                }
            }
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean updateAdminProfile(AdminProfile adminProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            OntClass adminProfileClass = model.getOntClass(Constants.ADMIN_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + adminProfile.getId());
            String id = adminProfile.getId();
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + id, adminProfileClass);
            
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, adminProfile.getId());

            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, adminProfile.getName());

            myproperty = model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, adminProfile.getEmail());

            myproperty = model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, adminProfile.getContact());

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

            File xmlFile = new File(filename + "AdminProfiles.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("AdminProfile");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(adminProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(adminProfile.getEmail()))))
                    {
                        element.getElementsByTagName("hasName").item(0).setTextContent(adminProfile.getName());
                        element.getElementsByTagName("hasEmail").item(0).setTextContent(adminProfile.getEmail());
                        element.getElementsByTagName("hasContact").item(0).setTextContent(adminProfile.getContact());
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename + "AdminProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean deleteAdminProfile(AdminProfile adminProfile, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );

            model.read(reader,null);
            
            OntClass adminProfileClass = model.getOntClass(Constants.ADMIN_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + adminProfile.getId());
            String id = adminProfile.getId();
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + id, adminProfileClass);
            
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, adminProfile.getId());

            myproperty = model.getProperty(Constants.NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            myproperty = model.getProperty(Constants.CONTACT_ATTRIBUTE_URL);
            ind.addProperty(myproperty, "...");

            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();

            File xmlFile = new File(filename + "AdminProfiles.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("AdminProfile");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasName").item(0).getTextContent().equals(adminProfile.getName()))&&((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(adminProfile.getEmail()))))
                    {
                        element.getElementsByTagName("hasName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasEmail").item(0).setTextContent("...");
                        element.getElementsByTagName("hasContact").item(0).setTextContent("...");
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filename + "AdminProfiles.xml"));
//            StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(AdminProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
