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
@Namespace("/train")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class TrainAction extends ActionSupport implements ModelDriven<Train>{
	
	private Train train=new Train();
	private int pageIndex = 1;
	
	@Autowired
	private TrainService trainService;
	
	//查询
	@Action(value="listTrain",results= {@Result(name="list",type="dispatcher",location="/train.jsp")})
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

	//删除
	@Action(value="deleteTrain",results= {@Result(name="list",type="redirect",location="listTrain")})
	public String deleteTrain(){
		boolean flag =trainService.deleteTrain(train.getTrainId());
		System.out.println(flag+"=======");
		if(flag) {
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addTrain",results= {@Result(name="list",type="redirect",location="listTrain")})
	public String addTrain(){
		if(train.getTrainTitle()==null || "".equals(train.getTrainTitle()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "主题不能为空");
			return ERROR;
		}
		if(train.getTrainMan()==null || "".equals(train.getTrainMan()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "培训人不能为空");
			return ERROR;
		}
		if(train.getTrainTime()==null || "".equals(train.getTrainTime()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "时间不能为空");
			return ERROR;
		}
		if(train.getTrainAddress()==null || "".equals(train.getTrainAddress()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "地点不能为空");
			return ERROR;
		}
		if(train.getTrainJoin()==null || "".equals(train.getTrainJoin()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "参加人不能为空");
			return ERROR;
		}
		if(train.getTrainAim()==null || "".equals(train.getTrainAim()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "培训目的不能为空");
			return ERROR;
		}
		boolean flag=trainService.addTrain(train);
		if(flag){
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "培训主题已存在,添加失败");
			return ERROR;
		}
	}
	@Action(value="findTrain",results= {@Result(name="update",type="dispatcher",location="/updateTrain.jsp")})
	public String findTrain(){
		Train t=trainService.findTrain(train.getTrainId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("trains", t);
		return "update";
	}
	@Action(value="updateTrain",results= {@Result(name="list",type="redirect",location="listTrain")})
	public String updateTrain(){
		if(train.getTrainTitle()==null || "".equals(train.getTrainTitle()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "主题不能为空");
			return ERROR;
		}
		if(train.getTrainMan()==null || "".equals(train.getTrainMan()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "培训人不能为空");
			return ERROR;
		}
		if(train.getTrainTime()==null || "".equals(train.getTrainTime()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "时间不能为空");
			return ERROR;
		}
		if(train.getTrainAddress()==null || "".equals(train.getTrainAddress()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "地点不能为空");
			return ERROR;
		}
		if(train.getTrainJoin()==null || "".equals(train.getTrainJoin()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "参加人不能为空");
			return ERROR;
		}
		if(train.getTrainAim()==null || "".equals(train.getTrainAim()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "培训目的不能为空");
			return ERROR;
		}
		boolean flag=trainService.updateTrain(train);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	public Train getModel() {
		return train;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
