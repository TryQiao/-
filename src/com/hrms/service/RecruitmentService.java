package com.hrms.service;

import java.util.List;

import com.hrms.model.Recruitment;
import com.hrms.model.Page;

public interface RecruitmentService {
	boolean addRecruitment(Recruitment recruitment);
	boolean deleteRecruitment(int recruitmentId);
	boolean updateRecruitment(Recruitment recruitment);
	Recruitment findRecruitment(int recruitmentId);
	long findTotalCount(Recruitment recruitment);
	List<Recruitment> listRecruitment(Recruitment recruitment,Page page);
	long findCount();
}
