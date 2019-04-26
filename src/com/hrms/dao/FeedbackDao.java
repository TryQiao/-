package com.hrms.dao;

import java.util.List;

import com.hrms.model.Feedback;
import com.hrms.model.Page;

public interface FeedbackDao {
	boolean addFeedback(Feedback feedback);
	boolean deleteFeedback(int feedbackId);
	boolean updateFeedback(Feedback feedback);
	Feedback findFeedback(int feedbackId);
	long findTotalCount(Feedback feedback);
	List<Feedback> listFeedback(Feedback feedback,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String feedbackContent,String feedbackName);
	boolean isExitWithoutSelf(String feedbackContent,int feedbackId);
	long findCountFeedback();
}
