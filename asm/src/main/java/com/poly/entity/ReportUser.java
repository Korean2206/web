package com.poly.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;


@Entity	
public class ReportUser {
 
	@Id
	String id;
	String fullName;
	String email;
	Date fDate;
	public ReportUser(String id, String fullName, String email, Date fDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.fDate = fDate;
	}
	public String getGroup() {
		return id;
	}
	public void setGroup(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getfDate() {
		return fDate;
	}
	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	
	
}
