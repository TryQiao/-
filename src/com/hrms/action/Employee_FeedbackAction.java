package com.hrms.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.ManagerDao;
import com.hrms.dao.impl.ManagerDaoImpl;
import com.hrms.model.Employee;
import com.hrms.model.Feedback;
import com.hrms.model.Manager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.hrms.model.Page;
import com.hrms.service.EmployeeService;
import com.hrms.service.FeedbackService;
import com.hrms.service.ManagerService;

@ParentPackage("struts-default")
@Namespace("/feedback_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class Employee_FeedbackAction extends ActionSupport implements ModelDriven<Feedback>{
	
	private Feedback feedback=new Feedback();
	private Employee employee=new Employee();
	private int pageIndex = 1;
	
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private EmployeeService employeeService;
	
	//查询
	@Action(value="listFeedback",results= {@Result(name="list",type="dispatcher",location="/feedback_employee.jsp")})
	public String listFeedback() throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = feedbackService.findTotalCount(feedback);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Feedback> feedbacks = feedbackService.listFeedback(feedback,page);
		//存到request域中
		request.setAttribute("feedbacks", feedbacks);
		request.setAttribute("page", page);
		
		return "list";
	}

	//删除
	@Action(value="deleteFeedback",results= {@Result(name="list",type="redirect",location="listFeedback")})
	public String deleteFeedback(){
		boolean flag =feedbackService.deleteFeedback(feedback.getFeedbackId());
		System.out.println(flag+"=======");
		if(flag) {
			HttpServletRequest request=ServletActionContext.getRequest();
			long countFeedback=feedbackService.findCountFeedback();
			HttpSession session = request.getSession();
			session.setAttribute("countFeedback", countFeedback);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//
		@Action(value="addFeedback_Employee",results= {@Result(name="add",type="dispatcher",location="/addFeedback_Employee.jsp")})
		public String addFeedback_Employee(){
			
			HttpServletRequest request=ServletActionContext.getRequest();
			int employeeId=Integer.parseInt(request.getParameter("employId"));
			System.out.println(employeeId+"666");
			Employee employee=employeeService.findEmployee(employeeId);
			feedback.setFeedbackName(employee.getEmployeeName());
			System.out.println(feedback.getFeedbackName());
			return "add";
		}
	//添加
	@Action(value="addFeedback",results= {@Result(name="list",type="redirect",location="listFeedback")})
	public String addFeedback(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(feedback.getFeedbackName()==null || "".equals(feedback.getFeedbackName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "姓名不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackContent()==null || "".equals(feedback.getFeedbackContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "反馈内容不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackDate()==null || "".equals(feedback.getFeedbackDate()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "反馈时间不能为空");
			return ERROR;
		}
		
		boolean flag=feedbackService.addFeedback(feedback);
		if(flag){
			
			long countFeedback=feedbackService.findCountFeedback();
			HttpSession session = request.getSession();
			session.setAttribute("countFeedback", countFeedback);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "反馈内容已存在，添加失败");
			return ERROR;
		}
	}
	@Action(value="findFeedback",results= {@Result(name="update",type="dispatcher",location="/updateFeedback_Employee.jsp")})
	public String findFeedback(){
		Feedback f=feedbackService.findFeedback(feedback.getFeedbackId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("feedbacks", f);
		return "update";
	}
	@Action(value="updateFeedback",results= {@Result(name="list",type="redirect",location="listFeedback")})
	public String updateFeedback(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(feedback.getFeedbackName()==null || "".equals(feedback.getFeedbackName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "姓名不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackContent()==null || "".equals(feedback.getFeedbackContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "反馈内容不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackDate()==null || "".equals(feedback.getFeedbackDate()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "反馈时间不能为空");
			return ERROR;
		}
		boolean flag=feedbackService.updateFeedback(feedback);
		if(flag)
		{
			Feedback feedbacks=feedbackService.findFeedback(feedback.getFeedbackId());
			HttpSession session = request.getSession();
			session.setAttribute("Feedback", feedbacks);
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	public Feedback getModel() {
		return feedback;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
}
