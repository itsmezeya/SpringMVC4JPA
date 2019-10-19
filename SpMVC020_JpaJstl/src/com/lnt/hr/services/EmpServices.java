package com.lnt.hr.services;

import java.util.List;

import com.lnt.hr.beans.Employees;
import com.lnt.hr.exceptions.EmpException;

public interface EmpServices {
	public List<Employees> getEmpList() throws EmpException;
	public Employees getEmpDetails(int empNo) throws EmpException;
	public Employees joinEmployee(Employees emp) throws EmpException;
}
