package com.kakashi.employeeservice.controller;

import com.kakashi.employeeservice.model.Employee;
import com.kakashi.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;


    // CRUD operation
    @PostMapping("/employee")
    public ResponseEntity<Employee> postEmployeeDetails(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee)) ;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees()) ;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employee.setEmpId(id);
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Custom Query
    @GetMapping("/emp/restaurant/{restaurantId}")
    public ResponseEntity<List<Employee>> customFetchAllEmployeesByRestaurantId(@PathVariable String restaurantId) {
        return ResponseEntity.ok(employeeService.getEmployeesByRestaurantId(restaurantId)) ;
    }
}
