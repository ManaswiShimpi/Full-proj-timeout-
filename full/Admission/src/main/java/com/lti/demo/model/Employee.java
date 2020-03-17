package com.lti.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Employee {

	
	@Id
	String Empid;
	public String getEmpid() {
		return Empid;
	}
	public void setEmpid(String empid) {
		Empid = empid;
	}
	
	@Override
	public String toString() {
		return "Employee [Empid=" + Empid + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", getEmpid()=" + getEmpid() + ", getName()=" + getName() + ", getDepartment()=" + getDepartment()
				+ ", getSalary()=" + getSalary() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Employee( String name, String department, float salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	String name;
	String department;
	float salary;
	
}
