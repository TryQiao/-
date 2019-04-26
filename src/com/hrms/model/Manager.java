package com.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tb_manager")
public class Manager implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manager_id",length=10,nullable=false)
	private Integer managerId;
	@Column(name="manager_name",length=20,nullable=false)
	private String managerName;
	@Column(name="manager_pwd",length=20,nullable=false)
	private String managerPwd;
	@Column(name="manager_sex",length=20)
	private String managerSex;
	@Column(name="manager_phone",length=20)
	private String managerPhone;


	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getManagerSex() {
		return managerSex;
	}

	public void setManagerSex(String managerSex) {
		this.managerSex = managerSex;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}


	
	

}
