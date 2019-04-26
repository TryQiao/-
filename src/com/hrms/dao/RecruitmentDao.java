package com.hrms.dao;

import java.util.List;

import com.hrms.model.Page;
import com.hrms.model.Recruitment;

public interface RecruitmentDao {
	boolean addRecruitment(Recruitment recruitment);
	boolean deleteRecruitment(int recruitmentId);
	boolean updateRecruitment(Recruitment recruitment);
	Recruitment findRecruitment(int recruitmentId);
	long findTotalCount(Recruitment recruitment);
	List<Recruitment> listRecruitment(Recruitment recruitment,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String recruitmentTitle);
	boolean isExitWithoutSelf(String recruitmentTitle,int recruitmentId);
	long findCount();
}
