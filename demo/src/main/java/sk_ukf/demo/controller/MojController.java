package sk_ukf.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk_ukf.demo.entity.Employee;
import sk_ukf.demo.entity.Student;
import sk_ukf.demo.service.EmployeeService;
import sk_ukf.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MojController {
    private final StudentService studentService;
    private final EmployeeService employeeService;
    @Autowired
    public MojController(StudentService studentService, EmployeeService employeeService) {
        this.studentService = studentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
}