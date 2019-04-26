package com.hrms.dao;

import java.util.List;

import com.hrms.model.Leaving;
import com.hrms.model.Page;

public interface LeavingDao {
	boolean addLeaving(Leaving leaving);
	boolean deleteLeaving(int leavingId);
	boolean updateLeaving(Leaving leaving);
	Leaving findLeaving(int leavingId);
	long findTotalCount(Leaving leaving);
	List<Leaving> listLeaving(Leaving leaving ,Page page);
	boolean isExit(String leavingTime);
	boolean isExitWithoutSelf(String leavingTime,int leavingId);
	long findCountLeaving();
	long findCountPersonLeaving(String employeeName);
}
