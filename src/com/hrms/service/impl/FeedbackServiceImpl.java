package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.FeedbackDao;
import com.hrms.dao.ManagerDao;
import com.hrms.model.Feedback;
import com.hrms.model.Manager;
import com.hrms.model.Page;
import com.hrms.service.FeedbackService;
import com.hrms.service.ManagerService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Feedback findFeedback(int feedbackId) {
		return feedbackDao.findFeedback(feedbackId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Feedback feedback) {
		return feedbackDao.findTotalCount(feedback);
	}

	public List<Feedback> listFeedback(Feedback feedback, Page page) {
		return feedbackDao.listFeedback(feedback, page);
	}

	@Override
	public boolean deleteFeedback(int feedbackId) {
		
		return feedbackDao.deleteFeedback(feedbackId);
	}


	public boolean addFeedback(Feedback feedback) {
		boolean flag=feedbackDao.isExit(feedback.getFeedbackContent(),feedback.getFeedbackName());
		if(flag==true)
		{
			return false;
		}
		else {
			return feedbackDao.addFeedback(feedback);
		}
		
	}

	public boolean updateFeedback(Feedback feedback) {
		boolean flag=feedbackDao.isExitWithoutSelf(feedback.getFeedbackContent(),feedback.getFeedbackId());
		if(flag==true)
		{
			return false;
		}
		else {
			feedbackDao.updateFeedback(feedback);
		}
		return true;
	}

	public long findCountFeedback() {
		
		return feedbackDao.findCountFeedback();
	}

}
