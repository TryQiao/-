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

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.hrms.model.Page;
import com.hrms.model.Recruitment;
import com.hrms.service.RecruitmentService;

@ParentPackage("struts-default")
@Namespace("/recruitment_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class Employee_RecruitmentAction extends ActionSupport implements ModelDriven<Recruitment>{
	
	private Recruitment recruitment=new Recruitment();
	private int pageIndex = 1;
	
	@Autowired
	private RecruitmentService recruitmentService;
	
	//查询
	@Action(value="listRecruitment",results= {@Result(name="list",type="dispatcher",location="/recruitment_employee.jsp")})
	public String listRecruitment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = recruitmentService.findTotalCount(recruitment);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Recruitment> recruitments = recruitmentService.listRecruitment(recruitment,page);
		//存到request域中
		request.setAttribute("recruitments", recruitments);
		request.setAttribute("page", page);
		
		return "list";
	}

	public Recruitment getModel() {
		return recruitment;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
