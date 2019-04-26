package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.FeedbackDao;
import com.hrms.dao.ManagerDao;
import com.hrms.model.Feedback;
import com.hrms.model.Manager;
import com.hrms.model.Page;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Feedback findFeedback(int feedbackId) {
		Session s=sessionFactory.getCurrentSession();
		Feedback f=s.get(Feedback.class, feedbackId);
		return f;
	}

	public long findTotalCount(Feedback feedback) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Feedback where 1=1");
		String feedbackContent = feedback.getFeedbackContent();
		String feedbackName=feedback.getFeedbackName();
		String feedbackType=feedback.getFeedbackType();
		//拼接条件
		
		if(feedbackContent != null && !"".equals(feedbackContent)) {
			hql.append(" and feedbackContent like :feedbackContent");
		}
		if(feedbackName != null && !"".equals(feedbackName)) {
			hql.append(" and feedbackName like :feedbackName");
		}
		if(feedbackType != null && !"".equals(feedbackType)) {
			hql.append(" and feedbackType like :feedbackType");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		
		if(feedbackContent != null && !"".equals(feedbackContent)) {
			q.setParameter("feedbackContent", "%"+feedbackContent+"%");
		}
		if(feedbackName != null && !"".equals(feedbackName)) {
			q.setParameter("feedbackName", "%"+feedbackName+"%");
		}
		if(feedbackType != null && !"".equals(feedbackType)) {
			q.setParameter("feedbackType", "%"+feedbackType+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Feedback> listFeedback(Feedback feedback, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Feedback where 1=1");
		
		String feedbackContent = feedback.getFeedbackContent();
		String feedbackName=feedback.getFeedbackName();
		String feedbackType=feedback.getFeedbackType();
		if(feedbackContent !=null&& !"".equals(feedbackContent))
		{
			hql.append(" and feedbackContent like :feedbackContent");
		}
		if(feedbackName != null && !"".equals(feedbackName)) {
			hql.append(" and feedbackName like :feedbackName");
		}
		if(feedbackType != null && !"".equals(feedbackType)) {
			hql.append(" and feedbackType like :feedbackType");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(feedbackContent !=null&& !"".equals(feedbackContent)){
			q.setParameter("feedbackContent", "%"+feedbackContent+"%");
		}
		if(feedbackName != null && !"".equals(feedbackName)) {
			q.setParameter("feedbackName", "%"+feedbackName+"%");
		}
		if(feedbackType != null && !"".equals(feedbackType)) {
			q.setParameter("feedbackType", "%"+feedbackType+"%");
		}
		return q.list();
	}

	public boolean deleteFeedback(int feedbackId) {
		Session s=sessionFactory.getCurrentSession();
		Feedback f=s.get(Feedback.class, feedbackId);
		s.delete(f);
		return true;
	}

	public boolean addFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().save(feedback);
		return true;
	}

	public boolean isExit(String feedbackContent,String feedbackName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Feedback where feedbackContent=:feedbackContent and feedbackName=:feedbackName");
		Query q=s.createQuery(hql.toString());
		q.setParameter("feedbackContent", feedbackContent);
		q.setParameter("feedbackName", feedbackName);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().update(feedback);
		return true;
	}

	public boolean isExitWithoutSelf(String feedbackContent, int feedbackId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Feedback where feedbackContent=:feedbackContent and feedbackId !=:feedbackId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("feedbackContent", feedbackContent);
		q.setParameter("feedbackId", feedbackId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public long findCountFeedback() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Feedback");
		Query q=s.createQuery(hql.toString());
		long countFeedback = (long)q.uniqueResult();
		return countFeedback;
	}



}
