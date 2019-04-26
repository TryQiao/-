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
@Table(name="tb_leaving")
public class Leaving implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leavin_id",length=10,nullable=false)
	private Integer leavingId;
	@Column(name="leaving_type",length=20,nullable=false)
	private String leavingType;
	@Column(name="leaving_reason",length=20,nullable=false)
	private String leavingReason;
	@Column(name="leaving_time",length=20,nullable=false)
	private String leavingTime;
	@Column(name="leaving_name",length=20)
	private String leavingName;
	
	
/*	@ManyToOne(targetEntity=Employee.class,fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id",referencedColumnName="employee_id")
	private Employee employees=new Employee();*/

	public Integer getLeavingId() {
		return leavingId;
	}

	public void setLeavingId(Integer leavingId) {
		this.leavingId = leavingId;
	}

	public String getLeavingType() {
		return leavingType;
	}

	public void setLeavingType(String leavingType) {
		this.leavingType = leavingType;
	}

	public String getLeavingReason() {
		return leavingReason;
	}

	public void setLeavingReason(String leavingReason) {
		this.leavingReason = leavingReason;
	}

	public String getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(String leavingTime) {
		this.leavingTime = leavingTime;
	}

/*	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}*/

	public String getLeavingName() {
		return leavingName;
	}

	public void setLeavingName(String leavingName) {
		this.leavingName = leavingName;
	}
	
	
	
	
	
}
