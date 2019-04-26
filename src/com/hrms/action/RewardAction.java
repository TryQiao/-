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

import com.hrms.model.Department;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Pay;
import com.hrms.model.Reward;
import com.hrms.service.EmployeeService;
import com.hrms.service.PayService;
import com.hrms.service.RewardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/reward")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class RewardAction extends ActionSupport implements ModelDriven<Reward>{
	
	private Reward reward=new Reward();
	private int pageIndex = 1;
	
	@Autowired
	private RewardService rewardService;
	@Autowired
	private PayService payService;
	
	//查询
	@Action(value="listReward",results= {@Result(name="list",type="dispatcher",location="/reward.jsp")})
	public String listReward() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		List<Pay> pays=payService.findAllPay();
		request.setAttribute("pays", pays);
		
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = rewardService.findTotalCount(reward);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Reward> rewards = rewardService.listReward(reward,page);
		//存到request域中
		request.setAttribute("rewards", rewards);
		request.setAttribute("page", page);
		
		return "list";
	}
	
	//个人奖惩查询
		@Action(value="listRewardPerson",results= {@Result(name="listPerson",type="dispatcher",location="/rewardPerson.jsp")})
		public String listRewardPerson() {
			HttpServletRequest request = ServletActionContext.getRequest();
			//创建Page对象
			List<Pay> pays=payService.findAllPay();
			request.setAttribute("pays", pays);
			
			Page page = new Page();
			System.out.println(pageIndex+"=======");
			page.setPageIndex(pageIndex);
			page.setUrl(request.getRequestURI());
			//查询总条数
			long totalCount = rewardService.findTotalCount(reward);
			System.out.println(totalCount);
			page.setTotalCount(totalCount);
			//查询记录
			List<Reward> rewards = rewardService.listReward(reward,page);
			//存到request域中
			request.setAttribute("rewards", rewards);
			request.setAttribute("page", page);
			return "listPerson";
		}


	//删除
	@Action(value="deleteReward",results= {@Result(name="list",type="redirect",location="listReward")})
	public String deleteReward(){
		boolean flag =rewardService.deleteReward(reward.getRewardId());
		System.out.println(flag+"=======");
		if(flag) {
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	//添加
	@Action(value="addReward",results= {@Result(name="list",type="redirect",location="listReward")})
	public String addReward(){
		Pay pay= payService.findPay(reward.getPay().getPayId());
		reward.setRewardName(pay.getEmpl().getEmployeeName());
		
		if(reward.getPay().getPayId()==null || "".equals(reward.getPay().getPayId()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "员工不能为空");
			return ERROR;
		}
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
		
		boolean flag=rewardService.addReward(reward);
		if(flag){
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "奖励名称已存在,添加失败");
			return ERROR;
		}
	}
	
	@Action(value="findReward",results= {@Result(name="update",type="dispatcher",location="/updateReward.jsp")})
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
		Pay pay= payService.findPay(reward.getPay().getPayId());
		reward.setRewardName(pay.getEmpl().getEmployeeName());
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
	}
	
	//查询出角色,跳转到添加用户的页面
		@Action(value="addRewardPage",results= {@Result(name="addReward",type="dispatcher",location="/addReward.jsp")})
		public String addRewardPage() {
			HttpServletRequest request = ServletActionContext.getRequest();
			//查询所有角色
			List<Pay> pays=payService.findAllPay();
			request.setAttribute("pays", pays);
			return "addReward";
		}
	public Reward getModel() {
		return reward;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
