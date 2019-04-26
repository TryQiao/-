package com.hrms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.LoginDao;
import com.hrms.model.Employee;
import com.hrms.model.Manager;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Manager login(Manager manager) {
		Session s = sessionFactory.getCurrentSession();
		Query q=s.createQuery("from Manager where managerName=:managerName and managerPwd=:managerPwd");
		q.setParameter("managerName", manager.getManagerName());
		q.setParameter("managerPwd", manager.getManagerPwd());
		Manager m=(Manager) q.uniqueResult();
		return m;
	}

	public Employee login_employee(Employee employee) {
		Session s = sessionFactory.getCurrentSession();
		Query q=s.createQuery("from Employee where employeeName=:employeeName and employeePwd=:employeePwd");
		q.setParameter("employeeName", employee.getEmployeeName());
		q.setParameter("employeePwd", employee.getEmployeePwd());
		Employee e=(Employee) q.uniqueResult();
		return e;
	}

}
