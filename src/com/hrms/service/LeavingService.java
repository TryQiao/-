package com.hrms.service;

import java.util.List;

import com.hrms.model.Feedback;
import com.hrms.model.Leaving;
import com.hrms.model.Page;

public interface LeavingService {
	boolean addLeaving(Leaving leaving);
	boolean deleteLeaving(int leavingId);
	boolean updateLeaving(Leaving leaving);
	Leaving findLeaving(int leavingId);
	long findTotalCount(Leaving leaving);
	List<Leaving> listLeaving(Leaving leaving,Page page);
	long findCountLeaving();
	long findCountPersonLeaving(String employeeName);
}
