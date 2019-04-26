package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.RecruitmentDao;
import com.hrms.model.Page;
import com.hrms.model.Recruitment;
import com.hrms.service.RecruitmentService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class RecruitmentServiceImpl implements RecruitmentService {

	@Autowired
	private RecruitmentDao recruitmentDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Recruitment findRecruitment(int recruitmentId) {
		return recruitmentDao.findRecruitment(recruitmentId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Recruitment recruitment) {
		return recruitmentDao.findTotalCount(recruitment);
	}

	public List<Recruitment> listRecruitment(Recruitment recruitment, Page page) {
		return recruitmentDao.listRecruitment(recruitment, page);
	}

	@Override
	public boolean deleteRecruitment(int recruitmentId) {
		
		return recruitmentDao.deleteRecruitment(recruitmentId);
	}


	public boolean addRecruitment(Recruitment recruitment) {
		boolean flag=recruitmentDao.isExit(recruitment.getRecruitmentTitle());
		if(flag==true)
		{
			return false;
		}
		else {
			return recruitmentDao.addRecruitment(recruitment);
		}
		
	}

	public boolean updateRecruitment(Recruitment recruitment) {
		boolean flag=recruitmentDao.isExitWithoutSelf(recruitment.getRecruitmentTitle(),recruitment.getRecruitmentId());
		if(flag==true)
		{
			return false;
		}
		else {
			recruitmentDao.updateRecruitment(recruitment);
		}
		return true;
	}

	public long findCount() {
		return recruitmentDao.findCount();
	}

}
