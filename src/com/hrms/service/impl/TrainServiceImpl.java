package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dao.ManagerDao;
import com.hrms.dao.TrainDao;
import com.hrms.model.Manager;
import com.hrms.model.Page;
import com.hrms.model.Train;
import com.hrms.service.ManagerService;
import com.hrms.service.TrainService;

@Service
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Train findTrain(int trainId) {
		return trainDao.findTrain(trainId);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public long findTotalCount(Train train) {
		return trainDao.findTotalCount(train);
	}

	public List<Train> listTrain(Train train, Page page) {
		return trainDao.listTrain(train, page);
	}

	@Override
	public boolean deleteTrain(int trainId) {
		
		return trainDao.deleteTrain(trainId);
	}


	public boolean addTrain(Train train) {
		boolean flag=trainDao.isExit(train.getTrainTitle());
		if(flag==true)
		{
			return false;
		}
		else {
			return trainDao.addTrain(train);
		}
		
	}

	public boolean updateTrain(Train train) {
		boolean flag=trainDao.isExitWithoutSelf(train.getTrainTitle(),train.getTrainId());
		if(flag==true)
		{
			return false;
		}
		else {
			trainDao.updateTrain(train);
		}
		return true;
	}

	public long findCount() {
		return trainDao.findCount();
	}

}
