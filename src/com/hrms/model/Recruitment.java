package com.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_recruitment")
public class Recruitment implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recruitment_id",length=10,nullable=false)
	private Integer recruitmentId;
	@Column(name="recruitment_title",length=10,nullable=false)
	private String recruitmentTitle;
	@Column(name="recruitment_image",length=300)
	private String recruitmentImage;
	@Column(name="recruitment_content",nullable=false)
	private String recruitmentContent;
	@Column(name="recruitment_date",length=20,nullable=false)
	private String recruitmentDate;
	public Integer getRecruitmentId() {
		return recruitmentId;
	}
	public void setRecruitmentId(Integer recruitmentId) {
		this.recruitmentId = recruitmentId;
	}
	public String getRecruitmentTitle() {
		return recruitmentTitle;
	}
	public void setRecruitmentTitle(String recruitmentTitle) {
		this.recruitmentTitle = recruitmentTitle;
	}
	
	
	
	public String getRecruitmentImage() {
		return recruitmentImage;
	}
	public void setRecruitmentImage(String recruitmentImage) {
		this.recruitmentImage = recruitmentImage;
	}
	public String getRecruitmentContent() {
		return recruitmentContent;
	}
	public void setRecruitmentContent(String recruitmentContent) {
		this.recruitmentContent = recruitmentContent;
	}
	public String getRecruitmentDate() {
		return recruitmentDate;
	}
	public void setRecruitmentDate(String recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
	}
	
	
	
}
