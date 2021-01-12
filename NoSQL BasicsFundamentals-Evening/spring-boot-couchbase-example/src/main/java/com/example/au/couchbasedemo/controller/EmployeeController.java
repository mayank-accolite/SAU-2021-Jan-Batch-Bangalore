package com.example.au.couchbasedemo.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository EmployeeRepository;
    
    
    @PostMapping("/Employee")
    public Employee addEmployeePost(@RequestBody Employee newEmployee) {
        return EmployeeRepository.save(newEmployee);
    }
    
    @GetMapping("/Employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String empId) {
        if (EmployeeRepository.existsById(empId)) {
            return EmployeeRepository.findById(empId);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/Employee/location/{location}")
    public List<Employee> getEmployeeBylocationName(@PathVariable String location) {
        return EmployeeRepository.findByLocation(location);
    }
    
    @GetMapping("/Employee/pincode/{pincode}")
    public List<Employee> getEmployeeByPincode(@PathVariable Integer pincode) {
        return EmployeeRepository.findByPincode(pincode);
    }
    
    
    @DeleteMapping("/Employee/{id}")
    public void deleteById(@PathVariable String empId) {
        EmployeeRepository.deleteById(empId);
    }
    
}