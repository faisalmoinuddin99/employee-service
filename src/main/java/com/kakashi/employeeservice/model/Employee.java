package com.kakashi.employeeservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "emp_tbl")
public class Employee {

    @Id
    private Long empId;
    private String restaurantId ;
    private String empName;
    private String phoneNumber;
    private String jobPosition;
    private Double salary;
    private String nationality;
    private String nativeState;
    private Integer workExp;
    private List<String> hobby = new ArrayList<>();

}
