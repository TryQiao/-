package com.hrms.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
@Namespace("/recruitment")
@Results({@Result(name="error",type="dispatcher",location="/error.jsp")})
public class RecruitmentAction extends ActionSupport implements ModelDriven<Recruitment>{
	
	private Recruitment recruitment=new Recruitment();
	private int pageIndex = 1;
	private String recruitmentImgFileName;//获取文件原名
    private File recruitmentImg;//获取文件
	
	@Autowired
	private RecruitmentService recruitmentService;
	
	//查询
	@Action(value="listRecruitment",results= {@Result(name="list",type="dispatcher",location="/recruitment.jsp")})
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

	//删除
	@Action(value="deleteRecruitment",results= {@Result(name="list",type="redirect",location="listRecruitment")})
	public String deleteRecruitment(){
		boolean flag =recruitmentService.deleteRecruitment(recruitment.getRecruitmentId());
		System.out.println(flag+"=======");
		if(flag) {
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败");
			return ERROR;
		}
	}
	
	//添加
	@Action(value="addRecruitment",results= {@Result(name="list",type="redirect",location="listRecruitment")})
	public String addRecruitment(){
		if(recruitment.getRecruitmentTitle()==null || "".equals(recruitment.getRecruitmentTitle()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "标题不能为空");
			return ERROR;
		}
		if(recruitment.getRecruitmentContent()==null || "".equals(recruitment.getRecruitmentContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "内容不能为空");
			return ERROR;
		}
		if(recruitment.getRecruitmentDate()==null || "".equals(recruitment.getRecruitmentDate()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "日期不能为空");
			return ERROR;
		}
		
		//拼接新的文件名称
        if(recruitmentImg != null) {
            String imgName = recruitmentImg.getName();
            String newName = imgName.substring(0, imgName.indexOf("."))+recruitmentImgFileName.substring(recruitmentImgFileName.lastIndexOf("."));

            String dirPath = "/recruitment/image/";
            //获取要保存文件夹的物理路径(绝对路径)
            String realPath=ServletActionContext.getServletContext().getRealPath("/");
            File file = new File(realPath+dirPath);
            //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
            if(!file.exists())
                file.mkdirs();
            try {//保存重命名后的图片
                FileUtils.copyFile(recruitmentImg,new File(realPath+dirPath+newName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置路径
            recruitment.setRecruitmentImage(dirPath+newName);
        }else {
            //如果没有选择头像,设置default.jpg为默认头像
        	recruitment.setRecruitmentImage("/recruitment/image/loading.gif");
        }

		
		boolean flag=recruitmentService.addRecruitment(recruitment);
		if(flag){
			return "list";
		}else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "招聘标题已存在,添加失败");
			return ERROR;
		}
	}
	@Action(value="findRecruitment",results= {@Result(name="update",type="dispatcher",location="/updateRecruitment.jsp")})
	public String findRecruitment(){
		Recruitment r=recruitmentService.findRecruitment(recruitment.getRecruitmentId());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("recruitments", r);
		return "update";
	}
	@Action(value="updateRecruitment",results= {@Result(name="list",type="redirect",location="listRecruitment")})
	public String updateRecruitment(){
		if(recruitment.getRecruitmentTitle()==null || "".equals(recruitment.getRecruitmentTitle()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "标题不能为空");
			return ERROR;
		}
		if(recruitment.getRecruitmentContent()==null || "".equals(recruitment.getRecruitmentContent()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "内容不能为空");
			return ERROR;
		}
		if(recruitment.getRecruitmentDate()==null || "".equals(recruitment.getRecruitmentDate()))
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "日期不能为空");
			return ERROR;
		}
		
		if(recruitmentImg != null) {
			String imgName = recruitmentImg.getName();
			String newName = imgName.substring(0, imgName.indexOf("."))+recruitmentImgFileName.substring(recruitmentImgFileName.lastIndexOf("."));
			
			String dirPath = "/recruitment/image/";
			//获取要保存文件夹的物理路径(绝对路径)
	        String realPath=ServletActionContext.getServletContext().getRealPath("/");
	        File file = new File(realPath+dirPath);
	        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
	        if(!file.exists()) 
	        	file.mkdirs();
	        try {//保存重命名后的图片
				FileUtils.copyFile(recruitmentImg,new File(realPath+dirPath+newName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        //设置路径
	        recruitment.setRecruitmentImage(dirPath+newName);
		}
		
		boolean flag=recruitmentService.updateRecruitment(recruitment);
		if(flag)
		{
			return "list";
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", "更新失败");
			return ERROR;
		}
	}
	public Recruitment getModel() {
		return recruitment;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getRecruitmentImgFileName() {
		return recruitmentImgFileName;
	}

	public void setRecruitmentImgFileName(String recruitmentImgFileName) {
		this.recruitmentImgFileName = recruitmentImgFileName;
	}

	public File getRecruitmentImg() {
		return recruitmentImg;
	}

	public void setRecruitmentImg(File recruitmentImg) {
		this.recruitmentImg = recruitmentImg;
	}
	
}
