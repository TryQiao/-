package com.hrms.dao;

import java.util.List;

import com.hrms.model.Reward;
import com.hrms.model.Page;

public interface RewardDao {
	boolean addReward(Reward reward);
	boolean deleteReward(int rewardId);
	boolean updateReward(Reward reward);
	Reward findReward(int rewardId);
	long findTotalCount(Reward reward);
	List<Reward> listReward(Reward reward,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String rewardName,String rewardReason);
	boolean isExitWithoutSelf(String rewardReason,int rewardId);
}
