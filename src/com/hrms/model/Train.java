package com.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_train")
public class Train implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="train_id",length=10,nullable=false)
	private Integer trainId;
	
	@Column(name="train_man",length=20,nullable=false)
	private String trainMan;
	//培训主题
	@Column(name="train_title",length=20,nullable=false)
	private String trainTitle;
	
	@Column(name="train_time",length=20,nullable=false)
	private String trainTime;
	
	@Column(name="train_address",length=30,nullable=false)
	private String trainAddress;
	
	@Column(name="train_join",length=20,nullable=false)
	private String trainJoin;
	
	@Column(name="train_aim",length=1000,nullable=false)
	private String trainAim;

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getTrainMan() {
		return trainMan;
	}

	public void setTrainMan(String trainMan) {
		this.trainMan = trainMan;
	}

	public String getTrainTitle() {
		return trainTitle;
	}

	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
	}

	public String getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(String trainTime) {
		this.trainTime = trainTime;
	}

	

	public String getTrainAddress() {
		return trainAddress;
	}

	public void setTrainAddress(String trainAddress) {
		this.trainAddress = trainAddress;
	}

	public String getTrainJoin() {
		return trainJoin;
	}

	public void setTrainJoin(String trainJoin) {
		this.trainJoin = trainJoin;
	}

	public String getTrainAim() {
		return trainAim;
	}

	public void setTrainAim(String trainAim) {
		this.trainAim = trainAim;
	}
	
	
}
