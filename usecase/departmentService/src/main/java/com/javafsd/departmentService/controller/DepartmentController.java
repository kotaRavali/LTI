package com.javafsd.departmentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.departmentService.entity.Department;
import com.javafsd.departmentService.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		Department departmentResponse = departmentService.saveDepartment(department);
		return departmentResponse;
	}

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}

}