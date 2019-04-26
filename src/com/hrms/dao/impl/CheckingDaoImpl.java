package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.CheckingDao;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Checking;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Reward;

@Repository
public class CheckingDaoImpl implements CheckingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Checking findChecking(int checkingId) {
		Session s=sessionFactory.getCurrentSession();
		Checking c=s.get(Checking.class,checkingId);
		return c;
	}

	public long findTotalCount(Checking checking) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Checking where 1=1");
		String checkingName = checking.getCheckingName();
		String checkingType = checking.getCheckingType();
		Integer payId=checking.getPy().getPayId();
		System.out.println(payId+"666");
		//拼接条件
		if(checkingName != null && !"".equals(checkingName)) {
			hql.append(" and checkingName like :checkingName");
		}
		if(checkingType != null && !"".equals(checkingType)) {
			hql.append(" and checkingType like :checkingType");
		}
		if(payId != null) {
			hql.append(" and py.payId = :payId");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(checkingName != null && !"".equals(checkingName)) {
			q.setParameter("checkingName", "%"+checkingName+"%");
		}
		if(checkingType != null && !"".equals(checkingType)) {
			q.setParameter("checkingType", "%"+checkingType+"%");
		}
		if(payId != null) {
			q.setParameter("payId", payId);
		}
		return (long)q.uniqueResult();
	}

	public List<Checking> listChecking(Checking checking, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Checking where 1=1");
		Integer payId=checking.getPy().getPayId();
		String checkingName = checking.getCheckingName();
		String checkingType = checking.getCheckingType();
		if(checkingName !=null&& !"".equals(checkingName))
		{
			hql.append(" and checkingName like :checkingName");
		}
		if(checkingType !=null&& !"".equals(checkingType))
		{
			hql.append(" and checkingType like :checkingType");
		}
		if(payId != null) {
			hql.append(" and py.payId = :payId");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(checkingName !=null&& !"".equals(checkingName)){
			q.setParameter("checkingName", "%"+checkingName+"%");
		}
		if(checkingType !=null&& !"".equals(checkingType)){
			q.setParameter("checkingType", "%"+checkingType+"%");
		}
		if(payId != null) {
			q.setParameter("payId", payId);
		}
		return q.list();
	}

	public boolean deleteChecking(int checkingId) {
		Session s=sessionFactory.getCurrentSession();
		Checking c=s.get(Checking.class, checkingId);
		c.setPy(null);
		s.delete(c);
		return true;
	}

	public boolean addChecking(Checking checking) {
		sessionFactory.getCurrentSession().save(checking);
		return true;
	}

	public boolean isExit(String checkingStart,String checkingName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Checking where checkingName=:checkingName and checkingStart=:checkingStart");
		Query q=s.createQuery(hql.toString());
		q.setParameter("checkingStart", checkingStart);
		q.setParameter("checkingName", checkingName);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateChecking(Checking checking) {
		sessionFactory.getCurrentSession().update(checking);
		return true;
	}

	public boolean isExitWithoutSelf(String checkingType, int checkingId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Checking where checkingType=:checkingType and checkingId !=:checkingId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("checkingType", checkingType);
		q.setParameter("checkingId", checkingId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}


}
