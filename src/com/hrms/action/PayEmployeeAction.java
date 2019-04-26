package com.hrms.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Pay;
import com.hrms.service.EmployeeService;
import com.hrms.service.PayService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/pay_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class PayEmployeeAction extends ActionSupport implements ModelDriven<Pay>{
	
	private Pay pay=new Pay();
	private int pageIndex = 1;
	
	@Autowired
	private PayService payService;
	@Autowired
	private EmployeeService employeeService;
	
	//查询
	@Action(value="listPay",results= {@Result(name="list",type="dispatcher",location="/pay_employee.jsp")})
	public String listPay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		List<Employee> emp=employeeService.findAllEmployee();
		request.setAttribute("emps", emp);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = payService.findTotalCount(pay);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Pay> pays = payService.listPay(pay,page);
		
		//存到request域中
		request.setAttribute("pays", pays);
		request.setAttribute("page", page);
		
		return "list";
	}

	
	
	public Pay getModel() {
		return pay;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
