package com.hrms.dao;

import com.hrms.model.Employee;
import com.hrms.model.Manager;

public interface LoginDao {
	Manager login(Manager manager);
	Employee login_employee(Employee employee);
}
