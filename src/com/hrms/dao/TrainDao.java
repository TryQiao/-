package com.hrms.dao;

import java.util.List;

import com.hrms.model.Train;
import com.hrms.model.Page;

public interface TrainDao {
	boolean addTrain(Train train);
	boolean deleteTrain(int trainId);
	boolean updateTrain(Train train);
	Train findTrain(int trainId);
	long findTotalCount(Train train);
	List<Train> listTrain(Train train,Page page);
	//判断添加时是否已经存在该姓名信息
	boolean isExit(String trainName);
	boolean isExitWithoutSelf(String trainName,int trainId);
	long findCount();
}
