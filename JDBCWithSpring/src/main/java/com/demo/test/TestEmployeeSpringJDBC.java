package com.demo.test;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;

public class TestEmployeeSpringJDBC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		EmployeeService eservice = (EmployeeService) ctx.getBean("employeeServiceImpl");
		int choice=0;
		
		do {
			System.out.println("1.Add employee\n2.Display all employee\n3.Delete employee\n4.Update employee\n5.Sort by name");
			System.out.println("6.Sort by salary\n7.Display by id\n8.Display by salary\n9.Exit\nEnter Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			
			//1.Add employee
			case 1:
				int result=eservice.addNewEmp();
				if(result!=0) {
					System.out.println("Employee details added");
				}else
				{
					System.out.println("Not added\nTry again........................");
				}
				break;
				
				
				//2.Display all employee
			case 2:
				List<Employee> elist = eservice.displayAllEmp();
				elist.forEach(System.out::println);
				break;
				
				
				//3.Delete employee
			case 3:
				System.out.println("Enter emp id to delete");
				int id=sc.nextInt();
				boolean res =eservice.deleteEmp(id);
				if(res) 
					System.out.println("Employee details deleted");
				else
					System.out.println("Not deleted\nTry again........................");
				break;
				
				//4.Update employee
			case 4:
				System.out.println("Enter emp id to update");
				id=sc.nextInt();
				System.out.println("Emter updated emp role");
				String rl =sc.next();
				System.out.println("Enter emp salary to update");
				int sal=sc.nextInt();
				res =eservice.updateEmp(id,rl,sal);
				if(res) 
					System.out.println("Employee details updated");
				else
					System.out.println("Not updated\nTry again........................");
				break;
				
				//5.Sort by name
			case 5:
				elist = eservice.sortByName();
				elist.forEach(System.out::println);
				break;
				
				
				//6.Sort by salary
			case 6:
				elist = eservice.sortBySalary();
				elist.forEach(System.out::println);
				break;
				
				//7.Display by id
			case 7:
				System.out.println("Enter id to display emp details");
				id=sc.nextInt();
				Employee e = eservice.displayById(id);
				if(e!=null)
					System.out.println(e);
				else
					System.out.println("Not found");
				break;
				
				
				//8.Display by salary
			case 8:
				System.out.println("Enter salary to display emp details");
				sal=sc.nextInt();
				elist=eservice.displayBySal(sal);
				elist.forEach(System.out::println);
				break;
				
				//9.Exit
			case 9:
				sc.close();
				((ClassPathXmlApplicationContext)ctx).close();
				System.out.println("Thank you for visiting");
				break;
				
				//default case
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
		while(choice!=9);

	}

}
