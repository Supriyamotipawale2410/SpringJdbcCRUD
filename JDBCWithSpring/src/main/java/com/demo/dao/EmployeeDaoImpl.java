package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//1.Add employee
	public int saveEmp(Employee e) {
		int n = jdbcTemplate.update("insert into employee values(?,?,?,?)", new Object[] {e.getId(),e.getName(),e.getRole(),e.getSalary()}); 
		return n;
	}

	//2.Display all employee
	@Override
	public List<Employee> displayAllEmp() {
		RowMapper rm =(rs,num)->{
			Employee e = new Employee();	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getInt(4));
					
				return e;		
		};
		List<Employee> elist = jdbcTemplate.query("select * from employee", rm);
		
		return elist;
	}

	//3.Delete employee
	@Override
	public boolean deleteEmp(int id) {
		int n =jdbcTemplate.update("delete from employee where id=?" , new Object[] {id});
		if(n>0)
			return true;
		else
		return false;
	}

	//4.Update employee
	@Override
	public boolean updateEmp(int id, String rl, int sal) {
		int n =jdbcTemplate.update("update employee set role=?,salary=? where id=?" , new Object[] {rl,sal,id});
		if(n>0)
			return true;
		else
		return false;
	}

	//5.Sort by name
	@Override
	public List<Employee> sortByName() {
		RowMapper rm =(rs,num)->{
			Employee e = new Employee();	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getInt(4));
					
				return e;		
		};
		List<Employee> elist = jdbcTemplate.query("select * from employee order by name", rm);
		
		return elist;
	}

	//6.Sort by salary
	@Override
	public List<Employee> sortBySal() {
		RowMapper rm =(rs,num)->{
			Employee e = new Employee();	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getInt(4));
					
				return e;		
		};
		List<Employee> elist = jdbcTemplate.query("select * from employee order by salary", rm);
		
		return elist;
	}

	//7.Display by id
	@Override
	public Employee displayById(int id) {
		Employee e = jdbcTemplate.queryForObject("select * from employee where id=?", new Object[] {id}, BeanPropertyRowMapper.newInstance(Employee.class));
		return e;
	}

	//8.Display by salary
	@Override
	public List<Employee> displayBySal(int sal) {
		RowMapper rm =(rs,num)->{
			Employee e = new Employee();	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getInt(4));
					
				return e;		
		};
		List<Employee> elist = jdbcTemplate.query("select * from employee where salary > ?",new Object[] {sal}, rm);
		
		return elist;
	}
	
	
}
