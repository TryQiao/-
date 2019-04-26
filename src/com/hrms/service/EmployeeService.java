package com.hrms.service;

import java.util.List;

import com.hrms.model.Employee;
import com.hrms.model.Page;

public interface EmployeeService {
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(int employeeId);
	boolean updateEmployee(Employee employee);
	Employee findEmployee(int employeeId);
	long findTotalCount(Employee employee);
	List<Employee> listEmployee(Employee employee,Page page);
	List<Employee> findAllEmployee();
	long findCount();
}
