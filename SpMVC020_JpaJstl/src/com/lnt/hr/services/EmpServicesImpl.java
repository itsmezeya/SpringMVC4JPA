package com.lnt.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.hr.beans.Employees;
import com.lnt.hr.daos.EmpDao;
import com.lnt.hr.exceptions.EmpException;

@Service("empServices")
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class EmpServicesImpl implements EmpServices {

	@Autowired
	private EmpDao dao;
	
	@Override
	public List<Employees> getEmpList() throws EmpException {
		return dao.getEmpList();
	}

	@Override
	public Employees getEmpDetails(int empNo) throws EmpException {
		return dao.getEmpDetails(empNo);
	}

	@Override
	public Employees joinEmployee(Employees emp) throws EmpException {
		// Statement to insert a record in the table.
		// Statement to update a record of the table.
		// Statement to delete a record from the table.
		return dao.insertNewEmployee(emp);
	}
}
