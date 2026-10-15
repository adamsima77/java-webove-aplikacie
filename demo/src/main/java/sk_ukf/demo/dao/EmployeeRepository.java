package sk_ukf.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk_ukf.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}