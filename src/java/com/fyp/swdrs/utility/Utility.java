/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.utility;

import com.fyp.swdrs.bo.DoctorProfile;
import com.fyp.swdrs.controller.Controller;
import com.fyp.swdrs.dal.owlNxml.UtilityDAL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zohaib Masood (CS-121054)
 */

public class Utility 
{
    public static ArrayList<String> viewArea(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewAreaAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        for (int i = 0; i < list.size(); i++) { list.set(i, list.get(i).replace("_", " ")); }
        return list;
    }
    public static ArrayList<String> viewCity(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewCityAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        for (int i = 0; i < list.size(); i++) { list.set(i, list.get(i).replace("_", " ")); }
        return list;
    }
    public static ArrayList<String> viewDays(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewDaysAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewDegree(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewDegreeAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewGender(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewGenderAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewHospital(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewHospitalAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewIncomeGroup(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewIncomeGroupAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewSpecialties(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewSpecialtiesAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewSymptom(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewSymptomAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewDisease(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewDiseaseAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewFeedbackQuestion(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewFeedbackQuestionAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    public static ArrayList<String> viewAddress(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.viewAddressAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    
    public static ArrayList<String> retrieveFeedbackQuestions(String filename)
    {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.retrieveFeedbackQuestionsAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }
    
    public static double CalculateRating1(String behaviour1Answer, String behaviour2Answer, String behaviour3Answer, String behaviour4Answer, String behaviour5Answer, String behaviour6Answer, String interaction1Answer, String interaction2Answer, String interaction3Answer, String interaction4Answer, String interaction5Answer, String interaction6Answer, String interaction7Answer, String interaction8Answer, String interaction9Answer, String diagnosisTimeAnswer, String scaleAnswer) 
    {
        double rating = 0;
        double sumWeights = 0;
        double ratingAvg = 0;
        ArrayList<Double> weights = new ArrayList();
        ArrayList<Double> ratings = new ArrayList();
        
        weights.add(7.0);
        weights.add(8.0);
        weights.add(9.0);
        weights.add(9.0);
        weights.add(8.0);
        weights.add(9.0);
        weights.add(8.0);
        weights.add(9.0);
        weights.add(8.0);
        weights.add(10.0);
        weights.add(8.0);
        weights.add(7.0);
        weights.add(10.0);
        weights.add(10.0);
        weights.add(10.0);
        weights.add(10.0);
        weights.add(10.0);
        
        ratings.add(CheckValue1(behaviour1Answer));
        ratings.add(CheckValue1(behaviour2Answer));
        ratings.add(CheckValue1(behaviour3Answer));
        ratings.add(CheckValue1(behaviour4Answer));
        ratings.add(CheckValue1(behaviour5Answer));
        ratings.add(CheckValue1(behaviour6Answer));
        ratings.add(CheckValue1(interaction1Answer));
        ratings.add(CheckValue1(interaction2Answer));
        ratings.add(CheckValue1(interaction3Answer));
        ratings.add(CheckValue1(interaction4Answer));
        ratings.add(CheckValue1(interaction5Answer));
        ratings.add(CheckValue1(interaction6Answer));
        ratings.add(CheckValue1(interaction7Answer));
        ratings.add(CheckValue1(interaction8Answer));
        ratings.add(CheckValue1(interaction9Answer));
        ratings.add(CheckValue1(diagnosisTimeAnswer));
        ratings.add(Double.parseDouble(scaleAnswer)/10);
        
        for (int i = 0; i < 17; i++) {
            sumWeights += weights.get(i);
        }
        for (int i = 0; i < 17; i++) {
            rating += (ratings.get(i) * weights.get(i));
        }
        
        ratingAvg = (rating/sumWeights)*10;
        
        
        System.out.println(ratings);
        System.out.println(weights);
        System.out.println(rating);
        System.out.println(sumWeights);
        System.out.println(ratingAvg);
        return ratingAvg;
    }
            
    public static double CheckValue1(String str) {
        if((str.equals("Always"))||(str.equals("Instant"))||(str.equals("Greater than 1 month"))||(str.equals("Yes")))
        {
            return 1;
        }
        else if((str.equals("Usually"))||(str.equals("1 to 3 visits"))||(str.equals("Less than 1 month")))
        {
            return 0.75;
        }
        else if((str.equals("Sometimes"))||(str.equals("More than 3 visits"))||(str.equals("Less than 15 days")))
        {
            return 0.25;
        }
        else if((str.equals("Never"))||(str.equals("No diagnosis"))||(str.equals("Less than 5 days"))||(str.equals("No")))
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
//    public static int CalculateRating(String introduction1Answer, String introduction2Answer, String introduction3Answer, String introduction4Answer, String behaviour1Answer, String behaviour2Answer, String behaviour3Answer, String behaviour4Answer, String behaviour5Answer, String behaviour6Answer, String interaction1Answer, String interaction2Answer, String interaction3Answer, String interaction4Answer, String interaction5Answer, String interaction6Answer, String interaction7Answer, String interaction8Answer, String interaction9Answer, String diagnosisTimeAnswer, String scaleAnswer) 
    public static int CalculateRating2(String behaviour1Answer, String behaviour2Answer, String behaviour3Answer, String behaviour4Answer, String behaviour5Answer, String behaviour6Answer, String interaction1Answer, String interaction2Answer, String interaction3Answer, String interaction4Answer, String interaction5Answer, String interaction6Answer, String interaction7Answer, String interaction8Answer, String interaction9Answer, String diagnosisTimeAnswer, String scaleAnswer) 
    {
        int rating = 0;
        int ratingAvg = 0;
//        rating += CheckValue(introduction1Answer) + CheckValue(introduction2Answer) + CheckValue(introduction3Answer) + CheckValue(introduction4Answer);
        rating += CheckValue(behaviour1Answer) + CheckValue(behaviour2Answer) + CheckValue(behaviour3Answer) + CheckValue(behaviour4Answer) + CheckValue(behaviour5Answer) + CheckValue(behaviour6Answer); 
        rating += CheckValue(interaction1Answer) + CheckValue(interaction2Answer) + CheckValue(interaction3Answer) + CheckValue(interaction4Answer) + CheckValue(interaction5Answer) + CheckValue(interaction6Answer) + CheckValue(interaction7Answer) + CheckValue(interaction8Answer) + CheckValue(interaction9Answer); 
        rating += CheckValue(diagnosisTimeAnswer); 
        rating += StrtoInt(scaleAnswer);
        ratingAvg = rating/4;
        return ratingAvg;
        
    }
            
    public static int CheckValue(String str) {
        if((str.equals("Always"))||(str.equals("More than 3 visits"))||(str.equals("Greater than 1 month"))||(str.equals("Yes")))
        {
            return 4;
        }
        else if((str.equals("Usually"))||(str.equals("1 to 3 visits"))||(str.equals("Less than 1 month")))
        {
            return 3;
        }
        else if((str.equals("Sometimes"))||(str.equals("Instant diagnosis"))||(str.equals("Less than 15 days")))
        {
            return 2;
        }
        else if((str.equals("Never"))||(str.equals("No diagnosis"))||(str.equals("Less than 5 days"))||(str.equals("No")))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
   
    public static int StrtoInt(String str) {
        return (Integer.parseInt(str)*4);
    }
    
    public static double calculateSystemRating(String doctorName, String filename) {
        double averageRating = UtilityDAL.calculateSystemRating(doctorName, filename);
        return averageRating;
    }

    public static ArrayList<String> populateList(String filename) {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.populateListAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }

    public static ArrayList<String> populateDoctorName(String filename) {
        ArrayList<String> list = populateList(filename);
        ArrayList<String> name = new ArrayList();
        list.remove(0);
        int size = list.size();
        for (int i = 0; i < size; i++) 
        {
            if(i%15 == 0)
            {
                name.add(list.get(i));
            }
        }
        return name;
    }

    public static ArrayList<String> populateDoctorEmail(String filename) {
        ArrayList<String> list = populateList(filename);
        ArrayList<String> email = new ArrayList();
        list.remove(0);
        int size = list.size();
        for (int i = 0; i < size; i++) 
        {
            if(i%15 == 1)
            {
                email.add(list.get(i));
            }
        }
        return email;
    }

      
    public static void printArray(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> list2 = new ArrayList();
        
        Set<String> hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list2.addAll(hs);
        return list2;
    }

    public static ArrayList<Integer> calculateAge(String dobDate) {
        String currentDate = (new SimpleDateFormat ("yyyy-MM-dd")).format(new Date());
        ArrayList<Integer> age = new ArrayList();
        int currentDay = dateDay(currentDate);
        int currentMonth = dateMonth(currentDate);
        int currentYear = dateYear(currentDate);
        int dobDay = dateDay(dobDate);
        int dobMonth = dateMonth(dobDate);
        int dobYear = dateYear(dobDate);
        int day = 0;
        int month = 0;
        int year = 0;
        int monthDays = 0;
        if(currentYear >= dobYear)
        {
            year = currentYear-dobYear;
            if((currentMonth < 13) && (dobMonth < 13))
            {
                if(currentMonth>dobMonth) { month = currentMonth-dobMonth; }
                else { month = currentMonth + (12-dobMonth); }
                
                if(dobDay < currentDay) { day = currentDay-dobDay; }
                else if(dobDay >= currentDay)
                {
                    if((dobMonth == 4)||(dobMonth == 6)||(dobMonth == 9)||(dobMonth == 11)) { monthDays = 30; }
                    else if(dobMonth == 2) 
                    { 
                        if(dobYear%4 == 0) { monthDays = 29; } 
                        else { monthDays = 28; } 
                    }
                    else { monthDays = 31; }
                    day = currentDay + (monthDays-dobDay);
                }
            }
        }
        age.add(year);
        age.add(month);
        age.add(day);
        return age;
    }

    public static int dateYear(String date) {
        return Integer.parseInt(date.substring(0,4));
    }
    
    public static int dateMonth(String date) {
        return Integer.parseInt(date.substring(5,7));
    }
    
    public static int dateDay(String date) {
        return Integer.parseInt(date.substring(8,10));
    }

    public static String timeFormat(String time) { 
        if((Integer.parseInt(time.substring(0, 2))) > 12) { if((((Integer.parseInt(time.substring(0,2)))-12)<10)&&((Integer.parseInt(time.substring(3,5)))<10)) { time="0"+Integer.toString(((Integer.parseInt(time.substring(0,2)))-12))+":0"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":PM"; } else if((((Integer.parseInt(time.substring(0,2)))-12)<10)&&((Integer.parseInt(time.substring(3,5)))>10)) { time="0"+Integer.toString(((Integer.parseInt(time.substring(0,2)))-12))+":"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":PM"; } else if((((Integer.parseInt(time.substring(0,2)))-12)>10)&&((Integer.parseInt(time.substring(3,5)))<10)) { time=Integer.toString(((Integer.parseInt(time.substring(0,2)))-12))+":0"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":PM"; } else { time=Integer.toString(((Integer.parseInt(time.substring(0,2)))-12))+":"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":PM"; } } else { if(((Integer.parseInt(time.substring(0,2)))<10)&&((Integer.parseInt(time.substring(3,5)))<10)) { time="0"+Integer.toString((Integer.parseInt(time.substring(0,2))))+":0"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":AM"; } else if(((Integer.parseInt(time.substring(0,2)))<10)&&((Integer.parseInt(time.substring(3,5)))>10)) { time="0"+Integer.toString((Integer.parseInt(time.substring(0,2))))+":"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":AM"; } else if(((Integer.parseInt(time.substring(0,2)))>10)&&((Integer.parseInt(time.substring(3,5)))<10)) { time=Integer.toString((Integer.parseInt(time.substring(0,2))))+":0"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":AM"; } else { time=Integer.toString((Integer.parseInt(time.substring(0,2))))+":"+Integer.toString((Integer.parseInt(time.substring(3,5))))+":AM"; } } return time; 
    }

    public static String removeTag(String str) {
        return str.substring(str.indexOf(" ")+1);
    }

    public static ArrayList<String> populateDoctorNameList(String filename) {
        ArrayList<String> list = new ArrayList();
        Controller controller = new Controller();
        Object[] params = new Object[1];
        params[0] = list;
        Object[] returnObj = controller.processRequest(Constants.populateDoctorListAction, params, filename);
        if(returnObj!=null)
        {
            list = (ArrayList<String>) returnObj[0];
        }
        return list;
    }

    public static HashMap<String, ArrayList<Integer>> removeDoctorProfiles(ArrayList<DoctorProfile> doctorProfile) 
    {
        ArrayList<String> emailList = new ArrayList();
        ArrayList<Integer> frequencyList = new ArrayList();
        ArrayList<String> allEmailList = new ArrayList();
        for (int i = 0; i < doctorProfile.size(); i++) { allEmailList.add(doctorProfile.get(i).getEmail()); emailList.add(doctorProfile.get(i).getEmail()); }
        Set<String> uniqueSet = new HashSet<String>(emailList);
	for (String key : uniqueSet) {
            frequencyList.add(Collections.frequency(emailList, key));
        }
        emailList.clear();
        emailList.addAll(uniqueSet);
        String key = "";
        int frequency = 0;
        int index = 0;
        HashMap<String, ArrayList<Integer>> uniqueMap = new HashMap();
        for (int i = 0; i < emailList.size(); i++) { 
            key = emailList.get(i);
            frequency = frequencyList.get(i);
            ArrayList<Integer> indexList = new ArrayList();
            for (int j = 0; j < frequency; j++) {
                index = allEmailList.indexOf(key);
                indexList.add(index);
                allEmailList.set(index, "REMOCED");
            }
            uniqueMap.put(key, indexList);
        }
        return uniqueMap;
    }
}