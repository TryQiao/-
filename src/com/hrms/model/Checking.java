package com.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tb_checking")
public class Checking implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="checking_id",length=10,nullable=false)
	private Integer checkingId;
	
	@Column(name="checking_name",length=20)
	private String checkingName;
	
	@Column(name="checking_type",length=20,nullable=false)
	private String checkingType;
	
	@Column(name="checking_start",length=20,nullable=false)
	private String checkingStart;
	
	@Column(name="checking_end",length=20,nullable=false)
	private String checkingEnd;
	
	@Column(name="checking_money",length=20,nullable=false)
	private Integer checkingMoney;
	
	@Column(name="checking_recorder",length=20,nullable=false)
	private String checkingRecorder;
	
	@ManyToOne(targetEntity=Pay.class,fetch=FetchType.EAGER)
	@JoinColumn(name="pay_id",referencedColumnName="pay_id")
	private Pay py=new Pay();

	public Integer getCheckingId() {
		return checkingId;
	}

	public void setCheckingId(Integer checkingId) {
		this.checkingId = checkingId;
	}

	public String getCheckingName() {
		return checkingName;
	}

	public void setCheckingName(String checkingName) {
		this.checkingName = checkingName;
	}

	public String getCheckingType() {
		return checkingType;
	}

	public void setCheckingType(String checkingType) {
		this.checkingType = checkingType;
	}

	public String getCheckingStart() {
		return checkingStart;
	}

	public void setCheckingStart(String checkingStart) {
		this.checkingStart = checkingStart;
	}

	public String getCheckingEnd() {
		return checkingEnd;
	}

	public void setCheckingEnd(String checkingEnd) {
		this.checkingEnd = checkingEnd;
	}

	public String getCheckingRecorder() {
		return checkingRecorder;
	}

	public Integer getCheckingMoney() {
		return checkingMoney;
	}

	public void setCheckingMoney(Integer checkingMoney) {
		this.checkingMoney = checkingMoney;
	}

	public void setCheckingRecorder(String checkingRecorder) {
		this.checkingRecorder = checkingRecorder;
	}

	public Pay getPy() {
		return py;
	}

	public void setPy(Pay py) {
		this.py = py;
	}

	
	
	
	
	
	
}