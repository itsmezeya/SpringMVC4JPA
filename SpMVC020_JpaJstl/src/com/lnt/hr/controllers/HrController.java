package com.lnt.hr.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lnt.hr.beans.Employees;
import com.lnt.hr.exceptions.EmpException;
import com.lnt.hr.services.EmpServices;

/*
 * Controller
 * 		1. To interact with the service layer to get processed data.
 * 		2. After receipt of the data from Service Layer, apply transformation
 * 		3. Create a data model
 * 		4. Suggest name of JSP.
 * 
 * Abstract Controller
 * Simple Form Controller
 * MultiAction Controller
 * 
 * View Resolvers
 * 	InternalResourceViewResolver(Default): Basic view resolver which can identify jsps in a specific
 * 			folder and with a specific format of the name.
 *  XMLViewResolver: If views are categorized in different folders and with different formats of name.
 *  ResourceBundleViewResolver: For internationalization.
 *  JSTlViewResolver
 *  
 *  Handler Mappings
 *  	BeanNameUrlHandlerMapping:  Default.
 *  	ControllerClassNameHandlerMapping: Picks up the class name as URL for a method in class.
 *  	SimpleUrlHandlerMapping: A map is to be configured to create url for each controller class.
 * 
 * http://localhost:8085/SpMVC020_JpaJstl/home.hr
 *
 */
@Controller
public class HrController {
	
	@Resource
	private EmpServices services;
	
	@RequestMapping("/home.hr")
	public String getHomePage() {
		return "Home";
	}
	
	/*@RequestMapping("/empList.hr")
	public String getEmpList(HttpServletRequest request) {
		List<Employees> empList = null;
		try {
			empList = services.getEmpList();
			//System.out.println(empList);
			
			// Pass-on this data to JSP
			request.setAttribute("list", empList);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return "EmpList";
	} */
	
	@RequestMapping("/empList.hr")
	public ModelAndView getEmpList(){
		List<Employees> empList = null;
		ModelAndView mAndV = null;
		try {
			empList = services.getEmpList();
			System.out.println(empList);
			mAndV = new ModelAndView();
			// Pass-on this data to JSP
			mAndV.setViewName("EmpList");
			mAndV.addObject("list", empList);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return mAndV;
	} 
	
	@RequestMapping("/empDetails.hr")
	public ModelAndView getEmpDetails(@RequestParam("id") int empNo) {
		ModelAndView mAndV = new ModelAndView("EmpDetails");
		Employees emp = null;
		try {
			emp = services.getEmpDetails(empNo);
			System.out.println(emp);
			
			// Pass-on this data to JSP
			mAndV.addObject("emp",emp);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return mAndV;
	} 
	
	@RequestMapping("/registrationPage.hr")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}
	
	@RequestMapping("/registration.hr")
	public String registerEmp(HttpServletRequest req) {
		String strEmpId = req.getParameter("empId");
		Employees emp = new Employees();
		emp.setEmpId(Integer.parseInt(strEmpId));
		
		try {
			services.joinEmployee(emp);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return "SuccInsert";
	}
}
