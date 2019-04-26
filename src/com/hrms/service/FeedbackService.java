package com.hrms.service;

import java.util.List;

import com.hrms.model.Feedback;
import com.hrms.model.Page;

public interface FeedbackService {
	boolean addFeedback(Feedback feedback);
	boolean deleteFeedback(int feedbackId);
	boolean updateFeedback(Feedback feedback);
	Feedback findFeedback(int feedbackId);
	long findTotalCount(Feedback feedback);
	List<Feedback> listFeedback(Feedback feedback,Page page);
	long findCountFeedback();
}
