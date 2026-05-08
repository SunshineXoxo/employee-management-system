package com.javaproject.ems_backend.repository;

import com.javaproject.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
