package com.crm.controller;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController{
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // http://localhost:8080/api/v1/employee/add

    @PostMapping("/add")
    public String addEmployee(
            @RequestBody Employee employee

    ){
        employeeService.addEmployee(employee);

        return  "saved" ;
    }

    //http://localhost:8080/api/v1/employee?id=1
    @DeleteMapping
    public String deleteEmployee(
        @RequestParam Long id

 ){
        employeeService.deleteEmployee(id);
        return "deleted";
    }

    //http://localhost:8080/api/v1/employee?id=1
    @PutMapping 
    public String UpdateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto

    ){
        employeeService.UpdateEmployee(id,dto);
        return "updated";
    }

}
