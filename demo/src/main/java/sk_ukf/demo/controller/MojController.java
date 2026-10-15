package sk_ukf.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sk_ukf.demo.entity.Employee;
import sk_ukf.demo.entity.Student;
import sk_ukf.demo.service.EmployeeService;
import sk_ukf.demo.service.StudentService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
        }
        return student;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
        }
        return employee;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.save(student);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student existingStudent = studentService.findById(id);
        if (existingStudent == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
        }
        student.setId(id);
        return studentService.save(student);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
        }
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/students/{id}")
    public Map<String, String> deleteStudent(@PathVariable Integer id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
        }
        studentService.deleteById(id);
        return Map.of("message", "Deleted student id - " + id);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, String> deleteEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
        }
        employeeService.deleteById(id);
        return Map.of("message", "Deleted employee id - " + id);
    }

    @GetMapping("/students/search")
    public List<Student> searchStudents(@RequestParam String firstName, @RequestParam String lastName) {
        return studentService.findByFirstNameAndLastName(firstName, lastName);
    }
}