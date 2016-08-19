/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fyp.swdrs.dal.owlNxml;

import com.fyp.swdrs.utility.Constants;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindswap.pellet.jena.PelletReasonerFactory;

/**
 *
 * @author Admin
 */

public class IncomeGroupDAL 
{   
    public boolean createIncomeGroup(String crudValue, String filename)
    {
        boolean success = false;
        ArrayList<String> list = new ArrayList();
        try 
        {
            FileReader fr = new FileReader(filename + "Income_Groups.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null) 
            {
                list.add(str);
            }   fr.close(); br.close();
            list.add(crudValue);
            FileWriter fw = new FileWriter(filename + "Income_Groups.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0; i<list.size(); i++)
            {
                pw.println(list.get(i));
            }   fw.close();pw.close();
//            Collections.sort(list);
            success = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found!");
        } 
        catch (IOException ex) 
        {
            System.err.println("Exception occured: IncomeGroupDAL::create!");
        }
        return success;
    }
    
    public boolean viewIncomeGroup(ArrayList<String> list, String filename)
    {
        boolean success = false;
        try 
        {
            FileReader fr = new FileReader(filename + "Income_Groups.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null) 
            {
                list.add(str);
            }   fr.close(); br.close();
//            Collections.sort(list);
            success = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found!");
        } 
        catch (IOException ex) 
        {
            System.err.println("Exception occured: IncomeGroupDAL::create!");
        }
        return success;
    }
    
    public boolean updateIncomeGroup(ArrayList<String> list, String filename)
    {
        boolean success = false;
        try 
        {
            FileWriter fw = new FileWriter(filename + "Income_Groups.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0; i<list.size(); i++)
            {
                if(!(list.get(i).equals("")))
                {
                    pw.println(list.get(i));
                }
            }   fw.close();pw.close();
            success = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found!");
        } 
        catch (IOException ex) 
        {
            System.err.println("Exception occured: IncomeGroupDAL::create!");
        }
        return success;
    }

    public boolean deleteIncomeGroup(String crudValue, String filename)
    {
        boolean success = false;
        ArrayList<String> list = new ArrayList();
        try 
        {
            FileReader fr = new FileReader(filename + "Income_Groups.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null) 
            {
                list.add(str);
            }   fr.close(); br.close();
            FileWriter fw = new FileWriter(filename + "Income_Groups.txt");
            PrintWriter pw = new PrintWriter(fw);
            list.remove(crudValue);
            for(int i=0; i<list.size(); i++)
            {
                pw.println(list.get(i));
            }   fw.close();pw.close();
//            Collections.sort(list);
            success = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.err.println("File not found!");
        } 
        catch (IOException ex) 
        {
            System.err.println("Exception occured: IncomeGroupDAL::create!");
        }
        return success;
    }
    
    public boolean create(String crudValue, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass adminCrudClass = model.getOntClass(Constants.GENDER_CLASS_URL);
            Iterator iterator = adminCrudClass.listInstances();
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + crudValue, adminCrudClass);
            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(IncomeGroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public boolean view(ArrayList<String> list, String filename)
    {
        boolean success = false;
        FileReader reader = null;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            reader = new FileReader(file);
            OntModel model = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass adminCrudClass = model.getOntClass(Constants.GENDER_CLASS_URL);
            Iterator insIter = adminCrudClass.listInstances();
            while(insIter.hasNext())
            {
                Individual individual = (Individual) insIter.next();
                String URI = individual.getURI();
                URI= URI.substring(URI.indexOf(Constants.NS)+1);
                list.add(URI);
            }
            Collections.sort(list);
            success = true;
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(IncomeGroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public boolean update(String oldCrudValue, String newCrudValue, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass adminCrudClass = model.getOntClass(Constants.GENDER_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + oldCrudValue);
            model.removeAll(indvi,null,null);
            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + newCrudValue, adminCrudClass);
            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(IncomeGroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public boolean delete(String crudValue, String filename)
    {
        boolean success = false;
        try 
        {
            File file = new File(filename + "Doctor.owl");
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory .createOntologyModel(PelletReasonerFactory.THE_SPEC );
            model.read(reader,null);
            OntClass adminCrudClass = model.getOntClass(Constants.GENDER_CLASS_URL);
            Individual indvi = model.getIndividual(Constants.SOURCE_URL + Constants.NS + crudValue);
            model.removeAll(indvi,null,null);
//            Individual ind = model.createIndividual(Constants.SOURCE_URL + Constants.NS + newCrudValue, adminCrudClass);
            StringWriter sw = new StringWriter();
            model.write(sw, "RDF/XML-ABBREV");
            String owlCode = sw.toString(); 
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
            success = true;
        }
        catch (IOException ex) 
        {
            Logger.getLogger(IncomeGroupDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
