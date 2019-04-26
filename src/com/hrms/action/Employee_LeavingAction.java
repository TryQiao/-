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

import com.hrms.model.Employee;
import com.hrms.model.Feedback;
import com.hrms.model.Leaving;
import com.hrms.model.Page;
import com.hrms.service.EmployeeService;
import com.hrms.service.LeavingService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/leaving_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class Employee_LeavingAction extends ActionSupport implements ModelDriven<Leaving> {

	private Leaving leaving=new Leaving();
	private int pageIndex = 1;
	
	@Autowired
	private LeavingService leavingService;
	@Autowired
	private EmployeeService employeeService; 
	
	@Action(value="listLeaving",results= {@Result(name="list",type="dispatcher",location="/leaving_employee.jsp")})
	public String listLeaving() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = leavingService.findTotalCount(leaving);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Leaving> leavings = leavingService.listLeaving(leaving,page);
		/*List<Employee> emp = employeeService.findAllEmployee();*/
		//存到request域中
		/*request.setAttribute("emps", emp);*/
		request.setAttribute("leavings", leavings);
		request.setAttribute("page", page);
		
		return "list";
	}
	
	//删除
		@Action(value="deleteLeaving",results= {@Result(name="list",type="redirect",location="listLeaving")})
		public String deleteLeaving(){
			boolean flag =leavingService.deleteLeaving(leaving.getLeavingId());
			if(flag) {
				long countLeaving=leavingService.findCountLeaving();
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("countLeaving", countLeaving);
				return "list";
			}else {
				ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
				return ERROR;
			}
		}
		
		@Action(value="addLeaving_Employee",results= {@Result(name="add",type="dispatcher",location="/addLeaving_Employee.jsp")})
		public String addLeaving_Employee(){
			
			HttpServletRequest request=ServletActionContext.getRequest();
			List<Employee> emp = employeeService.findAllEmployee();
			request.setAttribute("emps", emp);
			int employeeId=Integer.parseInt(request.getParameter("employId"));
			System.out.println(employeeId+"666");
			Employee employee=employeeService.findEmployee(employeeId);
			leaving.setLeavingName(employee.getEmployeeName());
			/*leaving.setEmployees(employee);*/
			System.out.println(leaving.getLeavingName());
			return "add";
		}
		//添加
		@Action(value="addLeaving",results= {@Result(name="list",type="redirect",location="listLeaving")})
		public String addLeaving(){
			HttpServletRequest request=ServletActionContext.getRequest();
			if(leaving.getLeavingType()==null || "".equals(leaving.getLeavingType()))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "类型不能为空");
				return ERROR;
			}
			if(leaving.getLeavingReason()==null || "".equals(leaving.getLeavingReason()))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "详细原因不能为空");
				return ERROR;
			}
			if(leaving.getLeavingTime()==null || "".equals(leaving.getLeavingTime()))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "请假时间不能为空");
				return ERROR;
			}
			boolean flag=leavingService.addLeaving(leaving);
			if(flag){
				
				long countLeaving=leavingService.findCountLeaving();
				HttpSession session = request.getSession();
				session.setAttribute("countLeaving", countLeaving);
				return "list";
			}else {
				ServletActionContext.getRequest().setAttribute("errorMsg", "本时间点请假信息已存在，添加失败");
				return ERROR;
			}
		}
		@Action(value="findLeaving",results= {@Result(name="update",type="dispatcher",location="/updateLeaving_Employee.jsp")})
		public String findLeaving(){
			Leaving l=leavingService.findLeaving(leaving.getLeavingId());
			
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("leavings", l);
			return "update";
		}
		@Action(value="updateLeaving",results= {@Result(name="list",type="redirect",location="listLeaving")})
		public String updateLeaving(){
			HttpServletRequest request=ServletActionContext.getRequest();
			if(leaving.getLeavingType()==null || "".equals(leaving.getLeavingType()))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "类型不能为空");
				return ERROR;
			}
			if(leaving.getLeavingReason()==null || "".equals(leaving.getLeavingReason()==null))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "详细原因不能为空");
				return ERROR;
			}
			if(leaving.getLeavingTime()==null || "".equals(leaving.getLeavingTime()))
			{
				ServletActionContext.getRequest().setAttribute("errorMsg", "时间不能为空");
				return ERROR;
			}
			boolean flag=leavingService.updateLeaving(leaving);
			if(flag)
			{
				Leaving leavings=leavingService.findLeaving(leaving.getLeavingId());
				HttpSession session = request.getSession();
				session.setAttribute("leaving", leavings);
				return "list";
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", "此时间请假信息已存在，更新失败");
				return ERROR;
			}
		}
		
	public Leaving getModel() {
		return leaving;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
