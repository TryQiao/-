package com.hrms.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Entity
@Table(name="tb_pay")
public class Pay implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_id",length=10,nullable=false)
	private  Integer payId;
	
	@Column(name="pay_supply")
	private Integer paySupply;
	
	@Column(name="pay_basemoney",length=20,nullable=false)
	private Integer payBaseMoney;
	
	@Column(name="pay_employee")
	private Integer payEmployee;
	
	
	

	@OneToMany(targetEntity=Reward.class,mappedBy="pay",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Set<Reward> rw = new HashSet<Reward>(0);
	
	@OneToMany(targetEntity=Checking.class,mappedBy="py",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Set<Checking> ck = new HashSet<Checking>(0);
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee empl;

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	
	public Integer getPaySupply() {
		return paySupply;
	}

	public void setPaySupply(Integer paySupply) {
		this.paySupply = paySupply;
	}

	public Integer getPayBaseMoney() {
		return payBaseMoney;
	}

	public void setPayBaseMoney(Integer payBaseMoney) {
		this.payBaseMoney = payBaseMoney;
	}

	public Integer getPayEmployee() {
		return payEmployee;
	}

	public void setPayEmployee(Integer payEmployee) {
		this.payEmployee = payEmployee;
	}

	public Set<Reward> getRw() {
		return rw;
	}

	public void setRw(Set<Reward> rw) {
		this.rw = rw;
	}
	
	

	public Set<Checking> getCk() {
		return ck;
	}

	public void setCk(Set<Checking> ck) {
		this.ck = ck;
	}

	public Employee getEmpl() {
		return empl;
	}

	public void setEmpl(Employee empl) {
		this.empl = empl;
	}


	
	
	
}
