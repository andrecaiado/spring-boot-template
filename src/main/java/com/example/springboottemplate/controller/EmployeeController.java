package com.example.springboottemplate.controller;

import com.example.springboottemplate.dto.CreateEmployeeDto;
import com.example.springboottemplate.dto.EmployeeDto;
import com.example.springboottemplate.entity.Employee;
import com.example.springboottemplate.service.EmployeeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok().body(employeeService.getAllEmployees(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody CreateEmployeeDto employee) {
        return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id, @RequestBody CreateEmployeeDto employee) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Deleted employee successfully");
    }

}
