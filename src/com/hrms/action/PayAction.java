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
@Namespace("/pay")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class PayAction extends ActionSupport implements ModelDriven<Pay>{
	
	private Pay pay=new Pay();
	private int pageIndex = 1;
	
	@Autowired
	private PayService payService;
	@Autowired
	private EmployeeService employeeService;
	
	//查询
	@Action(value="listPay",results= {@Result(name="list",type="dispatcher",location="/pay.jsp")})
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

	//删除
	@Action(value="deletePay",results= {@Result(name="list",type="redirect",location="listPay")})
	public String deletePay(){
		
		boolean flag =payService.deletePay(pay.getPayId());
		System.out.println(flag+"=======");
		if(flag) {
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addPay",results= {@Result(name="list",type="redirect",location="listPay")})
	public String addPay(){
		if(pay.getEmpl().getEmployeeId()==null || "".equals(pay.getEmpl().getEmployeeId()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "员工不能为空");
			return ERROR;
		}
		if(pay.getPayBaseMoney()==null || "".equals(pay.getPayBaseMoney()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "基本工资不能为空");
			return ERROR;
		}
		pay.setPayEmployee(pay.getEmpl().getEmployeeId());
		boolean flag=payService.addPay(pay);
		if(flag){
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "员工已存在,添加失败");
			return ERROR;
		}
		
		
	}
	
	@Action(value="findPay",results= {@Result(name="update",type="dispatcher",location="/updatePay.jsp")})
	public String findPay(){
		Pay p=payService.findPay(pay.getPayId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		List<Employee> emp = employeeService.findAllEmployee();
		request.setAttribute("emps", emp);
		request.setAttribute("pays", p);
		return "update";
	}
	@Action(value="updatePay",results= {@Result(name="list",type="redirect",location="listPay")})
	public String updatePay(){
		if(pay.getEmpl().getEmployeeId()==null || "".equals(pay.getEmpl().getEmployeeId()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "员工不能为空");
			return ERROR;
		}
		if(pay.getPayBaseMoney()==null || "".equals(pay.getPayBaseMoney()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "基本工资不能为空");
			return ERROR;
		}
		boolean flag=payService.updatePay(pay);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	
	//查询出角色,跳转到添加用户的页面
		@Action(value="addPayPage",results= {@Result(name="addPay",type="dispatcher",location="/addPay.jsp")})
		public String addPayPage() {
			HttpServletRequest request = ServletActionContext.getRequest();
			//查询所有角色
			List<Employee> emp = employeeService.findAllEmployee();
			request.setAttribute("emps", emp);
			return "addPay";
		}
	public Pay getModel() {
		return pay;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
