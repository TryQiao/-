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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.sun.org.apache.bcel.internal.generic.NEW;



@Entity
@Table(name="tb_employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id",length=10,nullable=false)
	private  Integer employeeId;
	
	@Column(name="employee_name",length=20,nullable=false)
	private String employeeName;
	
	@Column(name="employee_age",length=6,nullable=false)
	private Integer employeeAge;
	
	@Column(name="employee_sex",length=4,nullable=false)
	private String employeeSex;
	
	@Column(name="employee_born",length=20,nullable=false)
	private String employeeBorn;
	
	@Column(name="employee_marriage",length=10,nullable=false)
	private String  employeeMarriage;
	
	@Column(name="employee_phone",length=20,nullable=false)
	private Integer employeePhone;
	
	@Column(name="employee_address",length=20,nullable=false)
	private String  employeeAddress;
	
	@Column(name="employee_starttime",length=20,nullable=false)
	private String employeeStarttime;
	
	@Column(name="employee_bz",length=100)
	private String  employeeBz;
	
	@Column(name="employee_pwd",length=10,nullable=false)
	private Integer employeePwd;
	
	@Column(name="employee_post",length=20)
	private String employeePost;
	
	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name="department_id",referencedColumnName="department_id")
	private Department departments=new Department();
	
	@OneToOne(mappedBy="empl",cascade = CascadeType.REMOVE) 
	private Pay pa;
	
/*	@OneToMany(targetEntity=Leaving.class,mappedBy="employees",fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Set<Leaving> leavings = new HashSet<Leaving>(0);*/

	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	
	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeeBorn() {
		return employeeBorn;
	}

	public void setEmployeeBorn(String employeeBorn) {
		this.employeeBorn = employeeBorn;
	}

	public String getEmployeeMarriage() {
		return employeeMarriage;
	}

	public void setEmployeeMarriage(String employeeMarriage) {
		this.employeeMarriage = employeeMarriage;
	}

	public Integer getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(Integer employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	

	public String getEmployeeStarttime() {
		return employeeStarttime;
	}

	public void setEmployeeStarttime(String employeeStarttime) {
		this.employeeStarttime = employeeStarttime;
	}

	public String getEmployeeBz() {
		return employeeBz;
	}

	public void setEmployeeBz(String employeeBz) {
		this.employeeBz = employeeBz;
	}
	
	

	public Integer getEmployeePwd() {
		return employeePwd;
	}

	public void setEmployeePwd(Integer employeePwd) {
		this.employeePwd = employeePwd;
	}
	
	

	public String getEmployeePost() {
		return employeePost;
	}

	public void setEmployeePost(String employeePost) {
		this.employeePost = employeePost;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	public Pay getPa() {
		return pa;
	}

	public void setPa(Pay pa) {
		this.pa = pa;
	}

	/*public Set<Leaving> getLeavings() {
		return leavings;
	}

	public void setLeavings(Set<Leaving> leavings) {
		this.leavings = leavings;
	}*/

	
	
	

}
