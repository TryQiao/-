package com.hrms.service;

import com.hrms.model.Employee;
import com.hrms.model.Manager;

public interface LoginService {
	Manager login(Manager manager); 
	Employee login_employee(Employee employee);
}
