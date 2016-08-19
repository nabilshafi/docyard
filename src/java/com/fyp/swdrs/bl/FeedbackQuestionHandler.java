/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.dal.owlNxml.FeedbackQuestionDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */

public class FeedbackQuestionHandler
{
    public boolean createFeedbackQuestion(String crudValue, String filename)
    {
        FeedbackQuestionDAL adminCrudDAL = new FeedbackQuestionDAL();
        boolean success = adminCrudDAL.createFeedbackQuestion(crudValue, filename);
        return success;
    }
    
    public boolean viewFeedbackQuestion(ArrayList<String> list, String filename)
    {
        FeedbackQuestionDAL adminCrudDAL = new FeedbackQuestionDAL();
        boolean success = adminCrudDAL.viewFeedbackQuestion(list, filename);
        return success;
    }
    
    public boolean updateFeedbackQuestion(ArrayList<String> list, String filename)
    {
        FeedbackQuestionDAL adminCrudDAL = new FeedbackQuestionDAL();
        boolean success = adminCrudDAL.updateFeedbackQuestion(list, filename);
        return success;
    }
    
    public boolean deleteFeedbackQuestion(String crudValue, String filename)
    {
        FeedbackQuestionDAL adminCrudDAL = new FeedbackQuestionDAL();
        boolean success = adminCrudDAL.deleteFeedbackQuestion(crudValue, filename);
        return success;
    }
}
