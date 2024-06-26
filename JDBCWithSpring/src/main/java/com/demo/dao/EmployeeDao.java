package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	int saveEmp(Employee e);

	List<Employee> displayAllEmp();

	boolean deleteEmp(int id);

	boolean updateEmp(int id, String rl, int sal);

	List<Employee> sortByName();

	List<Employee> sortBySal();

	Employee displayById(int id);

	List<Employee> displayBySal(int sal);

}
