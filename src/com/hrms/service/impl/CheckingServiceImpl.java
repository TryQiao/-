package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.CheckingDao;
import com.hrms.dao.EmployeeDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Checking;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Reward;
import com.hrms.service.CheckingService;
import com.hrms.service.EmployeeService;
import com.hrms.service.RewardService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class CheckingServiceImpl implements CheckingService {

	@Autowired
	private CheckingDao checkingDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Checking findChecking(int checkingId) {
		return checkingDao.findChecking(checkingId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Checking checking) {
		return checkingDao.findTotalCount(checking);
	}

	public List<Checking> listChecking(Checking checking, Page page) {
		return checkingDao.listChecking(checking, page);
	}

	@Override
	public boolean deleteChecking(int checkingId) {
		
		return checkingDao.deleteChecking(checkingId);
	}


	public boolean addChecking(Checking checking) {
		boolean flag=checkingDao.isExit(checking.getCheckingStart(),checking.getCheckingName());
		if(flag==true)
		{
			return false;
		}
		else {
			checkingDao.addChecking(checking);
		}
		return true;
	}

	public boolean updateChecking(Checking checking) {
		boolean flag=checkingDao.isExitWithoutSelf(checking.getCheckingType(),checking.getCheckingId());
		if(flag==true)
		{
			return false;
		}
		else {
			checkingDao.updateChecking(checking);
		}
		return true;
	}

}
