package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Reward;

@Repository
public class RewardDaoImpl implements RewardDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Reward findReward(int rewardId) {
		Session s=sessionFactory.getCurrentSession();
		Reward r=s.get(Reward.class, rewardId);
		return r;
	}

	public long findTotalCount(Reward reward) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Reward where 1=1");
		String rewardName = reward.getRewardName();
		String rewardType=reward.getRewardType();
		Integer payId=reward.getPay().getPayId();
		System.out.println(payId);
		//拼接条件
		if(rewardName != null && !"".equals(rewardName)) {
			hql.append(" and rewardName like :rewardName");
		}
		if(rewardType != null && !"".equals(rewardType)) {
			hql.append(" and rewardType like :rewardType");
		}
		if(payId != null) {
			hql.append(" and pay.payId = :payId");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(rewardName != null && !"".equals(rewardName)) {
			q.setParameter("rewardName", "%"+rewardName+"%");
		}
		if(rewardType != null && !"".equals(rewardType)) {
			q.setParameter("rewardType", "%"+rewardType+"%");
		}
		if(payId != null) {
			q.setParameter("payId", payId);
		}
		return (long)q.uniqueResult();
	}

	public List<Reward> listReward(Reward reward, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Reward where 1=1");
		
		String rewardName=reward.getRewardName();
		String rewardType=reward.getRewardType();
		Integer payId=reward.getPay().getPayId();
		Integer rewardId=reward.getRewardId();
		if(rewardName !=null&& !"".equals(rewardName))
		{
			hql.append(" and rewardName like :rewardName");
		}
		if(rewardType != null && !"".equals(rewardType)) {
			hql.append(" and rewardType like :rewardType");
		}
		if(payId != null) {
			hql.append(" and pay.payId = :payId");
		}
		if(rewardId != null) {
			hql.append(" and rewardId = :rewardId");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(rewardName !=null&& !"".equals(rewardName)){
			q.setParameter("rewardName", "%"+rewardName+"%");
		}
		if(rewardType != null && !"".equals(rewardType)) {
			q.setParameter("rewardType", "%"+rewardType+"%");
		}
		if(payId != null) {
			q.setParameter("payId", payId);
		}
		if(rewardId != null) {
			q.setParameter("rewardId", rewardId);
		}
		return q.list();
	}

	public boolean deleteReward(int rewardId) {
		Session s=sessionFactory.getCurrentSession();
		Reward r=s.get(Reward.class, rewardId);
		r.setPay(null);
		s.delete(r);
		return true;
	}

	public boolean addReward(Reward reward) {
		sessionFactory.getCurrentSession().save(reward);
		return true;
	}

	public boolean isExit(String rewardName,String rewardReason) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Reward where rewardName=:rewardName and rewardReason=:rewardReason");
		Query q=s.createQuery(hql.toString());
		q.setParameter("rewardName", rewardName);
		q.setParameter("rewardReason", rewardReason);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateReward(Reward reward) {
		sessionFactory.getCurrentSession().update(reward);
		return true;
	}

	public boolean isExitWithoutSelf(String rewardReason, int rewardId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Reward where rewardReason=:rewardReason and rewardId !=:rewardId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("rewardReason", rewardReason);
		q.setParameter("rewardId", rewardId);
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
