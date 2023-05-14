package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="tbl_user")
@Entity
@Setter
@Getter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long 		id;
	private String 		ssn;
	private String 		firstName;
	private String 		middleName;
	private String 		familyName;
	private Date   		birthDate;
	@CreationTimestamp
	@Column(name="created_datetime")
	private Timestamp 	createdDtm;
	@UpdateTimestamp
	@Column(name="updated_datetime")
	private Timestamp 	updateDtm;
	private String 		createdBy;
	private String 		updateBy;
	private Boolean 	isActive;
	@UpdateTimestamp
	@Column(name="deleted_datetime")
	private Timestamp 	deletedDtm;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
