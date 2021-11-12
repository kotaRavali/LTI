package com.javafsd.departmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafsd.departmentService.entity.Department;

@Repository
public interface  DepartmentRepository extends JpaRepository< Department, Long> {

	public Department getDepartmentById(Long departmentId);

	
	//Department findDepartmentById(Long departmentId);

	 //Department getDepartmentById(Long departmentId);

	
}
