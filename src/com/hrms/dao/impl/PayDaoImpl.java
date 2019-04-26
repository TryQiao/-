package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.PayDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Pay;
import com.hrms.model.Reward;

@Repository
public class PayDaoImpl implements PayDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Pay findPay(int payId) {
		Session s=sessionFactory.getCurrentSession();
		Pay p=s.get(Pay.class, payId);
		return p;
	}

	public long findTotalCount(Pay pay) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Pay where 1=1");
		Integer payId = pay.getPayId();
		Integer payBaseMoney=pay.getPayBaseMoney();
		if(payId != null) {
			hql.append(" and payId = :payId");
		}
		if(payBaseMoney != null) {
			hql.append(" and payBaseMoney = :payBaseMoney");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(payId != null) {
			q.setParameter("payId", payId);
		}
		if(payBaseMoney != null) {
			q.setParameter("payBaseMoney", payBaseMoney);
		}
		
		return (long)q.uniqueResult();
	}

	public List<Pay> listPay(Pay pay, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Pay where 1=1");
		
		Integer payId=pay.getPayId();
		Integer payBaseMoney=pay.getPayBaseMoney();
		if(payId !=null)
		{
			hql.append(" and payId = :payId");
		}
		if(payBaseMoney != null) {
			hql.append(" and payBaseMoney = :payBaseMoney");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(payId !=null){
			q.setParameter("payId", payId);
		}
		if(payBaseMoney != null) {
			q.setParameter("payBaseMoney", payBaseMoney);
		}
		return q.list();
	}

	public boolean deletePay(int payId) {
		Session s=sessionFactory.getCurrentSession();
		Pay p=s.get(Pay.class, payId);
		s.delete(p);
		return true;
	}

	public boolean addPay(Pay pay) {
		sessionFactory.getCurrentSession().save(pay);
		return true;
	}

	public boolean isExit(int employeeId) {
		Session s=sessionFactory.getCurrentSession();
		System.out.println("====="+employeeId);
		StringBuffer hql= new StringBuffer("select count(*) from Pay where payEmployee=?");
		Query q=s.createQuery(hql.toString());
		q.setParameter(0, employeeId);
		long count = (long)q.uniqueResult();
		System.out.println(count);
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updatePay(Pay pay) {
		sessionFactory.getCurrentSession().update(pay);
		return true;
	}

	public boolean isExitWithoutSelf(Integer payEmployee, int payId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Pay where payEmployee=:payEmployee and payId !=:payId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("payEmployee", payEmployee);
		q.setParameter("payId", payId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public List<Pay> findAllPay() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("from Pay order by payId");
		Query q=s.createQuery(hql.toString());
		return q.list();
	}



}
