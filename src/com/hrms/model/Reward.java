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
@Table(name="tb_reward")
public class Reward implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reward_id",length=10,nullable=false)
	private Integer rewardId;
	
	@Column(name="reward_name",length=20)
	private String rewardName;
	
	@Column(name="reward_title",length=100,nullable=false)
	private String rewardTitle;
	
	@Column(name="reward_type",length=20,nullable=false)
	private String rewardType;
	
	@Column(name="reward_money",length=10,nullable=false)
	private Integer rewardMoney;
	
	@Column(name="reward_time",length=20,nullable=false)
	private String rewardTime;
	
	@Column(name="reward_reason",length=100)
	private String  rewardReason;
	
	@ManyToOne(targetEntity=Pay.class,fetch=FetchType.EAGER)
	@JoinColumn(name="pay_id",referencedColumnName="pay_id")
	private Pay pay=new Pay();

	public Integer getRewardId() {
		return rewardId;
	}

	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getRewardTitle() {
		return rewardTitle;
	}

	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public Integer getRewardMoney() {
		return rewardMoney;
	}

	public void setRewardMoney(Integer rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public String getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(String rewardTime) {
		this.rewardTime = rewardTime;
	}

	public String getRewardReason() {
		return rewardReason;
	}

	public void setRewardReason(String rewardReason) {
		this.rewardReason = rewardReason;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}
	
	
	
}
