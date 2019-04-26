package com.hrms.service;

import java.util.List;

import com.hrms.model.Reward;
import com.hrms.model.Page;

public interface RewardService {
	boolean addReward(Reward reward);
	boolean deleteReward(int rewardId);
	boolean updateReward(Reward reward);
	Reward findReward(int rewardId);
	long findTotalCount(Reward reward);
	List<Reward> listReward(Reward reward,Page page);
}
