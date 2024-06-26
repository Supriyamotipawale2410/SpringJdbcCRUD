package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao edao;

	
	//1.Add employee
	public int addNewEmp() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter emp id");
		int id = sc.nextInt();
		System.out.println("Enter emp name");
		String nm = sc.next();
		System.out.println("Enter emp role");
		String rl = sc.next();
		System.out.println("Enter emp salary");
		int sal = sc.nextInt();
		Employee e= new Employee(id,nm,rl,sal);
		return edao.saveEmp(e);
	}

	//2.Display all employee
	@Override
	public List<Employee> displayAllEmp() {
		
		return edao.displayAllEmp();
	}

	//3.Delete employee
	@Override
	public boolean deleteEmp(int id) {
		
		return edao.deleteEmp(id);
	}

	//4.Update employee
	@Override
	public boolean updateEmp(int id, String rl, int sal) {
		
		return edao.updateEmp(id,rl,sal);
	}

	//5.Sort by name
	@Override
	public List<Employee> sortByName() {
		
		return edao.sortByName();
	}

	//6.Sort by salary
	@Override
	public List<Employee> sortBySalary() {
		
		return edao.sortBySal();
	}

	//7.Display by id
	@Override
	public Employee displayById(int id) {
		
		return edao.displayById(id);
	}

	//8.Display by salary
	@Override
	public List<Employee> displayBySal(int sal) {
		
		return edao.displayBySal(sal);
	}

	
	
}
