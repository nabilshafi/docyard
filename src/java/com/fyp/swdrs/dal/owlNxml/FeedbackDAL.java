/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.utility.Utility;
import java.io.File;
import java.io.IOException;
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

public class FeedbackDAL
{
    public boolean createFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
        try 
        {
            File xmlFile = new File(filename + "Feedbacks.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            Utility utility = new Utility();
            double rating = utility.CalculateRating1(feedback.getBehavior1Answer(), feedback.getBehavior2Answer(), feedback.getBehavior3Answer(), feedback.getBehavior4Answer(), feedback.getBehavior5Answer(), feedback.getBehavior6Answer(), feedback.getInteraction1Answer(), feedback.getInteraction2Answer(), feedback.getInteraction3Answer(), feedback.getInteraction4Answer(), feedback.getInteraction5Answer(), feedback.getInteraction6Answer(), feedback.getInteraction7Answer(), feedback.getInteraction8Answer(), feedback.getInteraction9Answer(), feedback.getDiagnosisTimeAnswer(), feedback.getScaleAnswer());
//            DecimalFormat decimalFormat = new DecimalFormat("0.00");
//            feedback.setDoctorRating(Double.toString(decimalFormat.format(rating)));
            feedback.setDoctorRating(Double.toString(rating));
            
            NodeList nId = document.getElementsByTagName("Feedback");
            feedback.setId("f" + Integer.toString(nId.getLength()+1));

            NodeList nodeList = document.getElementsByTagName("Feedbacks");
            Node node = nodeList.item(0);
            Element elem = (Element)node;

            Element information = document.createElement("Feedback");
            elem.appendChild(information);

            Element id = document.createElement("hasId");
            id.appendChild(document.createTextNode(feedback.getId()));
            information.appendChild(id);
       
            Element patientName = document.createElement("hasPatientName");
            patientName.appendChild(document.createTextNode(feedback.getPatientName()));
            information.appendChild(patientName);

            Element patientEmail = document.createElement("hasPatientEmail");
            patientEmail.appendChild(document.createTextNode(feedback.getPatientEmail()));
            information.appendChild(patientEmail);

            Element doctorName = document.createElement("hasDoctorName");
            doctorName.appendChild(document.createTextNode(feedback.getDoctorName()));
            information.appendChild(doctorName);

            Element doctorRating = document.createElement("hasDoctorRating");
            doctorRating.appendChild(document.createTextNode(feedback.getDoctorRating()));
            information.appendChild(doctorRating);

//            Element patientFeedback = document.createElement("hasPatientFeedback");
//            patientFeedback.appendChild(document.createTextNode(feedback.getPatientFeedback()));
//            information.appendChild(patientFeedback);

//            Element introduction1Answer = document.createElement("hasIntroduction1Answer");
//            introduction1Answer.appendChild(document.createTextNode(feedback.getIntroduction1Answer()));
//            information.appendChild(introduction1Answer);

//            Element introduction2Answer = document.createElement("hasIntroduction2Answer");
//            introduction2Answer.appendChild(document.createTextNode(feedback.getIntroduction2Answer()));
//            information.appendChild(introduction2Answer);

//            Element introduction3Answer = document.createElement("hasIntroduction3Answer");
//            introduction3Answer.appendChild(document.createTextNode(feedback.getIntroduction3Answer()));
//            information.appendChild(introduction3Answer);

//            Element introduction4Answer = document.createElement("hasIntroduction4Answer");
//            introduction4Answer.appendChild(document.createTextNode(feedback.getIntroduction4Answer()));
//            information.appendChild(introduction4Answer);

            Element behavior1Answer = document.createElement("hasBehavior1Answer");
            behavior1Answer.appendChild(document.createTextNode(feedback.getBehavior1Answer()));
            information.appendChild(behavior1Answer);
            
            Element behavior2Answer = document.createElement("hasBehavior2Answer");
            behavior2Answer.appendChild(document.createTextNode(feedback.getBehavior2Answer()));
            information.appendChild(behavior2Answer);
            
            Element behavior3Answer = document.createElement("hasBehavior3Answer");
            behavior3Answer.appendChild(document.createTextNode(feedback.getBehavior3Answer()));
            information.appendChild(behavior3Answer);
            
            Element behavior4Answer = document.createElement("hasBehavior4Answer");
            behavior4Answer.appendChild(document.createTextNode(feedback.getBehavior4Answer()));
            information.appendChild(behavior4Answer);
            
            Element behavior5Answer = document.createElement("hasBehavior5Answer");
            behavior5Answer.appendChild(document.createTextNode(feedback.getBehavior5Answer()));
            information.appendChild(behavior5Answer);
            
            Element behavior6Answer = document.createElement("hasBehavior6Answer");
            behavior6Answer.appendChild(document.createTextNode(feedback.getBehavior6Answer()));
            information.appendChild(behavior6Answer);
            
            Element interaction1Answer = document.createElement("hasInteraction1Answer");
            interaction1Answer.appendChild(document.createTextNode(feedback.getInteraction1Answer()));
            information.appendChild(interaction1Answer);

            Element interaction2Answer = document.createElement("hasInteraction2Answer");
            interaction2Answer.appendChild(document.createTextNode(feedback.getInteraction2Answer()));
            information.appendChild(interaction2Answer);

            Element interaction3Answer = document.createElement("hasInteraction3Answer");
            interaction3Answer.appendChild(document.createTextNode(feedback.getInteraction3Answer()));
            information.appendChild(interaction3Answer);

            Element interaction4Answer = document.createElement("hasInteraction4Answer");
            interaction4Answer.appendChild(document.createTextNode(feedback.getInteraction4Answer()));
            information.appendChild(interaction4Answer);

            Element interaction5Answer = document.createElement("hasInteraction5Answer");
            interaction5Answer.appendChild(document.createTextNode(feedback.getInteraction5Answer()));
            information.appendChild(interaction5Answer);

            Element interaction6Answer = document.createElement("hasInteraction6Answer");
            interaction6Answer.appendChild(document.createTextNode(feedback.getInteraction6Answer()));
            information.appendChild(interaction6Answer);

            Element interaction7Answer = document.createElement("hasInteraction7Answer");
            interaction7Answer.appendChild(document.createTextNode(feedback.getInteraction7Answer()));
            information.appendChild(interaction7Answer);

            Element interaction8Answer = document.createElement("hasInteraction8Answer");
            interaction8Answer.appendChild(document.createTextNode(feedback.getInteraction8Answer()));
            information.appendChild(interaction8Answer);

            Element interaction9Answer = document.createElement("hasInteraction9Answer");
            interaction9Answer.appendChild(document.createTextNode(feedback.getInteraction9Answer()));
            information.appendChild(interaction9Answer);
            
            Element diagnosisTimeAnswer = document.createElement("hasDiagnosisTimeAnswer");
            diagnosisTimeAnswer.appendChild(document.createTextNode(feedback.getDiagnosisTimeAnswer()));
            information.appendChild(diagnosisTimeAnswer);
            
            Element scaleAnswer = document.createElement("hasScaleAnswer");
            scaleAnswer.appendChild(document.createTextNode(feedback.getScaleAnswer()));
            information.appendChild(scaleAnswer);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename + "Feedbacks.xml"));
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
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public boolean viewFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
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
                    if((element.getElementsByTagName("hasPatientName").item(0).getTextContent().equals(feedback.getPatientName()))&&(element.getElementsByTagName("hasPatientEmail").item(0).getTextContent().equals(feedback.getPatientEmail()))&&(element.getElementsByTagName("hasDoctorName").item(0).getTextContent().equals(feedback.getDoctorName())))
                    {
                        feedback.setId(element.getElementsByTagName("hasId").item(0).getTextContent());
                        feedback.setPatientName(element.getElementsByTagName("hasPatientName").item(0).getTextContent());
                        feedback.setPatientEmail(element.getElementsByTagName("hasPatientEmail").item(0).getTextContent());
                        feedback.setDoctorName(element.getElementsByTagName("hasDoctorName").item(0).getTextContent());
                        feedback.setDoctorRating(element.getElementsByTagName("hasDoctorRating").item(0).getTextContent());
                        //feedback.setPatientFeedback(element.getElementsByTagName("hasPatientFeedback").item(0).getTextContent());
                        //feedback.setIntroduction1Answer(element.getElementsByTagName("hasIntroduction1Answer").item(0).getTextContent());
                        //feedback.setIntroduction2Answer(element.getElementsByTagName("hasIntroduction2Answer").item(0).getTextContent());
                        //feedback.setIntroduction3Answer(element.getElementsByTagName("hasIntroduction3Answer").item(0).getTextContent());
                        //feedback.setIntroduction4Answer(element.getElementsByTagName("hasIntroduction4Answer").item(0).getTextContent());
                        feedback.setBehavior1Answer(element.getElementsByTagName("hasBehavior1Answer").item(0).getTextContent());
                        feedback.setBehavior2Answer(element.getElementsByTagName("hasBehavior2Answer").item(0).getTextContent());
                        feedback.setBehavior3Answer(element.getElementsByTagName("hasBehavior3Answer").item(0).getTextContent());
                        feedback.setBehavior4Answer(element.getElementsByTagName("hasBehavior4Answer").item(0).getTextContent());
                        feedback.setBehavior5Answer(element.getElementsByTagName("hasBehavior5Answer").item(0).getTextContent());
                        feedback.setBehavior6Answer(element.getElementsByTagName("hasBehavior6Answer").item(0).getTextContent());
                        feedback.setInteraction1Answer(element.getElementsByTagName("hasInteraction1Answer").item(0).getTextContent());
                        feedback.setInteraction2Answer(element.getElementsByTagName("hasInteraction2Answer").item(0).getTextContent());
                        feedback.setInteraction3Answer(element.getElementsByTagName("hasInteraction3Answer").item(0).getTextContent());
                        feedback.setInteraction4Answer(element.getElementsByTagName("hasInteraction4Answer").item(0).getTextContent());
                        feedback.setInteraction5Answer(element.getElementsByTagName("hasInteraction5Answer").item(0).getTextContent());
                        feedback.setInteraction6Answer(element.getElementsByTagName("hasInteraction6Answer").item(0).getTextContent());
                        feedback.setInteraction7Answer(element.getElementsByTagName("hasInteraction7Answer").item(0).getTextContent());
                        feedback.setInteraction8Answer(element.getElementsByTagName("hasInteraction8Answer").item(0).getTextContent());
                        feedback.setInteraction9Answer(element.getElementsByTagName("hasInteraction9Answer").item(0).getTextContent());
                        feedback.setDiagnosisTimeAnswer(element.getElementsByTagName("hasDiagnosisTimeAnswer").item(0).getTextContent());
                        feedback.setScaleAnswer(element.getElementsByTagName("hasScaleAnswer").item(0).getTextContent());
                    }
                }
            }
            success = true;
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
        return success;
    }

    public boolean updateFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
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
                    if((element.getElementsByTagName("hasPatientName").item(0).getTextContent().equals(feedback.getPatientName()))&&(element.getElementsByTagName("hasPatientEmail").item(0).getTextContent().equals(feedback.getPatientEmail())))
                    {
                        element.getElementsByTagName("hasId").item(0).setTextContent(feedback.getId());
                        element.getElementsByTagName("hasPatientName").item(0).setTextContent(feedback.getPatientName());
                        element.getElementsByTagName("hasPatientEmail").item(0).setTextContent(feedback.getPatientEmail());
                        element.getElementsByTagName("hasDoctorName").item(0).setTextContent(feedback.getDoctorName());
                        element.getElementsByTagName("hasDoctorRating").item(0).setTextContent(feedback.getDoctorRating());
                        //element.getElementsByTagName("hasPatientFeedback").item(0).setTextContent(feedback.getPatientFeedback());
                        //element.getElementsByTagName("hasIntroduction1Answer").item(0).setTextContent(feedback.getIntroduction1Answer());
                        //element.getElementsByTagName("hasIntroduction2Answer").item(0).setTextContent(feedback.getIntroduction2Answer());
                        //element.getElementsByTagName("hasIntroduction3Answer").item(0).setTextContent(feedback.getIntroduction3Answer());
                        //element.getElementsByTagName("hasIntroduction4Answer").item(0).setTextContent(feedback.getIntroduction4Answer());
                        element.getElementsByTagName("hasBehavior1Answer").item(0).setTextContent(feedback.getBehavior1Answer());
                        element.getElementsByTagName("hasBehavior2Answer").item(0).setTextContent(feedback.getBehavior2Answer());
                        element.getElementsByTagName("hasBehavior3Answer").item(0).setTextContent(feedback.getBehavior3Answer());
                        element.getElementsByTagName("hasBehavior4Answer").item(0).setTextContent(feedback.getBehavior4Answer());
                        element.getElementsByTagName("hasBehavior5Answer").item(0).setTextContent(feedback.getBehavior5Answer());
                        element.getElementsByTagName("hasBehavior6Answer").item(0).setTextContent(feedback.getBehavior6Answer());
                        element.getElementsByTagName("hasInteraction1Answer").item(0).setTextContent(feedback.getInteraction1Answer());
                        element.getElementsByTagName("hasInteraction2Answer").item(0).setTextContent(feedback.getInteraction2Answer());
                        element.getElementsByTagName("hasInteraction3Answer").item(0).setTextContent(feedback.getInteraction3Answer());
                        element.getElementsByTagName("hasInteraction4Answer").item(0).setTextContent(feedback.getInteraction4Answer());
                        element.getElementsByTagName("hasInteraction5Answer").item(0).setTextContent(feedback.getInteraction5Answer());
                        element.getElementsByTagName("hasInteraction6Answer").item(0).setTextContent(feedback.getInteraction6Answer());
                        element.getElementsByTagName("hasInteraction7Answer").item(0).setTextContent(feedback.getInteraction7Answer());
                        element.getElementsByTagName("hasInteraction8Answer").item(0).setTextContent(feedback.getInteraction8Answer());
                        element.getElementsByTagName("hasInteraction9Answer").item(0).setTextContent(feedback.getInteraction9Answer());
                        element.getElementsByTagName("hasDiagnosisTimeAnswer").item(0).setTextContent(feedback.getDiagnosisTimeAnswer());
                        element.getElementsByTagName("hasScaleAnswer").item(0).setTextContent(feedback.getScaleAnswer());
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File(filename + "Feedbacks.xml"));
            //StreamResult streamResult = new StreamResult(System.out);

            transformer.transform(source, streamResult);
            success = true;
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
        catch (TransformerException ex) 
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public boolean deleteFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
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
                    if((element.getElementsByTagName("hasPatientName").item(0).getTextContent().equals(feedback.getPatientName()))&&(element.getElementsByTagName("hasPatientEmail").item(0).getTextContent().equals(feedback.getPatientEmail())))
                    {
                        //element.getParentNode().removeChild(element);
                        element.getElementsByTagName("hasId").item(0).setTextContent("...");
                        element.getElementsByTagName("hasPatientName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasPatientEmail").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDoctorName").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDoctorRating").item(0).setTextContent("...");
                        //element.getElementsByTagName("hasPatientFeedback").item(0).setTextContent("...");
                        //element.getElementsByTagName("hasIntroduction1Answer").item(0).setTextContent("...");
                        //element.getElementsByTagName("hasIntroduction2Answer").item(0).setTextContent("...");
                        //element.getElementsByTagName("hasIntroduction3Answer").item(0).setTextContent("...");
                        //element.getElementsByTagName("hasIntroduction4Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior1Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior2Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior3Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior4Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior5Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasBehavior6Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction1Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction2Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction3Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction4Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction5Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction6Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction7Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction8Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasInteraction9Answer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasDiagnosisTimeAnswer").item(0).setTextContent("...");
                        element.getElementsByTagName("hasScaleAnswer").item(0).setTextContent("...");
                        document.normalize();
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
        
            StreamResult streamResult = new StreamResult(new File(filename + "Feedbacks.xml"));
            //StreamResult streamResult = new StreamResult(System.out);

        transformer.transform(source, streamResult);
            success = true;
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
        catch (TransformerException ex) 
        {
            Logger.getLogger(FeedbackDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

}