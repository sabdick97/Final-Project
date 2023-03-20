package com.ems.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ManagerDTO {
	
	private String manName;
	private String manAddress;
	private double salary;
	private String contact;
	private String email;
	private String designation;
	private Date DOJ;
	
	private DepartmentDTO dept;

}
