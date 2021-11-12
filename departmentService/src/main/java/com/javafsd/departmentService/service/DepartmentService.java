package com.javafsd.departmentService.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafsd.departmentService.entity.Department;

import com.javafsd.departmentService.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		Department departmentResponse = departmentRepository.save(department);
		
		LOGGER.info("Department saved successfully : " + departmentResponse);

		return departmentResponse;
		}
	
	public Department getDepartmentById(Long departmentId) {
		Department department = departmentRepository.getDepartmentById(departmentId);
		//if(department ==null) {
		//	throw new DepartmentNotFoundException("Department dosent exist for this");
		//}
		return department;
	}
	
	
	
}
