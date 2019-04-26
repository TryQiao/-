package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Reward;
import com.hrms.service.EmployeeService;
import com.hrms.service.RewardService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class RewardServiceImpl implements RewardService {

	@Autowired
	private RewardDao rewardDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Reward findReward(int rewardId) {
		return rewardDao.findReward(rewardId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Reward reward) {
		return rewardDao.findTotalCount(reward);
	}

	public List<Reward> listReward(Reward reward, Page page) {
		return rewardDao.listReward(reward, page);
	}

	@Override
	public boolean deleteReward(int rewardId) {
		
		return rewardDao.deleteReward(rewardId);
	}


	public boolean addReward(Reward reward) {
		boolean flag=rewardDao.isExit(reward.getRewardName(),reward.getRewardReason());
		if(flag==true)
		{
			return false;
		}
		else {
			rewardDao.addReward(reward);
		}
		return true;
	}

	public boolean updateReward(Reward reward) {
		boolean flag=rewardDao.isExitWithoutSelf(reward.getRewardReason(),reward.getRewardId());
		if(flag==true)
		{
			return false;
		}
		else {
			rewardDao.updateReward(reward);
		}
		return true;
	}

}
