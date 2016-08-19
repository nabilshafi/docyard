/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fyp.swdrs.bl;

import com.fyp.swdrs.bo.Feedback;
import com.fyp.swdrs.dal.owlNxml.FeedbackDAL;
//import com.fyp.swdrs.dal.filing.FeedbackDAL;
//import com.fyp.swdrs.dal.xml.FeedbackDAL;

/**
 *
 * @author Admin
 */

public class FeedbackHandler
{
    public boolean createFeedback(Feedback feedback, String filename)
    {
        FeedbackDAL feedbackDAL = new FeedbackDAL();
        boolean success = feedbackDAL.createFeedback(feedback, filename);
        return success;
    }
    public boolean viewFeedback(Feedback feedback, String filename)
    {
        FeedbackDAL feedbackDAL = new FeedbackDAL();
        boolean success = feedbackDAL.viewFeedback(feedback, filename);
        return success;
    }
    public boolean updateFeedback(Feedback feedback, String filename)
    {
        FeedbackDAL feedbackDAL = new FeedbackDAL();
        boolean success = feedbackDAL.updateFeedback(feedback, filename);
        return success;
    }
    public boolean deleteFeedback(Feedback feedback, String filename)
    {
        FeedbackDAL feedbackDAL = new FeedbackDAL();
        boolean success = feedbackDAL.deleteFeedback(feedback, filename);
        return success;
    }
}
