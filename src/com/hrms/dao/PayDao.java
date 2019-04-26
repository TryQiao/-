package com.hrms.dao;

import java.util.List;

import com.hrms.model.Pay;
import com.hrms.model.Employee;
import com.hrms.model.Page;

public interface PayDao {
	boolean addPay(Pay pay);
	boolean deletePay(int payId);
	boolean updatePay(Pay pay);
	Pay findPay(int payId);
	long findTotalCount(Pay pay);
	List<Pay> listPay(Pay pay,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(int employeeId);
	boolean isExitWithoutSelf(Integer payEmployee,int payId);
	List<Pay> findAllPay();
	
}
