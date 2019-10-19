package com.lnt.hr.daos;

import java.util.List;

import com.lnt.hr.beans.Employees;
import com.lnt.hr.exceptions.EmpException;

public interface EmpDao {
	public List<Employees> getEmpList() throws EmpException;
	public Employees getEmpDetails(int empNo) throws EmpException;
	public Employees insertNewEmployee(Employees emp) throws EmpException;
}
