package sk_ukf.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sk_ukf.demo.entity.Employee;
import sk_ukf.demo.entity.Student;
import sk_ukf.demo.response.ResponseWrapper;
import sk_ukf.demo.service.EmployeeService;
import sk_ukf.demo.service.StudentService;
import sk_ukf.demo.response.ResponseFactory;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MojController {
    private final StudentService studentService;
    private final EmployeeService employeeService;
    private final ResponseFactory response;

    public MojController(StudentService studentService, EmployeeService employeeService, ResponseFactory response) {
        this.studentService = studentService;
        this.employeeService = employeeService;
        this.response = response;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper<List<Student>>> getAllStudents() {
        return response.ok("Úspešne načítané", studentService.findAll());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ResponseWrapper<Student>> getStudentById(@PathVariable Integer id) {
        return response.ok("Študent úspešne nájdený", studentService.findById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<ResponseWrapper<Student>> createStudent(@Valid @RequestBody Student student) {
        student.setId(null);
        return response.success(HttpStatus.CREATED, "Študent bol úspešne vytvorený", studentService.save(student));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<ResponseWrapper<Student>> updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.findById(id);
        student.setId(id);
        return response.ok("Študent úspešne aktualizovaný", studentService.save(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);
        return response.success(HttpStatus.OK, "Deleted student id - " + id, null);
    }

    @GetMapping("/students/search")
    public ResponseEntity<ResponseWrapper<List<Student>>> searchStudents(@RequestParam String firstName, @RequestParam String lastName) {
        return response.success(HttpStatus.OK, "Students found successfully", studentService.findByFirstNameAndLastName(firstName, lastName));
    }


    @GetMapping("/employees")
    public ResponseEntity<ResponseWrapper<List<Employee>>> getAllEmployees() {
        return response.ok("Zamestnanci úspešne načítaní", employeeService.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> getEmployeeById(@PathVariable Integer id) {
        return response.ok("Zamestnanec úspešne nájdený", employeeService.findById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(null);
        return response.success(HttpStatus.CREATED, "Zamestnanec bol úspešne vytvorený", employeeService.save(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee) {
        employeeService.findById(id);
        employee.setId(id);
        return response.ok("Zamestnanec úspešne aktualizovaný", employeeService.save(employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return response.success(HttpStatus.OK, "Deleted employee id - " + id, null);
    }
}