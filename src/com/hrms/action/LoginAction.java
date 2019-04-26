package com.hrms.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.dao.DepartmentDao;
import com.hrms.model.Employee;
import com.hrms.model.Manager;
import com.hrms.service.DepartmentService;
import com.hrms.service.EmployeeService;
import com.hrms.service.LeavingService;
import com.hrms.service.LoginService;
import com.hrms.service.ManagerService;
import com.hrms.service.RecruitmentService;
import com.hrms.service.TrainService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
public class LoginAction extends ActionSupport implements ModelDriven<Manager> {
	
	private Manager manager=new Manager();
	@Autowired
	private LoginService loginService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private LeavingService leavingService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RecruitmentService recruitmentService;
	@Autowired
	private TrainService trainService;
	
	@Action(value="login",results= {@Result(name="login",type="dispatcher",location="/login.jsp"),@Result(name="index",type="redirect",location="/index")})
	public String login(){
		Manager m=loginService.login(manager);
		//1.获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		if(m == null) {//用户不存在
			request.setAttribute("msg", "用户名或密码错误");
			return "login";
		}else {//登录成功
			HttpSession session = request.getSession();
			session.setAttribute("manager", m);
			return "index";
		}
	}
	
	@Action(value="index",results= {@Result(name="success",type="redirect",location="/index.jsp")})
	public String index(){
		long count=employeeService.findCount();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("countEmployee", count);
		long countDepartment=departmentService.findCountDepartment();
		HttpSession session2 = request.getSession();
		session2.setAttribute("countDepartment", countDepartment);
		long countManager=managerService.findCountManager();
		HttpSession session3 = request.getSession();
		session3.setAttribute("countManager", countManager);
		long countLeaving=leavingService.findCountLeaving();
		HttpSession session4 = request.getSession();
		session4.setAttribute("countLeaving", countLeaving);
		long countRecruitment=recruitmentService.findCount();
		HttpSession session5 = request.getSession();
		session5.setAttribute("countRecruitment", countRecruitment);
		long countTrain=trainService.findCount();
		HttpSession session6 = request.getSession();
		session6.setAttribute("countTrain", countTrain);
		
		return "success";
		
	}
	
	@Action(value="logout",results= {@Result(name="login",type="redirect",location="/login.jsp")})
	public String logout(){
		
		return "login";
	}
	
	
	public Manager getModel() {
		return manager;
	}

}
