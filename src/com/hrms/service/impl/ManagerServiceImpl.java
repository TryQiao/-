package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.ManagerDao;
import com.hrms.model.Manager;
import com.hrms.model.Page;
import com.hrms.service.ManagerService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Manager findManager(int managerId) {
		return managerDao.findManager(managerId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Manager manager) {
		return managerDao.findTotalCount(manager);
	}

	public List<Manager> listManager(Manager manager, Page page) {
		return managerDao.listManager(manager, page);
	}

	@Override
	public boolean deleteManager(int managerId) {
		
		return managerDao.deleteManager(managerId);
	}


	public boolean addManager(Manager manager) {
		boolean flag=managerDao.isExit(manager.getManagerName());
		if(flag==true)
		{
			return false;
		}
		else {
			return managerDao.addManager(manager);
		}
		
	}

	public boolean updateManager(Manager manager) {
		boolean flag=managerDao.isExitWithoutSelf(manager.getManagerName(),manager.getManagerId());
		if(flag==true)
		{
			return false;
		}
		else {
			managerDao.updateManager(manager);
		}
		return true;
	}

	public long findCountManager() {
		
		return managerDao.findCountManager();
	}

}
