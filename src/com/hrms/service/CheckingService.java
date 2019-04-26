package com.hrms.service;

import java.util.List;

import com.hrms.model.Checking;
import com.hrms.model.Page;

public interface CheckingService {
	boolean addChecking(Checking checking);
	boolean deleteChecking(int checkingId);
	boolean updateChecking(Checking checking);
	Checking findChecking(int checkingId);
	long findTotalCount(Checking checking);
	List<Checking> listChecking(Checking checking,Page page);
}
