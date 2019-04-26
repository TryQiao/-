package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hrms.dao.LeavingDao;
import com.hrms.model.Leaving;
import com.hrms.model.Page;

@Repository
public class LeavingDaoImpl implements LeavingDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Leaving findLeaving(int leavingId) {
		Session s=sessionFactory.getCurrentSession();
		Leaving l=s.get(Leaving.class, leavingId);
		return l;
	}

	public long findTotalCount(Leaving leaving) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Leaving where 1=1");
		String leavingReason = leaving.getLeavingReason();
		String leavingType=leaving.getLeavingType();
		//拼接条件
		if(leavingReason != null && !"".equals(leavingReason)) {
			hql.append(" and leavingReason like :leavingReason");
		}
		if(leavingType != null && !"".equals(leavingType)) {
			hql.append(" and leavingType like :leavingType");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(leavingReason != null && !"".equals(leavingReason)) {
			q.setParameter("leavingReason", "%"+leavingReason+"%");
		}
		if(leavingType != null && !"".equals(leavingType)) {
			q.setParameter("leavingType", "%"+leavingType+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Leaving> listLeaving(Leaving leaving, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Leaving where 1=1");
		
		String leavingName=leaving.getLeavingName();
		String leavingType=leaving.getLeavingType();
		
		if(leavingName !=null&& !"".equals(leavingName))
		{
			hql.append(" and leavingName like :leavingName");
		}
		if(leavingType !=null&& !"".equals(leavingType))
		{
			hql.append(" and leavingType like :leavingType");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(leavingName !=null&& !"".equals(leavingName)){
			q.setParameter("leavingName", "%"+leavingName+"%");
		}
		if(leavingType !=null&& !"".equals(leavingType)){
			q.setParameter("leavingType", "%"+leavingType+"%");
		}
		return q.list();
	}

	public boolean deleteLeaving(int leavingId) {
		Session s=sessionFactory.getCurrentSession();
		Leaving l=s.get(Leaving.class, leavingId);
		s.delete(l);
		return true;
	}

	public long findCountLeaving() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Leaving");
		Query q=s.createQuery(hql.toString());
		long countLeaving = (long)q.uniqueResult();
		return countLeaving;
	}
	
	public long findCountPersonLeaving(String employeeName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Leaving where leavingName=:employeeName");
		Query q=s.createQuery(hql.toString());
		q.setParameter("employeeName", employeeName);
		long countLeaving = (long)q.uniqueResult();
		return countLeaving;
	}

	public boolean addLeaving(Leaving leaving) {
		sessionFactory.getCurrentSession().save(leaving);
		return true;
	}

	public boolean updateLeaving(Leaving leaving) {
		sessionFactory.getCurrentSession().update(leaving);
		return true;
	}

	public boolean isExit(String leavingTime) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Leaving where leavingTime=:leavingTime");
		Query q=s.createQuery(hql.toString());
		q.setParameter("leavingTime", leavingTime);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExitWithoutSelf(String leavingTime,int leavingId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Leaving where leavingTime=:leavingTime and leavingId !=:leavingId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("leavingTime", leavingTime);
		q.setParameter("leavingId", leavingId);
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
