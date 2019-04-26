package com.hrms.dao;

import java.util.List;

import com.hrms.model.Employee;
import com.hrms.model.Page;

public interface EmployeeDao {
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(int employeeId);
	boolean updateEmployee(Employee employee);
	Employee findEmployee(int EmployeeId);
	long findTotalCount(Employee employee);
	List<Employee> listEmployee(Employee employee,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String employeeName);
	boolean isExitWithoutSelf(String employeeName,int employeeId);
	List<Employee> fiandAllEmployee();
	long findCount();
}
