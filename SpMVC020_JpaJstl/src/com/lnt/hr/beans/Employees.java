package com.lnt.hr.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="queryOnSalaryRange", query="from Employees where salary >= :from and salary <= :to order by empId"),
	@NamedQuery(name="maxEmpId", query="select max(empId) from Employees"),
	@NamedQuery(name="allEmps", query="from Employees")
})
@Entity
@Table(name="EMPLOYEES")
public class Employees {
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	
	public Employees(int empId, String firstName) {
		super();
		this.empId = empId;
		this.firstName = firstName;
	}

	public Employees() {
		super();
	}

	@Id
	@Column(name="EMPLOYEE_ID")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="HIRE_DATE")
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Column(name="JOB_ID")
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", firstName=" + firstName + "]";
	}
}
