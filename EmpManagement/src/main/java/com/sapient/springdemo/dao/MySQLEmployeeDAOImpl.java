package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository(value = "mysqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public MySQLEmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
   //    jdbcTemplate.execute("insert into employee(name) values ('"+employee.getName()+"')");

       jdbcTemplate.execute("insert into employee(id , name) values ('"+employee.getId()+"','"+employee.getName()+"')");


        return null;
    }

    public List<Employee> listAll() {
    	System.out.println("You are in List all method");
    	List<Employee> employeeList = jdbcTemplate.query("select * from employee",
    			(rs,rowNum)-> new Employee(rs.getInt( 1),rs.getString(2)));
        return employeeList;
    }

    public Employee findById(long id) {
    	
    	System.out.println("You are in findBy id all method");
    	return jdbcTemplate.queryForObject("select * from employee where id ="+id,
    			(rs,rowNum)-> new Employee(rs.getInt( 1),rs.getString(2)));
    	//return  null;
    	}

    public void deleteEmployee(long id) {
    	System.out.println("You are in delete method");
    	 jdbcTemplate.execute("delete from employee where id= "+id);
    }

	
	public void updateEmployee(long id) {
		// TODO Auto-generated method stub
		String str= "akash";
		System.out.println("Came inside the updateEmployee method of MySQLEmployeeDAOImpl");
        jdbcTemplate.update("update employee set name ="+str+" where id ="+id);
               
		       //jdbcTemplate.execute("update employee"
		    	//	   +"set name= '"+employee.getName()+"'");

	}
   
}