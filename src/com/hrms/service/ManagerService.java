package com.hrms.service;

import java.util.List;

import com.hrms.model.Manager;
import com.hrms.model.Page;

public interface ManagerService {
	boolean addManager(Manager manager);
	boolean deleteManager(int managerId);
	boolean updateManager(Manager manager);
	Manager findManager(int managerId);
	long findTotalCount(Manager manager);
	List<Manager> listManager(Manager manager,Page page);
	long findCountManager();
}
