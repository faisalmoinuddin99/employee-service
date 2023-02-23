package com.kakashi.employeeservice.service;

import com.kakashi.employeeservice.model.Employee;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee addEmployee(Employee employee) ;

    public List<Employee> getEmployees() ;
    public Optional<Employee> getEmployeeById(Long id) ;

    public Employee updateEmployee(Employee employee) ;

    public void deleteEmployee(Long id) ;

    public List<Employee> getEmployeesByRestaurantId(String restaurantId) ;
}
