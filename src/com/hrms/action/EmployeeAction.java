package com.hrms.action;

import java.util.List;

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
import com.hrms.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hrms.model.Page;
import com.hrms.service.DepartmentService;
import com.hrms.service.EmployeeService;

@ParentPackage("struts-default")
@Namespace("/employee")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private Employee employee=new Employee();
	private int pageIndex = 1;
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	//查询
	@Action(value="listEmployee",results= {@Result(name="list",type="dispatcher",location="/employee.jsp")})
	public String listEmployee() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		List<Department> dm=departmentService.findAllDepartment();
		request.setAttribute("dms", dm);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = employeeService.findTotalCount(employee);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Employee> employees = employeeService.listEmployee(employee,page);
		//存到request域中
		request.setAttribute("employees", employees);
		request.setAttribute("page", page);
		
		return "list";
	}
	
	//员工部门查询
	@Action(value="employeeDepartment",results= {@Result(name="listDepartment",type="dispatcher",location="/employeeDepartment.jsp")})
	public String employeeDepartment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		/*//创建Page对象
		List<Department> dm=departmentService.findAllDepartment();
		request.setAttribute("dms", dm);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = employeeService.findTotalCount(employee);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);*/
		//查询记录
		System.out.println(employee.getEmployeeId());
		Employee e = employeeService.findEmployee(employee.getEmployeeId());
		List<Department> dep = departmentService.findAllDepartment();
		request.setAttribute("deps", dep);
		/*System.out.println(employees.getDepartments().getDepartmentName());*/
		//存到request域中
		request.setAttribute("employees", e);
		return "listDepartment";
		
	}
	
	//职务查询
	@Action(value="listEmployeePost",results= {@Result(name="list",type="dispatcher",location="/employeePost.jsp")})
	public String listEmployeePost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		List<Department> dm=departmentService.findAllDepartment();
		request.setAttribute("dms", dm);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = employeeService.findTotalCount(employee);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Employee> employees = employeeService.listEmployee(employee,page);
		//存到request域中
		request.setAttribute("employees", employees);
		request.setAttribute("page", page);
		
		return "list";
	}

	//删除
	@Action(value="deleteEmployee",results= {@Result(name="list",type="redirect",location="listEmployee")})
	public String deleteEmployee(){
		boolean flag =employeeService.deleteEmployee(employee.getEmployeeId());
		System.out.println(flag+"=======");
		if(flag) {
			long count=employeeService.findCount();
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("countEmployee", count);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addEmployee",results= {@Result(name="list",type="redirect",location="listEmployee")})
	public String addEmployee(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(employee.getEmployeeName()==null || "".equals(employee.getEmployeeName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "姓名不能为空");
			return ERROR;
		}
		if(employee.getEmployeeAge()==null || "".equals(employee.getEmployeeAge()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "年龄不能为空");
			return ERROR;
		}
		if(employee.getEmployeeSex()==null || "".equals(employee.getEmployeeSex()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "性别不能为空");
			return ERROR;
		}
		if(employee.getEmployeeBorn()==null || "".equals(employee.getEmployeeBorn()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "出生日期不能为空");
			return ERROR;
		}
		if(employee.getEmployeeMarriage()==null || "".equals(employee.getEmployeeMarriage()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "婚姻情况不能为空");
			return ERROR;
		}
		if(employee.getEmployeePhone()==null || "".equals(employee.getEmployeePhone()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "电话不能为空");
			return ERROR;
		}
		if(employee.getEmployeeAddress()==null || "".equals(employee.getEmployeeAddress()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "住址不能为空");
			return ERROR;
		}
		if(employee.getEmployeeStarttime()==null || "".equals(employee.getEmployeeStarttime()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "开始工作时间不能为空");
			return ERROR;
		}
		if(employee.getEmployeePwd()==null || "".equals(employee.getEmployeePwd()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
			return ERROR;
		}
		if(employee.getEmployeePost()==null || "".equals(employee.getEmployeePost()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "职位不能为空");
			return ERROR;
		}
		if(employee.getDepartments().getDepartmentId()==null || "".equals(employee.getDepartments().getDepartmentId()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门不能为空");
			return ERROR;
		}
		boolean flag=employeeService.addEmployee(employee);
		if(flag){
			long count=employeeService.findCount();
			
			HttpSession session = request.getSession();
			session.setAttribute("countEmployee", count);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "员工已存在,添加失败");
			return ERROR;
		}
	}
	@Action(value="detailEmployee",results= {@Result(name="detail",type="dispatcher",location="/detailEmployee.jsp")})
	public String detailEmployee(){
		Employee e=employeeService.findEmployee(employee.getEmployeeId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		/*List<Department> dep = departmentService.findAllDepartment();
		request.setAttribute("deps", dep);*/
		request.setAttribute("employees", e);
		return "detail";
	}
	@Action(value="findEmployee",results= {@Result(name="update",type="dispatcher",location="/updateEmployee.jsp")})
	public String findEmployee(){
		Employee e=employeeService.findEmployee(employee.getEmployeeId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		List<Department> dep = departmentService.findAllDepartment();
		request.setAttribute("deps", dep);
		request.setAttribute("employees", e);
		return "update";
	}
	
	@Action(value="findEmployeePost",results= {@Result(name="update",type="dispatcher",location="/updateEmployeePost.jsp")})
	public String findEmployeePost(){
		Employee e=employeeService.findEmployee(employee.getEmployeeId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		List<Department> dep = departmentService.findAllDepartment();
		request.setAttribute("deps", dep);
		request.setAttribute("employees", e);
		return "update";
	}
	@Action(value="updateEmployee",results= {@Result(name="list",type="redirect",location="listEmployee")})
	public String updateEmployee(){
		if(employee.getEmployeeName()==null || "".equals(employee.getEmployeeName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "姓名不能为空");
			return ERROR;
		}
		if(employee.getEmployeeAge()==null || "".equals(employee.getEmployeeAge()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "年龄不能为空");
			return ERROR;
		}
		if(employee.getEmployeeSex()==null || "".equals(employee.getEmployeeSex()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "性别不能为空");
			return ERROR;
		}
		if(employee.getEmployeeBorn()==null || "".equals(employee.getEmployeeBorn()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "出生日期不能为空");
			return ERROR;
		}
		if(employee.getEmployeeMarriage()==null || "".equals(employee.getEmployeeMarriage()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "婚姻情况不能为空");
			return ERROR;
		}
		if(employee.getEmployeePhone()==null || "".equals(employee.getEmployeePhone()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "电话不能为空");
			return ERROR;
		}
		if(employee.getEmployeeAddress()==null || "".equals(employee.getEmployeeAddress()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "住址不能为空");
			return ERROR;
		}
		if(employee.getEmployeeStarttime()==null || "".equals(employee.getEmployeeStarttime()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "开始工作时间不能为空");
			return ERROR;
		}
		if(employee.getEmployeePwd()==null || "".equals(employee.getEmployeePwd()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
			return ERROR;
		}
		if(employee.getDepartments().getDepartmentId()==null || "".equals(employee.getDepartments().getDepartmentId()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "部门不能为空");
			return ERROR;
		}
		boolean flag=employeeService.updateEmployee(employee);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	@Action(value="updateEmployeePost",results= {@Result(name="list",type="redirect",location="listEmployeePost")})
	public String updateEmployeePost(){
		if(employee.getEmployeeName()==null || "".equals(employee.getEmployeeName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "姓名不能为空");
			return ERROR;
		}
		if(employee.getEmployeePost()==null || "".equals(employee.getEmployeePost()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "职位不能为空");
			return ERROR;
		}
		boolean flag=employeeService.updateEmployee(employee);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	
	//查询出角色,跳转到添加用户的页面
		@Action(value="addEmployeePage",results= {@Result(name="addEmployee",type="dispatcher",location="/addEmployee.jsp")})
		public String addEmployeePage() {
			HttpServletRequest request = ServletActionContext.getRequest();
			//查询所有角色
			List<Department> dep = departmentService.findAllDepartment();
			request.setAttribute("deps", dep);
			return "addEmployee";
		}
	public Employee getModel() {
		return employee;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
