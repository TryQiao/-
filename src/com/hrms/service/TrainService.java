package com.hrms.service;

import java.util.List;

import com.hrms.model.Train;
import com.hrms.model.Page;

public interface TrainService {
	boolean addTrain(Train train);
	boolean deleteTrain(int trainId);
	boolean updateTrain(Train train);
	Train findTrain(int trainId);
	long findTotalCount(Train train);
	List<Train> listTrain(Train train,Page page);
	long findCount();
}
