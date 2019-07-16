package com.sapient.springdemo.service;

import com.sapient.springdemo.model.Employee;
import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public List<Employee> listAll();

    public Employee findById(long id);

    public void deleteEmployee(long id);
    
    public void updateEmployee(long id);

}