package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	int addNewEmp();

	List<Employee> displayAllEmp();

	boolean deleteEmp(int id);

	boolean updateEmp(int id, String rl, int sal);

	List<Employee> sortByName();

	List<Employee> sortBySalary();

	Employee displayById(int id);

	List<Employee> displayBySal(int sal);

}
