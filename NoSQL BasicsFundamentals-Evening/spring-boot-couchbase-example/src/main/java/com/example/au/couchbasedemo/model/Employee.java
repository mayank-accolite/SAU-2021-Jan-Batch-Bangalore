package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Employee {
	
	@Id
	private String empId;
	
	@NotNull
    @Field
	private String empName;
	
	@NotNull
    @Field
	private String location;
	
	@NotNull
    @Field
	private Integer pincode; 
	
	public Employee(String empId, String empName, String location, Integer pincode) {
		this.empId = empId;
		this.empName = empName;
		this.location = location;
		this.pincode= pincode;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
		this.location = location;
	}
	
	public Integer getPincode() {
		return pincode;
	}
	
	public void setPincode(Integer pincode) {
		this.pincode=pincode;
	}
	
	
	
	

}
