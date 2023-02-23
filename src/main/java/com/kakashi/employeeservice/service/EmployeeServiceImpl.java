package com.kakashi.employeeservice.service;

import com.kakashi.employeeservice.model.Employee;
import com.kakashi.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Long generateRandomUniqueId(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    @Override
    public Employee addEmployee(Employee employeeRequest) {
        Long randomEmpID = generateRandomUniqueId(1L, 1000L);
        employeeRequest.setEmpId(randomEmpID);
        Employee employee = Employee.builder()
                .empId(employeeRequest.getEmpId())
                .empName(employeeRequest.getEmpName())
                .hobby(employeeRequest.getHobby())
                .jobPosition(employeeRequest.getJobPosition())
                .nationality(employeeRequest.getNationality())
                .restaurantId(employeeRequest.getRestaurantId())
                .nativeState(employeeRequest.getNativeState())
                .phoneNumber(employeeRequest.getPhoneNumber())
                .salary(employeeRequest.getSalary())
                .workExp(employeeRequest.getWorkExp())
                .build();

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByRestaurantId(String restaurantId) {
        return employeeRepository.findEmployeeByRestaurantId(restaurantId);
    }
}
