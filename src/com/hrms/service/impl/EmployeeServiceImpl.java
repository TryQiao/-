package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.EmployeeDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.service.EmployeeService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Employee findEmployee(int employeeId) {
		return employeeDao.findEmployee(employeeId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Employee employee) {
		return employeeDao.findTotalCount(employee);
	}

	public List<Employee> listEmployee(Employee employee, Page page) {
		return employeeDao.listEmployee(employee, page);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeDao.deleteEmployee(employeeId);
	}


	public boolean addEmployee(Employee employee) {
		boolean flag=employeeDao.isExit(employee.getEmployeeName());
		if(flag==true)
		{
			return false;
		}
		else {
			employeeDao.addEmployee(employee);
		}
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		boolean flag=employeeDao.isExitWithoutSelf(employee.getEmployeeName(),employee.getEmployeeId());
		if(flag==true)
		{
			return false;
		}
		else {
			employeeDao.updateEmployee(employee);
		}
		return true;
	}

	public List<Employee> findAllEmployee() {
		return employeeDao.fiandAllEmployee();
	}

	public long findCount() {
		return employeeDao.findCount();
	}

}
