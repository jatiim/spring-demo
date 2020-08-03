package com.adorsys.demo.service;

import com.adorsys.demo.exception.CustomException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.demo.entity.Employee;
import com.adorsys.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> getEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repo.findById(id).orElseThrow(() -> new CustomException("Can't find employee " + id));
	}

	@Override
	public Employee createEmployee(Employee newEmployee) {
		return repo.save(newEmployee);
	}

	@Override
	public Employee updateEmployee(Employee newEmployee, Long id) {
		return repo.findById(id).map((oldEmployee) -> {
			oldEmployee.setName(newEmployee.getName());
			oldEmployee.setHobby(newEmployee.getHobby());
			oldEmployee.setCity(newEmployee.getCity());
			return repo.save(oldEmployee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return repo.save(newEmployee);
		});
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}



}
