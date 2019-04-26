package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.ManagerDao;
import com.hrms.dao.TrainDao;
import com.hrms.model.Manager;
import com.hrms.model.Page;
import com.hrms.model.Train;

@Repository
public class TrainDaoImpl implements TrainDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Train findTrain(int trainId) {
		Session s=sessionFactory.getCurrentSession();
		Train t=s.get(Train.class, trainId);
		return t;
	}

	public long findTotalCount(Train train) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Train where 1=1");
		String trainTitle = train.getTrainTitle();
		String trainMan=train.getTrainMan();
		//拼接条件
		if(trainTitle != null && !"".equals(trainTitle)) {
			hql.append(" and trainTitle like :trainTitle");
		}
		if(trainMan != null && !"".equals(trainMan)) {
			hql.append(" and trainMan like :trainMan");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(trainTitle != null && !"".equals(trainTitle)) {
			q.setParameter("trainTitle", "%"+trainTitle+"%");
		}
		if(trainMan != null && !"".equals(trainMan)) {
			q.setParameter("trainMan", "%"+trainMan+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Train> listTrain(Train train, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Train where 1=1");
		
		String trainTitle=train.getTrainTitle();
		String trainMan=train.getTrainMan();
		if(trainTitle !=null&& !"".equals(trainTitle))
		{
			hql.append(" and trainTitle like :trainTitle");
		}
		if(trainMan != null && !"".equals(trainMan)) {
			hql.append(" and trainMan like :trainMan");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(trainTitle !=null&& !"".equals(trainTitle)){
			q.setParameter("trainTitle", "%"+trainTitle+"%");
		}
		if(trainMan != null && !"".equals(trainMan)) {
			q.setParameter("trainMan", "%"+trainMan+"%");
		}
		return q.list();
	}

	public boolean deleteTrain(int trainId) {
		Session s=sessionFactory.getCurrentSession();
		Train t=s.get(Train.class, trainId);
		s.delete(t);
		return true;
	}

	public boolean addTrain(Train train) {
		sessionFactory.getCurrentSession().save(train);
		return true;
	}

	public boolean isExit(String trainTitle) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Train where trainTitle=:trainTitle");
		Query q=s.createQuery(hql.toString());
		q.setParameter("trainTitle", trainTitle);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateTrain(Train train) {
		sessionFactory.getCurrentSession().update(train);
		return true;
	}

	public boolean isExitWithoutSelf(String trainTitle, int trainId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Train where trainTitle=:trainTitle and trainId !=:trainId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("trainTitle", trainTitle);
		q.setParameter("trainId", trainId);
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
		StringBuffer hql= new StringBuffer("select count(*) from Train");
		Query q=s.createQuery(hql.toString());
		long count = (long)q.uniqueResult();
		return count;
	}

}
