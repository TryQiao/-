package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.RecruitmentDao;
import com.hrms.model.Page;
import com.hrms.model.Recruitment;

@Repository
public class RecruitmentDaoImpl implements RecruitmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Recruitment findRecruitment(int recruitmentId) {
		Session s=sessionFactory.getCurrentSession();
		Recruitment r=s.get(Recruitment.class, recruitmentId);
		return r;
	}

	public long findTotalCount(Recruitment recruitment) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Recruitment where 1=1");
		String recruitmentTitle = recruitment.getRecruitmentTitle();
		//拼接条件
		if(recruitmentTitle != null && !"".equals(recruitmentTitle)) {
			hql.append(" and recruitmentTitle like :recruitmentTitle");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(recruitmentTitle != null && !"".equals(recruitmentTitle)) {
			q.setParameter("recruitmentTitle", "%"+recruitmentTitle+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Recruitment> listRecruitment(Recruitment recruitment, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Recruitment where 1=1");
		
		String recruitmentTitle=recruitment.getRecruitmentTitle();
		if(recruitmentTitle !=null&& !"".equals(recruitmentTitle))
		{
			hql.append(" and recruitmentTitle like :recruitmentTitle");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(recruitmentTitle !=null&& !"".equals(recruitmentTitle)){
			q.setParameter("recruitmentTitle", "%"+recruitmentTitle+"%");
		}
		return q.list();
	}

	public boolean deleteRecruitment(int recruitmentId) {
		Session s=sessionFactory.getCurrentSession();
		Recruitment r=s.get(Recruitment.class, recruitmentId);
		s.delete(r);
		return true;
	}

	public boolean addRecruitment(Recruitment recruitment) {
		sessionFactory.getCurrentSession().save(recruitment);
		return true;
	}

	public boolean isExit(String recruitmentTitle) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Recruitment where recruitmentTitle=:recruitmentTitle");
		Query q=s.createQuery(hql.toString());
		q.setParameter("recruitmentTitle", recruitmentTitle);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateRecruitment(Recruitment recruitment) {
		sessionFactory.getCurrentSession().update(recruitment);
		return true;
	}

	public boolean isExitWithoutSelf(String recruitmentTitle, int recruitmentId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Recruitment where recruitmentTitle=:recruitmentTitle and recruitmentId !=:recruitmentId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("recruitmentTitle", recruitmentTitle);
		q.setParameter("recruitmentId", recruitmentId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public long findCount() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Recruitment");
		Query q=s.createQuery(hql.toString());
		long count = (long)q.uniqueResult();
		return count;
	}

}
