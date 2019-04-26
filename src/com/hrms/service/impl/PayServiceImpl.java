package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.PayDao;
import com.hrms.dao.RewardDao;
import com.hrms.model.Employee;
import com.hrms.model.Page;
import com.hrms.model.Pay;
import com.hrms.model.Reward;
import com.hrms.service.EmployeeService;
import com.hrms.service.PayService;
import com.hrms.service.RewardService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDao payDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Pay findPay(int payId) {
		return payDao.findPay(payId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Pay pay) {
		return payDao.findTotalCount(pay);
	}

	public List<Pay> listPay(Pay pay, Page page) {
		return payDao.listPay(pay, page);
	}

	@Override
	public boolean deletePay(int payId) {
		
		return payDao.deletePay(payId);
	}


	public boolean addPay(Pay pay) {
		boolean flag=payDao.isExit(pay.getEmpl().getEmployeeId());
		if(flag==true)
		{
			return false;
		}
		else {
			payDao.addPay(pay);
		}
		return true;
	}

	public boolean updatePay(Pay pay) {
		boolean flag=payDao.isExitWithoutSelf(pay.getPayEmployee(),pay.getPayId());
		if(flag==true)
		{
			return false;
		}
		else {
			payDao.updatePay(pay);
		}
		return true;
	}

	public List<Pay> findAllPay() {
		return payDao.findAllPay();
	}

}
