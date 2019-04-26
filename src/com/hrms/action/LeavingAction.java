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
import com.hrms.model.Leaving;
import com.hrms.model.Page;
import com.hrms.service.EmployeeService;
import com.hrms.service.LeavingService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/leaving")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class LeavingAction extends ActionSupport implements ModelDriven<Leaving> {

	private Leaving leaving=new Leaving();
	private int pageIndex = 1;
	
	@Autowired
	private LeavingService leavingService;
	@Autowired
	private EmployeeService employeeService; 
	
	@Action(value="listLeaving",results= {@Result(name="list",type="dispatcher",location="/leaving.jsp")})
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
		List<Employee> emp = employeeService.findAllEmployee();
		//存到request域中
		request.setAttribute("emps", emp);
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
		
	
	
	
	public Leaving getModel() {
		return leaving;
	}

}
