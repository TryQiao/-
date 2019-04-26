package com.hrms.dao;

import java.util.List;

import com.hrms.model.Department;
import com.hrms.model.Page;

public interface DepartmentDao {
	boolean addDepartment(Department Department);
	boolean deleteDepartment(int departmentId);
	boolean updateDepartment(Department department);
	Department findDepartment(int departmentId);
	long findTotalCount(Department department);
	List<Department> listDepartment(Department department,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String departmentName);
	boolean isExitWithoutSelf(String departmentName,int departmentId);
	List<Department> findAllDepartment(); 
	long findCountDepartment();
}
