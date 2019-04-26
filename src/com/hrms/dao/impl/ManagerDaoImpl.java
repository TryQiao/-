package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.ManagerDao;
import com.hrms.model.Manager;
import com.hrms.model.Page;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Manager findManager(int managerId) {
		Session s=sessionFactory.getCurrentSession();
		Manager m=s.get(Manager.class, managerId);
		return m;
	}

	public long findTotalCount(Manager manager) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Manager where 1=1");
		String managerName = manager.getManagerName();
		//拼接条件
		if(managerName != null && !"".equals(managerName)) {
			hql.append(" and managerName like :managerName");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(managerName != null && !"".equals(managerName)) {
			q.setParameter("managerName", "%"+managerName+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Manager> listManager(Manager manager, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Manager where 1=1");
		
		String managerName=manager.getManagerName();
		if(managerName !=null&& !"".equals(managerName))
		{
			hql.append(" and managerName like :managerName");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(managerName !=null&& !"".equals(managerName)){
			q.setParameter("managerName", "%"+managerName+"%");
		}
		return q.list();
	}

	public boolean deleteManager(int managerId) {
		Session s=sessionFactory.getCurrentSession();
		Manager m=s.get(Manager.class, managerId);
		s.delete(m);
		return true;
	}

	public boolean addManager(Manager manager) {
		sessionFactory.getCurrentSession().save(manager);
		return true;
	}

	public boolean isExit(String managerName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Manager where managerName=:managerName");
		Query q=s.createQuery(hql.toString());
		q.setParameter("managerName", managerName);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateManager(Manager manager) {
		sessionFactory.getCurrentSession().update(manager);
		return true;
	}

	public boolean isExitWithoutSelf(String managerName, int managerId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Manager where managerName=:managerName and managerId !=:managerId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("managerName", managerName);
		q.setParameter("managerId", managerId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public long findCountManager() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Manager");
		Query q=s.createQuery(hql.toString());
		long countManager = (long)q.uniqueResult();
		return countManager;
	}

}
