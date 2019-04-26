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

import com.hrms.model.Checking;
import com.hrms.model.Department;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Pay;
import com.hrms.model.Reward;
import com.hrms.service.CheckingService;
import com.hrms.service.EmployeeService;
import com.hrms.service.PayService;
import com.hrms.service.RewardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/checking")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class CheckingAction extends ActionSupport implements ModelDriven<Checking>{
	
	private Checking checking=new Checking();
	private int pageIndex = 1;
	
	@Autowired
	private CheckingService checkingService;
	@Autowired
	private PayService payService;
	
	//查询
	@Action(value="listChecking",results= {@Result(name="list",type="dispatcher",location="/checking.jsp")})
	public String listChecking() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		List<Pay> pays=payService.findAllPay();
		request.setAttribute("pays", pays);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = checkingService.findTotalCount(checking);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Checking> checkings = checkingService.listChecking(checking,page);
		//存到request域中
		request.setAttribute("checkings", checkings);
		request.setAttribute("page", page);
		
		return "list";
	}
	
	//个人奖惩查询
		@Action(value="listCheckingPerson",results= {@Result(name="listCheckingPerson",type="dispatcher",location="/checkingPerson.jsp")})
		public String listCheckingPerson() {
			HttpServletRequest request = ServletActionContext.getRequest();
			//创建Page对象
			List<Pay> pays=payService.findAllPay();
			request.setAttribute("pays", pays);
			
			Page page = new Page();
			System.out.println(pageIndex+"=======");
			page.setPageIndex(pageIndex);
			page.setUrl(request.getRequestURI());
			//查询总条数
			long totalCount = checkingService.findTotalCount(checking);
			System.out.println(totalCount);
			page.setTotalCount(totalCount);
			//查询记录
			List<Checking> checkings = checkingService.listChecking(checking,page);
			//存到request域中
			request.setAttribute("checkings", checkings);
			request.setAttribute("page", page);
			return "listCheckingPerson";
		}


	//删除
	@Action(value="deleteChecking",results= {@Result(name="list",type="redirect",location="listChecking")})
	public String deleteChecking(){
		boolean flag =checkingService.deleteChecking(checking.getCheckingId());
		System.out.println(flag+"=======");
		if(flag) {
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//查询出角色,跳转到添加用户的页面
			@Action(value="addCheckingPage",results= {@Result(name="addCheckings",type="dispatcher",location="/addChecking.jsp")})
			public String addCheckingPage() {
				HttpServletRequest request = ServletActionContext.getRequest();
				//查询所有角色
				List<Pay> pays=payService.findAllPay();
				request.setAttribute("pays", pays);
				return "addCheckings";
			}
	
	//添加
	@Action(value="addCheckings",results= {@Result(name="list",type="redirect",location="listChecking")})
	public String addChecking(){
		
		
		Pay pay= payService.findPay(checking.getPy().getPayId());
		checking.setCheckingName(pay.getEmpl().getEmployeeName());
		if(checking.getCheckingType()==null || "".equals(checking.getCheckingType()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "类型不能为空");
			return ERROR;
		}
		if(checking.getCheckingStart()==null || "".equals(checking.getCheckingStart()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "上班时间不能为空");
			return ERROR;
		}
		if(checking.getCheckingEnd()==null || "".equals(checking.getCheckingEnd()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "下班时间不能为空");
			return ERROR;
		}
		if(checking.getCheckingMoney()==null || "".equals(checking.getCheckingMoney()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "金额不能为空");
			return ERROR;
		}
		if(checking.getCheckingRecorder()==null || "".equals(checking.getCheckingRecorder()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "记录人不能为空");
			return ERROR;
		}
		
		boolean flag=checkingService.addChecking(checking);
		if(flag){
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "已存在,添加失败");
			return ERROR;
		}
	}
	
	/*@Action(value="findReward",results= {@Result(name="update",type="dispatcher",location="/updateReward.jsp")})
	public String findReward(){
		Reward r=rewardService.findReward(reward.getRewardId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		List<Pay> pays=payService.findAllPay();
		request.setAttribute("pays", pays);
		request.setAttribute("rewards", r);
		return "update";
	}
	@Action(value="updateReward",results= {@Result(name="list",type="redirect",location="listReward")})
	public String updateReward(){
		if(reward.getRewardTitle()==null || "".equals(reward.getRewardTitle()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "标题不能为空");
			return ERROR;
		}
		if(reward.getRewardType()==null || "".equals(reward.getRewardType()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "类型不能为空");
			return ERROR;
		}
		if(reward.getRewardTime()==null || "".equals(reward.getRewardTime()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "时间不能为空");
			return ERROR;
		}
		if(reward.getRewardMoney()==null || "".equals(reward.getRewardMoney()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "金额不能为空");
			return ERROR;
		}
		if(reward.getRewardReason()==null || "".equals(reward.getRewardReason()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "原因不能为空");
			return ERROR;
		}
		
		boolean flag=rewardService.updateReward(reward);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}*/
	
	
	public Checking getModel() {
		return checking;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
