package com.lti.service;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Employee;
import com.lti.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

//create
	public Employee create(String empid, String name, String department, float salary) {
		return employeeRepository.save(new Employee(empid, name, department, salary));

	}

//retrive
	public List<Employee> getAll(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeRepository.findAll();
	}

	public Employee getByEmpid(String empid) {
		return employeeRepository.findByEmpid(empid);
	}

//update
	public Employee update(String empid, String name, String department, float salary) {
		Employee p = employeeRepository.findByEmpid(empid);
		p.setName(name);
		p.setDepartment(department);
		p.setSalary(salary);
		return employeeRepository.save(p);
	}

//Delete
	public void deleteAll() {
		employeeRepository.deleteAll();
	}

	public void delete(String empid) {
		Employee p = employeeRepository.findByEmpid(empid);
		employeeRepository.delete(p);
	}
}
