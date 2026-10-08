package sk_ukf.demo.dao;

import sk_ukf.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
