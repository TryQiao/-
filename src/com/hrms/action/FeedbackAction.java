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
import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

import com.hrms.dao.ManagerDao;
import com.hrms.dao.impl.ManagerDaoImpl;
import com.hrms.model.Feedback;
import com.hrms.model.Manager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.hrms.model.Page;
import com.hrms.service.FeedbackService;
import com.hrms.service.ManagerService;

@ParentPackage("struts-default")
@Namespace("/feedback")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class FeedbackAction extends ActionSupport implements ModelDriven<Feedback>{
	
	private Feedback feedback=new Feedback();
	private int pageIndex = 1;
	
	@Autowired
	private FeedbackService feedbackService;
	
	//查询
	@Action(value="listFeedback",results= {@Result(name="list",type="dispatcher",location="/feedback.jsp")})
	public String listFeedback() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
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
	
	//添加
	@Action(value="addFeedback",results= {@Result(name="list",type="redirect",location="listFeedback")})
	public String addFeedback(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(feedback.getFeedbackName()==null || "".equals(feedback.getFeedbackName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "管理员姓名不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackContent()==null || "".equals(feedback.getFeedbackContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
			return ERROR;
		}
		boolean flag=feedbackService.addFeedback(feedback);
		if(flag){
			
			long countFeedback=feedbackService.findCountFeedback();
			HttpSession session = request.getSession();
			session.setAttribute("countFeedback", countFeedback);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "添加失败");
			return ERROR;
		}
	}
	@Action(value="findFeedback",results= {@Result(name="update",type="dispatcher",location="/updateFeedback.jsp")})
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
			ServletActionContext.getRequest().setAttribute("errorMsg", "管理员姓名不能为空");
			return ERROR;
		}
		if(feedback.getFeedbackContent()==null || "".equals(feedback.getFeedbackContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
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
