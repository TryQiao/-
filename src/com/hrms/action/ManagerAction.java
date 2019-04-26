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
import com.hrms.model.Manager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.hrms.model.Page;
import com.hrms.service.ManagerService;

@ParentPackage("struts-default")
@Namespace("/manager")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	
	private Manager manager=new Manager();
	private int pageIndex = 1;
	
	@Autowired
	private ManagerService managerService;
	
	//查询
	@Action(value="listManager",results= {@Result(name="list",type="dispatcher",location="/manager.jsp")})
	public String listManager() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//创建Page对象
		Page page = new Page();
		System.out.println(pageIndex+"=======");
		page.setPageIndex(pageIndex);
		page.setUrl(request.getRequestURI());
		//查询总条数
		long totalCount = managerService.findTotalCount(manager);
		System.out.println(totalCount);
		page.setTotalCount(totalCount);
		//查询记录
		List<Manager> managers = managerService.listManager(manager,page);
		//存到request域中
		request.setAttribute("managers", managers);
		request.setAttribute("page", page);
		
		return "list";
	}

	//删除
	@Action(value="deleteManager",results= {@Result(name="list",type="redirect",location="listManager")})
	public String deleteManager(){
		if(manager.getManagerId()==1){
			ServletActionContext.getRequest().setAttribute("errorMsg", "admin不能被删除");
			return ERROR;
		}
		boolean flag =managerService.deleteManager(manager.getManagerId());
		System.out.println(flag+"=======");
		if(flag) {
			HttpServletRequest request=ServletActionContext.getRequest();
			long countManager=managerService.findCountManager();
			HttpSession session = request.getSession();
			session.setAttribute("countManager", countManager);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addManager",results= {@Result(name="list",type="redirect",location="listManager")})
	public String addManager(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(manager.getManagerName()==null || "".equals(manager.getManagerName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "管理员姓名不能为空");
			return ERROR;
		}
		if(manager.getManagerPwd()==null || "".equals(manager.getManagerPwd()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
			return ERROR;
		}
		boolean flag=managerService.addManager(manager);
		if(flag){
			
			long countManager=managerService.findCountManager();
			HttpSession session = request.getSession();
			session.setAttribute("countManager", countManager);
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "管理员已存在,添加失败");
			return ERROR;
		}
	}
	@Action(value="findManager",results= {@Result(name="update",type="dispatcher",location="/updateManager.jsp")})
	public String findManager(){
		Manager m=managerService.findManager(manager.getManagerId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("managers", m);
		return "update";
	}
	@Action(value="updateManager",results= {@Result(name="list",type="redirect",location="listManager")})
	public String updateManager(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(manager.getManagerName()==null || "".equals(manager.getManagerName()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "管理员姓名不能为空");
			return ERROR;
		}
		if(manager.getManagerPwd()==null || "".equals(manager.getManagerPwd()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "密码不能为空");
			return ERROR;
		}
		boolean flag=managerService.updateManager(manager);
		if(flag)
		{
			Manager managers=managerService.findManager(manager.getManagerId());
			HttpSession session = request.getSession();
			session.setAttribute("manager", managers);
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	public Manager getModel() {
		return manager;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
