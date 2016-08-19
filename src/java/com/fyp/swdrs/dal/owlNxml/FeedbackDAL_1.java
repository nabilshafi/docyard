/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.utility.Constants;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
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
import org.apache.jena.ext.com.google.common.collect.Iterators;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Admin
 */

public class FeedbackDAL_1
{
    public boolean createFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 
            OntModel model = ModelFactory .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            
            OntClass feedbackProfileClass = model.getOntClass(Constants.FEEDBACK_CLASS_URL);
            Iterator iterator = feedbackProfileClass.listInstances();
            int size = Iterators.size(iterator);
            feedback.setId("f" + Integer.toString(size+1));
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + feedback.getId(), feedbackProfileClass);
            
            File xmlFile = new File(filename + "Feedbacks.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("Feedbacks");
            Node node = nodeList.item(0);
            Element elem = (Element)node;

            Element information = document.createElement("Feedback");
            elem.appendChild(information);

            Element id = document.createElement("hasId");
            id.appendChild(document.createTextNode(feedback.getId()));
            information.appendChild(id);
            Property myproperty = model.getProperty(Constants.ID_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getId());

            Element patientName = document.createElement("hasPatientName");
            patientName.appendChild(document.createTextNode(feedback.getPatientName()));
            information.appendChild(patientName);
            myproperty = model.getProperty(Constants.FEEDBACK_PATIENT_NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getPatientName());

            Element patientEmail = document.createElement("hasPatientEmail");
            patientEmail.appendChild(document.createTextNode(feedback.getPatientEmail()));
            information.appendChild(patientEmail);
            myproperty = model.getProperty(Constants.FEEDBACK_PATIENT_EMAIL_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getPatientEmail());

            Element doctorName = document.createElement("hasDoctorName");
            doctorName.appendChild(document.createTextNode(feedback.getDoctorName()));
            information.appendChild(doctorName);
            myproperty = model.getProperty(Constants.FEEDBACK_DOCTOR_NAME_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getDoctorName());

            Element doctorRating = document.createElement("hasDoctorRating");
            doctorRating.appendChild(document.createTextNode(feedback.getDoctorRating()));
            information.appendChild(doctorRating);
            myproperty = model.getProperty(Constants.FEEDBACK_DOCTOR_RATING_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getDoctorRating());

            //Element patientFeedback = document.createElement("hasPatientFeedback");
            //patientFeedback.appendChild(document.createTextNode(feedback.getPatientFeedback()));
            //information.appendChild(patientFeedback);
            //myproperty = model.getProperty(Constants.FEEDBACK_PATIENT_FEEDBACK_ATTRIBUTE_URL);
            //ind.addProperty(myproperty, feedback.getPatientFeedback());

            //Element introduction1Answer = document.createElement("hasIntroduction1Answer");
            //introduction1Answer.appendChild(document.createTextNode(feedback.getIntroduction1Answer()));
            //information.appendChild(introduction1Answer);
            //myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_1_ANSWER_ATTRIBUTE_URL);
            //ind.addProperty(myproperty, feedback.getIntroduction1Answer());

            //Element introduction2Answer = document.createElement("hasIntroduction2Answer");
            //introduction2Answer.appendChild(document.createTextNode(feedback.getIntroduction2Answer()));
            //information.appendChild(introduction2Answer);
            //myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_2_ANSWER_ATTRIBUTE_URL);
            //ind.addProperty(myproperty, feedback.getIntroduction2Answer());

            //Element introduction3Answer = document.createElement("hasIntroduction3Answer");
            //introduction3Answer.appendChild(document.createTextNode(feedback.getIntroduction3Answer()));
            //information.appendChild(introduction3Answer);
            //myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_3_ANSWER_ATTRIBUTE_URL);
            //ind.addProperty(myproperty, feedback.getIntroduction3Answer());

            //Element introduction4Answer = document.createElement("hasIntroduction4Answer");
            //introduction4Answer.appendChild(document.createTextNode(feedback.getIntroduction4Answer()));
            //information.appendChild(introduction4Answer);
            //myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_4_ANSWER_ATTRIBUTE_URL);
            //ind.addProperty(myproperty, feedback.getIntroduction4Answer());

            Element behavior1Answer = document.createElement("hasBehavior1Answer");
            behavior1Answer.appendChild(document.createTextNode(feedback.getBehavior1Answer()));
            information.appendChild(behavior1Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_1_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior1Answer());

            Element behavior2Answer = document.createElement("hasBehavior2Answer");
            behavior2Answer.appendChild(document.createTextNode(feedback.getBehavior2Answer()));
            information.appendChild(behavior2Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_2_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior2Answer());

            Element behavior3Answer = document.createElement("hasBehavior3Answer");
            behavior3Answer.appendChild(document.createTextNode(feedback.getBehavior3Answer()));
            information.appendChild(behavior3Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_3_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior3Answer());

            Element behavior4Answer = document.createElement("hasBehavior4Answer");
            behavior4Answer.appendChild(document.createTextNode(feedback.getBehavior4Answer()));
            information.appendChild(behavior4Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_4_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior4Answer());

            Element behavior5Answer = document.createElement("hasBehavior5Answer");
            behavior5Answer.appendChild(document.createTextNode(feedback.getBehavior5Answer()));
            information.appendChild(behavior5Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_5_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior5Answer());

            Element behavior6Answer = document.createElement("hasBehavior6Answer");
            behavior6Answer.appendChild(document.createTextNode(feedback.getBehavior6Answer()));
            information.appendChild(behavior6Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_6_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getBehavior6Answer());

            Element interaction1Answer = document.createElement("hasInteraction1Answer");
            interaction1Answer.appendChild(document.createTextNode(feedback.getInteraction1Answer()));
            information.appendChild(interaction1Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_1_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction1Answer());

            Element interaction2Answer = document.createElement("hasInteraction2Answer");
            interaction2Answer.appendChild(document.createTextNode(feedback.getInteraction2Answer()));
            information.appendChild(interaction2Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_2_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction2Answer());

            Element interaction3Answer = document.createElement("hasInteraction3Answer");
            interaction3Answer.appendChild(document.createTextNode(feedback.getInteraction3Answer()));
            information.appendChild(interaction3Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_3_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction3Answer());

            Element interaction4Answer = document.createElement("hasInteraction4Answer");
            interaction4Answer.appendChild(document.createTextNode(feedback.getInteraction4Answer()));
            information.appendChild(interaction4Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_4_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction4Answer());

            Element interaction5Answer = document.createElement("hasInteraction5Answer");
            interaction5Answer.appendChild(document.createTextNode(feedback.getInteraction5Answer()));
            information.appendChild(interaction5Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_5_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction5Answer());

            Element interaction6Answer = document.createElement("hasInteraction6Answer");
            interaction6Answer.appendChild(document.createTextNode(feedback.getInteraction6Answer()));
            information.appendChild(interaction6Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_6_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction6Answer());

            Element interaction7Answer = document.createElement("hasInteraction7Answer");
            interaction7Answer.appendChild(document.createTextNode(feedback.getInteraction7Answer()));
            information.appendChild(interaction7Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_7_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction7Answer());

            Element interaction8Answer = document.createElement("hasInteraction8Answer");
            interaction8Answer.appendChild(document.createTextNode(feedback.getInteraction8Answer()));
            information.appendChild(interaction8Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_8_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction8Answer());

            Element interaction9Answer = document.createElement("hasInteraction9Answer");
            interaction9Answer.appendChild(document.createTextNode(feedback.getInteraction9Answer()));
            information.appendChild(interaction9Answer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_9_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getInteraction9Answer());

            Element diagnosisTimeAnswer = document.createElement("hasDiagnosisTimeAnswer");
            diagnosisTimeAnswer.appendChild(document.createTextNode(feedback.getDiagnosisTimeAnswer()));
            information.appendChild(diagnosisTimeAnswer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_DIAGNOSIS_TIME_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getDiagnosisTimeAnswer());

            Element scaleAnswer = document.createElement("hasScaleAnswer");
            scaleAnswer.appendChild(document.createTextNode(feedback.getScaleAnswer()));
            information.appendChild(scaleAnswer);
            myproperty = model.getProperty(Constants.FEEDBACK_QUESTION_SCALE_ANSWER_ATTRIBUTE_URL);
            ind.addProperty(myproperty, feedback.getScaleAnswer());

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

    public boolean viewFeedback(Feedback feedback, String filename)
    {
        boolean success = false;
        try
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file); 

            OntModel model = ModelFactory .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            OntClass doctorClass = model.getOntClass(Constants.FEEDBACK_CLASS_URL);
            Iterator insIter = doctorClass.listInstances();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                if((individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_PATIENT_NAME_ATTRIBUTE_URL)).toString().equals(feedback.getPatientName()))&&(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_PATIENT_EMAIL_ATTRIBUTE_URL)).toString().equals(feedback.getPatientEmail())))
                {
                    feedback.setId(individual.getPropertyValue(model.getProperty(Constants.ID_ATTRIBUTE_URL)).toString());
                    feedback.setPatientName(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_PATIENT_NAME_ATTRIBUTE_URL)).toString());
                    feedback.setPatientEmail(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_PATIENT_EMAIL_ATTRIBUTE_URL)).toString());
                    feedback.setDoctorName(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_DOCTOR_NAME_ATTRIBUTE_URL)).toString());
                    feedback.setDoctorRating(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_DOCTOR_RATING_ATTRIBUTE_URL)).toString());
                    //feedback.setPatientFeedback(individual.getPropertyValue(model.getProperty(FEEDBACK_QUESTION_INTRODUCTION_1_ANSWER_ATTRIBUTE_URL)).toString());
                    //feedback.setIntroduction1Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_1_ANSWER_ATTRIBUTE_URL)).toString());
                    //feedback.setIntroduction2Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_2_ANSWER_ATTRIBUTE_URL)).toString());
                    //feedback.setIntroduction3Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_3_ANSWER_ATTRIBUTE_URL)).toString());
                    //feedback.setIntroduction4Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTRODUCTION_1_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior1Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_1_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior2Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_2_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior3Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_3_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior4Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_4_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior5Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_5_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setBehavior6Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_BEHAVIOUR_6_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction1Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_1_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction2Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_2_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction3Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_3_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction4Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_4_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction5Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_5_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction6Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_6_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction7Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_7_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction8Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_8_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setInteraction9Answer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_INTERACTION_9_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setDiagnosisTimeAnswer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_DIAGNOSIS_TIME_ANSWER_ATTRIBUTE_URL)).toString());
                    feedback.setScaleAnswer(individual.getPropertyValue(model.getProperty(Constants.FEEDBACK_QUESTION_SCALE_ANSWER_ATTRIBUTE_URL)).toString());
                }
            }
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(PatientProfileDAL.class.getName()).log(Level.SEVERE, null, ex);
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
                    if(element.getElementsByTagName("hasPatientName").item(0).getTextContent().equals(feedback.getPatientName()))
                    {
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
                    if(element.getElementsByTagName("hasPatientName").item(0).getTextContent().equals(feedback.getPatientName()))
                    {
                        //element.getParentNode().removeChild(element);
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
