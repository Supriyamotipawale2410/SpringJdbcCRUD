package com.demo.beans;

public class Employee {

	private int id;
	private String name;
	private String role;
	private int salary;
	public Employee() {	//default constr
		super();
	}
	public Employee(int id, String name, String role, int salary) { 	//Parameterized constr
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
	}
	
	
}
