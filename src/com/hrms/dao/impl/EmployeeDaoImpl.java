package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.EmployeeDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee findEmployee(int employeeId) {
		Session s=sessionFactory.getCurrentSession();
		Employee e=s.get(Employee.class, employeeId);
		return e;
	}

	public long findTotalCount(Employee employee) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Employee where 1=1");
		String employeeName = employee.getEmployeeName();
		//拼接条件
		if(employeeName != null && !"".equals(employeeName)) {
			hql.append(" and employeeName like :employeeName");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(employeeName != null && !"".equals(employeeName)) {
			q.setParameter("employeeName", "%"+employeeName+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Employee> listEmployee(Employee employee, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Employee where 1=1");
		
		String employeeName=employee.getEmployeeName();
		if(employeeName !=null&& !"".equals(employeeName))
		{
			hql.append(" and employeeName like :employeeName");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(employeeName !=null&& !"".equals(employeeName)){
			q.setParameter("employeeName", "%"+employeeName+"%");
		}
		return q.list();
	}

	public boolean deleteEmployee(int employeeId) {
		Session s=sessionFactory.getCurrentSession();
		
		Employee d=s.get(Employee.class, employeeId);
		s.delete(d);
		return true;
	}

	public boolean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean isExit(String employeeName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Employee where employeeName=:employeeName");
		Query q=s.createQuery(hql.toString());
		q.setParameter("employeeName", employeeName);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public boolean isExitWithoutSelf(String employeeName, int employeeId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Employee where employeeName=:employeeName and employeeId !=:employeeId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("employeeName", employeeName);
		q.setParameter("employeeId", employeeId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public List<Employee> fiandAllEmployee() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("from Employee order by employeeId");
		Query q=s.createQuery(hql.toString());
		return q.list();
	}

	public long findCount() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Employee");
		Query q=s.createQuery(hql.toString());
		long count = (long)q.uniqueResult();
		return count;
	}

}
