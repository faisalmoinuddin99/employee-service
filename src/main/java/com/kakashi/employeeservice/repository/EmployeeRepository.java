package com.kakashi.employeeservice.repository;

import com.kakashi.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.restaurantId = :restaurantId")
    List<Employee> findEmployeeByRestaurantId(@Param("restaurantId") String restaurantId) ;

}
