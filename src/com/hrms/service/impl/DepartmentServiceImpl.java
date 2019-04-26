package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.DepartmentDao;
import com.hrms.model.Department;
import com.hrms.model.Page;
import com.hrms.service.DepartmentService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Department findDepartment(int departmentId) {
		return departmentDao.findDepartment(departmentId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Department department) {
		return departmentDao.findTotalCount(department);
	}

	public List<Department> listDepartment(Department department, Page page) {
		return departmentDao.listDepartment(department, page);
	}

	@Override
	public boolean deleteDepartment(int departmentId) {
		
		return departmentDao.deleteDepartment(departmentId);
	}


	public boolean addDepartment(Department department) {
		boolean flag=departmentDao.isExit(department.getDepartmentName());
		if(flag==true)
		{
			return false;
		}
		else {
			return departmentDao.addDepartment(department);
		}
		
	}

	public boolean updateDepartment(Department department) {
		boolean flag=departmentDao.isExitWithoutSelf(department.getDepartmentName(),department.getDepartmentId());
		if(flag==true)
		{
			
			return false;
		}
		else {
			departmentDao.updateDepartment(department);
		}
		return true;
	}

	public List<Department> findAllDepartment() {
		
		return departmentDao.findAllDepartment();
	}

	public long findCountDepartment() {
		return departmentDao.findCountDepartment();
	}

}
