/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Doctor;
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

/**
 *
 * @author Admin
 */

public class DoctorDAL extends FactoryDAL
{
    @Override
    public boolean createDoctor(Doctor doctor, String filename)
    {
        boolean success = false;
        try 
        {
            File xmlFile = new File(filename + "Doctors.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Document document2 = ((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).parse(new File(filename + "Doctors.xml"));
            Document document3 = ((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).parse(new File(filename + "Patients.xml"));
            ArrayList<String> list = new ArrayList();
            NodeList nodeList1 = document.getElementsByTagName("Admin");
            for (int i = 0; i < nodeList1.getLength(); i++) 
            {
                Node node = nodeList1.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                }
            }
            NodeList nodeList2 = document2.getElementsByTagName("Doctor");
            for (int i = 0; i < nodeList2.getLength(); i++) 
            {
                Node node = nodeList2.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                }
            }
            NodeList nodeList3 = document3.getElementsByTagName("Patient");
            for (int i = 0; i < nodeList3.getLength(); i++) 
            {
                Node node = nodeList3.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    list.add(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                }
            }
            if(!(list.contains(doctor.getEmail())))
            {
                NodeList nodeList = document.getElementsByTagName("Doctors");
                Node node = nodeList.item(0);
                Element elem = (Element)node;

                Element information = document.createElement("Doctor");
                elem.appendChild(information);

                Element email = document.createElement("hasEmail");
                email.appendChild(document.createTextNode(doctor.getEmail()));
                information.appendChild(email);

                Element password = document.createElement("hasPassword");
                password.appendChild(document.createTextNode(doctor.getPassword()));
                information.appendChild(password);

                Element name = document.createElement("hasName");
                name.appendChild(document.createTextNode(doctor.getName()));
                information.appendChild(name);

                Element type = document.createElement("hasType");
                type.appendChild(document.createTextNode(doctor.getUserCategory()));
                information.appendChild(type);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                StreamResult streamResult = new StreamResult(new File(filename + "Doctors.xml"));
    //            StreamResult streamResult = new StreamResult(System.out);

                transformer.transform(source, streamResult);
                success = true;
            }
            else
            {
                success = false;
            }
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
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean viewDoctor(Doctor doctor, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Doctors.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Doctor");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;

                    doctor.setEmail(element.getElementsByTagName("hasEmail").item(0).getTextContent());
                    doctor.setPassword(element.getElementsByTagName("hasPassword").item(0).getTextContent());
                    doctor.setName(element.getElementsByTagName("hasName").item(0).getTextContent());
                    doctor.setUserCategory(element.getElementsByTagName("hasType").item(0).getTextContent());
                }
            }
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean updateDoctor(Doctor doctor, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Doctors.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Doctor");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(doctor.getPassword()))))
                    {
                        element.getElementsByTagName("hasEmail").item(0).setTextContent(doctor.getEmail());
                        element.getElementsByTagName("hasPassword").item(0).setTextContent(doctor.getPassword());
                        element.getElementsByTagName("hasName").item(0).setTextContent(doctor.getName());
                        element.getElementsByTagName("hasType").item(0).setTextContent(doctor.getUserCategory());
                        document.normalize();
                    }
                }
            }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        
        StreamResult streamResult = new StreamResult(new File(filename + "Doctors.xml"));
//        StreamResult streamResult = new StreamResult(System.out);

        transformer.transform(source, streamResult);
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public boolean deleteDoctor(Doctor doctor, String filename)
    {
        boolean success = false;
        try
        {
            File xmlFile = new File(filename + "Doctors.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Doctor");

            for (int i = 0; i < nodeList.getLength(); i++) 
            {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if((element.getElementsByTagName("hasEmail").item(0).getTextContent().equals(doctor.getEmail()))&&((element.getElementsByTagName("hasPassword").item(0).getTextContent().equals(doctor.getPassword()))))
                    {
//                        element.getParentNode().removeChild(element);
                        element.getElementsByTagName("hasEmail").item(0).setTextContent("...");
                        element.getElementsByTagName("hasPassword").item(0).setTextContent("...");
                        element.getElementsByTagName("hasName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasType").item(0).setTextContent("...");
                        document.normalize();
                    }
                }
            }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        
        StreamResult streamResult = new StreamResult(new File(filename + "Doctors.xml"));
//        StreamResult streamResult = new StreamResult(System.out);

        transformer.transform(source, streamResult);
            success = true;
        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (TransformerException ex) 
        {
            Logger.getLogger(DoctorDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}