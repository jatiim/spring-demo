package com.adorsys.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorsys.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
