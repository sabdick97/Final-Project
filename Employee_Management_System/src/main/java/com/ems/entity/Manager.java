package com.ems.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name= "Manager")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager extends User{
	
	@Column(length=30, nullable=false)
	private String manName;
	@Column(length=30, nullable= false)
	private String manAddress;
	@Column(length=20,nullable=false)
	private double salary;
	@Column(length=10, nullable=false)
	private String contact;
	@Column(length=50, nullable=false,unique=true)
	private String email;
	@Column(length=30, nullable=false)
	private String destination;
	@Column(nullable=false)
	private LocalDate DOJ;
	
	
	@OneToMany
	private List<Employee> employees;

}
