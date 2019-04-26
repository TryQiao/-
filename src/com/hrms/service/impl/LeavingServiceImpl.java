package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.LeavingDao;
import com.hrms.model.Leaving;
import com.hrms.model.Page;
import com.hrms.service.LeavingService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class LeavingServiceImpl implements LeavingService {

	@Autowired
	public LeavingDao leavingDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Leaving findLeaving(int leavingId) {
		return leavingDao.findLeaving(leavingId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Leaving leaving) {
		return leavingDao.findTotalCount(leaving);
	}

	public List<Leaving> listLeaving(Leaving leaving, Page page) {
		return leavingDao.listLeaving(leaving, page);
	}

	public boolean deleteLeaving(int leavingId) {
		return leavingDao.deleteLeaving(leavingId);
	}

	public long findCountLeaving() {
		return leavingDao.findCountLeaving();
	}

	public long findCountPersonLeaving(String employeeName) {
		return leavingDao.findCountPersonLeaving(employeeName);
	}
	
	public boolean addLeaving(Leaving leaving) {
		boolean flag=leavingDao.isExit(leaving.getLeavingTime());

		if(flag==true)
		{
			return false;
		}
		else {
			leavingDao.addLeaving(leaving);
		}
		return true;
	}

	public boolean updateLeaving(Leaving leaving) {
		boolean flag=leavingDao.isExitWithoutSelf(leaving.getLeavingTime(),leaving.getLeavingId());
		System.out.println(flag);

		if(flag==true)
		{
			return false;
		}
		else {
			leavingDao.updateLeaving(leaving);
		}
		return true;
	}

	

}
