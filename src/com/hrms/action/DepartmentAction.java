package com.hrms.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.model.Department;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hrms.model.Page;
import com.hrms.service.DepartmentService;

@ParentPackage("struts-default")
@Namespace("/department")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	
	private Department department=new Department();
	private int pageIndex = 1;
	
	@Autowired
	private DepartmentService departmentService;
	
	//查询
	@Action(value="listDepartment",results= {@Result(name="list",type="dispatcher",location="/department.jsp")})
	public String listDepartment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = departmentService.findTotalCount(department);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Department> departments = departmentService.listDepartment(department,page);
		//存到request域中
		request.setAttribute("departments", departments);
		request.setAttribute("page", page);
		
		return "list";
	}

	//删除
	@Action(value="deleteDepartment",results= {@Result(name="list",type="redirect",location="listDepartment")})
	public String deleteManager(){
		System.out.println("aaaa");
		boolean flag =departmentService.deleteDepartment(department.getDepartmentId());
		System.out.println(flag+"aaaa");
		if(flag) {
			long countDepartment=departmentService.findCountDepartment();
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("countDepartment", countDepartment);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addDepartment",results= {@Result(name="list",type="redirect",location="listDepartment")})
	public String addDepartment(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(department.getDepartmentName()==null || "".equals(department.getDepartmentName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门名不能为空");
			return ERROR;
		}
		if(department.getDepartmentNumber()==null || "".equals(department.getDepartmentNumber()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门人数不能为空");
			return ERROR;
		}
		boolean flag=departmentService.addDepartment(department);
		if(flag){
			long countDepartment=departmentService.findCountDepartment();
			HttpSession session = request.getSession();
			session.setAttribute("countDepartment", countDepartment);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门已存在,添加失败");
			return ERROR;
		}
	}
	@Action(value="findDepartment",results= {@Result(name="update",type="dispatcher",location="/updateDepartment.jsp")})
	public String findDepartment(){
		Department d=departmentService.findDepartment(department.getDepartmentId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("departments", d);
		return "update";
	}
	@Action(value="updateDepartment",results= {@Result(name="list",type="redirect",location="listDepartment")})
	public String updateDepartment(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(department.getDepartmentName()==null || "".equals(department.getDepartmentName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门名不能为空");
			return ERROR;
		}
		if(department.getDepartmentNumber()==null || "".equals(department.getDepartmentNumber()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门人数不能为空");
			return ERROR;
		}
		
		boolean flag=departmentService.updateDepartment(department);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	
	
	public Department getModel() {
		return department;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
