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

import com.hrms.model.Manager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.hrms.model.Page;
import com.hrms.model.Train;
import com.hrms.service.ManagerService;
import com.hrms.service.TrainService;

@ParentPackage("struts-default")
@Namespace("/train_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class Employee_TrainAction extends ActionSupport implements ModelDriven<Train>{
	
	private Train train=new Train();
	private int pageIndex = 1;
	
	@Autowired
	private TrainService trainService;
	
	//查询
	@Action(value="listTrain",results= {@Result(name="list",type="dispatcher",location="/train_employee.jsp")})
	public String listTrain() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = trainService.findTotalCount(train);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Train> trains = trainService.listTrain(train,page);
		//存到request域中
		request.setAttribute("trains", trains);
		request.setAttribute("page", page);
		
		return "list";
	}

	public Train getModel() {
		return train;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
