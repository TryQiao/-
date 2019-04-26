package com.hrms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrms.dao.DepartmentDao;
import com.hrms.model.Department;
import com.hrms.model.Page;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Department findDepartment(int departmentId) {
		Session s=sessionFactory.getCurrentSession();
		Department d=s.get(Department.class, departmentId);
		return d;
	}

	public long findTotalCount(Department department) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("select count(*) from Department where 1=1");
		String departmentName = department.getDepartmentName();
		//拼接条件
		if(departmentName != null && !"".equals(departmentName)) {
			hql.append(" and departmentName like :departmentName");
		}
		Query q = s.createQuery(hql.toString());
		//给占位符赋值
		if(departmentName != null && !"".equals(departmentName)) {
			q.setParameter("departmentName", "%"+departmentName+"%");
		}
		return (long)q.uniqueResult();
	}

	public List<Department> listDepartment(Department department, Page page) {
		Session s = sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("from Department where 1=1");
		
		String departmentName=department.getDepartmentName();
		if(departmentName !=null&& !"".equals(departmentName))
		{
			hql.append(" and departmentName like :departmentName");
		}
		Query q = s.createQuery(hql.toString()).setFirstResult(page.getRecordStart()).setMaxResults(page.getPageSize());
		if(departmentName !=null&& !"".equals(departmentName)){
			q.setParameter("departmentName", "%"+departmentName+"%");
		}
		return q.list();
	}

	public boolean deleteDepartment(int departmentId) {
		Session s=sessionFactory.getCurrentSession();
		//更新用户角色外键
		String hql = "update Employee e set e.departments.departmentId=null where e.departments.departmentId=?";
		Query query = s.createQuery(hql);
		query.setParameter(0, departmentId);
		query.executeUpdate();
		Department d=s.get(Department.class, departmentId);
		s.delete(d);
		return true;
	}

	public boolean addDepartment(Department department) {
		sessionFactory.getCurrentSession().save(department);
		return true;
	}

	public boolean isExit(String departmentName) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Department where departmentName=:departmentName");
		Query q=s.createQuery(hql.toString());
		q.setParameter("departmentName", departmentName);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean updateDepartment(Department department) {
		sessionFactory.getCurrentSession().update(department);
		return true;
	}

	public boolean isExitWithoutSelf(String departmentName, int departmentId) {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Department where departmentName=:departmentName and departmentId !=:departmentId");
		Query q=s.createQuery(hql.toString());
		q.setParameter("departmentName", departmentName);
		q.setParameter("departmentId", departmentId);
		long count = (long)q.uniqueResult();
		if(count!=0)
		{
			return true;
		}
		else {
			return false;
		}
	}

	public List<Department> findAllDepartment() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("from Department order by departmentId");
		Query q = s.createQuery(hql.toString());
		return q.list();
	}

	public long findCountDepartment() {
		Session s=sessionFactory.getCurrentSession();
		StringBuffer hql= new StringBuffer("select count(*) from Department");
		Query q=s.createQuery(hql.toString());
		long countDepartment = (long)q.uniqueResult();
		return countDepartment;
	}

}
