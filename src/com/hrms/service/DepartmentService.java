package com.hrms.service;

import java.util.List;

import com.hrms.model.Department;
import com.hrms.model.Page;

public interface DepartmentService {
	boolean addDepartment(Department department);
	boolean deleteDepartment(int departmentId);
	boolean updateDepartment(Department department);
	Department findDepartment(int departmentId);
	long findTotalCount(Department department);
	List<Department> listDepartment(Department department,Page page);
	List<Department> findAllDepartment(); 
	long findCountDepartment();
}
