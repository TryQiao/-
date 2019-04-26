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
@Namespace("/reward_employee")
@Results({@Result(name="error",type="dispatcher",location="/error_employee.jsp")})
public class RewardEmployeeAction extends ActionSupport implements ModelDriven<Reward>{
	
	private Reward reward=new Reward();
	private int pageIndex = 1;
	
	@Autowired
	private RewardService rewardService;
	@Autowired
	private PayService payService;
	
	
	//个人奖惩查询
		@Action(value="listRewardPerson",results= {@Result(name="listPerson",type="dispatcher",location="/rewardPerson_Employee.jsp")})
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


	public Reward getModel() {
		return reward;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
