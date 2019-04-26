package com.hrms.service;

import java.util.List;

import com.hrms.model.Pay;
import com.hrms.model.Employee;
import com.hrms.model.Page;

public interface PayService {
	boolean addPay(Pay pay);
	boolean deletePay(int payId);
	boolean updatePay(Pay pay);
	Pay findPay(int payId);
	long findTotalCount(Pay pay);
	List<Pay> listPay(Pay pay,Page page);
	List<Pay> findAllPay();
}
