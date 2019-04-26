package com.hrms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.LoginDao;
import com.hrms.model.Employee;
import com.hrms.model.Manager;
import com.hrms.service.LoginService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Manager login(Manager manager) {
		
		return loginDao.login(manager);
	}
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Employee login_employee(Employee employee) {
		// TODO Auto-generated method stub
		return loginDao.login_employee(employee);
	}

}
