package com.hrms.dao;

import java.util.List;

import com.hrms.model.Checking;
import com.hrms.model.Page;

public interface CheckingDao {
	boolean addChecking(Checking checking);
	boolean deleteChecking(int checkingId);
	boolean updateChecking(Checking checking);
	Checking findChecking(int checkingId);
	long findTotalCount(Checking checking);
	List<Checking> listChecking(Checking checking,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String checkingStart,String checkingName);
	boolean isExitWithoutSelf(String checkingType,int checkingId);
}
