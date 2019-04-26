package com.hrms.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.model.Employee;
import com.hrms.model.Manager;
import com.hrms.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
public class LoginEmployeeAction extends ActionSupport implements ModelDriven<Employee> {
	
	private Employee employee=new Employee();
	@Autowired
	private LoginService loginService;
	
	@Action(value="login_employee",results= {@Result(name="login_employee",type="dispatcher",location="/login_employee.jsp"),@Result(name="index_employee",type="redirect",location="/index_employee.jsp")})
	public String login_employee(){
		Employee e=loginService.login_employee(employee);
		System.out.println(e);
		//1.获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		if(e != null) {
			HttpSession session = request.getSession();
			session.setAttribute("employee", e);
			return "index_employee";
			
		}else {//登录成功
			request.setAttribute("msg", "用户名或密码错误");
			return "login_employee";
			
		}
	}
	@Action(value="logout_employee",results= {@Result(name="login",type="redirect",location="/login_employee.jsp")})
	public String logout(){
		
		return "login";
	}
	
	
	public Employee getModel() {
		return employee;
	}

}
