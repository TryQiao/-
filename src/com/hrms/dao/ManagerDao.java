package com.hrms.dao;

import java.util.List;

import com.hrms.model.Manager;
import com.hrms.model.Page;

public interface ManagerDao {
	boolean addManager(Manager manager);
	boolean deleteManager(int managerId);
	boolean updateManager(Manager manager);
	Manager findManager(int managerId);
	long findTotalCount(Manager manager);
	List<Manager> listManager(Manager manager,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String managerName);
	boolean isExitWithoutSelf(String managerName,int managerId);
	long findCountManager();
}
